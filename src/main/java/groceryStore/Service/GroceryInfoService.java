package groceryStore.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groceryStore.Entity.GroceryAmounts;
import groceryStore.Entity.GroceryInfo;
import groceryStore.Entity.GrocerySource;
//import groceryStore.repository.GroceryAmountRepository;
import groceryStore.repository.GroceryInfoRepository;
import groceryStore.repository.GrocerySourceRepository;

@Service
public class GroceryInfoService {

	@Autowired
	private GroceryInfoRepository groceryInfoRepository;

//	 @Autowired
//	    private GroceryAmountRepository groceryAmountRepository;

	@Autowired
	private GrocerySourceRepository grocerySourceRepository;

	@Autowired
	private GrocerySourceService grocerySourceService;

	public List<GroceryInfo> getAllGroceries() {
		GrocerySource grocerySource = new GrocerySource();

		GroceryAmounts groceryAmount = new GroceryAmounts();

		groceryAmount.getTotalCostOfItems();

		grocerySource.getStateName();
		grocerySource.getSource_id();

		List<GroceryInfo> groceries = groceryInfoRepository.findAll();

		return groceries;

	}

	public GroceryInfo addGrocery(GroceryInfo grocery) {
		try {
			grocery.getGroceryAmounts()
					.setTotalCostOfItems(grocery.getCostPerItem() * grocery.getGroceryAmounts().getItemsAvailable());

			// grocery.setGrocerySource(manageGrocerySource(grocery.getGrocerySource()));
			grocery.setGrocerySource(
					grocerySourceRepository.findById(grocery.getGrocerySource().getSource_id()).orElse(null));

			return groceryInfoRepository.save(grocery); // Save all entities at once
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to add grocery", e);
		}

	}

	public GroceryInfo getGroceryById(int Id) {

		GroceryInfo grocery = groceryInfoRepository.findById(Id).orElse(null);

		if (grocery == null) {
			System.out.println("Grocery with ID->" + Id + "(Not Present in the database.....)");
		}

		return grocery;

	}

	public GroceryInfo updateGrocery(int id, GroceryInfo updatedGrocery) {

		GroceryInfo existingGrocery = groceryInfoRepository.findById(id).orElse(null);
		

		if (existingGrocery != null) {
			existingGrocery.setGroceryName(updatedGrocery.getGroceryName());

			existingGrocery.setCostPerItem(updatedGrocery.getCostPerItem());

			// Update item amounts if provided
			if (updatedGrocery.getGroceryAmounts() != null) {
				existingGrocery.getGroceryAmounts()
						.setItemsAvailable(updatedGrocery.getGroceryAmounts().getItemsAvailable());

				Double newTotalCost = updatedGrocery.getCostPerItem()
						* (updatedGrocery.getGroceryAmounts().getItemsAvailable());
				existingGrocery.getGroceryAmounts().setTotalCostOfItems(newTotalCost);
			}

			// Update grocery source if provided and state changed

			if (updatedGrocery.getGrocerySource() != null && existingGrocery.getGrocerySource()
					.getSource_id() != updatedGrocery.getGrocerySource().getSource_id()) {

				int newStateId = updatedGrocery.getGrocerySource().getSource_id();

				// Try to find existing source with new state
				Optional<GrocerySource> existingSourceState = grocerySourceRepository.findById(newStateId);

				if (existingSourceState.isPresent()) {
					existingGrocery.setGrocerySource(existingSourceState.get());

				} else {
					GrocerySource newSource = new GrocerySource();
					newSource.setSource_id(newStateId);
					newSource.setStateName(updatedGrocery.getGrocerySource().getStateName());
					grocerySourceRepository.save(newSource);
					existingGrocery.setGrocerySource(newSource);
				}

			}

			// Save the updated grocery and return it
			return groceryInfoRepository.save(existingGrocery);

		} else {
			// Throw an error if the grocery with the given ID is not found
			throw new RuntimeException("Grocery not found with ID: " + id);

		}

	}

	public Boolean deleteGroceryById(int id) {
		try {
			// Check if the grocery exists before deleting
			Optional<GroceryInfo> groceryToDelete = groceryInfoRepository.findById(id);

			if (groceryToDelete.isPresent()) {

				// Delete the grocery using the repository

				groceryInfoRepository.delete(groceryToDelete.get());
				return true;
			} else {

				// Handle the case where the grocery was not found
				System.out.println("Grocery with ID " + id + " not found"); // Replace with logging

				return false;
			}
		} catch (Exception error) {
			// Handle any errors that may occur during deletion
			System.out.println("Error deleting grocery: " + error.getMessage()); // Replace with logging
			throw new RuntimeException("Failed to delete grocery", error); // Rethrow for further handling
		}

	}

}
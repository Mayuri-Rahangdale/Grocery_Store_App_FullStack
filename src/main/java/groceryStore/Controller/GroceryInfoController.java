package groceryStore.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groceryStore.Entity.GroceryInfo;
//import groceryStore.Service.GroceryAmountsService;
import groceryStore.Service.GroceryInfoService;
//import groceryStore.Service.GrocerySourceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/groceries")
public class GroceryInfoController {
	
	@Autowired
	private GroceryInfoService groceryInfoService;

//	@Autowired
//	private GroceryAmountsService groceryAmountsService;
//
//	@Autowired
//	private GrocerySourceService grocerySourceService;

	
	@GetMapping
	
	public ResponseEntity<List<GroceryInfo>> getAllGrocery() {

		try {
			List<GroceryInfo> groceries = groceryInfoService.getAllGroceries();

			return new ResponseEntity<>(groceries, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace(); // or log the exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<GroceryInfo> addGrocery(@RequestBody GroceryInfo grocery) {
		try {
			// Add the grocery using the service
			GroceryInfo savedGrocery = groceryInfoService.addGrocery(grocery);

			// Return a success response with the added grocery
			return ResponseEntity.ok(savedGrocery); // Use ResponseEntity.ok for 200 status
		} catch (Exception error) {
			// Print the error for now (replace with logging later)
			System.out.println("Error adding grocery: " + error.getMessage());

			// Return an error response
			return ResponseEntity.status(500).build(); // 500 for internal server error
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<GroceryInfo> getGroceryById(@PathVariable int id) {

		try {

			GroceryInfo groceryById = groceryInfoService.getGroceryById(id);

			if (groceryById != null) {
				return ResponseEntity.ok(groceryById); // Return the grocery if found
			} else {
				return ResponseEntity.notFound().build(); // Return 404 if not found
			}

		} catch (Exception error) {
			// Print the error for now (replace with logging later)
			System.out.println("Error while Feteching the data" + error.getMessage());
			// Return 500 for internal server error
			return ResponseEntity.status(500).build();

		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<GroceryInfo> updateMyGrocery(@PathVariable int id, @RequestBody GroceryInfo updatedGrocery) {

		try {

			GroceryInfo savedGrocery = groceryInfoService.updateGrocery(id, updatedGrocery);

			return ResponseEntity.ok(savedGrocery);

		} catch (Exception error) {
			// Print the error for now (replace with logging later)
			System.out.println("Error updating grocery: " + error.getMessage());
			return ResponseEntity.status(500).build(); // Return 500 for internal server error

		}

	}
	

   
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteGrocery(@PathVariable int id){
		try {
			if(groceryInfoService.deleteGroceryById(id)) {
				return ResponseEntity.ok("Succesfully deleted the item with item_id:"+id); //show the response of succesfull dletion
			}else {
				return ResponseEntity.status(404).body("Grocery ID:"+id +" Does not Exist!");
			}
			
			
			
		}catch(Exception error) {
			
			 // Print the error for now (replace with logging later)
			System.out.println("Error while deleting the grocery:"+ error.getMessage());
			
			return ResponseEntity.status(500).build();// Return 500 for internal server error
		}
	}
	
}
































//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import groceryStore.Entity.Grocery;
//import groceryStore.repository.GroceryAmountRepository;
//import groceryStore.repository.GroceryInfoRepository;
//import groceryStore.repository.GroceryRepository;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController  // <-- Corrected annotation for REST API responses
//@Controller
//@RequestMapping("/api/groceries")
//
//public class GroceryController {
//	
//	@Autowired
//    private GroceryRepository groceryRepository;
//    @Autowired
//    private GroceryInfoRepository groceryInfoRepository;
//    @Autowired
//    private GroceryAmountRepository groceryAmountsRepository;
//
//    @GetMapping
//    public List<Grocery> getAllGroceries() {
//        return groceryRepository.findAll();
//    }
//    
//    @GetMapping("/{id}")
//    public ResponseEntity<Grocery> getGroceryById(@PathVariable Long id) {
//        Optional<Grocery> grocery = groceryRepository.findById(id);
//        if (grocery.isPresent()) {
//            return ResponseEntity.ok(grocery.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//     
//    @PostMapping
//    public ResponseEntity<Grocery> createGrocery(@RequestBody Grocery grocery) {
//        grocery.getGroceryAmounts().setTotalCostOfItems(grocery.getGroceryAmounts().calculateTotalCost(
//        		grocery.getGroceryAmounts().getItemsAvailable(),
//                grocery.getGroceryInfo().getCostPerItem()));
//        Grocery savedGrocery = groceryRepository.save(grocery);
//        return ResponseEntity.ok(savedGrocery);
//    }
//
//    
//    @PutMapping("/{id}")
//    public ResponseEntity<Grocery> updateGrocery(@PathVariable Long id, @RequestBody Grocery grocery) {
//        Optional<Grocery> existingGrocery = groceryRepository.findById(id);
//        if (existingGrocery.isPresent()) {
//            // Update relevant fields based on user input
//        	existingGrocery.get().getGroceryAmounts().setTotalCostOfItems(grocery.getGroceryAmounts().calculateTotalCost(
//        			grocery.getGroceryAmounts().getItemsAvailable(),
//                    grocery.getGroceryInfo().getCostPerItem()));
//            existingGrocery.get().setName(grocery.getName());
//            existingGrocery.get().setType(grocery.getType());
//            existingGrocery.get().getGrocerySource().setSourceName(grocery.getGrocerySource().getSourceName());
//            existingGrocery.get().setGroceryAmounts(grocery.getGroceryAmounts()); // Update associated amounts
//            groceryRepository.save(existingGrocery.get());
//            // Save associated entities after saving the parent Grocery
//            groceryInfoRepository.save(existingGrocery.get().getGroceryInfo());
//            groceryAmountsRepository.save(existingGrocery.get().getGroceryAmounts());
//            return ResponseEntity.ok(existingGrocery.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    
//    
//	
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteGrocery(@PathVariable Long id) {
//        groceryRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}


































//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import groceryStore.Entity.GroceryInfo;
////import groceryStore.service.GroceryAmountService;
//import groceryStore.service.GroceryInfoService;
//import jakarta.validation.Valid;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController  // <-- Corrected annotation for REST API responses
//@RequestMapping("/api/groceries")
//public class GroceryController {
//
//    @Autowired
//    private GroceryInfoService groceryService;
//
//    // Adding endpoint mapping and request handling methods
//
//    @PostMapping
//    public ResponseEntity<Void> addGrocery(@Valid @RequestBody GroceryInfo groceryInfo) {
//        groceryService.addGrocery(groceryInfo);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//    
////    @PostMapping("/calculateTotalCost")
////    public ResponseEntity<Double> calculateTotalCost(@RequestParam int quantity, @RequestParam double unitPrice) {
////        double totalCost = groceryAmountService.calculateTotalCost(quantity, unitPrice);
////        return ResponseEntity.ok(totalCost);
////    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> updateGrocery(@PathVariable Long id, @Valid @RequestBody GroceryInfo groceryInfo) {
//        groceryService.updateGrocery(id, groceryInfo);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteGrocery(@PathVariable Long id) {
//        groceryService.deleteGrocery(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // <-- Added response for consistency
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GroceryInfo> getGroceryInfo(@PathVariable Long id) {
//        GroceryInfo groceryInfo = groceryService.getGroceryById(id);
//        return new ResponseEntity<>(groceryInfo, HttpStatus.OK);
//    }
//
//    @GetMapping ("/getAll")
//    public ResponseEntity<List<GroceryInfo>> getAllGroceries() {
//        List<GroceryInfo> groceries = groceryService.getAllGroceries();
//        return new ResponseEntity<>(groceries, HttpStatus.OK);
//        
//      
//    }
//}

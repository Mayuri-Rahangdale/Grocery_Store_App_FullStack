package groceryStore.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groceryStore.Entity.GrocerySource;
import groceryStore.repository.GrocerySourceRepository;

@Service
public class GrocerySourceService {
	
	@Autowired
	GrocerySourceRepository grocerySourceRepository;
	
	
	public List<GrocerySource>  getAllState(){
		
		List<GrocerySource> allStates =  grocerySourceRepository.findAll();
		
		return allStates;
	}
	
	public GrocerySource getStateById (Integer id) {
		return grocerySourceRepository.findById(id).orElse(null);
	}

}



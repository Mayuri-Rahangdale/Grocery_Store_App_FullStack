package groceryStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groceryStore.Entity.GrocerySource;
import groceryStore.Service.GrocerySourceService;

@RestController
@RequestMapping("/api/states")
public class GrocerySourceController {
	
@Autowired
	
	GrocerySourceService grorcerySourceService;
	
	
	
	@GetMapping()
public List<GrocerySource>  getAllStates(){
		
		List<GrocerySource> allStates = grorcerySourceService.getAllState();
		
		return allStates;
	}
	
	@GetMapping("/{id}")
	public GrocerySource stateById(@PathVariable Integer id) {
		return grorcerySourceService.getStateById(id);
		
	}
}



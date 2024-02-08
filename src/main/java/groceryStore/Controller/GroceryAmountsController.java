package groceryStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groceryStore.Entity.GroceryAmounts;
import groceryStore.Service.GroceryAmountsService;

@RestController
@RequestMapping("/api/groceryamounts")
public class GroceryAmountsController {
	
	@Autowired
	GroceryAmountsService groceryAmountsservice;
	
	
	
	@GetMapping
	public List<GroceryAmounts> getAllAmountsDetails(){
		List<GroceryAmounts> getAllAmountDetails =groceryAmountsservice.getAllAmount();
		
		return getAllAmountDetails;
		
	}

}



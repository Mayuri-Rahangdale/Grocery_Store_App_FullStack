package groceryStore.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import groceryStore.Entity.GroceryAmounts;
import groceryStore.repository.GroceryAmountRepository;

@Service
public class GroceryAmountsService {
	
	@Autowired
	GroceryAmountRepository groceryAmountRepository;



public List<GroceryAmounts> getAllAmount(){
	
	List<GroceryAmounts> getAllAmountDetails =groceryAmountRepository.findAll();
	
	return getAllAmountDetails;
	
}

}

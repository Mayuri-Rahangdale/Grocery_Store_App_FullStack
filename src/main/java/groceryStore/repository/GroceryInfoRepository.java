package groceryStore.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import groceryStore.Entity.GroceryInfo;



public interface GroceryInfoRepository extends JpaRepository<GroceryInfo, Integer> {
	
	 //Optional<GroceryInfo> findByGroceryName(String groceryName);
	 
//	 List<GroceryInfo> findByGroceryType(String groceryType);
	 
//	 List<GroceryInfo> findByCostPerItemBetween(BigDecimal minCost, BigDecimal maxCost);

//	 @Query
	 
//	 ("SELECT g FROM GroceryInfo g WHERE g.groceryType = :type")
//	    List<GroceryInfo> findByGroceryType(@Param("type") String type);
	 
//	 @Query
	 
//	 (value = "SELECT * FROM GROCERY_INFO WHERE COST_PER_ITEM > ?1", nativeQuery = true)
//	  List<GroceryInfo> findByCostPerItemGreaterThan(BigDecimal costThreshold);

}






















//public interface GroceryInfoRepository extends JpaRepository<GroceryInfo, Long> {
// 
//List<GroceryInfo> findAll();  // Retrieve all groceries
//
//
//GroceryInfo findByGroceryName(String groceryName);
//
//@Query("SELECT g FROM GroceryInfo g WHERE g.groceryType = :type")
//List<GroceryInfo> findByGroceryType(@Param("type") String type);
//
//
//@Query("SELECT g FROM GroceryInfo g WHERE g.grocerySource = :sourceName") // Corrected query
//List<GroceryInfo> findByGrocerySource(@Param("sourceName") String sourceName);
//
//@Query("SELECT g FROM GroceryInfo g WHERE g.costPerItem < :cost")
//List<GroceryInfo> findByCostPerItem(@Param("cost") double cost);
//
//}

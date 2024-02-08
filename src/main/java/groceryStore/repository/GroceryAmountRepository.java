package groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;


//import org.springframework.stereotype.Repository;

import groceryStore.Entity.GroceryAmounts;

//@Repository

public interface GroceryAmountRepository extends JpaRepository<GroceryAmounts, Integer> {

//	List<GroceryAmount> findByItemsAvailableGreaterThan(int threshold);
//
//	List<GroceryAmount> findByTotalCostOfItemsLessThan(BigDecimal maxTotalCost);

}


































//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import groceryStore.Entity.GroceryAmount;
//
//
//@Repository
//public interface GroceryAmountRepository extends JpaRepository<GroceryAmount, Long> {
//
//	@Query("SELECT ga FROM GroceryAmount ga WHERE ga.grocery.id = :groceryId")
//	List<GroceryAmount> findByGroceryId(@Param("groceryId") Long groceryId);
//
//
//}

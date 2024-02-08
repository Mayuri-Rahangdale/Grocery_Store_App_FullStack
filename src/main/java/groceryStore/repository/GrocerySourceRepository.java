package groceryStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;


//import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import groceryStore.Entity.GrocerySource;

//@Repository

public interface GrocerySourceRepository extends JpaRepository<GrocerySource, Integer> {

	@Query("SELECT gs FROM GrocerySource gs WHERE gs.stateName = :stateName")
	GrocerySource findByName(@Param("stateName") String stateName);
	
	//Optional<GrocerySource> findByStateName(String stateName);
	
	//List<GrocerySource> findByStateNameStartingWith(String prefix);

}
































//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import groceryStore.Entity.GrocerySource;
//
//@Repository
//
//public  interface GrocerySourceRepository extends JpaRepository<GrocerySource, Long> {
//	
//	GrocerySource findBySourceName(String sourceName);
//	
//}
//
//

package groceryStore.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.Data;

@Entity
@Table(name = "GROCERY_SOURCE")
public class GrocerySource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SOURCE_ID")
	private Integer source_id;

	@Column(name="STATE_NAME")
	private String stateName;


	public String getStateName() {
		return stateName;
	}

	public Integer getSource_id() {
		return source_id;
	}

	public void setSource_id(Integer source_id) {
		this.source_id = source_id;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "GrocerySource [source_id=" + source_id + ", stateName=" + stateName + "]";
	}	

}


































//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class GrocerySource {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String sourceName;
//
//    
//    public GrocerySource() {
//        // Optionally initialize fields here
//    }
//    
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getSourceName() {
//		return sourceName;
//	}
//
//	public void setSourceName(String sourceName) {
//		this.sourceName = sourceName;
//	}
//
//	public GrocerySource(Long id, String sourceName) {
//		super();
//		this.id = id;
//		this.sourceName = sourceName;
//	}
//	
//	@Override
//    public String toString() {
//        return "GrocerySource{" +
//                "id=" + id +
//                ", sourceName='" + sourceName + '\'' +
//                '}';
//    }
//	
//}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
////import java.util.List;
////
////import jakarta.persistence.Column;
////import jakarta.persistence.Entity;
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
////import jakarta.persistence.Id;
////import jakarta.persistence.OneToMany;
////import jakarta.persistence.Table;
////
////@Entity
////@Table(name = "GROCERY_SOURCE")
////
////public class GrocerySource {
////	
////	@Id
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
////	private Long id;
////	
////	@Column(name = "STATE_NAME")
////	private String stateName;
////	
////	@OneToMany(mappedBy = "grocerySource") // Assumes a many-to-one relationship
////    private List<GroceryInfo> groceryInfos;
////
////	 public GrocerySource() {
////	    }
////
////	    public GrocerySource(Long Id, String stateName) {
////	        this.id = Id;
////	        this.stateName = stateName;
////	    }
////	
////	public Long getId() {
////		return id;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
////	}
////
////	public String getStateName() {
////		return stateName;
////	}
////
////	public void setStateName(String stateName) {
////		this.stateName = stateName;
////	}
//	
////	 public List<GroceryInfo> getGroceryInfos() {
////	        return groceryInfos;
////	    }
////
////	    public void setGroceryInfos(List<GroceryInfo> groceryInfos) {
////	        this.groceryInfos = groceryInfos;
////	    }
//
////	public GrocerySource(Long id, String stateName) {
////		super();
////		this.id = id;
////		this.stateName = stateName;
////	}
////	
//

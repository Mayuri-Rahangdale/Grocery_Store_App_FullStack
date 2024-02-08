package groceryStore.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GROCERY_INFO")
public class GroceryInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private Integer item_id;
	
	
	@Column(name="GROCERY_NAME")
	private String groceryName;
	
	public GrocerySource getGrocerySource() {
		return grocerySource;
	}


	public void setGrocerySource(GrocerySource grocerySource) {
		this.grocerySource = grocerySource;
	}


	@Column(name = "COST_PER_ITEM")
	private Double costPerItem;
	
	
	
	
	public Integer getItem_id() {
		return item_id;
	}


	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}





	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "GROCERY_ID")
	private GroceryAmounts groceryAmounts;

	      @ManyToOne
	    @JoinColumn(name = "SOURCE_ID")
	    private GrocerySource grocerySource;



	public String getGroceryName() {
		return groceryName;
	}


	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}


	public Double getCostPerItem() {
		return costPerItem;
	}


	public void setCostPerItem(Double costPerItem) {
		this.costPerItem = costPerItem;
	}


	public GroceryAmounts getGroceryAmounts() {
		return groceryAmounts;
	}


	public void setGroceryAmounts(GroceryAmounts groceryAmounts) {
		this.groceryAmounts = groceryAmounts;
	}


	@Override
	public String toString() {
		return "GroceryInfo [item_id=" + item_id + ", groceryName=" + groceryName + ", costPerItem=" + costPerItem
				+ ", groceryAmounts=" + groceryAmounts + ", grocerySource=" + grocerySource + "]";
	}
	
}



































//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//
//
//@Entity
//public class GroceryInfo {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private double costPerItem;
//
//    @OneToOne(mappedBy = "groceryInfo")
//    private Grocery grocery;
//    
//    @Column(name = "grocery_type") 
//    private String groceryType;
//
//    
//    public String getGroceryType() {
//		return groceryType;
//	}
//
//	public void setGroceryType(String groceryType) {
//		this.groceryType = groceryType;
//	}
//
//	private String grocerySource;
//
//    
// // Getter and Setter :
//    
//	public GroceryInfo() {
//        // Optionally initialize fields here
//    }
//	
//	public String getGrocerySource() {
//		return grocerySource;
//	}
//
//	public void setGrocerySource(String grocerySource) {
//		this.grocerySource = grocerySource;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public double getCostPerItem() {
//		return costPerItem;
//	}
//
//	public void setCostPerItem(double costPerItem) {
//		this.costPerItem = costPerItem;
//	}
//
//	public Grocery getGrocery() {
//		return grocery;
//	}
//
//	public void setGrocery(Grocery grocery) {
//		this.grocery = grocery;
//	}
//
//	public GroceryInfo(Long id, double costPerItem, Grocery grocery) {
//		super();
//		this.id = id;
//		this.costPerItem = costPerItem;
//		this.grocery = grocery;
//	}	
//	
//	@Override
//    public String toString() {
//        return "GroceryInfo{" +
//                "id=" + id +
//                ", costPerItem=" + costPerItem +
//                ", grocery=" + grocery +
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
//
//
//
//
////
////import jakarta.persistence.Column;
////import jakarta.persistence.Entity;
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
////import jakarta.persistence.Id;
////import jakarta.persistence.JoinColumn;
////import jakarta.persistence.ManyToOne;
////import jakarta.persistence.Table;
////
////@Entity
////@Table(name="GROCERY_INFO")
////public class GroceryInfo {
////
////	@Id
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
////	@Column(name= "id")
////	private Long id;
////	
////	 
////	
////	@Column(name = "GROCERY_TYPE")
////	private String groceryType;
////	
////	
////
////	@Column(name = "GROCERY_NAME")
////	private String groceryName;
////	
////	@ManyToOne
////	@JoinColumn(name="GROCERY_SOURCE_ID")
////	private GrocerySource grocerySource;
////	
//////	@Column(name = "QUANTITY")
//////	private int quantity;
////	
////	@Column(name = "COST_PER_ITEM")
////	private double costPerItem;
////	
//////	@Column(name = "TOTAL_COST")
//////	private double totalCost;
////	
////	 public GroceryInfo() {} // Default constructor
////
////	    public GroceryInfo(Long id, String groceryTypeString, GrocerySource grocerySource, int quantity, double costPerItem,
////	                       double totalCost, String groceryName) {
////	        super();
////	        this.id = id;
////	        this.groceryName = groceryName;
////	        this.groceryType = groceryTypeString;
////	        this.grocerySource = grocerySource;
////	        //this.quantity = quantity;
////	        this.costPerItem = costPerItem;
////	      //  this.totalCost = totalCost;
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
////	public String getGroceryType() {
////		return groceryType;
////	}
////	
////	public String getGroceryName() {
////	    return groceryName;
////	}
////
////
////	public void setGroceryType(String groceryType) {
////		this.groceryType = groceryType;
////	}
////	
////	public void setGroceryName(String groceryName) {
////		this.groceryName = groceryName;
////	}
////
////	public GrocerySource getGrocerySource() {
////		return grocerySource;
////	}
////
////	public void setGrocerySource(GrocerySource grocerySource) {
////		this.grocerySource = grocerySource;
////	}
////
//////	public int getQuantity() {
//////		return quantity;
//////	}
////
//////	public void setQuantity(int quantity) {
//////		this.quantity = quantity;
//////	}
////
////	public double getCostPerItem() {
////		return costPerItem;
////	}
////
////	public void setCostPerItem(double costPerItem) {
////		this.costPerItem = costPerItem;
////	}
////
//////	public double getTotalCost() {
//////		return totalCost;
//////	}
//////
//////	public void setTotalCost(double totalCost) {
//////		this.totalCost = totalCost;
//////	}
////	
////	
////
//////	public GroceryInfo(Long id, String groceryTypeString, GrocerySource grocerySource, int quantity, double costPerItem,
//////			double totalCost) {
//////		super();
//////		this.id = id;
//////		this.groceryType = groceryTypeString;
//////		this.grocerySource = grocerySource;
////////		this.quantity = quantity;
//////       this.costPerItem = costPerItem;
//////	//	this.totalCost = totalCost;
//////		
//////	}
////		
////		//public double calculateTotalCost() {
////	        // business logic to calculate total cost
////	      //  return this.totalCost = quantity * costPerItem;
////		
////	}
////	

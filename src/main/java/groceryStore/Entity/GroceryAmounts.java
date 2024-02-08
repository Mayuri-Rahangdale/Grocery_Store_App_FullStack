package groceryStore.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GROCERY_AMOUNTS")

public class GroceryAmounts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	     @Column(name="GROCERY_ID")
	     private Integer id;
	   

	    @Column(name = "ITEMS_AVAILABLE")
	    private int itemsAvailable;

	    @Column(name = "TOTAL_COST_OF_ITEMS")
	    private Double totalCostOfItems;

//	    @OneToOne
//	    @JoinColumn(name = "GROCERY_ID")
//	    private GroceryInfo groceryInfo;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public int getItemsAvailable() {
			return itemsAvailable;
		}

		public void setItemsAvailable(int itemsAvailable) {
			this.itemsAvailable = itemsAvailable;
		}

		public Double getTotalCostOfItems() {
			return totalCostOfItems;
		}

		public void setTotalCostOfItems(Double totalCostOfItems) {
			this.totalCostOfItems = totalCostOfItems;
		}
		
//
//		public GroceryInfo getGroceryInfo() {
//			return groceryInfo;
//		}
//
//		public void setGroceryInfo(GroceryInfo groceryInfo) {
//			this.groceryInfo = groceryInfo;
//		}

		@Override
		public String toString() {
			return "GroceryAmounts [id=" + id + ", itemsAvailable=" + itemsAvailable + ", totalCostOfItems="
					+ totalCostOfItems +  "]";
		}	

}






























//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//
//@Entity
//public class GroceryAmount {
//	
//	 @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//
//	    private int itemsAvailable;
//	    private double totalCostOfItems;
//
//	    @OneToOne(mappedBy = "groceryAmounts")
//	    private Grocery grocery;
//	    
//	    @OneToOne
//	    private GroceryInfo groceryInfo;
//
//	    
//	    // Getter, Setter and Constructor : 
//	    
//	    public GroceryAmount() {
//	        // Optionally initialize fields here
//	    }
//
//		public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//		public int getItemsAvailable() {
//			return itemsAvailable;
//		}
//
//		public void setItemsAvailable(int itemsAvailable) {
//			this.itemsAvailable = itemsAvailable;
//		}
//
//		public double getTotalCostOfItems() {
//			return totalCostOfItems;
//		}
//
//		public void setTotalCostOfItems(double totalCostOfItems) {
//			this.totalCostOfItems = totalCostOfItems;
//		}
//
//		public Grocery getGrocery() {
//			return grocery;
//		}
//
//		public void setGrocery(Grocery grocery) {
//			this.grocery = grocery;
//		}
//
//		public GroceryAmount(Long id, int itemsAvailable, double totalCostOfItems, Grocery grocery) {
//			super();
//			this.id = id;
//			this.itemsAvailable = itemsAvailable;
//			this.totalCostOfItems = totalCostOfItems;
//			this.grocery = grocery;
//		}
//		
//		public double calculateTotalCost(int itemsAvailable, double costPerItem) {
//		    return itemsAvailable * costPerItem;
//		}
//
//	    
//		public void updateAmounts(int quantity) {
//	        this.itemsAvailable = quantity;
//	        this.totalCostOfItems = quantity * groceryInfo.getCostPerItem();
//	    }
//		
//		 public void updateCostFromInfo() {
//		        this.totalCostOfItems = itemsAvailable * groceryInfo.getCostPerItem();
//		    }
//		
//		 @Override
//		    public String toString() {
//		        return "GroceryAmount{" +
//		                "id=" + id +
//		                ", itemsAvailable=" + itemsAvailable +
//		                ", totalCostOfItems=" + totalCostOfItems +
//		                ", grocery=" + grocery +
//		                '}';
//		    }
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
////import jakarta.persistence.Column;
////import jakarta.persistence.Entity;
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
////import jakarta.persistence.Id;
////import jakarta.persistence.JoinColumn;
////import jakarta.persistence.OneToOne;
////import jakarta.persistence.Table;
////
////
////
////	
////	@Entity
////	@Table(name = "GROCERY_AMOUNT")
////	
////	
////	public class GroceryAmount {
////		
////		@Id
////		@GeneratedValue(strategy = GenerationType.IDENTITY)
////		private Long id;
////		
//////		@Column(name= "GROCERY_AMOUNT-ID")
//////		private int groceryAmountId;
//////		
////		@Column(name = "ITEM_AVAILABLE")
////		private int itemsAvailable;
////		
////		@Column(name = "TOTAL_COST_OD_ITEM")
////		private double totalCostOfItems;
////		
////		@Column(name = "COST_PER_ITEM")
////	    private double costPerItem;
////		
////		private int quantity;
////
////	    @OneToOne
////	    @JoinColumn(name = "grocery_info_id", referencedColumnName = "id")
////	    
////	    public int getQuantity() {
////	        return quantity;
////	    }
////
////	    public void setQuantity(int quantity) {
////	        this.quantity = quantity;
////	    }
////
////	    public GroceryInfo getGroceryInfo() {
////	        return groceryInfo;
////	    }
////
////	    public void setGroceryInfo(GroceryInfo groceryInfo) {
////	        this.groceryInfo = groceryInfo;
////	    }
////	    
////	    
////	    private GroceryInfo groceryInfo;
////
////
////		public Long getId() {
////			return id;
////		}
////
////		public void setId(Long id) {
////			this.id = id;
////		}
////
////		public int getItemsAvailable() {
////			return itemsAvailable;
////		}
////
////		public void setItemsAvailable(int itemsAvailable) {
////			this.itemsAvailable = itemsAvailable;
////		}
////
////		public double getTotalCostOfItems() {
////			return totalCostOfItems;
////		}
////
////		public void setTotalCostOfItems(double totalCostOfItem) {
////			this.totalCostOfItems = totalCostOfItem;
////		}
////		
////		 public double getCostPerItem() { 
////		        return costPerItem;
////		    }
////
////		    public void setCostPerItem(double costPerItem) { 
////		        this.costPerItem = costPerItem;
////		    }
////
////		public GroceryAmount(Long id, int itemsAvailable, int totalCostOfItem) {
////			super();
////			this.id = id;
////			this.itemsAvailable = itemsAvailable;
////			this.totalCostOfItems = totalCostOfItem;
////		
////		}	
////			 // Business logic specific to GroceryAmounts
////		    public void updateTotalCost() {
////		        // Adding business logic here
////		        this.totalCostOfItems = calculateTotalCost();
////		    }
////		    
////		    private int calculateTotalCost() {
////		        // Adding calculation logic here
////		        return (int) (itemsAvailable * costPerItem);
////		    
////		    }
////}
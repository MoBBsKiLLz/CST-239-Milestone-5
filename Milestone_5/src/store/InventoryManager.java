package store;

import java.util.ArrayList;
import product.*;
import storefront.Product;
/**
 * Inventory manager class to manage store inventory
 * @author migg_
 * @param <T> Generic type for inventory manager
 *
 */
public class InventoryManager<T> {
	/**
	 * Inventory as an ArrayList of generic type
	 */
	private ArrayList<T> inventory;
	
	/**
	 * Default constructor that creates an empty ArrayList of type Product for inventory
	 */
	public InventoryManager() {
		this.inventory = new ArrayList<T>();
	}
	
	/**
	 * Constructor with one parameter
	 * @param inventory Inventory parameter as an ArrayList of generic type
	 */
	public InventoryManager(ArrayList<T> inventory) {
		this.inventory = inventory;
	}
	
	/**
     * Returns the Inventory of the store
     * @return Returns the Inventory as an ArrayList of generic type
     */
	public ArrayList<T> getInventory() {
		return this.inventory;
	}
	
    /**
     * Sets the Inventory of a generic type taking a parameter
     * @param inventory Inventory parameter as an ArrayList
     */
	public void setInventory(ArrayList<T> inventory) {
		this.inventory = (inventory);
	}
	
	/**
	 * Adds a generic type to the inventory, if it's in the list already it will increase the quantity.
	 * @param item Item as generic type
	 * @return Returns boolean value if the product was added
	 */
    public boolean addToInventory(T item) {
    	// Check if inventory is empty
		if(inventory.size() > 0) {
			// Loop through inventory
			for(int i = 0; i < inventory.size(); i++) {
				if(item instanceof Product) {
					Product invItem = (Product) inventory.get(i);
					Product nextItem =(Product) item; 
					
					if(invItem.getName().compareTo(nextItem.getName()) == 0) {
						invItem.setQuantity(invItem.getQuantity() + nextItem.getQuantity());
						return true;
					} 
				}
			}
		}
			
		return inventory.add(item);
	}
    
    /**
     * Removes a product from inventory or decreases the quantity
     * @param name Name parameter as a String
     * @param quantity Quantity parameter as an int
     * @return Returns boolean value if the product was removed from the inventory
     */
    public boolean removeFromInventory(String name, int quantity) {
    	if (inventory.size() > 0) {
    		// Loop through inventory
			for(int i = 0; i < inventory.size(); i++) {
			    if (inventory.get(i) instanceof Product) {
			    	Product currentProduct = (Product) inventory.get(i);
				    // Check for product name match
				    if(currentProduct.getName().compareTo(name) == 0) {
				    	// Check quantity
						if(currentProduct.getQuantity() == quantity || currentProduct.getQuantity() < quantity) {
							// Remove the product from the shopping cart
						    inventory.remove(i);
						    System.out.println();
						    System.out.println("Product removed from inventory.");
						    return true;
						}
						else if (currentProduct.getQuantity() > quantity) {
							// Decrease inventory product quantity
						    currentProduct.setQuantity(currentProduct.getQuantity() - quantity);
						    System.out.println();
						    System.out.println("Product removed from inventory.");
						    return true;
						}
				    }
			    }
			}
    	}
    	else {
    		System.out.println();
    		System.out.println("Inventory is empty.");
    		return false;
    	}
    	
    	System.out.println();
    	System.out.println("Product was not found.");
    	return false;
    }
	
	/**
     * Void method that prints the inventory
     */
    public void showInventory() {
    	System.out.println("INVENTORY");
		System.out.println();
		
    	// Loop through inventory
    	this.getInventory().forEach(i -> {
    		if (i instanceof Product) {
    			Product p = (Product) i;
    			// Print product details
			    System.out.println("Product: " + p.getName());
			    System.out.println("Description: " + p.getDescription());
			    System.out.println("Price: " + p.getPrice());
			    System.out.println("Qty: " + p.getQuantity());
			    // Check for instance each subclass
			    if (p instanceof Armor) {
			    	System.out.println("Resistance: " + ((Armor) p).getResistance());
			    }
			    else if (p instanceof Weapon) {
			    	System.out.println("Damage: " + ((Weapon) p).getDamage());
			    }
			    else if (p instanceof Health) {
			    	System.out.println("Amount: " + ((Health) p).getAmount());
			    }
    		}
    		
		    System.out.println();
		});
    	
    }
}

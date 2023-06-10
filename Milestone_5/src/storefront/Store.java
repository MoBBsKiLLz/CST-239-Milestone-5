package storefront;

import java.util.ArrayList;
import store.*;

/**
 * Store class with inventory and shoppingCart instances
 * @author migg_
 *
 * @param <T> Generic type
 */
public class Store<T> {
	/**
	 * Fields include inventory and shoppingCart as generic types
	 */
    InventoryManager<T> inventory;
    ShoppingCart<T> shoppingCart;
    
    
    /**
     * Store default constructor that sets fields as the respective objects
     */
    public Store(){
		shoppingCart = new ShoppingCart<T>();
		inventory = new InventoryManager<T>();
    }
    
    /**
     * Store constructor that takes inventory and shoppingCart parameters
     * @param inventory Inventory parameter of type InventoryManager with generic type
     * @param shoppingCart ShoppingCart parameter of type ShoppingCart with generic type
     */
    public Store(InventoryManager<T> inventory, ShoppingCart<T> shoppingCart) {
    	this.inventory = inventory;
		this.shoppingCart = shoppingCart;
    }
    
    /**
     * Returns the inventory instance
     * @return Returns the inventory as type InventoryManager with generic type
     */
    public InventoryManager<T> getInventory() {
		return inventory;
	}

    /**
     * Sets the inventory taking one parameter
     * @param inventory Inventory parameter as type InventoryManager with generic type
     */
	public void setInventory(InventoryManager<T> inventory) {
		this.inventory = inventory;
	}

	/**
     * Returns the shopping cart instance
     * @return Returns the shopping cart as type ShoppingCart
     */
	public ShoppingCart<T> getShoppingCart() {
		return shoppingCart;
	}

	/**
     * Sets the shopping cart taking one parameter
     * @param shoppingCart Shopping Cart parameter as type ShoppingCart with generic type
     */
	public void setShoppingCart(ShoppingCart<T> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	/**
     * Completes the purchase of an item by removing it from the inventory
     * @return Returns a receipt as an ArrayList of generic type
     */
    public ArrayList<T> purchase() {
		ArrayList<T> receipt = new ArrayList<T>();
		Product currentSC;
		Product currentInv;
		
		ArrayList<T> shoppingCartList = this.shoppingCart.getShoppingCart();
		ArrayList<T> inventoryList = this.inventory.getInventory();
		
		if(shoppingCartList.size() > 0) {
			// Add products in shopping cart to receipt
			shoppingCartList.forEach(cart ->{
				receipt.add(cart);
			});
			
			// Loop through shoppingCart
			for(int s = 0; s < shoppingCartList.size(); s++) {
				if (shoppingCartList.get(s) instanceof Product) {
					currentSC = (Product) shoppingCartList.get(s);
					// Loop through inventory
					for(int i = 0; i < inventoryList.size(); i++) {
						currentInv = (Product) inventoryList.get(i);
						// Check if product name matches
						if(currentSC.getName().compareTo(currentInv.getName()) == 0) {
							// Set the new inventory product quantity based on the quantity being purchased
							currentInv.setQuantity(currentInv.getQuantity() - currentSC.getQuantity());
						}
					}
				}
			}
			
			// Clear the shopping cart
			this.getShoppingCart().emptyShoppingCart();
			
			System.out.println("Purchase successful!");
			
			return receipt;
		}
		else {
			System.out.println("Shopping cart is empty.");
			return null;
		}
	
	}
    
    /**
     * Cancels the purchase of a product taking a parameter
     * @param receipt Receipt parameter as a ArrayList of generic type
     * @return Returns true or false
     */
    public boolean cancel(ArrayList<T> receipt) {
		Product currentRec;
		Product currentInv;
		boolean result = false;
		
		ArrayList<T> inventoryList = this.inventory.getInventory();
		
		// Loop through receipt
		for(int r = 0; r < receipt.size(); r++) {
			if (receipt.get(r) instanceof Product) {
				currentRec = (Product) receipt.get(r);
				// Loop through inventory
				for(int i = 0; i < inventoryList.size(); i++) {
					currentInv = (Product) inventoryList.get(i);
					// Check if product name matches
					if(currentRec.getName().compareTo(currentInv.getName())  == 0) {
						// Set the new inventory product quantity based on the quantity being purchased
						currentInv.setQuantity(currentInv.getQuantity() + currentRec.getQuantity());
						result = true;
					}
				}
			}
		}
		
		return result;
	}
}

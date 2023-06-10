package store;

import java.util.ArrayList;
import product.*;
import storefront.Product;
/**
 * ShoppingCart class to manager store shopping cart
 * @author migg_
 *
 * @param <T> Generic type
 */
public class ShoppingCart<T> {
	/**
	 * ShoppingCart as an ArrayList of generic type
	 */
	private ArrayList<T> shoppingCart;
	
	/**
	 * Default constructor that creates an empty ArrayList of generic type for shopping cart
	 */
	public ShoppingCart() {
		this.shoppingCart = new ArrayList<T>();
	}
	
	/**
	 * Constructor with one parameter
	 * @param shoppingCart Shopping Cart parameter as an ArrayList of generic type
	 */
	public ShoppingCart(ArrayList<T> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	/**
     * Returns the ShoppingCart of a generic type
     * @return Returns the ShoppingCart as an ArrayList of generic type
     */
    public ArrayList<T> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Sets the ShoppingCart of a generic type taking a parameter
     * @param shoppingCart ShoppingCart parameter as a ArrayList of generic type
     */
    public void setShoppingCart(ArrayList<T> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
    /**
     * Adds an item to the ShoppingCart taking three parameters
     * @param name Name parameter as a String
     * @param quantity Quantity parameter as an int
     * @param inventoryManager InventoryManager parameter as a InventoryManager with generic type
     * @return Returns true or false
     */
    @SuppressWarnings("unchecked")
	public boolean addToCart(String name, int quantity, InventoryManager<T> inventoryManager) {
		// Get the inventory list
    	ArrayList<T> inventory = inventoryManager.getInventory();
    	
    	// Loop through inventory
		for(int i = 0; i < inventory.size(); i++) {
			// Check for instance of Product
			if (inventory.get(i) instanceof Product) {
				Product invItem = (Product) inventory.get(i);
				// Compare the name in the argument and the inventory item
				if(invItem.getName().compareTo(name) == 0) {
					// Check the quantity of the item in the inventory
					if(invItem.getQuantity() >= quantity) {
						// Check if the shopping cart is empty
						if(shoppingCart.size() > 0) {
							// Loop through shoppingCart
							for(int s = 0; s < shoppingCart.size(); s++) {
								Product cartItem = (Product) shoppingCart.get(s);
								if(cartItem.getName().compareTo(name) == 0) {
									cartItem.setQuantity(cartItem.getQuantity() + quantity);
									return true;
								} 
							}
							
							// Add a new product if the product wasn't in the shopping cart
							Product newProduct = new Product();
							newProduct.setName(name);
							newProduct.setQuantity(quantity);
							newProduct.setPrice(invItem.getPrice());
							newProduct.setDescription(invItem.getDescription());
							shoppingCart.add((T) newProduct);
							
							return true;
						}
						else {
							// Create a new product if the shopping cart was empty
							Product newProduct = new Product();
							newProduct.setName(name);
							newProduct.setQuantity(quantity);
							newProduct.setPrice(invItem.getPrice());
							newProduct.setDescription(invItem.getDescription());
							shoppingCart.add((T) newProduct);
							return true;
						}
					}
					else {
						System.out.println("The quantity entered exceeds the armor inventory quantity of " + 
							invItem.getQuantity() + ".");
						System.out.println();
					}
				}
			}
		}
		
		return false;
	}
    
    /**
     * Removes a product from the ShoppingCart
     * @param name Name parameter as a String
     * @param quantity Quantity parameter as an int
     * @return Returns true or false
     */
    public boolean removeFromCart(String name, int quantity) {
    	if (shoppingCart.size() > 0) {
    		// Loop through shoppingCart
			for(int s = 0; s < shoppingCart.size(); s++) {
				if (shoppingCart.get(s) instanceof Product) {
					Product currentProduct = (Product) shoppingCart.get(s);
				    // Check for product name match
				    if(currentProduct.getName().compareTo(name) == 0) {
				    	// Check quantity
						if(currentProduct.getQuantity() == quantity || currentProduct.getQuantity() < quantity) {
							// Remove the product from the shopping cart
						    shoppingCart.remove(s);
						    System.out.println();
						    System.out.println("Item removed from shopping cart.");
						    return true;
						}
						else if (currentProduct.getQuantity() > quantity) {
							// Decrease shopping cart product quantity
						    currentProduct.setQuantity(currentProduct.getQuantity() - quantity);
						    System.out.println();
						    System.out.println("Item removed from shopping cart.");
						    return true;
						}
				    }
				}
			}
    	}
    	else {
    		System.out.println();
    		System.out.println("Shopping cart is empty.");
    		return false;
    	}
    	
    	System.out.println();
    	System.out.println("Product was not found.");
    	return false;
    }
    
    /**
     * Void method that prints the shopping cart
     */
    public void showShoppingCart() {
    	System.out.println("SHOPPING CART");
		System.out.println();
		
    	// Loop through inventory
    	this.getShoppingCart().forEach(i -> {
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
    		
		});
    	
    	System.out.println();
    }
    
    /**
     * Void method to empty the shopping cart
     */
    public void emptyShoppingCart() {
    	this.shoppingCart.clear();
    }
}

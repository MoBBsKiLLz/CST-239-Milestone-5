package product;

import storefront.Product;

/**
 * Health subclass of the Product superclass 
 * @author migg_
 *
 */
public class Health extends Product {
	/**
	 * Damage field of type int
	 */
	private int amount;
	
	/**
	 * Default constructor that uses the Product default constructor
	 */
	public Health(){
		super();
		this.amount = 0;
	}
	
	/**
	 * Non-default constructor that takes parameters for name, description, price, quantity and damage
	 * @param name Name parameter of type String
	 * @param description Description parameter of type String
	 * @param price Price parameter of type double
	 * @param quantity Quantity parameter of type int
	 * @param amount Amount parameter of type int
	 */
	public Health(String name, String description, double price, int quantity, int amount) {
		super(name, description, price, quantity);
		this.amount = amount;
	}
	
	/**
     * Returns the amount of the Health
     * @return Returns the amount as an int
     */
	public int getAmount() {
		return amount;
	}

	/**
     * Sets the amount of the Health taking a parameter
     * @param amount Amount parameter as an int
     */
	public void setAmount(int amount) {
		this.amount = amount;
	}
}

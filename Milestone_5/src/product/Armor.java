package product;

import storefront.Product;

/**
 * Armor subclass of the Product superclass
 * @author migg_
 *
 */
public class Armor extends Product {
	/**
	 * Resistance field of type int
	 */
	private int resistance;
	
	/**
	 * Default constructor that uses the Product default constructor
	 */
	public Armor() {
		super();
		this.resistance = 0;
	}
	
	/**
	 * Non-default constructor that takes parameters for name, description, price, quantity and resistance
	 * @param name Name parameter of type String
	 * @param description Description parameter of type String
	 * @param price Price parameter of type double
	 * @param quantity Quantity parameter of type int
	 * @param resistance Resistance parameter of type int
	 */
	public Armor(String name, String description, double price, int quantity, int resistance) {
		super(name, description, price, quantity);
		this.resistance = resistance;
	}

	/**
     * Returns the resistance of the Armor
     * @return Returns the resistance as an int
     */
	public int getResistance() {
		return resistance;
	}

	/**
     * Sets the resistance of the Armor taking a parameter
     * @param resistance Resistance parameter as an int
     */
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
}

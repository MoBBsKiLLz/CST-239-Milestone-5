package product;

import storefront.Product;

/**
 * Weapon subclass of the Product superclass 
 * @author migg_
 *
 */
public class Weapon extends Product {
	/**
	 * Damage field of type int
	 */
	private int damage;
	
	/**
	 * Default constructor that uses the Product default constructor
	 */
	public Weapon(){
		super();
		this.damage = 0;
	}
	
	/**
	 * Non-default constructor that takes parameters for name, description, price, quantity and damage
	 * @param name Name parameter of type String
	 * @param description Description parameter of type String
	 * @param price Price parameter of type double
	 * @param quantity Quantity parameter of type int
	 * @param damage Damage parameter of type int
	 */
	public Weapon(String name, String description, double price, int quantity, int damage) {
		super(name, description, price, quantity);
		this.damage = damage;
	}
	
	/**
     * Returns the damage of the Weapon
     * @return Returns the damage as an int
     */
	public int getDamage() {
		return damage;
	}

	/**
     * Sets the damage of the Weapon taking a parameter
     * @param damage Damage parameter as an int
     */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
}

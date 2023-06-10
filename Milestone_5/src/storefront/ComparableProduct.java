package storefront;
/**
 * ComparableProudct class to compare products and sort by name
 * @author migg_
 *
 */
public class ComparableProduct extends Product implements Comparable<ComparableProduct> {
	/**
	 * Constructor that takes four parameters using respective super Product constructor
	 * @param name Name parameter of type String
	 * @param description Description parameter of type String
	 * @param price Price parameter of type double
	 * @param quantity Quantity parameter of type int
	 */
	public ComparableProduct(String name, String description, double price, int quantity) {
		super(name, description, price, quantity);
	}

	/**
	 * Override of the comparetTo method to compare based on product name
	 */
	@Override
	public int compareTo(ComparableProduct o) {
		return getName().toLowerCase().compareTo(o.getName().toLowerCase());
	}
}

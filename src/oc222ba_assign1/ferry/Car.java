/**
 * 
 */
package oc222ba_assign1.ferry;

/**
 * @author olgachristensen
 *
 */
public class Car extends Vehicle{
	
	public Car (int n) {
		super(n);
		priceV = 100;
		priceP = 15;
		space = 5;
	}

	// max 4 passengers in a car
	public boolean checkPassengers(int n) {
		return (n <= 4);
	}

}

/**
 * 
 */
package oc222ba_assign1.ferry;

/**
 * @author olgachristensen
 *
 */
public class Bus extends Vehicle{
	
	public Bus (int n) {
		super(n);
		priceV = 200;
		priceP = 10;
		space = 20;
	}

	// max 20 passenger on a bus
	public boolean checkPassengers(int n) {
		return (n <= 20);
	}

}

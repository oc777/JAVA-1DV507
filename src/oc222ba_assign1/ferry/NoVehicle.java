/**
 * 
 */
package oc222ba_assign1.ferry;

/**
 * @author olgachristensen
 *
 */
public class NoVehicle extends Vehicle{
	
	public NoVehicle(int n) {
		super(n);
		priceV = 0;
		priceP = 20;
		space = 0;
	}
	
	// max one passenger w/o vehicle per one ticket
	public boolean checkPassengers(int n) {
		return (n == 1);
	}

}

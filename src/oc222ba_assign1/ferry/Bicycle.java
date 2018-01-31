/**
 * 
 */
package oc222ba_assign1.ferry;

/**
 * @author olgachristensen
 *
 */
public class Bicycle extends Vehicle{
	
	public Bicycle (int n) {
		super(n);
		priceV = 40;
		priceP = 0;
		space = 1;
	}

	// max one passenger w bicycle per one ticket
	public boolean checkPassengers(int n) {
		return (n == 1);
	}
	
}

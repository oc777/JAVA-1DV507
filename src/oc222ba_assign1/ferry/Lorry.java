/**
 * 
 */
package oc222ba_assign1.ferry;

/**
 * @author olgachristensen
 *
 */
public class Lorry extends Vehicle{

	public Lorry (int n) {
		super(n);
		priceV = 300;
		priceP = 15;
		space = 40;
	}

	// max 2 passenger on a lorry
	public boolean checkPassengers(int n) {
		return (n <= 2);
	}

}

/**
 * 
 */
package oc222ba_assign1.ferry;

import java.util.ArrayList;

/**
 * @author olgachristensen
 *
 */
public class Vehicle{
	protected String type;							// car, bus ...
	protected int priceV;							// price per vehicle
	protected int priceP;							// price per passenger
	protected int space;							// space V takes in bikes
	protected boolean embarked;						// true if V is embarked
	protected boolean passengersN;					// true if number of passengers doesn't exceed allowed maximum
	protected ArrayList<Passenger> passengers;		// list of V's passengers
	
	public Vehicle(int n) {
		passengersN = false;
		passengers = new ArrayList<Passenger>();
		
		if (checkPassengers(n)) {
			passengersN = true;
			for (int i = 0; i < n; i++) {
				Passenger p = new Passenger();
				passengers.add(p);
			}
			embarked = false;
		}
		
	}
	
	// calculates the total price for vehicle and its passengers
	public int calculateTotalPrice() {
		int total = priceV + priceP*passengers.size();
		return total;
	}
	
	// checks if the number of passengers (int n) doesn't exceed allowed maximum
	public boolean checkPassengers(int n) {
		return true;
	}

}

/**
 * 
 */
package oc222ba_assign1.ferry;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author olgachristensen
 *
 */
public class TheFerry implements Ferry{

	private int space;							// available space for vehicles
	private int usedSpace;						// taken space
	private int room;							// available room for passengers
	private int money;							// earned from ticket sales
	private ArrayList<Vehicle> vehicles;		// list of all on-board vehicles 
	private ArrayList<Passenger> passengers;	// list of all on-board passengers
	
	public TheFerry() {
		space = 200; 							// in bikes equivalent
		usedSpace = 0;							// in bikes equivalent
		room = 200;
		money = 0;
		vehicles = new ArrayList<Vehicle>();
		passengers = new ArrayList<Passenger>();
	}
	
	public int countPassengers() {
		return passengers.size();
	}
	
	public int countVehicleSpace() {
		return usedSpace/5;							// in cars equivalent
	}
	
	public int countMoney() {
		return money;
	}
	
	public Iterator<Vehicle> iterator() {
		return new VehicleIterator();
	}
	
	public void embark(Vehicle v) {
		if (v.passengersN) {								// check if the V has allowed number of passengers
			if (v.embarked == false) {						// check if the V is embarked
				if (hasSpaceFor(v)) {						// check if there's space for the V 
					
					boolean hasRoom = true;					// check if there's room for the V's passengers
					for (Passenger p : v.passengers) {
						if (!hasRoomFor(p)) {
							hasRoom = false;
							break;
						}
					}
					
					if (hasRoom) {
						vehicles.add(v);
						v.embarked = true;
						money += v.calculateTotalPrice();
						space -= v.space;
						usedSpace += v.space;
						
						for (Passenger p : v.passengers) {
							embark(p);
						}
						
						//System.out.println("Embarked");		// test
					}
					
					else
						System.err.println("There is not enough room on the ferry");
												
				}
				
				else
					System.err.println("There is not enough space on the ferry");
					
			}
			else
				System.err.println("The vehicle is already embarked");
		}	
		else
			System.err.println("Too many passengers for one vehicle.");
	}
	
	public void embark(Passenger p) {
		passengers.add(p);
	}
	
	public void disembark() {
		for (Vehicle v : vehicles)
			v.embarked = false;
			
		vehicles.clear();
		passengers.clear();
		space = 200;
		usedSpace = 0;
	}
	
	public boolean hasSpaceFor(Vehicle v) {
		return (space - v.space >= 0);
	}
	
	public boolean hasRoomFor(Passenger p) {
		return (passengers.size() + 1 <= room);			
	}
	
	public String toString() {
		String result = "";
		result += "Passengers on board: " + passengers.size() + "\n";
		result += "Vehicles on board: " + vehicles.size() + "\n";
		result += "Money earned: " + money + " SEK";
		return result;
	}
	
	
	class VehicleIterator implements Iterator<Vehicle>{
		private int count = 0;
		public Vehicle next() {
			return vehicles.get(count++);
		}
		
		public boolean hasNext() {
			return count < vehicles.size();
		}
		
	}

}

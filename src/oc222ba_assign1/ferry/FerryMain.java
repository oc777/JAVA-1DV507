/**
 * 
 */
package oc222ba_assign1.ferry;

import java.util.Iterator;

/**
 * @author olgachristensen
 *
 */
public class FerryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TheFerry f = new TheFerry();
		
		Car car1 = new Car(4);
		Car car2 = new Car(2);
		Car car3 = new Car(1);
		
		Bus bus1 = new Bus(23);
		Bus bus2 = new Bus(18);
		Bus bus3 = new Bus(20);
		Bus bus4 = new Bus(20);
		Bus bus5 = new Bus(20);
		Bus bus6 = new Bus(20);
		
		Lorry lorry1 = new Lorry(2);
		Lorry lorry2 = new Lorry(3);
		
		Bicycle bike1 = new Bicycle(1);
		Bicycle bike2 = new Bicycle(1);
		Bicycle bike3 = new Bicycle(1);
		
		NoVehicle passenger1 = new NoVehicle(1);
		NoVehicle passenger2 = new NoVehicle(1);
		NoVehicle passenger3 = new NoVehicle(1);
		NoVehicle passenger4 = new NoVehicle(1);
		NoVehicle passenger5 = new NoVehicle(1);
		
		f.embark(bike3);
		f.embark(bike3);
		f.embark(bike1);
		f.embark(bike2);
		
		f.embark(car1);
		f.embark(car2);
		f.embark(car3);
		
		Iterator<Vehicle> it = f.iterator();
		while (it.hasNext()){
			Vehicle v = it.next();
			System.out.println("space " + v.space + ", people " + v.passengers.size());
		}
		
		f.embark(bus6);
		f.embark(bus5);
		f.embark(bus4);
		f.embark(bus3);
		f.embark(bus2);
		f.embark(bus1);
		
		f.embark(passenger5);
		f.embark(passenger4);
		
		f.embark(lorry1);
		
		System.out.println(f.toString());
			
		System.out.println("Used space: ca. " + f.countVehicleSpace() + " cars.");


	}

}

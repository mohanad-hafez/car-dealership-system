package carDealership;

import java.time.LocalDate;

public class Dealership {
	private String name;
	private String location;
	private int nv;
	private int ns;
	private Vehicle[] inventory;
	private Sale[] sales;

	public Dealership(String name, String location, int maxInventory) {
		this.name = name;
		this.location = location;
		inventory = new Vehicle[maxInventory];
		sales = new Sale[maxInventory*2];
		nv = 0;
		ns = 0;
	}

	public boolean addVehicle(Vehicle vehicle) {
		if (nv == inventory.length) {
			return false;
		}
		if (vehicle instanceof Car) {
			inventory[nv++] = new Car((Car) vehicle);
		}

		if (vehicle instanceof Motorcycle) {
			inventory[nv++] = new Motorcycle((Motorcycle) vehicle);
		}

		return true;

	}

	public boolean removeVehicle(Vehicle vehicle) {
		if(vehicle == null) {
			return false;
		}
		int index = getIndexFromId(vehicle.id);
		
		// If the vehicle does not exist return false.
		if(index == -1) {
			return false;
		}
		
		// Shift the vehicles in the inventory to the left to remove the gap.
		for(int i = index; i<nv-1; i++) {
			inventory[i] = inventory[i+1];
		}
		
		nv--;
		return true;
	}
	

	public int getIndexFromId(int id) {
		int index = -1;
		for (int i = 0; i < nv; i++) {
			if (inventory[i].id == id) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	// This method is used to sell a vehicle by removing it from inventory and adding a sales record.
	// returns true if the vehicle is successfully sold, false otherwise.
	public boolean sellVehicle(Vehicle vehicle, String buyerName, String buyerContact) {
		 // Check if the vehicle can be removed from inventory
		if(!removeVehicle(vehicle)) {
			return false;
		}
		 // Add a sales record for the sold vehicle
		sales[ns++] = new Sale(vehicle, buyerName, buyerContact, LocalDate.now());
		return true;
	}
	
	//  Calculates the gross value of the inventory by summing up the prices of all vehicles.
	public double getInventoryGrossValue() {
	    double totalValue = 0.0;
	    for (int i = 0; i < nv; i++) {
	        totalValue += inventory[i].price;
	    }
	    return totalValue;
	}
	
	// Returns the total number of cars in the inventory.
	public int getTotalCars() {
		int totalCars = 0;
		for(int i = 0; i<nv; i++) {
			if(inventory[i] instanceof Car) {
				totalCars++;
			}
		}
		return totalCars;
	}
	
	// Returns the total number of motorcycles in the inventory.
	public int getTotalMotorcycles() {
	    int totalMotorcycles = 0;
	    for (int i = 0; i < nv; i++) {
	        if (inventory[i] instanceof Motorcycle) {
	            totalMotorcycles++;
	        }
	    }
	    return totalMotorcycles;
	}
	
	public void displayAll() {
	    System.out.println("Inventory Details:");
	    System.out.println("Total inventory value: " + getInventoryGrossValue());
	    for (int i = 0; i < nv; i++) {
	        System.out.println("-------------------");
	        inventory[i].displayInfo();
	        System.out.println("-------------------");
	    }
	}
	
	public boolean isFull() {
		return nv == inventory.length;
	}
	
	public boolean isEmpty() {
		return nv==0;
	}
	
	public Vehicle getVehicleFromId(int id) {
		Vehicle v = null;
		for(int i = 0; i<nv; i++) {
			if(inventory[i].id == id) {
				v = inventory[i];
			}
		}
		return v;
	}
	
	public void displaySalesHistory() {
	    System.out.println("Sales History:");
	    if (ns == 0) {
	        System.out.println("No sales recorded.");
	        return;
	    }
	    for (int i = 0; i<ns; i++) {
	        System.out.println("-------------------");
	        sales[i].getVehicle().displayInfo();
	        System.out.println("Buyer Name: " + sales[i].getBuyerName());
	        System.out.println("Buyer Contact: " + sales[i].getBuyerContact());
	        System.out.println("Sale Date: " + sales[i].getSaleDate());
	        System.out.println("-------------------");
	    }
	}
	public Car[] searchCar(String s) {  // Search car using type
		Car  types[] = new Car[getTotalCars()];
		int counter = 0;
		
		for(int i=0; i< nv; i++) {
			if(inventory[i] instanceof Car) {
				if(((Car)inventory[i]).getType().equalsIgnoreCase(s)) {
					types[counter++] = (Car)inventory[i];
					}
			}
		}
		if (counter ==0) {
			System.out.println("Sorry didn't find car with type: "+ s);
		}
		return types;
	}
	
	//End
	
	
	
	
	
	
}




















package carDealership;
import java.util.Scanner;
import java.io.*;

public class Main {
	public static Scanner input = new Scanner(System.in);
	public static Dealership dealership;

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		
		// --------------- Load save file if exists, launch new dealership page if it doesn't  ----------------
		File saveFile = new File("save.data");

		
		
		if(saveFile.exists()) {
			FileInputStream inFileStream = new FileInputStream(saveFile);
			ObjectInputStream inObjStream = new ObjectInputStream(inFileStream);
			dealership = (Dealership) inObjStream.readObject(); 
			inObjStream.close();
			Frame myFrame = new Frame();
		}
		else {
			FirstLaunchPage newPage = new FirstLaunchPage();
		}
		
		
		
		

		
		
	/*	
		System.out.println("Welcome to the Dealership System!");
		dealership.getInfo(); // Prints dealership's name,location,inventory size.
		while (true) {
			System.out.println("\nChoose an option:");
			System.out.println("1. Display all vehicles");
			System.out.println("2. Add a vehicle");
			System.out.println("3. Sell a vehicle");
			System.out.println("4. Remove a vehicle");
			System.out.println("5. Edit a vehicle");
			System.out.println("6. Sales history");
			System.out.println("7. Search type");
			System.out.println("8. Find car using budget");
			System.out.println("9. Change text color");
			System.out.println("10. Exit");
			System.out.print("Enter your choice: ");
			String choice = input.nextLine();

			switch (choice) {
			case "1":
				if (dealership.isEmpty()) {
					System.out.println("\nInventory is empty!");
					break;
				}
				dealership.displayAll();
				break;
			case "2":
				if (dealership.isFull()) {
					System.out.println("Inventory is full!");
					break;
				}
				addVehicleMenu();
				break;
			case "3":
				sellVehicleMenu();
				break;
			case "4":
				removeVehicleMenu();
				break;
			case "5":
				editVehicleMenu();
				break;
			case "6":
				dealership.displaySalesHistory();
				break;
			case "9":
				changeColorMenu();
				break;
			case "7":
				searchCarMenu();

				break;
			case "8":
				budgetCarMenu();

				break;
			case "10":
				System.out.println("Exiting the Dealership System. Goodbye!");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
				
				
			}
		}*/
	}

	public static void addVehicleMenu() {
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Add a Vehicle");
		System.out.println("\nChoose an option:");
		System.out.println("1. Car");
		System.out.println("2. Motorcycle");
		System.out.println("3. Exit");

		String choice = input.nextLine();

		switch (choice) {
		case "1":
			addCarMenu();
			break;
		case "2":
			addMotorcycleMenu();
			break;
		case "3":
			return;
		default:
			System.out.println("Invalid choice. Please try again.");
		}
	}

	
	
	
	
	
	public static void addCarMenu() {
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Add a Car");

		System.out.print("\nEnter the make: ");
		String make = input.nextLine();

		System.out.print("Enter the model: ");
		String model = input.nextLine();

		System.out.print("Enter the color: ");
		String color = input.nextLine();

		System.out.print("Enter the year: ");
		int year = input.nextInt();

		System.out.print("Enter the price: ");
		double price = input.nextDouble();

		System.out.print("Enter the type: ");
		input.nextLine();
		String type = input.nextLine();

		if (dealership.addVehicle(new Car(make, model, color, year, price, type))) {
			System.out.println("Car added succesfully.");
		} else {
			System.out.println("Couldn't add car.");
		}
	}

	public static void addMotorcycleMenu() {
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Add a Motorcycle");

		System.out.print("\nEnter the make: ");
		String make = input.nextLine();

		System.out.print("Enter the model: ");
		String model = input.nextLine();

		System.out.print("Enter the color: ");
		String color = input.nextLine();

		System.out.print("Enter the year: ");
		int year = input.nextInt();

		System.out.print("Enter the price: ");
		double price = input.nextDouble();
		input.nextLine();

		System.out.print("Enter the handlebar type: ");
		String handlebarType = input.nextLine();

		if (dealership.addVehicle(new Motorcycle(make, model, color, year, price, handlebarType))) {
			System.out.println("Motorcycle added successfully.");
		} else {
			System.out.println("Couldn't add Motorcycle.");
		}
	}

	public static void sellVehicleMenu() {
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Sell a Vehicle");

		System.out.print("\nEnter the id of the vehicle: ");
		int id = input.nextInt();
		input.nextLine();

		if (dealership.getIndexFromId(id) == -1) {
			System.out.println("\nVehicle not found!");
			return;
		}

		System.out.print("Enter the buyer's name: ");
		String buyerName = input.nextLine();

		System.out.print("Enter the buyer's contact: ");
		String buyerContact = input.nextLine();

		Vehicle vehicle = dealership.getVehicleFromId(id);

		if (dealership.sellVehicle(vehicle, buyerName, buyerContact)) {
			System.out.println("Vehicle sold successfully.");
		} else {
			System.out.println("Couldn't sell vehicle");
		}

	}

	public static void removeVehicleMenu() {
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Remove a Vehicle");

		System.out.print("\nEnter the id of the vehicle: ");
		int id = input.nextInt();
		input.nextLine();

		if (dealership.getIndexFromId(id) == -1) {
			System.out.println("\nVehicle not found!");
			return;
		}

		Vehicle vehicle = dealership.getVehicleFromId(id);

		if (dealership.removeVehicle(vehicle)) {
			System.out.println("Vehicle removed successfully.");
		} else {
			System.out.println("Couldn't remove vehicle");
		}
	}

	public static void editVehicleMenu() {
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Edit a Vehicle");

		System.out.print("\nEnter the id of the vehicle: ");
		int id = input.nextInt();
		input.nextLine();

		if (dealership.getIndexFromId(id) == -1) {
			System.out.println("\nVehicle not found!");
			return;
		}
		System.out.println("\nEnter the new information");
		Vehicle vehicle = dealership.getVehicleFromId(id);
		vehicle.displayInfo();

		if (vehicle instanceof Car) {
			carEdit((Car) vehicle);
		}
		if (vehicle instanceof Motorcycle) {
			motorcycleEdit((Motorcycle) vehicle);
		}
	}

	public static void carEdit(Car c) {
		System.out.print("\nEnter the make: ");
		String make = input.nextLine();

		System.out.print("Enter the model: ");
		String model = input.nextLine();

		System.out.print("Enter the color: ");
		String color = input.nextLine();

		System.out.print("Enter the year: ");
		int year = input.nextInt();

		System.out.print("Enter the price: ");
		double price = input.nextDouble();

		System.out.print("Enter the type: ");
		input.nextLine();
		String type = input.nextLine();

		c.setMake(make);
		c.setModel(model);
		c.setColor(color);
		c.setYear(year);
		c.setPrice(price);
		c.setType(type);

	}

	public static void motorcycleEdit(Motorcycle m) {
		System.out.print("\nEnter the make: ");
		String make = input.nextLine();

		System.out.print("Enter the model: ");
		String model = input.nextLine();

		System.out.print("Enter the color: ");
		String color = input.nextLine();

		System.out.print("Enter the year: ");
		int year = input.nextInt();

		System.out.print("Enter the price: ");
		double price = input.nextDouble();

		System.out.print("Enter the handlebar type: ");
		input.nextLine();
		String handlebarType = input.nextLine();

		m.setMake(make);
		m.setModel(model);
		m.setColor(color);
		m.setYear(year);
		m.setPrice(price);
		m.setHandlebarType(handlebarType);

	}

	public static void searchCarMenu() {
		if (!(dealership.isEmpty())) {

			System.out.println("Enter type: ");
			String s = input.nextLine();

			Car[] v = dealership.searchCar(s);
			int total = 0;
			if (v != null) {
				for (int i = 0; i < v.length; i++) {
					if (v[i] != null) {
						v[i].displayInfo();
						System.out.println();
						total++;
					}
				}
			}
			System.out.printf("Total found: [%d]\n", total);
		} else
			System.out.println("Sorry the inventory is empty.");
	}

	public static void changeColorMenu() {
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Add a Vehicle");
		System.out.println("\nChoose an option:");
		System.out.println("1. Blue");
		System.out.println("2. Green");
		System.out.println("3. White");
		System.out.println("4. Exit");
		String choice = input.nextLine();

		switch (choice) {
		case "1":
			System.out.println("\u001B[36m"); // Changes color to Blue.
			break;
		case "2":
			System.out.println("\u001B[32m"); // Changes color to Green.

			break;
		case "3":
			System.out.println("\u001B[0m"); // Changes color back to White.

			break;
		case "4":
			return;
		default:
			System.out.println("Invalid choice. Please try again.");
		}

	}

	public static void budgetCarMenu() {
		if (!(dealership.isEmpty())) {

			System.out.println("Enter budget: ");
			String budget = input.nextLine();

			for (int i = 0; i < budget.length(); i++) {
				if (budget.charAt(i) < 48 || budget.charAt(i) > 57) { // Ascii digits from 0 to 9.
					System.out.println("Invaild Input, Please enter postive numbers only.");
					return;
				}
			}
			{
				int total = dealership.carBudget(Double.parseDouble(budget)); // Calling carBudget Method.
				System.out.printf("Total [%d]\n", total );
			}

		}else
			System.out.println("Sorry the inventory is empty.");
	}
	
	public static void createDealership(String name, String location, int capacity) throws IllegalCapacityException {
		if(capacity < 1 || capacity > 100) {
			throw new IllegalCapacityException();
		}
		dealership = new Dealership(name, location, capacity);
	}
	
	public static void save() throws IOException {
		File saveFile = new File("save.data");
		FileOutputStream outFileStream = null;
		try {
			outFileStream = new FileOutputStream(saveFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ObjectOutputStream outObjStream = null;
		try {
			 outObjStream = new ObjectOutputStream(outFileStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		outObjStream.writeObject(dealership);
		outObjStream.close();
		
	}
	
	// Main end.
	

}

package carDealership;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Dealership dealership = new Dealership("Saidawi Motors", "Riyadh", 20);

    public static void main(String args[]) {

        System.out.println("Welcome to the Dealership System!");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display all vehicles");
            System.out.println("2. Add a vehicle");
            System.out.println("3. Sell a vehicle");
            System.out.println("4. Remove a vehicle");
            System.out.println("5. Edit a vehicle");
            System.out.println("6. Sales history");
            System.out.println("7. Exit");
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
                case "7":
                    System.out.println("Exiting the Dealership System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
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
}

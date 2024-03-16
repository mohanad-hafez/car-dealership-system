# Car Dealership System (Phase 1)

This repository contains the first phase of the **Car Dealership System**, a Java project developed for the CSC 113 course during the second semester of 1445. The project aims to provide a comprehensive understanding of Java programming concepts, including inheritance, polymorphism, abstract classes, and array manipulation.

## Project Overview

The Car Dealership System is designed to simulate the management of a car dealership. It allows users to add, remove, sell, and edit vehicles within the dealership's inventory. The system also maintains a sales history to track all vehicle transactions.

## Project Structure

The project is structured into multiple Java classes:

1. **Vehicle**: An abstract class representing a generic vehicle with common attributes such as make, model, color, year, and price.
2. **Car**: A subclass of Vehicle, representing a car with additional attributes such as type.
3. **Motorcycle**: Another subclass of Vehicle, representing a motorcycle with specific attributes such as handlebar type.
4. **Dealership**: The main class handling dealership operations including managing inventory, sales, and displaying information.
5. **Sale**: A class representing a sale transaction, including details of the vehicle sold, buyer's name, contact, and sale date.
6. **Main**: The entry point of the program containing the main menu and user interaction functionalities.

## Functionality

The system provides the following functionalities:

- Displaying all vehicles in the inventory.
- Adding new vehicles (cars or motorcycles) to the inventory.
- Selling vehicles to customers and maintaining a sales history.
- Removing vehicles from the inventory.
- Editing vehicle information (make, model, color, year, price, type, handlebar type).

## Usage

Before running the program, ensure you have Java Development Kit (JDK) installed on your system. Then, follow these steps to compile and execute the Car Dealership System:

1. **Compile the Program**: Open your command-line interface, navigate to the project directory containing the source files, and execute the following command to compile the Java files:

    ```bash
    javac carDealership/*.java
    ```

    This command will compile all Java files in the `carDealership` package.

2. **Run the Program**: After successful compilation, execute the following command to run the Main class:

    ```bash
    java carDealership.Main
    ```

    This command will start the program and display the main menu for interacting with the Car Dealership System.


## Implementation Details

The implementation adheres to the project requirements, including:

- Proper use of inheritance with Vehicle, Car, and Motorcycle classes.
- Utilization of abstract class (Vehicle) and polymorphic methods.
- Array manipulation for managing the dealership's inventory.
- User-friendly menu-based interaction through the Main class.

## Sample Run

Below is a sample run of the program:
```
Choose an option:
1. Display all vehicles
2. Add a vehicle
3. Sell a vehicle
4. Remove a vehicle
5. Edit a vehicle
6. Sales history
7. Exit
Enter your choice: 1
Inventory Details:
Total inventory value: 122000.0
-------------------
ID: 1
Car: Toyota Camry 2022
Color: Black
Type: Sedan
Price: 102000.0 SAR
-------------------
-------------------
ID: 3
Motorcycle: Yamaha MT-07 2021
Color: Blue
Handlebar type: Standard
Price: 20000.0 SAR
-------------------
```
## UML
![Car Dealership drawio (1)](https://github.com/mohanad-hafez/car-dealership-system/assets/160021417/d538a3fc-6123-4bc2-b69b-5c4d9ed0b3cc)



## Team Members

- [Mohanad Hafez](https://github.com/mohanad-hafez)
- [Faris Al Zahrani](https://github.com/nxrzs)
- [Hisham Saydawi](https://github.com/xAGS1)


## Note

- The designed system will be utilized in the subsequent phases of the project.

## Note on Limitations

Please note that this implementation has fixed sizes for the inventory and sales arrays, which may limit the number of vehicles that can be stored and sales records that can be maintained. Currently, the maximum inventory size is set to 20 vehicles, and the sales history can accommodate up to double that number of transactions. If your requirements exceed these limits, you may need to modify the code accordingly.

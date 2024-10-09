# Car Dealership System

This repository contains the second phase of the **Car Dealership System**, a Java project developed for the CSC 113 course during the second semester of 1445. This phase enhances the program by handling exceptions, using files for data storage, and providing a graphical user interface (GUI) using Java Swing components.

## Project Overview

The Car Dealership System simulates the management of a car dealership, allowing users to perform various operations such as adding, removing, selling, and editing vehicles within the dealership's inventory. The system also maintains a sales history to track all vehicle transactions.

## Project Structure

The project is structured into multiple Java classes, including:

- **Vehicle**: An abstract class representing a generic vehicle with common attributes.
- **Car**: A subclass of Vehicle, representing a car with additional attributes.
- **Motorcycle**: Another subclass of Vehicle, representing a motorcycle with specific attributes.
- **Dealership**: The main class handling dealership operations.
- **Sale**: A class representing a sale transaction.
- **Main**: The entry point of the program containing the main menu and user interaction functionalities.
- **Frame**: A class implementing the GUI for user interaction.
- **VehicleMenu**: A class providing GUI forms for adding vehicles.
- **FirstLaunchPage**: A class for the initial launch GUI to set up dealership information.

## Functionality

The system provides the following functionalities:

- Displaying all vehicles in the inventory.
- Adding new vehicles (cars or motorcycles) to the inventory.
- Selling vehicles to customers and maintaining a sales history.
- Removing vehicles from the inventory.
- Editing vehicle information.
- Searching for cars by type.
- Finding cars within a specified budget.

## Exception Handling

### User Defined Exceptions
- **IllegalCapacityException**: An unchecked exception used to handle invalid input for inventory capacity. It is thrown when the user inputs a capacity that is not within the valid range (1-100).

### Checked Exceptions
- Checked exceptions were handled when dealing with files for saving and loading data. Methods that interact with files are declared to throw IOException, and appropriate try-catch blocks are used to handle potential file-related exceptions.

### Unchecked Exceptions
- **NumberFormatException**: An unchecked exception used to handle invalid input for inventory capacity in the new launch page. It is thrown when the user inputs a non-numeric value for inventory capacity.

## File Handling

Files are used for saving and loading data using Java's data stream (ObjectInputStream and ObjectOutputStream). The entire Dealership object is serialized and stored in a binary file named "save.data".

## Graphical User Interface (GUI)

The GUI is implemented using Java Swing components, including JFrame, JButton, JLabel, JTextField, JPanel, JMenuBar, JMenuItem, and JTextArea. The GUI provides an intuitive interface for users to interact with the Car Dealership System.

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

## Sample Run

Below is a sample run of the program:


## UML
![Car Dealership UML Diagram](https://github.com/mohanad-hafez/car-dealership-system/assets/160021417/d538a3fc-6123-4bc2-b69b-5c4d9ed0b3cc)



## Team Members

- [Mohanad Hafez](https://github.com/mohanad-hafez)
- [Faris Al Zahrani](https://github.com/nxrzs)
- [Hisham Saydawi](https://github.com/xAGS1)

## Possible Improvements

- Enhance user interface design for better user experience.
- Implement user authentication and authorization for secure access.
- Utilize a linked list data structure instead of an array for the inventory to enable dynamic resizing without specifying a fixed size.

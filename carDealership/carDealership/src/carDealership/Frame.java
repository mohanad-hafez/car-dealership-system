package carDealership;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Frame extends JFrame implements ActionListener {

	private Container con;
	private JFrame jf1;
	private JMenuBar menuBar;
	// ---------Buttons--------
	private JButton jbutton1, jbutton2, jbutton3, jbutton4, jbutton5, jbutton6, jbutton7, jbutton8, jbutton9;
	
	
	//=========Files==========
	private   String fileName;
    private  JTextArea textArea;
    private  JScrollPane scrollPane;
	// ---------Jmenu buttons-----------------
//	private JMenu jm1, jm2;

   
	// -----------Labels---------
	private JLabel jl1;

	public Frame() {
		jf1 = new JFrame();
		JMenuBar menuBar = new JMenuBar();

	//	jm1 = new JMenu("Read");
	//	jm2 = new JMenu("Write");
		con = new Container();

		// ----------jbuttons stuff-------------
		jbutton1 = new JButton("Display all");
		jbutton2 = new JButton("Add a vehicle");
		jbutton3 = new JButton("Sell a vehicle");
		jbutton4 = new JButton("Remove a vehicle");
		jbutton5 = new JButton("Edit a vehicle");
		jbutton6 = new JButton("Sales history");
		jbutton7 = new JButton("Search car (Budget)");
		jbutton9 = new JButton("Write");
		jbutton8 = new JButton("Read");
		// jbutton1.setForeground(Color.white);
	
		jbutton1.setForeground(new java.awt.Color(12, 101, 72));
		jbutton3.setForeground(new java.awt.Color(1, 121, 72));
		jbutton4.setForeground(Color.red);
		
		jbutton1.setBackground(Color.decode("#F09EA7"));
		jbutton2.setBackground(Color.decode("#F6CA94"));
		jbutton3.setBackground(Color.decode("#FAFABE"));
		jbutton4.setBackground(Color.decode("#C1EBC0"));
		jbutton5.setBackground(Color.decode("#C7CAFF"));
		jbutton6.setBackground(Color.decode("#CDABEB"));
		jbutton7.setBackground(Color.decode("#F6C2F3"));
		jbutton8.setBackground(Color.cyan);
		jbutton9.setBackground(Color.cyan);

		
		
		jbutton1.setBounds(20, 40, 150, 70);
		jbutton2.setBounds(180, 40, 150, 70);
		jbutton3.setBounds(340, 40, 150, 70);
		jbutton4.setBounds(500, 40, 150, 70);
		jbutton5.setBounds(660, 40, 150, 70);
		jbutton6.setBounds(820, 40, 150, 70);
		jbutton7.setBounds(980, 40, 150, 70);
		
		jbutton9.setBounds(580, 120, 150, 70);
		jbutton8.setBounds(420, 120, 150, 70);
		// ------------Labels-----------
		jl1 = new JLabel("");

		// ----------MENU------------
		jf1.setJMenuBar(menuBar);
	//	menuBar.add(jm1);
	//	menuBar.add(jm2);

		// -------------------------

		jf1.setTitle("Dealership system");
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.getContentPane().setBackground(Color.decode("#ADD8E6"));

		jf1.setVisible(true);
		jf1.setBounds(0, 0, 1170, 600);
		jf1.setResizable(false);

		jf1.add(jbutton1);
		jf1.add(jbutton2);
		jf1.add(jbutton3);
		jf1.add(jbutton4);
		jf1.add(jbutton5);
		jf1.add(jbutton6);
		jf1.add(jbutton7);
		jf1.add(jbutton8);
		jf1.add(jbutton9);
		// jf1.add(jb8);

		jf1.add(jl1);

		// ---------------------------
		jbutton1.addActionListener(this);
		jbutton2.addActionListener(this);
		jbutton3.addActionListener(this);
		jbutton4.addActionListener(this);
		jbutton5.addActionListener(this);
		jbutton6.addActionListener(this);
		jbutton7.addActionListener(this);
		jbutton8.addActionListener(this);
		jbutton9.addActionListener(this);
		
		
		// ============= eXcpetions
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbutton1) {
			displayInventory();
		}
		if (e.getSource() == jbutton2) {
			SwingUtilities.invokeLater(() -> {
				VehicleMenu VehicleMenu = new VehicleMenu();
				VehicleMenu.setVisible(true);
			});
			System.out.println("Adding...");
		}
		if (e.getSource() == jbutton3) {
			sellVehicleMenu();
		}
		if (e.getSource() == jbutton4) {
			removeVehicleMenu();
		}
		if (e.getSource() == jbutton5) {
			editVehicleMenu();
		}
		if (e.getSource() == jbutton6) {
			displaySalesHistory();
		}
		if (e.getSource() == jbutton7) {
			budgetCarGUI();
		}
		if (e.getSource() == jbutton8) {
			readSalesHistoryFromFile();
		}
		if (e.getSource() == jbutton9) {
			displayAndWriteDataToFile();
		}

	}
	

	private void displayAndWriteDataToFile() {
	    String[] options = {"Inventory", "Sales History", "Both"};
	    int choice = JOptionPane.showOptionDialog(null, "Choose the data to write to file:", 
	                                               "Write to File", JOptionPane.DEFAULT_OPTION, 
	                                               JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	    if (choice == JOptionPane.CLOSED_OPTION) {
	        return;
	    }
	    StringBuilder dataToDisplay = new StringBuilder();

	    if (choice == 0 || choice == 2) {
	        if (Main.dealership.isEmpty()) {
	            dataToDisplay.append("Inventory is empty!\n\n");
	        } else {
	            dataToDisplay.append("").append(Main.dealership.displayAlls()).append("");
	        }
	    }
	    if (choice == 1 || choice == 2) {
	        dataToDisplay.append("\n").append(Main.dealership.showSalesHistory());
	    }

	    JTextArea textArea = new JTextArea(dataToDisplay.toString());
	    textArea.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    scrollPane.setPreferredSize(new Dimension(600, 400));
	    
	    String fileName = JOptionPane.showInputDialog(null, "Enter the file name:");
	    if (fileName == null || fileName.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Invalid file name. Please enter a valid file name.");
	        return;
	    }
	    try (FileWriter writer = new FileWriter(fileName)) {
	        writer.write(dataToDisplay.toString());
	        JOptionPane.showMessageDialog(null, "Data successfully written to file: " + fileName);
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error writing to file: " + fileName);
	        e.printStackTrace();
	    }
	    JOptionPane.showMessageDialog(null, scrollPane, "Inventory and Sales History", JOptionPane.PLAIN_MESSAGE);
	}


	 
	  private  void readSalesHistoryFromFile() {
	        fileName = JOptionPane.showInputDialog(null, "Enter the file name:");
	        if (fileName == null || fileName.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Invalid file name. Please enter a valid file name.");
	            return;
	        }
	        textArea = new JTextArea(20, 40);
	        textArea.setEditable(false);
	        scrollPane = new JScrollPane(textArea);

	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            StringBuilder salesHistory = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                salesHistory.append(line).append("\n");
	            }
	            textArea.setText(salesHistory.toString());
	        } catch (FileNotFoundException e) {
	            JOptionPane.showMessageDialog(null, "File not found: " + fileName);
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, "Error reading from file: " + fileName);
	            e.printStackTrace();
	        }

	        JOptionPane.showMessageDialog(null, scrollPane, "Sales History from File", JOptionPane.PLAIN_MESSAGE);
	    }
	 
	
	private void displayInventory() {
		if (Main.dealership.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Inventory is empty!");
		} else {
			 textArea = new JTextArea(Main.dealership.displayAlls());
			textArea.setEditable(false);
			 scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(400, 300));
			JOptionPane.showMessageDialog(null, scrollPane, "Inventory", JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void sellVehicleMenu() {
	    try {
	        String idString = JOptionPane.showInputDialog(null, "Enter the id of the vehicle:");
	        if (idString == null) { //checks if no input
	            return;
	        }
	        int id = Integer.parseInt(idString);
	        if (Main.dealership.getIndexFromId(id) == -1) {
	            JOptionPane.showMessageDialog(null, "Vehicle not found!");
	            return;
	        }
	        String buyerName = JOptionPane.showInputDialog(null, "Enter the buyer's name:");
	        String buyerContact = JOptionPane.showInputDialog(null, "Enter the buyer's contact:");
	        Vehicle vehicle = Main.dealership.getVehicleFromId(id);

	        if (Main.dealership.sellVehicle(vehicle, buyerName, buyerContact)) {
	            JOptionPane.showMessageDialog(null, "Vehicle sold successfully.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Couldn't sell vehicle.");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer ID.");
	    }
	}
	

	private void displaySalesHistory() {
	 textArea = new JTextArea(Main.dealership.showSalesHistory());
		textArea.setEditable(false);
		 scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(400, 300));
		JOptionPane.showMessageDialog(null, scrollPane, "Sales History", JOptionPane.PLAIN_MESSAGE);
	}

	private void removeVehicleMenu() {
	    try {
	        String idString = JOptionPane.showInputDialog(null, "Enter the id of the vehicle:");
	        if (idString == null) { //checks if no input
	            return;
	        }
	        int id = Integer.parseInt(idString);
	        
	        if (Main.dealership.getIndexFromId(id) == -1) {
	            JOptionPane.showMessageDialog(null, "Vehicle not found!");
	        } else {
	            Vehicle vehicle = Main.dealership.getVehicleFromId(id);
	            if (Main.dealership.removeVehicle(vehicle)) {
	                JOptionPane.showMessageDialog(null, "Vehicle removed successfully.");
	            } else {
	                JOptionPane.showMessageDialog(null, "Couldn't remove vehicle.");
	            }
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer ID.");
	    }
	}


	private void editVehicleMenu() {
		try {
			String idString = JOptionPane.showInputDialog(null, "Enter the id of the vehicle:");
			
			 if (idString == null) { //checks if no input
		            return;
		        }
			 
			int id = Integer.parseInt(idString);

			if (Main.dealership.getIndexFromId(id) == -1) { // check if exist
				JOptionPane.showMessageDialog(null, "Vehicle not found!");
				return;
			}
			Vehicle vehicle = Main.dealership.getVehicleFromId(id);

			JTextField makeField = new JTextField();
			JTextField modelField = new JTextField();
			JTextField colorField = new JTextField();
			JTextField yearField = new JTextField();
			JTextField priceField = new JTextField();
			JTextField typeField = new JTextField();
			JTextField handlebarField = new JTextField();

			JPanel editPanel = new JPanel();
			editPanel.setLayout(new GridLayout(0, 2));

			if (vehicle instanceof Car) {
				Car car = (Car) vehicle;

				editPanel.add(new JLabel("Make:"));
				makeField.setText(car.getMake());
				editPanel.add(makeField);

				editPanel.add(new JLabel("Model:"));
				modelField.setText(car.getModel());
				editPanel.add(modelField);

				editPanel.add(new JLabel("Color:"));
				colorField.setText(car.getColor());
				editPanel.add(colorField);

				editPanel.add(new JLabel("Year:"));
				yearField.setText(String.valueOf(car.getYear()));
				editPanel.add(yearField);

				editPanel.add(new JLabel("Price:"));
				priceField.setText(String.valueOf(car.getPrice()));
				editPanel.add(priceField);

				editPanel.add(new JLabel("Type:"));
				typeField.setText(car.getType());
				editPanel.add(typeField);

			} else if (vehicle instanceof Motorcycle) {
				Motorcycle motorcycle = (Motorcycle) vehicle;

				editPanel.add(new JLabel("Make:"));
				makeField.setText(motorcycle.getMake());
				editPanel.add(makeField);

				editPanel.add(new JLabel("Model:"));
				modelField.setText(motorcycle.getModel());
				editPanel.add(modelField);

				editPanel.add(new JLabel("Color:"));
				colorField.setText(motorcycle.getColor());
				editPanel.add(colorField);

				editPanel.add(new JLabel("Year:"));
				yearField.setText(String.valueOf(motorcycle.getYear()));
				editPanel.add(yearField);

				editPanel.add(new JLabel("Price:"));
				priceField.setText(String.valueOf(motorcycle.getPrice()));
				editPanel.add(priceField);

				editPanel.add(new JLabel("Handlebar Type:"));
				handlebarField.setText(motorcycle.getHandlebarType());
				editPanel.add(handlebarField);
			}

			int option = JOptionPane.showConfirmDialog(null, editPanel, "Edit Vehicle", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) { // edit and set
				if (vehicle instanceof Car) {
					Car car = (Car) vehicle;
					car.setMake(makeField.getText());
					car.setModel(modelField.getText());
					car.setColor(colorField.getText());
					car.setYear(Integer.parseInt(yearField.getText()));
					car.setPrice(Double.parseDouble(priceField.getText()));
					car.setType(typeField.getText());
				} else if (vehicle instanceof Motorcycle) {
					Motorcycle motorcycle = (Motorcycle) vehicle;
					motorcycle.setMake(makeField.getText());
					motorcycle.setModel(modelField.getText());
					motorcycle.setColor(colorField.getText());
					motorcycle.setYear(Integer.parseInt(yearField.getText()));
					motorcycle.setPrice(Double.parseDouble(priceField.getText()));
					motorcycle.setHandlebarType(handlebarField.getText());
				}
				JOptionPane.showMessageDialog(null, "Vehicle edited successfully.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input. Year and price must be numeric values.");
		}
	}

	public  void budgetCarGUI() { // ADD WHATS CAR WITHIN BUDGET HERE
		JFrame frame = new JFrame("Budget for Cars");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(3, 2));

		JLabel budgetLabel = new JLabel("Enter Budget:");
		JTextField budgetField = new JTextField();
		JButton searchButton = new JButton("Check Budget");

		searchButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String budgetText = budgetField.getText();
				try {
					double budget = Double.parseDouble(budgetText);
					if (budget < 0) {
						JOptionPane.showMessageDialog(null, "Invalid input. Please enter a positive number.");
						return;
					}
					int total = Main.dealership.carBudget(budget);
					JOptionPane.showMessageDialog(null, "Total number of cars within budget: " + total);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
				}
			}
		});
		frame.add(budgetLabel);
		frame.add(budgetField);
		frame.add(searchButton);

		frame.setVisible(true);

	}

}

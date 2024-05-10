package carDealership;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Frame extends JFrame implements ActionListener {

	private Container con;
	private JFrame jf1;
	// ---------Buttons--------
	private JButton jbutton1, jbutton2, jbutton3, jbutton4, jbutton5, jbutton6, jbutton7, jbutton8;

	// =========Files==========
	private String fileName;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	// ---------JMenu -----------------
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem save;
	private JMenuItem deleteDealership;

	private ImageAnimation ia;
	// -----------Labels---------
	private JLabel jl1;
	private JLabel jl2;

	public Frame() {
		jf1 = new JFrame();
		con = new Container();

		
		
		
	
	//===== secret stuff ======	
		SwingUtilities.invokeLater(() -> {
			ia = new ImageAnimation();
			ia.setVisible(true);
			jf1.add(ia);

		});

		// ------------- Jmenu ------------
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		save = new JMenuItem("save");
		deleteDealership = new JMenuItem("delete dealership");

		fileMenu.add(save);
		fileMenu.add(deleteDealership);

		menuBar.add(fileMenu);

		jf1.setJMenuBar(menuBar);
	
		// jm1 = new JMenu("Read");
		// jm2 = new JMenu("Write");

		// ----------jbuttons stuff-------------
		jbutton1 = new JButton("Display all");
		jbutton2 = new JButton("Add a vehicle");
		jbutton3 = new JButton("Sell a vehicle");
		jbutton4 = new JButton("Remove a vehicle");
		jbutton5 = new JButton("Edit a vehicle");
		jbutton6 = new JButton("Sales history");
		jbutton7 = new JButton("Search car (Budget)");
		jbutton8 = new JButton("Dealership info");
		
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
		jbutton8.setBackground(Color.decode("#FFD700"));

		jbutton1.setBounds(20, 40, 150, 70);
		jbutton2.setBounds(180, 40, 150, 70);
		jbutton3.setBounds(340, 40, 150, 70);
		jbutton4.setBounds(500, 40, 150, 70);
		jbutton5.setBounds(660, 40, 150, 70);
		jbutton6.setBounds(820, 40, 150, 70);
		jbutton7.setBounds(980, 40, 150, 70);
		
		jbutton8.setBounds(500, 120, 150, 50);
		
		// ------------Labels-----------
		jl1 = new JLabel("");

		// ----------MENU------------
		jf1.setJMenuBar(menuBar);
		// menuBar.add(jm1);
		// menuBar.add(jm2);

		// -------------------------

		jf1.setTitle("Dealership system");
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.getContentPane().setBackground(Color.decode("#ADD8E6"));

		jf1.setVisible(true);
		jf1.setBounds(0, 0, 1170, 600);
		jf1.setResizable(false);
		jf1.setIconImage(Toolkit.getDefaultToolkit().getImage(FirstLaunchPage.class.getResource("/images/icon.jpg")));
		
		jf1.add(jbutton1);
		jf1.add(jbutton2);
		jf1.add(jbutton3);
		jf1.add(jbutton4);
		jf1.add(jbutton5);
		jf1.add(jbutton6);
		jf1.add(jbutton7);
		jf1.add(jbutton8);
		

		jf1.add(jl1); // do not remove!

		// ---------------------------
		jbutton1.addActionListener(this);
		jbutton2.addActionListener(this);
		jbutton3.addActionListener(this);
		jbutton4.addActionListener(this);
		jbutton5.addActionListener(this);
		jbutton6.addActionListener(this);
		jbutton7.addActionListener(this);
		jbutton8.addActionListener(this);
		
		save.addActionListener(this);
		deleteDealership.addActionListener(this);

		// ============= eXcpetions

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbutton1) {
			displayInventory();
		}
		if (e.getSource() == jbutton2) {
			SwingUtilities.invokeLater(() -> {
				if(!(Main.dealership.isFull())) {
				VehicleMenu VehicleMenu = new VehicleMenu();
				VehicleMenu.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Sorry, your inventory is Full!");
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

		if (e.getSource() == save) {
			try {
				Main.save();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		if (e.getSource() == deleteDealership) {
		    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the dealership?", "Confirmation", JOptionPane.YES_NO_OPTION);
		    if (confirm == JOptionPane.YES_OPTION) {
		        System.out.println("On bro I'm speaking fax");
		        File saveFile = new File("save.data");
		        if (saveFile.exists()) {
		        	 saveFile.delete();
		        }
		           
		        jf1.dispose();
		    }
		}
		if(e.getSource() == jbutton8) {
			displayDealerInfo();
		}


	}

	
	
	
	
	private void displayDealerInfo() {
	 JTextArea textArea = new JTextArea();
     textArea.setText(Main.dealership.getInfoGUI()); 
     textArea.setEditable(false);

     // Wrap the text area in a scroll pane
     JScrollPane scrollPane = new JScrollPane(textArea);

     // Create a dialog to display the information
     JOptionPane.showMessageDialog(null, scrollPane, "All Information", JOptionPane.PLAIN_MESSAGE);
	
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
			if (idString == null) { // checks if no input
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
			JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
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
	        if (idString == null) { // checks if no input
	            return;
	        }
	        int id = Integer.parseInt(idString);

	        if (Main.dealership.getIndexFromId(id) == -1) {
	            JOptionPane.showMessageDialog(null, "Vehicle not found!");
	        } else {
	            Vehicle vehicle = Main.dealership.getVehicleFromId(id);
	            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this vehicle\nwith id: "+ id , "Confirm Deletion", JOptionPane.YES_NO_OPTION);
	            if (confirm == JOptionPane.YES_OPTION) {
	                if (Main.dealership.removeVehicle(vehicle)) {
	                    JOptionPane.showMessageDialog(null, "Vehicle removed successfully.");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Couldn't remove vehicle.");
	                }
	            }
	        }
	    } catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
	    }
	}

	

	private void editVehicleMenu() {
		try {
			String idString = JOptionPane.showInputDialog(null, "Enter the id of the vehicle:");

			if (idString == null) { // checks if no input
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

	  public void budgetCarGUI() { // Search a CAR WITHIN a specific BUDGET.
	        
	        String budgetText = JOptionPane.showInputDialog(null, "Enter Budget:");
	        if (budgetText == null) {
	            return;
	        }
	        
	        try {
	        	
	            double budget = Double.parseDouble(budgetText);
	            if (budget < 0) {
	                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a positive number.");
	                return;
	            }
	            
	            
	            Car[] carsWithinBudget = Main.dealership.carsWithinBudget(budget);
	            if (carsWithinBudget.length == 0) {
	                JOptionPane.showMessageDialog(null, "No cars found within the budget of " + budget + " SAR.");
	            } 
	            else {
	                StringBuilder message = new StringBuilder();
	                for (Car car : carsWithinBudget) {
	                    if (car != null && car.getPrice() <= budget) {
	                        message.append(car.toString()+ "\n--------------------").append("\n");
	                    }
	                }
	                if (message.length() == 0) {
	                    JOptionPane.showMessageDialog(null, "No cars found within the budget of " + budget );
	                } 
	                else {
	                    JTextArea resultArea = new JTextArea(message.toString());
	                     scrollPane = new JScrollPane(resultArea);
	                    scrollPane.setPreferredSize(new Dimension(400, 300));
	                    JOptionPane.showMessageDialog(null, scrollPane, "Cars within Budget", JOptionPane.PLAIN_MESSAGE);
	                }
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
	        }
	    }
	
	
	  
	  

}

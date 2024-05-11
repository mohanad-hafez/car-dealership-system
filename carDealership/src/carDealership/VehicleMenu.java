package carDealership;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VehicleMenu extends JFrame implements ActionListener { // this class for adding a vehicle gui..
    private JButton carButton, motorcycleButton, exitButton;
   
    public VehicleMenu() {
        setTitle("Add a Vehicle");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(null); 

        carButton = new JButton("Add Car");
        carButton.setBackground(Color.pink);
        carButton.addActionListener(this);
        add(carButton);

        motorcycleButton = new JButton("Add Motorcycle");
        motorcycleButton.setBackground(Color.decode("#9FE7F5"));
        motorcycleButton.addActionListener(this);
        add(motorcycleButton);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == carButton) {
            addCarMenu();
        } else if (e.getSource() == motorcycleButton) {
            addMotorcycleMenu();
        } else if (e.getSource() == exitButton) {
            dispose(); // closes the GUI windw.
        }
    }

    private void addCarMenu() {
        JTextField makeField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField carTypeField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Make:"));
        panel.add(makeField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Color:"));
        panel.add(colorField);
        panel.add(new JLabel("Year:"));
        panel.add(yearField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Car Type:"));
        panel.add(carTypeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add a Car", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String make = makeField.getText();
            String model = modelField.getText();
            String color = colorField.getText();
            int year;
            double price;

            try {
                year = Integer.parseInt(yearField.getText());
                price = Double.parseDouble(priceField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Year and price must be numeric values.");
                return;
            }

            String type = carTypeField.getText();

           if( Main.dealership.addVehicle(new Car(make, model, color, year, price, type)))
            JOptionPane.showMessageDialog(null, "Car has been added successfully.");
           else
         	  JOptionPane.showMessageDialog(null, "Sorry, the car has not been added.");
        }
    }


    private void addMotorcycleMenu() {
        JTextField makeField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField handlebarTypeField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("Make:"));
        panel.add(makeField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Color:"));
        panel.add(colorField);
        panel.add(new JLabel("Year:"));
        panel.add(yearField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Handlebar Type:"));
        panel.add(handlebarTypeField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Add a Motorcycle", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String make = makeField.getText();
            String model = modelField.getText();
            String color = colorField.getText();
            int year;
            double price;

            try {
                year = Integer.parseInt(yearField.getText());
                price = Double.parseDouble(priceField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Year and price must be numeric values.");
                return;
            }

            String handlebarType = handlebarTypeField.getText();
            
            if(  Main.dealership.addVehicle(new Motorcycle(make, model, color, year, price, handlebarType)))
            JOptionPane.showMessageDialog(null, "Motorcycle has been added successfully.");
            else
            	  JOptionPane.showMessageDialog(null, "Sorry, the motorcycle has not been added.");
          
        }
    }


  

	
}
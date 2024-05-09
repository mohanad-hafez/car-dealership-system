package carDealership;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FirstLaunchPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FirstLaunchPage frame = new FirstLaunchPage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FirstLaunchPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FirstLaunchPage.class.getResource("/images/icon.jpg")));
		setTitle("Dealership System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(6, 6, 6));
		panel.setBounds(0, 0, 277, 377);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FirstLaunchPage.class.getResource("/images/bg.jpg")));
		lblNewLabel_1.setBounds(-242, 0, 509, 256);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Get Started");
		lblNewLabel_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setBounds(83, 299, 153, 42);
		panel.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Go");

		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(241, 57, 83));
		btnNewButton.setBounds(356, 277, 203, 30);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(319, 72, 291, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Dealership Name");
		lblNewLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblNewLabel.setBounds(319, 40, 151, 22);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(319, 217, 291, 30);
		contentPane.add(textField_1);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblLocation.setBounds(319, 112, 151, 22);
		contentPane.add(lblLocation);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(319, 149, 291, 30);
		contentPane.add(textField_2);

		JLabel lblInventoryCapacity = new JLabel("Inventory Capacity");
		lblInventoryCapacity.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		lblInventoryCapacity.setBounds(319, 185, 151, 22);
		contentPane.add(lblInventoryCapacity);
		
		JLabel lblNewLabel_3 = new JLabel("Inventory Capacity must be an integer");
		lblNewLabel_3.setForeground(new Color(255, 128, 128));
		lblNewLabel_3.setBounds(319, 249, 291, 16);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("Capacity must be between 1 - 100");
		lblNewLabel_4.setForeground(new Color(255, 128, 128));
		lblNewLabel_4.setBounds(319, 249, 266, 16);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					Main.createDealership(textField.getText(), textField_2.getText(),
							Integer.valueOf(textField_1.getText()));
					dispose();
					Frame myFrame = new Frame();
				} catch (NumberFormatException ex) {
					textField_1.setText("");
					lblNewLabel_4.setVisible(false);
					lblNewLabel_3.setVisible(true);
				} catch(IllegalCapacityException ex2) {
					textField_1.setText("");
					lblNewLabel_3.setVisible(false);
					lblNewLabel_4.setVisible(true);
				}
			}
		});

		setVisible(true);
	}
}

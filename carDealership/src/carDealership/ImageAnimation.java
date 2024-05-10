package carDealership;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageAnimation extends JPanel implements ActionListener {
    private int xPos = 1000;
    private int yPos = 450;
    private int xVelocity = 3;
    private Image image;
    private Timer timer;

    private int imageWidth = 100;
    private int imageHeight = 100;

    public ImageAnimation() {
        setPreferredSize(new Dimension(imageWidth, imageHeight));
        setOpaque(false); // Make transparent
        
        loadImage();
        timer = new Timer(3, this);
   

       
        JButton btn = new JButton("Animation Options");
    
        btn.setBackground(Color.white);
        btn.addActionListener(new ActionListener() {
        	
        	
            
            public void actionPerformed(ActionEvent e) {
            

                JPopupMenu popupMenu = new JPopupMenu();
               
                // Add items to the popup menu
                JMenuItem speedItem = new JMenuItem("Adjust Speed");
                speedItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input = JOptionPane.showInputDialog(null, "Enter the new speed (pixels/frame):");
                        try {
                            int speed = Integer.parseInt(input);
                            xVelocity = speed;
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
                        }
                    }
                });
                popupMenu.add(speedItem);

                JMenuItem toggleItem = new JMenuItem("Toggle Animation");
                toggleItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (timer.isRunning()) {
                            timer.stop(); 
                        } else {
                            timer.start();
                        }
                    }
                });
                popupMenu.add(toggleItem);
                popupMenu.show(btn, 0, btn.getHeight()); // show the pop menu
            }
        });
        add(btn); 
    }

    
    
    
    private void loadImage() {
        ImageIcon ii = new ImageIcon(ImageAnimation.class.getResource("/images/hehe.png"));
        image = ii.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(new Color(0, 0, 0, 0)); // Transparent background
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.drawImage(image, xPos, yPos, this);
        g2d.dispose();
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        xPos -= xVelocity;
        if (xPos + imageWidth < 0) { // Check if image has gone fully to the left
            xPos = getWidth(); // Reset position
        }
        repaint();
    }
}


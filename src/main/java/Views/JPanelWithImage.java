package Views;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class JPanelWithImage extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;
	 @Override
     protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         if (image != null) {
             g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
         }
     }
     public void setImage(Image img) {
         this.image = img;
         repaint();
     }
 }


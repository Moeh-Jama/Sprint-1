import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel {
	double x=0,y=0,velX=23,velY=23;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D c = new Ellipse2D.Double(x,y, 40, 40);
		g2.fill(c);
		
	}
	
	public void move(String movementType) {
		switch(movementType) {
		case "UP":{
			y -= velY;
			break;
			
		}
		case "Down":{
			y += velY;
			break;
		}
		case "Right":{
			x += velX;
			break;
		}
		case "Left":{
			x -= velX;
			break;
		}
		}
		repaint();
	}
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Weapon extends JPanel {
	private int weaponX=0;
	private int weaponY=0;
	private String name;
	private int velocity_X = 23;
	private int velocity_Y = 23;
	Color weapon = Color.RED;


	//get weapon coordinate x 
	public int getWeaponX() {
		return this.weaponX;
	}

	//get weapon coordinate y
	public int getWeaponY() {
		return this.weaponY;
	}
	
	//get the weapon name
	public String getName() {
		return this.name;
	}

	//set the weapon name
	public void setName(String name) {
		this.name = name;
	}

	//set the weapon coordinate x
	public void setWeaponX(int x) {
		this.weaponX = x;
	}

	//set the weapon coordinate y
	public void setWeaponY(int y) {
		this.weaponY = y;
	}

	//calculate the new coordinate of the weapon
	public void calculateCoordinates(int x, int y) {
		weaponX += x;
		weaponY += y;
	}

	//generate image of weapon
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.cyan);
		g2.setFont(new Font("Britannic", Font.BOLD, 14));
		g2.drawString(getName().substring(0, 2), weaponX, weaponY); 
		//g2.fill(c);
	}

	//move weapon
	public void move(String movementType) {
		switch (movementType) {
		case "U": {
			if (weaponY > 0)
				weaponY -= velocity_Y;
			break;

		}
		case "D": {
			if (weaponY < 23 * 24)
				weaponY += velocity_Y;
			break;
		}
		case "R": {
			if (weaponX < 23 * 23)
				weaponX += velocity_X;
			break;
		}
		case "L": {
			if (weaponX > 0)
				weaponX -= velocity_X;
			break;
		}
		}
		repaint();
	}

}

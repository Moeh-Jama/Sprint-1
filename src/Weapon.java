import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Weapon extends JPanel {
	private int weaponX;
	private int weaponY;
	private String name;
	private int velocity_X = 23 * 4;
	private int velocity_Y = 23 * 4;
	Color weapon = Color.RED;

	public Weapon(String name, int x, int y) {
		setName(name);
		setWeaponX(x);
		setWeaponY(y);
	}

	public int getWeaponX() {
		return this.weaponX;
	}

	public int getWeaponY() {
		return this.weaponY;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeaponX(int x) {
		this.weaponX = x;
	}

	public void setWeaponY(int y) {
		this.weaponY = y;
	}

	public void calculateCoordinates(int x, int y) {
		weaponX += x;
		weaponY += y;
	}

	public void paintComponent(Graphics g) {

		/*
		 * super.paintComponent(g);
		 * 
		 * Graphics2D g2 = (Graphics2D) g;
		 * 
		 * Ellipse2D c = new Ellipse2D.Double(x,y, 23, 23); g2.setColor(player);
		 * g2.fill(c);
		 */

		// @Override

	}

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

	public void setWeapon(String weaponName) {
		switch (weaponName) {
		case "Example1": {
			weapon = Color.RED;
		}
		case "Example2": {
			weapon = Color.BLUE;
		}
		default: {
			System.out.println("Player could not be assigned Color: setPlayerName");
			System.exit(0);
		}
		}
	}

}

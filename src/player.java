
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class player extends JPanel {
	private String name;//Name of the player	
	private double player_X_CoOrdinate;//co-ordinate X of the player
	private double player_Y_CoOrdinate;//Y co-ordinate
	private int velocity_X = 23 * 4;
	private int velocity_Y = 23 * 4;
	Color player = Color.RED;

	public void setPositionX(double x) {
		this.player_X_CoOrdinate = x;
	}
//Sets Y-coOrdinate of the player
	public void setPositionY(double y) {
		this.player_Y_CoOrdinate = y;
	}
//Returns players name
	public String getPlayerName() {


public class player {
	private String name;
	private int x;
	private int y;
	
	public Player(String name, int a,int b){
		this.x=a;
		this.y=b;
		this.name=name;
	}
	
	public String getPlayerName(){

		return this.name;
	}
//Function to return players X co-ordinate
	public double getPlayerPostionX() {
		return this.player_X_CoOrdinate;
	}
//function to return players Y co-ordinate
	public double getPlayerPositionY() {
		return this.player_Y_CoOrdinate;
	}
//Function to move the players over the board
	public void move(String movementType) {
		switch (movementType) {
		case "U": {
			if (player_Y_CoOrdinate > 0)
				player_Y_CoOrdinate -= velocity_Y;
			break;

		}
		case "D": {
			if (player_Y_CoOrdinate < 23 * 24)
				player_Y_CoOrdinate += velocity_Y;
			break;
		}
		case "R": {
			if (player_X_CoOrdinate < 23 * 23)
				player_X_CoOrdinate += velocity_X;
			break;
		}
		case "L": {
			if (player_X_CoOrdinate > 0)
				player_X_CoOrdinate -= velocity_X;
			break;
		}
		}
		repaint();
	}
	//Assigning colours to players
	public void setPlayer(String playerName) {
		switch (playerName) {
		case "Example1": {
			player = Color.RED;
		}
		case "Example2": {
			player = Color.BLUE;
		}
		default: {
			System.out.println("Player could not be assigned Color: setPlayerName");
			System.exit(0);
		}
		}
	}

	public void paintComponent(Graphics g) {
		System.out.println(player_X_CoOrdinate + ", " + player_Y_CoOrdinate);
		/*
		 * super.paintComponent(g);
		 * 
		 * Graphics2D g2 = (Graphics2D) g;
		 * 
		 * Ellipse2D c = new Ellipse2D.Double(x,y, 23, 23); g2.setColor(player);
		 * g2.fill(c);
		 */

		Image bg = new ImageIcon("src/image/uganda_k.png").getImage();
		// @Override

		super.paintComponent(g);
		g.drawImage(bg, (int) player_X_CoOrdinate, (int) player_Y_CoOrdinate, 23 * 4, 23 * 4, this);

	}
}

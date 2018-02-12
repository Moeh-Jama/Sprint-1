
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel {
	private String name;// Name of the player
	private int player_X_CoOrdinate;// co-ordinate X of the player
	private int player_Y_CoOrdinate;// Y co-ordinate
	private int velocity_X = 23;
	private int velocity_Y = 23;
	Color player = Color.RED;

	public void setPositionX(int x) {
		this.player_X_CoOrdinate = x;
	}

	// Sets Y-coOrdinate of the player
	public void setPositionY(int y) {
		this.player_Y_CoOrdinate = y;
	}

	// Returns players name
	public String getPlayerName() {

		return this.name;
	}
	public void setPlayerName(String name) {
		setPlayer(name);
		this.name = name;
	}
	// Function to return players X co-ordinate
	public int getPlayerPositionX() {
		return this.player_X_CoOrdinate;
	}

	// function to return players Y co-ordinate
	public int getPlayerPositionY() {
		return this.player_Y_CoOrdinate;
	}

	// Function to move the players over the board
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D c = new Ellipse2D.Double(player_X_CoOrdinate,player_Y_CoOrdinate, 23, 23);
		g2.setColor(player);
		g2.fill(c);
	}

	public void setPlayer(String playerName) {
		switch(playerName) {
		case "Scarlet":{
			player = Color.RED;
			break;
		}
		case "White":{
			player = Color.WHITE;
			break;
		}
		case "Peacock":{
			player = Color.BLUE;
			break;
		}
		case "Green":{
			player = Color.GREEN;
			break;
		}
		case "Mustard":{
			player = Color.YELLOW;
			break;
		}
		case "Plum":{
			player = Color.MAGENTA;
			break;
		}
		case "Brown":{
			player = Color.BLACK;
			break;
		}
		default:{
			System.out.println("Player could not be assigned Color: setPlayerName");
			System.exit(0);
		}
		}
	}
	
	public void move(String movementType) {
		
		switch(movementType) {
		case "U":{
			if(player_Y_CoOrdinate>0)
				player_Y_CoOrdinate -= velocity_Y;
			break;
			
		}
		case "D":{
			if(player_Y_CoOrdinate<23*24)
				player_Y_CoOrdinate += velocity_Y;
			break;
		}
		case "R":{
			if(player_X_CoOrdinate<23*23)
				player_X_CoOrdinate+= velocity_X;
			break;
		}
		case "L":{
			if(player_X_CoOrdinate>0)
				player_X_CoOrdinate -= velocity_X;
			break;
		}
		}
		repaint();
	}
}

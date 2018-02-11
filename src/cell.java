import java.awt.Dimension;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class cell {
	private boolean door;
	private String room;
	private String type;
	private boolean player;
	private int x1;
	private int x2;
	private int y1;
	private int y2;

	// constructor method for cell
	public cell(boolean door, boolean player, String type, int a1, int b1, int a2, int b2) {
		this.door = door;
		this.type = type;
		this.player = player;
		x1 = a1;
		x2 = a2;
		y1 = b1;
		y2 = b2;
		int size = 23;
	}

	// making a set of blocks a room on the map
	public void setRoom(String s) {
		room = s;
	}

	// Getter method for rooms
	public String getRoom() {
		return room;
	}

	// Returns type of room, i.e cellar etc
	public String getType() {
		return this.type;
	}

	// making a block a room
	public void setDoor(boolean t) {
		door = t;
	}

	// returns if a certain block is a room or not
	public boolean getDoor() {
		return door;
	}

	// returns player
	public boolean getPlayer() {
		return this.player;
	}

	// returns X1
	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

}

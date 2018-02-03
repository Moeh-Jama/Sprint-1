import java.util.*;
public class Cell {
	private boolean door;
	private String room;
	private String type;
	private boolean player;
	private int x1;
	private int x2;
	private int y1;
	private int y2;

	public Cell(boolean door,boolean player,String type, int a1, int b1,int a2, int b2){
		this.door=door;
		this.type=type;
		this.player=player;
		x1 = a1;
		x2 = a2;
		y1 = b1;
		y2 = b2;
	}
	
	public void setRoom(String s)
	{
		room = s;
	}
	public String getRoom() {
		return room;
	}
	
	public String getType(){
		return this.type;
	}
	public void setDoor(boolean t) {
		door = t;
	}
	public boolean getDoor(){
		return door;
	}
	public boolean getPlayer(){
		return this.player;
	}

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

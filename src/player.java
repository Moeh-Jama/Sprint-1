import java.util.*;
public class player {
	private String name;
	private int x;
	private int y;
	
	public player(String name, int a,int b){
		this.x=a;
		this.y=b;
		this.name=name;
	}
	
	public String getPlayerName(){
		return this.name;
	}
	public int getPlayerX(){
		return this.x;
	}
	public int getPlayerY(){
		return this.y;
	}
}

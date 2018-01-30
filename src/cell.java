import java.util.*;
public class cell {
	public boolean door;
	public String type;
	public boolean player;

	public cell(boolean door,boolean player,String type){
		this.door=door;
		this.type=type;
		this.player=player;
	}
	
	public String getType(){
		return this.type;
	}
	public boolean getDoor(){
		return door;
	}
	public boolean getPlayer(){
		return this.player;
	}
}

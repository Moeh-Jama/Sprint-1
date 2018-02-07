import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameProperties {
	/*
	 * This class will hold all the important game properties such as 
	 * number of characters, weapons rooms and such it will deal with all the calculations
	 * 
	 */
	private int height = 574;
	private int width = 552;

	
	
	
	private Cell[][] game_board;// = new Cell[25][25];
	private ArrayList<String> door_positions = new ArrayList<String>();
	
	
	
	
	
	
	
	
	
	
	
	public void makeGameBoard() {
		game_board = new Cell[25][25];
		createArrayListGrid();
	}
	
	public void makeDoorPositions() {
		readDoors();
		createDoorsGrid();
	}
	public Cell getBoardPos(int x, int y) {
		return game_board[x][y];
	}
	
	private void createArrayListGrid() {
		int iterationx = 0;
		int steps = 23;
		for(int i=0; i<getPanelHeight(); i+=steps)
		{
			//System.out.println(iteration+", "+i);
			int iterationy =0;
			for(int j =0; j<getPanelWidth(); j+=steps)
			{
				//In order to calculate where the user is in get all corner and their
				// x,y coordinates.
				int x1 = i;
				int x2 = i+steps;
				int y1 = j;
				int y2 = j+steps;
				// get the mid points of each axis
				int mid1 = (x1+x2)/2;
				int mid2 = (y1+y2)/2;
				// This should give us the mid point of each cell and reduces any
				// irregular points. I.e. a point being behind or after a grid line.
				
				Cell temp = new Cell(false, false, "NA", x1, y1, x2, y2);
				
				//System.out.println(iterationx+","+iterationy);
				game_board[iterationx][iterationy] = temp;

				
				// The room is now assigned to the grid cell.
				game_board[iterationx][iterationy].setRoom(Room.GetRoom(mid1, mid2));
				iterationy++;
			}
			
			iterationx++;
		}
	}
	
	
	
	private void readDoors() {
		// Get the the information from the Doors.txt file and place them into doors_positions
		File path = new File("");
		String absolutePathOfDoors = path.getAbsolutePath()+"\\src\\Doors.txt";
		System.out.println(absolutePathOfDoors);
		FileReader n = null;
		try {
			n = new FileReader(absolutePathOfDoors);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Doors does not exist!");
			//e.printStackTrace();
		}
		Scanner in = new Scanner(n);
		
		BufferedReader k = new BufferedReader(n);
		String line = null;
		
		try {
			while((line = k.readLine()) != null)
			{
				Scanner input = new Scanner(line);
				door_positions.add(line);
				//System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createDoorsGrid() {
		/*
		 * No inputs or outputs.
		 * sets true to all positions on the game_board that have a door
		 * according to the door_positions array.
		 */
		for(String s: door_positions) {
			String[] XsYs = s.split(", ");
			int x = Integer.parseInt(XsYs[0]);
			int y = Integer.parseInt(XsYs[1]);
			//System.out.println(XsYs[0]+"\t"+XsYs[1]);
			game_board[x][y].setDoor(true);;
		}
	}
	
	
	public int getPanelHeight() {
		return height;
	}
	public int getPanelWidth() {
		return width;
	}
	
	
	
}

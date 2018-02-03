import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Board extends JFrame{
	private int Height = 640;
	private int Width = 638;
	private JPanel panel = new JPanel();
	private ArrayList<String> doorCoordinates = new ArrayList<String>();
	private Cell[][] panel_grid = new Cell[25][25];
	public Board() {
		//The main Board Interface.
		this.setTitle("Cluedo Board");
		this.setSize(Height, Width);
		// The main 23*23 grid panel is created.
		createDoors();
		createGridPanel();
		displayImage();
		createDoorsGrid();

		
		//this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	//	System.out.println("END");
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
				
				
				panel_grid[iterationx][iterationy] = temp;
				
				// The room is now assigned to the grid cell.
				panel_grid[iterationx][iterationy].setRoom(Room.GetRoom(mid1, mid2));
				iterationy++;
			}
			
			iterationx++;
		}
	}

	private void createDoors() {
		FileReader n = null;
		try {
			n = new FileReader("C:\\Users\\kalto\\eclipse-workspace\\Sprint_1\\src\\Doors.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner in = new Scanner(n);
		
		BufferedReader k = new BufferedReader(n);
		String line = null;
		
		try {
			while((line = k.readLine()) != null)
			{
				Scanner input = new Scanner(line);
				doorCoordinates.add(line);
				//System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createDoorsGrid() {
		for(String s: doorCoordinates) {
			String[] XsYs = s.split(", ");
			int x = Integer.parseInt(XsYs[0]);
			int y = Integer.parseInt(XsYs[1]);
			//System.out.println(XsYs[0]+"\t"+XsYs[1]);
			panel_grid[x][y].setDoor(true);;
		}
	}
	
	private void createGridPanel() {
		
		panel.setSize((int) (Width * 0.8655), (int)(Height * 0.898));
		//panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		//Making the background set.
		panel.setOpaque(false);
		//The panel is set to the middle of the board.
		int x = 34;
		int y = 3;
		panel.setLocation(x, y);
		
		//System.out.println("The size of the Plane: "+panel.getSize());
		ListenToJPanel lpanel = new ListenToJPanel();
		
		panel.addMouseListener(lpanel);
		this.add(panel);//, BorderLayout.CENTER);
		createArrayListGrid();
	}
	private int getPanelHeight() {
		return panel.getSize().height;
	}
	private int getPanelWidth() {
		return panel.getSize().width;
	}
	private void displayImage() {
		//ImageIcon icon = new ImageIcon(".\\image\\CluedBoard.jpg");
		ImageIcon icon = new ImageIcon("src/image/CluedBoard.jpg");
		this.add(new JLabel(icon));
	}
	private void drawInGridPanel() {
		
	}
		

	
	
	private class ListenToJPanel implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			int px = panel.getMousePosition().y;
			int py = panel.getMousePosition().x;
			
			//Get the grid positions in x and y coordinates.
			int x = px/23;
			int y = py/ 23;
			System.out.println("Room: "+panel_grid[x][y].getRoom());
			System.out.println("Door: "+panel_grid[x][y].getDoor());
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
}

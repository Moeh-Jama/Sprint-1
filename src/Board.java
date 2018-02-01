import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Board extends JFrame{
	private int Height = 640;
	private int Width = 638;
	private JPanel panel = new JPanel();
	private ArrayList<Cell> grid = new ArrayList<Cell>();
	private Cell[][] newGrid = new Cell[24][24];
	public Board() {
		//The main Board Interface.
		this.setTitle("Cluedo Board");
		this.setSize(Height, Width);
		// The main 23*23 grid panel is created.
		createGridPanel();
		displayImage();
		

		
		//this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	//	System.out.println("END");
	}
	
	private void createArrayListGrid() {
		int iterationx = 0;
		for(int i=0; i<getPanelHeight(); i+=24)
		{
			//System.out.println(iteration+", "+i);
			int iterationy =0;
			for(int j =0; j<getPanelWidth(); j+=24)
			{
				Cell temp = new Cell(false, false, "NA", j, i, j+24, i+24);
				if(j==0) {
					//System.out.println("("+j+","+i+")"+"\t"+"("+(j+24)+", "+(i+24)+")");
				}
				
				System.out.println("["+iterationx+","+iterationy+"]"+"\n"+Room.GetRoom(j, i)+"\t"+i+","+j);
				temp.setRoom(Room.GetRoom(j, i));
				grid.add(temp);
				//System.out.println();
				newGrid[iterationx][iterationy] = temp;
				iterationy++;
			}
			
			iterationx++;
		}
	}
	
	private void createGridPanel() {
		
		panel.setSize((int) (Width * 0.87), (int)(Height * 0.898));
		//panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		//Making the background set.
		panel.setOpaque(false);
		//The panel is set to the middle of the board.
		panel.setLocation((int)30, (int)3);
		
		System.out.println("The size of the Plane: "+panel.getSize());
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
		
	public void testRooms() {
		Scanner input = new Scanner(System.in);
		while (true) {
			String res = input.nextLine();
			
			if(res.equals("-1"))
			{
				break;
			}
			else {
				String[] numbers = res.split(" ");
				int x = Integer.parseInt(numbers[0]);
				int y = Integer.parseInt(numbers[1]);
				System.out.println(Room.GetRoom(x, y)+" |||| "+newGrid[x][y].getRoom());
			}
		}
	}
	
	private class ListenToJPanel implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("I was clicked");
			//System.out.println("Current Posiition isL "+panel.getMousePosition());
			int px = panel.getMousePosition().x;
			int py = panel.getMousePosition().y;
			System.out.println(px+" ___ "+py);
			System.out.println(Room.GetRoom(px, py));
			

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

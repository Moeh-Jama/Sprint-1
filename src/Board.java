import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Board extends JFrame{
	private int Height = 640;
	private int Width = 638;
	private JPanel panel = new JPanel();
	private ArrayList<Cell> grid = new ArrayList<Cell>();
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
		int iteration = 0;
		for(int i=0; i<getPanelHeight(); i+=24)
		{
			//System.out.println(iteration+", "+i);
			for(int j =0; j<getPanelWidth(); j+=24)
			{
				Cell temp = new Cell(false, false, "NA", j, i, j+24, i+24);
				if(j==0) {
					//System.out.println("("+j+","+i+")"+"\t"+"("+(j+24)+", "+(i+24)+")");
				}
				
				grid.add(temp);
			}
			
			iteration++;
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
		
	
	
	
	private class ListenToJPanel implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("I was clicked");
			//System.out.println("Current Posiition isL "+panel.getMousePosition());
			int px = panel.getMousePosition().x;
			int py = panel.getMousePosition().y;
			//System.out.println(px+" ___ "+py);
			if((px<=140) && (py<=158)) {
				System.out.println("Kitchen");
			}
			else if((py>=50 && py<=180) && (px>=195 && px<=366))
			{
				System.out.println("Ball Room");
			}
			else if((py>=0 && py<=46) && (px>=235 && px<=324))
			{
				System.out.println("Ball Room");
			}
			else if((py>=437 && py<=573) && (px>=0 && px<=163))
			{
				System.out.println("Lounge");
			}
			else if((py>=415 && py<=570) && (px>=213 && px<=346))
			{
				System.out.println("Hall");
			}
			else if((py>=180 && py<=295) && (px>=420 && px<=553))
			{
				System.out.println("Billiard Room");
			}
			else if((py>=0 && py<=112) && (px>=418 && px<=550))
			{
				System.out.println("Conservatory");
			}
			else if((py>=114 && py<=133) && (px>=442 && px<=554))
			{
				System.out.println("Conservatory");
			}
			else if((py>=232 && py<=362) && (px>=0 && px<=185))
			{
				System.out.println("Dining Room");
			}
			else if((py>=204 && py<=230) && (px>=0 && px<=115))
			{
				System.out.println("Dining Room");
			}
			else if((py>=485 && py<=573) && (px>=396 && px<=553))
			{
				System.out.println("Study");
			}
			else if((py>=322 && py<=432) &&  (px>=418 && px<=550))
			{
				System.out.println("Library");
			}
			else if((py>=345 && py<=409) && (px>=396 && px<=(396+24)))
			{
				System.out.println("Library");
			}
			else if((py>=231 && py<=387) && (px>=235 && px<=346))
			{
				System.out.println("Cellar");
			}
			else {
				System.out.println("Corridoors");
			}
			

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

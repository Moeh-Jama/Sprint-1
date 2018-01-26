package board;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Board extends JFrame{
	public static void main (String[] args)
	{
		new Board();
		Control controlPanel = new Control();
		controlPanel.panel();
		
	}
	
	public Board() {
		this.setTitle("Cluedo Board");
		this.setSize(640, 638);
		//paint(10,10,30,30);
		displayImage();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void displayImage() {
		ImageIcon icon = new ImageIcon("CluedBoard.jpg");
		this.add(new JLabel(icon));
	}
	public  void paint(int x,int y,int XSIZE,int YSIZE) {
		  Graphics g = this.getGraphics();
		  g.setColor(Color.red);
		  g.fillOval(x, y, XSIZE, YSIZE);
		  g.dispose();
		}
}

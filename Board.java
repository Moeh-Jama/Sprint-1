import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Board extends JFrame{
	private int Height = 640;
	private int Width = 638;
	
	
	public Board() {
		this.setTitle("Cluedo Board");
		this.setSize(Height, Width);
		//paint(10,10,30,30);
		makeBorder();
		displayImage();
		

		
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void makeBorder() {
		JPanel panel = new JPanel();
		panel.setSize((int) (Width * 0.87), (int)(Height * 0.898));
		//panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		//Making the background set.
		panel.setOpaque(false);
		//JLabel x = new JLabel("Hello World");
		panel.setLocation((int)30, (int)3);
		//panel.add(x);
		System.out.println(panel.getSize());
		this.add(panel);//, BorderLayout.CENTER);
	}
	private void displayImage() {
		ImageIcon icon = new ImageIcon(".\\CluedBoard.jpg");
		this.add(new JLabel(icon));
	}
	public  void paint(int x,int y,int XSIZE,int YSIZE) {
		  Graphics g = this.getGraphics();
		  g.setColor(Color.red);
		  g.fillOval(x, y, XSIZE, YSIZE);
		  g.dispose();
		}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;


public class Board extends JPanel{
	private int Height = 640;
	private int Width = 638;
	private PlayerPanel panel = new PlayerPanel();

	//private Panel panel = new Panel();
	private JLabel backgroundImage;
	
	class BigPanel extends JPanel{
		BufferedImage image;
		
		Image bg = new ImageIcon("src/image/CluedBoard.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	        g.drawImage(bg, 0, 0,getWidth()-1, getHeight()-1, this);
	    }
	}
	
	class PlayerPanel extends JPanel{
		double x=22.5*11,y=25,velX=23,velY=23;
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D) g;
			
			Ellipse2D c = new Ellipse2D.Double(x,y, 23, 23);
			g2.fill(c);
			
		}
		
		public void move(String movementType) {
			switch(movementType) {
			case "UP":{
				y -= velY;
				break;
				
			}
			case "Down":{
				y += velY;
				break;
			}
			case "Right":{
				x += velX;
				break;
			}
			case "Left":{
				x -= velX;
				break;
			}
			}
			repaint();
		}
	}
	
	
	public Board() {
		
		this.setSize(Height, Width);
		createGridPanel();
		JPanel bacgroundPanel = new BigPanel();
		bacgroundPanel.setLayout(new BorderLayout());
		bacgroundPanel.add(panel);
		bacgroundPanel.setPreferredSize(new Dimension(Height,Width));
		this.add(bacgroundPanel);
		this.setSize(Width, Height);
		//displayImage();
		
	}
	
	public void addButtonToPanel() {
		JLabel msg = new JLabel("Hello, and welcome");
		msg.setFont(new Font("Serif", Font.BOLD, 20));
		msg.setForeground(Color.ORANGE);
		msg.setLocation(500, 300);
		panel.add(msg);
		
		panel.revalidate();
	}
	
	
	
	
	
	public int getPanelHeight() {
		return panel.getSize().height;
	}
	public int getPanelWidth() {
		return panel.getSize().width;
	}
	private void displayImage() {
		//ImageIcon icon = new ImageIcon(".\\image\\CluedBoard.jpg");
		ImageIcon icon = new ImageIcon("src/image/CluedBoard.jpg");
		backgroundImage = new JLabel(icon){
			public void paint(Graphics g) {
	            super.paint(g);
	            double width = this.getSize().getWidth();
	            double height = this.getSize().getHeight();
	            g.setColor(Color.red);
	            for (int i=0; i<width; i+=height) {
	               g.drawOval(i, 0, (int) height, (int) height);
	            }
	         }
	       };
		this.add(backgroundImage);
	}
	public void movePlayer(String res) {
		panel.move(res);
	}
	
	private void createGridPanel() {
			
			panel.setSize((int) (Width * 0.8655), (int)(Height * 0.898));
			System.out.println(panel.getAlignmentX());
			//panel.setPreferredSize(new Dimension((int) (Width * 0.8655), (int)(Height * 0.898)));
			panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			System.out.println("Panel size is: "+panel.getSize());
			//Making the background set.
			panel.setOpaque(false);
			//The panel is set to the middle of the board.
			int x = 34;
			int y = 3;
			panel.setLocation(x, y);


			this.add(panel);//, BorderLayout.CENTER);
	}
	

	/*
	 * The Mouse Listener is no longer needed now.
	 */
	
	
}

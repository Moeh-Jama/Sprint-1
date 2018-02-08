import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
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
	
	private PlayerPanel[] currentPlayers = new PlayerPanel[5];
	private JPanel GameBoardPanel = new JPanel();
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
		private double x=0;
		private double y = 0;
		private int volX=23;
		private int volY=23;
		Color player = Color.RED;
		//22.5*11
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D) g;
			
			Ellipse2D c = new Ellipse2D.Double(x,y, 23, 23);
			g2.setColor(player);
			g2.fill(c);
			
			
		}
		
		public void setX(double x) { this.x = x;}
		public double getPlayerX() {return x;}
		
		public void setY(double y) {this.y = y;}
		public double getPlayerY() {return y;}
		
		public void setPlayer(String playerName) {
			switch(playerName) {
			case "Example1":{
				player = Color.RED;
			}
			case "Example2":{
				player = Color.BLUE;
			}
			default:{
				System.out.println("Player could not be assigned Color: setPlayerName");
				System.exit(0);
			}
			}
		}
		
		public void move(String movementType) {
			switch(movementType) {
			case "UP":{
				y -= volY;
				break;
				
			}
			case "Down":{
				y += volY;
				break;
			}
			case "Right":{
				x += volX;
				break;
			}
			case "Left":{
				x -= volX;
				break;
			}
			}
			repaint();
		}
	}
	
	
	public Board() {
		createGridPanel();
		this.setSize(Height, Width);
		//this.setSize(Width, Height);
		JPanel bacgroundPanel = new BigPanel();
		bacgroundPanel.setLayout(null);
		//bacgroundPanel.setSize(Width, Height);
		//createGridPanel();
		
		bacgroundPanel.add(panel);
		bacgroundPanel.setPreferredSize(new Dimension(Height,Width));

		this.add(bacgroundPanel);

		//displayImage();
		

		
	}
	public void resizeGameBoard() {
		GameBoardPanel.setSize(50,50);
	}
	
	
	public void addButtonToPanel() {
		JLabel msg = new JLabel("Hello, and welcome");
		msg.setFont(new Font("Serif", Font.BOLD, 20));
		msg.setForeground(Color.ORANGE);
		
		panel.add(msg);
		
		panel.revalidate();
	}
	
	
	
	
	
	public int getPanelHeight() {
		return panel.getHeight();
	}
	public int getPanelWidth() {
		return panel.getSize().width;
	}

	public void movePlayer(String res) {
		panel.move(res);
	}
	
	
	private void createGridPanel() {
		/*
		 * This function sets the size of t
		 */
		int panel_width = (int) (Width * 0.8655);
		int panel_height =  (int)(Height * 0.898);
		Dimension panelSize = new Dimension(panel_width, panel_height);
		panel.setPreferredSize(panelSize);
		panel.setSize(panelSize);
		System.out.println("Panel size is: "+panel.getSize());
		
		
		//Making the background set.
		panel.setOpaque(false);
		//The panel is set to the middle of the board.
		
		

		int x = 42;
		int y = 23;
		panel.setLocation(x, y);

			
			
	}
	

	/*
	 * The Mouse Listener is no longer needed now.
	 */
	
	
}

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
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;


public class Board extends JPanel{
	private int Height = 640;
	private int Width = 638;
	//private PlayerPanel panel = new PlayerPanel();
	
	private Player[] currentPlayers = new Player[6];
	private Weapon[] currentWeapons = new Weapon[6];
	private JPanel GameBoardPanel = new JPanel();
	
	class BigPanel extends JPanel{
		BufferedImage image;
		
		Image bg = new ImageIcon("src/image/CluedBoard.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	        g.drawImage(bg, 0, 0,getWidth()-1, getHeight()-1, this);
	    }
	}

	
	JPanel bacgroundPanel = new BigPanel();
	public Board() {
		drawAllPlayersOnBoard();
		drawAllWeaponsOnBoard();
		this.setSize(Height, Width);
		//this.setSize(Width, Height);
		
		bacgroundPanel.setLayout(null);
		//bacgroundPanel.setSize(Width, Height);
		//createGridPanel();
		
		
		bacgroundPanel.setPreferredSize(new Dimension(Height,Width));

		this.add(bacgroundPanel);

		//displayImage();
		

		
	}
	public void resizeGameBoard() {
		GameBoardPanel.setSize(50,50);
	}
	
	public void drawAllPlayersOnBoard() {
		
		String[] starting_pos = { "0, 9", "0, 14","6, 23","19, 23","24, 7","17, 0"};
		String[] player_names = { "White", "Brown", "Peacock", "Plum", "Scarlet", "Mustard"};

		for(int i=0; i<currentPlayers.length; i++)
		{
			int y = Integer.parseInt(starting_pos[i].split(", ")[0]);
			int x = Integer.parseInt(starting_pos[i].split(", ")[1]);

			currentPlayers[i] = new Player();
			currentPlayers[i].setPositionY(y*23);
			currentPlayers[i].setPositionX(x*23);
			currentPlayers[i].setPlayerName(player_names[i]);
			playerPanelGrid(currentPlayers[i]);
			bacgroundPanel.add(currentPlayers[i]);
		}
	}

	
	public Player getPlayer(int index) {
		return currentPlayers[index];
	}
	
	public void movePlayer(String res, int player) {
		currentPlayers[player].move(res);
	}
	private Player playerPanelGrid(Player panel) {
		/*
		 * This function sets the size of t
		 */
		int panel_width = (int) (Width * 0.8655);
		int panel_height =  (int)(Height * 0.898);
		Dimension panelSize = new Dimension(panel_width, panel_height);
		panel.setPreferredSize(panelSize);
		panel.setSize(panelSize);
		//System.out.println("Panel size is: "+panel.getSize());
		
		
		//Making the background set.
		panel.setOpaque(false);
		//The panel is set to the middle of the board.
		
		

		int x = 42;
		int y = 23;
		panel.setLocation(x, y);

		return panel;
			
	}
	
	
	public void drawAllWeaponsOnBoard() {
		
		String[] starting_pos = { "5, 2", "22, 22","22, 10","10, 22","5, 22","12, 6"};
		String[] player_names = { "Rope", "Dagger", "Revolver", "Candlestick", "Wrench", "Lead Pipe"};
		
		for(int i=0; i<currentWeapons.length; i++)
		{
			int y = Integer.parseInt(starting_pos[i].split(", ")[0]);
			int x = Integer.parseInt(starting_pos[i].split(", ")[1]);
			
			currentWeapons[i] = new Weapon();
			currentWeapons[i].setWeaponY(y*23);
			currentWeapons[i].setWeaponX(x*23);
			currentWeapons[i].setName(player_names[i]);
			weaponPanelGrid(currentWeapons[i]);
			bacgroundPanel.add(currentWeapons[i]);
		}
	}
	
	private Weapon weaponPanelGrid(Weapon panel) {
		/*
		 * This function sets the size of t
		 */
		int panel_width = (int) (Width * 0.8655);
		int panel_height =  (int)(Height * 0.898);
		Dimension panelSize = new Dimension(panel_width, panel_height);
		panel.setPreferredSize(panelSize);
		panel.setSize(panelSize);
		//System.out.println("Panel size is: "+panel.getSize());
		
		
		//Making the background set.
		panel.setOpaque(false);
		//The panel is set to the middle of the board.
		
		

		int x = 42;
		int y = 23;
		panel.setLocation(x, y);

		return panel;
			
	}
	
}

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class Board extends JPanel{
	private int Height = 640;
	private int Width = 638;
	
	/*
	 * currentPlayers and currentWeapons holds all Weapon and Player token classes.
	 */
	private player[] currentPlayers = new player[6];
	private Weapon[] currentWeapons = new Weapon[6];
	private JPanel GameBoardPanel = new JPanel();
	
	class GameBackgroundJpanel extends JPanel{
		/*
		 * GameBackgroundJpanel sets the Board Jpanels background to the cluedoBoard in the 
		 * image folder.
		 */
		BufferedImage image;
		
		Image bg = new ImageIcon("src/image/CluedBoard.jpg").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	        g.drawImage(bg, 0, 0,getWidth()-1, getHeight()-1, this);
	    }
	}

	
	JPanel backgroundPanel = new GameBackgroundJpanel();
	public Board() {
		/*
		 * All Players and Weapons are drawn on the
		 * Board.
		 */
		drawAllPlayersOnBoard();
		drawAllWeaponsOnBoard();
		//Size of the Jpanel is set.
		this.setSize(Height, Width);
		//Layout is set to null so we can set the absolute positioning of each player.
		backgroundPanel.setLayout(null);
		
		//Background Panel is set to the same size as the main Board JPanel.
		backgroundPanel.setPreferredSize(new Dimension(Height,Width));

		this.add(backgroundPanel);
	}
	
	
	public void resizeGameBoard() {
		//GameBoardPanel reside.
		GameBoardPanel.setSize(50,50);
	}
	
	public void drawAllPlayersOnBoard() {
		//Player Starting positions and player names array created in appropriate order
		// to one another.
		String[] starting_pos = { "0, 9", "0, 14","6, 23","19, 23","24, 7","17, 0"};
		String[] player_names = { "White", "Brown", "Peacock", "Plum", "Scarlet", "Mustard"};

		for(int i=0; i<currentPlayers.length; i++)
		{
			//X and Y coordinates is created.
			int y = Integer.parseInt(starting_pos[i].split(", ")[0]);
			int x = Integer.parseInt(starting_pos[i].split(", ")[1]);

			currentPlayers[i] = new player();
			//Positions assigned
			currentPlayers[i].setPositionY(y*23);
			currentPlayers[i].setPositionX(x*23);
			//Player Name made
			currentPlayers[i].setPlayerName(player_names[i]);
			//JPanel set to appropriate info in playerPanelGrid
			playerPanelGrid(currentPlayers[i]);
			//added to the bagroundPanel
			backgroundPanel.add(currentPlayers[i]);
		}
	}
	
	private player playerPanelGrid(player panel) {
		/*
		 * This function sets the size of the Player Panel and correct position
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
		
		
		//Location centred to board.
		int x = 42;
		int y = 23;
		panel.setLocation(x, y);

		return panel;
			
	}
	
	public player getPlayer(int index) {
		return currentPlayers[index];
	}
	
	public void movePlayer(String res, int player) {
		currentPlayers[player].move(res);
	}

	public void moveWeapon(String res, int weapon) {
		currentWeapons[weapon].move(res);
	}

	public Weapon getWeapon(int index) {
		return currentWeapons[index];
	}

	public void drawAllWeaponsOnBoard() {
		// Weapon Starting positions and weapon names array created in appropriate order
		// to one another.
		String[] starting_pos = { "5, 2", "22, 22","22, 10","10, 22","5, 22","12, 6"};
		String[] player_names = { "Rope", "Dagger", "Revolver", "Candlestick", "Wrench", "Lead Pipe"};
		
		for(int i=0; i<currentWeapons.length; i++)
		{
			//X and Y coordinates is created.
			int y = Integer.parseInt(starting_pos[i].split(", ")[0]);
			int x = Integer.parseInt(starting_pos[i].split(", ")[1]);
			
			currentWeapons[i] = new Weapon();
			//Positions assigned
			currentWeapons[i].setWeaponY(y*23);
			currentWeapons[i].setWeaponX(x*23);
			//Player Name assigned
			currentWeapons[i].setName(player_names[i]);
			//JPanel set to appropriate info in weaponPanelGrid
			weaponPanelGrid(currentWeapons[i]);
			
			//added to the bagroundPanel
			backgroundPanel.add(currentWeapons[i]);
		}
	}
	
	private Weapon weaponPanelGrid(Weapon panel) {
		/*
		 * This function sets the size of the properties of the weapon
		 * JPanel.
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

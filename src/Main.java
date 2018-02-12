
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/*
 * Project: Cluedo.
 * Version: Sprint-1
 * Team Name: esketit
 * Authors: JingYuan Tan,
 * 			Mohamed Jama,
 * 			Rahul Praveen.
 * 
 * 
 * Original repository on GitHub: 	https://github.com/Moeh-Jama/Sprint-1
 * New repository on GitHub: 		https://github.com/UCD-COMP20050/esketit
 * 
 * Original repository: 48 commits
 * New repository:		1 commits.
 * Date: 12/02/2018
 * 
 */



public class Main {
	//Game properties, such as grid and door positions, class declared.
	private static GameProperties gp = new GameProperties();
	//JFrame Properties declared below.
	private static Board grid_board = new Board();
	private static Control controlPanel = new Control();
	private static InformationPanel info = new InformationPanel();
	static JLabel tokenName = new JLabel();
	//Weapon and Player index begins at 0
	private static int currentPlayer = 0;
	private static int currentWeapon = 0;
	
	//current Player and Weapon objects declared to null, since
	//game has not started started.
	private static Player PlayerDetails = null;
	private static Weapon WeaponDetails = null;
	
	public static void main(String[] args) {
		
		setPlayer();
		//All necessary game functionalities are implemented at first
		//such as the grid_board.s
		gameStartingOperations();

		
		/*
		 * Game Main JFrame is created and its attributes made.
		 */
		JFrame f = new JFrame();
		f.setTitle("Esketit: Cluedo Game");
		f.setSize(1100, 700);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		
		//main_game_panel is the main JPanel of the JFrame.
		//It organises all the elements of the game
		JPanel main_game_panel = new JPanel(new BorderLayout());
		
		/*
		 * BoardGamePanel stores the Game Board.
		 */
		JPanel BoardGamePanel = new JPanel();
		JPanel rightHandSideScreen = new JPanel(new BorderLayout());
		BoardGamePanel.add(grid_board);
		
	
		//BoardGamePanel is added to the Left side of the main Game Panel.
		main_game_panel.add(BoardGamePanel, BorderLayout.WEST);
		
		
		/*
		 * rightHandSideScreen jpanel holds every component of the game on the right side of
		 * the JFrame.
		 * 
		 * Displays Players Name.
		 * Controls.
		 * Information panel
		 * 
		 */
		rightHandSideScreen.add(tokenName, BorderLayout.NORTH);
		rightHandSideScreen.add(info, BorderLayout.SOUTH);
		rightHandSideScreen.add(controlPanel, BorderLayout.CENTER);
		
		//Right Hand Side Screen is added to main Game Panel.
		main_game_panel.add(rightHandSideScreen, BorderLayout.EAST);
		
		f.add(main_game_panel);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//All components of the game is now implemented for sprint-1
	}

	public static void setToCurrentToken() {
		if(getCurrentPlayer()<6) {
			setPlayer();
		}
		else {
			setWeapon();
		}
	}
	
	
	public static int getCurrentPlayer() {
		//Returns the current index player.
		return currentPlayer;
	}
	public static int getCurrentWeapon() {
		//Returns the current index Weapon.
		return currentWeapon;
	}
	
	
	public static void setPlayer() {
		/*
		 * This function updates the JLabel PlayerName which tells which Player Token is being
		 * played at the moment.
		 */
		PlayerDetails = grid_board.getPlayer(currentPlayer%6);
		tokenName.setText("CURRENT PLAYER: "+PlayerDetails.getPlayerName());
		tokenName.setFont(new Font("Serif", Font.BOLD, 20));
		tokenName.revalidate();
	}
	
	public static void setWeapon() {
		/*
		 * This function updates the JLabel PlayerName which tells which Weapon Token is being
		 * played at the moment.
		 */
		WeaponDetails = grid_board.getWeapon(currentWeapon%6);
		tokenName.setText("CURRENT Weapon: "+WeaponDetails.getName());
		tokenName.setFont(new Font("Serif", Font.BOLD, 20));
		tokenName.revalidate();
	}
	
	public static void movePlayer(int x, int y)
	{
		/*
		 * This method moves the Player to the x and y coordinates.
		 * It also adds to the informationPanel with a message to detail where the player went from
		 * and is now to all other players in the game.
		 */
		if(getCurrentPlayer()<6) {
			
			int curr = getCurrentPlayer();
			//Get the previous x and y coordinates to display as message later.
			int p_x = PlayerDetails.getPlayerPositionX()/23;
			int p_y = PlayerDetails.getPlayerPositionY()/24;
			
			//Whil the player doesn't reach the x coordinate do the following.
			while(x!=0)
			{
				if(x<0) {
					grid_board.movePlayer("D",curr);
					x++;
				}
				else {
					grid_board.movePlayer("U",curr);
					x--;
				}
			}
			//While the player does not reach the y coordinate do the following.
			while(y!=0) {
				if(y<0) {
					grid_board.movePlayer("R",curr);
					y++;
				}
				else {
					grid_board.movePlayer("L",curr);
					y--;
				}
			}
			
			//Get the current x,y, positions of the player.
			int current_player_pos_x = PlayerDetails.getPlayerPositionX()/23;
			int current_player_pos_y = PlayerDetails.getPlayerPositionY()/24;
			//create the new message of the players updated position.
			String msg = PlayerDetails.getPlayerName()+" Went from position ("+p_x+","+p_y+") to ("+current_player_pos_x+","+current_player_pos_y+")";
			//get the previous info in the textArea.
			String previous_information = info.getTextInformation();
			//Also get the Current Room of the player.
			String room = gp.getBoardPos(current_player_pos_y,current_player_pos_x).getRoom();
			
			/*
			 * The information is now added to the info textArea.
			 */
			if(previous_information.equals(""))
				info.setTextField(msg+". ROOM: "+room);
			else
				info.setTextField(previous_information+"\n"+msg+". ROOM: "+room);
			info.revalidate();
			
			
			currentPlayer++;
			RevalidateControl();
		}
		else {
			moveWeapon(x, y);
		}
	}
	
	
	public static void moveWeapon(int x, int y)
	{
		/*
		 * This method moves the Player to the x and y coordinates.
		 * It also adds to the informationPanel with a message to detail where the player went from
		 * and is now to all other players in the game.
		 */
		if(getCurrentWeapon()<6) {
			
			int curr = getCurrentWeapon();
			int p_x = WeaponDetails.getWeaponX()/23;
			int p_y = WeaponDetails.getWeaponY()/24;
			while(x!=0)
			{
				if(x<0) {
					grid_board.moveWeapon("D",curr);
					x++;
				}
				else {
					grid_board.moveWeapon("U",curr);
					x--;
				}
			}
			while(y!=0) {
				if(y<0) {
					grid_board.moveWeapon("R",curr);
					y++;
				}
				else {
					grid_board.moveWeapon("L",curr);
					y--;
				}
			}
			//Get the current x,y, positions of the player.
			int current_weapon_pos_x = WeaponDetails.getWeaponX()/23;
			int current_weapon_pos_y = WeaponDetails.getWeaponY()/24;
			//create the new message of the players updated position.
			String msg = "Weapon: ["+WeaponDetails.getName()+"] Went from position ("+p_x+","+p_y+") to ("+current_weapon_pos_x+","+current_weapon_pos_y+")";
			//get the previous info in the textArea.
			String previous_information = info.getTextInformation();
			String room = gp.getBoardPos(current_weapon_pos_y,current_weapon_pos_x).getRoom();
			
			
			/*
			 * The information is now added to the info textArea.
			 */
			if(previous_information.equals(""))
				info.setTextField(msg+". ROOM: "+room);
			else
				info.setTextField(previous_information+"\n"+msg+". ROOM: "+room);
			info.revalidate();
			
			
			currentWeapon++;
			RevalidateControl();
			//setWeapon();
		}
		else {
			System.out.println("Game as Ended!");
			System.exit(0);
		}
	}
	
	
	public static  void gameStartingOperations() {
		/*
		 * These are the operations that must be created before any interface is made.
		 */
		gp.makeGameBoard();
		gp.makeDoorPositions();
	}
	
	public static void RevalidateBoard() {
		grid_board.revalidate();
	}
	public static void RevalidateControl() {
		setToCurrentToken();
		controlPanel.ReEnableAll();
	}
	
}

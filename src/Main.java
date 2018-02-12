
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main {
	private static GameProperties gp = new GameProperties();
	private static Board grid_board = new Board();
	private static Control controlPanel = new Control();
	private static InformationPanel info = new InformationPanel();
	
	static JLabel PlayerName = new JLabel();
	private static JLabel playerImg = new JLabel();
	private static int currentPlayer = 0;
	
	
	private static Player PlayerDetails = null;
	private static Weapon WeaponDetails = null;
	
	public static void main(String[] args) {
	
		setPlayer();
		gameStartingOperations();
		/*
		 * Next step is to implement the Controls to be built along side the game Board.
		 */
		
		JFrame f = new JFrame();
		f.setTitle("Esketit: Cluedo Game");
		f.setSize(1024, 700);
		f.setResizable(false);
		//f.setLocationRelativeTo(null);

		JPanel totalPanel = new JPanel(new BorderLayout());
		//b.addButtonToPanel();
		
		JPanel BoardGamePanel = new JPanel();
		JPanel leftHandSideScreen = new JPanel(new BorderLayout());
		BoardGamePanel.add(grid_board);
		
		
		info.setTextField("");
		
		totalPanel.add(BoardGamePanel, BorderLayout.WEST);
		
		
		
		leftHandSideScreen.add(PlayerName, BorderLayout.NORTH);
		leftHandSideScreen.add(info, BorderLayout.SOUTH);
		leftHandSideScreen.add(playerImg, BorderLayout.EAST);
		System.out.println(playerImg);
		leftHandSideScreen.add(new JLabel("Control Panel"));
		leftHandSideScreen.add(controlPanel, BorderLayout.CENTER);
		totalPanel.add(leftHandSideScreen, BorderLayout.EAST);
		
		f.add(totalPanel);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	/*public static void setImg() {
		File path = new File("");
		String currentPath = path.getAbsolutePath()+"\\src\\image\\";
		ImageIcon newPlayer = new ImageIcon(currentPath+PlayerDetails.getPlayerName()+".png");
		System.out.println(currentPath+PlayerDetails.getPlayerName()+".png");
		playerImg= (new JLabel(newPlayer));
	}*/
	
	public static int getCurrentPlayer() {
		
		/*info.setTextField(null);
		info.revalidate();
		info.setTextField("Currently Playing: "+PlayerDetails.getPlayerName());
		info.revalidate();*/
		return currentPlayer;
	}
	public static void setPlayer() {
		
		PlayerDetails = grid_board.getPlayer(currentPlayer%6);
		PlayerName.setText("CURRENT PLAYER: "+PlayerDetails.getPlayerName());
		PlayerName.setFont(new Font("Serif", Font.BOLD, 20));
		PlayerName.revalidate();
		/*
		setImg();
		
		playerImg.repaint();
		*/
	}
	
	public static void movePlayer(int x, int y)
	{
		
		
		int curr = getCurrentPlayer()%6;
		int p_x = PlayerDetails.getPlayerPositionX()/23;
		int p_y = PlayerDetails.getPlayerPositionY()/24;
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
		
		int current_player_pos_x = PlayerDetails.getPlayerPositionX()/23;
		int current_player_pos_y = PlayerDetails.getPlayerPositionY()/24;
		String msg = PlayerDetails.getPlayerName()+" Went from position ("+p_x+","+p_y+") to ("+current_player_pos_x+","+current_player_pos_y+")";
		String previous_information = info.getTextInformation();
		String room = gp.getBoardPos(current_player_pos_y,current_player_pos_x).getRoom();
		System.out.println(previous_information+"\n"+msg);
		if(previous_information.equals(""))
			info.setTextField(msg+". ROOM: "+room);
		else
			info.setTextField(previous_information+"\n"+msg+". ROOM: "+room);
		info.revalidate();
		RevalidateControl();
		
		currentPlayer++;
		setPlayer();
		
	}
	
	
	public static void moveWeapon(int x, int y)
	{
		
		
		int curr = getCurrentPlayer()%6;
		int p_x = PlayerDetails.getPlayerPositionX()/23;
		int p_y = PlayerDetails.getPlayerPositionY()/24;
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
		
		int current_player_pos_x = PlayerDetails.getPlayerPositionX()/23;
		int current_player_pos_y = PlayerDetails.getPlayerPositionY()/24;
		String msg = PlayerDetails.getPlayerName()+" Went from position ("+p_x+","+p_y+") to ("+current_player_pos_x+","+current_player_pos_y+")";
		String previous_information = info.getTextInformation();
		String room = gp.getBoardPos(current_player_pos_y,current_player_pos_x).getRoom();
		System.out.println(previous_information+"\n"+msg);
		if(previous_information.equals(""))
			info.setTextField(msg+". ROOM: "+room);
		else
			info.setTextField(previous_information+"\n"+msg+". ROOM: "+room);
		info.revalidate();
		RevalidateControl();
		
		currentPlayer++;
		setPlayer();
		
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
		controlPanel.ReEnableAll();
		//controlPanel
	}
	
}

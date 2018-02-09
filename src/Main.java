
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main {
	private static GameProperties gp = new GameProperties();
	private static Board b = new Board();
	private static Control controlPanel = new Control();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gameStartingOperations();
		/*
		 * Next step is to implement the Controls to be built along side the game Board.
		 */
		
		JFrame f = new JFrame();
		f.setSize(1000, 700);
		f.setLocationRelativeTo(null);
		JPanel totalPanel = new JPanel();
		//b.addButtonToPanel();
		totalPanel.add(b);
		totalPanel.add(controlPanel);
		f.add(totalPanel);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			String res = in.nextLine();
			
			if(res.equals("X")) {
				System.out.println("END");
				break;
			}
			else {
				//java.awt.Toolkit.getDefaultToolkit().beep();
				final JFXPanel fxPanel = new JFXPanel();
				File sound = new File("");
				String path = (sound.getAbsolutePath()+"\\src\\Uganda.mp3");
				Media hit = new Media(new File(path).toURI().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(hit);
				mediaPlayer.stop();
				//media[0] = mediaPlayer;
				mediaPlayer.play();
				
				b.movePlayer(res);
			}
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
		b.revalidate();
	}
	
}

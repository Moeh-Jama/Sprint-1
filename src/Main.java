
import java.util.Scanner;

import javax.swing.*;

public class Main {
	private static GameProperties gp = new GameProperties();
	private static Board b = new Board();
	
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
		b.addButtonToPanel();
		totalPanel.add(b);
	//	totalPanel.add(new Control());
		f.add(totalPanel);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

	public static  void gameStartingOperations() {
		/*
		 * These are the operations that must be created before any interface is made.
		 */
		gp.makeGameBoard();
		gp.makeDoorPositions();
	}
	
	public void RevalidateBoard() {
		b.revalidate();
	}
	
}

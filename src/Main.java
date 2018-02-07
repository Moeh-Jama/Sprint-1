
import java.util.Scanner;

import javax.swing.*;

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
		b.addButtonToPanel();
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
	
	/*public static void movePlayer(String res) {
		String[] xy  = res.split(",");
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);
		if(x>0) {
			while(x!=0) {
				b.move("Left");
				x--;
			}
		
		}
		else if(x>0) {
			while(x!=0) {
				b.move("Right");
				
				x++;
			}
		}
		
		if(y>0) {
			while(y!=0) {
				b.move("UP");
				y--;
			}
		
		}
		else if(y>0) {
			while(y!=0) {
				b.move("Down");
				
				y++;
			}
		
	}
		RevalidateBoard();
	}*/
}

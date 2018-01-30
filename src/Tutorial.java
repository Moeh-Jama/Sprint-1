import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Tutorial extends JPanel {

	
	/*public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawRect(100, 10, 30, 40);
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tutorial t = new Tutorial();
		JFrame jf = new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(600,400);
		createRect();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
	}
	
	private static void createRect() {
		Graphics g = null;
		g.setColor(Color.RED);
		g.drawRect(100, 10, 30, 40);
		//super.createRect(g);
	}

}

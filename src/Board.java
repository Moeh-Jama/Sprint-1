import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Board extends JFrame{
	private int Height = 640;
	private int Width = 638;
	private JPanel panel = new JPanel();
	
	public Board() {
		//The main Board Interface.
		this.setTitle("Cluedo Board");
		this.setSize(Height, Width);
		// The main 23*23 grid panel is created.
		createGridPanel();
		displayImage();
		

		
		//this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void createGridPanel() {
		panel.setSize((int) (Width * 0.87), (int)(Height * 0.898));
		//panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		//Making the background set.
		panel.setOpaque(false);
		//The panel is set to the middle of the board.
		panel.setLocation((int)30, (int)3);
		
		//System.out.println(panel.getSize());
		this.add(panel);//, BorderLayout.CENTER);
	}
	private int getPanelHeight() {
		return panel.getSize().height;
	}
	private int getPanelWidth() {
		return panel.getSize().width;
	}
	private void displayImage() {
		ImageIcon icon = new ImageIcon("src/image/CluedBoard.jpg");
		this.add(new JLabel(icon));
	}
}

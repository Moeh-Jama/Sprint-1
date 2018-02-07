import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	private JPanel panel = new JPanel();

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
	
	
	
	public Board() {
		
		this.setSize(Height, Width);
		createGridPanel();
		JPanel bacgroundPanel = new BigPanel();
		bacgroundPanel.setLayout(new BorderLayout());
		bacgroundPanel.add(panel);
		bacgroundPanel.setPreferredSize(new Dimension(Height,Width));
		this.add(bacgroundPanel);
		//this.setSize(Width, Height);
		//displayImage();
		
	}
	
	public void addButtonToPanel() {
		JLabel msg = new JLabel("Hello, and welcome");
		msg.setFont(new Font("Serif", Font.BOLD, 20));
		msg.setForeground(Color.ORANGE);
		panel.add(msg);
		panel.revalidate();
	}
	

	public int getPanelHeight() {
		return panel.getSize().height;
	}
	public int getPanelWidth() {
		return panel.getSize().width;
	}
	private void displayImage() {
		//ImageIcon icon = new ImageIcon(".\\image\\CluedBoard.jpg");
		ImageIcon icon = new ImageIcon("src/image/CluedBoard.jpg");
		backgroundImage = new JLabel(icon){
			public void paint(Graphics g) {
	            super.paint(g);
	            double width = this.getSize().getWidth();
	            double height = this.getSize().getHeight();
	            g.setColor(Color.red);
	            for (int i=0; i<width; i+=height) {
	               g.drawOval(i, 0, (int) height, (int) height);
	            }
	         }
	       };
		this.add(backgroundImage);
	}
	private void createGridPanel() {
			
			panel.setSize((int) (Width * 0.8655), (int)(Height * 0.898));
			//panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			
			//Making the background set.
			panel.setOpaque(false);
			//The panel is set to the middle of the board.
			int x = 34;
			int y = 3;
			panel.setLocation(x, y);


			this.add(panel);//, BorderLayout.CENTER);
	}
	

	/*
	 * The Mouse Listener is no longer needed now.
	 */
	
	
}

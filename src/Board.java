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

public class Board extends JPanel {
	private int Height = 640;
	private int Width = 638;
	private player panel = new player();

	private player[] currentPlayers = new player[6];
	private JPanel GameBoardPanel = new JPanel();
	// private Panel panel = new Panel();
	private JLabel backgroundImage;

	class BigPanel extends JPanel {
		BufferedImage image;

		Image bg = new ImageIcon("src/image/CluedBoard.jpg").getImage();

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg, 0, 0, getWidth() - 1, getHeight() - 1, this);
		}
	}

	JPanel bacgroundPanel = new BigPanel();

	public Board() {
		drawAllPlayersOnBoard();
		this.setSize(Height, Width);
		// this.setSize(Width, Height);

		bacgroundPanel.setLayout(null);
		// bacgroundPanel.setSize(Width, Height);
		// createGridPanel();

		bacgroundPanel.setPreferredSize(new Dimension(Height, Width));

		this.add(bacgroundPanel);

		// displayImage();

	}

	public void resizeGameBoard() {
		GameBoardPanel.setSize(50, 50);
	}

	public void drawAllPlayersOnBoard() {

		String[] starting_pos = { "0, 9", "0, 14", "6, 23", "19, 23", "24, 7", "17, 0" };
		// BLACK
		// RED
		// GREEN
		// ORANGE
		// YELLOW

		for (int i = 0; i < currentPlayers.length; i++) {
			int x = Integer.parseInt(starting_pos[i].split(", ")[0]);
			int y = Integer.parseInt(starting_pos[i].split(", ")[1]);
			// System.out.println);
			System.out.println("Positions of Players" + ": " + x * 23 + ", " + y * 23);
			currentPlayers[i] = new player();
			currentPlayers[i].setPositionX(x * 23);
			currentPlayers[i].setPositionY(y * 24);
			playerPanelGrid(currentPlayers[i]);
			bacgroundPanel.add(currentPlayers[i]);
		}
	}

	public void addButtonToPanel() {
		JLabel msg = new JLabel("Hello, and welcome");
		msg.setFont(new Font("Serif", Font.BOLD, 20));
		msg.setForeground(Color.ORANGE);

		panel.add(msg);
		// "0, 9", "0, 14","6, 23","19, 23","24, 7","17, 0"
		panel.revalidate();
	}

	public int getPanelHeight() {
		return panel.getHeight();
	}

	public int getPanelWidth() {
		return panel.getSize().width;
	}

	public void movePlayer(String res) {
		panel.move(res);
		// Random r = new Random();
		// currentPlayers[r.nextInt(5)].move(res);
	}

	private player playerPanelGrid(player panel) {
		/*
		 * This function sets the size of t
		 */
		int panel_width = (int) (Width * 0.8655);
		int panel_height = (int) (Height * 0.898);
		Dimension panelSize = new Dimension(panel_width, panel_height);
		panel.setPreferredSize(panelSize);
		panel.setSize(panelSize);
		// System.out.println("Panel size is: "+panel.getSize());

		// Making the background set.
		panel.setOpaque(false);
		// The panel is set to the middle of the board.

		int x = 42;
		int y = 23;
		panel.setLocation(x, y);

		return panel;

	}

	/*
	 * The Mouse Listener is no longer needed now.
	 */

}

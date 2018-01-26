package board;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Control extends JFrame implements ActionListener{
	Control(){}
	public void panel(){
		JFrame frame = new JFrame("Control");
		frame.setSize(600, 600);
		frame.setLayout(new GridLayout(3, 0));
		frame.setVisible(true);
		
		JButton roll =new JButton("Roll Dice");
		roll.setActionCommand("Roll");
		roll.addActionListener(this);
		
		frame.getContentPane().add(roll);
	}	
	
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		int result = 0;
		String setsOfMoves = "";
		if(name.equals("Roll")){	
			Dice dice[] = new Dice[2];
			for(int i=0;i<2;i++){
				dice[i] = new Dice();
				result += dice[i].value();
			}			
			setsOfMoves = JOptionPane.showInputDialog("Your dices' values are " + dice[0] + " and " + dice[1] + ", so you have " + result + " moves.");
		}
	}
}
	

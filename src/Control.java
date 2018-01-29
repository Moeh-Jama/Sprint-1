

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Control extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	private int totalNumberOfMoves = 0;
	public Control(){
		
		this.setTitle("Control Panel");
		this.setSize(600, 600);
		//this.setLayout(new GridLayout(3, 0));
		JTextArea text = new JTextArea("HELLO WORLD");
		
		this.add(text);
		
		
		panel();
		//TextField();
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public void TextField() {
		
		JTextField text = new JTextField("HELLO WORLD");
		this.revalidate();
		panel.add(text);
		System.out.println("HELLO WORLD>>>");
		//new Control();
	}
	
	public void panel(){
		
		System.out.println("1");
		JButton roll =new JButton("Roll Dice");
		roll.setActionCommand("Roll");
		roll.addActionListener(this);
		
		JButton submit = new JButton("Submit Moves");
		submit.addActionListener(this);
		panel.add(roll);
		panel.add(submit);
		//this.add(panel);
	//	this.getContentPane().add(roll);
		
	}	
	
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand();
		switch(name) {
		case "Roll":{
			int result = 0;
			String setsOfMoves = "";
			Dice dice[] = new Dice[2];
			for(int i=0;i<2;i++){
				dice[i] = new Dice();
				result += dice[i].value();
			}			
			String message = ("Your dices' values are " + dice[0].value() + " and " + dice[1].value() + ", so you have " + result + " moves.");
			JOptionPane.showMessageDialog(null, message);
			totalNumberOfMoves = result;
			TextField();
			break;
		}
		case "Submit Moves":{
			if(totalNumberOfMoves==0) {
				String errorMessage = "I'm Sorry but you must first roll a dice in order to enter this command.";
				JOptionPane.showMessageDialog(null, errorMessage, "An Error has occured", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
			}
			break;
		}
		default:{
			JOptionPane.showInputDialog(null, "An unexptected Error has Occured: Control:63", JOptionPane.ERROR_MESSAGE);
			break;
		}
		}
		
	}
}
	

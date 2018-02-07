

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

public class Control extends JPanel implements ActionListener{
	JPanel panel = new JPanel();
	private int totalNumberOfMoves = 0;
	private String move= "";
	private boolean moveSubmitted = false;
	public Control(){
		
		//this.setTitle("Control Panel");
		this.setSize(600, 600);
		
		panel();
		
		this.add(panel);
		this.setVisible(true);
		//this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public void panel(){
		//create roll button
		JButton roll = new JButton("Roll Dice");
		roll.setActionCommand("Roll");
		roll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				//to store the sum of two dice
				totalNumberOfMoves = 0; 
				int result = 0;
				Dice dice[] = new Dice[2];
				
				//roll two dice
				for(int i=0;i<2;i++){
					dice[i] = new Dice();
					result += dice[i].value();
				}			
				String message = ("Your dices' values are " + dice[0].value() + " and " + dice[1].value() + ", so you have " + result + " moves.");
				JOptionPane.showMessageDialog(null, message);
				totalNumberOfMoves = result;
				
				//disable the roll button after user had roll the dice
				roll.setEnabled(false);
			 }
		});
		
		//create submit move button
		JButton submitMove = new JButton("Submit Moves");
		submitMove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int x = 0;
				int y = 0;
				//to check if the moves set that the user insert is valid
				boolean validMove;
				if(totalNumberOfMoves == 0) {
					String errorMessage = "Please roll a dice first in order to make your move.";
					JOptionPane.showMessageDialog(null, errorMessage, "An Error has occured", JOptionPane.ERROR_MESSAGE);
				}else {
					do{
						validMove = false;
						String moves = JOptionPane.showInputDialog("Please insert your move > ");
						String [] splited = moves.split("");
						
						//to check if the user insert the same number of moves compare to the sum of the two dice
						if(splited.length != totalNumberOfMoves){
							JOptionPane.showMessageDialog(null, "Invalid number of moves, you have " + totalNumberOfMoves + " moves.", "An Error has occured", JOptionPane.ERROR_MESSAGE);
						}else{
							//to check for invalid input from users
							for(int i=0;i<splited.length;i++){
								if(!splited[i].equalsIgnoreCase("U") && !splited[i].equalsIgnoreCase("D")
									&& !splited[i].equalsIgnoreCase("L")&& !splited[i].equalsIgnoreCase("R")){
									JOptionPane.showMessageDialog(null, "Invalid input. All input should only contain\n" + "U = UP\nD = DOWN\nL = Left\nR = Right", "An Error has occured", JOptionPane.ERROR_MESSAGE);
									break;
								}
								else{
									validMove = true;
								}
							}
							
							//x and y coordinates operation here
							for(int i=0;i<splited.length;i++){
								if(splited[i].equalsIgnoreCase("U")){
									x++;
									
								}else if(splited[i].equalsIgnoreCase("D")){
									x--;
									
								}else if(splited[i].equalsIgnoreCase("L")){
									y++;
									
								}else if(splited[i].equalsIgnoreCase("R")){
									y--;
								}
							}
						}
						
					}while(!validMove);
				}
				//disable the submit move button
				submitMove.setEnabled(false);
				moveSubmitted = true;
				String newString = Integer.toString(x)+","+Integer.toString(y);
				System.out.println(newString);
				move = newString;
			 }
		});
		
		//add buttons into the control panel
		panel.add(roll);
		panel.add(submitMove);
	}	
	public String getMove() {
		if(!moveSubmitted)
			return "wrong,wrong";
		return move;
	}
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand();
		switch(name) {
		/*case "Roll":{
			
			
		}
		case "Submit Moves":{
			
		}*/
		default:{
			JOptionPane.showInputDialog(null, "An unexptected Error has Occured: Control:63", JOptionPane.ERROR_MESSAGE);
			break;
		}
		}
		
	}
}
	

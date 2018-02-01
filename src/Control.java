

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
		
		panel();
		
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	/*public void TextField() {
		
		JTextField text = new JTextField("HELLO WORLD");
		this.revalidate();
		panel.add(text);
		System.out.println("HELLO WORLD>>>");
	}*/
	
	public void panel(){
		JButton roll = new JButton("Roll Dice");
		roll.setActionCommand("Roll");
		roll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				totalNumberOfMoves = 0;
				int result = 0;
				Dice dice[] = new Dice[2];
				for(int i=0;i<2;i++){
					dice[i] = new Dice();
					result += dice[i].value();
				}			
				String message = ("Your dices' values are " + dice[0].value() + " and " + dice[1].value() + ", so you have " + result + " moves.");
				JOptionPane.showMessageDialog(null, message);
				totalNumberOfMoves = result;
				roll.setEnabled(false);
			 }
		});
		
		
		JButton submitMove = new JButton("Submit Moves");
		submitMove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				boolean validMove;
				if(totalNumberOfMoves == 0) {
					String errorMessage = "Please roll a dice first in order to make your move.";
					JOptionPane.showMessageDialog(null, errorMessage, "An Error has occured", JOptionPane.ERROR_MESSAGE);
				}else {
					do{
						validMove = false;
						String moves = JOptionPane.showInputDialog("Please insert your move > ");
						String [] splited = moves.split("");
						if(splited.length != totalNumberOfMoves){
							JOptionPane.showMessageDialog(null, "Invalid number of moves, you have " + totalNumberOfMoves + " moves.", "An Error has occured", JOptionPane.ERROR_MESSAGE);
						}else{
							//to check for invalid input
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
							
							for(int i=0;i<splited.length;i++){
								if(splited[i].equalsIgnoreCase("U")){
									
								}else if(splited[i].equalsIgnoreCase("D")){
									
								}else if(splited[i].equalsIgnoreCase("L")){
									
								}else if(splited[i].equalsIgnoreCase("R")){
									
								}
							}
						}
						
					}while(!validMove);
				}
				submitMove.setEnabled(false);
			 }
		});
		
		panel.add(roll);
		panel.add(submitMove);
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
	

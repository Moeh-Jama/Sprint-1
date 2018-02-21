


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Control extends JPanel implements ActionListener{
	JPanel panel = new JPanel();
	private int totalNumberOfMoves = 0;
	private JButton submitCommand = null;
	private JTextArea commandPanel = null;
	private boolean moveSubmitted = false;
	private boolean isDone = false;
	private int x = 0, y = 0;
	
	public Control(){
		
		//this.setTitle("Control Panel");
		this.setSize(600, 600);
		
		panel();
		this.add(panel);
		this.setVisible(true);
		//this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public void panel(){
		commandPanel = new JTextArea(2,20);		
		submitCommand = new JButton("Confirm");
		
		submitCommand.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String command = commandPanel.getText();
				if(command.equalsIgnoreCase("roll")){
					//to store the sum of two dices
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
					commandPanel.setText(null);
				}
				else if(command.equalsIgnoreCase("quit")){
					//exit game
					System.exit(1);
				}
				else if(command.equalsIgnoreCase("done")){
					//ends player's turn
					Main.endTurn();
				}
				else{
					x = 0;
					y = 0;
					//to check if the moves set that the user insert is valid
					boolean validMove = true;
					if(totalNumberOfMoves == 0) {
						String errorMessage = "Please roll a dice first in order to make your move.";
						JOptionPane.showMessageDialog(null, errorMessage, "An Error has occured", JOptionPane.ERROR_MESSAGE);
						validMove = false;
					}
					else {
						String moves = command;
						String [] splited = moves.split(" ");
						
						//to check if the user insert the same number of moves compare to the sum of the two dice
						if(splited.length != totalNumberOfMoves){
							JOptionPane.showMessageDialog(null, "Invalid number of moves, you have " + totalNumberOfMoves + " moves.", "An Error has occured", JOptionPane.ERROR_MESSAGE);
							validMove = false;
						}
						else{
							//to check for invalid input from users
							for(int i=0;i<splited.length;i++){
								if(!splited[i].equalsIgnoreCase("U") && !splited[i].equalsIgnoreCase("D") && !splited[i].equalsIgnoreCase("L")&& !splited[i].equalsIgnoreCase("R")){
									JOptionPane.showMessageDialog(null, "Invalid input. All input should only contain\n" + "U = UP\nD = DOWN\nL = Left\nR = Right", "An Error has occured", JOptionPane.ERROR_MESSAGE);
									validMove = false;
									break;
								}
							}
							
							if(validMove){
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
								
								//moveSubmitted = true;
								String newString = Integer.toString(x)+","+Integer.toString(y);
								System.out.println(newString);
								
								//move = newString;
								Main.movePlayer(x, y);
								commandPanel.setText(null);
							}
						}
					}
					
					
				}
			 }
		});
		
		//add features into the control panel
		panel.add(commandPanel);
		panel.add(submitCommand);
	}	
	public int[] getMove(int x_in, int y_in) {
		int newCoordinates[] = new int[2];
		if(!moveSubmitted){
			/*return "wrong,wrong";*/
		}
		else{
			x_in += x;
			y_in += y;
			newCoordinates[0] = x_in;
			newCoordinates[1] = y_in;
		}
		return newCoordinates;
	}
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand();
		switch(name) {
			default:{
				JOptionPane.showInputDialog(null, "An unexptected Error has Occured: Control:63", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
	}
	
	public void ReEnableAll() {
		/*roll.setEnabled(true);
		submitMove.setEnabled(false);*/
		totalNumberOfMoves = 0;
		commandPanel.setText(null);
	}

}
	

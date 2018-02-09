import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class differentApproachInnerClasses extends JFrame{
	
	public static void main(String[] args)
	{
		
		new differentApproachInnerClasses();
	}	
	
	public differentApproachInnerClasses() {
		this.setSize(300, 300);
		ListenForButtons lbtn = new ListenForButtons();
		
		JButton roll = new JButton("Roll Dice");
		roll.addActionListener(lbtn);
		
		
		JButton submitMove = new JButton("Submit Move");
		submitMove.addActionListener(lbtn);
		
		JPanel pane = new JPanel();
		pane.add(roll);
		pane.add(submitMove);
		this.add(pane);
		this.setVisible(true);
		
	}
	
	
	
	private class ListenForButtons implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			String button = e.getActionCommand();
			switch(button) {
			case "Roll Dice":{
				//Do this
				break;
			}
			case "Submit Move":{
				//Do some else.
				break;
			}
			}
			
	}
		
	}
}

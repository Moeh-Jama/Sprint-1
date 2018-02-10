import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InformationPanel extends JPanel{
	private JTextArea Information=new JTextArea();
	public InformationPanel(){
		this.add(Information);
	}
	public void setTextField(String text){
		Information.setText(text);
	}
	public String getTextInformation(){
		return Information.getText();
	}
}

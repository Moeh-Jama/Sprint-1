package board;

public class Dice {
	private int faceValue;
    
    public void roll() {
    	faceValue = 1 + (int)(Math.random()*6.0);
    }
    
    public int value(){
    	return faceValue;
    }
    
    public Dice(){
    	roll();
    }
}
    


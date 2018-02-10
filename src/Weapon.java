public class Weapon {
	private int weaponX;
	private int weaponY;
	private String name;
	
	public Weapon(String name, int x, int y) {
		setName(name);
		setWeaponX(x);
		setWeaponY(y);
	}
	
	
	public int getWeaponX(){
		return this.weaponX;
	}
	
	public int getWeaponY(){
		return this.weaponY;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setWeaponX(int x){
		this.weaponX = x;
	}
	
	public void setWeaponY(int y){
		this.weaponY = y;
	}
	
	public void calculateCoordinates(int x, int y){
		weaponX += x;
		weaponY += y;
	}

}

package a6adept;
/*
 * Coordinate object class that holds x,y location values
 */
public class Coordinate {
	
	private int x;
	private int y;
	/*
	 * Constructor that sets and holds x and y values
	 */
	public Coordinate (int x, int y){
		this.x=x;
		this.y=y;
	}
	
	/*
	 * Returns x parameter
	 */
	public int getX(){
		return x;
	}
	
	/*
	 * Returns y parameter
	 */
	public int getY(){
		return y;
	}

}

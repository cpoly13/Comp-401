package a6jedi;
import java.util.Iterator;
import java.util.NoSuchElementException;
/*
 * Iterator object class that "skips" over pixels in picture
 * by argument set parameters
 * Author: Chris Polychronides
 */
public class SkippingIterator implements Iterator<Pixel> {
	Picture pic;
	int x;
	int y;
	int init_x;
	int init_y;
	int dx;
	int dy;
	/*
	 * Constructor that sets fields based on arguments passed in
	 */
	SkippingIterator(Picture pic, int init_x, int init_y, int dx, int dy){
		this.pic=pic;
		this.init_x=init_x;
		this.init_y=init_y;
		this.dx=dx;
		this.dy=dy;
		x=init_x-1; //subtracts 1 in order to start at correct location in next method
		y=init_y;
	}
	/*
	 * Checks whether picture has next element
	 * Output: Boolean value of next element existence
	 */
	@Override
	public boolean hasNext() {

		if(x+dx<pic.getWidth()){
		return true;
		}
		else if(y+dy<pic.getHeight()){
			return true;
		}
		
		else {
			return false;
		}
	}
	/*
	 * Gets next pixel in skipping order
	 * Output: Pixel in next index in order
	 * Return unsupported operation exception if iterator has already reached end
	 */
	@Override
	public Pixel next() {
		
		if (x<init_x){
			x++;
			return pic.getPixel(x, y);
		}
		else if(x+dx<pic.getWidth()){
			x+=dx;
			return pic.getPixel(x, y);
		}
		else if(y+dy<pic.getHeight()){
			y+=dy;
			x=init_x;
			
			return pic.getPixel(x, y);
		}
		
		else{
				throw new NoSuchElementException();
		}
	}
	
	

}

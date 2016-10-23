package a6adept;
import java.util.Iterator;

public class SkippingIterator implements Iterator<Pixel> {
	Picture pic;
	int x;
	int y;
	int init_x;
	int init_y;
	int dx;
	int dy;
	
	SkippingIterator(Picture pic, int init_x, int init_y, int dx, int dy){
		this.pic=pic;
		this.init_x=init_x;
		this.init_y=init_y;
		this.dx=dx;
		this.dy=dy;
		x=init_x-1;
		y=init_y;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
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

	@Override
	public Pixel next() {
		// TODO Auto-generated method stub
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
				throw new UnsupportedOperationException();
		}
	}
	
	

}

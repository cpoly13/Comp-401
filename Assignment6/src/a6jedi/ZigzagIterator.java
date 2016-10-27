package a6jedi;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ZigzagIterator implements Iterator<Pixel> {
	private Picture pic;
	private int x;
	private int y;
	private boolean right=false;
	private boolean diagonalDownLeft=false;
	private boolean down=false;
	private boolean diagonalUpRight=false;
	
	
	public ZigzagIterator(Picture pic){
		this.pic=pic;
		x=-1; //so next() starts at 0
		y=0;
		right=true;
	}


	@Override
	public boolean hasNext() {
		if(x==-1){
			return true;
		}
		
		else if(x+1<pic.getWidth()){
			return true;
		}
		else if(y+1<pic.getHeight()){
			return true;
		}
		
		else {
			return false;
		}
	}

	@Override
	public Pixel next() {
		if(x==-1){
			x++;
			return pic.getPixel(x, y);
		}
		
		else if(right){
			x++;
			right=false;
			if(y==0){
				diagonalDownLeft=true;
			}
			else if(x+1<pic.getWidth()){
				diagonalUpRight=true;
			}
			
			return pic.getPixel(x, y);
		}
		
		else if(diagonalDownLeft){
			x--;
			y++;
			
			if(x-1<0){
				diagonalDownLeft=false;
				if(y+1<pic.getHeight()){
					down=true;
				}
				else{
					right=true;
				}
				
			}
			else if(y+1==pic.getHeight()){
				diagonalDownLeft=false;
				right=true;
			}
			return pic.getPixel(x, y);
		}
		
		else if(down){
			y++;
			down=false;
			
			if(x==0){
				diagonalUpRight=true;
			}
			else if(y+1<pic.getHeight()){
				diagonalDownLeft=true;
			}
			return pic.getPixel(x, y);
		}
		
		else if(diagonalUpRight){
			x++;
			y--;
			
			if(x+1==pic.getWidth()){
				diagonalUpRight=false;
				down=true;
			}
			else if(y-1<0){
				diagonalUpRight=false;
				right=true;
			}
			return pic.getPixel(x, y);
		}
		
		else{
			throw new NoSuchElementException();
		}
	
	}
	
	
}

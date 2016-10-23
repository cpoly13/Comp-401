package a6adept;

import java.util.Iterator;

public class RowMajorPixelIterator implements Iterator <Pixel> {
	
	Picture pic;
	int x;
	int y;
	int width;
	int height;
	
	public RowMajorPixelIterator(Picture pic){
		this.pic=pic;
		x=-1;
		y=0;
		width=pic.getWidth();
		height=pic.getHeight();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		if(x+1<width){
			return true;
		}
		else if(y+1<height){
			return true;
		}
		else{
		return false;
		}
	}

	@Override
	public Pixel next() {
		// TODO Auto-generated method stubb
		
		if(x+1<width){
			x++;
			return pic.getPixel(x, y);
		}
		else if( y+1<height){
			y++;
			x=0;
			return pic.getPixel(x, y);
		}
		else{
			throw new UnsupportedOperationException();
		}
		
		
	}
	
	
	

}

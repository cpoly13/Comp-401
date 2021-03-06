package a6novice;

import java.util.Iterator;



abstract public class AnyPicture implements Picture {

	protected int width;
	protected int height;

	public AnyPicture(int width, int height) {
		if (width < 0 || height < 0) {
			throw new IllegalArgumentException("Error, negative parameters");
		}

		this.width = width;
		this.height = height;

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	abstract public void setPixel(int x, int y, Pixel p);

	abstract public Pixel getPixel(int x, int y);

	public int countRange(double low, double high) {
		if (low < 0 || low > 1 || high < 0 || high > 1) {
			throw new IllegalArgumentException("Error, range out of bounds");
		}

		int count = 0;

		for (int i = 0; i < width; i++) {

			for (int n = 0; n < height; n++) {
				if (getPixel(i, n).getIntensity() >= low && getPixel(i, n).getIntensity() <= high) {
					count++;
				}
			}

		}
		return count;

	}
	
	public void print() {

		for (int i = 0; i < height; i++) {

			for (int n = 0; n < width; n++) {
				System.out.print(getPixel(n,i).getChar());

			}

			System.out.print("\n");

		}
		
		
	}
	
	public SubPicture extract(int xOffset, int yOffset, int width, int height){
		SubPicture newSub=new SubPictureImpl(this,xOffset,yOffset, width, height);
		
		return newSub;
	}
	
	public SubPicture extract(Coordinate corner_a, Coordinate corner_b) {
		int x;
		int y;
		int width;
		int height;
		
		if(corner_a.getX()>=this.width || corner_b.getX()>=this.width){
			throw new IllegalArgumentException("Coordinate out of bounds");
		}
		
		if(corner_a.getY()>=this.height || corner_b.getY()>=this.height){
			throw new IllegalArgumentException("Coordinate out of bounds");
		}
			x = corner_a.getX();
			width =Math.abs(corner_b.getX() - corner_a.getX());

			y = corner_a.getY();
			height = Math.abs(corner_b.getY() - corner_a.getY());

		
		return extract(x,y,width,height);
	}
	@Override
	public void setPixel(Coordinate c, Pixel p) {
		
		
		setPixel(c.getX(),c.getY(),p);
		
	}

	@Override
	public Pixel getPixel(Coordinate c) {
		
		return getPixel(c.getX(),c.getY());
	}
	
	@Override
	public Iterator<Pixel> iterator() {
		
		Iterator <Pixel> iterator= new RowMajorPixelIterator(this);
		return iterator;
	}

}

package a6novice;

public interface Picture extends Iterable<Pixel> {
	
	public int getWidth();
	public int getHeight();
	public void setPixel(int x, int y, Pixel p);
	public void setPixel(Coordinate c, Pixel p);
	public Pixel getPixel(int x, int y);
	public Pixel getPixel(Coordinate c);
	public int countRange(double low, double high);
	public void print();
	public SubPicture extract(int xOffset, int yOffset, int width, int height);
	public SubPicture extract (Coordinate corner_a, Coordinate corner_b );

}

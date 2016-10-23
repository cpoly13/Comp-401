package a6adept;
import java.util.Iterator;

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
	public Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy);
	public Iterator<SubPicture> window(int window_width, int window_height);
	public Iterator<SubPicture> tile(int tile_width,int tile_height);

}

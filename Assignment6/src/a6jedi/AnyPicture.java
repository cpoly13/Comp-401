package a6jedi;

import java.util.Iterator;


/*
 * Abstract Picture class with common shared picture methods
 * @Author Chris Polychronides
 */
abstract public class AnyPicture implements Picture {

	protected int width;
	protected int height;
	/*
	 * Constructor
	 * Sets width and height fields
	 */
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
	
	/*
	 * Counts amount of Pixel objects within range
	 * Input:lowest pixel intensity, highest pixel intensity
	 * Output: Count of pixels within range
	 * Returns Illegal Argument if out of bounds 
	 */
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
	/*
	 * Prints picture in row major order
	 * Output: Picture to console
	 */
	public void print() {

		for (int i = 0; i < height; i++) {

			for (int n = 0; n < width; n++) {
				System.out.print(getPixel(n, i).getChar());
			}
			
			System.out.println();
			
		}
	}
	
	/*
	 * Extracts Sub-Picture from Picture
	 * Input:Integer parameters for offset starting location and width/height for dimensions
	 * Output:SubPicture object extracted from picture
	 */
	public SubPicture extract(int xOffset, int yOffset, int width, int height) {
		SubPicture newSub = new SubPictureImpl(this, xOffset, yOffset, width, height);

		return newSub;
	}
	/*
	 * Extracts Sub-Picture from Picture
	 * Input:Coordinate objects for opposite ends of Sub-picture
	 * Output:Sub-Picture extracted between coordinate locations
	 */
	public SubPicture extract(Coordinate corner_a, Coordinate corner_b) {
		
		if(corner_a==null || corner_b==null ){
			throw new IllegalArgumentException("One or more Coordinates are null");
		}
		
		int x;
		int y;
		int width;
		int height;
		
		if(corner_a.getX()<corner_b.getX()){
		x=corner_a.getX();
		}
		else{
			x=corner_b.getX();
		}
		if(corner_a.getY()<corner_b.getY()){
		y=corner_a.getY();
		}
		else{
			y=corner_b.getY();
		}
		width=1+Math.abs(corner_b.getX()-corner_a.getX());
		height=1+Math.abs(corner_b.getY()-corner_a.getY());

		SubPicture newSub = new SubPictureImpl(this, x, y, width, height);
		return newSub;
	}
	/*
	 * Sets pixel into picture using Coordinate objects
	 * Input: Coordinate location and pixel
	 */
	@Override
	public void setPixel(Coordinate c, Pixel p) {
		
		if(c==null){
			throw new IllegalArgumentException("Coordinate can't be null");
		}
		setPixel(c.getX(), c.getY(), p);

	}
	
	/*
	 * Gets Pixel from Coordinate location using coordinate x & y values
	 * Input:Coordinate
	 * Output:Pixel from Picture
	 */
	@Override
	public Pixel getPixel(Coordinate c) {
		if(c==null){
			throw new IllegalArgumentException("Coordinate can't be null");
		}
		return getPixel(c.getX(), c.getY());
	}
	
	/*
	 * Creates general Iterator to iterate through picture
	 * Output:Iterator Object
	 */
	@Override
	public Iterator<Pixel> iterator() {
		
		Iterator<Pixel> iterator = new RowMajorPixelIterator(this);
		return iterator;
	}
	
	/*
	 * Creates sample Iterator object that iterates in skips
	 * Input:Integer parameters for starting point and skipping distance
	 * Output:Iterator object to skip through picture by parameters
	 * Returns Illegal Argument on out of bounds and negative parameters 
	 */
	public Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy) {
		if (dx <= 0 || dy <=0 || init_x < 0 || init_y < 0) {
			throw new IllegalArgumentException("Sample parameters are negative");
		}

		if (init_x >= width || init_y >= height) {
			throw new IllegalArgumentException("Sample init values are out of bounds");
		}

		Iterator<Pixel> sampleSkipper = new SkippingIterator(this, init_x, init_y, dx, dy);
		return sampleSkipper;
	}
	/*
	 * Creates window iterator object that iterates through picture with "window"
	 *  single increment window boundaries
	 * Input: width and height for window iterator
	 * Output: Window iterator
	 * Returns Illegal Argument Exception if arguments are negative or out of bounds
	 */
	public Iterator<SubPicture> window (int window_width, int window_height){
		if(window_width<=0 || window_height<=0){
			throw new IllegalArgumentException("window width/height values are negative");
		}
		
		if(window_width>width || window_height>height){
			throw new IllegalArgumentException("Window width/height out of picture bounds");
		}
		Iterator<SubPicture> subWindow= new WindowIterator (this, window_width, window_height);
		
		return subWindow;
		
	}
	/*
	 * Creates tile iterator object that iterates through picture with subsequent "tile" boundaries
	 * Input: width and height for tile iterator
	 * Output: Tile iterator
	 * Returns Illegal Argument Exception if arguments are negative or out of bounds
	 */
	public Iterator<SubPicture> tile(int tile_width, int tile_height){
		if(tile_width<=0 || tile_height<=0){
			throw new IllegalArgumentException("Tile width/height values are negative");
		}
		if(tile_width>width || tile_height>height){
			throw new IllegalArgumentException("Tile width/height out of picture bounds");
		}
		Iterator<SubPicture> subTile= new TileIterator(this,tile_width,tile_height);
		return subTile;
	}
	
	public Iterator <Pixel> zigzag(){
		Iterator <Pixel> zigzager = new ZigzagIterator(this);
		return zigzager;
	}


}

package a8;


public class ColorPixel implements Pixel {

	private double red;
	private double green;
	private double blue;
	
	private static final double RED_INTENSITY_FACTOR = 0.299;
	private static final double GREEN_INTENSITY_FACTOR = 0.587;
	private static final double BLUE_INTENSITY_FACTOR = 0.114;

	private static final char[] PIXEL_CHAR_MAP = {'#', 'M', 'X', 'D', '<', '>', 's', ':', '-', ' ', ' '};
	
	public ColorPixel(double r, double g, double b) {
		if (r > 1.0 || r < 0.0) {
			throw new IllegalArgumentException("Red out of bounds");
		}
		if (g > 1.0 || g < 0.0) {
			throw new IllegalArgumentException("Green out of bounds");
		}
		if (b > 1.0 || b < 0.0) {
			throw new IllegalArgumentException("Blue out of bounds");
		}
		red = r;
		green = g;
		blue = b;
	}
	
	@Override
	public double getRed() {
		return red;
	}

	@Override
	public double getBlue() {
		return blue;
	}

	@Override
	public double getGreen() {
		return green;
	}

	@Override
	public double getIntensity() {
		return RED_INTENSITY_FACTOR*getRed() + 
				GREEN_INTENSITY_FACTOR*getGreen() + 
				BLUE_INTENSITY_FACTOR*getBlue();
	}
	
	@Override
	public char getChar() {
		int char_idx = (int) (getIntensity()*10.0);
		return PIXEL_CHAR_MAP[char_idx];
	}
	
	public Pixel blend(Pixel p, double weight) {
		if (p == null) {
			throw new RuntimeException("Error, null input");
		}
		
		if (weight>1 || weight<0){
			throw new RuntimeException("Error, weight out of bounds");
		}

		Pixel blendPixel = new ColorPixel(p.getRed() * (1.0 - weight) + this.red * weight,
				p.getGreen() * (1.0 - weight) + this.green * weight, p.getBlue() * (1.0 - weight) + this.blue * weight);

		return blendPixel;
		
	}
	
	public Pixel lighten(double factor) {
		if (factor < 0 || factor > 1) {
			throw new RuntimeException("Error, factor out" + " of bounds");
		}

		Pixel lightTheWay = new GrayPixel(1);

		Pixel lightPixel = blend(lightTheWay, 1-factor);

		return lightPixel;

	}
	
	public Pixel darken (double factor) {
		if (factor < 0 || factor > 1) {
			throw new RuntimeException("Error, factor out" + " of bounds");
		}
		
		Pixel dimThePath=new GrayPixel(0);
		return (blend(dimThePath,1-factor));
		
	}
}

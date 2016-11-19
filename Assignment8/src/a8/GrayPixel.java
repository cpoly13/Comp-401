package a8;

public class GrayPixel implements Pixel {

	private double intensity;

	private static final char[] PIXEL_CHAR_MAP = {'#', 'M', 'X', 'D', '<', '>', 's', ':', '-', ' '};


	public GrayPixel(double intensity) {
		if (intensity < 0.0 || intensity > 1.0) {
			throw new IllegalArgumentException("Intensity of gray pixel is out of bounds.");
		}
		this.intensity = intensity;
	}

	@Override
	public double getRed() {
		return getIntensity();
	}

	@Override
	public double getBlue() {
		return getIntensity();
	}

	@Override
	public double getGreen() {
		return getIntensity();
	}

	@Override
	public double getIntensity() {
		return intensity;
	}

	@Override
	public char getChar() {
		return PIXEL_CHAR_MAP[(int) (getIntensity()*10.0)];
	}	
	
	public Pixel blend(Pixel p, double weight) {
		if (p == null) {
			throw new RuntimeException("Error, null input");
		}
		
		if (weight>1 || weight<0){
			throw new RuntimeException("Error, weight out of bounds");
		}

		Pixel blendPixel = new ColorPixel(p.getRed() * (1.0 - weight) + this.getRed() * weight,
				p.getGreen() * (1.0 - weight) + this.getGreen() * weight, p.getBlue() * (1.0 - weight) + this.getBlue() * weight);

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

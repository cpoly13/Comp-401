package a6jedi;

import java.util.Iterator;

public class PictureImpl extends AnyPicture implements Picture {
	
	private Pixel[][] pixelArray;

	public PictureImpl(int width, int height) {
		super(width, height);
		pixelArray = new Pixel[width][height];

		for (int i = 0; i < pixelArray.length; i++) {
			for (int n = 0; n < pixelArray[0].length; n++) {
				pixelArray[i][n] = new GrayPixel(0.5);
			}
		}
	}

	public void setPixel(int x, int y, Pixel p) {
		if (x < 0 || y < 0) {
			throw new RuntimeException("Error, negative parameters");
		}

		if (p == null) {
			throw new RuntimeException("Error, null reference");
		}

		pixelArray[x][height-1-y] = p;
	}

	public Pixel getPixel(int x, int y) {
		if (x < 0 || y < 0) {
			throw new RuntimeException("Error, negative parameters");
		}

		return pixelArray[x][height-1-y];

	}

}

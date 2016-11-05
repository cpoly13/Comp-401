package a6jedi;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Pixel Iterator that iterates through picture from top row
 * through bottom row
 * Author: Chris Polychronides
 */
public class RowMajorPixelIterator implements Iterator<Pixel> {

	Picture pic;
	int x;
	int y;
	int width;
	int height;

	/*
	 * Constructor that sets parameters to appropriate values
	 */
	public RowMajorPixelIterator(Picture pic) {
		this.pic = pic;
		x = -1; // Sets at -1 so that next starts at first element
		y = 0;
		width = pic.getWidth();
		height = pic.getHeight();
	}

	/*
	 * Checks if picture has another pixel element Output: boolean on whether
	 * exists
	 */
	@Override
	public boolean hasNext() {

		if (x + 1 < width) {
			return true;
		} else if (y + 1 < height) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Returns next pixel object in picture Output: Next pixel in order Returns
	 * Unsupported operation exception if no next pixel exists
	 */
	@Override
	public Pixel next() {

		if (x + 1 < width) {
			x++;
			return pic.getPixel(x, y);
		} else if (y + 1 < height) {
			y++;
			x = 0;
			return pic.getPixel(x, y);
		} else {
			throw new NoSuchElementException();
		}

	}

}

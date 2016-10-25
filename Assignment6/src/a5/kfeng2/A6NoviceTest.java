package a5.kfeng2;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6jedi.GrayPixel;
import a6jedi.RowMajorPixelIterator;
import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[] {
			"coordinateTest",
			"pictureGetPixelTest",
			"pictureExtractionTest",
			"pictureIteratorTest",
			"pictureIteratorFinishedTest",
			"pictureIteratorRemoveTest"
		};
		
		return test_names;
	}
		
	@Test
	public void coordinateTest() {
		// Test if Coordinate constructor works properly
		Coordinate c = new Coordinate(1, 2);
		assertEquals(1, c.getX());
		assertEquals(2, c.getY());
	}
	
	@Test
	public void pictureGetPixelTest() {
		// Test if both versions of getPixel work the same way
		Picture picture = new PictureImpl(80, 24);
		Pixel pixel = new ColorPixel(0.1, 0.5, 0.1);
		picture.setPixel(3, 4, pixel);
		Pixel p1 = picture.getPixel(3, 4); // Using integer values
		Pixel p2 = picture.getPixel(new Coordinate(3, 4)); // Using Coordinate object
		assertTrue(p1.equals(p2));
		assertTrue(pixel.equals(p1));
		assertTrue(pixel.equals(p2));
	}

	@Test
	public void pictureExtractionTest() {
		// Test if both versions of extract work the same way
		Picture picture = new PictureImpl(80, 24);
		
		// Define ranges
		int x1 = 3, y1 = 5, x2 = 13, y2 = 20;

		// Changes pixels around a bit
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < 24; j++) {
				Pixel pixel = new ColorPixel(i/80.0, j/24.0, 1.0);
				picture.setPixel(i,  j, pixel);
			}
		}

		// Using integer values (xOffset, yOffset, width, height)
		SubPicture pic1 = picture.extract(x1, y1, x2-x1, y2-y1);

		// Using Coordinate object
		SubPicture pic2 = picture.extract(
				new Coordinate(x1, y1),
				new Coordinate(x2, y2));

		// Since we can't compare two SubPictures directly, compare their pixels
		for (int i = 0; i < x2-x1; i++) {
			for (int j = 0; j < y2-y1; j++) {
				Pixel p1 = pic1.getPixel(i, j);
				Pixel p2 = pic2.getPixel(i, j);
				assertTrue(p1.equals(p2));
			}
		}
	}

	@Test
	public void pictureIteratorTest() {
		// Make sure the iterator traverses the pixels in row-major order
		Picture picture = new PictureImpl(80, 24);

		// Changes pixels around a bit
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < 24; j++) {
				Pixel pixel = new ColorPixel(i/80.0, j/24.0, 1.0);
				picture.setPixel(i,  j, pixel);
			}
		}

		// Get an iterator to the picture
		Iterator<Pixel> it = picture.iterator();
		
		int acc = 0;
		// Traverse the pixels (quick n dirty)
		for (int j = 0; j < 24; j++) {
			for (int i = 0; i < 80; i++) {
				acc++; // tmp
				System.out.println(acc); // debug
				System.out.println(i + ", " + j); // debug

				Pixel p1 = it.next(); // From iterator
				Pixel p2 = picture.getPixel(i, j); // From coordinates

				assertTrue(p1.equals(p2));

				System.out.println(p1); // debug
				System.out.println(p2); // debug
			}
		}

	}
	
	@Test
	public void pictureIteratorFinishedTest() {
		// Calling next() after the last pixel has been traversed should throw NoSuchElementException
		Picture picture = new PictureImpl(80, 24);
		Iterator<Pixel> it = picture.iterator();
		
		// Traverse the pixels
		while (it.hasNext()) {
			it.next();
		}

		try {
			it.next();
			fail("Did not throw NoSuchElementException");
		}
		catch (NoSuchElementException e) {
		}
	}
	
	@Test
	public void pictureIteratorRemoveTest() {
		// Calling remove() on RowMajorPixelIterator should throw UnsupportedOperationException
		Picture picture = new PictureImpl(80, 24);
		Iterator<Pixel> it = picture.iterator();

		try {
			it.remove();
			fail("Did not throw UnsupportedOperationException");
		}
		catch (UnsupportedOperationException e) {
		}
	}
}

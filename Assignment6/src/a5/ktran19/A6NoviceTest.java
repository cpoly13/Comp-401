package a5.ktran19;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

	static public String[] getTestNames() {
		String[] test_names = new String[5];

		test_names[0] = "coordinateTest";
		test_names[1] = "extractTest";
		test_names[2] = "iteratorTest";
		test_names[3] = "exceptionTest";
		test_names[4] = "zigZagTest";

		return test_names;
	}

	@Test
	public void coordinateTest() {
		Coordinate c = new Coordinate(1, 3);
		assertEquals("X value does not match X coordinate", 1, c.getX());
		assertEquals("Y value does not match y coordinate", 3, c.getY());

	}

	@Test
	public void extractTest() {
		Picture p = new PictureImpl(5, 6);
		Coordinate a = new Coordinate(1, 3);
		Coordinate b = new Coordinate(4, 4);
		SubPicture sp = p.extract(a, b);
		assertEquals(4, sp.getWidth());
		assertEquals(2, sp.getHeight());

	}

	@Test
	public void iteratorTest() {
		Picture pic = new PictureImpl(3, 3);
		Iterator<Pixel> iter = pic.iterator();
		Pixel p = iter.next();
		assertEquals(pic.getPixel(1, 1), p);
	}

	@Test
	public void exceptionTest() {
		Picture pic = new PictureImpl(3, 3);
		Iterator<Pixel> iter = pic.iterator();
		for (int i = 0; i < pic.getWidth(); i++) {
			for (int j = 0; j < pic.getHeight(); j++) {
				if (iter.hasNext()) {
					Pixel p = iter.next();
					assertEquals(pic.getPixel(i, j), p);
				} else {
					Pixel p = iter.next();
					try {
						fail("Expected NoSuchElementException");
					} catch (NoSuchElementException e) {
					}
				}
			}
		}
	}

}

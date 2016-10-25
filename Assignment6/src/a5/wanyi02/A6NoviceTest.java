package a5.wanyi02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	static public String[] getTestNames() {
		String[] test_names = new String[3];

		test_names[0] = "exampleTest";
		test_names[1] = "testSetPixel";
		test_names[2] = "testSubPicExtract";

		return test_names;
	}

	@Test
	public void exampleTest() {
	}

	@Test
	public void testSetPixel() {
		Picture p = new PictureImpl(2, 2);
		Coordinate c = new Coordinate(1, 1);
		p.setPixel(c, GREEN);
		assertEquals("set pixel does not match", p.getPixel(1, 1), GREEN);
	}

	@Test
	public void testSubPicExtract() {
		Picture p = new PictureImpl(3, 2);
		p.setPixel(0, 0, BLACK);
		p.setPixel(1, 0, BLACK);
		p.setPixel(2, 0, BLACK);
		p.setPixel(0, 1, BLACK);
		p.setPixel(1, 1, WHITE);
		p.setPixel(2, 1, WHITE);

		Coordinate upperLeft = new Coordinate(1, 0);
		Coordinate lowerRight = new Coordinate(2, 1);
		Picture sp = p.extract(upperLeft, lowerRight);

		assertEquals("sub picture extract does not match", p.getPixel(1, 0), sp.getPixel(0, 0));
		assertEquals("sub picture extract does not match", p.getPixel(2, 0), sp.getPixel(1, 0));
		assertEquals("sub picture extract does not match", p.getPixel(1, 1), sp.getPixel(0, 1));
		assertEquals("sub picture extract does not match", p.getPixel(2, 1), sp.getPixel(1, 1));
	}
}

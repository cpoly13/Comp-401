package a5.vathana;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {
	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "CoordinateTest";
		test_names[1] = "coordinateExtractTest";

		return test_names;
	}

	@Test
	public void CoordinateTest() {
		Coordinate c1 = new Coordinate(1, 2);
		Picture p1 = new PictureImpl(3, 4);
		p1.setPixel(c1, WHITE);
		assertEquals("Coordinates setters don't work", p1.getPixel(c1), WHITE);
		c1 = new Coordinate(0, 0);
		p1.setPixel(c1, BLACK);
		assertEquals("Coordinates setters don't work", p1.getPixel(c1), BLACK);
	}

	@Test
	public void coordinateExtractTest() {
		Coordinate c1 = new Coordinate(2, 2);
		Coordinate c2 = new Coordinate(3, 3);
		Picture p1 = new PictureImpl(4, 5);
		p1.setPixel(c1, GREEN);
		p1.setPixel(c2, RED);
		p1.setPixel(2, 3, BLUE);
		p1.setPixel(3, 2, WHITE);
		SubPicture s1 = p1.extract(c1, c2);
		assertEquals("Pixel from SubPicture doesn't match source", s1.getPixel(0, 0), GREEN);
		assertEquals("Pixel from SubPicture doesn't match source", s1.getPixel(1, 0), WHITE);
		assertEquals("Pixel from SubPicture doesn't match source", s1.getPixel(0, 1), BLUE);
		assertEquals("Pixel from SubPicture doesn't match source", s1.getPixel(1, 1), RED);

	}

}
package a5.micahand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;

public class A6NoviceTest {

	static public String[] getTestNames() {
		String[] test_names = new String[5];

		test_names[0] = "exampleTest";
		test_names[1] = "testPictureGettersSetters";
		test_names[2] = "testCoordinateGetterSetter";
		test_names[3] = "testExtract";
		test_names[4] = "testCoordinates";

		return test_names;
	}

	@Test
	public void exampleTest() {
	}

	@Test
	public void testPictureGettersSetters() {
		// tests to make sure Picture getters and setters work properly
		Picture pic = new PictureImpl(4, 4);
		Pixel red = new ColorPixel(1, 0, 0);
		Pixel green = new ColorPixel(0, 1, 0);
		Pixel blue = new ColorPixel(0, 0, 1);
		Pixel white = new ColorPixel(1, 1, 1);

		pic.setPixel(0, 0, blue);
		pic.setPixel(1, 0, green);
		pic.setPixel(2, 0, red);
		pic.setPixel(3, 0, white);
		pic.setPixel(0, 1, blue);
		pic.setPixel(1, 1, green);
		pic.setPixel(2, 1, red);
		pic.setPixel(3, 1, white);
		pic.setPixel(0, 2, blue);
		pic.setPixel(1, 2, green);
		pic.setPixel(2, 2, red);
		pic.setPixel(3, 2, white);

		SubPicture sub = new SubPictureImpl(pic, 2, 2, 2, 2);

		assertEquals("Your Picture getters and/or setters are no bueno", pic.getPixel(2, 2), sub.getPixel(0, 0));

	}

	@Test
	public void testCoordinateGetterSetter() {
		// tests to make sure getters and setters of Coordinate class work
		// properly
		Picture pic = new PictureImpl(4, 4);
		Coordinate test = new Coordinate(1, 2);
		Pixel pixel = new ColorPixel(1, 1, 1);
		pic.setPixel(test, pixel);

		assertEquals("Your Coordinate setters and/or getters are no bueno", pic.getPixel(test), pixel);

	}

	@Test
	public void testExtract() {
		// tests to make sure that extracted pixels are the same as initial
		// pixels
		Picture pic = new PictureImpl(4, 4);
		Pixel red = new ColorPixel(1, 0, 0);
		Pixel green = new ColorPixel(0, 1, 0);
		Pixel blue = new ColorPixel(0, 0, 1);
		Pixel white = new ColorPixel(1, 1, 1);

		pic.setPixel(0, 0, blue);
		pic.setPixel(1, 0, green);
		pic.setPixel(2, 0, red);
		pic.setPixel(3, 0, white);
		pic.setPixel(0, 1, blue);
		pic.setPixel(1, 1, green);
		pic.setPixel(2, 1, red);
		pic.setPixel(3, 1, white);
		pic.setPixel(0, 2, blue);
		pic.setPixel(1, 2, green);
		pic.setPixel(2, 2, red);
		pic.setPixel(3, 2, white);

		Coordinate test1 = new Coordinate(1, 1);
		Coordinate test2 = new Coordinate(2, 2);

		SubPicture sub = new SubPictureImpl(pic, 0, 0, 3, 3);

		assertEquals("extract doesn't work", sub.extract(test1, test2).getPixel(0, 0), sub.getPixel(1, 1));

	}

	@Test
	public void testCoordinates() {
		// tests to make sure values of Coordinates are valid
		Picture pic = new PictureImpl(4, 4);
		Pixel red = new ColorPixel(1, 0, 0);
		Pixel green = new ColorPixel(0, 1, 0);
		Pixel blue = new ColorPixel(0, 0, 1);
		Pixel white = new ColorPixel(1, 1, 1);

		pic.setPixel(0, 0, blue);
		pic.setPixel(1, 0, green);
		pic.setPixel(2, 0, red);
		pic.setPixel(3, 0, white);
		pic.setPixel(0, 1, blue);
		pic.setPixel(1, 1, green);
		pic.setPixel(2, 1, red);
		pic.setPixel(3, 1, white);
		pic.setPixel(0, 2, blue);
		pic.setPixel(1, 2, green);
		pic.setPixel(2, 2, red);
		pic.setPixel(3, 2, white);

		Coordinate test1 = new Coordinate(-1, 1);
		Coordinate test2 = new Coordinate(2, 2);

		try {
			SubPicture subpicture = pic.extract(test1, test2);
			fail("Expected IllegalArgumentException for negative coordinates");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException for negative coordinates");
		}
	}

}

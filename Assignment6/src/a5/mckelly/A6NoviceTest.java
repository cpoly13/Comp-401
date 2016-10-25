package a5.mckelly;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);

	static public String[] getTestNames() {
		String[] test_names = new String[3];

		test_names[0] = "testCoordinateGetters";
		test_names[1] = "testCoordinateSetters";
		test_names[2] = "testPixelSetter";

		return test_names;
	}

	@Test
	public void testCoordinateGetters() { // Tests coordinate getters

		Coordinate coordinateGetterTest = new Coordinate(0, 1);
		Coordinate coordinateGetterTest2 = new Coordinate(10, 100);

		// Tests X value getter
		assertEquals("Result from getX() does not match x coordinate", 0, coordinateGetterTest.getX());
		assertEquals("Result from getX() does not match x coordinate", 10, coordinateGetterTest2.getX());

		// Tests Y value getter
		assertEquals("Result from getY() does not match x coordinate", 1, coordinateGetterTest.getY());
		assertEquals("Result from getY() does not match x coordinate", 100, coordinateGetterTest2.getY());
	}

	@Test
	public void testCoordinateSetters() { // Tests coordinate setters

		Coordinate coordinateSetterTest = new Coordinate(5, 7);
		Coordinate coordinateSetterTest2 = new Coordinate(30, 87);

		// Tests X value setter
		assertEquals("Result from getX() does not match x coordinate", 5, coordinateSetterTest.getX());
		assertEquals("Result from getX() does not match x coordinate", 30, coordinateSetterTest2.getX());

		// Tests Y value setter
		assertEquals("Result from getY() does not match x coordinate", 7, coordinateSetterTest.getY());
		assertEquals("Result from getY() does not match x coordinate", 87, coordinateSetterTest2.getY());
	}

	@Test
	public void testPixelSetter() { // Tests Pixel Setter

		Picture pixelTest = new PictureImpl(5, 5);
		Picture pixelTest1 = new PictureImpl(30, 3);

		pixelTest.setPixel(2, 3, RED);
		pixelTest.setPixel(3, 2, BLUE);
		pixelTest1.setPixel(1, 1, RED);
		pixelTest1.setPixel(29, 2, BLUE);

		assertEquals("SetPixel() did not set correctly", RED, pixelTest.getPixel(2, 3));
		assertEquals("SetPixel() did not set correctly", BLUE, pixelTest.getPixel(3, 2));
		assertEquals("SetPixel() did not set correctly", RED, pixelTest1.getPixel(1, 1));
		assertEquals("SetPixel() did not set correctly", BLUE, pixelTest1.getPixel(29, 2));
	}

}

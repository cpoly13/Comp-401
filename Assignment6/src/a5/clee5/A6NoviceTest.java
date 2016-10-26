package a5.clee5;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	return new String[] { "testCoordinateGetters", "testOverloadedPictureGettersAndSetters",
		"testOverloadedPictureExtract" };
    }

    @Test
    public void testCoordinateGetters() {
	Coordinate c = new Coordinate(1, 2);

	assertEquals("Result from getX() does not match x coordinate", 1, c.getX());
	assertEquals("Result from getY() does not match y coordinate", 2, c.getY());
    }

    @Test
    public void testOverloadedPictureGettersAndSetters() {
	Coordinate c = new Coordinate(3, 9);
	Pixel pix = new ColorPixel(0.3, 0.6, 0.9);
	Picture pic = new PictureImpl(10, 10);
	pic.setPixel(c, pix);

	assertEquals("Result from pic.getPixel(c) does not match ColorPixel", pix, pic.getPixel(c));
    }

    @Test
    public void testOverloadedPictureExtract() {
	Coordinate cOne = new Coordinate(1, 1);
	Coordinate cTwo = new Coordinate(2, 2);
	Picture pic = new PictureImpl(3, 3);
	pic.setPixel(0, 0, RED);
	pic.setPixel(1, 0, RED);
	pic.setPixel(2, 0, RED);
	pic.setPixel(0, 1, GREEN);
	pic.setPixel(1, 1, BLUE);
	pic.setPixel(2, 1, WHITE);
	pic.setPixel(0, 2, BLACK);
	pic.setPixel(1, 2, BLACK);
	pic.setPixel(2, 2, RED);
	SubPicture sp = pic.extract(cOne, cTwo);

	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		pic.getPixel(1, 1), sp.getPixel(0, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		pic.getPixel(2, 1), sp.getPixel(1, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		pic.getPixel(1, 2), sp.getPixel(0, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		pic.getPixel(2, 2), sp.getPixel(1, 1));
    }
}
package a5.nwalters;

import static org.junit.Assert.assertEquals;

// import java.util.Iterator;
import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = { "coordinateConstructorTest", "coordinateGetPixelTest" };

	return test_names;
    }

    @Test // Test to make sure coordinate input and coordinate set are equal
    public void coordinateConstructorTest() {
	Coordinate c = new Coordinate(1, 1);

	assertEquals("x value does not match x value of coordinate input", 1, c.getX());
	assertEquals("y value does not match y value of coordinate input", 1, c.getY());
    }

    @Test // Test the overloaded getPixel method with coordinate as parameter
    public void coordinateGetPixelTest() {
	Coordinate c = new Coordinate(1, 1);
	Pixel pix = new ColorPixel(1, 0, 0);
	Picture p = new PictureImpl(3, 3);
	p.setPixel(c, pix);
	assertEquals("pixel is not set at correct coordinate", pix, p.getPixel(c));
    }
}

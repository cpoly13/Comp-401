package a5.ericxin;

import static org.junit.Assert.*;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Pixel;
import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;

public class A6NoviceTest {

    private static final Pixel GREEN = new ColorPixel(0, 1, 0);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "getPixelCoordTest";
	test_names[1] = "setPixelCoordTest";
	test_names[2] = "extractCoordTest";

	return test_names;
    }

    @Test
    public void getPixelCoordTest() {
	Picture pic1 = new PictureImpl(4, 20);

	Coordinate c1 = new Coordinate(7, 10);
	Coordinate c2 = new Coordinate(0, 20);

	try {
	    pic1.getPixel(c1);
	    pic1.getPixel(c2);
	    fail("Expected IllegalArgumentException for coordinate out of bounds");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

    }

    @Test
    public void setPixelCoordTest() {
	Picture pic1 = new PictureImpl(4, 20);

	Coordinate c1 = new Coordinate(7, 10);
	Coordinate c2 = new Coordinate(2, 20);
	Coordinate c3 = new Coordinate(2, 10);

	try {
	    pic1.setPixel(c1, GREEN);
	    pic1.setPixel(c2, GREEN);
	    fail("Expected IllegalArgumentException for coordinate out of bounds");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    pic1.setPixel(c3, GREEN);
	} catch (RuntimeException e) {
	    fail("Exception not expected");
	}

	assertEquals("setPixel not successfully set", pic1.getPixel(c3), GREEN);
    }

    @Test
    public void extractCoordTest() {
	Picture pic1 = new PictureImpl(10, 5);

	Coordinate c1 = new Coordinate(1, 2);
	Coordinate c2 = new Coordinate(4, 4);

	Picture subpic1 = pic1.extract(c1, c2);

	assertEquals("Incorrect width", 4, subpic1.getWidth());
	assertEquals("Incorrect height", 3, subpic1.getHeight());
    }

}

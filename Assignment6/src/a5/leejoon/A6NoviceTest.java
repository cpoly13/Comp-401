package a5.leejoon;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];
	test_names[0] = "coordinateValidTest";
	test_names[1] = "getPixelTest";
	test_names[2] = "setPixelTest";
	test_names[3] = "extractTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    // Test coordinate class parameters
    @Test
    public void coordinateValidTest() {
	Coordinate a = new Coordinate(5, 3);
	int expectedX = 5;
	int expectedY = 3;
	assertEquals(expectedX, a.getX(), 0.00001);
	assertEquals(expectedY, a.getY(), 0.00001);

    }

    // Test setPixels of coordinates
    @Test
    public void setPixelTest() {
	Picture a = new PictureImpl(10, 15);
	Coordinate c1 = new Coordinate(5, 7);
	Coordinate c2 = new Coordinate(8, 11);
	Pixel p1 = new ColorPixel(0.4, 0.3, 0.6);
	Pixel p2 = new GrayPixel(0.7);

	a.setPixel(c1, p1);
	a.setPixel(c2, p2);

	assertEquals(p1, a.getPixel(c1));
	assertEquals(p2, a.getPixel(c2));

    }

    // Test extract of coordinates
    @Test
    public void extractTest() {
	Picture a = new PictureImpl(10, 15);
	Coordinate c1 = new Coordinate(5, 7);
	Coordinate c2 = new Coordinate(8, 11);
	SubPicture aSub1 = a.extract(c1, c2);
	double precision = 0.0000001;

	// Expected values
	int width = 4;
	int height = 5;
	int xOffset = 5;
	int yOffset = 7;

	assertEquals(width, aSub1.getWidth(), precision);
	assertEquals(height, aSub1.getHeight(), precision);
	assertEquals(a, aSub1.getSource());
	assertEquals(xOffset, aSub1.getXOffset(), precision);
	assertEquals(yOffset, aSub1.getYOffset(), precision);

    }

    // Test iterators
    public void iteratorTest() {
	Picture a = new PictureImpl(10, 15);
	Coordinate c1 = new Coordinate(5, 7);
	Coordinate c2 = new Coordinate(8, 11);
	Pixel p1 = new ColorPixel(0.4, 0.3, 0.6);
	Pixel p2 = new GrayPixel(0.7);
	Iterator<Pixel> iter1 = a.iterator();
	Iterator<Pixel> iter2 = a.iterator();

	a.setPixel(c1, p1);
	a.setPixel(c2, p2);

	Pixel testing1 = null;
	Pixel testing2 = null;
	for (int i = 0; i < 76; i++) {
	    if (iter1.hasNext()) {
		testing1 = iter1.next();
	    }
	}
	for (int i = 0; i < 119; i++) {
	    if (iter2.hasNext()) {
		testing2 = iter2.next();
	    }
	}
	assertEquals(testing1, p1);
	assertEquals(testing2, p2);
    }
}

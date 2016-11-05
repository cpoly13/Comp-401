package a5.swetakar;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "testXandYInput";
	test_names[1] = "testSetPixel";
	test_names[2] = "testGetPixel";
	test_names[3] = "testExtract";
	test_names[4] = "testIterator";
	// setPixel, getPixel
	// extract, iterator
	return test_names;
    }

    @Test
    public void testSetPixel() {
	Coordinate c = new Coordinate(2, 2);
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, GREEN);
	p.setPixel(2, 1, GREEN);
	p.setPixel(0, 2, BLUE);
	p.setPixel(1, 2, BLUE);
	p.setPixel(2, 2, BLUE);

	try {
	    p.setPixel(null, GREEN);
	    fail("Expected IllegalArgumentException null Coordinate");
	} catch (RuntimeException e) {
	}

	try {
	    p.setPixel(c, null);
	    fail("Expected IllegalArgumentException null Pixel");
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate c2 = new Coordinate(4, 5);
	    p.setPixel(c2, GREEN);
	    fail("Expected IllegalArgumentException for Coordinate out of bounds");
	} catch (RuntimeException e) {
	}

	p.setPixel(c, GREEN);
	assertEquals("Pixel not set correctly in picture", p.getPixel(2, 2), GREEN);
    }

    @Test
    public void testGetPixel() {
	Coordinate c = new Coordinate(2, 2);
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, GREEN);
	p.setPixel(2, 1, GREEN);
	p.setPixel(0, 2, BLUE);
	p.setPixel(1, 2, BLUE);
	p.setPixel(2, 2, BLUE);

	try {
	    p.getPixel(null);
	    fail("Expected IllegalArgumentException null Coordinate");
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate c2 = new Coordinate(4, 5);
	    p.getPixel(c2);
	    fail("Expected IllegalArgumentException for Coordinate out of bounds");
	} catch (RuntimeException e) {
	}

	p.setPixel(c, GREEN);
	assertEquals("Pixel not retrieved correctly in picture", p.getPixel(c), GREEN);
    }

    @Test
    public void testExtract() {
	Coordinate c1 = new Coordinate(1, 1);
	Coordinate c2 = new Coordinate(2, 2);
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, GREEN);
	p.setPixel(2, 1, GREEN);
	p.setPixel(0, 2, BLUE);
	p.setPixel(1, 2, BLUE);
	p.setPixel(2, 2, BLUE);
	SubPicture sub1 = p.extract(c1, c2);
	SubPicture sub2 = p.extract(1, 1, 2, 2);
	assertEquals("Extract function not implemented correctly with coordinate arguments. - x offset",
		sub1.getXOffset(), sub2.getXOffset());
	assertEquals("Extract function not implemented correctly with coordinate arguments. - y offset",
		sub1.getYOffset(), sub2.getYOffset());
	assertEquals("Extract function not implemented correctly with coordinate arguments. - source", sub1.getSource(),
		sub2.getSource());
	assertEquals("Extract function not implemented correctly with coordinate arguments. - width", sub1.getWidth(),
		sub2.getWidth());
	assertEquals("Extract function not implemented correctly with coordinate arguments. - height", sub1.getHeight(),
		sub2.getHeight());

    }

    @Test
    public void testIterator() {
	Picture p = new PictureImpl(3, 3);
	Iterator<Pixel> iter = p.iterator();
	assertEquals("Iterator implementation is not correct", iter.hasNext(), true); // filled
										      // with
										      // gray
										      // pixels
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, GREEN);
	p.setPixel(2, 1, GREEN);
	p.setPixel(0, 2, BLUE);
	p.setPixel(1, 2, BLUE);
	p.setPixel(2, 2, BLUE);
	assertEquals("Iterator implementation is not correct", RED, iter.next());
	assertEquals("Iterator implementation is not correct", RED, iter.next());
	assertEquals("Iterator implementation is not correct", RED, iter.next());
	assertEquals("Iterator implementation is not correct", GREEN, iter.next());
	assertEquals("Iterator implementation is not correct", GREEN, iter.next());
	assertEquals("Iterator implementation is not correct", GREEN, iter.next());
	assertEquals("Iterator implementation is not correct", BLUE, iter.next());
	assertEquals("Iterator implementation is not correct", BLUE, iter.next());
	assertEquals("Iterator implementation is not correct", BLUE, iter.next());
	assertEquals("Iterator implementation is not correct", false, iter.hasNext());
	try {
	    iter.next();
	    fail("Expected IllegalArgumentException for Coordinate out of bounds");
	} catch (RuntimeException e) {
	}
    }

    @Test
    public void testXandYInput() {
	Coordinate c = new Coordinate(2, 3);
	assertEquals("X value inputed does not equal getX() value", 2, c.getX());
	assertEquals("Y value inputed does not equal getY() value", 3, c.getY());
    }

    @Test
    public void exampleTest() {
    }

}

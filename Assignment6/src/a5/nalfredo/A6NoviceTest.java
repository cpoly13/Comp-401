package a5.nalfredo;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "exampleTest";
	test_names[1] = "testCoordinateConstructor";
	test_names[2] = "testCoordinateGettersandSetters";
	test_names[3] = "testCoordinateExtract";
	test_names[4] = "testRowMajorPixelIterator";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    /*
     * Test for the Coordinate Constructor
     */
    @Test
    public void testCoordinateConstructor() {
	Coordinate c = new Coordinate(1, 2);
	assertEquals("X coordinate does not match.", 1, c.getX());
	assertEquals("Y coordinate doees not match.", 2, c.getY());

    }

    /*
     * Test for the Picture getters and setters that use Coordinate as inputs.
     * Assumes the integer getters and setters work properly, and tests the
     * overloaded version against those.
     */

    @Test
    public void testCoordinateGettersandSetters() {
	Coordinate c_0_0 = new Coordinate(0, 0);
	Coordinate c_1_1 = new Coordinate(1, 1);
	new Coordinate(2, 2);

	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	assertEquals(RED, p.getPixel(c_0_0));
	p.setPixel(c_1_1, BLUE);
	assertEquals(BLUE, p.getPixel(1, 1));

	SubPicture sub = p.extract(1, 1, 2, 2);
	sub.setPixel(1, 1, GREEN);
	assertEquals(GREEN, sub.getPixel(c_1_1));
	sub.setPixel(c_0_0, WHITE);
	assertEquals(WHITE, sub.getPixel(0, 0));

    }

    /*
     * Test the overloaded version of extract. Assumes the "original" extract
     * works properly and tests the overloaded version against it.
     */
    @Test
    public void testCoordinateExtract() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);

	Coordinate a = new Coordinate(1, 1);
	Coordinate b = new Coordinate(2, 2);

	SubPicture sub_old = p.extract(1, 1, 2, 2);
	SubPicture sub_new = p.extract(a, b);

	assertEquals(sub_old.getPixel(0, 0), sub_new.getPixel(0, 0));
	assertEquals(sub_old.getPixel(0, 1), sub_new.getPixel(0, 1));
	assertEquals(sub_old.getPixel(1, 0), sub_new.getPixel(1, 0));
	assertEquals(sub_old.getPixel(1, 1), sub_new.getPixel(1, 1));
    }

    /*
     * Test the iterator for both a picture and a subpicture. Uses an array of
     * coordinates - the order in which coordinates are set in the array
     * corresponds to row major order. Also tests for null pictures trying to
     * use the iterator.
     */
    @SuppressWarnings("null")
    @Test
    public void testRowMajorPixelIterator() {

	try {
	    Picture not_p = null;
	    not_p.iterator();
	    fail("Illegal null picture.");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    // fail("Expected IllegalArgumentException but got generic
	    // RuntimeException");
	}

	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);

	Coordinate[] coords = new Coordinate[9];
	coords[0] = new Coordinate(0, 0);
	coords[1] = new Coordinate(1, 0);
	coords[2] = new Coordinate(2, 0);
	coords[3] = new Coordinate(0, 1);
	coords[4] = new Coordinate(1, 1);
	coords[5] = new Coordinate(2, 1);
	coords[6] = new Coordinate(0, 2);
	coords[7] = new Coordinate(1, 2);
	coords[8] = new Coordinate(2, 2);

	Coordinate[] sub_coords = new Coordinate[4];
	sub_coords[0] = new Coordinate(0, 0);
	sub_coords[1] = new Coordinate(1, 0);
	sub_coords[2] = new Coordinate(0, 1);
	sub_coords[3] = new Coordinate(1, 1);

	Iterator<Pixel> p_iter = p.iterator();
	int i = 0;
	while (p_iter.hasNext()) {
	    assertEquals("Iterator for pixel at " + coords[i].getX() + " " + coords[i].getY() + " does not match.",
		    p.getPixel(coords[i]), p_iter.next());
	    i++;
	}
	try {
	    p_iter.next();
	    fail("Should be at the end of the iterator.");
	} catch (NoSuchElementException e) {
	}

	SubPicture sub = p.extract(1, 1, 2, 2);
	Iterator<Pixel> sub_iter = sub.iterator();
	int j = 0;
	while (sub_iter.hasNext()) {
	    assertEquals(
		    "Iterator for pixel at " + sub_coords[j].getX() + " " + sub_coords[j].getY() + " does not match.",
		    sub.getPixel(sub_coords[j]), sub_iter.next());
	    j++;
	}
	try {
	    sub_iter.next();
	    fail("Should be at the end of the iterator.");
	} catch (NoSuchElementException e) {
	}

    }

}

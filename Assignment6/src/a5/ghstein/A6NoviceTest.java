package a5.ghstein;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Pixel;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testCoordinateClass";
	test_names[1] = "testCoordinateClassExceptions";
	test_names[2] = "rowMajorPixelIteratorClassExceptions";

	return test_names;
    }

    @Test
    public void testCoordinateClass() {
	Coordinate c = new Coordinate(2, 3);
	assertEquals("X value does not match value given to constructor", 2, c.getX());
	assertEquals("Y value does not match value given to constuctor", 3, c.getY());
    }

    @Test
    public void testCoordinateClassExceptions() {
	try {
	    new Coordinate(-1, 3);

	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}
	try {
	    new Coordinate(3, -1);

	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

    }

    @Test
    public void rowMajorPixelIteratorClassExceptions() {
	try {
	    List<Pixel> pixel_list = new ArrayList<Pixel>();
	    pixel_list.add(new ColorPixel(.1, .1, .1));
	    pixel_list.add(new ColorPixel(.2, .2, .2));
	    pixel_list.add(new ColorPixel(0, 0, 1));
	    Iterator<Pixel> iter = pixel_list.iterator();
	    for (int i = 0; i == 5; i++) {
		Pixel next_Pixel = iter.next();
		System.out.println("The next pixel color is: " + next_Pixel.getIntensity());
	    }
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("expected no such element exception but got generic runtime exception");
	}
    }

}

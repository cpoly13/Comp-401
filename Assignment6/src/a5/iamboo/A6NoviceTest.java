package a5.iamboo;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "exampleTest";
	test_names[1] = "testSetPixelNull";
	test_names[2] = "testSetPixelOutOfBounds";
	test_names[3] = "testIterator";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void testSetPixelNull() {
	Picture p1 = new PictureImpl(10, 10);
	Coordinate c1 = new Coordinate(2, 2);
	try {
	    p1.setPixel(c1, null);
	    fail("Failed to throw exception for null pixel");
	} catch (RuntimeException e) {
	}

    }

    @Test
    public void testSetPixelOutOfBounds() {
	Picture p1 = new PictureImpl(10, 10);
	Pixel pix1 = new GrayPixel(.5);
	Coordinate c1 = new Coordinate(-1, 2);
	Coordinate c2 = new Coordinate(2, 11);
	try {
	    p1.setPixel(c1, pix1);
	    fail("Failed to throw exception for out of bounds pixel");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
	try {
	    p1.setPixel(c2, pix1);
	    fail("Failed to throw exception for out of bounds pixel");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {

	}
    }

    @SuppressWarnings("null")
    @Test
    public void testIterator() {
	Picture p1 = null;
	Picture p2 = new PictureImpl(15, 15);
	try {
	    p1.iterator();
	    fail("Failed to throw Error for null Argument");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
	try {
	    Iterator<Pixel> iter2 = p2.iterator();
	    while (iter2.hasNext()) {
		iter2.next();
	    }
	    iter2.next();
	    fail("Failed to throw error when next() called without element");
	} catch (java.util.NoSuchElementException e) {
	} catch (RuntimeException e) {
	    Assert.fail("Expected NoSuchElementException");
	}
    }
}

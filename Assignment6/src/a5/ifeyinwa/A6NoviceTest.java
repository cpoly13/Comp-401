package a5.ifeyinwa;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testCoordinates";
	test_names[1] = "testExtract";
	test_names[2] = "testIterator";

	return test_names;
    }

    @Test
    public void testCoordinates() {
	Coordinate a = new Coordinate(2, 3);
	assertEquals("X value in coordinate does not match expectation.", a.getX(), 2);
	assertEquals("Y value in coordinate does not match expectation.", a.getY(), 3);
    }

    @Test
    public void testExtract() {
	Picture p = new PictureImpl(3, 3);
	Coordinate a = new Coordinate(0, 0);
	Coordinate b = new Coordinate(2, 2);
	Coordinate c = new Coordinate(1, 1);
	p.setPixel(a, new GrayPixel(1));
	p.setPixel(b, new GrayPixel(0));

	SubPicture sp = p.extract(c, b);
	assertEquals("Pixel in upper corner does not match expectation.", p.getPixel(c), sp.getPixel(a));
	assertEquals("Pixel in bottom corner does not match expectation.", p.getPixel(b), sp.getPixel(c));
    }

    @Test
    public void testIterator() {
	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> iter = p.iterator();

	iter.next();
	iter.next();
	iter.next();
	iter.next();

	try {
	    iter.next();
	    fail("Should not iterate if there is nothing to get.");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Excpected NoSuchElementEsception but got generic RuntimeException.");
	}
    }
}

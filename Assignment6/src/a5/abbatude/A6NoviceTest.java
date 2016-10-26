package a5.abbatude;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "CoordTest";
	test_names[1] = "PixelIteratorTest";

	return test_names;
    }

    @Test
    public void CoordTest() {
	Coordinate c = new Coordinate(4, 3);
	assertEquals("getX() does not return x", 4, c.getX());
	assertEquals("getY() does not return y", 3, c.getY());
    }

    @Test
    public void PixelIteratorTest() {
	PictureImpl p = new PictureImpl(2, 2);
	Iterator<Pixel> iter = p.iterator();
	iter.next();
	iter.next();
	assertEquals(true, iter.hasNext());
	iter.next();
	iter.next();
	assertEquals(false, iter.hasNext());

    }

}

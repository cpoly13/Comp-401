package a5.mingyue;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "setPixelTest";
	test_names[1] = "getPixelTest";
	test_names[2] = "extractTest";
	test_names[3] = "iteratorTest";
	test_names[4] = "exceptionTest";

	return test_names;
    }

    @Test
    public void setPixelTest() {
	Picture pic = new PictureImpl(1, 1);
	Pixel p = new GrayPixel(0.0);
	Coordinate c = new Coordinate(0, 0);
	pic.setPixel(c, p);
	Pixel expected = pic.getPixel(c);
	assertEquals(p, expected);
	// public void setPixel(Coordinate c, Pixel p);
    }

    @Test
    public void getPixelTest() {
	Picture pic = new PictureImpl(2, 2);
	Pixel p = new GrayPixel(1.0);
	pic.setPixel(1, 1, p);
	Coordinate c = new Coordinate(1, 1);
	Pixel expected = pic.getPixel(c);
	assertEquals(p, expected);
	// public void setPixel(Coordinate c, Pixel p);
    }

    @Test
    public void extractTest() {
	Picture pic = new PictureImpl(3, 3);
	Pixel p1 = new GrayPixel(0.0);
	Pixel p2 = new GrayPixel(1.0);
	pic.setPixel(0, 0, p1);
	pic.setPixel(0, 1, p2);
	pic.setPixel(0, 2, p1);
	pic.setPixel(1, 0, p2);
	pic.setPixel(1, 1, p1);
	pic.setPixel(1, 2, p2);
	pic.setPixel(2, 0, p1);
	pic.setPixel(2, 1, p2);
	pic.setPixel(2, 2, p1);

	Coordinate corner_a = new Coordinate(1, 0);
	Coordinate corner_b = new Coordinate(2, 1);
	SubPicture sp = pic.extract(corner_a, corner_b);

	Coordinate c1 = new Coordinate(1, 0);
	Coordinate c2 = new Coordinate(0, 0);
	Coordinate c3 = new Coordinate(1, 1);
	Coordinate c4 = new Coordinate(0, 1);
	Coordinate c5 = new Coordinate(2, 0);
	Coordinate c6 = new Coordinate(2, 1);

	assertEquals(pic.getPixel(c1), sp.getPixel(c2));
	assertEquals(pic.getPixel(c3), sp.getPixel(c4));
	assertEquals(pic.getPixel(c5), sp.getPixel(c1));
	assertEquals(pic.getPixel(c6), sp.getPixel(c3));
    }

    @Test
    public void iteratorTest() {
	Picture pic = new PictureImpl(2, 2);
	Pixel p1 = new GrayPixel(0.0);
	Pixel p2 = new GrayPixel(1.0);
	Pixel p3 = new GrayPixel(0.5);
	pic.setPixel(0, 0, p1);
	pic.setPixel(0, 1, p3);
	pic.setPixel(1, 0, p2);
	pic.setPixel(1, 1, p1);
	Iterator<Pixel> iter = pic.iterator();

	assertTrue(iter.hasNext());
	assertEquals(p1, pic.getPixel(0, 0));
	assertTrue(iter.hasNext());
	assertEquals(p2, pic.getPixel(1, 0));
	assertTrue(iter.hasNext());
	assertEquals(p3, pic.getPixel(0, 1));
	assertTrue(iter.hasNext());
	assertEquals(p1, pic.getPixel(1, 1));

	/*
	 * assertEquals(p1, iter.next()); assertEquals(p2, iter.next());
	 * assertEquals(p3, iter.next()); assertEquals(p1, iter.next());
	 */
    }

    @Test
    public void exceptionTest() {
	Picture pic = new PictureImpl(2, 2);
	Pixel p1 = new GrayPixel(0.0);
	Pixel p2 = new GrayPixel(1.0);
	Pixel p3 = new GrayPixel(0.5);
	pic.setPixel(0, 0, p2);
	pic.setPixel(0, 1, p3);
	pic.setPixel(1, 0, p1);
	pic.setPixel(1, 1, p2);
	Iterator<Pixel> iter = pic.iterator();

	try {
	    iter.remove();
	    fail("No UnsupportedOperationException");
	} catch (UnsupportedOperationException a) {
	} catch (Exception a) {
	    fail("Expected UnsupportedOperationException");
	}
    }

}

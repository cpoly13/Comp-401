package a5.aaachen;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

import java.util.NoSuchElementException;
import a6novice.*;
import org.junit.Assert;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "testCoordinate";
	test_names[1] = "testIterator";
	test_names[2] = "testNoSuchElement";
	test_names[3] = "testHasNext";
	test_names[4] = "testCoordinateExtract";

	return test_names;
    }

    @Test
    public void testCoordinate() {
	Picture picture = new PictureImpl(5, 5);
	picture.setPixel(1, 1, new GrayPixel(1));
	Coordinate c = new Coordinate(1, 1);
	assertTrue("The Pixels should be the same", comparePixels(picture.getPixel(c), picture.getPixel(1, 1)));
    }

    @Test
    public void testIterator() {
	Picture picture = new PictureImpl(2, 2);
	Iterator<Pixel> p = picture.iterator();
	picture.setPixel(0, 0, new GrayPixel(0));
	picture.setPixel(0, 1, new GrayPixel(1));
	picture.setPixel(1, 0, new GrayPixel(1));
	picture.setPixel(1, 1, new GrayPixel(0));
	Assert.assertEquals('#', p.next().getChar());
	Assert.assertEquals(' ', p.next().getChar());
	Assert.assertEquals(' ', p.next().getChar());
	Assert.assertEquals('#', p.next().getChar());
    }

    @Test
    public void testNoSuchElement() {
	Picture picture = new PictureImpl(2, 2);
	Iterator<Pixel> p = picture.iterator();
	p.next();
	p.next();
	p.next();
	p.next();
	try {
	    p.next();
	    fail("Going out of bounce did not throw no-such-element error");
	} catch (NoSuchElementException e) {
	} catch (Exception e) {
	    fail("Going out of bounce did not throw no-such-element error");
	}
    }

    @Test
    public void testHasNext() {
	Picture picture = new PictureImpl(2, 2);
	Iterator<Pixel> iter = picture.iterator();
	for (int i = 0; i < 4; i++) {
	    iter.next();
	}
	Assert.assertFalse("Iterator should return false", iter.hasNext());
    }

    @Test
    public void testCoordinateExtract() {
	Picture picture = new PictureImpl(3, 3);
	picture.setPixel(1, 1, new GrayPixel(0));
	picture.setPixel(2, 2, new GrayPixel(1));
	Picture p1 = picture.extract(1, 1, 1, 1);
	Picture p2 = picture.extract(new Coordinate(1, 1), new Coordinate(2, 2));
	Assert.assertEquals("Pixels are differnt at the specified point", p1.getPixel(0, 0), p2.getPixel(0, 0));
	Assert.assertEquals("Pixels are differnt at the specified point", p1.getPixel(1, 1), p2.getPixel(1, 1));
    }

    private static boolean comparePixels(Pixel a, Pixel b) {
	return ((Math.abs(a.getRed() - b.getRed()) < 0.001) && (Math.abs(a.getGreen() - b.getGreen()) < 0.001)
		&& (Math.abs(a.getBlue() - b.getBlue()) < 0.001));
    }

}

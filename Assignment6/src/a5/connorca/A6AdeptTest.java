package a5.connorca;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    private static final Pixel white = new GrayPixel(1.0);
    private static final Pixel black = new GrayPixel(0.0);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testSampleIterator";
	test_names[1] = "testWindowIterator";
	test_names[2] = "testTileIterator";

	return test_names;
    }

    @Test
    public void testSampleIterator() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, black);
	p.setPixel(1, 0, white);
	p.setPixel(2, 0, black);
	p.setPixel(0, 1, white);
	p.setPixel(1, 1, black);
	p.setPixel(2, 1, white);
	p.setPixel(0, 2, black);
	p.setPixel(1, 2, white);
	p.setPixel(2, 2, black);

	try {
	    p.sample(3, 3, 1, 1);
	    fail("invalid startpoint");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("wrong exception");
	}

	Iterator<Pixel> iter = p.sample(0, 1, 2, 1);
	Pixel p1 = iter.next();
	Pixel p2 = iter.next();
	assertEquals(white, p1);
	assertEquals(white, p2);

	try {
	    Iterator<Pixel> sample_Iter = p.sample(1, 1, 1, 1);
	    for (int i = 0; i < 5; i++) {
		sample_Iter.next();
	    }
	    sample_Iter.hasNext();
	    fail("there should be no element left in the list");
	} catch (java.util.NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("wrong type of exception");
	}
    }

    @Test
    public void testWindowIterator() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, black);
	p.setPixel(1, 0, white);
	p.setPixel(2, 0, black);
	p.setPixel(0, 1, white);
	p.setPixel(1, 1, black);
	p.setPixel(2, 1, white);
	p.setPixel(0, 2, black);
	p.setPixel(1, 2, white);
	p.setPixel(2, 2, black);

	Iterator<SubPicture> window_Iter = p.window(2, 2);
	SubPicture s1 = window_Iter.next();
	SubPicture s2 = p.extract(0, 0, 2, 2);
	Pixel p1 = s1.getPixel(1, 1);
	Pixel p2 = s2.getPixel(1, 1);
	assertEquals(p1, p2);
	try {
	    for (int i = 0; i < 5; i++) {
		window_Iter.next();
	    }
	    window_Iter.hasNext();
	    fail("there should be no element left in the list");
	} catch (java.util.NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("wrong type of exception");
	}

    }

    @Test
    public void testTileIterator() {
	Picture p = new PictureImpl(4, 4);
	p.setPixel(0, 0, black);
	p.setPixel(1, 0, white);
	p.setPixel(2, 0, black);
	p.setPixel(3, 0, white);
	p.setPixel(0, 1, white);
	p.setPixel(1, 1, black);
	p.setPixel(2, 1, white);
	p.setPixel(3, 1, black);
	p.setPixel(0, 2, black);
	p.setPixel(1, 2, white);
	p.setPixel(2, 2, black);
	p.setPixel(3, 2, white);
	p.setPixel(0, 3, white);
	p.setPixel(1, 3, black);
	p.setPixel(2, 3, white);
	p.setPixel(3, 3, black);

	Iterator<SubPicture> tile_Iter = p.window(2, 2);
	SubPicture s1 = tile_Iter.next();
	SubPicture s2 = p.extract(2, 0, 2, 2);
	Pixel p1 = s1.getPixel(1, 1);
	Pixel p2 = s2.getPixel(1, 1);
	assertEquals(black, p1);
	assertEquals(black, p2);

    }
}

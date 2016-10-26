package a5.nmancuso;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "sampleTest";
	test_names[1] = "windowTest";
	test_names[2] = "outofRangeTest";
	test_names[3] = "testExtractCoordinates";
	test_names[4] = "iteratorTest";

	return test_names;
    }

    @Test
    public void sampleTest() {
	Picture p = new PictureImpl(15, 10);

	Coordinate a = new Coordinate(2, 3);
	Coordinate b = new Coordinate(5, 3);
	Coordinate c = new Coordinate(14, 7);

	p.setPixel(a, RED);
	p.setPixel(b, BLUE);
	p.setPixel(c, GREEN);

	// create iterator to test sample method
	Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
	Pixel pix = WHITE;

	// go to first iteration and test equivalence
	if (sample_iter.hasNext()) {
	    pix = sample_iter.next();
	}
	assertEquals("First Pixel not iterated", RED, pix);

	// go to second iteration and test equivalence
	if (sample_iter.hasNext()) {
	    pix = sample_iter.next();
	}
	assertEquals("Second Pixel not iterated", BLUE, pix);

	// go to last iteration and test equivalence
	while (sample_iter.hasNext()) {
	    pix = sample_iter.next();
	}
	assertEquals("Last pixel not iterated", GREEN, pix);

    }

    @Test
    public void windowTest() {
	Picture p = new PictureImpl(5, 5);

	Coordinate a = new Coordinate(0, 0);
	Coordinate b = new Coordinate(1, 0);
	Coordinate c = new Coordinate(2, 0);
	Coordinate d = new Coordinate(2, 3);

	p.setPixel(a, RED);
	p.setPixel(b, BLUE);
	p.setPixel(c, GREEN);
	p.setPixel(d, BLACK);

	// create iterator to test window method
	Iterator<SubPicture> window_iter = p.window(3, 2);
	SubPicture sub = new SubPictureImpl(p, 0, 0, 5, 5);

	// go to first iteration and test equivalence
	if (window_iter.hasNext()) {
	    sub = window_iter.next();
	}
	Pixel pix = sub.getPixel(a);
	assertEquals("First window iteration is not correct", RED, pix);

	// go to second iteration and test equivalence
	if (window_iter.hasNext()) {
	    sub = window_iter.next();
	}
	pix = sub.getPixel(a);
	assertEquals("Second window iteration is not correct", BLUE, pix);

	// go to third iteration and test equivalence
	if (window_iter.hasNext()) {
	    sub = window_iter.next();
	}
	pix = sub.getPixel(a);
	assertEquals("Third window iteration is not correct", GREEN, pix);

	// go to last iteration and test equivalence
	while (window_iter.hasNext()) {
	    sub = window_iter.next();
	}
	pix = sub.getPixel(a);
	assertEquals("Last window iteration is not correct", BLACK, pix);

    }

    @Test
    public void outOfRangeTest() {
	// testing new coordinate class
	Coordinate c1 = new Coordinate(-1, 0);
	Picture p = new PictureImpl(2, 2);

	// testing if getPixel can tell coordinate is out of range
	try {
	    p.getPixel(c1);
	} catch (RuntimeException e) {
	} catch (Exception e) {
	    fail("Expceted RuntimeException, detected some other kind");
	}
    }

    @Test
    public void testExtractAndCoordinates() {
	Picture p = new PictureImpl(3, 3);
	Coordinate a = new Coordinate(0, 0);
	Coordinate b = new Coordinate(1, 0);
	Coordinate c = new Coordinate(0, 1);
	Coordinate d = new Coordinate(1, 1);
	Coordinate e = new Coordinate(1, 2);
	Coordinate f = new Coordinate(2, 1);
	Coordinate g = new Coordinate(2, 2);

	p.setPixel(a, RED);
	p.setPixel(b, RED);
	p.setPixel(c, GREEN);
	p.setPixel(d, BLUE);
	p.setPixel(f, WHITE);
	p.setPixel(e, BLACK);
	p.setPixel(g, RED);

	// test the new extract picture with Coordinates
	SubPicture sp = p.extract(d, g);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(d),
		sp.getPixel(a));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(f),
		sp.getPixel(b));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(e),
		sp.getPixel(c));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(g),
		sp.getPixel(d));
    }

    @Test
    public void iteratorTest() {
	Picture p = new PictureImpl(3, 3);

	Coordinate a = new Coordinate(0, 0);
	Coordinate b = new Coordinate(1, 0);
	Coordinate c = new Coordinate(2, 0);
	Coordinate d = new Coordinate(2, 2);

	p.setPixel(a, RED);
	p.setPixel(b, GREEN);
	p.setPixel(c, BLACK);
	p.setPixel(d, BLUE);

	// create new iterator object
	Iterator<Pixel> iter = p.iterator();
	Pixel pix = GREEN;

	// go to first iteration and test equivalence
	if (iter.hasNext()) {
	    pix = iter.next();
	}
	assertEquals("First pixel not iterated", RED, pix);

	// go to second iteration and test equivalence
	if (iter.hasNext()) {
	    pix = iter.next();
	}
	assertEquals("Second pixel not iterated", GREEN, pix);

	// go to last iteration and test equivalence
	while (iter.hasNext()) {
	    pix = iter.next();
	}
	assertEquals("Last pixel not iterated", BLUE, pix);

    }
}

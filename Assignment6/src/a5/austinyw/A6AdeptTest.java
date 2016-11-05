package a5.austinyw;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "badParamTest";
	test_names[1] = "sampleTest";
	test_names[2] = "windowTest";
	test_names[3] = "tileTest";

	return test_names;
    }

    @Test
    public void badParamTest() {
	Picture p1 = new PictureImpl(5, 5);
	try {
	    p1.sample(5, 0, 1, 1);
	    fail("Did not throw exception for init_x out of bounds");
	} catch (IllegalArgumentException e) {
	}
	try {
	    p1.sample(0, 5, 1, 1);
	    fail("Did not throw exception for init_y out of bounds");
	} catch (IllegalArgumentException e) {
	}
	try {
	    p1.sample(0, 0, 0, 1);
	    fail("Did not throw exception for non-positive dx");
	} catch (IllegalArgumentException e) {
	}
	try {
	    p1.sample(0, 0, 1, -5);
	    fail("Did not throw exception for non-positive dy");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p1.window(0, 1);
	    fail("Did not throw exception window_width out of bounds");
	} catch (IllegalArgumentException e) {
	}
	try {
	    p1.window(6, 1);
	    fail("Did not throw exception window_width out of bounds");
	} catch (IllegalArgumentException e) {
	}
	try {
	    p1.window(1, 0);
	    fail("Did not throw exception window_height out of bounds");
	} catch (IllegalArgumentException e) {
	}
	try {
	    p1.window(1, 6);
	    fail("Did not throw exception window_height out of bounds");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p1.tile(0, 1);
	    fail("Did not throw exception tile_width out of bounds");
	} catch (IllegalArgumentException e) {
	}
	try {
	    p1.tile(6, 1);
	    fail("Did not throw exception tile_width out of bounds");
	} catch (IllegalArgumentException e) {
	}
	try {
	    p1.tile(1, 0);
	    fail("Did not throw exception tile_height out of bounds");
	} catch (IllegalArgumentException e) {
	}
	try {
	    p1.tile(1, 6);
	    fail("Did not throw exception tile_height out of bounds");
	} catch (IllegalArgumentException e) {
	}
    }

    @Test
    public void sampleTest() {
	Picture p1 = new PictureImpl(6, 9);

	p1.setPixel(1, 2, new GrayPixel(0.1));
	p1.setPixel(3, 2, new GrayPixel(0.2));
	p1.setPixel(5, 2, new GrayPixel(0.3));
	p1.setPixel(1, 5, new GrayPixel(0.4));
	p1.setPixel(3, 5, new GrayPixel(0.5));
	p1.setPixel(5, 5, new GrayPixel(0.6));
	p1.setPixel(1, 8, new GrayPixel(0.7));
	p1.setPixel(3, 8, new GrayPixel(0.8));
	p1.setPixel(5, 8, new GrayPixel(0.9));

	Iterator<Pixel> iter1 = p1.sample(1, 2, 2, 3);

	Pixel expected1 = p1.getPixel(1, 2);
	Pixel expected2 = p1.getPixel(3, 2);
	Pixel expected3 = p1.getPixel(5, 2);
	Pixel expected4 = p1.getPixel(1, 5);
	Pixel expected5 = p1.getPixel(3, 5);
	Pixel expected6 = p1.getPixel(5, 5);
	Pixel expected7 = p1.getPixel(1, 8);
	Pixel expected8 = p1.getPixel(3, 8);
	Pixel expected9 = p1.getPixel(5, 8);

	assertEquals("Pixel 1 is not as expected", expected1, iter1.next());
	assertEquals("Pixel 2 is not as expected", expected2, iter1.next());
	assertEquals("Pixel 3 is not as expected", expected3, iter1.next());
	assertEquals("Pixel 4 is not as expected", expected4, iter1.next());
	assertEquals("Pixel 5 is not as expected", expected5, iter1.next());
	assertEquals("Pixel 6 is not as expected", expected6, iter1.next());
	assertEquals("Pixel 7 is not as expected", expected7, iter1.next());
	assertEquals("Pixel 8 is not as expected", expected8, iter1.next());
	assertEquals("Pixel 9 is not as expected", expected9, iter1.next());

	try {
	    iter1.next();
	    fail("Called next and the iterator did not throw an exception");
	} catch (NoSuchElementException e) {
	}
    }

    @Test
    public void windowTest() {
	Picture p1 = new PictureImpl(3, 3);

	p1.setPixel(0, 0, new ColorPixel(0.11, 0.12, 0.13));
	p1.setPixel(1, 0, new ColorPixel(0.21, 0.22, 0.23));
	p1.setPixel(2, 0, new ColorPixel(0.31, 0.32, 0.33));
	p1.setPixel(0, 1, new ColorPixel(0.41, 0.42, 0.43));
	p1.setPixel(1, 1, new ColorPixel(0.51, 0.52, 0.53));
	p1.setPixel(2, 1, new ColorPixel(0.61, 0.62, 0.63));
	p1.setPixel(0, 2, new ColorPixel(0.71, 0.72, 0.73));
	p1.setPixel(1, 2, new ColorPixel(0.81, 0.82, 0.83));
	p1.setPixel(2, 2, new ColorPixel(0.91, 0.92, 0.93));

	Iterator<SubPicture> iter1 = p1.window(2, 2);

	SubPicture expected1 = p1.extract(0, 0, 2, 2);
	SubPicture expected2 = p1.extract(1, 0, 2, 2);
	SubPicture expected3 = p1.extract(0, 1, 2, 2);
	SubPicture expected4 = p1.extract(1, 1, 2, 2);

	SubPicture iterTemp = iter1.next();
	for (int x = 0; x < expected1.getWidth(); x++) {
	    for (int y = 0; y < expected1.getHeight(); y++) {
		assertEquals("SubPicture 1 not as expected", expected1.getPixel(x, y), iterTemp.getPixel(x, y));
	    }
	}

	iterTemp = iter1.next();
	for (int x = 0; x < expected2.getWidth(); x++) {
	    for (int y = 0; y < expected2.getHeight(); y++) {
		assertEquals("SubPicture 2 not as expected", expected2.getPixel(x, y), iterTemp.getPixel(x, y));
	    }
	}

	iterTemp = iter1.next();
	for (int x = 0; x < expected3.getWidth(); x++) {
	    for (int y = 0; y < expected3.getHeight(); y++) {
		assertEquals("SubPicture 1 not as expected", expected3.getPixel(x, y), iterTemp.getPixel(x, y));
	    }
	}

	iterTemp = iter1.next();
	for (int x = 0; x < expected4.getWidth(); x++) {
	    for (int y = 0; y < expected4.getHeight(); y++) {
		assertEquals("SubPicture 1 not as expected", expected4.getPixel(x, y), iterTemp.getPixel(x, y));
	    }
	}

	try {
	    iter1.next();
	    fail("Called next and the iterator did not throw an exception");
	} catch (NoSuchElementException e) {
	}

    }

    @Test
    public void tileTest() {
	Picture p1 = new PictureImpl(5, 5);

	p1.setPixel(0, 0, new ColorPixel(0.11, 0.12, 0.13));
	p1.setPixel(1, 0, new ColorPixel(0.12, 0.13, 0.14));
	p1.setPixel(2, 0, new ColorPixel(0.13, 0.14, 0.15));
	p1.setPixel(3, 0, new ColorPixel(0.14, 0.15, 0.16));
	p1.setPixel(4, 0, new ColorPixel(0.15, 0.16, 0.17));

	p1.setPixel(0, 1, new ColorPixel(0.21, 0.22, 0.23));
	p1.setPixel(1, 1, new ColorPixel(0.22, 0.23, 0.24));
	p1.setPixel(2, 1, new ColorPixel(0.23, 0.24, 0.25));
	p1.setPixel(3, 1, new ColorPixel(0.24, 0.25, 0.26));
	p1.setPixel(4, 1, new ColorPixel(0.25, 0.26, 0.27));

	p1.setPixel(0, 2, new ColorPixel(0.31, 0.32, 0.33));
	p1.setPixel(1, 2, new ColorPixel(0.32, 0.33, 0.34));
	p1.setPixel(2, 2, new ColorPixel(0.33, 0.34, 0.35));
	p1.setPixel(3, 2, new ColorPixel(0.34, 0.35, 0.36));
	p1.setPixel(4, 2, new ColorPixel(0.35, 0.36, 0.37));

	p1.setPixel(0, 3, new ColorPixel(0.41, 0.42, 0.43));
	p1.setPixel(1, 3, new ColorPixel(0.42, 0.43, 0.44));
	p1.setPixel(2, 3, new ColorPixel(0.43, 0.43, 0.45));
	p1.setPixel(3, 3, new ColorPixel(0.44, 0.45, 0.46));
	p1.setPixel(4, 3, new ColorPixel(0.45, 0.46, 0.47));

	p1.setPixel(0, 4, new ColorPixel(0.51, 0.52, 0.53));
	p1.setPixel(1, 4, new ColorPixel(0.52, 0.53, 0.54));
	p1.setPixel(2, 4, new ColorPixel(0.53, 0.54, 0.55));
	p1.setPixel(3, 4, new ColorPixel(0.54, 0.55, 0.56));
	p1.setPixel(4, 4, new ColorPixel(0.55, 0.56, 0.57));

	Iterator<SubPicture> iter1 = p1.tile(2, 2);

	SubPicture expected1 = p1.extract(0, 0, 2, 2);
	SubPicture expected2 = p1.extract(2, 0, 2, 2);
	SubPicture expected3 = p1.extract(0, 2, 2, 2);
	SubPicture expected4 = p1.extract(2, 2, 2, 2);

	SubPicture iterTemp = iter1.next();
	for (int x = 0; x < expected1.getWidth(); x++) {
	    for (int y = 0; y < expected1.getHeight(); y++) {
		assertEquals("SubPicture 1 not as expected", expected1.getPixel(x, y), iterTemp.getPixel(x, y));
	    }
	}

	iterTemp = iter1.next();
	for (int x = 0; x < expected2.getWidth(); x++) {
	    for (int y = 0; y < expected2.getHeight(); y++) {
		assertEquals("SubPicture 2 not as expected", expected2.getPixel(x, y), iterTemp.getPixel(x, y));
	    }
	}

	iterTemp = iter1.next();
	for (int x = 0; x < expected3.getWidth(); x++) {
	    for (int y = 0; y < expected3.getHeight(); y++) {
		assertEquals("SubPicture 1 not as expected", expected3.getPixel(x, y), iterTemp.getPixel(x, y));
	    }
	}

	iterTemp = iter1.next();
	for (int x = 0; x < expected4.getWidth(); x++) {
	    for (int y = 0; y < expected4.getHeight(); y++) {
		assertEquals("SubPicture 1 not as expected", expected4.getPixel(x, y), iterTemp.getPixel(x, y));
	    }
	}

	try {
	    iter1.next();
	    fail("Called next and the iterator did not throw an exception");
	} catch (NoSuchElementException e) {
	}
    }
}

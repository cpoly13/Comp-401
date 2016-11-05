package a5.aandrei;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testSampleIterator";
	test_names[1] = "testWindowIterator";
	test_names[2] = "testTileIterator";

	return test_names;
    }

    private static final Pixel GRAY = new GrayPixel(0.5);
    private static final Pixel BLACK = new GrayPixel(1);
    private static final Pixel WHITE = new GrayPixel(0);

    @Test
    public void testSampleIterator() {
	Picture p = new PictureImpl(16, 10);
	for (int i = 0; i < 10; i++) {
	    for (int j = 0; j < 16; j++) {
		p.setPixel(j, i, GRAY);
	    }
	}
	p.setPixel(5, 2, BLACK);
	p.setPixel(1, 8, WHITE);
	Iterator<Pixel> iter = p.sample(1, 2, 4, 3);

	iter.next();
	assertEquals("iterator did not return expected Pixel", BLACK, iter.next());
	for (int i = 0; i < 6; i++) {
	    iter.next();
	}
	assertEquals("iterator did not return expected Pixel", WHITE, iter.next());
	for (int i = 0; i < 3; i++) {
	    iter.next();
	}
	try {
	    iter.next();
	    fail("Expected NoSuchElementException");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but got generic RuntimeException");
	}
    }

    @Test
    public void testWindowIterator() {
	Picture p = new PictureImpl(5, 5);
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		p.setPixel(j, i, GRAY);
	    }
	}
	p.setPixel(1, 0, BLACK);
	p.setPixel(2, 3, BLACK);
	p.setPixel(2, 1, WHITE);
	p.setPixel(1, 4, WHITE);
	Iterator<SubPicture> iter = p.window(2, 3);

	assertEquals("iterator did not return expected SubPicture", BLACK, iter.next().getPixel(1, 0));
	iter.next();
	assertEquals("iterator did not return expected SubPicture", WHITE, iter.next().getPixel(0, 1));
	for (int i = 0; i < 3; i++) {
	    iter.next();
	}
	assertEquals("iterator did not return expected SubPicture", WHITE, iter.next().getPixel(0, 0));
	iter.next();
	assertEquals("iterator did not return expected SubPicture", WHITE, iter.next().getPixel(1, 2));
	iter.next();
	assertEquals("iterator did not return expected SubPicture", BLACK, iter.next().getPixel(0, 1));
	iter.next();
	try {
	    iter.next();
	    fail("Expected NoSuchElementException");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but got generic RuntimeException");
	}
    }

    @Test
    public void testTileIterator() {
	Picture p = new PictureImpl(11, 9);
	for (int i = 0; i < 9; i++) {
	    for (int j = 0; j < 11; j++) {
		p.setPixel(j, i, GRAY);
	    }
	}
	p.setPixel(2, 2, BLACK);
	p.setPixel(8, 7, BLACK);
	p.setPixel(7, 1, WHITE);
	p.setPixel(1, 6, WHITE);
	Iterator<SubPicture> iter = p.tile(3, 4);

	assertEquals("iterator did not return expected SubPicture", BLACK, iter.next().getPixel(2, 2));
	iter.next();
	assertEquals("iterator did not return expected SubPicture", WHITE, iter.next().getPixel(1, 1));
	assertEquals("iterator did not return expected SubPicture", WHITE, iter.next().getPixel(1, 2));
	iter.next();
	assertEquals("iterator did not return expected SubPicture", BLACK, iter.next().getPixel(2, 3));
	try {
	    iter.next();
	    fail("Expected NoSuchElementException");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but got generic RuntimeException");
	}
    }
}

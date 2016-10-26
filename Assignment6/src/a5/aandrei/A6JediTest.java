package a5.aandrei;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6jedi.GrayPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testZigzagIterator";

	return test_names;
    }

    private static final Pixel GRAY = new GrayPixel(0.5);
    private static final Pixel BLACK = new GrayPixel(1);
    private static final Pixel WHITE = new GrayPixel(0);

    @Test
    public void testZigzagIterator() {
	Picture p = new PictureImpl(5, 4);
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 5; j++) {
		p.setPixel(j, i, GRAY);
	    }
	}
	p.setPixel(0, 1, BLACK);
	p.setPixel(3, 1, BLACK);
	p.setPixel(2, 2, WHITE);
	p.setPixel(2, 3, WHITE);
	Iterator<Pixel> iter = p.zigzag();

	iter.next();
	iter.next();
	assertEquals("iterator did not return expected Pixel", BLACK, iter.next());
	for (int i = 0; i < 8; i++) {
	    iter.next();
	}
	assertEquals("iterator did not return expected Pixel", WHITE, iter.next());
	assertEquals("iterator did not return expected Pixel", BLACK, iter.next());
	for (int i = 0; i < 3; i++) {
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
}

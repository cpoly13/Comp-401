package a5.nwalters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = { "iteratorTest", "iteratorExceptionTest" };

	return test_names;
    }

    // Test if iterator parses through pixels correctly
    @Test
    public void iteratorTest() {
	Picture p = new PictureImpl(15, 10);
	int x = 2; // count variable to parse through all pixels iterator will
	int y = 3;
	Iterator<Pixel> iterExample = p.sample(2, 3, 3, 4);
	while (iterExample.hasNext() && y < p.getHeight() - y) { // Make sure y
								 // value does
								 // not
								 // go out of
								 // bounds
	    Pixel iterationPix = p.getPixel(x, y);
	    assertEquals("Pixels do not match", iterExample.next(), iterationPix);
	    x += 3;
	    y += 4;
	}
    }

    // Test if iterator exception occurs at correct place
    @Test
    public void iteratorExceptionTest() {
	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> iterExample = p.sample(2, 3, 1, 1);
	while (iterExample.hasNext()) {
	    iterExample.next();
	}
	try {
	    iterExample.next();
	    fail("Expected java.util.NoSuchElementException");
	} catch (java.util.NoSuchElementException e) {
	}
    }

}

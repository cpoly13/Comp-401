package a5.jmoore98;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = { "exampleTest", "iteratorTest", "iteratorExceptionTest" };

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    // Test if iterator parses through pixels correctly
    @Test
    public void iteratorTest() {
	Picture p = new PictureImpl(15, 10);
	int x = 2; // count variable to parse through all pixels iterator will
	int y = 3;
	Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
	while (sample_iter.hasNext() && y < p.getHeight() - y) { // Make sure y
								 // value does
								 // not go out
								 // of bounds
	    Pixel iter_out = p.getPixel(x, y);
	    assertEquals("Pixels do not match", sample_iter.next(), iter_out);
	    x += 3;
	    y += 4;
	}
    }

    // Test if iterator exception occurs at correct place
    @Test
    public void iteratorExceptionTest() {
	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> sample_iter = p.sample(2, 3, 1, 1);
	while (sample_iter.hasNext()) {
	    sample_iter.next();
	}
	try {
	    sample_iter.next();
	    fail("Expected java.util.NoSuchElementException");
	} catch (java.util.NoSuchElementException e) {
	}
    }

}

package a5.jmoore98;

import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = { "exampleTest", "windowIteratorTest" };

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    // Test if window_iterator throws errors when expected
    @Test
    public void windowIteratorTest() {
	Picture p = new PictureImpl(15, 10);
	Iterator<SubPicture> window_iter = p.window(3, 2);
	while (window_iter.hasNext()) {
	    window_iter.next();
	}
	try {
	    window_iter.next();
	    fail("Expected java.util.NoSuchElementException");
	} catch (java.util.NoSuchElementException e) {
	}
    }
}

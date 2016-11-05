package a5.larrypat;

import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_id = { "exampleTest", "windowIteratorTest" };

	return test_id;
    }

    @Test
    public void exampleTest() {
    }

    // Tests to see if window_iterator throws errors when expected
    @Test
    public void windowIteratorTest() {
	Picture p = new PictureImpl(15, 10);
	Iterator<SubPicture> window_iterat = p.window(3, 2);
	while (window_iterat.hasNext()) {
	    window_iterat.next();
	}
	try {
	    window_iterat.next();
	    fail("Expected java.util.NoSuchElementException");
	} catch (java.util.NoSuchElementException e) {
	}
    }
}

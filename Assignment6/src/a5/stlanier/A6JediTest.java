package a5.stlanier;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagTests";

	return test_names;
    }

    @Test
    public void zigzagTests() {
	Pixel a = new ColorPixel(1, 1, 1);
	Pixel b = new ColorPixel(1, 1, 0);
	Pixel c = new ColorPixel(1, 0, 0);
	Picture myPic = new PictureImpl(8, 4);
	myPic.setPixel(1, 1, a);
	myPic.setPixel(5, 1, b);
	myPic.setPixel(6, 3, c);
	Iterator<Pixel> zzIt = myPic.zigzag();

	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	assertEquals("zigzagIterator does not accurately traverse Picture.", a, zzIt.next());
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	assertEquals("zigzagIterator does not accurately traverse Picture.", b, zzIt.next());
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	zzIt.next();
	assertEquals("zigzagIterator does not accurately traverse Picture.", c, zzIt.next());
	zzIt.next();

	assertEquals("sampleIterator signifies final hasNext() incorrectly.", false, zzIt.hasNext());
	try {
	    zzIt.next();
	} catch (java.util.NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementedException instead of generic RuntimeException.");
	}
    }
}

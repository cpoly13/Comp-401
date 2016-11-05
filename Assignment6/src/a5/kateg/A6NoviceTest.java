package a5.kateg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;

public class A6NoviceTest {
    /*
     * returns an array of strings that correspond to each JUnit test in the
     * class:
     */
    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "coordinateTest";

	return test_names;
    }
    // Calling next() after the last pixel has already been traversed should
    // result in a java.util.NoSuchElementException.
    // @Test
    // public void noMoreNext() {
    //
    // Picture p = new PictureImpl(6,4);
    // p.next();
    //
    // }

    @Test
    // checking to see if coordinate parameter gets same pixel value as x,y
    // parameters
    public void coordinateTest() {
	Picture p = new PictureImpl(2, 3);
	Coordinate c1 = new Coordinate(1, 0);
	Coordinate c2 = new Coordinate(-1, 0);

	assertEquals("getPixel() called with coordinate different from getPixel() called with x and y",
		p.getPixel(1, 0), p.getPixel(c1));
	try {
	    p.getPixel(c2);
	    fail("Expected illegalArgumentException because x is negative");
	} catch (IllegalArgumentException e) {
	} catch (Exception e) {
	}
    }
}

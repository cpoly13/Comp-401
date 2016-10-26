package a5.takoda;

import java.util.*;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

/*
 * Takoda Ren
 * October 19, 2016
 */
public class A6NoviceTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);
    private static final Coordinate C00 = new Coordinate(0, 0);
    private static final Coordinate C10 = new Coordinate(0, 1);
    private static final Coordinate C01 = new Coordinate(1, 0);
    private static final Coordinate C11 = new Coordinate(1, 1);
    private static final Coordinate C12 = new Coordinate(2, 1);
    private static final Coordinate C21 = new Coordinate(1, 2);
    private static final Coordinate C02 = new Coordinate(2, 0);
    private static final Coordinate C20 = new Coordinate(0, 2);
    private static final Coordinate C22 = new Coordinate(2, 2);

    /*
     * Output: Returns array of test names in this class This method is for the
     * successful completion of the autograder
     */
    static public String[] getTestNames() {
	String[] testNames = new String[3];

	testNames[0] = "testCoordinateGettersAndSetters";
	testNames[1] = "testExtractWithCoordinates";
	testNames[2] = "testSimpleIterator";

	return testNames;
    }

    /*
     * Tests whether the pixel getters and setters with coordinate inputs are
     * correct
     */
    @Test
    public void testCoordinateGettersAndSetters() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(C00, RED);
	p.setPixel(C01, GREEN);
	p.setPixel(C02, BLUE);
	p.setPixel(C10, WHITE);
	p.setPixel(C11, BLACK);
	p.setPixel(C12, RED);
	p.setPixel(C20, GREEN);
	p.setPixel(C21, BLUE);
	p.setPixel(C22, WHITE);

	// checking for equality
	assertEquals("Retrieved pixel does not match expected value.", RED, p.getPixel(C00));
	assertEquals("Retrieved pixel does not match expected value.", GREEN, p.getPixel(C01));
	assertEquals("Retrieved pixel does not match expected value.", BLUE, p.getPixel(C02));
	assertEquals("Retrieved pixel does not match expected value.", WHITE, p.getPixel(C10));
	assertEquals("Retrieved pixel does not match expected value.", BLACK, p.getPixel(C11));
	assertEquals("Retrieved pixel does not match expected value.", RED, p.getPixel(C12));
	assertEquals("Retrieved pixel does not match expected value.", GREEN, p.getPixel(C20));
	assertEquals("Retrieved pixel does not match expected value.", BLUE, p.getPixel(C21));
	assertEquals("Retrieved pixel does not match expected value.", WHITE, p.getPixel(C22));
    }

    /*
     * Tests the extract overridden extract class that takes coordinate inputs.
     * Also tests whether the order of the coordinates entered as paramaters
     * matters.
     */
    @Test
    public void testExtractWithCoordinates() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(C00, RED);
	p.setPixel(C01, GREEN);
	p.setPixel(C02, BLUE);
	p.setPixel(C10, WHITE);
	p.setPixel(C11, BLACK);
	p.setPixel(C12, RED);
	p.setPixel(C20, GREEN);
	p.setPixel(C21, BLUE);
	p.setPixel(C22, WHITE);

	SubPicture sp = p.extract(C10, C22);
	assertEquals("Pixel retrieved from subpicture does not match pixel from source.", p.getPixel(C10),
		sp.getPixel(C00));
	assertEquals("Pixel retrieved from subpicture does not match pixel from source.", p.getPixel(C11),
		sp.getPixel(C01));
	assertEquals("Pixel retrieved from subpicture does not match pixel from source.", p.getPixel(C12),
		sp.getPixel(C02));
	assertEquals("Pixel retrieved from subpicture does not match pixel from source.", p.getPixel(C20),
		sp.getPixel(C10));
	assertEquals("Pixel retrieved from subpicture does not match pixel from source.", p.getPixel(C21),
		sp.getPixel(C11));
	assertEquals("Pixel retrieved from subpicture does not match pixel from source.", p.getPixel(C22),
		sp.getPixel(C12));

	try {
	    p.extract(new Coordinate(-1, -1), C01);
	    fail("IllegalArgumentException not thrown for " + "out of bounds coordinates");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}
    }

    @Test
    public void testSimpleIterator() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(C00, RED);
	p.setPixel(C01, RED);
	p.setPixel(C02, RED);
	p.setPixel(C10, GREEN);
	p.setPixel(C11, GREEN);
	p.setPixel(C12, GREEN);
	p.setPixel(C20, BLUE);
	p.setPixel(C21, BLUE);
	p.setPixel(C22, BLUE);
	Pixel[] pa = { RED, RED, RED, GREEN, GREEN, GREEN, BLUE, BLUE, BLUE };
	Iterator<Pixel> i = p.iterator();
	for (int j = 0; j < pa.length; j++) {
	    assertEquals("Iterator does not return has next", true, i.hasNext());
	    assertEquals("Iterator does not return correct pixel", pa[j], i.next());
	}

	try {
	    i.next();
	    fail("Iterator did not return NoSuchElementException");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but received" + "RuntimeException.");
	}
    }
}

package a5.takoda;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6adept.*;

/*
 * Takoda Ren
 * October 19, 2016
 */

public class A6AdeptTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    /*
     * Output: Returns array of test names in this class This method is for the
     * successful completion of the autograder
     */
    static public String[] getTestNames() {
	String[] testNames = new String[3];

	testNames[0] = "testSampleIterator";
	testNames[1] = "testWindowIterator";
	testNames[2] = "testTileIterator";
	return testNames;
    }

    /*
     * Tests the Sample iterator object through PictureImpl. Verifies Illegal
     * Argument Exceptions and accuracy of the returned pixels.
     */
    @Test
    public void testSampleIterator() {
	Picture p = new PictureImpl(6, 6);
	for (int i = 0; i < p.getHeight(); i++) {
	    for (int j = 0; j < p.getWidth(); j++) {
		if (j % 3 == 0)
		    p.setPixel(j, i, RED);
		if (j == 1 || j == 4)
		    p.setPixel(j, i, GREEN);
		if (j == 2 || j == 5)
		    p.setPixel(j, i, BLUE);
	    }
	}
	Iterator<Pixel> sampleIter = p.sample(1, 1, 2, 3);
	Pixel[] pa = { GREEN, RED, BLUE, GREEN, RED, BLUE };
	for (int i = 0; i < 6; i++) {
	    assertEquals("Sample iterator does not return true for hasNext", true, sampleIter.hasNext());
	    assertEquals("Pixel returned by sample iterator does not match expected Pixel", pa[i], sampleIter.next());
	}
	assertEquals("Sample iterator returns true for hasNext when it should be false", false, sampleIter.hasNext());
	try {
	    p.sample(-1, 1, 2, 3);
	    fail("IllegalArgumentException not thrown for negative init_x");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    p.sample(0, 8, 2, 3);
	    fail("IllegalArgumentException not thrown for out of bound init_y");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    p.sample(0, 3, -1, 3);
	    fail("IllegalArgumentException not thrown for negative dx");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    p.sample(0, 3, 1, -1);
	    fail("IllegalArgumentException not thrown for negative dy");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    sampleIter.next();
	    fail("Iterator did not return NoSuchElementException");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but received" + "RuntimeException.");
	}
    }

    @Test
    public void testWindowIterator() {
	Picture p = new PictureImpl(6, 6);
	for (int i = 0; i < p.getHeight(); i++) {
	    for (int j = 0; j < p.getWidth(); j++) {
		if (j % 3 == 0)
		    p.setPixel(j, i, RED);
		if (j == 1 || j == 4)
		    p.setPixel(j, i, GREEN);
		if (j == 2 || j == 5)
		    p.setPixel(j, i, BLUE);
	    }
	}
	Iterator<SubPicture> windowIter = p.window(4, 5);
	for (int i = 0; i < 2; i++) {
	    for (int j = 0; j < 3; j++) {
		assertEquals("Window iterator returns false for hasNext", true, windowIter.hasNext());
		assertTrue("Returned subPicture from iterator does " + "not match expected subpicture",
			compareSubPictures(p.extract(j, i, 4, 5), windowIter.next()));
	    }
	}
	assertEquals("Window iterator returns true for hasNext when it should be false", false, windowIter.hasNext());

	try {
	    p.window(-1, -3);
	    fail("IllegalArgumentException not thrown for " + "negative window width/window height");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    p.window(7, 2);
	    fail("IllegalArgumentException not thrown for " + "out of bounds window width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    p.window(2, 7);
	    fail("IllegalArgumentException not thrown for " + "out of bounds window height");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    windowIter.next();
	    fail("Iterator did not return NoSuchElementException");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but received" + "RuntimeException.");
	}
    }

    @Test
    public void testTileIterator() {
	Picture p = new PictureImpl(5, 5);
	for (int i = 0; i < p.getHeight(); i++) {
	    for (int j = 0; j < p.getWidth(); j++) {
		if (j % 3 == 0)
		    p.setPixel(j, i, RED);
		if ((j - 1) % 3 == 0)
		    p.setPixel(j, i, GREEN);
		if (j == 2)
		    p.setPixel(j, i, BLUE);
	    }
	}
	Iterator<SubPicture> tileIter = p.tile(2, 2);
	for (int i = 0; i < 3; i += 2) {
	    for (int j = 0; j < 3; j += 2) {
		assertEquals("hasNext does not return true when it should do so", true, tileIter.hasNext());
		assertTrue("Returned subPicture does not match expected subPicture",
			compareSubPictures(p.extract(j, i, 2, 2), tileIter.next()));
	    }
	}

	assertEquals("Tile iterator returns true for hasNext when it should be false", false, tileIter.hasNext());

	try {
	    p.tile(-1, -2);
	    fail("IllegalArgumentException not thrown for " + "negative tile width/tile height");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    p.tile(6, 2);
	    fail("IllegalArgumentException not thrown for " + "out of bounds tile width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    p.tile(2, 6);
	    fail("IllegalArgumentException not thrown for " + "out of bounds tile height");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but received RuntimeException");
	}

	try {
	    tileIter.next();
	    fail("Iterator did not return NoSuchElementException");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but received" + "RuntimeException.");
	}

    }

    /*
     * Helper method for determining equality of subPictures and pictures
     */
    static public boolean compareSubPictures(SubPicture a, SubPicture b) {
	if (a.getSource() == b.getSource() && a.getXOffset() == b.getXOffset() && a.getYOffset() == b.getYOffset()
		&& a.getHeight() == b.getHeight() && a.getWidth() == b.getWidth())
	    return true;
	else
	    return false;
    }
}

package a5.tas127;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6jedi.*;

/**
 * A test for the Assignment 6 'jedi' difficulty. Tests the zigzag iterator for
 * a Picture.
 * 
 * @author Taylor Smith
 *
 */
public class A6JediTest {

    /**
     * An epsilon bound to test for equality. Can be updated to make sure the
     * values are closer together.
     */
    private static final double EQUALS_BOUND = .00001;

    /**
     * A method that returns the names of the tests written to test Assignment 6
     * 'jedi' difficulty.
     * 
     * @return An array of Strings that contains the names of the written tests.
     */
    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagTest";

	return test_names;
    }

    @Test
    public void zigzagTest() {
	PictureImpl pic = new PictureImpl(8, 8);

	randomizePic(pic);
	randomizePic(pic);

	Iterator<Pixel> zigIt = pic.zigzag();

	assertTrue(comparePixels(pic.getPixel(0, 0), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(1, 0), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(0, 1), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(0, 2), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(1, 1), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(2, 0), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(3, 0), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(2, 1), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(1, 2), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(0, 3), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(0, 4), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(1, 3), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(2, 2), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(3, 1), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(4, 0), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(5, 0), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(4, 1), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(3, 2), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(2, 3), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(1, 4), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(0, 5), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(0, 6), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(1, 5), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(2, 4), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(3, 3), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(4, 2), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(5, 1), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(6, 0), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(7, 0), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(6, 1), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(5, 2), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(4, 3), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(3, 4), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(2, 5), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(1, 6), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(0, 7), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(1, 7), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(2, 6), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(3, 5), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(4, 4), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(5, 3), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(6, 2), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(7, 1), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(7, 2), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(6, 3), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(5, 4), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(4, 5), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(3, 6), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(2, 7), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(3, 7), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(4, 6), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(5, 5), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(6, 4), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(7, 3), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(7, 4), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(6, 5), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(5, 6), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(4, 7), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(5, 7), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(6, 6), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(7, 5), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(7, 6), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(6, 7), zigIt.next()));
	assertTrue(comparePixels(pic.getPixel(7, 7), zigIt.next()));

	assertFalse(zigIt.hasNext());
	try {
	    zigIt.next();
	    fail("Should've thrown exception");
	} catch (NoSuchElementException e) {

	}
    }

    private static boolean comparePixels(Pixel a, Pixel b) {
	return (Math.abs(a.getIntensity() - b.getIntensity()) < EQUALS_BOUND);
    }

    /**
     * Randomizes a Picture with new pixel values. Makes the tests less
     * predictable.
     * 
     * @param pic
     *            The picture to randomize.
     */
    private static void randomizePic(Picture pic) {
	for (int x = 0; x < pic.getWidth(); x++) {
	    for (int y = 0; y < pic.getHeight(); y++) {
		pic.setPixel(new Coordinate(x, y), new ColorPixel(Math.random(), Math.random(), Math.random()));
	    }
	}
    }
}

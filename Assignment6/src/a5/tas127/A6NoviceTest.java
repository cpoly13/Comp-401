package a5.tas127;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

/**
 * A test for the Assignment 6 'novice' difficulty. Tests the Coordinate class
 * and the new overloaded Picture methods using the Coordinate class. It also
 * tests the basic iterator.
 * 
 * @author Taylor Smith
 *
 */
public class A6NoviceTest {
    /**
     * Width for a Picture. Used so that it can easily be changed in only one
     * spot and the test will update
     */
    private final int WIDTH = 5;
    /**
     * Height for a Picture. Used so that it can easily be changed in only one
     * spot and the test will update
     */
    private final int HEIGHT = 5;

    /**
     * An epsilon bound to test for equality. Can be updated to make sure the
     * values are closer together.
     */
    private static final double EQUALS_BOUND = .0001;

    /**
     * A method that returns the names of the tests written to test Assignment 6
     * 'novice' difficulty.
     * 
     * @return An array of Strings that contains the names of the written tests.
     */
    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "newExtractTest";
	test_names[1] = "coordinateTest";
	test_names[2] = "iteratorTest";
	test_names[3] = "newGetAndSetPixelTest";

	return test_names;
    }

    /**
     * A method that tests the Coordinate class.
     */
    @Test
    public void coordinateTest() {
	int randX = (int) (Math.random() * 100);
	int randY = (int) (Math.random() * 100);
	Coordinate c = new Coordinate(randX, randY);

	assertEquals(randX, c.getX());
	assertEquals(randY, c.getY());
    }

    /**
     * A method that tests the getPixel and setPixel methods of the Picture
     * classes using the new Coordinate class.
     */
    @Test
    public void newGetAndSetPixelTest() {
	PictureImpl pic = new PictureImpl(WIDTH, HEIGHT);
	double[][] intensities = new double[WIDTH][HEIGHT];
	for (int x = 0; x < pic.getWidth(); x++) {
	    for (int y = 0; y < pic.getHeight(); y++) {
		double rand = Math.random();
		pic.setPixel(new Coordinate(x, y), new GrayPixel(rand));
		intensities[x][y] = rand;
	    }
	}

	for (int x = 0; x < pic.getWidth(); x++) {
	    for (int y = 0; y < pic.getHeight(); y++) {
		assertEquals(intensities[x][y], pic.getPixel(new Coordinate(x, y)).getIntensity(), EQUALS_BOUND);
	    }
	}

	GrayPixel p = new GrayPixel(.5);

	// test that exceptions are thrown for new setPixel
	try {
	    pic.setPixel(new Coordinate(-1, 0), p);
	    fail("Can't set out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.setPixel(new Coordinate(0, -1), p);
	    fail("Can't set out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.setPixel(new Coordinate(-1, -1), p);
	    fail("Can't set out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.setPixel(new Coordinate(WIDTH, 0), p);
	    fail("Can't set out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.setPixel(new Coordinate(0, HEIGHT), p);
	    fail("Can't set out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.setPixel(new Coordinate(WIDTH, HEIGHT), p);
	    fail("Can't set out of bounds");
	} catch (RuntimeException e) {

	}

	// test that exceptions are thrown for new getPixel
	try {
	    pic.getPixel(new Coordinate(-1, 0));
	    fail("Can't get out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.getPixel(new Coordinate(0, -1));
	    fail("Can't get out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.getPixel(new Coordinate(-1, -1));
	    fail("Can't get out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.getPixel(new Coordinate(WIDTH, 0));
	    fail("Can't get out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.getPixel(new Coordinate(0, HEIGHT));
	    fail("Can't get out of bounds");
	} catch (RuntimeException e) {

	}
	try {
	    pic.getPixel(new Coordinate(WIDTH, HEIGHT));
	    fail("Can't get out of bounds");
	} catch (RuntimeException e) {

	}
    }

    /**
     * A method that tests the new extract method that uses the Coordinate
     * class.
     */
    @Test
    public void newExtractTest() {
	PictureImpl pic = new PictureImpl(WIDTH, HEIGHT);
	randomizePic(pic);

	// sub picture of everything but a 'frame'
	SubPicture sub = pic.extract(new Coordinate(1, 1), new Coordinate(3, 3));
	for (int x = 0; x < sub.getWidth(); x++) {
	    for (int y = 0; y < sub.getHeight(); y++) {
		assertEquals(sub.getPixel(new Coordinate(x, y)).getIntensity(),
			pic.getPixel(x + sub.getXOffset(), y + sub.getYOffset()).getIntensity(), EQUALS_BOUND);
	    }
	}

	try {
	    pic.extract(new Coordinate(-1, 0), new Coordinate(1, 1));
	    fail("Expected extraction to fail");
	} catch (IllegalArgumentException e) {

	}
	try {
	    pic.extract(new Coordinate(0, -1), new Coordinate(1, 1));
	    fail("Expected extraction to fail");
	} catch (IllegalArgumentException e) {

	}
	try {
	    pic.extract(new Coordinate(0, 0), new Coordinate(WIDTH, HEIGHT));
	    fail("Expected extraction to fail");
	} catch (IllegalArgumentException e) {

	}
	try {
	    pic.extract(new Coordinate(0, 0), new Coordinate(WIDTH, 2));
	    fail("Expected extraction to fail");
	} catch (IllegalArgumentException e) {

	}
	try {
	    pic.extract(new Coordinate(0, 0), new Coordinate(2, HEIGHT));
	    fail("Expected extraction to fail");
	} catch (IllegalArgumentException e) {

	}
    }

    /**
     * Tests the basic iterator for a Picture.
     */
    @Test
    public void iteratorTest() {
	PictureImpl pic = new PictureImpl(WIDTH, HEIGHT);

	randomizePic(pic);

	Iterator<Pixel> iter = pic.iterator();

	for (int y = 0; y < pic.getHeight(); y++) {
	    for (int x = 0; x < pic.getWidth(); x++) {
		assertTrue(iter.hasNext());
		assertEquals(pic.getPixel(new Coordinate(x, y)).getIntensity(), iter.next().getIntensity(),
			EQUALS_BOUND);
	    }
	}

	// make sure that error is thrown
	try {
	    iter.next();
	    fail("Should've thrown a NoSuchElementException");
	} catch (NoSuchElementException e) {

	}

	assertFalse(iter.hasNext());

	// now try with an iterator of a subpicture
	SubPicture sub = pic.extract(1, 1, 3, 3);
	randomizePic(sub);
	Iterator<Pixel> iter2 = sub.iterator();

	for (int y = 0; y < sub.getHeight(); y++) {
	    for (int x = 0; x < sub.getWidth(); x++) {
		assertTrue(iter2.hasNext());
		assertEquals(sub.getPixel(x, y).getIntensity(), iter2.next().getIntensity(), EQUALS_BOUND);
	    }
	}

	try {
	    iter2.next();
	    fail("Should've thrown a NoSuchElementException");
	} catch (NoSuchElementException e) {

	}

	assertFalse(iter2.hasNext());
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
package a5.tas127;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6adept.*;

/**
 * A test for the Assignment 6 'adept' difficulty. Tests the sample, window, and
 * tile iterators for a Picture.
 * 
 * @author Taylor Smith
 *
 */
public class A6AdeptTest {
    /**
     * Width for a Picture. Used so that it can easily be changed in only one
     * spot and the test will update
     */
    private final int WIDTH = 15;
    /**
     * Height for a Picture. Used so that it can easily be changed in only one
     * spot and the test wlil update
     */
    private final int HEIGHT = 10;
    /**
     * An epsilon bound to test for equality. Can be updated to make sure the
     * values are closer together.
     */
    private static final double EQUALS_BOUND = .0001;

    /**
     * Width for a Picture. Used so that it can easily be changed in only one
     * spot and the test will update
     */
    private final int WIDTH2 = 10;
    /**
     * Height for a Picture. Used so that it can easily be changed in only one
     * spot and the test will update
     */
    private final int HEIGHT2 = 10;
    /**
     * A change in x value used for the sample iterator. Used so that it can
     * easily be changed in only one spot and the test will update
     */
    private final int DX = 2;
    /**
     * A change in y value used for the sample iterator. Used so that it can
     * easily be changed in only one spot and the test will update
     */
    private final int DY = 3;

    /**
     * A method that returns the names of the tests written to test Assignment 6
     * 'adept' difficulty.
     * 
     * @return An array of Strings that contains the names of the written tests.
     */
    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "tileTest";
	test_names[1] = "sampleTest";
	test_names[2] = "windowTest";

	return test_names;
    }

    /**
     * Tests the 'sample' iterator for a Picture.
     */
    @Test
    public void sampleTest() {
	PictureImpl pic = new PictureImpl(WIDTH, HEIGHT);

	Iterator<Pixel> sampleIter = pic.sample(2, 3, 3, 4);

	assertTrue(sampleIter.hasNext());

	assertEquals(pic.getPixel(2, 3).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);
	assertEquals(pic.getPixel(5, 3).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);
	assertEquals(pic.getPixel(8, 3).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);
	assertEquals(pic.getPixel(11, 3).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);
	assertEquals(pic.getPixel(14, 3).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);
	assertEquals(pic.getPixel(2, 7).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);
	assertEquals(pic.getPixel(5, 7).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);
	assertEquals(pic.getPixel(8, 7).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);
	assertEquals(pic.getPixel(11, 7).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);
	assertEquals(pic.getPixel(14, 7).getIntensity(), sampleIter.next().getIntensity(), EQUALS_BOUND);

	assertFalse(sampleIter.hasNext());

	try {
	    sampleIter.next();
	    fail("Should have thrown an exception.");
	} catch (NoSuchElementException e) {

	}

	SubPicture sub = pic.extract(DX, DY, WIDTH2, HEIGHT2 / 2);
	Iterator<Pixel> iter2 = sub.sample(DX, DY, DX, DY);

	assertTrue(iter2.hasNext());

	int countX = DX;
	int countY = DY;
	while (iter2.hasNext()) {
	    assertEquals(sub.getPixel(countX, countY).getIntensity(), iter2.next().getIntensity(), EQUALS_BOUND);
	    countX += DX;

	    if (countX >= sub.getWidth()) {
		countX = DX;
		countY += DY;
	    }
	}

	try {
	    iter2.next();
	    fail("Should've thrown an exception");
	} catch (NoSuchElementException e) {

	}

	assertFalse(iter2.hasNext());

	// test for bad parameters for sample
	try {
	    iter2 = pic.sample(-1, 0, 1, 1);
	    fail("Can't go out of bounds");
	} catch (IllegalArgumentException e) {

	}
	try {
	    iter2 = pic.sample(0, -1, 1, 1);
	    fail("Can't go out of bounds");
	} catch (IllegalArgumentException e) {

	}
	try {
	    iter2 = pic.sample(-1, -1, 1, 1);
	    fail("Can't go out of bounds");
	} catch (IllegalArgumentException e) {

	}
	try {
	    iter2 = pic.sample(0, 0, -1, 1);
	    fail("Can't go out of bounds");
	} catch (IllegalArgumentException e) {

	}
	try {
	    iter2 = pic.sample(0, 0, 1, -1);
	    fail("Can't go out of bounds");
	} catch (IllegalArgumentException e) {

	}
	try {
	    iter2 = pic.sample(0, 0, -1, -1);
	    fail("Can't go out of bounds");
	} catch (IllegalArgumentException e) {

	}
    }

    /**
     * Tests the 'window' iterator for a Picture.
     */
    @Test
    public void windowTest() {
	PictureImpl pic = new PictureImpl(5, 5);
	randomizePic(pic);

	Iterator<SubPicture> subIt = pic.window(3, 2);

	assertTrue(subIt.hasNext());

	assertTrue(subPictureEquals(pic.extract(0, 0, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(1, 0, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(2, 0, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(0, 1, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(1, 1, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(2, 1, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(0, 2, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(1, 2, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(2, 2, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(0, 3, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(1, 3, 3, 2), subIt.next()));
	assertTrue(subPictureEquals(pic.extract(2, 3, 3, 2), subIt.next()));

	assertFalse(subIt.hasNext());

	try {
	    subIt.next();
	    fail("Should've thrown exception");
	} catch (NoSuchElementException e) {

	}

	int windowWidth = 2;
	int windowHeight = 4;
	int width = 10;
	int height = 15;
	int curX = 0;
	int curY = 0;

	pic = new PictureImpl(width, height);
	randomizePic(pic);

	subIt = pic.window(windowWidth, windowHeight);
	while (subIt.hasNext()) {
	    assertTrue(subIt.hasNext());
	    assertTrue(subPictureEquals(pic.extract(curX, curY, windowWidth, windowHeight), subIt.next()));
	    curX++;
	    if (curX + windowWidth > pic.getWidth()) {
		curX = 0;
		curY++;
	    }
	}

	// test for bad parameters
	try {
	    subIt = pic.window(0, 1);
	    fail("Width too small");
	} catch (IllegalArgumentException e) {

	}
	try {
	    subIt = pic.window(1, 0);
	    fail("Height too small");
	} catch (IllegalArgumentException e) {

	}
	try {
	    subIt = pic.window(0, 0);
	    fail("Width and height too small");
	} catch (IllegalArgumentException e) {

	}
	try {
	    subIt = pic.window(pic.getWidth() + 1, 1);
	    fail("Width too much");
	} catch (IllegalArgumentException e) {

	}
	try {
	    subIt = pic.window(1, pic.getHeight() + 1);
	    fail("Height too much");
	} catch (IllegalArgumentException e) {

	}
	try {
	    subIt = pic.window(pic.getWidth() + 1, pic.getHeight() + 1);
	    fail("Width and height too much");
	} catch (IllegalArgumentException e) {

	}
    }

    /**
     * Tests the 'tile' iterator of a Picture.
     */
    @Test
    public void tileTest() {
	PictureImpl pic = new PictureImpl(5, 5);
	randomizePic(pic);

	Iterator<SubPicture> tileIter = pic.tile(2, 2);

	assertTrue(tileIter.hasNext());

	assertTrue(subPictureEquals(pic.extract(0, 0, 2, 2), tileIter.next()));
	assertTrue(subPictureEquals(pic.extract(2, 0, 2, 2), tileIter.next()));
	assertTrue(subPictureEquals(pic.extract(0, 2, 2, 2), tileIter.next()));
	assertTrue(subPictureEquals(pic.extract(2, 2, 2, 2), tileIter.next()));

	assertFalse(tileIter.hasNext());

	try {
	    tileIter.next();
	    fail("Should've thrown an exception");
	} catch (NoSuchElementException e) {

	}

	int width = 17;
	int height = 32;
	int tileWidth = 3;
	int tileHeight = 4;
	int curX = 0;
	int curY = 0;

	pic = new PictureImpl(width, height);
	randomizePic(pic);

	tileIter = pic.tile(tileWidth, tileHeight);

	while (tileIter.hasNext()) {
	    assertTrue(tileIter.hasNext());
	    assertTrue(subPictureEquals(pic.extract(curX, curY, tileWidth, tileHeight), tileIter.next()));
	    curX += tileWidth;
	    if (curX >= pic.getWidth() - tileWidth) {
		curX = 0;
		curY += tileHeight;
	    }
	}

	// test tile bad parameters
	try {
	    tileIter = pic.tile(0, 1);
	    fail("Width too small");
	} catch (IllegalArgumentException e) {

	}
	try {
	    tileIter = pic.tile(1, 0);
	    fail("Height too small");
	} catch (IllegalArgumentException e) {

	}
	try {
	    tileIter = pic.tile(0, 0);
	    fail("Height and width too small");
	} catch (IllegalArgumentException e) {

	}
	try {
	    tileIter = pic.tile(pic.getWidth() + 1, 1);
	    fail("Width too much");
	} catch (IllegalArgumentException e) {

	}
	try {
	    tileIter = pic.tile(1, pic.getHeight() + 1);
	    fail("Height too much");
	} catch (IllegalArgumentException e) {

	}
	try {
	    tileIter = pic.tile(pic.getWidth() + 1, pic.getHeight() + 1);
	    fail("Width and height too much");
	} catch (IllegalArgumentException e) {

	}
    }

    /**
     * A private method that ensures that two subpictures are equal.
     * 
     * @param sub1
     *            The first subpicture to compare.
     * @param sub2
     *            The second subpicture to compare.
     * @return If both subpictures are equal in every way.
     */
    private static boolean subPictureEquals(SubPicture sub1, SubPicture sub2) {
	if (sub1.getWidth() != sub2.getWidth()) {
	    return false;
	}
	if (sub1.getHeight() != sub2.getHeight()) {
	    return false;
	}
	if (sub1.getXOffset() != sub2.getXOffset()) {
	    return false;
	}
	if (sub1.getYOffset() != sub2.getYOffset()) {
	    return false;
	}
	for (int x = 0; x < sub1.getWidth(); x++) {
	    for (int y = 0; y < sub1.getHeight(); y++) {
		if (Math.abs(sub1.getPixel(x, y).getIntensity() - sub2.getPixel(x, y).getIntensity()) > EQUALS_BOUND) {
		    return false;
		}
	    }
	}
	return true;
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

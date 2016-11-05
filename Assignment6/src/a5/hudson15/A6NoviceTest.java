package a5.hudson15;

import static org.junit.Assert.*;

import a6novice.*;
import org.junit.Test;

import java.util.Iterator;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "pixelIteratorReturnsCorrectObject";
	test_names[1] = "setPixelCoordinate";
	test_names[2] = "getPixelCoordinate";
	test_names[3] = "pixelIteratorNoSuchElement";
	test_names[4] = "extractCoordinate";

	return test_names;
    }

    @Test // Tests that the pixel iterator returns the correct objects and that
	  // the final next() call returns the proper exception
    public void pixelIteratorReturnsCorrectObject() {

	int width = 20;
	int height = 10;
	Picture testPic = new PictureImpl(width, height);
	Iterator<Pixel> testPicIterator = testPic.iterator();

	for (int h = 0; h < height; h++) {
	    for (int w = 0; w < width; w++) {
		assertEquals("Iterator returns the wrong pixel", testPic.getPixel(w, h), testPicIterator.next());
	    }
	}

	try {
	    testPicIterator.next();
	    fail("Shouldnt be any more pixels, expected NoSuchElementException");
	} catch (java.util.NoSuchElementException e) {

	}

    }

    @Test // Tests that the pixel iterator returns the correct objects and that
	  // the final next() call returns the proper exception
    public void pixelIteratorNoSuchElement() {

	int width = 20;
	int height = 10;
	Picture testPic = new PictureImpl(width, height);
	Iterator<Pixel> testPicIterator = testPic.iterator();

	for (int i = 0; i < height * width; i++) {
	    testPicIterator.next();
	}

	try {
	    testPicIterator.next();
	    fail("Shouldn't be any more pixels, expected NoSuchElementException");
	} catch (java.util.NoSuchElementException e) {

	}
    }

    @Test // Tests that the Coordinate function of setPixel the same as x y
    public void setPixelCoordinate() {
	Picture xyTestPic = testPic(2, 2);
	Picture coordinateTestPic = testPic(2, 2);

	Pixel testPixel = new ColorPixel(.1, .2, .3);

	xyTestPic.setPixel(1, 0, testPixel);

	Coordinate oneZero = new Coordinate(1, 0);
	coordinateTestPic.setPixel(oneZero, testPixel);

	assertEquals("Overloaded setPixel using coordinate does not match xy version", coordinateTestPic.getPixel(1, 0),
		xyTestPic.getPixel(1, 0));

    }

    @Test // Tests that the getCoordinate version of getPixel functions the same
	  // as x y
    public void getPixelCoordinate() {
	Picture testPic = testPic(2, 2);
	Pixel testPixel = new ColorPixel(.1, .2, .3);

	testPic.setPixel(0, 0, testPixel);
	Coordinate zeroZero = new Coordinate(0, 0);

	assertEquals("Overloaded getPixel using coordinate does not match xy version", testPic.getPixel(0, 0),
		testPic.getPixel(zeroZero));

    }

    @Test // Tests that the getCoordinate version of extract functions the same
	  // as x y
    public void extractCoordinate() {
	Picture testPic = testPic(5, 5);
	Pixel testPixel = new ColorPixel(.1, .2, .3);

	testPic.setPixel(2, 0, testPixel);
	testPic.setPixel(0, 3, testPixel);
	testPic.setPixel(1, 0, testPixel);
	testPic.setPixel(2, 2, testPixel);

	Picture xyExtract = testPic.extract(0, 0, 5, 5);
	Picture coordinateExtract = testPic.extract(new Coordinate(0, 0), new Coordinate(4, 4));

	assertEquals("Overloaded extract SubPicture using coordinate does not match xy version", true,
		comparePictures(xyExtract, coordinateExtract));

    }

    // returns a picture filled with random Pixels
    private Picture testPic(int width, int height) {
	Picture testPic = new PictureImpl(width, height);

	for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
		testPic.setPixel(x, y, new ColorPixel(Math.random(), Math.random(), Math.random()));
	    }
	}
	return testPic;

    }

    // Compares two pictures and returns Boolean
    private boolean comparePictures(Picture firstPic, Picture secondPic) {
	// Compare sizes
	if (firstPic.getHeight() != secondPic.getHeight() || firstPic.getWidth() != secondPic.getWidth()) {
	    return false;
	}

	for (int i = 0; i < firstPic.getHeight() * firstPic.getWidth(); i++) {
	    // compare pixels
	    if (firstPic.iterator().next() != secondPic.iterator().next()) {
		return false;
	    }
	}

	return true;

    }

}

package a5.luismart;

import static org.junit.Assert.fail;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "exampleTest";

	return test_names;
    }

    @SuppressWarnings("null")
    @Test
    public void nullTestXCoordConstructor() {
	try {
	    new Coordinate((Integer) null, 1);
	    fail("Cannot pass null x value to coordinate constructor");
	} catch (NullPointerException e) {

	}
    }

    @SuppressWarnings("null")
    @Test
    public void nullTestYCoordConstructor() {
	try {
	    new Coordinate(1, (Integer) null);
	    fail("Cannot pass null y value to coordinate constructor");
	} catch (NullPointerException e) {

	}
    }

    @Test
    public void nullExtractTest() {
	Coordinate topCoord = null;
	Coordinate bottomCoord = new Coordinate(3, 3);
	PictureImpl example = new PictureImpl(5, 5);
	try {
	    example.extract(topCoord, bottomCoord);
	    fail("Cannot pass a null coordinate A to extract method");
	} catch (NullPointerException e) {

	} catch (IllegalArgumentException e) {

	}
	try {
	    example.extract(bottomCoord, topCoord);
	    fail("Cannot pass a null coordinate B to extract method");
	} catch (NullPointerException e) {

	} catch (IllegalArgumentException e) {

	}
    }

    @Test
    public void oversizeExtractTest() {
	Coordinate topCoord = new Coordinate(0, 0);
	Coordinate bottomCoord = new Coordinate(7, 7);
	PictureImpl example = new PictureImpl(5, 5);
	try {
	    example.extract(topCoord, bottomCoord);
	    fail("Cannot create a SubPicture bigger than original picture");
	} catch (NullPointerException e) {

	} catch (IllegalArgumentException e) {

	}
    }

    @Test
    public void nullGetPixelTest() {
	PictureImpl example = new PictureImpl(5, 5);
	try {
	    example.getPixel(null);
	    fail("Cannot test a null coordinate to method getPixel");
	} catch (NullPointerException e) {

	} catch (IllegalArgumentException e) {

	}

    }

    @Test
    public void nullCoordSetPixelTest() {
	Coordinate nullCoord = null;
	Coordinate origin = new Coordinate(0, 0);
	PictureImpl example = new PictureImpl(5, 5);
	Pixel testPixel = example.getPixel(origin);
	try {
	    example.setPixel(nullCoord, testPixel);
	    fail("Cannot test a null coordinate to method getPixel");
	} catch (NullPointerException e) {

	} catch (IllegalArgumentException e) {

	}
    }
}

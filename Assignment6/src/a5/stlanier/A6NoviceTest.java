package a5.stlanier;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "nullTests";
	test_names[1] = "coordinateTests";
	test_names[2] = "iteratorTests";

	return test_names;
    }

    @SuppressWarnings("unused")
    @Test
    public void nullTests() {
	try {
	    Coordinate c = null;
	    Picture myPic = null;
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException instead of generic RuntimeException.");
	}
    }

    @Test
    public void coordinateTests() {
	Pixel a = new ColorPixel(1, 1, 0);
	Pixel b = new ColorPixel(1, 0, 0);
	Pixel c = new ColorPixel(0, 0, 0);
	Coordinate aSpot = new Coordinate(0, 0);
	Coordinate bSpot = new Coordinate(2, 1);
	Coordinate cSpot = new Coordinate(2, 2);
	Picture myPic = new PictureImpl(3, 3);
	myPic.setPixel(aSpot, a);
	myPic.setPixel(bSpot, b);
	myPic.setPixel(cSpot, c);

	assertEquals("Inaccurately sets Pixel using Coordinate", myPic.getPixel(0, 0), a);
	assertEquals("Inaccurately sets Pixel using Coordinate", myPic.getPixel(2, 1), b);
	assertEquals("Inaccurately sets Pixel using Coordinate", myPic.getPixel(2, 2), c);

    }

    @Test
    public void iteratorTests() {
	Pixel a = new ColorPixel(1, 1, 0);
	Pixel b = new ColorPixel(1, 0, 0);
	Pixel c = new ColorPixel(0, 0, 0);
	Picture myPic = new PictureImpl(3, 3);
	myPic.setPixel(0, 0, a);
	myPic.setPixel(2, 1, b);
	myPic.setPixel(2, 2, c);
	Iterator<Pixel> myIt = myPic.iterator();

	assertEquals("Inaccurately implements next().", myIt.hasNext(), true);
	assertEquals("Inaccurately traverses picture.", myIt.next(), a);

	myIt.next();
	myIt.next();
	myIt.next();
	myIt.next();
	assertEquals("Inaccurately traverses pictues.", myIt.next(), b);

	myIt.next();
	myIt.next();
	assertEquals("Inaccurately implements next().", myIt.hasNext(), true);
	assertEquals("Inaccurately traverses pictues.", myIt.next(), c);
	assertEquals("Inaccurately implements next().", myIt.hasNext(), false);

	try {
	    myIt.next();
	    fail("Expected NoSuchElementException for out of range next().");
	} catch (java.util.NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but got generic RuntimeException");
	}

    }

}

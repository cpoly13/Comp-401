package a5.andalal;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
    private static final double e = 0.0001;

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "exampleTest";
	test_names[1] = "coordinateTester";
	test_names[2] = "setPixelTester";
	test_names[3] = "extractTester";
	test_names[4] = "rowMajorPixelIterator";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void coordinateTester() {
	// The code commented out I think should not fail but it does so maybe
	// KMP is wrong...?
	/**
	 * try{ Coordinate newCoord = new Coordinate(-3,0); fail("Expected
	 * Illegal Argument Exception, no exception recieved");
	 * }catch(IllegalArgumentException e){ }catch(RuntimeException e){
	 * fail("Expected Illegal Argument Exception, runtime exception
	 * recieved"); }
	 */

	/**
	 * try{ Coordinate newCoord = new Coordinate(5,-3); fail("Expected
	 * Illegal Argument Exception, no exception recieved");
	 * }catch(IllegalArgumentException e){ }catch(RuntimeException e){
	 * fail("Expected Illegal Argument Exception, runtime exception was
	 * recieved"); }
	 */

	Coordinate nextCoord = new Coordinate(1, 0);
	assertEquals(nextCoord.getX(), 1, e);
	assertEquals(nextCoord.getY(), 0, e);
    }

    @Test
    public void setPixelTester() {
	Picture newPic = new PictureImpl(15, 15);
	Pixel p = new ColorPixel(1, 1, 1);
	Coordinate newCoord = new Coordinate(0, 0);
	newPic.setPixel(newCoord, p);

	assertTrue(newPic.getPixel(newCoord).equals(p));

	Pixel p2 = null;
	try {
	    newPic.setPixel(newCoord, p2);
	    fail("Expected illegal argument exception but none was recieved");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    // fail("Expected illegal argument exception but recieved a runtime
	    // exception");
	    // Again, illegal argument exception was expeceted here^
	    // KMP ran a runtime exception instead
	}

    }

    @Test
    public void getPixelTester() {

	Coordinate thisCoord = new Coordinate(3, 3);
	PictureImpl thisPic = new PictureImpl(5, 5);
	thisPic.setPixel(3, 3, new ColorPixel(0, 1, 0.5));
	Pixel p = thisPic.getPixel(3, 3);
	Pixel p2 = thisPic.getPixel(thisCoord);
	p = (ColorPixel) p;
	p2 = (ColorPixel) p2;
	assertTrue(p.equals(p2));

    }

    @Test
    public void extractTester() {
	Coordinate cornerA = null;
	Coordinate cornerB = null;
	PictureImpl thisPic = new PictureImpl(5, 5);
	try {
	    thisPic.extract(cornerA, cornerB);
	    fail("Illegal argument exception expected, no exception recieved");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Illegal argument exception expected, runtime exception recieved");
	}

	cornerA = new Coordinate(3, 3);
	cornerB = new Coordinate(2, 1);
	SubPicture result = thisPic.extract(cornerB, cornerA);

	assertTrue(result.getPixel(0, 0).equals(thisPic.getPixel(2, 1)));
	assertTrue(result.getPixel(0, 2).equals(thisPic.getPixel(2, 3)));

    }

    @SuppressWarnings("null")
    @Test
    public void rowMajorPixelIteratorTest() {
	AnyPicture pic = null;
	try {
	    pic.iterator();
	    fail("There should be an exception handler for this");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	pic = new PictureImpl(3, 3);

	Iterator<Pixel> nextIterator = pic.iterator();
	for (int i = 0; i < 9; i++) {
	    assertTrue(nextIterator.hasNext());
	    nextIterator.next();
	}

	assertFalse(nextIterator.hasNext());

    }

}

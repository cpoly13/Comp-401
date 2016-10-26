package a5.vatsal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "getPixelTest";
	test_names[1] = "setPixelTest";
	test_names[2] = "hasNextTest";
	test_names[3] = "nextTest";

	return test_names;
    }

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    /*
     * Implementation of overridden getPixel method which receives a coordinate
     * object Use version of method by passing coordinate object Use version of
     * method by manually entering x and y coordinates compare to make sure both
     * return the same Pixel object
     */
    @Test
    public void getPixelTest() {

	// Picture takes in (width,height)
	Picture examplePicture = new PictureImpl(3, 5);
	Coordinate exampleCoordinate = new Coordinate(1, 2);
	assertEquals(examplePicture.getPixel(exampleCoordinate).equals(examplePicture.getPixel(1, 2)), true);
    }

    /*
     * Implementation of overridden setPixel method which receives a coordinate
     * object. Test to see if setPixel method acts upon a new Picture object
     */

    @Test
    public void setPixelTest() {
	Picture examplePicture1 = new PictureImpl(3, 5);
	Picture examplePicture2 = new PictureImpl(3, 5);
	Coordinate exampleCoordinate = new Coordinate(2, 2);
	Pixel p = RED;
	examplePicture2.setPixel(exampleCoordinate, p);

	assertEquals(examplePicture1.equals(examplePicture2), false);
    }

    /*
     * Check to see if in row major order, if there is another pixel after the
     * pixel of focus
     */

    @Test
    public void hasNextTest() {
	Picture examplePicture = new PictureImpl(2, 2);
	Iterator<Pixel> exampleIterator = examplePicture.iterator();
	assertEquals(exampleIterator.hasNext(), true);
	exampleIterator.next();
	assertEquals(exampleIterator.hasNext(), true);
	exampleIterator.next();
	assertEquals(exampleIterator.hasNext(), true);
	exampleIterator.next();
	assertEquals(exampleIterator.hasNext(), true);
	exampleIterator.next();
	assertEquals(exampleIterator.hasNext(), false);

    }

    /*
     * Check to see if iterator method is iterating properly through a Picture
     * object
     */

    @Test
    public void nextTest() {
	Picture examplePicture = new PictureImpl(2, 2);
	examplePicture.setPixel(0, 0, GREEN);
	examplePicture.setPixel(1, 0, RED);
	examplePicture.setPixel(0, 1, BLUE);
	examplePicture.setPixel(1, 1, BLUE);
	Iterator<Pixel> exampleIterator = examplePicture.iterator();
	if (exampleIterator.hasNext()) {
	    assertTrue(exampleIterator.next().equals(GREEN));
	}
	if (exampleIterator.hasNext()) {
	    assertTrue(exampleIterator.next().equals(RED));
	}
	if (exampleIterator.hasNext()) {
	    assertTrue(exampleIterator.next().equals(BLUE));
	}
	if (exampleIterator.hasNext()) {
	    Pixel p = exampleIterator.next();
	    assertTrue(p.equals(BLUE));
	}

    }

}

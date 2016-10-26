package a5.deleeke;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "testPictureIterator";
	test_names[1] = "testCoordinate";
	test_names[2] = "testSubpicture";
	test_names[3] = "testPicture";

	return test_names;
    }

    @Test
    public void testCoordinate() {

	try {
	    new Coordinate(1, 1);
	} catch (Exception e) {
	    fail("Coordinate constructor does not work");
	}

	Coordinate p2 = new Coordinate(1, 1);
	assertEquals(1, p2.getX());
	assertEquals(1, p2.getY());

    }

    @Test
    public void testPictureIterator() {
	Picture pic = new PictureImpl(15, 15);
	Iterator<Pixel> picIter = pic.iterator();
	while (picIter.hasNext()) {
	    try {
		picIter.next();
	    } catch (Exception e) {
		fail("Picture iterator hasNext() method did not work properly");
	    }
	}
	try {
	    picIter.next();
	} catch (NoSuchElementException e) {

	} catch (Exception e) {
	    fail("Attempting to go past last element pixel array should throw NoSuchElementException");
	}
    }

    @Test
    public void testPicture() {
	Picture pic = new PictureImpl(15, 15);
	Pixel dark = new GrayPixel(0.2);
	Pixel light = new GrayPixel(0.8);
	Coordinate p1 = new Coordinate(0, 0);
	Coordinate p2 = new Coordinate(10, 10);
	pic.setPixel(p1, dark);
	pic.setPixel(p2, light);
	assertTrue(pic.getPixel(p1).equals(dark));
	assertTrue(pic.getPixel(p2).equals(light));
    }

    @Test
    public void testSubpicture() {
	Picture pic = new PictureImpl(15, 15);
	Pixel dark = new GrayPixel(0.2);
	Pixel light = new GrayPixel(0.8);
	Coordinate p1 = new Coordinate(0, 0);
	Coordinate p2 = new Coordinate(10, 10);
	pic.setPixel(p1, dark);
	pic.setPixel(p2, light);
	assertTrue(pic.getPixel(p1).equals(dark));
	assertTrue(pic.getPixel(p2).equals(light));

	// create a 'SubPicture' that is actually the entire picture
	// so p1 and p2 should still refer to the same pixels
	Coordinate mincorner = new Coordinate(0, 0);
	Coordinate maxcorner = new Coordinate(14, 9);
	Picture subpic = pic.extract(mincorner, maxcorner);
	// assert that the pixel at p1 should still be
	// what we set them to be
	assertTrue(subpic.getPixel(p1).equals(dark));

    }

}

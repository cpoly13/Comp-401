package a5.markp;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "testUpdatedCoordinateGettersAndSetters";
	test_names[1] = "testUpdatedExtract";
	test_names[2] = "testIterator";
	test_names[3] = "testExceptions";

	return test_names;
    }

    // tests to make sure the updated getter method that uses Coordinate is
    // correct
    @Test
    public void testUpdatedCoordinateGettersAndSetters() {
	Picture original = new PictureImpl(4, 4);
	int i = 0;
	int j = 0;
	Coordinate c = new Coordinate(i, j);

	for (c.getX(); i < original.getHeight(); i++) {
	    for (c.getY(); j < original.getWidth(); j++) {
		if (i == 0) {
		    original.setPixel(c.getY(), c.getX(), RED);
		} else if (i == 1) {
		    original.setPixel(c.getY(), c.getX(), BLACK);
		} else if (i == 2) {
		    original.setPixel(c.getY(), c.getX(), GREEN);
		} else if (i == 3) {
		    original.setPixel(c.getY(), c.getX(), WHITE);
		}

	    }
	}

	// using coordinate class created to make sure it can correctly be
	// created to get pixels
	SubPicture sub = new SubPictureImpl(original, 2, 2, 1, 1);
	assertEquals("Coordinate class not correclty implemented", original.getPixel(new Coordinate(2, 2)),
		sub.getPixel(new Coordinate(0, 0)));
	assertEquals("Coordinate class not correclty implemented", original.getPixel(new Coordinate(2, 3)),
		sub.getPixel(new Coordinate(0, 1)));
	assertEquals("Coordinate class not correclty implemented", original.getPixel(new Coordinate(3, 2)),
		sub.getPixel(new Coordinate(1, 0)));
	assertEquals("Coordinate class not correclty implemented", original.getPixel(new Coordinate(3, 3)),
		sub.getPixel(new Coordinate(1, 1)));

    }

    // tests to make sure the updated setter method that uses Coordinate is
    // correct
    @Test
    public void testUpdatedExtract() {
	Picture original = new PictureImpl(4, 2);

	original.setPixel(0, 0, BLUE);
	original.setPixel(1, 0, RED);
	original.setPixel(2, 0, GREEN);
	original.setPixel(3, 0, WHITE);
	original.setPixel(0, 1, BLACK);
	original.setPixel(1, 1, WHITE);
	original.setPixel(2, 1, BLUE);
	original.setPixel(3, 1, GREEN);

	// testing the sub picture of original picture
	SubPicture sub = original.extract(new Coordinate(0, 1), new Coordinate(2, 1));
	assertEquals("Subpicture pixel does not match respective Picture pixel", original.getPixel(0, 1),
		sub.getPixel(0, 0));
	assertEquals("Subpicture pixel does not match respective Picture pixel", original.getPixel(1, 1),
		sub.getPixel(1, 0));
	assertEquals("Subpicture pixel does not match respective Picture pixel", original.getPixel(2, 1),
		sub.getPixel(2, 0));

	// testing the sub picture of the sub picture
	SubPicture sub2 = sub.extract(new Coordinate(1, 0), new Coordinate(2, 0));
	assertEquals("Second subpicture pixel does not match respective subpicture pixel", sub.getPixel(1, 0),
		sub2.getPixel(0, 0));
	assertEquals("Second subpicture pixel does not match respective subpicture pixel", sub.getPixel(2, 0),
		sub2.getPixel(1, 0));
	assertEquals("Second subpicture pixel does not match original picture pixel", original.getPixel(1, 1),
		sub2.getPixel(0, 0));
	assertEquals("Second subpicture pixel does not match original picture pixel", original.getPixel(2, 1),
		sub2.getPixel(1, 0));

    }

    // tests the functionality of the iterator
    @Test
    public void testIterator() {
	Picture pic = new PictureImpl(2, 2);

	pic.setPixel(0, 0, BLUE);
	pic.setPixel(1, 0, GREEN);
	pic.setPixel(0, 1, RED);
	pic.setPixel(1, 1, WHITE);

	Iterator<Pixel> iter = pic.iterator();

	assertTrue("There should be another pixel in the array.", iter.hasNext());
	assertEquals("Next pixel does not match expected pixel.", pic.getPixel(0, 0), iter.next());

	assertTrue("There should be another pixel in the array.", iter.hasNext());
	assertEquals("Next pixel does not match expected pixel.", pic.getPixel(1, 0), iter.next());

	assertTrue("There should be another pixel in the array.", iter.hasNext());
	assertEquals("Next pixel does not match expected pixel.", pic.getPixel(0, 1), iter.next());

	assertTrue("There should be another pixel in the array.", iter.hasNext());
	assertEquals("Next pixel does not match expected pixel.", pic.getPixel(1, 1), iter.next());

	assertFalse("There should not be another pixel in the array.", iter.hasNext());

    }

    // tests exceptions in the code
    @SuppressWarnings("null")
    @Test
    public void testExceptions() {
	Picture p = new PictureImpl(3, 3);
	for (int i = 0; i < p.getHeight(); i++) {
	    for (int j = 0; j < p.getWidth(); j++) {
		if (i == 0) {
		    p.setPixel(j, i, RED);
		} else if (i == 1) {
		    p.setPixel(j, i, BLACK);
		} else if (i == 2) {
		    p.setPixel(j, i, GREEN);
		}
	    }
	}

	try {
	    Picture nullPicture = null;
	    nullPicture.iterator();
	    fail("Expected Null Pointer Exception for not providing a picture");
	} catch (NullPointerException e) {
	} catch (RuntimeException e) {
	    fail("Expected Null Pointer Exception but got generic Runtime Exception");
	}

	try {
	    Coordinate c = new Coordinate(4, 0);
	    p.setPixel(c, WHITE);
	    fail("X coordinate out of bounds");
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate c = new Coordinate(0, 4);
	    p.setPixel(c, WHITE);
	    fail("Y coordinate out of bounds");
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate c = new Coordinate(-1, -1);
	    p.setPixel(c, WHITE);
	    fail("Coordinates cannot be negative");
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate cornerA = new Coordinate(3, 0);
	    Coordinate cornerB = new Coordinate(3, 2);
	    p.extract(cornerA, cornerB);
	    fail("Extract method arguments out of bounds");
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate cornerA = new Coordinate(1, 2);
	    Coordinate cornerB = new Coordinate(1, 4);
	    p.extract(cornerA, cornerB);
	    fail("Extract method arguments out of bounds");
	} catch (RuntimeException e) {
	}

	try {
	    Picture q = new PictureImpl(2, 2);
	    Iterator<Pixel> iter = q.iterator();
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next(); // this line should cause iterator to be out of bounds
	    fail("Iterator called next method when there was no more pixels in the picture");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected No Such Element Exception but got generic Runtime Exception instead");
	}

	try {
	    Picture q = new PictureImpl(1, 1);
	    Iterator<Pixel> iter = q.iterator();
	    iter.next();
	    iter.next(); // this line should cause iterator to be out of bounds
	    fail("Iterator called next method when there was no more pixels in the picture");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected No Such Element Exception but got generic Runtime Exception instead");
	}

    }

}

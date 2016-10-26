package a5.byi14;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

//Collaborated with David Le

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Picture PICTURE = new PictureImpl(3, 3);

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "testGetSetPixelCoord";
	test_names[1] = "testIterator";
	test_names[2] = "testIteratorException";
	test_names[3] = "testSubpictureExtractbyCoord";
	test_names[4] = "testSubpictureExtractbyCoordException";

	return test_names;
    }

    @Test
    public void testGetSetPixelCoord() {

	Coordinate c = new Coordinate(0, 0);
	PICTURE.setPixel(0, 0, RED);

	assertEquals("Pixel retreived using coordinate does not match pixel from source", RED, PICTURE.getPixel(c));
    }

    @Test
    public void testIterator() {

	PICTURE.setPixel(1, 1, RED);
	Iterator<Pixel> i = PICTURE.iterator();

	for (int j = 0; j < 4; j++) {
	    i.next();
	}

	assertEquals("Pixel from iterator does not match expected pixel value", RED, i.next());

    }

    @Test
    public void testIteratorException() {

	Iterator<Pixel> i = PICTURE.iterator();

	for (int j = 0; j < 9; j++) {
	    i.next();
	}

	try {
	    i.next();
	    fail("Expected NoSuchElementException");
	} catch (java.util.NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException");
	}
    }

    @Test
    public void testSubpictureExtractbyCoord() {

	PICTURE.setPixel(1, 1, RED);
	PICTURE.setPixel(2, 1, BLUE);
	PICTURE.setPixel(1, 2, GREEN);
	PICTURE.setPixel(2, 2, BLUE);

	Coordinate c1 = new Coordinate(1, 1);
	Coordinate c2 = new Coordinate(2, 2);
	SubPicture spCoord = PICTURE.extract(c1, c2);

	assertEquals("Extract pixel values do not match expected pixel values", RED, spCoord.getPixel(0, 0));
	assertEquals("Extract pixel values do not match expected pixel values", BLUE, spCoord.getPixel(1, 0));
	assertEquals("Extract pixel values do not match expected pixel values", GREEN, spCoord.getPixel(0, 1));
	assertEquals("Extract pixel values do not match expected pixel values", BLUE, spCoord.getPixel(1, 1));
    }

    @Test
    public void testSubpictureExtractbyCoordException() {

	Coordinate c1 = new Coordinate(1, 1);
	Coordinate c2 = new Coordinate(2, 2);
	Coordinate c3 = new Coordinate(88888, 88888);
	SubPicture spCoord = PICTURE.extract(c1, c2);

	try {
	    spCoord.getPixel(c3);
	    fail("Expected Runtime Exception");
	} catch (RuntimeException e) {
	}
    }
}

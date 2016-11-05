package a5.zsofiav1;

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
	return new String[] { "testCoordinateSubPicture", "testCoordinateGettersAndSetters", "testIterator",
		"testExceptions" };
    }

    /*
     * testCoordinateSubPicture Tests to see if a SubPicture extracted by giving
     * 2 Coordinates is identical to a SubPicture extracted by giving offsets
     * and height/width
     */
    @Test
    public void testCoordinatesSubPicture() {
	Coordinate a = new Coordinate(2, 3);
	Coordinate b = new Coordinate(6, 7);
	Picture p = new PictureImpl(9, 8);
	SubPicture sp = new SubPictureImpl(p, 2, 3, 5, 5);
	SubPicture sp2 = p.extract(a, b);

	assertEquals("Result from getSource() does not match source picture", p, sp.getSource());
	assertEquals("X offset does not match value given to constructor", 2, sp.getXOffset());
	assertEquals("Y offset does not match value given to constructor", 3, sp.getYOffset());
	assertEquals("Width does not match value given to constructor", 5, sp.getWidth());
	assertEquals("Height does not match value given to constructor", 5, sp.getHeight());
	assertEquals("Source for Subpictures do not match", sp2.getSource(), sp.getSource());
	assertEquals("X offset for Subpictures do not match", sp2.getXOffset(), sp.getXOffset());
	assertEquals("Y offset for Subpictures do not match", sp2.getYOffset(), sp.getYOffset());
	assertEquals("Width for Subpictures do not match", sp2.getWidth(), sp.getWidth());
	assertEquals("Height for Subpictures do not match", sp2.getHeight(), sp.getHeight());
    }

    /*
     * testCoordinateGettersAndSetters Tests to see whether setting a Pixel
     * using a Coordinate sets correct pixel Tests getter methods using
     * Coordinates in both Pictures and SubPictures
     */
    @Test
    public void testCoordinateGettersAndSetters() {
	Picture p = new PictureImpl(3, 3);
	Coordinate a = new Coordinate(0, 0);
	Coordinate b = new Coordinate(1, 0);
	Coordinate c = new Coordinate(2, 0);
	Coordinate d = new Coordinate(0, 1);
	Coordinate e = new Coordinate(1, 1);
	Coordinate f = new Coordinate(2, 1);
	Coordinate g = new Coordinate(0, 2);
	Coordinate h = new Coordinate(1, 2);
	Coordinate i = new Coordinate(2, 2);
	p.setPixel(a, RED);
	p.setPixel(b, RED);
	p.setPixel(c, RED);
	p.setPixel(d, GREEN);
	p.setPixel(e, BLUE);
	p.setPixel(f, WHITE);
	p.setPixel(g, BLACK);
	p.setPixel(h, BLACK);
	p.setPixel(i, RED);

	SubPicture sp = p.extract(e, i);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(e),
		sp.getPixel(a));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(f),
		sp.getPixel(b));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(h),
		sp.getPixel(d));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(i),
		sp.getPixel(e));

	sp.setPixel(a, RED);
	assertEquals("Pixel retrieved after setting does not match expected value", RED, sp.getPixel(a));
	assertEquals("Pixel in source not changed after setting through subpicture", RED, p.getPixel(a));

	SubPicture sp2 = sp.extract(e, e);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(i),
		sp2.getPixel(a));

    }

    /*
     * testIterator Tests iterator of a Picture; Whether it returns correct
     * boolean hasNext() at the start and the end Tests if correct Pixels were
     * returned when next() is called
     */
    @Test
    public void testIterator() {
	Picture p = new PictureImpl(2, 2);
	Coordinate a = new Coordinate(0, 0);
	Coordinate b = new Coordinate(1, 0);
	Coordinate c = new Coordinate(0, 1);
	Coordinate d = new Coordinate(1, 1);
	p.setPixel(a, RED);
	p.setPixel(b, BLUE);
	p.setPixel(c, WHITE);
	p.setPixel(d, GREEN);

	Iterator<Pixel> iter = p.iterator();
	assertEquals("hasNext() at start is false", true, iter.hasNext());
	assertEquals("0,0 is not red", RED, iter.next());
	assertEquals("0,1 is not white", BLUE, iter.next());
	assertEquals("1,0 is not blue", WHITE, iter.next());
	assertEquals("1,1 is not green", GREEN, iter.next());
	assertEquals("hasNext() at end is true", false, iter.hasNext());

    }

    /*
     * testExceptions Tests whether exceptions are correctly thown; - when a
     * null picture tries to create an iterator - NoSuchElementException thrown
     * when .next() is called after iterator is done - IllegalArgumentExceptions
     * thrown when null coordinates are used for getPixel, setPixel, or extract
     */
    @SuppressWarnings("null")
    @Test
    public void testExceptions() {
	Picture p = null;
	try {
	    p.iterator();
	} catch (Exception e) {
	}
	Picture p2 = new PictureImpl(1, 1);
	try {
	    Iterator<Pixel> iter = p2.iterator();
	    iter.next();
	    iter.next();
	} catch (NoSuchElementException e) {
	} catch (Exception e) {
	    fail("Exception was not NoSuchElementException");
	}
	Picture p3 = new PictureImpl(2, 2);
	Coordinate a = null;
	try {
	    p3.getPixel(a);
	    fail("Expected IllegalArgumentException for null Coordinate");
	} catch (IllegalArgumentException e) {
	} catch (Exception e) {
	    fail("Exception was not IllegalArgumentException");
	}
	try {
	    p3.extract(a, a);
	    fail("Expected IllegalArgumentException for null Coordinate");
	} catch (IllegalArgumentException e) {
	} catch (Exception e) {
	    fail("Exception was not IllegalArgumentException");
	}
	try {
	    p3.setPixel(a, WHITE);
	    fail("Expected IllegalArgumentException for null Coordinate");
	} catch (IllegalArgumentException e) {
	} catch (Exception e) {
	    fail("Exception was not IllegalArgumentException");
	}
    }
}

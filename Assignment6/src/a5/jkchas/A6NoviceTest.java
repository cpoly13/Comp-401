package a5.jkchas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "coordinateConstructorTest";
	test_names[1] = "subpictureCoordinateExtractTest";
	test_names[2] = "setPixelTest";
	test_names[3] = "pixelIteratorTest";
	test_names[4] = "pixelIteratorExceptionsTest";

	return test_names;
    }

    // Tests that the constructor assigns the correct values to the instance
    @Test
    public void coordinateConstructorTest() {
	Coordinate a = new Coordinate(1, 1);

	assertEquals("Coordinate supplied is not the one returned", 1, a.getX());
	assertEquals("Coordinate supplied is not the one returned", 1, a.getY());
    }

    // Ensures that the overloaded extract method works properly
    @Test
    public void subpictureCoordinateExtractTest() {
	Coordinate a = new Coordinate(1, 1);
	Coordinate b = new Coordinate(2, 2);
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);
	SubPicture sp = p.extract(a, b);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 1), sp.getPixel(0, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 1), sp.getPixel(1, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 2), sp.getPixel(0, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 2), sp.getPixel(1, 1));
    }

    // Makes sure that the set pixel method given a coordinate works
    @Test
    public void setPixelTest() {
	Coordinate a = new Coordinate(0, 0);
	Coordinate b = new Coordinate(0, 1);
	Coordinate c = new Coordinate(0, 2);
	Coordinate d = new Coordinate(1, 0);
	Coordinate e = new Coordinate(1, 1);
	Coordinate f = new Coordinate(1, 2);
	Coordinate g = new Coordinate(2, 0);
	Coordinate h = new Coordinate(2, 1);
	Coordinate i = new Coordinate(2, 2);
	Picture p = new PictureImpl(3, 3);
	p.setPixel(a, RED);
	p.setPixel(b, RED);
	p.setPixel(c, RED);
	p.setPixel(d, GREEN);
	p.setPixel(e, BLUE);
	p.setPixel(f, WHITE);
	p.setPixel(g, BLACK);
	p.setPixel(h, BLACK);
	p.setPixel(i, RED);

	assertEquals("Pixel stored via setter does not match expected pixel value", p.getPixel(0, 0), RED);
	assertEquals("Pixel stored via setter does not match expected pixel value", p.getPixel(0, 1), RED);
	assertEquals("Pixel stored via setter does not match expected pixel value", p.getPixel(0, 2), RED);
	assertEquals("Pixel stored via setter does not match expected pixel value", p.getPixel(1, 0), GREEN);
	assertEquals("Pixel stored via setter does not match expected pixel value", p.getPixel(1, 1), BLUE);
	assertEquals("Pixel stored via setter does not match expected pixel value", p.getPixel(1, 2), WHITE);
	assertEquals("Pixel stored via setter does not match expected pixel value", p.getPixel(2, 0), BLACK);
	assertEquals("Pixel stored via setter does not match expected pixel value", p.getPixel(2, 1), BLACK);
	assertEquals("Pixel stored via setter does not match expected pixel value", p.getPixel(2, 2), RED);
    }

    // Shows that the iterator does not go extend beyond the number of pixels in
    // picture
    @Test
    public void pixelIteratorTest() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);

	Iterator<Pixel> iterator = p.iterator();
	assertEquals("The iterator should have next object", iterator.hasNext(), true);
	iterator.next();
	iterator.next();
	iterator.next();
	iterator.next();
	iterator.next();
	iterator.next();
	iterator.next();
	iterator.next();
	iterator.next();
	assertEquals("The iterator should not have next object", iterator.hasNext(), false);

    }

    // Checks the exception handling of the iterator
    @Test
    public void pixelIteratorExceptionsTest() {
	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> iterator = p.iterator();
	iterator.next();
	iterator.next();
	iterator.next();
	iterator.next();
	try {
	    iterator.next();
	    fail("Expected NoSuchElementException");
	} catch (java.util.NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but got generic RuntimeException");
	}

	try {
	    iterator.remove();
	    fail("Expected UnsupportedOperationException");
	} catch (UnsupportedOperationException e) {
	} catch (RuntimeException e) {
	    fail("Expected UnsupportedOperationException but got generic RuntimeException");
	}

    }
}

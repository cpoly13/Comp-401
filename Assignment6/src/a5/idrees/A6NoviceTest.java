package a5.idrees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "exampleTest";
	test_names[1] = "getPixelTest";
	test_names[2] = "extractTest";
	test_names[3] = "nextExceptionTest";

	return test_names;
    }

    @Test
    public void getPixelTest() {
	Coordinate coord = new Coordinate(0, 1);
	PictureImpl impl = new PictureImpl(100, 100);
	Pixel pixel = new GrayPixel(0.5);
	impl.setPixel(coord, pixel);
	assertEquals("Returned pixel does not match pixel at location", pixel, impl.getPixel(coord));
    }

    @Test
    public void extractTest() {
	PictureImpl impl = new PictureImpl(100, 100);
	for (int x = 0; x < 10; x++) {
	    for (int y = 0; y < 10; y++) {
		impl.setPixel(new Coordinate(x, y), new GrayPixel((x + y) / 18));
	    }
	}
	SubPicture sub = impl.extract(new Coordinate(0, 0), new Coordinate(9, 9));
	for (int x = 0; x < 10; x++) {
	    for (int y = 0; y < 10; y++) {
		assertEquals("Pixel in subpicture was not equal to the pixel in the source picture",
			impl.getPixel(new Coordinate(x, y)), sub.getPixel(new Coordinate(x, y)));
	    }
	}
    }

    @Test
    public void nextExceptionTest() {
	Picture picture = new PictureImpl(1, 1);
	Iterator<Pixel> iter = picture.iterator();
	iter.next();
	try {
	    iter.next();
	    fail("Expected NoSuchElementException but no exception was thrown");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but got generic RuntimeException");
	}
    }

    @Test
    public void exampleTest() {
    }
}

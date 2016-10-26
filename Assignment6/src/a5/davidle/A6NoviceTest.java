package a5.davidle;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Picture PICTURE = new PictureImpl(5, 5);
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "javaBeanTest";
	test_names[1] = "iteratorExceptionTest";
	test_names[2] = "basicIteratorTest";
	test_names[3] = "subExtractbyCoordTest";
	test_names[4] = "outofBoundCoordTest";

	return test_names;
    }

    @Test
    public void javaBeanTest() {
	Coordinate c = new Coordinate(1, 2);
	PICTURE.setPixel(c, WHITE);
	assertEquals("Pixel retrieved does not match expected", WHITE, PICTURE.getPixel(c));
    }

    @Test
    public void iteratorExceptionTest() {
	Iterator<Pixel> i = PICTURE.iterator();
	try {
	    for (int a = 0; a < 26; ++a) {
		i.next();
	    }
	    fail("Expected NoSuchElementException");
	} catch (java.util.NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but got generic RuntimeException");
	}
    }

    @Test
    public void subExtractbyCoordTest() {
	Coordinate corner_a = new Coordinate(1, 1);
	Coordinate corner_b = new Coordinate(2, 2);
	Picture p = new PictureImpl(4, 4);
	p.setPixel(1, 1, WHITE);
	p.setPixel(2, 1, RED);
	p.setPixel(1, 2, BLUE);
	p.setPixel(2, 2, GREEN);
	Picture s = p.extract(corner_a, corner_b);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 1), s.getPixel(0, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 1), s.getPixel(1, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 2), s.getPixel(0, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 2), s.getPixel(1, 1));
    }

    @Test
    public void outofBoundCoordTest() {
	Coordinate corner_a = new Coordinate(0, 0);
	Coordinate corner_b = new Coordinate(2, 2);
	Coordinate c = new Coordinate(2, 6);
	Picture p = PICTURE.extract(corner_a, corner_b);
	try {
	    p.setPixel(c, BLACK);
	    fail("Expected RuntimeException");
	} catch (RuntimeException e) {
	}
    }

    @Test
    public void basicIteratorTest() {
	Picture p = new PictureImpl(2, 2);
	p.setPixel(0, 0, WHITE);
	p.setPixel(1, 0, RED);
	p.setPixel(0, 1, BLUE);
	p.setPixel(1, 1, GREEN);
	Iterator<Pixel> i = p.iterator();
	for (int a = 0; a < 2; ++a) {
	    for (int b = 0; b < 2; ++b) {
		assertEquals("Pixel retrieved from iterator does not match expected pixel", i.next(), p.getPixel(b, a));
	    }
	}
    }
}

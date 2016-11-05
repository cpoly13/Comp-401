package a5.stvn426;

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
	String[] test_names = new String[3];

	test_names[0] = "testGetterAndSetter";
	test_names[1] = "testOverloadedExtract";
	test_names[2] = "testNoSuchElementException";

	return test_names;
    }

    @Test
    public void testGetterAndSetter() {
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
	Coordinate c1 = new Coordinate(1, 1);
	Coordinate c2 = new Coordinate(1, 2);
	Coordinate c3 = new Coordinate(0, 2);
	Coordinate c4 = new Coordinate(0, 0);

	assertEquals("Pixel retrieved from getPixel does not match expected", p.getPixel(1, 1), p.getPixel(c1));
	assertEquals("Pixel retrieved from getPixel does not match expected", p.getPixel(1, 2), p.getPixel(c2));
	assertEquals("Pixel retrieved from getPixel does not match expected", p.getPixel(0, 2), p.getPixel(c3));
	assertEquals("Pixel retrieved from getPixel does not match expected", p.getPixel(0, 0), p.getPixel(c4));

	p.setPixel(c1, WHITE);
	p.setPixel(c2, RED);
	p.setPixel(c3, BLUE);
	p.setPixel(c4, GREEN);

	assertEquals("Pixel retrieved after setPixel does not match expected", p.getPixel(1, 1), p.getPixel(c1));
	assertEquals("Pixel retrieved after setPixel does not match expected", p.getPixel(1, 2), p.getPixel(c2));
	assertEquals("Pixel retrieved after setPixel does not match expected", p.getPixel(0, 2), p.getPixel(c3));
	assertEquals("Pixel retrieved after setPixel does not match expected", p.getPixel(0, 0), p.getPixel(c4));
    }

    @Test
    public void testOverloadedExtract() {
	Picture p = new PictureImpl(5, 5);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(3, 0, BLUE);
	p.setPixel(4, 0, GREEN);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(3, 1, RED);
	p.setPixel(4, 1, BLUE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);
	p.setPixel(3, 2, GREEN);
	p.setPixel(4, 2, BLACK);
	p.setPixel(0, 3, RED);
	p.setPixel(1, 3, RED);
	p.setPixel(2, 3, RED);
	p.setPixel(3, 3, GREEN);
	p.setPixel(4, 3, GREEN);
	p.setPixel(0, 4, GREEN);
	p.setPixel(1, 4, GREEN);
	p.setPixel(2, 4, GREEN);
	p.setPixel(3, 4, GREEN);
	p.setPixel(4, 4, GREEN);

	Coordinate c1 = new Coordinate(2, 2);
	Coordinate c2 = new Coordinate(4, 4);
	SubPicture sp2 = p.extract(c1, c2);

	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(c1),
		sp2.getPixel(0, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(c2),
		sp2.getPixel(2, 2));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(3, 3), sp2.getPixel(1, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(3, 2), sp2.getPixel(1, 0));

    }

    @Test
    public void testNoSuchElementException() {
	Picture p = new PictureImpl(3, 3);
	Iterator<Pixel> it = p.iterator();
	for (int i = 0; i < p.getWidth(); i++) {
	    for (int j = 0; j < p.getHeight(); j++) {
		it.next();
	    }
	}

	try {
	    it.next();
	    fail("Expected NoSuchElementException after last pixel is traversed");
	} catch (NoSuchElementException e) {
	} catch (RuntimeException e) {
	    fail("Expected NoSuchElementException but got generic RuntimeException");
	}
    }
}

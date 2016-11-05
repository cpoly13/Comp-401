//Collaborator:Ying Zheng, Yinan Wu
package a5.ziqinglu;

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
	String[] test_names = new String[5];

	test_names[0] = "SettersTest";
	test_names[1] = "ExtractTest";
	test_names[2] = "ExtractExceptionTest";
	test_names[3] = "TestIteratorException";
	test_names[4] = "TestGetter";
	return test_names;
    }

    @Test
    public void SettersTest() {
	Picture p = new PictureImpl(5, 5);
	try {
	    Coordinate cr = new Coordinate(-1, 4);
	    p.setPixel(cr, RED);
	    fail("x is negative");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate cr2 = new Coordinate(4, -1);
	    p.setPixel(cr2, RED);
	    fail("y is negative");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {

	}

	try {
	    Coordinate cr3 = new Coordinate(6, 4);
	    p.setPixel(cr3, RED);
	    fail("x exceeds width bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate cr4 = new Coordinate(4, 6);
	    p.setPixel(cr4, RED);
	    fail("y exceeds height bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
    }

    @Test
    public void TestGetter() {
	Picture p = new PictureImpl(5, 5);
	try {
	    Coordinate cr = new Coordinate(-1, 4);
	    p.getPixel(cr);
	    fail("x is negative");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate cr2 = new Coordinate(4, -1);
	    p.getPixel(cr2);
	    fail("y is negative");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {

	}

	try {
	    Coordinate cr3 = new Coordinate(6, 4);
	    p.getPixel(cr3);
	    fail("x exceeds width bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate cr4 = new Coordinate(4, 6);
	    p.getPixel(cr4);
	    fail("y exceeds height bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
    }

    @Test
    public void ExtractTest() {
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
	SubPicture sp = p.extract(new Coordinate(1, 1), new Coordinate(2, 2));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(1, 1)), sp.getPixel(new Coordinate(0, 0)));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(2, 1)), sp.getPixel(new Coordinate(1, 0)));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(1, 2)), sp.getPixel(new Coordinate(0, 1)));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(2, 2)), sp.getPixel(new Coordinate(1, 1)));

    }

    public void ExtractExceptionTest() {
	Picture p = new PictureImpl(3, 3);
	try {

	    Coordinate cr1 = new Coordinate(-1, 2);
	    Coordinate cr2 = new Coordinate(2, 2);
	    p.extract(cr1, cr2);
	    fail("x is negative");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate cr1 = new Coordinate(2, 2);
	    Coordinate cr2 = new Coordinate(2, -1);

	    p.extract(cr1, cr2);
	    fail("y is negative");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {

	}

	try {
	    Coordinate cr1 = new Coordinate(3, 2);
	    Coordinate cr2 = new Coordinate(2, 2);
	    p.extract(cr1, cr2);
	    fail("x exceeds width bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    Coordinate cr1 = new Coordinate(2, 2);
	    Coordinate cr2 = new Coordinate(2, 3);

	    p.extract(cr1, cr2);
	    fail("y exceeds height bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

    }

    @Test
    public void IteratorTest() {
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
	Iterator<Pixel> iter = p.iterator();

	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(0, 0)), iter.next());
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(1, 0)), iter.next());
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(2, 0)), iter.next());
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(0, 1)), iter.next());
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(1, 1)), iter.next());
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(2, 1)), iter.next());
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(0, 2)), iter.next());
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(1, 2)), iter.next());
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(2, 2)), iter.next());

    }

    /*
     * @Test public void SampleTest(){ Picture p = new PictureImpl(3,3);
     * 
     * p.setPixel(0, 0, RED); p.setPixel(1, 0, RED); p.setPixel(2, 0, RED);
     * p.setPixel(0, 1, GREEN); p.setPixel(1, 1, BLUE); p.setPixel(2, 1, WHITE);
     * p.setPixel(0, 2, BLACK); p.setPixel(1, 2, BLACK); p.setPixel(2, 2, RED);
     * Iterator<Pixel> sample_iter = p.sample(2,3,3,4);
     * 
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(2,3)),sample_iter.next());
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(5,3)),sample_iter.next());
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(8,3)),sample_iter.next());
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(11,3)),sample_iter.next());
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(14,3)),sample_iter.next());
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(2,7)),sample_iter.next());
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(5,7)),sample_iter.next());
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(8,7)),sample_iter.next());
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(11,7)),sample_iter.next());
     * assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source"
     * , p.getPixel(new Coordinate(14,7)),sample_iter.next());
     * 
     * }
     */
    @Test
    public void TestIteratorException() {
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
	Iterator<Pixel> iter = p.iterator();

	try {
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();
	    fail("does not have any element left");
	} catch (NoSuchElementException e) {
	}

	{
	}
    }

}

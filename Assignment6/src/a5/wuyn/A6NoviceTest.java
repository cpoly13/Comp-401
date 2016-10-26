//Collaborators: Ying Zheng, Ziqing Lu

package a5.wuyn;

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
	String[] test_names = new String[6];

	test_names[0] = "testPixelSettersExceptions";
	test_names[1] = "testPixelGettersExceptions";
	test_names[2] = "testExtractBasics";
	test_names[3] = "textExtractBadParamaters";
	test_names[4] = "testIteratorBasics";
	test_names[5] = "testIteratorExceptions";

	return test_names;
    }

    @Test
    public void testPixelSettersExceptions() {
	Picture p = new PictureImpl(6, 4);
	Coordinate c_1 = new Coordinate(-1, 0);
	Coordinate c_2 = new Coordinate(0, -1);
	Coordinate c1 = new Coordinate(6, 0);
	Coordinate c2 = new Coordinate(0, 4);
	Coordinate c3 = new Coordinate(1, 1);

	try {
	    p.setPixel(c_1, RED);
	    fail("Expected IllegalArgumentException for x < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.setPixel(c_2, RED);
	    fail("Expected IllegalArgumentException for y < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.setPixel(c1, RED);
	    fail("Expected IllegalArgumentException for x >= width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.setPixel(c2, RED);
	    fail("Expected IllegalArgumentException for y >= height");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.setPixel(c3, null);
	    fail("Expected IllegalArgumentException for null pixel");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
    }

    @Test
    public void testPixelGettersExceptions() {
	Picture p = new PictureImpl(6, 4);
	Coordinate c_1 = new Coordinate(-1, 0);
	Coordinate c_2 = new Coordinate(0, -1);
	Coordinate c1 = new Coordinate(6, 0);
	Coordinate c2 = new Coordinate(0, 4);
	new Coordinate(1, 1);

	try {
	    p.getPixel(c_1);
	    fail("Expected IllegalArgumentException for x < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.getPixel(c_2);
	    fail("Expected IllegalArgumentException for y < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.getPixel(c1);
	    fail("Expected IllegalArgumentException for x >= width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.getPixel(c2);
	    fail("Expected IllegalArgumentException for y >= height");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
    }

    @Test
    public void testExtractBasics() {
	Picture p = new PictureImpl(3, 3);

	Coordinate c_00 = new Coordinate(0, 0);
	Coordinate c_10 = new Coordinate(1, 0);
	Coordinate c_20 = new Coordinate(2, 0);
	Coordinate c_01 = new Coordinate(0, 1);
	Coordinate c_11 = new Coordinate(1, 1);
	Coordinate c_21 = new Coordinate(2, 1);
	Coordinate c_02 = new Coordinate(0, 2);
	Coordinate c_12 = new Coordinate(1, 2);
	Coordinate c_22 = new Coordinate(2, 2);

	p.setPixel(c_00, RED);
	p.setPixel(c_10, RED);
	p.setPixel(c_20, RED);
	p.setPixel(c_01, GREEN);
	p.setPixel(c_11, BLUE);
	p.setPixel(c_21, WHITE);
	p.setPixel(c_02, BLACK);
	p.setPixel(c_12, BLACK);
	p.setPixel(c_22, RED);

	SubPicture sp = p.extract(new Coordinate(1, 1), new Coordinate(2, 2));

	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(1, 1)), sp.getPixel(new Coordinate(0, 0)));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(1, 2)), sp.getPixel(new Coordinate(0, 1)));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(2, 1)), sp.getPixel(new Coordinate(1, 0)));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(2, 2)), sp.getPixel(new Coordinate(1, 1)));

	SubPicture sp2 = p.extract(new Coordinate(1, 0), new Coordinate(1, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(1, 0)), sp2.getPixel(new Coordinate(0, 0)));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(new Coordinate(1, 1)), sp2.getPixel(new Coordinate(0, 1)));
    }

    @Test
    public void testExtactBadParameters() {
	Picture p = new PictureImpl(3, 3);
	Coordinate c1 = new Coordinate(-1, 0);
	Coordinate c2 = new Coordinate(0, -1);
	Coordinate c3 = new Coordinate(3, 0);
	Coordinate c4 = new Coordinate(0, 3);

	try {
	    p.extract(c1, new Coordinate(1, 1));
	    fail("Expected IllegalArgumentException for coordinates out of bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.extract(new Coordinate(1, 1), c2);
	    fail("Expected IllegalArgumentException for coordinates out of bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.extract(c3, new Coordinate(1, 1));
	    fail("Expected IllegalArgumentException for coordinates out of bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}

	try {
	    p.extract(new Coordinate(1, 1), c4);
	    fail("Expected IllegalArgumentException for coordinates out of bound");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
    }

    @Test
    public void testIteratorBasics() {
	Picture p = new PictureImpl(3, 3);

	Coordinate c_00 = new Coordinate(0, 0);
	Coordinate c_10 = new Coordinate(1, 0);
	Coordinate c_20 = new Coordinate(2, 0);
	Coordinate c_01 = new Coordinate(0, 1);
	Coordinate c_11 = new Coordinate(1, 1);
	Coordinate c_21 = new Coordinate(2, 1);
	Coordinate c_02 = new Coordinate(0, 2);
	Coordinate c_12 = new Coordinate(1, 2);
	Coordinate c_22 = new Coordinate(2, 2);

	p.setPixel(c_00, RED);
	p.setPixel(c_10, RED);
	p.setPixel(c_20, RED);
	p.setPixel(c_01, GREEN);
	p.setPixel(c_11, BLUE);
	p.setPixel(c_21, WHITE);
	p.setPixel(c_02, BLACK);
	p.setPixel(c_12, BLACK);
	p.setPixel(c_22, RED);

	Iterator<Pixel> iter = p.iterator();

	boolean b1 = iter.hasNext();
	Pixel p00 = iter.next();

	boolean b2 = iter.hasNext();
	Pixel p10 = iter.next();

	boolean b3 = iter.hasNext();
	Pixel p20 = iter.next();

	boolean b4 = iter.hasNext();
	Pixel p01 = iter.next();

	boolean b5 = iter.hasNext();
	Pixel p11 = iter.next();

	boolean b6 = iter.hasNext();
	Pixel p21 = iter.next();

	boolean b7 = iter.hasNext();
	Pixel p02 = iter.next();

	boolean b8 = iter.hasNext();
	Pixel p12 = iter.next();

	boolean b9 = iter.hasNext();
	Pixel p22 = iter.next();

	boolean b10 = iter.hasNext();

	assertEquals("Pixel from the Interator<Pixel> does not match Pixel from source in order", p.getPixel(c_00),
		p00);
	assertEquals("Pixel from the Interator<Pixel> does not match Pixel from source in order", p.getPixel(c_10),
		p10);
	assertEquals("Pixel from the Interator<Pixel> does not match Pixel from source in order", p.getPixel(c_20),
		p20);
	assertEquals("Pixel from the Interator<Pixel> does not match Pixel from source in order", p.getPixel(c_01),
		p01);
	assertEquals("Pixel from the Interator<Pixel> does not match Pixel from source in order", p.getPixel(c_11),
		p11);
	assertEquals("Pixel from the Interator<Pixel> does not match Pixel from source in order", p.getPixel(c_21),
		p21);
	assertEquals("Pixel from the Interator<Pixel> does not match Pixel from source in order", p.getPixel(c_02),
		p02);
	assertEquals("Pixel from the Interator<Pixel> does not match Pixel from source in order", p.getPixel(c_12),
		p12);
	assertEquals("Pixel from the Interator<Pixel> does not match Pixel from source in order", p.getPixel(c_22),
		p22);

	assertEquals("Next Pixel exists", true, b1);
	assertEquals("Next Pixel exists", true, b2);
	assertEquals("Next Pixel exists", true, b3);
	assertEquals("Next Pixel exists", true, b4);
	assertEquals("Next Pixel exists", true, b5);
	assertEquals("Next Pixel exists", true, b6);
	assertEquals("Next Pixel exists", true, b7);
	assertEquals("Next Pixel exists", true, b8);
	assertEquals("Next Pixel exists", true, b9);
	assertEquals("Next Pixel does not exist", false, b10);
    }

    @Test
    public void testIteratorExceptions() {
	Picture p = new PictureImpl(3, 3);
	try {
	    Iterator<Pixel> iter1 = p.iterator();
	    iter1.next();
	    iter1.next();
	    iter1.next();
	    iter1.next();
	    iter1.next();
	    iter1.next();
	    iter1.next();
	    iter1.next();
	    iter1.next();
	    iter1.next();
	    fail("The last element does not exist");
	} catch (NoSuchElementException e) {
	}
    }

}

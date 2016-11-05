package a5.tsethe;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "getSetPixelCoordinate";
	test_names[1] = "iteratorTest";

	return test_names;
    }

    @Test
    public void getSetPixelCoordinate() {
	Picture p = new PictureImpl(2, 2);

	Coordinate c0 = new Coordinate(0, 0);
	Coordinate c1 = new Coordinate(1, 0);
	Coordinate c2 = new Coordinate(0, 1);
	Coordinate c3 = new Coordinate(1, 1);

	p.setPixel(c0, RED);
	p.setPixel(c1, BLUE);
	p.setPixel(c2, BLACK);
	p.setPixel(c3, WHITE);

	assertEquals("Pixel values do not match", p.getPixel(c0), RED);
	assertEquals("Pixel values do not match", p.getPixel(c1), BLUE);
	assertEquals("Pixel values do not match", p.getPixel(c2), BLACK);
	assertEquals("Pixel values do not match", p.getPixel(c3), WHITE);
    }

    @Test
    public void iteratorTest() {
	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> iter = p.iterator();

	Coordinate c0 = new Coordinate(0, 0);
	Coordinate c1 = new Coordinate(1, 0);
	Coordinate c2 = new Coordinate(0, 1);
	Coordinate c3 = new Coordinate(1, 1);

	p.setPixel(c0, RED);
	p.setPixel(c1, BLUE);
	p.setPixel(c2, BLACK);
	p.setPixel(c3, WHITE);

	assertTrue("Next did not return true", iter.hasNext());
	assertEquals("Pixel values do not match", iter.next(), RED);
	assertTrue("Next did not return true", iter.hasNext());
	assertEquals("Pixel values do not match", iter.next(), BLUE);
	assertTrue("Next did not return true", iter.hasNext());
	assertEquals("Pixel values do not match", iter.next(), BLACK);
	assertTrue("Next did not return true", iter.hasNext());
	assertEquals("Pixel values do not match", iter.next(), WHITE);
	assertFalse("Next did not return true", iter.hasNext());
    }

}
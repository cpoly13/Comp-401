package a5.melissa5;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testZigZagMethod";

	return test_names;
    }

    /*
     * Goal: Test if ZigZag Iterator Method traverses the pixels in zig-zag
     * pattern from top left to bottom right Iterator should go up & to the
     * right on even diagonals and down & to the left on odd diagonals
     */

    @Test
    public void testZigZagMethod() {
	Picture p = new PictureImpl(4, 4);
	Iterator<Pixel> zigzag_iter = p.zigzag();
	p.setPixel(new Coordinate(0, 0), RED);
	p.setPixel(new Coordinate(1, 0), GREEN);
	p.setPixel(new Coordinate(0, 1), BLUE);
	p.setPixel(new Coordinate(0, 2), WHITE);
	p.setPixel(new Coordinate(1, 1), BLACK);
	p.setPixel(new Coordinate(2, 0), BLUE);
	p.setPixel(new Coordinate(3, 0), RED);
	p.setPixel(new Coordinate(2, 1), GREEN);
	p.setPixel(new Coordinate(1, 2), BLACK);
	p.setPixel(new Coordinate(0, 3), WHITE);
	p.setPixel(new Coordinate(1, 3), RED);
	p.setPixel(new Coordinate(2, 2), BLUE);

	assertEquals(zigzag_iter.next(), p.getPixel(0, 0));
	assertEquals(zigzag_iter.next(), p.getPixel(1, 0));
	assertEquals(zigzag_iter.next(), p.getPixel(0, 1));
	assertEquals(zigzag_iter.next(), p.getPixel(0, 2));
	assertEquals(zigzag_iter.next(), p.getPixel(1, 1));
	assertEquals(zigzag_iter.next(), p.getPixel(2, 0));
	assertEquals(zigzag_iter.next(), p.getPixel(3, 0));
	assertEquals(zigzag_iter.next(), p.getPixel(2, 1));
	assertEquals(zigzag_iter.next(), p.getPixel(1, 2));
	assertEquals(zigzag_iter.next(), p.getPixel(0, 3));
	assertEquals(zigzag_iter.next(), p.getPixel(1, 3));
	assertEquals(zigzag_iter.next(), p.getPixel(2, 2));

    }
}

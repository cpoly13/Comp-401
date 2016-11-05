package a5.kbaek11;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    static public String[] getTestNames() {
	return new String[] { "testZigzag" };
    }

    @Test
    public void testZigzag() {

	Picture p1 = new PictureImpl(8, 8);

	p1.setPixel(0, 0, RED);
	p1.setPixel(1, 0, BLUE);
	p1.setPixel(0, 1, GREEN);
	p1.setPixel(0, 2, RED);
	p1.setPixel(1, 1, GREEN);
	p1.setPixel(2, 0, GREEN);

	Iterator<Pixel> iter = p1.zigzag();

	assertEquals(iter.next(), RED);
	assertEquals(iter.next(), BLUE);
	assertEquals(iter.next(), GREEN);
	assertEquals(iter.next(), RED);
	assertEquals(iter.next(), GREEN);
	assertEquals(iter.next(), GREEN);
    }
}

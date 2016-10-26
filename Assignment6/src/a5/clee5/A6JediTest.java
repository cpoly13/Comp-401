package a5.clee5;

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
	return new String[] { "testZigzag" };
    }

    @Test
    public void testZigzag() {
	Picture pic = new PictureImpl(3, 3);
	pic.setPixel(0, 0, RED);
	pic.setPixel(1, 0, RED);
	pic.setPixel(2, 0, RED);
	pic.setPixel(0, 1, GREEN);
	pic.setPixel(1, 1, BLUE);
	pic.setPixel(2, 1, WHITE);
	pic.setPixel(0, 2, BLACK);
	pic.setPixel(1, 2, BLACK);
	pic.setPixel(2, 2, RED);

	Iterator<Pixel> z = pic.zigzag();
	assertEquals(z.next(), RED);
	assertEquals(z.next(), RED);
	assertEquals(z.next(), GREEN);
	assertEquals(z.next(), BLACK);
	assertEquals(z.next(), BLUE);
	assertEquals(z.next(), RED);
	assertEquals(z.next(), WHITE);
	assertEquals(z.next(), BLACK);
	assertEquals(z.next(), RED);
    }
}

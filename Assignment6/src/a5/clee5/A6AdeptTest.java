package a5.clee5;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	return new String[] { "testSample" };
    }

    @Test
    public void testSample() {
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

	Iterator<Pixel> iter = pic.sample(0, 1, 1, 1);
	assertEquals(iter.next(), GREEN);
	assertEquals(iter.next(), BLUE);
	assertEquals(iter.next(), WHITE);
	assertEquals(iter.next(), BLACK);
    }
}

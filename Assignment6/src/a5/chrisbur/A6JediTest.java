package a5.chrisbur;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    public static final Pixel RED = new ColorPixel(1, 0, 0);
    public static final Pixel GREEN = new ColorPixel(0, 1, 0);
    public static final Pixel BLUE = new ColorPixel(0, 0, 1);
    public static final Pixel BLACK = new GrayPixel(0);
    public static final Pixel WHITE = new GrayPixel(1);
    public static final Pixel GRAY = new GrayPixel(.5);

    static public String[] getTestNames() {
	return new String[] { "zigZagTest" };
    }

    public static Picture getPicture() {
	Picture picture = new PictureImpl(4, 2);
	picture.setPixel(0, 0, RED);
	picture.setPixel(1, 0, GREEN);
	picture.setPixel(2, 0, BLUE);
	picture.setPixel(3, 0, WHITE);

	picture.setPixel(0, 1, BLACK);
	picture.setPixel(1, 1, GRAY);
	picture.setPixel(2, 1, GREEN);
	picture.setPixel(3, 1, WHITE);

	return picture;
    }

    @Test
    public void zigZagTest() {
	Iterator<Pixel> iter = getPicture().zigzag();
	assertEquals(.299, iter.next().getIntensity(), .001);
	assertTrue(iter.hasNext());
	assertEquals(0.587, iter.next().getIntensity(), .001);
	assertTrue(iter.hasNext());
	assertEquals(0.0, iter.next().getIntensity(), .001);
	assertTrue(iter.hasNext());
	assertEquals(0.5, iter.next().getIntensity(), .001);
	assertTrue(iter.hasNext());
	assertEquals(0.114, iter.next().getIntensity(), .001);
	assertTrue(iter.hasNext());
	assertEquals(1.0, iter.next().getIntensity(), .001);
	assertTrue(iter.hasNext());
	assertEquals(0.587, iter.next().getIntensity(), .001);
	assertTrue(iter.hasNext());
	assertEquals(1.0, iter.next().getIntensity(), .001);
	assertFalse(iter.hasNext());
    }
}

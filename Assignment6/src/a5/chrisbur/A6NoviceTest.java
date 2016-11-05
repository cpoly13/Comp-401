package a5.chrisbur;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
    public static final Pixel RED = new ColorPixel(1, 0, 0);
    public static final Pixel GREEN = new ColorPixel(0, 1, 0);
    public static final Pixel BLUE = new ColorPixel(0, 0, 1);
    public static final Pixel BLACK = new GrayPixel(0);
    public static final Pixel WHITE = new GrayPixel(1);
    public static final Pixel GRAY = new GrayPixel(.5);

    static public String[] getTestNames() {
	return new String[] { "iteratorTest", "coordinateTest" };
    }

    @Test
    public void coordinateTest() {
	Picture picture = new PictureImpl(3, 2);
	picture.setPixel(1, 0, new GrayPixel(.9));
	assertEquals(.9, picture.getPixel(new Coordinate(1, 0)).getIntensity(), .001);
	picture.setPixel(new Coordinate(2, 1), new GrayPixel(.1));
	assertEquals(.1, picture.getPixel(2, 1).getIntensity(), .001);
    }

    @Test
    public void iteratorTest() {
	Picture picture = new PictureImpl(3, 2);
	picture.setPixel(0, 0, RED);
	picture.setPixel(1, 0, GREEN);
	picture.setPixel(2, 0, BLUE);
	picture.setPixel(0, 1, BLACK);
	picture.setPixel(1, 1, GRAY);
	picture.setPixel(2, 1, GREEN);
	Iterator<Pixel> pixelIterator = picture.iterator();
	assertEquals(true, pixelIterator.hasNext());
	assertEquals(RED, pixelIterator.next());

	assertEquals(true, pixelIterator.hasNext());
	assertEquals(GREEN, pixelIterator.next());

	assertEquals(true, pixelIterator.hasNext());
	assertEquals(BLUE, pixelIterator.next());

	assertEquals(true, pixelIterator.hasNext());
	assertEquals(BLACK, pixelIterator.next());

	assertEquals(true, pixelIterator.hasNext());
	assertEquals(GRAY, pixelIterator.next());

	assertEquals(true, pixelIterator.hasNext());
	assertEquals(GREEN, pixelIterator.next());

	assertFalse(pixelIterator.hasNext());
    }
}

package a5.chrisbur;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    public static final Pixel RED = new ColorPixel(1, 0, 0);
    public static final Pixel GREEN = new ColorPixel(0, 1, 0);
    public static final Pixel BLUE = new ColorPixel(0, 0, 1);
    public static final Pixel BLACK = new GrayPixel(0);
    public static final Pixel WHITE = new GrayPixel(1);
    public static final Pixel GRAY = new GrayPixel(.5);

    static public String[] getTestNames() {
	return new String[] { "sampleTest", "tileTest", "windowTest" };
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
    public void sampleTest() {
	Iterator<Pixel> pixelIterator = getPicture().sample(0, 0, 2, 1);
	assertEquals(true, pixelIterator.hasNext());
	assertEquals(RED, pixelIterator.next());

	assertEquals(true, pixelIterator.hasNext());
	assertEquals(BLUE, pixelIterator.next());

	assertEquals(true, pixelIterator.hasNext());
	assertEquals(BLACK, pixelIterator.next());

	assertEquals(true, pixelIterator.hasNext());
	assertEquals(GREEN, pixelIterator.next());
	assertFalse(pixelIterator.hasNext());

    }

    @Test
    public void tileTest() {
	Iterator<SubPicture> iter = getPicture().tile(2, 2);
	assertTrue(iter.hasNext());

	SubPicture picture1 = iter.next();
	assertEquals(.299, picture1.getPixel(0, 0).getIntensity(), .001);
	assertTrue(iter.hasNext());
	SubPicture picture2 = iter.next();
	assertEquals(.114, picture2.getPixel(0, 0).getIntensity(), .001);
	assertFalse(iter.hasNext());

    }

    @Test
    public void windowTest() {
	Iterator<SubPicture> iter = getPicture().window(2, 2);
	SubPicture picture1 = iter.next();
	assertEquals(.299, picture1.getPixel(0, 0).getIntensity(), .001);
	assertTrue(iter.hasNext());
	SubPicture picture2 = iter.next();
	assertEquals(.587, picture2.getPixel(0, 0).getIntensity(), .001);
	SubPicture picture3 = iter.next();
	assertEquals(.114, picture3.getPixel(0, 0).getIntensity(), .001);
	assertFalse(iter.hasNext());
    }
}

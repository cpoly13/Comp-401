package a5.codyco;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    /*
     * Create static pixels for colors which are specifically black, white, red,
     * green or blue.
     */

    private static Pixel BLACK = new GrayPixel(0);
    private static Pixel WHITE = new GrayPixel(1);

    private static Pixel RED = new ColorPixel(1, 0, 0);
    private static Pixel GREEN = new ColorPixel(0, 1, 0);
    private static Pixel BLUE = new ColorPixel(0, 1, 0);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "testOffset";
	test_names[1] = "testWindow";

	return test_names;
    }

    // Tests that the offset pixels are correct when retrieved from the
    // Iterator.

    @Test
    public void testOffset() {
	Picture picture4 = new PictureImpl(5, 3);

	picture4.setPixel(0, 0, BLUE);
	picture4.setPixel(1, 0, BLACK);
	picture4.setPixel(2, 0, RED);
	picture4.setPixel(3, 0, BLUE);
	picture4.setPixel(4, 0, GREEN);
	picture4.setPixel(0, 1, WHITE);
	picture4.setPixel(1, 1, BLUE);
	picture4.setPixel(2, 1, WHITE);
	picture4.setPixel(3, 1, RED);
	picture4.setPixel(4, 1, GREEN);
	picture4.setPixel(0, 2, WHITE);
	picture4.setPixel(1, 2, BLUE);
	picture4.setPixel(2, 2, WHITE);
	picture4.setPixel(3, 2, RED);
	picture4.setPixel(4, 2, GREEN);

	Iterator<Pixel> picture4Iterator = picture4.sample(2, 1, 1, 2);

	assertTrue(picture4Iterator.hasNext());
	assertEquals("The pixel is the wrong color.", WHITE, picture4Iterator.next());
	assertTrue(picture4Iterator.hasNext());
	assertEquals("The pixel is the wrong color.", RED, picture4Iterator.next());
	assertTrue(picture4Iterator.hasNext());
	assertEquals("The pixel is the wrong color.", GREEN, picture4Iterator.next());

    }

    // Tests that the pixels retrieved from the window iterator are correct.

    @Test
    public void testWindow() {
	Picture picture4 = new PictureImpl(5, 3);
	Coordinate p1 = new Coordinate(0, 0);
	Coordinate p2 = new Coordinate(2, 0);
	Coordinate p3 = new Coordinate(0, 2);
	Coordinate p4 = new Coordinate(2, 0);

	Iterator<SubPicture> windowIterator = picture4.window(3, 2);
	Coordinate sp1 = new Coordinate(0, 0);
	Coordinate sp2 = new Coordinate(2, 0);
	Coordinate sp3 = new Coordinate(0, 2);
	Coordinate sp4 = new Coordinate(2, 0);

	assertTrue(windowIterator.hasNext());
	Picture windowPic = windowIterator.next();
	assertEquals("The Pixel returned is not correct", picture4.getPixel(p1), windowPic.getPixel(sp1));
	assertEquals("The Pixel returned is not correct", picture4.getPixel(p2), windowPic.getPixel(sp2));
	assertEquals("The Pixel returned is not correct", picture4.getPixel(p3), windowPic.getPixel(sp3));
	assertEquals("The Pixel returned is not correct", picture4.getPixel(p4), windowPic.getPixel(sp4));

    }
}

package a5.hasadi;

import static org.junit.Assert.*;
import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "exampleTest";
	test_names[1] = "exampleTest1";
	test_names[2] = "exampleTest2";

	return test_names;
    }

    @Test
    public void exampleTest() {

	Picture p = new PictureImpl(6, 4);
	try {
	    new SubPictureImpl(p, 7, 2, 1, 1);
	    fail("Expected IllegalArgumentException for x offset >= source width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

    }

    @Test
    public void exampleTest1() {

	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);
	Coordinate x = new Coordinate(1, 2);

	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 2), p.getPixel(x));

    }

    @Test
    public void exampleTest2() {

	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);
	Coordinate x = new Coordinate(2, 2);
	p.setPixel(new Coordinate(2, 2), BLACK);

	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 2), p.getPixel(x));

    }
}

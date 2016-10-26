package a5.scottieg;

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
	String[] test_names = new String[5];

	test_names[0] = "testSampleParameters";
	test_names[1] = "testWindowParameters";
	test_names[2] = "testTileParameters";
	test_names[3] = "testSampleMethod";
	test_names[4] = "testWindowMethod";

	return test_names;
    }

    @Test
    public void testSampleParameters() {
	Picture p = new PictureImpl(5, 5);

	try {
	    p.sample(-3, 2, 1, 1);
	    fail("Expected IllegalArgumentException x_init < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.sample(3, -2, 1, 1);
	    fail("Expected IllegalArgumentException y_init < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.sample(10, 2, 1, 1);
	    fail("Expected IllegalArgumentException x_init > width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.sample(3, 10, 1, 1);
	    fail("Expected IllegalArgumentException y_init > height");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.sample(3, 2, -1, 1);
	    fail("Expected IllegalArgumentException dx < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.sample(3, 2, 1, -1);
	    fail("Expected IllegalArgumentException dy < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}
    }

    @Test
    public void testWindowParameters() {
	Picture p = new PictureImpl(5, 5);

	try {
	    p.window(-1, 3);
	    fail("Expected IllegalArgumentException window_width < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.window(1, -3);
	    fail("Expected IllegalArgumentException window_height < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.window(6, 3);
	    fail("Expected IllegalArgumentException window_width > picture width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.window(1, 6);
	    fail("Expected IllegalArgumentException window_height > picture height");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}
    }

    @Test
    public void testTileParameters() {
	Picture p = new PictureImpl(5, 5);

	try {
	    p.tile(-1, 3);
	    fail("Expected IllegalArgumentException tile_width < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.tile(1, -3);
	    fail("Expected IllegalArgumentException tile_height < 0");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.tile(6, 3);
	    fail("Expected IllegalArgumentException tile_width > picture width");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    p.tile(1, 6);
	    fail("Expected IllegalArgumentException tile_height > picture height");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}
    }

    @Test
    public void testSampleMethod() {
	Picture p = new PictureImpl(5, 5);
	Iterator<Pixel> iter = p.sample(0, 1, 2, 1);

	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		switch ((i + j) % 5) {
		case 0:
		    p.setPixel(i, j, RED);
		    break;
		case 1:
		    p.setPixel(i, j, GREEN);
		    break;
		case 2:
		    p.setPixel(i, j, BLUE);
		    break;
		case 3:
		    p.setPixel(i, j, WHITE);
		    break;
		case 4:
		    p.setPixel(i, j, BLACK);
		    break;
		}
	    }
	}

	assertEquals("Iterator hasNext broken", iter.hasNext(), true);
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(0, 1));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(2, 1));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(4, 1));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(0, 2));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(2, 2));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(4, 2));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(0, 3));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(2, 3));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(4, 3));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(0, 4));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(2, 4));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(4, 4));
	assertEquals("hasNext doesn't return false when it is done traversing", iter.hasNext(), false);
    }

    @Test
    public void testWindowMethod() {
	Picture p = new PictureImpl(5, 5);
	Iterator<SubPicture> iter = p.window(3, 2);

	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		switch ((i + j) % 5) {
		case 0:
		    p.setPixel(i, j, RED);
		    break;
		case 1:
		    p.setPixel(i, j, GREEN);
		    break;
		case 2:
		    p.setPixel(i, j, BLUE);
		    break;
		case 3:
		    p.setPixel(i, j, WHITE);
		    break;
		case 4:
		    p.setPixel(i, j, BLACK);
		    break;
		}
	    }
	}

	SubPicture s1 = p.extract(0, 0, 3, 2);
	SubPicture s2 = p.extract(1, 0, 3, 2);
	SubPicture s3 = p.extract(2, 0, 3, 2);
	SubPicture s4 = p.extract(0, 1, 3, 2);
	SubPicture s5 = p.extract(1, 1, 3, 2);
	SubPicture s6 = p.extract(2, 1, 3, 2);
	SubPicture s7 = p.extract(0, 2, 3, 2);
	SubPicture s8 = p.extract(1, 2, 3, 2);
	SubPicture s9 = p.extract(2, 2, 3, 2);
	SubPicture s10 = p.extract(0, 3, 3, 2);
	SubPicture s11 = p.extract(1, 3, 3, 2);
	SubPicture s12 = p.extract(2, 3, 3, 2);

	SubPicture[] subs = { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12 };

	assertEquals("Iterator hasNext broken", iter.hasNext(), true);

	SubPicture current;

	for (SubPicture s : subs) {
	    current = iter.next();
	    for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 2; j++)
		    assertEquals("Iterator returned wrong subPicture", current.getPixel(i, j),
			    p.extract(s.getXOffset(), s.getYOffset(), s.getWidth(), s.getHeight()).getPixel(i, j));
	    }
	}

	assertEquals("hasNext doesn't return false when it is done traversing", iter.hasNext(), false);
    }
}

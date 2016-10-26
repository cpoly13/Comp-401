package a5.lucia24;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;
import a6adept.ColorPixel;
import a6adept.Pixel;

public class A6AdeptTest {
    private static Pixel BLUE = new ColorPixel(0, 0, 1);
    private static Pixel RED = new ColorPixel(1, 0, 0);
    private static Pixel GREEN = new ColorPixel(0, 1, 0);

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "sampleTest";
	test_names[1] = "windowTest";
	test_names[2] = "tileTest";
	test_names[3] = "exceptionTest";

	return test_names;
    }

    @Test
    public void sampleTest() {
	Picture p = new PictureImpl(5, 5);
	for (int w = 0; w < 3; w++) {
	    for (int h = 0; h < 3; h++) {
		p.setPixel(w, h, BLUE);
	    }
	}
	p.setPixel(1, 1, RED);
	p.setPixel(3, 1, RED);
	p.setPixel(0, 3, RED);
	p.setPixel(2, 3, RED);
	p.setPixel(4, 3, RED);

	Iterator<Pixel> sample_iter = p.sample(1, 1, 2, 2);
	if (sample_iter.hasNext()) {
	    assertEquals("", sample_iter.next(), RED);
	}
    }

    @Test
    public void windowTest() {
	Picture p = new PictureImpl(5, 5);
	for (int w = 0; w < 3; w++) {
	    for (int h = 0; h < 3; h++) {
		p.setPixel(w, h, BLUE);
	    }
	}
	p.setPixel(1, 2, GREEN);
	p.setPixel(3, 1, GREEN);
	p.setPixel(1, 3, BLUE);

	Picture[] windowPics = new Picture[16];
	Iterator<SubPicture> window_iter = p.window(2, 2);

	for (int i = 0; i < 16; i++) {
	    if (window_iter.hasNext()) {
		windowPics[i] = window_iter.next();
	    }
	}
	assertEquals("", windowPics[6].getPixel(0, 0), windowPics[8].getPixel(0, 0));
	assertEquals("", windowPics[9].getPixel(1, 1), windowPics[13].getPixel(1, 0));

    }

    @Test
    public void tileTest() {
	Picture p = new PictureImpl(5, 5);
	for (int w = 0; w < 3; w++) {
	    for (int h = 0; h < 3; h++) {
		p.setPixel(w, h, BLUE);
	    }
	}
	for (int i = 0; i < 4; i++) {
	    p.setPixel(i, 4, RED);
	    p.setPixel(4, i, RED);
	}

	p.setPixel(1, 1, GREEN);
	p.setPixel(2, 1, GREEN);
	p.setPixel(1, 2, GREEN);
	p.setPixel(2, 2, GREEN);

	Picture[] tilePics = new Picture[4];
	Iterator<SubPicture> tile_iter = p.tile(2, 2);

	for (int i = 0; i < 4; i++) {
	    if (tile_iter.hasNext()) {
		tilePics[i] = tile_iter.next();
	    }
	}

	for (int n = 0; n < 4; n++) {
	    assertNotSame("", tilePics[n].getPixel(0, 0), RED);
	}

	assertEquals("", tilePics[0].getPixel(1, 1), tilePics[1].getPixel(0, 1));
	assertEquals("", tilePics[2].getPixel(1, 0), tilePics[3].getPixel(0, 0));

    }

    @Test
    public void exceptionTest() {
	Picture p = new PictureImpl(5, 5);

	try {
	    p.tile(10, 10);
	    fail("shouldnt have done that bro");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("nope");
	}

	try {
	    p.window(-1, -1);
	    fail("shouldnt have done that bro");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("nope");
	}

	try {
	    p.sample(1, 1, 0, 0);
	    fail("shouldnt have done that bro");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("nope");
	}
    }

}

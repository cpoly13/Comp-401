package a5.willcjj;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "exampleTest";
	test_names[1] = "sampleTest";
	test_names[2] = "windowTest";
	test_names[3] = "tileTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void sampleTest() {
	// create input and output for of the test (test case)
	Picture pic = new PictureImpl(7, 10);
	pic.setPixel(3, 4, new GrayPixel(1));
	pic.setPixel(6, 4, new GrayPixel(1));
	pic.setPixel(3, 8, new GrayPixel(1));
	pic.setPixel(6, 8, new GrayPixel(1));

	// test it
	Iterator<Pixel> sample_iter = pic.sample(3, 4, 3, 4);
	for (int i = 0; i < 4; i++) {
	    Pixel temp = sample_iter.next();
	    assertEquals("Error", temp.getIntensity(), 1, 0.0001);
	}

	assertEquals("Sample hasNext", sample_iter.hasNext(), false);

    }

    @Test
    public void windowTest() {
	Picture p = new PictureImpl(5, 5);
	int xOffset[] = { 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2 };
	int yOffset[] = { 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3 };

	Iterator<SubPicture> window_iter = p.window(3, 2);
	for (int i = 0; i < 12; i++) {
	    SubPicture sub = window_iter.next();
	    assertEquals("Error", sub.getXOffset(), xOffset[i]);
	    assertEquals("Error", sub.getYOffset(), yOffset[i]);
	    assertEquals("Error", sub.getWidth(), 3);
	    assertEquals("Error", sub.getHeight(), 2);
	}
	assertEquals("Window", window_iter.hasNext(), false);
    }

    @Test
    public void tileTest() {
	Picture p = new PictureImpl(5, 5);
	int xOffset[] = { 0, 2, 0, 2 };
	int yOffset[] = { 0, 0, 2, 2 };

	Iterator<SubPicture> tile_iter = p.tile(2, 2);
	for (int i = 0; i < 4; i++) {
	    SubPicture sub = tile_iter.next();
	    assertEquals("Error", sub.getXOffset(), xOffset[i]);
	    assertEquals("Error", sub.getYOffset(), yOffset[i]);
	    assertEquals("Error", sub.getWidth(), 2);
	    assertEquals("Error", sub.getHeight(), 2);
	}
	assertEquals("Tile", tile_iter.hasNext(), false);
    }
}

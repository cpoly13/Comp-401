package a5.meganjn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "sampleTest";
	test_names[1] = "windowTest";
	test_names[2] = "tileTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    // compares pixels in sample iterator to corresponding pixels in original
    @Test
    public void sampleTest() {
	Picture p = makePicture(5, 5);
	Iterator<Pixel> sampleIterator = p.sample(1, 1, 2, 3);
	assertEquals("sample is worng", sampleIterator.next(), p.getPixel(1, 1));
	assertEquals("sample is wrong", sampleIterator.next(), p.getPixel(3, 1));
	assertEquals("sample is wrong", sampleIterator.next(), p.getPixel(1, 4));
	assertEquals("sample is wrong", sampleIterator.next(), p.getPixel(3, 4));

    }

    // compares Pictures in window iterator to Picture extracted from original
    @Test
    public void windowTest() {
	Picture p = makePicture(4, 4);
	Iterator<SubPicture> windowIterator = p.window(3, 3);
	assertTrue("window not working", comparePictures(windowIterator.next(), p.extract(0, 0, 3, 3)));
	assertTrue("window not working", comparePictures(windowIterator.next(), p.extract(1, 0, 3, 3)));
	assertTrue("window not working", comparePictures(windowIterator.next(), p.extract(0, 1, 3, 3)));
	assertTrue("window not working", comparePictures(windowIterator.next(), p.extract(1, 1, 3, 3)));
    }

    // compares Pictures in tile iterator to extracted Pictures from original
    @Test
    public void tileTest() {
	Picture p = makePicture(4, 4);
	Iterator<SubPicture> tileIterator = p.tile(2, 2);
	assertTrue("tile not working", comparePictures(tileIterator.next(), p.extract(0, 0, 2, 2)));
	assertTrue("tile not working", comparePictures(tileIterator.next(), p.extract(2, 0, 2, 2)));
	assertTrue("tile not working", comparePictures(tileIterator.next(), p.extract(0, 2, 2, 2)));
	assertTrue("tile not working", comparePictures(tileIterator.next(), p.extract(2, 2, 2, 2)));

    }

    // static method that creates new Picture
    // input: width x and height y
    // returns Picture object filled with different Pixels
    private static Picture makePicture(int x, int y) {
	Picture p = new PictureImpl(x, y);
	for (int x2 = 0; x2 < x; x2++) {
	    for (int y2 = 0; y2 < y; y2++) {
		p.setPixel(x2, y2, new ColorPixel(0, 0, 0.01 * x2));
	    }
	}
	return p;
    }

    // compares two Pictures by comparing pixels in each
    // input: two Pictures
    // returns true or false
    private static boolean comparePictures(Picture a, Picture b) {
	boolean variable = false;
	if (a.getWidth() != b.getWidth() || a.getHeight() != b.getHeight()) {
	    throw new IllegalArgumentException("pictures are not the same size");
	}
	for (int x = 0; x < a.getWidth(); x++) {
	    for (int y = 0; y < a.getHeight(); y++) {
		if (a.getPixel(x, y) == b.getPixel(x, y)) {
		    variable = true;
		} else {
		    return false;
		}
	    }
	}
	return variable;
    }
}

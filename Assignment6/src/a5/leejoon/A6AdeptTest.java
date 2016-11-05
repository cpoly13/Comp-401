package a5.leejoon;

import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[6];

	test_names[0] = "sampleTestValid";
	test_names[1] = "sampleTest";
	test_names[2] = "windowTestValid";
	test_names[3] = "windowTest";
	test_names[4] = "tileTestValid";
	test_names[5] = "tileTest";
	return test_names;
    }

    // Test sampleTest parameters
    @Test
    public void sampleTestValid() {
	Picture p = new PictureImpl(15, 10);
	try {
	    p.sample(16, 10, 3, 3);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.sample(-3, 10, 3, 3);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.sample(13, -2, 3, 3);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.sample(13, 12, 3, 3);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.sample(10, 10, -3, 3);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.sample(10, 10, 3, -3);
	} catch (IllegalArgumentException e) {
	}

    }

    // Test sampleTest method
    @Test
    public void sampleTest() {
	Picture p = new PictureImpl(15, 10);
	Coordinate c1 = new Coordinate(2, 3);
	Coordinate c2 = new Coordinate(5, 3);
	Coordinate c3 = new Coordinate(8, 3);
	Pixel p1 = new ColorPixel(0.4, 0.3, 0.6);
	Pixel p2 = new GrayPixel(0.7);
	p.setPixel(c1, p1);
	p.setPixel(c2, p2);
	Iterator<Pixel> sample_iter1 = p.sample(2, 3, 3, 4);
	Iterator<Pixel> sample_iter2 = p.sample(0, 0, 1, 1);
	Iterator<Pixel> novice_iter = p.iterator();

	Pixel testing = null;
	if (sample_iter1.hasNext()) {
	    testing = sample_iter1.next();
	}
	assertEquals(testing, p.getPixel(c1));

	if (sample_iter1.hasNext()) {
	    testing = sample_iter1.next();
	}
	assertEquals(testing, p.getPixel(c2));

	if (sample_iter1.hasNext()) {
	    testing = sample_iter1.next();
	}
	assertEquals(testing, p.getPixel(c3));

	while (sample_iter2.hasNext() && novice_iter.hasNext()) {
	    assertEquals(sample_iter2.next(), novice_iter.next());
	}

    }

    // Test windowTest parameters
    @Test
    public void windowTestValid() {
	Picture p = new PictureImpl(15, 10);
	try {
	    p.window(-3, 5);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.window(3, -5);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.window(16, 5);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.window(3, 11);
	} catch (IllegalArgumentException e) {
	}
    }

    // Test windowTest method
    @Test
    public void windowTest() {
	Picture p = new PictureImpl(15, 10);
	Iterator<SubPicture> window_iter = p.window(3, 2);
	SubPicture subp = null;
	for (int j = 0; j <= 8; j++) {
	    for (int i = 0; i <= 12; i++) {
		subp = p.extract(i, j, 3, 2);
		if (window_iter.hasNext()) {
		    assertTrue(compareSubPictures(window_iter.next(), subp));
		}
	    }
	}
    }

    // Test tileTest parameters
    @Test
    public void tileTestValid() {
	Picture p = new PictureImpl(15, 10);
	try {
	    p.tile(-3, 5);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.tile(3, -5);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.tile(19, 5);
	} catch (IllegalArgumentException e) {
	}
	try {
	    p.tile(3, 14);
	} catch (IllegalArgumentException e) {
	}
    }

    // Test tileTest method
    @Test
    public void tileTest() {
	Picture p = new PictureImpl(5, 5);
	Iterator<SubPicture> tile_iter = p.tile(2, 2);
	if (tile_iter.hasNext()) {
	    assertTrue(compareSubPictures(tile_iter.next(), p.extract(0, 0, 2, 2)));
	}
	if (tile_iter.hasNext()) {
	    assertTrue(compareSubPictures(tile_iter.next(), p.extract(2, 0, 2, 2)));
	}
	if (tile_iter.hasNext()) {
	    assertTrue(compareSubPictures(tile_iter.next(), p.extract(0, 2, 2, 2)));
	}
	if (tile_iter.hasNext()) {
	    assertTrue(compareSubPictures(tile_iter.next(), p.extract(2, 2, 2, 2)));
	}
    }

    // Helper method to compare to Subpictures for the window/tile Test
    private static boolean compareSubPictures(SubPicture s1, SubPicture window) {
	boolean compared = true;
	if (s1.getSource() != window.getSource()) {
	    compared = false;
	}
	if (s1.getXOffset() != window.getXOffset()) {
	    compared = false;
	}
	if (s1.getYOffset() != window.getYOffset()) {
	    compared = false;
	}
	if (s1.getWidth() != window.getWidth()) {
	    compared = false;
	}
	if (s1.getHeight() != window.getHeight()) {
	    compared = false;
	}
	return compared;
    }
}

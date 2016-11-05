package a5.davidbc;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "sampleTest";

	return test_names;
    }

    @Test
    public void sampleTest() {
	// Fairly straightforward setup, I just initiated a picture with certain
	// pixels having certain values and then used the sample method to pull
	// out said pixels and compare them to what I had set them to.
	Picture testPict = new PictureImpl(4, 4);
	Pixel testPixel = new GrayPixel(0.1);
	for (int i = 0; i < 4; i += 2) {
	    if (i == 0) {
		testPict.setPixel(0, 0, testPixel);
	    } else {
		testPict.setPixel(i, i, testPixel);
		testPict.setPixel(0, i, testPixel);
		testPict.setPixel(i, 0, testPixel);
	    }
	}
	Iterator<Pixel> testIter = testPict.sample(0, 0, 2, 2);
	for (int j = 0; j < 4; j++) {
	    assertEquals(testIter.next(), testPixel);
	}
    }
}

/*
 * @Test public void windowTest(){ Picture testPict = new PictureImpl(5,5);
 * //Pixel testPixel = new GrayPixel(0.2); //testPict.setPixel(1, 1,testPixel);
 * //testPict.setPixel(2, 3,testPixel); //testPict.setPixel(3, 1,testPixel);
 * //testPict.setPixel(0,3,testPixel); Iterator<SubPicture> testWindow =
 * testPict.window(3, 2); assertEquals(testWindow.next(),
 * testPict.extract(0,0,3,2));
 * 
 * }
 * 
 * @Test public void tileTest(){ Picture testPict = new PictureImpl(4,4);
 * Iterator<SubPicture> testTile = testPict.tile(2, 2);
 * assertEquals(testTile.next(), testPict.extract(0, 0,2,2)); }
 * 
 */

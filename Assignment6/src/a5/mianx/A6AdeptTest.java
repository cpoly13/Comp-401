package a5.mianx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "sampleTest";
	test_names[1] = "windowTest";
	test_names[2] = "tileTest";

	return test_names;
    }

    @Test
    // test the sample method from a6adept
    public void sampleTest() {
	Picture p1 = new PictureImpl(5, 5);
	for (int x = 0; x < p1.getWidth(); x += 2) {
	    for (int y = 0; y < p1.getHeight(); y += 3) {
		p1.setPixel(x, y, RED);
	    }
	}

	Iterator<Pixel> sampleIter = p1.sample(0, 0, 2, 3);
	while (sampleIter.hasNext()) {
	    assertEquals("the sample method is not correct", sampleIter.next(), RED);
	}
    }

    @Test
    // test the window method from a6adept
    public void windowTest() {
	Picture testPic = new PictureImpl(4, 4);

	Iterator<SubPicture> windowIter = testPic.window(2, 2);

	int xOffsetNum = testPic.getWidth() - 2;
	int yOffsetNum = testPic.getHeight() - 2;

	ArrayList<SubPicture> subList = new ArrayList<SubPicture>();
	for (int y = 0; y <= yOffsetNum; y++) {
	    for (int x = 0; x <= xOffsetNum; x++) {
		subList.add(testPic.extract(x, y, 2, 2));
	    }
	}
	for (int i = 0; i < subList.size(); i++) {
	    SubPicture aPic = windowIter.next();
	    SubPicture bPic = subList.get(i);
	    assertEquals("", aPic.getHeight(), bPic.getHeight());
	    assertEquals("", aPic.getWidth(), bPic.getWidth());
	    assertEquals("", aPic.getXOffset(), bPic.getXOffset());
	    assertEquals("", aPic.getYOffset(), bPic.getYOffset());
	}
    }

    @Test
    // test the tile method from a6adept
    public void tileTest() {
	Picture testPic = new PictureImpl(5, 5);
	Iterator<SubPicture> tileIter = testPic.tile(2, 2);

	ArrayList<SubPicture> subList = new ArrayList<SubPicture>();
	for (int y = 0; y + 2 < testPic.getHeight(); y += 2) {
	    for (int x = 0; x + 2 < testPic.getWidth(); x += 2) {
		subList.add(testPic.extract(x, y, 2, 2));
	    }
	}

	for (int i = 0; i < subList.size(); i++) {
	    assertTrue("", comparePic(subList.get(i), tileIter.next()));
	}
    }

    private boolean comparePic(Picture p1, Picture p2) {
	boolean result = true;
	if (p1.getHeight() != p2.getHeight() || p1.getWidth() != p2.getWidth()) {
	    result = false;
	}
	for (int x = 0; x < p1.getWidth(); x++) {
	    for (int y = 0; y < p1.getHeight(); y++) {
		Pixel pixel1 = p1.getPixel(x, y);
		Pixel pixel2 = p2.getPixel(x, y);
		if (pixel1.getRed() != pixel2.getRed() || pixel1.getGreen() != pixel2.getGreen()
			|| pixel1.getBlue() != pixel2.getBlue() || pixel1.getIntensity() != pixel2.getIntensity()) {
		    result = false;
		}
	    }
	}
	return result;
    }

}

package a5.vinli;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	return new String[] { "zigzagTest" };
    }

    Picture aPicture = new PictureImpl(20, 20);

    @Test
    public void zigzagTest() {
	// This method tests the zigzag method by creating a picture with pixels
	// that have the same intensity along the diagonals of the picture.

	ColorPixel[] colorPixels = new ColorPixel[aPicture.getWidth()];
	for (int i = 0; i < aPicture.getWidth(); i++) {
	    colorPixels[i] = new ColorPixel(Math.random(), Math.random(), Math.random());
	}

	for (int i = 0; i < aPicture.getHeight(); i++) {
	    for (int j = 0; j < aPicture.getWidth(); j++) {
		aPicture.setPixel(j, i, colorPixels[(j + i) % aPicture.getHeight()]);
	    }
	}

	Iterator<Pixel> iterator = aPicture.zigzag();
	for (int i = 0; i < aPicture.getWidth(); i++) {
	    for (int j = 0; j <= i; j++) {
		assertTrue(comparePixel(iterator.next(), colorPixels[i]));
	    }
	}

	for (int i = 20; i > 0; i--) {
	    for (int j = 1; j < i; j++) {
		assertTrue(comparePixel(iterator.next(), colorPixels[aPicture.getWidth() - i]));
	    }
	}

    }

    private static boolean comparePixel(Pixel p, Pixel c) {
	double ptotal = p.getBlue() + p.getRed() + p.getGreen() + p.getIntensity();
	double ctotal = c.getBlue() + c.getRed() + c.getGreen() + c.getIntensity();
	if (ctotal == ptotal) {
	    return true;
	}
	return false;
    }
}

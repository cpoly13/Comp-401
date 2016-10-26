package a5.hayt10;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "sampleTest";
	test_names[1] = "windowTest";
	test_names[2] = "tileTest";

	return test_names;
    }

    @Test
    /**
     * Ensures the sample method chooses the correct coordinates and retrieves
     * the corresponding pixels
     */
    public void sampleTest() {
	// Sets up an example to test
	Picture pic = new PictureImpl(15, 15);
	Coordinate initial = new Coordinate(4, 8);
	Pixel white = new GrayPixel(1);
	int dx = 4;
	int dy = 3;

	// Sets the pixels to be in the test sample to be white
	for (int i = initial.getY(); i <= pic.getHeight(); i += dy) {
	    for (int j = initial.getX(); j <= pic.getWidth(); j += dx) {
		pic.setPixel(new Coordinate(j, i), white);
	    }
	}

	// Test sample composed of all white pixels
	Iterator<Pixel> sampleIter = pic.sample(initial.getX(), initial.getY(), dx, dy);

	// Checks to see if correct pixels were chosen
	while (sampleIter.hasNext()) {
	    Pixel nextSampleCoord = sampleIter.next();
	    assertEquals("Sample iterator doesn't have the correct coordinates,", nextSampleCoord.equals(white), true);
	}
    }

    @Test
    /**
     * Checks the functionality of the window operation, which makes as many
     * SubPictures of a given size as possible within a Picture
     */
    public void windowTest() {
	// Sets up example picture and the window dimensions
	Picture pic = new PictureImpl(10, 12);
	int windowWidth = 4;
	int windowHeight = 5;
	Iterator<SubPicture> windowIter = pic.window(windowWidth, windowHeight);

	// Two loops generate all coordinates for the offsets of the windows
	for (int i = 0; i + windowHeight <= pic.getHeight(); i++) {
	    for (int j = 0; j + windowWidth <= pic.getWidth(); j++) {
		try {
		    SubPicture nextWindow = windowIter.next();
		    Coordinate origin = new Coordinate(nextWindow.getXOffset(), nextWindow.getYOffset());
		    assertEquals("X coordinate of the window's origin is wrong,", origin.getX(), j);
		    assertEquals("Y coordinate of the window's origin is wrong,", origin.getY(), i);
		    assertEquals("Window width is incorrect,", nextWindow.getWidth(), windowWidth);
		    assertEquals("Window height is incorrect,", nextWindow.getHeight(), windowHeight);
		}
		/*
		 * If "next" failed to find another window, there are fewer
		 * pictures than there are supposed to be
		 */
		catch (RuntimeException e) {
		    fail("Missing SubPictures in the window iterator");
		}
	    }
	}
    }

    @Test
    /**
     * Ensures the tile function properly cuts the picture into smaller "tiles"
     * of equal size
     */
    public void tileTest() {
	// Setup example picture and dimensions
	Picture pic = new PictureImpl(9, 7);
	int tileWidth = 3;
	int tileHeight = 2;
	Iterator<SubPicture> tileIter = pic.tile(tileWidth, tileHeight);

	// Two loops generate all coordinates for the offsets of the tiles
	for (int i = 0; i <= pic.getHeight() - tileHeight; i += tileHeight) {
	    for (int j = 0; j <= pic.getWidth() - tileWidth; j += tileWidth) {
		try {
		    SubPicture nextTile = tileIter.next();
		    Coordinate origin = new Coordinate(nextTile.getXOffset(), nextTile.getYOffset());
		    assertEquals("X coordinate of the window's origin is wrong,", origin.getX(), j);
		    assertEquals("Y coordinate of the window's origin is wrong,", origin.getY(), i);
		    assertEquals("Window width is incorrect,", nextTile.getWidth(), tileWidth);
		    assertEquals("Window height is incorrect,", nextTile.getHeight(), tileHeight);

		}
		/*
		 * If "next" failed to find another tile, there are fewer
		 * pictures than there are supposed to be
		 */
		catch (RuntimeException e) {
		    fail("Missing SubPictures in the tile iterator");
		}
	    }
	}
    }

}

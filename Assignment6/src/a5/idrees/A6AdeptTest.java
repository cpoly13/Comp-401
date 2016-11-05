package a5.idrees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Coordinate;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.SubPicture;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "exampleTest";
	test_names[1] = "tileTest";
	test_names[2] = "windowConstructorTest";

	return test_names;
    }

    @Test
    public void windowConstructorTest() {
	Picture pic = new PictureImpl(100, 100);
	try {
	    pic.window(-1, -1);
	    fail("Expected IllegalArgumentException for negative dimensions");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    pic.window(101, 101);
	    fail("Expected IllegalArgumentException for out of bounds dimensions");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	pic.window(100, 100);
    }

    @Test
    public void tileTest() {
	Picture picture = new PictureImpl(5, 5);
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		picture.setPixel(new Coordinate(i, j), new GrayPixel(1));
	    }
	}
	Iterator<SubPicture> tile_iter = picture.tile(2, 2);
	int[][] extract = { { 0, 0, 2, 2 }, { 2, 0, 2, 2 }, { 0, 2, 2, 2 }, { 2, 2, 2, 2 } };
	for (int i = 0; i < 4; i++) {
	    SubPicture tileSub = tile_iter.next();
	    SubPicture picSub = picture.extract(extract[i][0], extract[i][1], extract[i][2], extract[i][3]);
	    assertEquals("Tile does not match extracted subpicture", picSub.getPixel(0, 0), tileSub.getPixel(0, 0));
	    assertEquals("Tile does not match extracted subpicture", picSub.getPixel(0, 1), tileSub.getPixel(0, 1));
	    assertEquals("Tile does not match extracted subpicture", picSub.getPixel(1, 0), tileSub.getPixel(1, 0));
	    assertEquals("Tile does not match extracted subpicture", picSub.getPixel(1, 1), tileSub.getPixel(1, 1));
	}
    }

    @Test
    public void exampleTest() {
    }
}

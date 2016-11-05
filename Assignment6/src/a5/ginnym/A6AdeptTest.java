package a5.ginnym;

import static org.junit.Assert.fail;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "exampleTest";
	test_names[1] = "SampleExceptionTests";
	test_names[2] = "WindowExceptionsTests";
	test_names[3] = "TileExceptionsTests";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void SampleExceptionTests() {
	Picture pic = new PictureImpl(2, 2);
	try {
	    pic.sample(3, 2, 1, 1);
	    fail("Expected IllegalArgumentException. Given X not within picture.");
	} catch (IllegalArgumentException e) {
	}
	try {
	    pic.sample(2, 3, 1, 1);
	    fail("Expected IllegalArgumentException. Given Y not within picture.");
	} catch (IllegalArgumentException e) {
	}
	try {
	    pic.sample(2, 2, -1, 1);
	    fail("Expected IllegalArgumentException. dx cannot be negative.");
	} catch (IllegalArgumentException e) {
	}
	try {
	    pic.sample(2, 2, 1, -1);
	    fail("Expected IllegalArgumentException. dy cannot be negative.");
	} catch (IllegalArgumentException e) {
	}
    }

    @Test
    public void WindowExceptionsTests() {
	Picture pic = new PictureImpl(2, 2);
	try {
	    pic.window(-3, 2);
	    fail("Expected IllegalArgumentException. Window_width cannot be negative");
	} catch (IllegalArgumentException e) {
	}
	try {
	    pic.window(2, -2);
	    fail("Expected IllegalArgumentException. Window_height cannot be negative");
	} catch (IllegalArgumentException e) {
	}
	try {
	    pic.window(3, 2);
	    fail("Expected IllegalArgumentException. Window_width cannot be > source width.");
	} catch (IllegalArgumentException e) {
	}
	try {
	    pic.window(2, 3);
	    fail("Expected IllegalArgumentException. Window_height cannot be > source height.");
	} catch (IllegalArgumentException e) {
	}
    }

    @Test
    public void TileExceptionsTests() {
	Picture pic = new PictureImpl(2, 2);
	try {
	    pic.tile(-2, 2);
	    fail("Expected IllegalArgumentException. Tile_Width cannot be negative.");
	} catch (IllegalArgumentException e) {
	}
	try {
	    pic.tile(2, -2);
	    fail("Expected IllegalArgumentException. Tile_Height cannot be negative.");
	} catch (IllegalArgumentException e) {
	}
	try {
	    pic.tile(3, 2);
	    fail("Expected IllegalArgumentException. Tile_Width cannot be > source width.");
	} catch (IllegalArgumentException e) {
	}
	try {
	    pic.tile(2, 3);
	    fail("Expected IllegalArgumentException. Tile_Height cannot be > source height.");
	} catch (IllegalArgumentException e) {
	}
    }
}

// public Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy);
// @Test
// public void Sample(){
// Picture pic = new PictureImpl(15,10);
// Iterator<Pixel> sample_iter = pic.sample(2, 3, 3, 4);
// assertEquals("The sample iterator appears faulty", pic.sample(2,2,3,4),
// sample_iter);
//
// (pic.getPixel(2,3)),
// pic.getPixel(5,3), pic.getPixel(8,3), pic.getPixel(11,3), pic.getPixel(14,3),
// pic.getPixel(2,7), pic.getPixel(5,7), pic.getPixel(8,7), pic.getPixel(11,7),
// pic.getPixel(14,7));
// }

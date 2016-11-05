package a5.micahand;

import static org.junit.Assert.fail;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPictureImpl;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "testWindow";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void testWindow() {
	// tests window values
	Picture pic = new PictureImpl(4, 4);
	Pixel red = new ColorPixel(1, 0, 0);
	Pixel green = new ColorPixel(0, 1, 0);
	Pixel blue = new ColorPixel(0, 0, 1);
	Pixel white = new ColorPixel(1, 1, 1);

	pic.setPixel(0, 0, blue);
	pic.setPixel(1, 0, green);
	pic.setPixel(2, 0, red);
	pic.setPixel(3, 0, white);
	pic.setPixel(0, 1, blue);
	pic.setPixel(1, 1, green);
	pic.setPixel(2, 1, red);
	pic.setPixel(3, 1, white);
	pic.setPixel(0, 2, blue);
	pic.setPixel(1, 2, green);
	pic.setPixel(2, 2, red);
	pic.setPixel(3, 2, white);

	SubPictureImpl subpicture = new SubPictureImpl(pic, 1, 1, 2, 2);

	try {
	    subpicture.window(-1, 2);
	    fail("Expected IllegalArgumentException for negative arguments");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException for negative arguments");
	}
    }
}

package a5.conradc;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagTest";

	return test_names;
    }

    /**
     * JUnit test for zigzag iterator of PictureImpl Input: None Output: Asserts
     * whether zigzag iterator was properly implemented
     */

    @Test
    public void zigzagTest() {

	PictureImpl _picture = testPicture();
	Iterator<Pixel> _zigzag = _picture.zigzag();

	int num_diagnonals = Math.max(_picture.getHeight(), _picture.getWidth());

	boolean is_even = false;

	// Iterate through each diagonal in the Picture, switching between odd
	// and even diagonals.
	for (int i = 0; i < num_diagnonals; i++) {

	    if (is_even) {

		// Iterates down and to the left through array if on an even
		// diagonal.
		for (int m = 0; m < _picture.getHeight(); m++) {
		    for (int n = 0; n < _picture.getWidth(); n++) {

			if (i == n + m) {

			    /**
			     * Using the fact that pixel coordinates (x,y) of
			     * each pixel in each unique diagonal sum up to the
			     * same number.
			     **/

			    assertEquals(_zigzag.next(), _picture.getPixel(new Coordinate(n, m)));
			}

		    }
		}

		is_even = false;

	    } else {

		// Iterates up and to the right through array if on an odd
		// diagonal.
		for (int m = _picture.getHeight(); m >= 0; m--) {
		    for (int n = 0; n < _picture.getWidth(); n++) {

			if (i == n + m) {
			    assertEquals(_zigzag.next(), _picture.getPixel(new Coordinate(n, m)));
			}

		    }
		}

		is_even = true;
	    }

	}

    }

    /**
     * Helper method for constructing a Picture and filling it with pixels to
     * test Input: None Output: PictureImpl object filled with unique Pixels
     */

    private static PictureImpl testPicture() {

	PictureImpl pic_test = new PictureImpl(5, 5);

	for (int i = 0; i < pic_test.getHeight(); i++) {
	    for (int j = 0; j < pic_test.getWidth(); j++) {
		pic_test.setPixel(new Coordinate(j, i),
			new ColorPixel(j / pic_test.getWidth(), i / pic_test.getHeight(), 0));
	    }
	}

	return pic_test;
    }
}

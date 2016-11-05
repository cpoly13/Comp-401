package a5.tarek;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testSample";
	test_names[1] = "testWindow";
	test_names[2] = "testTile";

	return test_names;
    }

    /*
     * Test of the sample method in adept, by getting the pixels manually from
     * coordinates and comparing them to the iterator
     */
    @Test
    public void testSample() {
	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
	Coordinate c1 = new Coordinate(2, 3);
	Pixel test1 = p.getPixel(c1);

	Coordinate c2 = new Coordinate(5, 3);
	Pixel test2 = p.getPixel(c2);

	Coordinate c3 = new Coordinate(8, 3);
	Pixel test3 = p.getPixel(c3);

	Coordinate c4 = new Coordinate(11, 3);
	Pixel test4 = p.getPixel(c4);

	Coordinate c5 = new Coordinate(14, 3);
	Pixel test5 = p.getPixel(c5);

	Coordinate c6 = new Coordinate(2, 7);
	Pixel test6 = p.getPixel(c6);

	Coordinate c7 = new Coordinate(5, 7);
	Pixel test7 = p.getPixel(c7);

	Coordinate c8 = new Coordinate(8, 7);
	Pixel test8 = p.getPixel(c8);

	Coordinate c9 = new Coordinate(11, 7);
	Pixel test9 = p.getPixel(c9);

	Coordinate c10 = new Coordinate(14, 7);
	Pixel test10 = p.getPixel(c10);

	Pixel testing1 = sample_iter.next();
	Pixel testing2 = sample_iter.next();
	Pixel testing3 = sample_iter.next();
	Pixel testing4 = sample_iter.next();
	Pixel testing5 = sample_iter.next();
	Pixel testing6 = sample_iter.next();
	Pixel testing7 = sample_iter.next();
	Pixel testing8 = sample_iter.next();
	Pixel testing9 = sample_iter.next();
	Pixel testing10 = sample_iter.next();

	assertEquals("Sample iterator does not match expected value", testing1, test1);
	assertEquals("Sample iterator does not match expected value", testing2, test2);
	assertEquals("Sample iterator does not match expected value", testing3, test3);
	assertEquals("Sample iterator does not match expected value", testing4, test4);
	assertEquals("Sample iterator does not match expected value", testing5, test5);
	assertEquals("Sample iterator does not match expected value", testing6, test6);
	assertEquals("Sample iterator does not match expected value", testing7, test7);
	assertEquals("Sample iterator does not match expected value", testing8, test8);
	assertEquals("Sample iterator does not match expected value", testing9, test9);
	assertEquals("Sample iterator does not match expected value", testing10, test10);

	Iterator<Pixel> samplenov_iter = p.sample(0, 0, 1, 1);
	Pixel testing2nd1 = samplenov_iter.next();
	Pixel testing2nd2 = samplenov_iter.next();
	Pixel testing2nd3 = samplenov_iter.next();
	Pixel testing2nd4 = samplenov_iter.next();
	Pixel testing3rd1 = p.iterator().next();
	Pixel testing3rd2 = p.iterator().next();
	Pixel testing3rd3 = p.iterator().next();
	Pixel testing3rd4 = p.iterator().next();

	assertTrue("Sample iterator does not match source picture", testing2nd1.getIntensity() == testing3rd1.getIntensity());
	assertTrue("Sample iterator does not match source picture", testing2nd2.getIntensity() == testing3rd2.getIntensity());
	assertTrue("Sample iterator does not match source picture", testing2nd3.getIntensity() == testing3rd3.getIntensity());
	assertTrue("Sample iterator does not match source picture", testing2nd4.getIntensity() == testing3rd4.getIntensity());
	try {
	    Picture ptest = new PictureImpl(21, 19);
	    ptest.sample(2, 7, 2, 9);
	    sample_iter.remove();
	    fail("Expected UnsupportedOperationException for remove()");
	} catch (UnsupportedOperationException e) {
	}

	try {
	    Picture ptest2 = new PictureImpl(6, 4);
	    ptest2.sample(-6, -8, -2, -7);
	    fail("Illegal argument exception expected for sample parameters being negative or not fitting within picture");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

	try {
	    Picture ptest2 = new PictureImpl(6, 4);
	    ptest2.sample(8, 8, 1, 2);
	    fail("Illegal argument exception expected for sample parameters being negative or not fitting within picture");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

    }

    /*
     * Test of window method, creating new pictures from manually extracting
     * from a picture and them comparing them to the window iterator which
     * slides a window by the given dimensions across a parent picture. They're
     * compared by looping through each window and it's corresponding solution
     * and ensuring that they have identical pixels and dimensions.
     */
    @Test
    public void testWindow() {
	Pixel colorpix1 = new ColorPixel(0.2, 0.4, 1.0);
	Pixel colorpix2 = new ColorPixel(0.0, 0.9, 0.3);
	Picture p = new PictureImpl(5, 5);
	p.setPixel(1, 3, colorpix1);
	p.setPixel(4, 2, colorpix2);
	Iterator<SubPicture> window_iter = p.window(3, 2);

	Picture t1 = window_iter.next();
	Picture t2 = window_iter.next();
	Picture t3 = window_iter.next();
	Picture t4 = window_iter.next();
	Picture t5 = window_iter.next();
	Picture t6 = window_iter.next();
	Picture t7 = window_iter.next();
	Picture t8 = window_iter.next();
	Picture t9 = window_iter.next();
	Picture t10 = window_iter.next();
	Picture t11 = window_iter.next();
	Picture t12 = window_iter.next();

	boolean b = true;
	boolean b1 = true;

	SubPicture p1 = p.extract(0, 0, 3, 2);
	SubPicture p2 = p.extract(1, 0, 3, 2);
	SubPicture p3 = p.extract(2, 0, 3, 2);
	SubPicture p4 = p.extract(0, 1, 3, 2);
	SubPicture p5 = p.extract(1, 1, 3, 2);
	SubPicture p6 = p.extract(2, 1, 3, 2);
	SubPicture p7 = p.extract(0, 2, 3, 2);
	SubPicture p8 = p.extract(1, 2, 3, 2);
	SubPicture p9 = p.extract(2, 2, 3, 2);
	SubPicture p10 = p.extract(0, 3, 3, 2);
	SubPicture p11 = p.extract(1, 3, 3, 2);
	SubPicture p12 = p.extract(2, 3, 3, 2);

	for (int i = 0; i < p1.getHeight(); ++i) {
	    for (int j = 0; j < p1.getWidth(); ++j) {
		if ((p1.getPixel(j, i)) == (t1.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p2.getHeight(); ++i) {
	    for (int j = 0; j < p2.getWidth(); ++j) {
		if ((p2.getPixel(j, i)) == (t2.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p3.getHeight(); ++i) {
	    for (int j = 0; j < p3.getWidth(); ++j) {
		if ((p3.getPixel(j, i)) == (t3.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p4.getHeight(); ++i) {
	    for (int j = 0; j < p4.getWidth(); ++j) {
		if ((p4.getPixel(j, i)) == (t4.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p5.getHeight(); ++i) {
	    for (int j = 0; j < p5.getWidth(); ++j) {
		if ((p5.getPixel(j, i)) == (t5.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p6.getHeight(); ++i) {
	    for (int j = 0; j < p6.getWidth(); ++j) {
		if ((p6.getPixel(j, i)) == (t6.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p7.getHeight(); ++i) {
	    for (int j = 0; j < p7.getWidth(); ++j) {
		if ((p7.getPixel(j, i)) == (t7.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p8.getHeight(); ++i) {
	    for (int j = 0; j < p8.getWidth(); ++j) {
		if ((p8.getPixel(j, i)) == (t8.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p9.getHeight(); ++i) {
	    for (int j = 0; j < p9.getWidth(); ++j) {
		if ((p9.getPixel(j, i)) == (t9.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p10.getHeight(); ++i) {
	    for (int j = 0; j < p10.getWidth(); ++j) {
		if ((p10.getPixel(j, i)) == (t10.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p11.getHeight(); ++i) {
	    for (int j = 0; j < p11.getWidth(); ++j) {
		if ((p11.getPixel(j, i)) == (t11.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p12.getHeight(); ++i) {
	    for (int j = 0; j < p12.getWidth(); ++j) {
		if ((p12.getPixel(j, i)) == (t12.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}

	if ((p1.getWidth() != t1.getWidth()) || (p1.getHeight() != t1.getHeight()) || (p2.getWidth() != t2.getWidth())
		|| ((p2.getHeight() != t2.getHeight()) || (p3.getWidth() != t3.getWidth())
			|| (p3.getHeight() != t3.getHeight()) || (p4.getWidth() != t4.getWidth())
			|| (p4.getHeight() != t4.getHeight()))
		|| (p5.getWidth() != t5.getWidth()) || (p5.getHeight() != t5.getHeight())
		|| (p6.getWidth() != t6.getWidth()) || (p6.getHeight() != t6.getHeight())
		|| (p7.getWidth() != t7.getWidth()) || (p7.getHeight() != t7.getHeight())
		|| (p8.getWidth() != t8.getWidth()) || (p8.getHeight() != t8.getHeight())
		|| (p9.getWidth() != t9.getWidth()) || (p9.getHeight() != t9.getHeight())
		|| (p10.getWidth() != t10.getWidth())
		|| ((p10.getHeight() != t10.getHeight()) || (p11.getWidth() != t11.getWidth())
			|| (p11.getHeight() != t11.getHeight()) || (p12.getWidth() != t12.getWidth())
			|| (p12.getHeight() != t12.getHeight()))) {
	    b = false;
	}
	assertEquals("window() does not return the expected subpicture", b, b1);

	try {
	    Picture ex = new PictureImpl(6, 4);
	    ex.window(7, 3);
	    fail("Illegal argument exception expected for window height/width being negative or greater than"
		    + "picture dimensions");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

    }

    /*
     * Test of the tile method, which breaks a parent picture into tiles by
     * given dimensions. I find those tiles manually and then compare them to
     * the iterator. They're compared by taking each tile and it's corresponding
     * solution and ensuring that they have the same pixels and dimensions.
     */
    @Test
    public void testTile() {
	Pixel colorpix1 = new ColorPixel(0.2, 0.4, 1.0);
	Pixel colorpix2 = new ColorPixel(0.0, 0.9, 0.3);
	Picture p = new PictureImpl(5, 5);
	p.setPixel(1, 3, colorpix1);
	p.setPixel(4, 2, colorpix2);
	Iterator<SubPicture> tile_iter = p.tile(2, 2);

	Picture t1 = tile_iter.next();
	Picture t2 = tile_iter.next();
	Picture t3 = tile_iter.next();
	Picture t4 = tile_iter.next();

	boolean b = true;
	boolean b1 = true;

	Picture p1 = p.extract(0, 0, 2, 2);
	Picture p2 = p.extract(2, 0, 2, 2);
	Picture p3 = p.extract(0, 2, 2, 2);
	Picture p4 = p.extract(2, 2, 2, 2);

	for (int i = 0; i < p1.getHeight(); ++i) {
	    for (int j = 0; j < p1.getWidth(); ++j) {
		if ((p1.getPixel(j, i)) == (t2.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p2.getHeight(); ++i) {
	    for (int j = 0; j < p2.getWidth(); ++j) {
		if ((p2.getPixel(j, i)) == (t2.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p3.getHeight(); ++i) {
	    for (int j = 0; j < p3.getWidth(); ++j) {
		if ((p3.getPixel(j, i)) == (t3.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	for (int i = 0; i < p4.getHeight(); ++i) {
	    for (int j = 0; j < p4.getWidth(); ++j) {
		if ((p4.getPixel(j, i)) == (t4.getPixel(j, i))) {
		    b = true;
		} else {
		    b = false;
		}
	    }
	}
	if ((p1.getWidth() != t1.getWidth()) || (p1.getHeight() != t1.getHeight()) || (p2.getWidth() != t2.getWidth())
		|| ((p2.getHeight() != t2.getHeight()) || (p3.getWidth() != t3.getWidth())
			|| (p3.getHeight() != t3.getHeight()) || (p4.getWidth() != t4.getWidth())
			|| (p4.getHeight() != t4.getHeight()))) {
	    b = false;
	}
	assertEquals("tile() does not return the expected subpicture", b, b1);

	// testing for the correct exceptions
	try {
	    Picture ex = new PictureImpl(6, 4);
	    ex.tile(7, 3);
	    fail("Illegal argument exception expected for tile height/width being negative or greater than"
		    + "picture dimensions");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

    }
}

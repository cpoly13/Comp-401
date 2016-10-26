package a5.mcanders;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	// test_names[0] = "windowTest";
	// test_names[1] = "extractTest";

	return test_names;
    }

    static Pixel pOne = new ColorPixel(.333, .333, .333);
    static Pixel pTwo = new GrayPixel(.5);
    static Pixel pThree = new ColorPixel(.567, .125, .321);
    static Pixel pFour = new GrayPixel(0.0);

    static Picture p = new PictureImpl(2, 2);
    static Picture c = new PictureImpl(2, 2);
    static Picture t = new PictureImpl(10, 10);

    static Coordinate c1 = new Coordinate(0, 0);
    static Coordinate c2 = new Coordinate(0, 1);
    static Coordinate c3 = new Coordinate(1, 0);
    static Coordinate c4 = new Coordinate(1, 1);

    @Test
    public void windowTest() {

	for (int i = 0; i < 10; i++) {
	    for (int j = 0; j < 10; j++) {
		t.setPixel(i, j, new GrayPixel(Math.random()));
	    }
	}

	Iterator<SubPicture> titt = t.window(9, 9);

	testPictureEquals("Pictures do not equal", titt.next(), t.extract(0, 0, 9, 9));
	testPictureEquals("Pictures do not equal", titt.next(), t.extract(1, 0, 9, 9));
	testPictureEquals("Pictures do not equal", titt.next(), t.extract(0, 1, 9, 9));
	testPictureEquals("Pictures do not equal", titt.next(), t.extract(1, 1, 9, 9));

    }

    @Test
    public void extractTest() {

	for (int i = 0; i < 10; i++) {
	    for (int j = 0; j < 10; j++) {
		t.setPixel(i, j, new GrayPixel(Math.random()));
	    }
	}

	Iterator<SubPicture> titt = t.tile(4, 4);

	testPictureEquals("Pictures do not equal", titt.next(), t.extract(0, 0, 4, 4));
	testPictureEquals("Pictures do not equal", titt.next(), t.extract(4, 0, 4, 4));
	testPictureEquals("Pictures do not equal", titt.next(), t.extract(0, 4, 4, 4));
	testPictureEquals("Pictures do not equal", titt.next(), t.extract(4, 4, 4, 4));

    }

    private static void testPictureEquals(String s, Picture a, Picture b) {
	Iterator<Pixel> aitt = a.iterator(), bitt = b.iterator();

	try {
	    while (aitt.hasNext()) {
		assertEquals(s, aitt.next(), bitt.next());
	    }
	} catch (Exception e) {

	}
    }
}

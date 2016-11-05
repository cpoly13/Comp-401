package a5.tarek;

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

    /*
     * Testing the zigZag iterator. This test creates a new picture, changes
     * some of the pixels from the default gray, and then compares the iterator
     * with the expected values.
     */

    @Test
    public void zigzagTest() {

	Picture p = new PictureImpl(6, 4);
	Pixel testpix = new ColorPixel(0.3, 0.2, 0.8);
	Pixel testpix2 = new ColorPixel(0.0, 1.0, 0.0);
	p.setPixel(4, 2, testpix);
	p.setPixel(1, 3, testpix2);
	Iterator<Pixel> zigtest = p.zigzag();

	/*
	 * Putting all the pixels into a 2D array to make it easier to compare
	 * to the iterator.
	 */
	Pixel[][] testarray = new Pixel[6][4];
	for (int i = 0; i < 4; ++i) {
	    for (int j = 0; j < 6; ++j) {
		testarray[j][i] = p.getPixel(j, i);

	    }
	}
	/*
	 * This takes all the iterator's result pixels and puts them into a 1D
	 * array, and then compares the values with the expected values (found
	 * by hand) of a zig-zag in a 6x4 picture.
	 */
	Pixel[] testarray_zigiter = new Pixel[24];
	for (int i = 0; i < 24; ++i) {
	    testarray_zigiter[i] = zigtest.next();
	}
	assertEquals("Zig-zag method didn't return an expected value", testarray[0][0], testarray_zigiter[0]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[1][0], testarray_zigiter[1]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[0][1], testarray_zigiter[2]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[0][2], testarray_zigiter[3]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[1][1], testarray_zigiter[4]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[2][0], testarray_zigiter[5]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[3][0], testarray_zigiter[6]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[2][1], testarray_zigiter[7]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[1][2], testarray_zigiter[8]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[0][3], testarray_zigiter[9]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[1][3], testarray_zigiter[10]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[2][2], testarray_zigiter[11]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[3][1], testarray_zigiter[12]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[4][0], testarray_zigiter[13]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[5][0], testarray_zigiter[14]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[4][1], testarray_zigiter[15]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[3][2], testarray_zigiter[16]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[2][3], testarray_zigiter[17]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[3][3], testarray_zigiter[18]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[4][2], testarray_zigiter[19]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[5][1], testarray_zigiter[20]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[5][2], testarray_zigiter[21]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[4][3], testarray_zigiter[22]);
	assertEquals("Zig-zag method didn't return an expected value", testarray[5][3], testarray_zigiter[23]);

    }
}

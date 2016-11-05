package a5.meganjn;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagTest";

	return test_names;
    }

    // compares each corresponding original Pixel to Pixel in iterator
    @Test
    public void zigzagTest() {
	Picture p = new PictureImpl(3, 3);
	for (int x = 0; x < 3; x++) {
	    for (int y = 0; y < 3; y++) {
		p.setPixel(x, y, new ColorPixel(0, 0.1 * y, 0.2 * x));
	    }
	}
	Iterator<Pixel> zigzagIterator = p.zigzag();
	assertEquals("zigzag not working", zigzagIterator.next(), p.getPixel(0, 0));
	assertEquals("zigzag not working", zigzagIterator.next(), p.getPixel(1, 0));
	assertEquals("zigzag not working", zigzagIterator.next(), p.getPixel(0, 1));
	assertEquals("zigzag not working", zigzagIterator.next(), p.getPixel(0, 2));
	assertEquals("zigzag not working", zigzagIterator.next(), p.getPixel(1, 1));
	assertEquals("zigzag not working", zigzagIterator.next(), p.getPixel(2, 0));
	assertEquals("zigzag not working", zigzagIterator.next(), p.getPixel(2, 1));
	assertEquals("zigzag not working", zigzagIterator.next(), p.getPixel(1, 2));
	assertEquals("zigzag not working", zigzagIterator.next(), p.getPixel(2, 2));
    }

}

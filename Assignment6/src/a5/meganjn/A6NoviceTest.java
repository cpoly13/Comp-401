package a5.meganjn;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "coordinateExtractTest";
	test_names[1] = "iteratorTest";

	return test_names;
    }

    // tests overloaded extract method
    // compares each pixel of extracted Picture
    @Test
    public void coordinateExtractTest() {
	Picture p = makePicture(4, 4);
	Coordinate p1 = new Coordinate(1, 1);
	Coordinate p2 = new Coordinate(2, 2);
	SubPicture sub = p.extract(p1, p2);
	assertEquals("points dont match", sub.getPixel(0, 0), p.getPixel(1, 1));
	assertEquals("points dont match", sub.getPixel(0, 1), p.getPixel(1, 2));
	assertEquals("points dont match", sub.getPixel(1, 0), p.getPixel(2, 1));
	assertEquals("points dont match", sub.getPixel(1, 1), p.getPixel(2, 2));
    }

    // compares each pixel in iterator to pixel in Picture
    @Test
    public void iteratorTest() {
	Picture p = makePicture(3, 3);

	Iterator<Pixel> testIter = p.iterator();

	assertEquals("hasNext not working", testIter.hasNext(), true);

	assertEquals("iterator not working", testIter.next(), p.getPixel(0, 0));
	assertEquals("iterator not working", testIter.next(), p.getPixel(1, 0));
	assertEquals("iterator not working", testIter.next(), p.getPixel(2, 0));
	assertEquals("iterator not working", testIter.next(), p.getPixel(0, 1));
	assertEquals("iterator not working", testIter.next(), p.getPixel(1, 1));
	assertEquals("iterator not working", testIter.next(), p.getPixel(2, 1));
	assertEquals("iterator not working", testIter.next(), p.getPixel(0, 2));
	assertEquals("iterator not working", testIter.next(), p.getPixel(1, 2));
	assertEquals("iterator not working", testIter.next(), p.getPixel(2, 2));

    }

    // static method that creates new Picture
    // input: width x and height y
    // returns Picture object filled with different Pixels
    private static Picture makePicture(int x, int y) {
	Picture p = new PictureImpl(x, y);
	for (int x2 = 0; x2 < x; x2++) {
	    for (int y2 = 0; y2 < y; y2++) {
		p.setPixel(x2, y2, new ColorPixel(0, 0, 0.01 * x2));
	    }
	}
	return p;
    }

}

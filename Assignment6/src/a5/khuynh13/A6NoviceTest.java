package a5.khuynh13;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];
	test_names[0] = "iteratorTest1";
	test_names[1] = "iteratorTest2";
	return test_names;
    }

    @Test
    public void iteratorTest1() {
	Picture p1 = new PictureImpl(2, 2);
	Picture p2 = p1.extract(1, 1, 1, 1);
	Picture p3 = p1.extract(new Coordinate(1, 1), new Coordinate(1, 1));
	Pixel rand_pixel = new GrayPixel(0.67);
	Pixel rand_pixel2 = new GrayPixel(0.87);
	p1.setPixel(0, 0, rand_pixel);
	p1.setPixel(1, 0, new GrayPixel(0.45));
	p1.setPixel(0, 1, new GrayPixel(0.34));
	p1.setPixel(1, 1, rand_pixel2);
	Iterator<Pixel> iter = p1.iterator();
	Iterator<Pixel> iter2 = p2.iterator();
	Iterator<Pixel> iter3 = p3.iterator();

	assertEquals("Pixel returned does not match what's there", iter.next(), rand_pixel);
	assertEquals("Pixel returned does not match what's there", iter.next(), p1.getPixel(1, 0));
	assertEquals("Pixel returned does not match what's there", iter.next(), p1.getPixel(0, 1));
	assertEquals("Pixel returned does not match what's there", iter.next(), p1.getPixel(1, 1));
	assertEquals("Something is wrong with hasNext", iter.hasNext(), false);
	try {
	    assertEquals("Pixel returned does not match what's there", iter.next());
	} catch (NoSuchElementException e) {
	}
	assertEquals("The picture should return the single pixel", iter2.next(), p2.getPixel(0, 0));
	assertEquals("There are no more pixels", iter2.hasNext(), false);
	try {
	    assertEquals("Whatever", iter2.next());
	} catch (NoSuchElementException e) {
	}
	assertEquals("The picture should return the single pixel", iter3.next(), p2.getPixel(0, 0));
	assertEquals("There are no more pixels", iter3.hasNext(), false);
    }

    @Test
    public void iteratorTest2() {
	Picture p1 = new PictureImpl(2, 1);
	Iterator<Pixel> iter = p1.iterator();
	iter.next();
	iter.next();

	assertEquals("There are no more pixels", iter.hasNext(), false);
	try {
	    assertEquals("No pixels left to return", iter.next());
	} catch (NoSuchElementException e) {
	}
    }
}

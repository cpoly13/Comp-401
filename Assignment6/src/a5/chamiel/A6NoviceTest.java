package a5.chamiel;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "setPixelTest";
	test_names[1] = "extractTest";
	test_names[2] = "iteratorTest";

	return test_names;
    }

    @Test
    public void setPixelTest() {
	Picture pic = new PictureImpl(10, 10);
	pic.setPixel(new Coordinate(4, 4), new ColorPixel(.3, .7, .8));
	assertTrue(new ColorPixel(.3, .7, .8).getIntensity() == pic.getPixel(4, 4).getIntensity());
    }

    @Test
    public void extractTest() {
	Picture pic = new PictureImpl(10, 10);
	pic.setPixel(5, 5, new ColorPixel(Math.random(), Math.random(), Math.random()));
	Picture sub = pic.extract(new Coordinate(2, 2), new Coordinate(8, 8));
	assertTrue(sub.getPixel(3, 3).getIntensity() == pic.extract(2, 2, 6, 6).getPixel(3, 3).getIntensity());
    }

    @Test
    public void iteratorTest() {
	Picture pic = new PictureImpl(10, 10);
	Iterator<Pixel> it = pic.iterator();
	for (int i = 0; i < 10; i++) {
	    for (int j = 0; j < 10; j++) {
		pic.setPixel(i, j, new ColorPixel(Math.random(), Math.random(), Math.random()));
	    }
	}
	int i = (int) (Math.random() * 100);
	int j = 0;
	Coordinate c = new Coordinate(i % 10, i / 10);
	while (j < i) {
	    it.next();
	    j++;
	}
	assertTrue(pic.getPixel(c).getIntensity() == it.next().getIntensity());
	while (j < 99) {
	    it.next();
	    j++;
	}
	assertTrue(!it.hasNext());
	try {
	    it.next();
	} catch (NoSuchElementException e) {
	}

    }
}

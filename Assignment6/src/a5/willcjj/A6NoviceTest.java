package a5.willcjj;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "iteratorTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void iteratorTest() {
	Picture pic = new PictureImpl(3, 3);
	Iterator<Pixel> iter = pic.iterator();
	pic.setPixel(0, 0, new GrayPixel(0));
	pic.setPixel(2, 2, new GrayPixel(1));
	for (int x = 0; x < 9; x++) {
	    Pixel temp = iter.next();
	    if (x == 0) {
		assertEquals("Error", temp.getIntensity(), 0, 0.0001);
	    } else if (x == 8) {
		assertEquals("Error", temp.getIntensity(), 1, 0.001);
	    }
	}
	assertEquals("Iterator hasNext", iter.hasNext(), false);
    }
}

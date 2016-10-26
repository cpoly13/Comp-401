package a5.leejoon;

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

    // Test zigzag method
    @Test
    public void zigzagTest() {
	Picture p = new PictureImpl(3, 3);
	Iterator<Pixel> zigzag_iter = p.zigzag();
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		Pixel k = new GrayPixel(0.1 * i * j);
		p.setPixel(i, j, k);
	    }
	}

	if (zigzag_iter.hasNext()) {
	    assertEquals(p.getPixel(0, 0), zigzag_iter.next());
	}
	if (zigzag_iter.hasNext()) {
	    assertEquals(p.getPixel(1, 0), zigzag_iter.next());
	}
	if (zigzag_iter.hasNext()) {
	    assertEquals(p.getPixel(0, 1), zigzag_iter.next());
	}
	if (zigzag_iter.hasNext()) {
	    assertEquals(p.getPixel(0, 2), zigzag_iter.next());
	}
	if (zigzag_iter.hasNext()) {
	    assertEquals(p.getPixel(1, 1), zigzag_iter.next());
	}
	if (zigzag_iter.hasNext()) {
	    assertEquals(p.getPixel(2, 0), zigzag_iter.next());
	}
	if (zigzag_iter.hasNext()) {
	    assertEquals(p.getPixel(2, 1), zigzag_iter.next());
	}
	if (zigzag_iter.hasNext()) {
	    assertEquals(p.getPixel(1, 2), zigzag_iter.next());
	}
	if (zigzag_iter.hasNext()) {
	    assertEquals(p.getPixel(2, 2), zigzag_iter.next());
	}
    }
}

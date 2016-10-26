package a5.tsethe;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.GrayPixel;
import a6jedi.*;

public class A6JediTest {
    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagTest";

	return test_names;
    }

    @Test
    public void zigzagTest() {
	Picture p = new PictureImpl(4, 4);
	p.setPixel(1, 0, new GrayPixel(.66));
	p.setPixel(0, 1, new GrayPixel(.66));
	Iterator<Pixel> zigzag_iter = p.zigzag();

	assertEquals("Pixels do not match", p.getPixel(0, 0), zigzag_iter.next());
	assertEquals("Pixels do not match", p.getPixel(1, 0), zigzag_iter.next());
	assertEquals("Pixels do not match", p.getPixel(0, 1), zigzag_iter.next());
	assertEquals("Pixels do not match", p.getPixel(0, 2), zigzag_iter.next());
	assertEquals("Pixels do not match", p.getPixel(1, 1), zigzag_iter.next());

    }
}
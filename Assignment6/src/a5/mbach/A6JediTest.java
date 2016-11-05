package a5.mbach;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testZigZag";

	return test_names;
    }

    @Test
    public void testZigZag() {
	Picture p = new PictureImpl(4, 4);

	Iterator<Pixel> iter_zigZag = p.zigzag();

	assertEquals("Pixel does not match expected pixel value", p.getPixel(0, 0), iter_zigZag.next());
	assertEquals("Pixel does not match expected pixel value", p.getPixel(1, 0), iter_zigZag.next());
	assertEquals("Pixel does not match expected pixel value", p.getPixel(0, 1), iter_zigZag.next());
	assertEquals("Pixel does not match expected pixel value", p.getPixel(0, 2), iter_zigZag.next());
	assertEquals("Pixel does not match expected pixel value", p.getPixel(1, 1), iter_zigZag.next());
	assertEquals("Pixel does not match expected pixel value", p.getPixel(2, 0), iter_zigZag.next());
	assertEquals("Pixel does not match expected pixel value", p.getPixel(3, 0), iter_zigZag.next());
	assertEquals("Pixel does not match expected pixel value", p.getPixel(2, 1), iter_zigZag.next());

    }
}

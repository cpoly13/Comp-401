package a5.mbach;

import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testSample";

	return test_names;
    }

    @Test
    public void testSample() {
	Picture p = new PictureImpl(10, 10);

	Iterator<Pixel> sample_iter = p.sample(2, 1, 2, 3);

	assertEquals("Pixel returned was not the expected pixel", p.getPixel(2, 1), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(4, 1), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(6, 1), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(8, 1), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(2, 4), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(4, 4), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(6, 4), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(8, 4), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(2, 7), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(4, 7), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(6, 7), sample_iter.next());
	assertEquals("Pixel returned was not the expected pixel", p.getPixel(8, 7), sample_iter.next());

    }
}

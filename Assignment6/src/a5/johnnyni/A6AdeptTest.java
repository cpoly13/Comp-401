package a5.johnnyni;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "sampleTest";

	return test_names;
    }

    @Test
    public void sampleTest() {
	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
	assertEquals(p.getPixel(2, 3), sample_iter.next());
	assertEquals(p.getPixel(5, 3), sample_iter.next());
	assertEquals(p.getPixel(8, 3), sample_iter.next());
	assertEquals(p.getPixel(11, 3), sample_iter.next());
	assertEquals(p.getPixel(14, 3), sample_iter.next());
	assertEquals(p.getPixel(2, 7), sample_iter.next());
	assertEquals(p.getPixel(5, 7), sample_iter.next());
	assertEquals(p.getPixel(8, 7), sample_iter.next());
	assertEquals(p.getPixel(11, 7), sample_iter.next());
	assertEquals(p.getPixel(14, 7), sample_iter.next());
    }
}

package a5.moshe;

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
	Picture p = new PictureImpl(15, 10); // attempting to use example
					     // provided in
					     // assignment 6

	Iterator<Pixel> sample_it = p.sample(2, 3, 3, 4);
	assertEquals("A sampled pixel is incorrect.", p.getPixel(2, 3), sample_it.next());
	assertEquals("A sampled pixel is incorrect.", p.getPixel(5, 3), sample_it.next());
	assertEquals("A sampled pixel is incorrect.", p.getPixel(8, 3), sample_it.next());
	assertEquals("A sampled pixel is incorrect.", p.getPixel(11, 3), sample_it.next());
	assertEquals("A sampled pixel is incorrect.", p.getPixel(14, 3), sample_it.next());
	assertEquals("A sampled pixel is incorrect.", p.getPixel(2, 7), sample_it.next());
	assertEquals("A sampled pixel is incorrect.", p.getPixel(5, 7), sample_it.next());
	assertEquals("A sampled pixel is incorrect.", p.getPixel(8, 7), sample_it.next());
	assertEquals("A sampled pixel is incorrect.", p.getPixel(11, 7), sample_it.next());
	assertEquals("A sampled pixel is incorrect.", p.getPixel(14, 7), sample_it.next());
	assertEquals("There is no next pixel.", false, sample_it.hasNext());

    }
}

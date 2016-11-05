package a5.tsethe;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "sampleTest";
	test_names[1] = "windowTest";

	return test_names;
    }

    @Test
    public void sampleTest() {

	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);

	p.setPixel(2, 3, new GrayPixel(.66));

	assertEquals("Pixels do not match", p.getPixel(2, 3), sample_iter.next());
	assertEquals("Pixels do not match", p.getPixel(5, 3), sample_iter.next());
	assertEquals("Pixels do not match", p.getPixel(8, 3), sample_iter.next());

    }

    @Test
    public void windowTest() {

	Picture p = new PictureImpl(5, 2);
	Iterator<SubPicture> window_iter = p.window(3, 2);

	assertEquals("Pixels do not match", p.getPixel(0, 0), window_iter.next().getPixel(0, 0));
	assertEquals("Pixels do not match", p.getPixel(1, 0), window_iter.next().getPixel(0, 0));

    }
}
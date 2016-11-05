package a5.connjin;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "sampleIteratorTest";

	return test_names;
    }

    @Test
    public void sampleIteratorTest() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, GREEN);
	p.setPixel(2, 1, GREEN);
	p.setPixel(0, 2, BLUE);
	p.setPixel(1, 2, BLUE);
	p.setPixel(2, 2, BLUE);
	Iterator<Pixel> sample_iter = p.sample(0, 0, 2, 1);

	assertEquals("Not next", RED, sample_iter.next());
	assertEquals("Not next", RED, sample_iter.next());
	assertEquals("Not next", GREEN, sample_iter.next());
	assertEquals("Not next", GREEN, sample_iter.next());
	assertEquals("Not next", BLUE, sample_iter.next());
	assertEquals("Not next", BLUE, sample_iter.next());
    }

}

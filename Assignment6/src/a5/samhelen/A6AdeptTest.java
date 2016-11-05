package a5.samhelen;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "sampleTest";

	return test_names;
    }

    @Test
    public void sampleTest() {
	Picture p = new PictureImpl(6, 5);
	p.setPixel(1, 1, RED);
	p.setPixel(3, 1, GREEN);
	p.setPixel(5, 1, WHITE);
	p.setPixel(1, 4, BLUE);
	p.setPixel(3, 4, RED);
	p.setPixel(5, 4, BLACK);

	Iterator<Pixel> sample_iter = p.sample(1, 1, 2, 3);

	assertEquals("Pixel is different", p.getPixel(1, 1), sample_iter.next());

	assertEquals("Pixel is different", p.getPixel(3, 1), sample_iter.next());

	assertEquals("Pixel is different", p.getPixel(5, 1), sample_iter.next());

	assertEquals("Pixel is different", p.getPixel(1, 4), sample_iter.next());

	assertEquals("Pixel is different", p.getPixel(3, 4), sample_iter.next());

	assertEquals("Pixel is different", p.getPixel(5, 4), sample_iter.next());

    }

}

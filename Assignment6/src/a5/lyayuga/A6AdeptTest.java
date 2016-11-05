package a5.lyayuga;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "sampleTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void sampleTest() {
	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
	p.setPixel(2, 3, RED);
	assertTrue(sample_iter.next().equals(p.getPixel(2, 3)));
	p.setPixel(5, 3, GREEN);
	assertTrue(sample_iter.next().equals(p.getPixel(5, 3)));
	p.setPixel(8, 3, BLUE);
	assertTrue(sample_iter.next().equals(p.getPixel(8, 3)));
	sample_iter.next();
	sample_iter.next();
	p.setPixel(2, 7, WHITE);
	assertTrue(sample_iter.next().equals(p.getPixel(2, 7)));
    }
}

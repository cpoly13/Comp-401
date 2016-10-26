package a5.lironb;

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

	test_names[0] = "sampleTest";
	test_names[1] = "windowTest";

	return test_names;
    }

    @Test
    public void sampleTest() {
	Picture p = new PictureImpl(4, 4);
	p.setPixel(0, 1, WHITE);
	p.setPixel(2, 1, GREEN);
	p.setPixel(0, 3, BLUE);
	p.setPixel(2, 3, RED);

	Iterator<Pixel> sample_iter = p.sample(0, 1, 2, 2);

	assertEquals("Sample is returning incorrect pixels", sample_iter.next(), WHITE);
	assertEquals("Sample is returning incorrect pixels", sample_iter.next(), GREEN);
	assertEquals("Sample is returning incorrect pixels", sample_iter.next(), BLUE);
	assertEquals("Sample is returning incorrect pixels", sample_iter.next(), RED);

    }

    @Test
    public void windowTest() {
	Picture p1 = new PictureImpl(2, 2);
	p1.setPixel(0, 0, WHITE);
	p1.setPixel(1, 0, BLUE);
	p1.setPixel(0, 1, RED);
	p1.setPixel(1, 1, GREEN);

	Iterator<SubPicture> it = p1.tile(1, 1);

	assertEquals("tile method is returning the incorrect input", it.next().getPixel(0, 0), WHITE);
	assertEquals("tile method is returning the incorrect input", it.next().getPixel(0, 0), BLUE);
	assertEquals("tile method is returning the incorrect input", it.next().getPixel(0, 0), RED);
	assertEquals("tile method is returning the incorrect input", it.next().getPixel(0, 0), GREEN);
    }
}

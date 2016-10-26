package a5.robro;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

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
	Picture p = new PictureImpl(4, 4);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(3, 0, BLUE);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(3, 1, GREEN);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);
	p.setPixel(3, 2, WHITE);
	p.setPixel(0, 3, BLACK);
	p.setPixel(1, 3, RED);
	p.setPixel(2, 3, GREEN);
	p.setPixel(3, 3, WHITE);

	Iterator<Pixel> test = p.sample(0, 0, 2, 2);

	assertEquals("Iterator hasNext not functioning", true, test.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(0, 0), test.next());
	assertEquals("Iterator hasNext not functioning", true, test.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(2, 0), test.next());
	assertEquals("Iterator hasNext not functioning", true, test.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(0, 2), test.next());
	assertEquals("Iterator hasNext not functioning", true, test.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(2, 2), test.next());
    }
}

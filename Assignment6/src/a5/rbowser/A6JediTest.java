package a5.rbowser;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel BLACK = new GrayPixel(0);
    private static final Pixel WHITE = new GrayPixel(1);

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigTest";

	return test_names;
    }

    @Test
    public void zigTest() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, GREEN);
	p.setPixel(2, 0, BLUE);
	p.setPixel(0, 1, BLACK);
	p.setPixel(1, 1, WHITE);
	p.setPixel(2, 1, RED);
	p.setPixel(0, 2, GREEN);
	p.setPixel(1, 2, BLUE);
	p.setPixel(2, 2, BLACK);
	Iterator<Pixel> i = p.zigzag();
	assertEquals(p.getPixel(0, 0), i.next());
	assertEquals(p.getPixel(1, 0), i.next());
	assertEquals(p.getPixel(0, 1), i.next());
	assertEquals(p.getPixel(0, 2), i.next());
	assertEquals(p.getPixel(1, 1), i.next());
	assertEquals(p.getPixel(2, 0), i.next());
	assertEquals(p.getPixel(2, 1), i.next());
	assertEquals(p.getPixel(1, 2), i.next());
	assertEquals(p.getPixel(2, 2), i.next());
	assertFalse(i.hasNext());

    }
}

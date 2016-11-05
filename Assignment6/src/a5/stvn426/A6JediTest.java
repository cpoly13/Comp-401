package a5.stvn426;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testZigzag";

	return test_names;
    }

    @Test
    public void testZigzag() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);

	Iterator<Pixel> zz = p.zigzag();

	assertEquals("Zigzag iterator does not return expected pixel", zz.next(), p.getPixel(0, 0));
	assertEquals("Zigzag iterator does not return expected pixel", zz.next(), p.getPixel(1, 0));
	assertEquals("Zigzag iterator does not return expected pixel", zz.next(), p.getPixel(0, 1));
	assertEquals("Zigzag iterator does not return expected pixel", zz.next(), p.getPixel(0, 2));
	assertEquals("Zigzag iterator does not return expected pixel", zz.next(), p.getPixel(1, 1));
	assertEquals("Zigzag iterator does not return expected pixel", zz.next(), p.getPixel(2, 0));
	assertEquals("Zigzag iterator does not return expected pixel", zz.next(), p.getPixel(2, 1));
	assertEquals("Zigzag iterator does not return expected pixel", zz.next(), p.getPixel(1, 2));
	assertEquals("Zigzag iterator does not return expected pixel", zz.next(), p.getPixel(2, 2));
    }
}

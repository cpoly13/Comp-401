package a5.richyle;

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

	test_names[0] = "zigZagTest";

	return test_names;
    }

    @Test
    public void zigZagTest() {
	Picture p1 = new PictureImpl(3, 3);
	p1.setPixel(0, 0, WHITE);
	p1.setPixel(0, 1, BLUE);
	p1.setPixel(0, 2, RED);
	p1.setPixel(1, 0, GREEN);
	p1.setPixel(1, 1, BLACK);
	p1.setPixel(1, 2, WHITE);
	p1.setPixel(2, 0, BLUE);
	p1.setPixel(2, 1, RED);
	p1.setPixel(2, 2, GREEN);
	Iterator<Pixel> it = p1.zigzag();
	assertEquals("zig zag does not work", it.next(), WHITE);
	assertEquals("zig zag does not work", it.next(), GREEN);
	assertEquals("zig zag does not work", it.next(), BLUE);
	assertEquals("zig zag does not work", it.next(), RED);
	assertEquals("zig zag does not work", it.next(), BLACK);
	assertEquals("zig zag does not work", it.next(), BLUE);
	assertEquals("zig zag does not work", it.next(), RED);
	assertEquals("zig zag does not work", it.next(), WHITE);
	assertEquals("zig zag does not work", it.next(), GREEN);
    }
}

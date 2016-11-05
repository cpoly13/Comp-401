package a5.lukefd;

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
    private static final Pixel OTHER = new ColorPixel(.12, .5, .6);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "zigZagTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void zigZagTest() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(0, 2, BLUE);
	p.setPixel(1, 0, WHITE);
	p.setPixel(1, 2, BLACK);
	p.setPixel(1, 2, OTHER);
	p.setPixel(2, 0, RED);
	p.setPixel(2, 1, GREEN);
	p.setPixel(2, 2, BLUE);

	Iterator<Pixel> zig = p.zigzag();

	assertEquals("The pixel does not match the expected value.", p.getPixel(0, 0), zig.next());
	assertEquals("The pixel does not match the expected value.", p.getPixel(1, 0), zig.next());
	assertEquals("The pixel does not match the expected value.", p.getPixel(0, 1), zig.next());
	assertEquals("The pixel does not match the expected value.", p.getPixel(0, 2), zig.next());
    }
}

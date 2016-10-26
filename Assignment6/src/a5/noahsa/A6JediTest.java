package a5.noahsa;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.Pixel;
import a6jedi.*;

public class A6JediTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testZigZag";

	return test_names;
    }

    @Test
    public void testZigZag() {
	Picture p = new PictureImpl(4, 4);
	Iterator<Pixel> zig_zag_iter = p.zigzag();

	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, GREEN);
	p.setPixel(0, 1, BLUE);
	p.setPixel(0, 2, RED);
	p.setPixel(1, 1, GREEN);
	p.setPixel(2, 0, BLUE);
	p.setPixel(3, 0, RED);
	p.setPixel(2, 1, GREEN);
	p.setPixel(1, 2, BLUE);
	p.setPixel(0, 3, RED);
	p.setPixel(1, 3, GREEN);
	p.setPixel(2, 2, BLUE);
	p.setPixel(3, 1, RED);
	p.setPixel(3, 2, GREEN);
	p.setPixel(2, 3, BLUE);
	p.setPixel(3, 3, RED);

	assertEquals("Zigzaged to the wrong pixel", p.getPixel(0, 0), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(1, 0), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(0, 1), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(0, 2), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(1, 1), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(2, 0), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(3, 0), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(2, 1), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(1, 2), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(0, 3), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(1, 3), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(2, 2), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(3, 1), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(3, 2), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(2, 3), zig_zag_iter.next());
	assertEquals("Zigzaged to the wrong pixel", p.getPixel(3, 3), zig_zag_iter.next());

    }
}

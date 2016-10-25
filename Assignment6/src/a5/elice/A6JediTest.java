package a5.elice;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.GrayPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {
	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	static public String[] getTestNames() {
		String[] test_names = new String[1];

		test_names[0] = "jediTest";

		return test_names;
	}

	@Test
	public void jediTest() {
		Picture p1 = new PictureImpl(3, 3);
		p1.setPixel(0, 0, RED);
		p1.setPixel(0, 1, GREEN);
		p1.setPixel(0, 2, BLUE);
		p1.setPixel(1, 0, WHITE);
		p1.setPixel(1, 1, BLACK);
		p1.setPixel(1, 2, RED);
		p1.setPixel(2, 0, GREEN);
		p1.setPixel(2, 1, BLUE);
		p1.setPixel(2, 2, WHITE);
		Iterator<Pixel> iT = p1.zigzag();
		assertEquals("ZigZAG method not returning expected output", iT.next(), RED);
		assertEquals("ZigZAG method not returning expected output", iT.next(), WHITE);
		assertEquals("ZigZAG method not returning expected output", iT.next(), GREEN);
		assertEquals("ZigZAG method not returning expected output", iT.next(), BLUE);
		assertEquals("ZigZAG method not returning expected output", iT.next(), BLACK);
		assertEquals("ZigZAG method not returning expected output", iT.next(), GREEN);
		assertEquals("ZigZAG method not returning expected output", iT.next(), BLUE);
		assertEquals("ZigZAG method not returning expected output", iT.next(), RED);
		assertEquals("ZigZAG method not returning expected output", iT.next(), WHITE);

	}
}

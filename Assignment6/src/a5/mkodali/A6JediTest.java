package a5.mkodali;

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

		test_names[0] = "zigzagTest";

		return test_names;
	}

	@Test
	public void zigzagTest() {
		Picture p1 = new PictureImpl(3, 2);
		p1.setPixel(0, 0, GREEN);
		p1.setPixel(1, 0, WHITE);
		p1.setPixel(0, 1, BLUE);
		p1.setPixel(1, 1, RED);
		p1.setPixel(2, 0, BLACK);
		p1.setPixel(2, 1, GREEN);
		Iterator<Pixel> iterator = p1.zigzag();
		assertEquals("The values are not correct for the method", iterator.next(), GREEN);
		assertEquals("The values are not correct for the method", iterator.next(), WHITE);
		assertEquals("The values are not correct for the method", iterator.next(), BLUE);
		assertEquals("The values are not correct for the method", iterator.next(), RED);
		assertEquals("The values are not correct for the method", iterator.next(), BLACK);
		assertEquals("The values are not correct for the method", iterator.next(), GREEN);

	}
}

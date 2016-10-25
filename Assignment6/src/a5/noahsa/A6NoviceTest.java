package a5.noahsa;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.GrayPixel;
import a6novice.Pixel;
import a6novice.*;

public class A6NoviceTest {

	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);

	static public String[] getTestNames() {
		String[] test_names = new String[1];

		test_names[0] = "testExtract";

		return test_names;
	}

	@Test
	public void testExtract() {
		Picture p = new PictureImpl(3, 3);
		p.extract(1, 1, 2, 2);

		p.setPixel(1, 1, RED);
		p.setPixel(1, 2, GREEN);
		p.setPixel(2, 2, BLUE);

		assertEquals("Wrong pixel", p.getPixel(1, 1), p.extract(1, 1, 2, 2).getPixel(0, 0));
		assertEquals("Wrong pixel", p.getPixel(1, 2), p.extract(1, 1, 2, 2).getPixel(0, 1));
		assertEquals("Wrong pixel", p.getPixel(2, 2), p.extract(1, 1, 2, 2).getPixel(1, 1));

		Picture p2 = new PictureImpl(5, 5);
		p2.extract(1, 2, 3, 3);

		p2.setPixel(2, 3, RED);

		assertEquals("Wrong pixel", p2.getPixel(2, 3), p2.extract(1, 2, 3, 3).getPixel(1, 1));
	}
}

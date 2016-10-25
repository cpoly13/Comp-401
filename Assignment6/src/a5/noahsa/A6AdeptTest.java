package a5.noahsa;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.GrayPixel;
import a6adept.Pixel;
import a6adept.*;

public class A6AdeptTest {

	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);

	static public String[] getTestNames() {
		String[] test_names = new String[3];

		test_names[0] = "testSample";
		test_names[1] = "testWindow";
		test_names[2] = "testTile";

		return test_names;
	}

	@Test
	public void testSample() {
		Picture p1 = new PictureImpl(15, 10);

		p1.setPixel(2, 3, RED);
		p1.setPixel(5, 3, GREEN);
		p1.setPixel(8, 3, BLUE);
		p1.setPixel(11, 3, RED);
		p1.setPixel(14, 3, GREEN);
		p1.setPixel(2, 7, BLUE);
		p1.setPixel(5, 7, RED);
		p1.setPixel(8, 7, GREEN);
		p1.setPixel(11, 7, BLUE);
		p1.setPixel(14, 7, RED);

		Iterator<Pixel> test_p1 = p1.sample(2, 3, 3, 4);

		assertEquals("Incorrect Pixel", RED, test_p1.next());
		assertEquals("Incorrect Pixel", GREEN, test_p1.next());
		assertEquals("Incorrect Pixel", BLUE, test_p1.next());
		assertEquals("Incorrect Pixel", RED, test_p1.next());
		assertEquals("Incorrect Pixel", GREEN, test_p1.next());
		assertEquals("Incorrect Pixel", BLUE, test_p1.next());
		assertEquals("Incorrect Pixel", RED, test_p1.next());
		assertEquals("Incorrect Pixel", GREEN, test_p1.next());
		assertEquals("Incorrect Pixel", BLUE, test_p1.next());
		assertEquals("Incorrect Pixel", RED, test_p1.next());

	}

	@Test
	public void testWindow() {
		Picture p = new PictureImpl(5, 5);
		Iterator<SubPicture> window_iter = p.window(3, 2);

		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, GREEN);
		p.setPixel(2, 0, BLUE);
		p.setPixel(0, 1, RED);
		p.setPixel(1, 1, GREEN);
		p.setPixel(2, 1, BLUE);
		p.setPixel(0, 3, RED);
		p.setPixel(1, 3, GREEN);
		p.setPixel(2, 3, BLUE);

		assertEquals("Wrong Pixel", p.extract(0, 0, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(1, 0, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(2, 0, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(0, 1, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(1, 1, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(2, 1, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(0, 2, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(1, 2, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(2, 2, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(0, 3, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(1, 3, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));
		assertEquals("Wrong Pixel", p.extract(2, 3, 3, 2).getPixel(0, 0), window_iter.next().getPixel(0, 0));

	}

	@Test
	public void testTile() {
		Picture p = new PictureImpl(5, 5);
		Iterator<SubPicture> tile_iter = p.tile(2, 2);

		p.setPixel(0, 0, RED);
		p.setPixel(2, 0, GREEN);
		p.setPixel(0, 2, BLUE);
		p.setPixel(2, 2, RED);

		assertEquals("Wrong pixel", p.extract(0, 0, 2, 2).getPixel(0, 0), tile_iter.next().getPixel(0, 0));
		assertEquals("Wrong pixel", p.extract(2, 0, 2, 2).getPixel(0, 0), tile_iter.next().getPixel(0, 0));
		assertEquals("Wrong pixel", p.extract(0, 2, 2, 2).getPixel(0, 0), tile_iter.next().getPixel(0, 0));
		assertEquals("Wrong pixel", p.extract(2, 2, 2, 2).getPixel(0, 0), tile_iter.next().getPixel(0, 0));

	}

}

package a5.mkodali;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";

		return test_names;
	}

	@Test
	public void sampleTest() {
		Picture p1 = new PictureImpl(4, 4);
		p1.setPixel(0, 0, GREEN);
		p1.setPixel(2, 0, WHITE);
		p1.setPixel(0, 2, RED);
		p1.setPixel(2, 2, BLUE);
		Iterator<Pixel> iterator = p1.sample(0, 0, 2, 2);
		assertEquals("expected output not returned by the sample method", iterator.next(), GREEN);
		assertEquals("expected output not returned by the sample method", iterator.next(), WHITE);
		assertEquals("expected output not returned by the sample method", iterator.next(), RED);
		assertEquals("expected output not returned by the sample method", iterator.next(), BLUE);

	}

	@Test
	public void windowTest() {
		Picture p1 = new PictureImpl(2, 2);
		p1.setPixel(0, 0, GREEN);
		p1.setPixel(1, 0, WHITE);
		p1.setPixel(0, 1, RED);
		p1.setPixel(1, 1, BLUE);
		Iterator<SubPicture> iterator = p1.tile(1, 1);
		assertEquals("the incorrect value is being returned by the method", iterator.next().getPixel(0, 0), GREEN);
		assertEquals("the incorrect value is being returned by the method", iterator.next().getPixel(0, 0), WHITE);
		assertEquals("the incorrect value is being returned by the method", iterator.next().getPixel(0, 0), RED);
		assertEquals("the incorrect value is being returned by the method", iterator.next().getPixel(0, 0), BLUE);
	}
}

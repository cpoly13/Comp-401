package a5.samitha;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	private static Picture PIC = new PictureImpl(4, 4);

	private Picture PictureMaker() {
		PIC.setPixel(0, 0, RED);
		PIC.setPixel(1, 0, GREEN);
		PIC.setPixel(2, 0, BLUE);
		PIC.setPixel(3, 0, RED);
		PIC.setPixel(0, 1, GREEN);
		PIC.setPixel(1, 1, BLUE);
		PIC.setPixel(2, 1, RED);
		PIC.setPixel(3, 1, GREEN);
		PIC.setPixel(0, 2, BLUE);
		PIC.setPixel(1, 2, RED);
		PIC.setPixel(2, 2, GREEN);
		PIC.setPixel(3, 2, BLUE);
		PIC.setPixel(0, 3, WHITE);
		PIC.setPixel(1, 3, WHITE);
		PIC.setPixel(2, 3, BLACK);
		PIC.setPixel(3, 3, BLACK);
		return PIC;
	}

	static public String[] getTestNames() {
		String[] test_names = new String[1];

		test_names[0] = "testIterator";

		return test_names;
	}

	@Test
	public void testIterator() {
		Picture p = this.PictureMaker();
		Iterator<Pixel> testIterator = p.iterator();

		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), RED);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), GREEN);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), BLUE);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), RED);

		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), GREEN);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), BLUE);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), RED);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), GREEN);

		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), BLUE);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), RED);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), GREEN);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), BLUE);

		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), WHITE);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), WHITE);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), BLACK);
		assertEquals("Pixel retrieved from iterator does not exist, which is supposed to exist", testIterator.hasNext(),
				true);
		assertEquals("Pixel retrieved from iterator does not match expected pixel value from source",
				testIterator.next(), BLACK);

		assertEquals("Pixel retrieved from iterator does exist, which is supposed to not exist", testIterator.hasNext(),
				false);

	}

}
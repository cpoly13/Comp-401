package a5.khuynh13;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[5];
		test_names[0] = "sampleIteratorTest1";
		test_names[1] = "sampleIteratorTest2";
		test_names[2] = "compareSampleIteratorAndIterator";
		test_names[3] = "windowTest";
		test_names[4] = "tileTest";
		return test_names;
	}

	@Test
	public void sampleIteratorTest1() {
		Picture p1 = new PictureImpl(10, 10);
		Iterator<Pixel> sample_iter = p1.sample(2, 2, 2, 1);

		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(2, 2));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(4, 2));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(6, 2));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(8, 2));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(2, 3));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(4, 3));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(6, 3));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(8, 3));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(2, 4));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(4, 4));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(6, 4));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(8, 4));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(2, 5));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(4, 5));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(6, 5));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(8, 5));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(2, 6));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(4, 6));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(6, 6));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(8, 6));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(2, 7));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(4, 7));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(6, 7));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(8, 7));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(2, 8));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(4, 8));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(6, 8));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(8, 8));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(2, 9));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(4, 9));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(6, 9));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(8, 9));
		assertEquals("There are no more pixels", sample_iter.hasNext(), false);
		try {
			sample_iter.next();
		} catch (NoSuchElementException e) {
		}
	}

	@Test
	public void sampleIteratorTest2() {
		Picture p1 = new PictureImpl(4, 2);
		Iterator<Pixel> sample_iter = p1.sample(0, 1, 1, 2);
		p1.setPixel(0, 1, new GrayPixel(0.45));
		p1.setPixel(1, 1, new GrayPixel(0.33));
		p1.setPixel(2, 1, new GrayPixel(0.56));
		p1.setPixel(3, 1, new GrayPixel(0.47));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(0, 1));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(1, 1));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(2, 1));
		assertEquals("The pixels don't match", sample_iter.next(), p1.getPixel(3, 1));
		assertEquals("There are no more pixels", sample_iter.hasNext(), false);
	}

	@Test
	public void compareSampleIteratorAndIterator() {
		Picture p1 = new PictureImpl(2, 2);
		Iterator<Pixel> sample_iter = p1.sample(0, 0, 1, 1);
		Iterator<Pixel> iter = p1.iterator();
		p1.setPixel(0, 0, new GrayPixel(0.98));
		p1.setPixel(1, 0, new GrayPixel(0.87));
		p1.setPixel(0, 1, new GrayPixel(0.54));
		p1.setPixel(1, 1, new GrayPixel(0.66));
		assertEquals("The pixels don't match", sample_iter.next(), iter.next());
		assertEquals("The pixels don't match", sample_iter.next(), iter.next());
		assertEquals("The pixels don't match", sample_iter.next(), iter.next());
		assertEquals("The pixels don't match", sample_iter.next(), iter.next());
		try {
			assertEquals("The pixels don't match", sample_iter.next(), iter.next());
		} catch (NoSuchElementException e) {
		}
		assertEquals("There are no more pixels", sample_iter.hasNext(), iter.hasNext());
	}

	@Test
	public void windowTest() {
		Picture p1 = new PictureImpl(5, 5);
		Iterator<SubPicture> window_iter = p1.window(3, 2);
		assertEquals("The subpictures' pixels don't match", window_iter.next().getPixel(0, 0),
				p1.extract(0, 0, 3, 2).getPixel(0, 0));
		window_iter.next();
		window_iter.next();
		assertEquals("The subpictures' pixels don't match", window_iter.next().getPixel(1, 2),
				p1.extract(0, 1, 3, 2).getPixel(1, 1));
	}

	@Test
	public void tileTest() {
		Picture p1 = new PictureImpl(5, 5);
		Iterator<SubPicture> tile_iter = p1.tile(2, 2);
		tile_iter.next();
		tile_iter.next();
		assertEquals("The subpictures' pixels", tile_iter.next().getPixel(1, 1), p1.getPixel(1, 3));
	}
}

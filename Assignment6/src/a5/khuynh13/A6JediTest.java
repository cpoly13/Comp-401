package a5.khuynh13;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.GrayPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;
import a6jedi.SubPicture;

public class A6JediTest {

	static public String[] getTestNames() {
		String[] test_names = new String[1];
		test_names[0] = "zigZagTest";
		return test_names;
	}

	@Test
	public void zigZagTest() {
		Picture p1 = new PictureImpl(4, 3);
		Iterator<Pixel> iter1 = p1.zigzag();
		p1.setPixel(0, 0, new GrayPixel(0.96));
		p1.setPixel(1, 0, new GrayPixel(0.45));
		p1.setPixel(0, 1, new GrayPixel(0.67));
		p1.setPixel(0, 2, new GrayPixel(0.76));
		p1.setPixel(1, 1, new GrayPixel(0.22));
		p1.setPixel(2, 0, new GrayPixel(0.34));
		p1.setPixel(3, 0, new GrayPixel(0.84));
		p1.setPixel(2, 1, new GrayPixel(0.38));
		p1.setPixel(1, 2, new GrayPixel(0.79));
		p1.setPixel(2, 2, new GrayPixel(0.24));
		p1.setPixel(3, 1, new GrayPixel(0.12));
		p1.setPixel(3, 2, new GrayPixel(0.56));

		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(0, 0));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(1, 0));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(0, 1));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(0, 2));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(1, 1));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(2, 0));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(3, 0));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(2, 1));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(1, 2));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(2, 2));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(3, 1));
		assertEquals("The pixels don't match", iter1.next(), p1.getPixel(3, 2));

		SubPicture subP1 = p1.extract(1, 1, 3, 2);
		subP1.setPixel(0, 0, new ColorPixel(0.24, 0.56, 0.76));
		subP1.setPixel(1, 0, new ColorPixel(0.57, 0.34, 0.73));
		subP1.setPixel(0, 1, new ColorPixel(0.10, 0.65, 0.43));
		subP1.setPixel(1, 1, new ColorPixel(0.42, 0.33, 0.90));
		subP1.setPixel(2, 0, new ColorPixel(0.17, 0.55, 0.54));
		subP1.setPixel(2, 1, new GrayPixel(0.14));
		Iterator<Pixel> iter2 = subP1.zigzag();

		assertEquals("The pixels don't match", iter2.next(), subP1.getPixel(0, 0));
		assertEquals("The pixels don't match", iter2.next(), subP1.getPixel(1, 0));
		assertEquals("The pixels don't match", iter2.next(), subP1.getPixel(0, 1));
		assertEquals("The pixels don't match", iter2.next(), subP1.getPixel(1, 1));
		assertEquals("The pixels don't match", iter2.next(), subP1.getPixel(2, 0));
		assertEquals("The pixels don't match", iter2.next(), subP1.getPixel(2, 1));

		SubPicture subP2 = subP1.extract(2, 1, 1, 1);
		Iterator<Pixel> iter3 = subP2.zigzag();
		iter3.next();
		assertEquals("There are no more pixels", iter3.hasNext(), false);
		try {
			iter3.next();
		} catch (NoSuchElementException e) {
		}
	}
}

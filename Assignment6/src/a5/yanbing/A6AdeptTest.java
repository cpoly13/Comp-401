package a5.yanbing;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[3];

		test_names[0] = "testIterator";
		test_names[1] = "testIteratorSample";
		test_names[2] = "testIteratorWindow";

		return test_names;
	}

	@Test
	public void testIterator() {
		Picture p = new PictureImpl(2, 1);
		Iterator<Pixel> i = p.iterator();
		assertEquals("Does not match the value", i.hasNext(), true);
	}

	@Test
	public void testIteratorSample() {
		Picture p = new PictureImpl(3, 4);
		Iterator<Pixel> sample1 = p.sample(2, 3, 3, 4);
		assertEquals("Result from getY() does not match", p.getPixel(2, 3), sample1.next());
	}

	@Test
	public void testIteratorWindow() {
		Picture p = new PictureImpl(5, 5);
		Iterator<SubPicture> w = p.window(3, 2);
		Picture a = w.next();

		assertEquals("Result does not match", p.getPixel(0, 0), a.getPixel(0, 0));

	}
}

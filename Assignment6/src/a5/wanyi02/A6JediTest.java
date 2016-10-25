package a5.wanyi02;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "exampleTest";
		test_names[1] = "testZigzag";

		return test_names;
	}

	@Test
	public void exampleTest() {
	}

	@Test
	public void testZigzag() {
		Picture p = new PictureImpl(8, 8);
		Iterator<Pixel> iter = p.zigzag();
		assertEquals("iterator does not match", iter.next(), p.getPixel(0, 0));
		assertEquals("iterator does not match", iter.next(), p.getPixel(1, 0));
		assertEquals("iterator does not match", iter.next(), p.getPixel(0, 1));
		assertEquals("iterator does not match", iter.next(), p.getPixel(0, 2));
		assertEquals("iterator does not match", iter.next(), p.getPixel(1, 1));
	}
}

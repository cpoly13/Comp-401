package a5.yanbing;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {

	static public String[] getTestNames() {
		String[] test_names = new String[1];

		test_names[0] = "zigZagIteratorTest";

		return test_names;
	}

	@Test
	public void zigZagIteratorTest() {
		Picture source = new PictureImpl(10, 10);
		Iterator<Pixel> zig = source.zigzag();
		assertEquals("Zig Zag values invalid", source.getPixel(0, 0), zig.next());
	}
}

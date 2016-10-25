package a5.ktran19;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

	static public String[] getTestNames() {
		String[] test_names = new String[1];

		test_names[0] = "zigZagTest";

		return test_names;
	}

	@Test
	public void zigZagTest() {
		Picture p = new PictureImpl(8, 8);
		Iterator<Pixel> iter = p.iterator();
		Pixel nextPixel = iter.next();
		assertEquals(p.getPixel(1, 1), nextPixel);
	}
}

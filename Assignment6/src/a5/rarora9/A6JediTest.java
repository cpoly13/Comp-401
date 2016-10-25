package a5.rarora9;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
		
		return test_names;
	}
		
	@Test
	public void zigzagTest() {
		Picture picture = new PictureImpl(5, 5);
		Pixel pixel = new GrayPixel(0.3);
		picture.setPixel(0, 1, pixel);
		Iterator<Pixel> iterator = picture.zigzag();
		assertTrue(!iterator.next().equals(pixel));
		assertTrue(!iterator.next().equals(pixel));
		assertTrue(iterator.next().equals(pixel));
	}
}
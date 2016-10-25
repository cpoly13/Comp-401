package a5.rarora9;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "sampleTest";
		
		return test_names;
	}
		
	@Test
	public void sampleTest() {
		Picture picture = new PictureImpl(10, 15);
		Pixel pixel = new ColorPixel(0.2, 0.4, 0.5);
		picture.setPixel(7, 2, pixel);
		Iterator<Pixel> iterator= picture.sample(1, 2, 3, 5);
		assertTrue(!iterator.next().equals(pixel));
		assertTrue(!iterator.next().equals(pixel));
		assertTrue(iterator.next().equals(pixel));
	}
}
package a5.sbongu;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;


public class A6AdeptTest {
	
	// initialize Pixel variables for test
	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "sampleTest";
		
		return test_names;
	}

	@Test
	public void sampleTest() {
		Picture pic = new PictureImpl(10, 10);
		Iterator<Pixel> sampleIt = pic.sample(2, 3, 3, 4); // given sample
		
		pic.setPixel(2, 3, RED);
		assertTrue(sampleIt.next().equals(RED)); // test first coordinate
		
		pic.setPixel(5, 3, GREEN);
		assertTrue(sampleIt.next().equals(GREEN)); // test second coordinate
		
		pic.setPixel(8, 3, BLUE);
		assertTrue(sampleIt.next().equals(BLUE)); // test third coordinate
	}

}

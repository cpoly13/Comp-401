package a5.davidj96;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


import a6novice.*;

public class A6NoviceTest {

	static public String[] getTestNames() {
		String[] test_names = new String[3];

		test_names[0] = "testGetPixel";
		test_names[1] = "testExtract";
		test_names[2] = "testBounds";
		
		return test_names;
	}

	@Test
	public void testGetPixel() {
		Pixel red = new ColorPixel(1, 0, 0);
		Picture p = new PictureImpl(2, 2);
		Coordinate c = new Coordinate(1, 1);
		p.setPixel(c, red);
		assertEquals("Pixel at c is correct", red, p.getPixel(c));
	}

	@Test
	public void testExtract() {
		Picture p = new PictureImpl(7, 7);
		Coordinate c1 = new Coordinate(1, 1);
		Coordinate c2 = new Coordinate(5, 5);
		SubPicture subPic = p.extract(c1, c2);
		assertEquals(5, subPic.getWidth());

	}

	@Test
	public void testBounds() {
		Picture p = new PictureImpl(7, 7);
		Coordinate c1 = new Coordinate(1, 1);
		Coordinate c2 = new Coordinate(8, 5);
		
		try {
			SubPicture subPic = p.extract(c1, c2);
			fail("Expected IllegalArgumentException for mismatched heights of horizontal stack components");
		} catch (IllegalArgumentException e) {}
		
		

	}
}

package a5.tarek;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "testGetPixel";
		test_names[1] = "testExtract";
		
		return test_names;
	}

	/*
	 * This code tests the getPixel method from novice
	 * by creating a picture, changing some of the pixels,
	 * then retrieving that pixel.
	 */
	@Test
	public void testGetPixel() {
		Picture p = new PictureImpl(6,4);   
		Pixel pix = new GrayPixel(0.3);
		Coordinate c = new Coordinate(2,3);
		p.setPixel(c, pix);
		
		Pixel colorpixfringe = new ColorPixel(0.0, 1.0, 0.0);
		Picture p2 = new PictureImpl(10,7);
		Picture subp2 = new SubPictureImpl(p2, 1, 3, 2, 4);
		Coordinate c2 = new Coordinate(3,2);
		subp2.setPixel(c2, colorpixfringe);
		
		assertEquals("Coordinate from getPixel() does not match expected coordinatee",
					p.getPixel(c), pix); 
		assertEquals("Coordinate from getPixel() does not match expected coordinates",
					subp2.getPixel(c2), colorpixfringe);
					
	}
	
	/*
	 * Testing the extract method using 
	 * coordinate arguments rather than prior 
	 * arguments.
	 */
	@Test
	public void testExtract() {
		Picture p = new PictureImpl(17,7);
		Coordinate c1 = new Coordinate(0,0);
		Coordinate c2 = new Coordinate(3,3);
		Picture extracted = p.extract(c1, c2);
		
		Picture subp = new SubPictureImpl(p, 6, 3, 8, 3);
		Pixel colorpix = new ColorPixel(0.1, 0.6, 0.9);
		subp.setPixel(5, 0, colorpix);
		Coordinate c3 = new Coordinate(1,2);
		Coordinate c4 = new Coordinate(7,0);
		Picture subextracted = subp.extract(c3, c4);
		Pixel test = subextracted.getPixel(4,0);
		
		assertEquals("Coordinate from extract() does not match expected SubPicture",
				test, colorpix);
		
	}
}

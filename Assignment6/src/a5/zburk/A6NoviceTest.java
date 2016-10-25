package a5.zburk;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "exampleTest";
		test_names[1] = "getXCoordiante";
		test_names[2] = "getYCoordinate";
		test_names[3] = "setPixel";
		test_names[4] = "getPixel";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void getXCoordinate() {
		Coordinate c = new Coordinate(2,3);
		assertEquals(c.getX(), 2);
	}
	
	@Test
	public void getYCoordinate() {
		Coordinate c = new Coordinate(2,3);
		assertEquals(c.getY(), 3);
	}
	
	@Test
	public void setPixel() {
		Picture p = new PictureImpl(6,4);
		Coordinate c = new Coordinate(0,0);
		
		p.setPixel(c, new GrayPixel(0));
		
		p.setPixel(new Coordinate(5,3), new GrayPixel(0.25));
		
		assertTrue(comparePixels(new GrayPixel(0), p.getPixel(0,0)));
		assertTrue(comparePixels(new GrayPixel(0.25), p.getPixel(5,3)));
	}
	
	@Test
	public void getPixel() {
		Picture p = new PictureImpl(6,4);
		Coordinate c = new Coordinate(0,1);
		p.setPixel(c, new GrayPixel(0.2));
		
		assertTrue(comparePixels(new GrayPixel(0.2), p.getPixel(c)));
	}
	
	@Test
	public void hasNext() {
		Picture p = new PictureImpl(3,2);
		p.setPixel(0, 0, new GrayPixel(0.25));
		p.setPixel(2, 1, new GrayPixel(0.75));
		Iterator<Pixel> iter = p.iterator();
		
		assertTrue(comparePixels(new GrayPixel(0.25), iter.next()));
		
		// Skip over pixels to get to the 6th pixel in the image
		iter.next(); iter.next(); iter.next(); iter.next();
		assertTrue(comparePixels(new GrayPixel(0.75), iter.next()));

		try {
			iter.next();
			fail("Expected no element found");
		} catch (NoSuchElementException e) {
		} catch (RuntimeException e) {
			fail("Expected NoSuchElementException; but got generic RuntimeException");
		}
	}
	
	@Test
	public void extract() {
		Picture p = new PictureImpl(5,5);
		SubPicture subP = p.extract(new Coordinate(1,1), new Coordinate(3,3));

		assertEquals(subP.getWidth(), 3);
		assertEquals(subP.getHeight(), 3);
	}
	
	private static boolean comparePixels(Pixel a, Pixel b) {
		return ((Math.abs(a.getRed()-b.getRed()) < 0.001) &&
				(Math.abs(a.getGreen()-b.getGreen()) < 0.001) &&
				(Math.abs(a.getBlue()-b.getBlue()) < 0.001));
	}
}

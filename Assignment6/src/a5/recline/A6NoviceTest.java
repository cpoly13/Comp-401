package a5.recline;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	/*
	 * This method needs to return an array of strings that correspond to each JUnit test in the class
	 * The autograder will be relying on this method to test my tests
	 */
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "coordinateGetXGetYTest";
		test_names[1] = "anyPictureCoordinatesBadParameterTest";
		test_names[2] = "anyPictureSetAndGetPixelCoordinateTest";
		test_names[3] = "iteratorHasNextTest";
		test_names[4] = "iteratorNextBaseCaseTest";
		
		return test_names;
	}
	
	@Test
	public void coordinateGetXGetYTest() {
		Coordinate c = new Coordinate(0,3);		
		assertEquals(0,c.getX());
		assertEquals(3,c.getY());
	}
	
	@Test 
	public void anyPictureCoordinatesBadParameterTest() {
		Picture p = new PictureImpl(4,3);
		Pixel a = null;
		Pixel b = new ColorPixel(0,0,0);
		Coordinate c = new Coordinate(0,1);
		Coordinate d = null;
		
		try {
			p.setPixel(c, a);
			fail("Expected exception for setPixel if pixel is null.");
		} catch(Exception e) {	
		}
		
		try {
			p.setPixel(d, b);
			fail("Expected exception for setPixel if coordinate is null.");
		} catch(Exception e) {
		}
		
		try {
			p.extract(c, d);
			fail("Expected exception for extract if coordinate is null.");
		} catch(Exception e) {
		}
		
		try {
			p.extract(d, c);
			fail("Expected exception for extract if coordinate is null.");
		} catch(Exception e) {
		}
	}
	
	@Test
	public void anyPictureSetAndGetPixelCoordinateTest() {
		Picture p = new PictureImpl(4,3);
		Pixel a = new ColorPixel(0,0,0);
		Coordinate c = new Coordinate(0,1);
		p.setPixel(c, a);
		assertEquals(a, p.getPixel(c));
	}

	/*
	@Test
	public void anyPictureExtractCoordinateTest() {
		Picture p = new PictureImpl(3,3);
		Pixel BLACK = new ColorPixel(0,0,0);
		Pixel WHITE = new ColorPixel(1,1,1);
		p.setPixel(0,0,BLACK);
		p.setPixel(0,1,WHITE);
		p.setPixel(0,2,BLACK);
		p.setPixel(1,0,WHITE);
		p.setPixel(1,1,BLACK);
		p.setPixel(1,2,WHITE);
		p.setPixel(2,0,BLACK);
		p.setPixel(2,1,WHITE);
		p.setPixel(2,2,BLACK);
		Coordinate a = new Coordinate(1,1);
		Coordinate b = new Coordinate(2,2);

		assertEquals(p.extract(a,b),p.extract(1,1,2,2));
	}
	*/
	
	@Test
	public void iteratorHasNextTest() {
		Picture p = new PictureImpl(2,2);
		Iterator<Pixel> iter = p.iterator();
		assertTrue(iter.hasNext());
	}
	
	@Test
	public void iteratorNextBaseCaseTest() {
		Picture p = new PictureImpl(2,2);
		Pixel RED = new ColorPixel(1,0,0);
		p.setPixel(0,0,RED);
		Iterator<Pixel> iter = p.iterator();
		assertEquals(RED,iter.next());
	}
	
	/*
	@Test
	public void iteratorNextTest() {
		Picture p = new PictureImpl(2,2);
		Pixel RED = new ColorPixel(1,0,0);
		Pixel BLUE = new ColorPixel(0,0,1);
		p.setPixel(0,0,RED);
		p.setPixel(0,1,BLUE);
		p.setPixel(1,0,RED);
		p.setPixel(1,1,BLUE);
		assertEquals(????,Iterator.next());
	}
	*/
}

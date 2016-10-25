package a5.scottieg;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
//import a64novice.GrayPixel;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;
import a6novice.*;

public class A6NoviceTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "testCoordinateConstructor()";
		test_names[1] = "testCoordinateConstructorExceptions()";
		test_names[2] = "testPictureImplPixelGettersAndSetters()";
		test_names[3] = "testIterator()";
		
		return test_names;
	}
		
	@Test
	public void testCoordinateConstructor() {
		Coordinate c = new Coordinate(1,2);
		assertEquals("Result from getX() does not match value given in constructor",
				1, c.getX());
		assertEquals("Result from getY() does not match value given in constructor",
				2, c.getY());
	}
	
	/*@Test
	public void testCoordinateConstructorExceptions(){
		try {
			Coordinate c = new Coordinate(-1, 0);
			fail("Expected IllegalArgumentException x < 0");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		try {
			Coordinate c = new Coordinate(0, -1);
			fail("Expected IllegalArgumentException y < 0");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
	}*/
	
	@Test
	public void testPictureImplPixelGettersAndSetters(){
		Picture p = new PictureImpl(2,2);
		Coordinate c1 = new Coordinate(0,0);
		Coordinate c2 = new Coordinate(1,0);
		Coordinate c3 = new Coordinate(0,1);
		Coordinate c4 = new Coordinate(1,1);
		
		p.setPixel(c1 ,RED);
		p.setPixel(c2, GREEN);
		p.setPixel(c3, BLUE);
		p.setPixel(c4, WHITE);
		
		assertEquals("Pixel retrieved does not equal what it was set to",
				p.getPixel(c1), RED);
		assertEquals("Pixel retrieved does not equal what it was set to",
				p.getPixel(c2), GREEN);
		assertEquals("Pixel retrieved does not equal what it was set to",
				p.getPixel(c3), BLUE);
		assertEquals("Pixel retrieved does not equal what it was set to",
				p.getPixel(c4), WHITE);
	}
	
	@Test
	public void testIterator(){
		Picture p = new PictureImpl(2,2);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, GREEN);
		p.setPixel(0, 1, BLUE);
		p.setPixel(1, 1, WHITE);
		Iterator<Pixel> iter = p.iterator();
		
		assertEquals("Iterator hasNext broken",
				iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				iter.next(),p.getPixel(0, 0));
		assertEquals("Iterator returned wrong pixel",
				iter.next(),p.getPixel(1, 0));
		assertEquals("Iterator returned wrong pixel",
				iter.next(),p.getPixel(0, 1));
		assertEquals("Iterator returned wrong pixel",
				iter.next(),p.getPixel(1, 1));
		assertEquals("hasNext doesn't return false when it is done traversing",
				iter.hasNext(),false);
	}
	
}

package a5.lukefd;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "exampleTest";
		test_names[1] = "coordinateConstructorTest";
		test_names[2] = "iteratorTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void coordinateConstructorTest() {
		Coordinate c = new Coordinate(5, 10);
		Coordinate d = new Coordinate(-10, -20);
		
		assertEquals("Result from getX() does not match coordinate object.", 5, c.getX());
		assertEquals("Result from getY() does not match coordinate object.", 10, c.getY());
		assertEquals("Result from getX() does not match coordinate object.", -10, d.getX());
		assertEquals("Result from getY() does not match coordinate object.", -20, d.getY());
	}	
	
	@Test
	public void iteratorTest() {
		Picture p = new PictureImpl(2,2);
		p.setPixel(0, 0, RED);
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 0, BLUE);
		p.setPixel(1, 1, WHITE);
		
		Iterator<Pixel> i = p.iterator(); 
		
		assertEquals("Result from next() in iterator does not match expected pixel.", RED, i.next());
		assertEquals("Result from hasNext() in iterator does not match expected value.", true, i.hasNext());
	}
}

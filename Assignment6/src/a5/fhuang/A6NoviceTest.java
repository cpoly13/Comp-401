package a5.fhuang;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "testCoordinateConstructor";
		test_names[1] = "testSetPixel";
		test_names[2] = "testExtract";
		test_names[3] = "testIteratorException";
		test_names[4] = "testIterator";
		
		return test_names;
	}
	
		
	@Test
	public void testCoordinateConstructor() {
		Coordinate a = new Coordinate (6,4);
		
		assertEquals("Result from getX() does not match coordinate",
				6, a.getX());
		assertEquals("Result from getY() does not match coordinate",
				4, a.getY());
	}
	
	@Test
	public void testSetPixel() {
		Picture p = new PictureImpl(6,4);
		Pixel p1 = new ColorPixel(.1,.1,.1);
		Coordinate a = new Coordinate (0,1);
		
		p.setPixel(a, p1);
		
		assertEquals("Result from setPixel does not match coordinate",
				p1, p.getPixel(a));
			
		
	}
	
	@Test
	public void testExtract() {
		Picture p = new PictureImpl(6,4);
		Coordinate a = new Coordinate(0,0);
		Coordinate b = new Coordinate(2,2);
		
		Pixel p1 = new ColorPixel(.1,.1,.1);
		
		Coordinate c = new Coordinate(1,1);
		p.setPixel(b, p1);
		p.setPixel(a, p1);
		
		SubPicture result1 = p.extract(a, b);
		SubPicture result2 = p.extract(c, b);
		
		assertEquals("Result from extract does not match subpicture",
				p.getPixel(b), result1.getPixel(b));
		assertEquals("Result from extract does not match subpicture",
				p.getPixel(c), result2.getPixel(a));
		
	}
	
	@Test
	public void testIteratorException() {
		Picture empty = new PictureImpl(1,1);
		
		Iterator<Pixel> iter = empty.iterator();
		
		try {
			iter.next();
			iter.next();
			iter.hasNext();
			fail("Expected NoSuchElementException for x offset >= source width");
		} catch (NoSuchElementException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		//test for hasNext exception
	}
	
	@Test
	public void testIterator() {
		Picture p = new PictureImpl(6,4);
		Pixel p1= new ColorPixel(.5, .2, .1);
		p.setPixel(2, 0, p1);
		
		Iterator<Pixel> iter = p.iterator();
		iter.next();
		iter.next();
		
		assertEquals("Result from iterator does not match picture",
				p1, iter.next());
		
		
		
	}
}

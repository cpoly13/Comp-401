package a5.melissa5;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;
public class A6NoviceTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "testSubPictureImplGettersandSetters";
		test_names[1] = "testIteratorMethods";
		
		
		return test_names;
	}
		
	@Test
	public void testSubPictureImplGettersandSetters() {
		Picture p = new PictureImpl (6,6);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(2, 0, RED);
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 1, BLUE);
		p.setPixel(2, 1, WHITE);
		p.setPixel(0, 2, BLACK);
		p.setPixel(1, 2, BLACK);
		p.setPixel(2, 2, RED);
		
		Pixel test = p.getPixel(new Coordinate(0,0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",test, RED);
		
		SubPicture sp = p.extract(new Coordinate(2,2), new Coordinate(4,4));
	}
	
	/* Goal: tests to see if hasNext method returns False when there is no next pixel
	 * 
	 */
	
	@Test
	public void testIteratorMethods() {
		Picture p = new PictureImpl(2,2);
		p.setPixel(0, 0, RED);
		p.setPixel(0, 1, BLUE);
		p.setPixel(1, 0, GREEN);
		p.setPixel(1, 1, BLACK);
		
		Iterator<Pixel> it = p.iterator();
		Pixel q;
		assertTrue(it.hasNext());
		q = it.next();
		assertTrue(it.hasNext());
		q = it.next();
		assertTrue(it.hasNext());
		q = it.next();
		assertTrue(it.hasNext());
		q = it.next();
		assertFalse("There is no next pixel",it.hasNext());
		
		
	}
	
	
}

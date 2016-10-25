package a5.rbowser;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;



public class A6NoviceTest {
	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
	private static final Pixel BLACK = new GrayPixel(0);
	private static final Pixel WHITE = new GrayPixel(1);
		
	static public String[] getTestNames() {
		String[] test_names = new String[7];
		
	
		test_names[0] = "testCoordinateConstructor";
		test_names[1] = "testExtract";
		test_names[2] = "testGetPixelandSetPixel";
		test_names[3] = "exceptionTest";
		test_names[4] = "hasNextTest";
		test_names[5] = "nextTest";
		test_names[6] = "nullTest";
		
		
		
		return test_names;
	}
		
	
	
	@Test 
	public void testCoordinateConstructor()
	{
		Coordinate expected = new Coordinate(4, 4);

		assertEquals("Result from getX() does not match source picture",
				4, expected.getX());
		assertEquals("Result from getY() does not match source picture",
				4, expected.getY());
	}
	@Test
	public void testGetPixelandSetPixel()
	{
		Picture p = new PictureImpl(3, 3);
		
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, GREEN);
		p.setPixel(2, 0, BLUE);
		p.setPixel(0, 1, BLACK);
		p.setPixel(1, 1, WHITE);
		p.setPixel(2, 1, RED);
		p.setPixel(0, 2, GREEN);
		p.setPixel(1, 2, BLUE);
		p.setPixel(2, 2, BLACK);
		
		Coordinate corner_a = new Coordinate(1, 1);
		Coordinate corner_b = new Coordinate(2 , 2);
		SubPicture sub = p.extract(corner_a, corner_b);
		Coordinate test = new Coordinate(0,0);
		
		assertEquals("Expected pixel does not match the pixel from the subpicture",
				p.getPixel(1, 1), sub.getPixel(test));
		assertEquals("Expected pixel does not match the pixel from the subpicture",
				p.getPixel(2, 2), sub.getPixel(new Coordinate(1,1)));
		assertEquals("Expected pixel does not match the pixel from the subpicture",
				p.getPixel(1, 2), sub.getPixel(new Coordinate(0,1)));
		assertEquals("Expected pixel does not match the pixel from the subpicture",
				p.getPixel(2, 1), sub.getPixel(new Coordinate(1,0)));
		
		p.setPixel(new Coordinate(1, 0), RED);
		assertEquals("Expected pixel does not match the pixel from the subpicture", 
				RED ,p.getPixel(1, 0));
		
		
	}
	@Test
	public void testExtract()
	{
		Picture p = new PictureImpl(3, 3);
	
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, GREEN);
		p.setPixel(2, 0, BLUE);
		p.setPixel(0, 1, BLACK);
		p.setPixel(1, 1, WHITE);
		p.setPixel(2, 1, RED);
		p.setPixel(0, 2, GREEN);
		p.setPixel(1, 2, BLUE);
		p.setPixel(2, 2, BLACK);
		Coordinate corner_a = new Coordinate(1, 1);
		Coordinate corner_b = new Coordinate(2 , 2);
		SubPicture sub = p.extract(corner_a, corner_b);
		assertEquals("Expected pixel does not match the pixel from the subpicture",
				p.getPixel(2, 2), sub.getPixel(1, 1));
		assertEquals("Expected pixel does not match the pixel from the subpicture",
				p.getPixel(1,1), sub.getPixel(0, 0));
		assertEquals("Expected pixel does not match the pixel from the subpicture",
				p.getPixel(1, 2), sub.getPixel(0, 1));
		assertEquals("Expected pixel does not match the pixel from the subpicture",
				p.getPixel(2, 1), sub.getPixel(1, 0));
	}
	
	@Test
	public void exceptionTest()
	{
		Picture p = new PictureImpl(3,3);
		Coordinate corner_a = new Coordinate(1, 1);
		Coordinate corner_b = new Coordinate(4, 4);
		try {
			SubPicture sub = p.extract(corner_a, corner_b);
			fail("Expected IllegalArgumentException for x offset >= source width");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		Coordinate test = new Coordinate(-1, -1);
		Coordinate test2 = new Coordinate(-1, -1);
		try {
			SubPicture sub2 = p.extract(test, test2);
			fail("Expected illegal argument excpetion");
		} catch (IllegalArgumentException e) {
		}
		
	}
	@Test 
	public void hasNextTest()
	{
		
		Picture p = new PictureImpl(3,3);
		p.setPixel(0, 0, RED);
		Iterator i = p.iterator();
		p.setPixel(0, 1, GREEN);
		assertTrue(i.hasNext());
	
	}
	@Test
	public void nextTest()
	{
		Picture p = new PictureImpl(3,3);
		p.setPixel(0, 0, RED);
		Iterator i = p.iterator();
		
		assertTrue(i.hasNext());
		assertEquals(p.getPixel(0, 0), i.next());
	
	}
	@Test
	public void nullTest()
	{
		Picture p = new PictureImpl(1,1);
		p.setPixel(0, 0, RED);
		Iterator i = p.iterator();
		i.next();
		try{
			i.next();
			
		}
		catch (java.util.NoSuchElementException e) {
		}
	}

	
	

	
}

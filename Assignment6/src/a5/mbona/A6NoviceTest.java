package a5.mbona;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	//Create 5 pixels to be used for testing. 
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	
	
	//KMP test 
	
	static public String[] getTestNames() {
		String[] test_names = new String[6];
		
		test_names[0] = "exampleTest";
		test_names[1] = "getPixelTest";
		test_names[2] = "hasNextTest";
		test_names[3] = "nextTest"; 
		test_names[4] = "badParameterTest";
		test_names[5] = "extractTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	//My tests begin here. 
	
	
	/* getPixelTest() should retrieve the pixel established in the 
	 * PictureImpl that I created. 
	 */ 
	
	@Test
	public void getPixelTest() {
		Picture p = new PictureImpl(2, 2);
		Pixel expected = new ColorPixel(0, 0, 1);
		Coordinate c = new Coordinate(0,1); 
		p.setPixel(c, expected);
		assertEquals(expected, p.getPixel(c));	 
	 }
	
	
	/* Tests if there is another pixel in the iterator. 
	 * Goes through Picture's pixels and outputs t/f 
	 * if another follows.  
	 */
	 
	@Test
	public void hasNextTest() {
		int x = 0; 
		int y = 0; 
		
		Picture p = new PictureImpl(2,2); 
		p.setPixel(0, 0, RED);
		p.setPixel(0, 1, BLUE);
		p.setPixel(1, 0, GREEN);
		p.setPixel(1, 1, RED);
		
		Iterator iterator = p.iterator(); 
		
		assertTrue(iterator.hasNext());
		
	}
	
	/* Uses iterator to find what the next pixel in 
	 * the picture is. Returns t/f if there is a next,
	 * equates what is next. 
	 */
	
	@Test 
	public void nextTest() {
		Picture p = new PictureImpl(2,2); 
		p.setPixel(0, 0, RED);
		p.setPixel(0, 1, BLUE);
		p.setPixel(1, 0, GREEN);
		p.setPixel(1, 1, RED);
		
		Iterator iterator = p.iterator(); 
		assertTrue(iterator.hasNext());
		assertEquals(RED, iterator.next());
			
	}
	
	/* Checks Coordinate parameters for out of bounds 
	 * coordinates. 
	 */
	
	@Test
	public void badParameterTest() {
		Picture p = new PictureImpl(2,2); 
		Pixel a = null; 
		Coordinate c = new Coordinate(0,0); 
		
		try {
			p.setPixel(c,  a);
			fail("Expected exception for setPixel if pixel is null.");
		}
		catch(Exception e) {
		}

		Coordinate badC = new Coordinate(4, 8); 
		try {
			p.setPixel(badC, a);
			fail("Expected exception for setPixel if coordinate is out of bounds.");
		}
		catch(Exception e) {
		}
		
		Coordinate worseC = new Coordinate(-1, -3); 
		try {
			p.setPixel(worseC, a);
			fail("Expected exception for setPixel if coordinate is out of bounds.");
		}
		catch(Exception e) {
		}
	}


	@Test 
	public void extractTest() {
		Picture p = new PictureImpl(2,2); 
		p.setPixel(0, 0, RED);
		p.setPixel(0, 1, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(1, 1, RED);
		
		Coordinate a = new Coordinate(0,0);
		Coordinate b = new Coordinate(1,1);
		SubPicture sp = p.extract(a, b);
		
		assertEquals(2, sp.getWidth());
	}
}

	
// Collaborated with Reagan Cline 


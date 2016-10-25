package a5.nmchenry;

import static org.junit.Assert.assertEquals;


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
		
		test_names[0] = "setpixelTest";
		test_names[1] = "iteratorTest";
		
		return test_names;
	}
		
	
	@Test
	public void setpixelTest() {
		Picture p1 = new PictureImpl(10, 10);
		
		for (int i = 0; i < p1.getWidth(); i++) {
			for (int j = 0; j < p1.getHeight(); j++) {
				p1.setPixel(i, j, GREEN);	}
			}
		
		Coordinate c = new Coordinate(5, 5);
		Pixel p = BLUE;
		
		p1.setPixel(c, p);
		
		assertEquals("Pixel set incorrectly", BLUE, p1.getPixel(c));
		
		
			
	}
	
	@Test
	public void iteratorTest()  {
		Picture p1 = new PictureImpl(5,5);
		
		p1.setPixel(0, 0, BLUE);
		p1.setPixel(1, 0, RED);
		p1.setPixel(2, 0, GREEN);
			
		Iterator<Pixel> Itr = p1.iterator();
		
			assertEquals("Novice Iterator next function not working", BLUE, Itr.next());
			assertEquals("Novice Iterator next function not working", RED, Itr.next());
			assertEquals("Novice Iterator next function not working", GREEN, Itr.next());
			assertEquals("Novice Iterator hasNext function not working", true, Itr.hasNext());
	
			
		}
	
	}

	
	 


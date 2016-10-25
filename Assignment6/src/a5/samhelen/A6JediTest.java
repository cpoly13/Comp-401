package a5.samhelen;

import static org.junit.Assert.*;



import java.util.Iterator;

import org.junit.Test;


import a6jedi.*;

public class A6JediTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
		
		return test_names;
	}
		
	@Test
	public void zigzagTest() {
		Picture p = new PictureImpl(4, 3);
		p.setPixel(0,  0, RED);
		p.setPixel(1,  0, GREEN);
		p.setPixel(0,  1, RED);
		p.setPixel(0,  2, WHITE);
		p.setPixel(1,  1, BLACK);
		p.setPixel(2,  0, BLUE);
		p.setPixel(3,  0, GREEN);
		p.setPixel(1,  2, RED);
		p.setPixel(2,  2, WHITE);
		p.setPixel(3,  1, BLUE);
		p.setPixel(3,  2, BLUE);
		
		Iterator <Pixel> zigzag_iterator = p.zigzag();
		

			assertEquals("Pixel is different", p.getPixel(0, 0), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(1, 0), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(0, 1), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(0, 2), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(1, 1), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(2, 0), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(3, 0), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(2, 1), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(1, 2), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(2, 2), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(3, 1), zigzag_iterator.next());
			
			assertEquals("Pixel is different", p.getPixel(3, 2), zigzag_iterator.next());
			
			
	}
}

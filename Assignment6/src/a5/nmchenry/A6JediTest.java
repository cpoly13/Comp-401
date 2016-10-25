package a5.nmchenry;

import static org.junit.Assert.assertEquals;

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
		
		Picture p1 = new PictureImpl(3, 3);
		
		p1.setPixel(0, 0, RED);
		p1.setPixel(1, 0, WHITE);
		p1.setPixel(0, 1, BLUE);
		p1.setPixel(0, 2, RED);
		p1.setPixel(1, 1, WHITE);
		p1.setPixel(2, 0, BLUE);
		p1.setPixel(2, 1, RED);
		p1.setPixel(1, 2, WHITE);
		p1.setPixel(2, 2, BLUE);
		
		
		
			
		Iterator<Pixel> Itr = p1.zigzag();
		
		assertEquals("ZigZag Malfunction", p1.getPixel(0,0), Itr.next());
		assertEquals("ZigZag Malfunction", p1.getPixel(1,0), Itr.next());
		assertEquals("ZigZag Malfunction", p1.getPixel(0,1), Itr.next());
		assertEquals("ZigZag Malfunction", p1.getPixel(0,2), Itr.next());
		assertEquals("ZigZag Malfunction", p1.getPixel(1,1), Itr.next());
		assertEquals("ZigZag Malfunction", p1.getPixel(2,0), Itr.next());
		assertEquals("ZigZag Malfunction", p1.getPixel(2,1), Itr.next());
		assertEquals("ZigZag Malfunction", p1.getPixel(1,2), Itr.next());
		assertEquals("ZigZag Malfunction", p1.getPixel(2,2), Itr.next());
		
			
			
			
		}
	}


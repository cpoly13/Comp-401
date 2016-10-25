package a5.aneri;

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
		
		Picture p1 = new PictureImpl(2,2);
		
		p1.setPixel(0, 0, WHITE);
		p1.setPixel(1, 0, GREEN);
		p1.setPixel(0, 1, BLUE);
		p1.setPixel(1, 1, RED);
		
		Iterator<Pixel> zigIt = p1.zigzag();
		
		assertEquals("Sample is returning incorrect pixels", zigIt.next(), WHITE);
		assertEquals("Sample is returning incorrect pixels", zigIt.next(), GREEN);
		assertEquals("Sample is returning incorrect pixels", zigIt.next(), BLUE);
		assertEquals("Sample is returning incorrect pixels", zigIt.next(), RED);
	}
}

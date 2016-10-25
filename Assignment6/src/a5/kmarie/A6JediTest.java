package a5.kmarie;

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
		Picture p = new PictureImpl(3,3);
		p.setPixel(0, 0, BLACK);
		p.setPixel(1, 0, RED);
		p.setPixel(0, 1, RED);
		p.setPixel(0, 2, GREEN);
		p.setPixel(1, 1, WHITE);
		p.setPixel(2, 0, BLUE);
		p.setPixel(2, 1, GREEN);
		p.setPixel(1, 2, BLUE);
		p.setPixel(2, 2, BLACK);
		
		Iterator<Pixel> zigzag = p.zigzag();
		assertEquals(zigzag.next(),BLACK);
		assertEquals(zigzag.next(),RED);
		assertEquals(zigzag.next(),RED);
		assertEquals(zigzag.next(),GREEN);
		assertEquals(zigzag.next(),WHITE);
		assertEquals(zigzag.next(),BLUE);
		assertEquals(zigzag.next(),GREEN);
		assertEquals(zigzag.next(),BLUE);
		assertEquals(zigzag.next(),BLACK);
		
	}
}

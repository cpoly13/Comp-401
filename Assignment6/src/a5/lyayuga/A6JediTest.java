package a5.lyayuga;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


import a6jedi.*;

public class A6JediTest {
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "exampleTest";
		test_names[1]="zigzagTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	@Test
	public void zigzagTest() {
		Picture p = new PictureImpl(8,8);
		
		Iterator<Pixel> zigzag_iter = p.zigzag();
		
		p.setPixel(0, 0, RED);
		assertTrue(zigzag_iter.next().equals(p.getPixel(0,0)));
		p.setPixel(1, 0, GREEN);
		assertTrue(zigzag_iter.next().equals(p.getPixel(1,0)));
		p.setPixel(0, 1, BLUE);
		assertTrue(zigzag_iter.next().equals(p.getPixel(0,1)));
		zigzag_iter.next();
		zigzag_iter.next();
		zigzag_iter.next();
		p.setPixel(3, 0, WHITE);
		assertTrue(zigzag_iter.next().equals(p.getPixel(3,0)));
		
	}
	
}

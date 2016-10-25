package a5.ifeyinwa;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "testZigZagRectangle";
		test_names[1] = "testZigZagSquare";
		
		return test_names;
	}
		
	@Test
	public void testZigZagRectangle() {
		
		Picture p = new PictureImpl(3,4);
		Iterator<Pixel> zigzag_iter = p.zigzag();
		
		Pixel a = new GrayPixel(0);
		Pixel b = new GrayPixel(0.5);
		Pixel c = new GrayPixel(1);
		
		p.setPixel(0, 0, a);
		p.setPixel(1, 0, c);
		p.setPixel(2, 0, b);
		p.setPixel(0, 1, c);
		p.setPixel(1, 1, b);
		p.setPixel(2, 1, a);
		p.setPixel(0, 2, b);
		p.setPixel(1, 2, a);
		p.setPixel(2, 2, c);
		p.setPixel(0, 3, c);
		p.setPixel(1, 3, a);
		p.setPixel(2, 3, b);
	

		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), a);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), c);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), c);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), b);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), b);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), b);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), a);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), a);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), c);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), a);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), c);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), b);
	
	
	}
	
	@Test
	public void testZigZagSquare() {
		
		Picture p = new PictureImpl(3,3);
		Iterator<Pixel> zigzag_iter = p.zigzag();
		
		Pixel a = new GrayPixel(0);
		Pixel b = new GrayPixel(0.5);
		Pixel c = new GrayPixel(1);
		
		p.setPixel(0, 0, a);
		p.setPixel(1, 0, b);
		p.setPixel(2, 0, c);
		p.setPixel(0, 1, b);
		p.setPixel(1, 1, c);
		p.setPixel(2, 1, b);
		p.setPixel(0, 2, c);
		p.setPixel(1, 2, b);
		p.setPixel(2, 2, a);
		
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), a);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), b);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), b);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), c);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), c);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), c);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), b);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), b);
		assertEquals("Pixel retrieved does not match expectation.", zigzag_iter.next(), a);
	}
}

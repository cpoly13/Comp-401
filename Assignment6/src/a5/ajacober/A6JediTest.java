package a5.ajacober;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

	static public String[] getTestNames() {
		return new String[] {"testZigZag"};
	}

	@Test
	public void testZigZag() {
		Picture pic = new PictureImpl(10,10);
		Pixel p = new GrayPixel(0.5);
		Pixel p1 = new GrayPixel(0.5);
		Pixel p2 = new GrayPixel(0.5);
		Pixel p3 = new GrayPixel(0.5);
		Pixel p4 = new GrayPixel(0.5);
		Pixel p5 = new GrayPixel(0.5);
		pic.setPixel(0, 0, p);
		pic.setPixel(1, 0, p1);
		pic.setPixel(0, 1, p2);
		pic.setPixel(0, 2, p3);
		pic.setPixel(1, 1, p4);
		pic.setPixel(2, 0, p5);
		Iterator<Pixel> iter = pic.zigzag();
		assertEquals("ZigZag returns incorrect first Pixel",
				p, iter.next());
		assertEquals(p1,iter.next());
		assertEquals(p2,iter.next());
		assertEquals(p3,iter.next());
		assertEquals(p4,iter.next());
		assertEquals(p5,iter.next());
	}
}

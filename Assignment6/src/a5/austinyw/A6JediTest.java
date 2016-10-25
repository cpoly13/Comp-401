package a5.austinyw;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
	
	private double precision = 0.00001;
	
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
				
		return test_names;
	}
		
	@Test
	public void zigzagTest() {
		Picture p1 = new PictureImpl(4,4);
		
		p1.setPixel(0, 0, new GrayPixel(0.01));
		p1.setPixel(1, 0, new GrayPixel(0.02));
		p1.setPixel(0, 1, new GrayPixel(0.03));
		p1.setPixel(0, 2, new GrayPixel(0.04));
		p1.setPixel(1, 1, new GrayPixel(0.05));
		p1.setPixel(2, 0, new GrayPixel(0.06));
		p1.setPixel(3, 0, new GrayPixel(0.07));
		p1.setPixel(2, 1, new GrayPixel(0.08));
		p1.setPixel(1, 2, new GrayPixel(0.09));
		p1.setPixel(0, 3, new GrayPixel(0.10));
		p1.setPixel(1, 3, new GrayPixel(0.11));
		p1.setPixel(2, 2, new GrayPixel(0.12));
		p1.setPixel(3, 1, new GrayPixel(0.13));
		p1.setPixel(3, 2, new GrayPixel(0.14));
		p1.setPixel(2, 3, new GrayPixel(0.15));
		p1.setPixel(3, 3, new GrayPixel(0.16));
		
		SubPicture p2 = p1.extract(0, 0, 3, 4);
		SubPicture p3 = p1.extract(0, 0, 1, 4);
		
		Iterator<Pixel> iter1 = p1.zigzag();
		Iterator<Pixel> iter2 = p2.zigzag();
		Iterator<Pixel> iter3 = p3.zigzag();
		
		double expected1 = 0.01;
		double expected2 = 0.02;
		double expected3 = 0.03;
		double expected4 = 0.04;
		double expected5 = 0.05;
		double expected6 = 0.06;
		double expected7 = 0.07;
		double expected8 = 0.08;
		double expected9 = 0.09;
		double expected10 = 0.10;
		double expected11 = 0.11;
		double expected12 = 0.12;
		double expected13 = 0.13;
		double expected14 = 0.14;
		double expected15 = 0.15;
		double expected16 = 0.16;
		
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected1, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected2, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected3, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected4, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected5, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected6, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected7, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected8, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected9, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected10, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected11, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected12, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected13, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected14, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected15, iter1.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected16, iter1.next().getIntensity(), precision);
		try {
			iter1.next();
			fail("Called next and the iterator did not throw an exception");
		}
		catch(NoSuchElementException e) {
		}
		
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected1, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected2, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected3, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected4, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected5, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected6, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected8, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected9, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected10, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected11, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected12, iter2.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected15, iter2.next().getIntensity(), precision);
		try {
			iter2.next();
			fail("Called next and the iterator did not throw an exception");
		}
		catch(NoSuchElementException e) {
		}
		
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected1, iter3.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected3, iter3.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected4, iter3.next().getIntensity(), precision);
		assertEquals("Pixel does not match expected in zigzag iterator", 
				expected10, iter3.next().getIntensity(), precision);
		try {
			iter2.next();
			fail("Called next and the iterator did not throw an exception");
		}
		catch(NoSuchElementException e) {
		}
	}
}

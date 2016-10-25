package a5.kbaek11;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		return new String[] {"testSample"};
		
	}
		
	@Test
	public void testSample() {
		
		Picture p1 = new PictureImpl(15,10);
		p1.setPixel(2,3,GREEN);
		p1.setPixel(5,3,RED);
		p1.setPixel(8,3,RED);
		p1.setPixel(11,3,GREEN);
		p1.setPixel(14,3,GREEN);
		p1.setPixel(2,7,GREEN);
		p1.setPixel(5,7,BLUE);
		p1.setPixel(8,7,BLUE);
		p1.setPixel(11,7,BLUE);
		p1.setPixel(14,7,BLUE);
		
		Iterator<Pixel> iterTest = p1.sample(2, 3, 3, 4);

		assertEquals(iterTest.next(),GREEN);
		assertEquals(iterTest.next(),RED);
		assertEquals(iterTest.next(),RED);
		assertEquals(iterTest.next(),GREEN);
		assertEquals(iterTest.next(),GREEN);
		assertEquals(iterTest.next(),GREEN);
		assertEquals(iterTest.next(),BLUE);
		assertEquals(iterTest.next(),BLUE);
		assertEquals(iterTest.next(),BLUE);
		assertEquals(iterTest.next(),BLUE);
		
	}
	
}

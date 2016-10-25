package a5.mianx;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
	
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
		
		return test_names;
	}

	@Test
	public void zigzagTest() {
		Picture testPic = new PictureImpl(6,6);
		
		for(int x = 0;x<testPic.getWidth();x++) {
			for (int y = 0;y<testPic.getHeight();y++){
				if(y%2 ==0) {
					testPic.setPixel(x, y, BLACK);
				} else testPic.setPixel(x, y, WHITE);
			}
		}
		
		Iterator<Pixel> zigzag = testPic.zigzag();
		assertEquals("", zigzag.next(), testPic.getPixel(0,0));
		assertEquals("", zigzag.next(), testPic.getPixel(1,0));
		assertEquals("", zigzag.next(), testPic.getPixel(0,1));
		assertEquals("", zigzag.next(), testPic.getPixel(0,2));
		assertEquals("", zigzag.next(), testPic.getPixel(1,1));
		assertEquals("", zigzag.next(), testPic.getPixel(2,0));
		assertEquals("", zigzag.next(), testPic.getPixel(3,0));
		assertEquals("", zigzag.next(), testPic.getPixel(2,1));
		assertEquals("", zigzag.next(), testPic.getPixel(1,2));
		assertEquals("", zigzag.next(), testPic.getPixel(0,3));
		assertEquals("", zigzag.next(), testPic.getPixel(0,4));
		assertEquals("", zigzag.next(), testPic.getPixel(1,3));
		assertEquals("", zigzag.next(), testPic.getPixel(2,2));
		assertEquals("", zigzag.next(), testPic.getPixel(3,1));
		assertEquals("", zigzag.next(), testPic.getPixel(4,0));
		assertEquals("", zigzag.next(), testPic.getPixel(5,0));
		assertEquals("", zigzag.next(), testPic.getPixel(4,1));
		assertEquals("", zigzag.next(), testPic.getPixel(3,2));
		assertEquals("", zigzag.next(), testPic.getPixel(2,3));
		assertEquals("", zigzag.next(), testPic.getPixel(1,4));
		assertEquals("", zigzag.next(), testPic.getPixel(0,5));
		assertEquals("", zigzag.next(), testPic.getPixel(1,5));
		assertEquals("", zigzag.next(), testPic.getPixel(2,4));
		assertEquals("", zigzag.next(), testPic.getPixel(3,3));
		assertEquals("", zigzag.next(), testPic.getPixel(4,2));
		assertEquals("", zigzag.next(), testPic.getPixel(5,1));
		assertEquals("", zigzag.next(), testPic.getPixel(5,2));
		assertEquals("", zigzag.next(), testPic.getPixel(4,3));
		assertEquals("", zigzag.next(), testPic.getPixel(3,4));
		assertEquals("", zigzag.next(), testPic.getPixel(2,5));
		assertEquals("", zigzag.next(), testPic.getPixel(3,5));
		assertEquals("", zigzag.next(), testPic.getPixel(4,4));
		assertEquals("", zigzag.next(), testPic.getPixel(5,3));
		assertEquals("", zigzag.next(), testPic.getPixel(5,4));
		assertEquals("", zigzag.next(), testPic.getPixel(4,5));
		assertEquals("", zigzag.next(), testPic.getPixel(5,5));		
	}
}

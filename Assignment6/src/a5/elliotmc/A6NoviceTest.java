package a5.elliotmc;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


import a6novice.*;

public class A6NoviceTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "coordinateTest";
		test_names[1] = "setPixelTest";
		test_names[2] = "getPixelTest";
		test_names[3] = "extractTest";
		
		return test_names;
	}
		
	@Test
	public void coordinateTest(){
		Picture p = new PictureImpl(10, 10);
		for(int i = 0; i < p.getHeight(); i++){
			for(int k = 0; k < p.getWidth(); k++){
			assertEquals(p.getPixel(k,i), p.getPixel(new Coordinate(k,i)));
			}
		}
	}
	
	@Test
	public void setPixelTest(){
		Picture p = new PictureImpl(3, 3);
		
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(2, 0, RED);
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 1, BLUE);
		p.setPixel(2, 1, WHITE);
		p.setPixel(0, 2, BLACK);
		p.setPixel(1, 2, BLACK);
		p.setPixel(2, 2, RED);
		
		SubPicture sp = new SubPictureImpl(p, 1, 1, 2, 2);
		assertEquals("Pixel retrieved does not match expected pixel",
				p.getPixel(1, 1), sp.getPixel(0, 0));
		assertEquals("Pixel retrieved does not match expected pixel",
				p.getPixel(2, 1), sp.getPixel(1, 0));
		assertEquals("Pixel retrieved does not match expected pixel",
				p.getPixel(1, 2), sp.getPixel(0, 1));
		assertEquals("Pixel retrieved does not match expected pixel",
				p.getPixel(2, 2), sp.getPixel(1, 1));
		
	}
	
	@Test
	public void getPixelTest(){
		Picture p = new PictureImpl(3, 3);
		
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(2, 0, RED);
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 1, BLUE);
		p.setPixel(2, 1, WHITE);
		p.setPixel(0, 2, BLACK);
		p.setPixel(1, 2, BLACK);
		p.setPixel(2, 2, RED);
		
		assertEquals(p.getPixel(0,0), p.getPixel(2,0));
		assertEquals(p.getPixel(0,2), p.getPixel(1,2));
		assertEquals(p.getPixel(2,0), p.getPixel(2,2));
		assertEquals(p.getPixel(2,2), p.getPixel(0,0));

	}
	
	@Test
	public void extractTest(){
		Picture p = new PictureImpl(6,4);
		try {
			SubPicture sp = new SubPictureImpl(p, 7, 2, 1, 2);
			fail("Expected IllegalArgumentException for x >= source width");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			SubPicture sp = new SubPictureImpl(p, 3, 3, 4, 1);
			fail("Expected IllegalArgumentException for y  >= source height");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
	}
	
	
	
	
}

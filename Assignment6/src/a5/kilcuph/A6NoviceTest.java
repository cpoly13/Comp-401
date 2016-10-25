package a5.kilcuph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "exampleTest";
		test_names[1] = "getPixelTest";
		test_names[2] = "setPixelTest";
		test_names[3] = "nextTest";
		test_names[4] = "hasNextTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void getPixelTest() {
		Picture p = new PictureImpl(3, 3);
		Coordinate c = new Coordinate(1, 2);
		
		assertSame("GetPixel did not return the expected pixel information.", p.getPixel(c), p.getPixel(1,2));
	}
	
	
	@Test
	public void setPixelTest() {
		Picture p = new PictureImpl(3, 3);
		Coordinate c = new Coordinate(1, 2);
		Pixel pix = new ColorPixel(1.0, 1.0, 0.5);
		
		p.setPixel(c, pix);
		
		assertSame("SetPixel did not properly set red value", p.getPixel(c), pix);
		
	}
	
	@Test
	public void nextTest() {
		Picture p = new PictureImpl(3, 3);
		Iterator<Pixel> iter = p.iterator();
		
		for (int i = 0; i < p.getWidth(); i++)
			for (int j = 0; j < p.getHeight(); j++)
				iter.next();
		
		try {
			iter.next();
			fail("Expected NoSuchElementException for iterator next() after last pixel.");
		} catch(RuntimeException e) {
		}
	}
	
	@Test
	public void hasNextTest() {
		Picture p = new PictureImpl(3, 3);
		Iterator<Pixel> iter = p.iterator();
		
		for (int i = 0; i < p.getWidth(); i++)
			for (int j = 0; j < p.getHeight(); j++)
				iter.next();
		
		assertEquals("hasNext returned true at end of picture.", iter.hasNext(), false);
	}
	
	//TESTS TO DO: hasNext, Sample
}

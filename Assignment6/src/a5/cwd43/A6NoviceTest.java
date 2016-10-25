package a5.cwd43;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "extractSizeTest";
		test_names[1] = "nextTest";
		test_names[2] = "hasNextTest";
		
		return test_names;
	}
		
	@Test
	public void extractSizeTest() {
		
		PictureImpl p = new PictureImpl(5, 5);
		Coordinate a = new Coordinate(-1, -1);
		Coordinate b = new Coordinate(6, 6);
		
		try {
			p.extract(a, b);
			fail("Expected failure when coordinate x/y values are larger/smaller than picture boundaries");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void nextTest() {
		
		PictureImpl p = new PictureImpl(5, 5);
		Iterator<Pixel> iter = p.iterator();
		
		for (int i = 0; i < p.getHeight(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				assertEquals(iter.next(), p.getPixel(j,i));
			}	
		}		
		
	}
	
	@Test
	public void hasNextTest() {
		
		PictureImpl p = new PictureImpl(5, 5);
		Iterator<Pixel> iter = p.iterator();
		
		for (int i = 0; i < p.getHeight(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				assertEquals(iter.hasNext(), true);
				iter.next();
			}	
		}
		assertEquals(iter.hasNext(),false);
		
	}
	
	
	
}

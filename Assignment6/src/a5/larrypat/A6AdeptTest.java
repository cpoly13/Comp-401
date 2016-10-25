package a5.larrypat;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_id = {"exampleTest", "iteratorTest", "iteratorExceptionTest"};
		
		return test_id;
	}
		
	@Test
	public void exampleTest() {
	}
	
	//Test to see if iterator parses through pixels correctly
	@Test
	public void iteratorTest() {
		Picture p = new PictureImpl(15, 10);
		int x = 2;	//count variable to parse through all pixels iterator
		int y = 3;
		Iterator<Pixel> sample_iterat = p.sample(2, 3, 3, 4);
		while (sample_iterat.hasNext() && y < p.getHeight() - y) {	//Make sure y value doesn't go out of bounds
			Pixel iter_out = p.getPixel(x, y);
			assertEquals("Pixels do not match", sample_iterat.next(), iter_out);
			x += 3;
			y += 4;
		}
	}
	
	//Test if iterator exception occurs at right place
	@Test
	public void iteratorExceptionTest() {
		Picture p = new PictureImpl(15, 10);
		Iterator<Pixel> sample_iterat = p.sample(2, 3, 1, 1);
		while (sample_iterat.hasNext()) {
			sample_iterat.next();
		}
		try {
			sample_iterat.next();
			fail("Expected java.util.NoSuchElementException");
		} 
		catch (java.util.NoSuchElementException e) {
		}
	}

}

package a5.jfisch;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_Names = {"exampleTest", "iteratorTest", "iteratorExceptionTest"};
		
		return test_Names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	//Does iterator go through pixels
	@Test
	public void iteratorTest() {
		Picture a = new PictureImpl(15, 10);
		int x = 2;	
		int y = 3;
		Iterator<Pixel> sample_iter = a.sample(2, 3, 3, 4);
		while (sample_iter.hasNext() && y < a.getHeight() - y) {	
			Pixel iterator_out = a.getPixel(x, y);
			assertEquals("Pixels do not match", sample_iter.next(), iterator_out);
			x += 3;
			y += 4;
		}
	}
	
	//Test if iterator exception occurs at correct place
	@Test
	public void iteratorExceptionTest() {
		Picture a = new PictureImpl(15, 10);
		Iterator<Pixel> sample_iter = a.sample(2, 3, 1, 1);
		while (sample_iter.hasNext()) {
			sample_iter.next();
		}
		try {
			sample_iter.next();
			fail("Expected java.util.NoSuchElementException");
		} catch (java.util.NoSuchElementException e) {
		}
	}
	

}

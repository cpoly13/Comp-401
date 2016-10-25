package a5.willib;

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
	
	//Is the iterator going through pixels
	@Test
	public void iteratorTest() {
		Picture a = new PictureImpl(15, 10);
		int x = 2;	
		int y = 3;
		Iterator<Pixel> iterator_sample = a.sample(2, 3, 3, 4);
		while (iterator_sample.hasNext() && y < a.getHeight() - y) {	
			Pixel iterator_out = a.getPixel(x, y);
			assertEquals("Pixels do not match", iterator_sample.next(), iterator_out);
			x += 3;
			y += 4;
		}
	}
	
	//Test if iterator exception is happening at the correct place
	@Test
	public void iteratorExceptionTest() {
		Picture a = new PictureImpl(15, 10);
		Iterator<Pixel> iterator_sample = a.sample(2, 3, 1, 1);
		while (iterator_sample.hasNext()) {
			iterator_sample.next();
		}
		try {
			iterator_sample.next();
			fail("Expected java.util.NoSuchElementException");
		} catch (java.util.NoSuchElementException e) {
		}
	}
	

}

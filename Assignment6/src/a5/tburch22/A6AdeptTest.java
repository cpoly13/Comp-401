package a5.tburch22;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	// final pixel values for the purpose of testing methods that retrieve pixels
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
	
	// method with an output of strings that represent the names of the tests in the class
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "testSampleIterator";
		test_names[1] = "testSampleConstructorExceptions";
		test_names[2] = "testWindowConstructorExceptions";
		
		
		return test_names;
	}
		
	/* tests to make sure that the sample iterator works as specified. Checks this by comparing
	 * the call to next() and the expected values for all pixel locations that the iterator should 
	 * collect
	 */
	@Test
	public void testSampleIterator() {
		Picture pic1 = new PictureImpl(7,9);
		Iterator<Pixel> sampIter = pic1.sample(2, 2, 2, 3);
		for(int i = 2; i < 9; i+=3) {
			for(int j = 2; j < 7; j+=2) {
				pic1.setPixel(j, i, RED);
			}
		}
		
		for(int i = 0; i < 9; i++) {
				assertEquals("Pixel retrieved by the iterator does not match the pixel"
						+ "expected from the source picture", RED, sampIter.next());
			}
		
		
	}
	
	/*specific testing of the exceptions expected when an invalid sample iterator
    is constructed. Exceptions include negative dx and dy values, along with initial x 
    and y values not being in the source picture. It also takes into account the fact that an
    IllegalArgumentException should be generated, not a RuntimeException */
	@Test
	public void testSampleConstructorExceptions() {
		Picture pic1 = new PictureImpl(7,9);
		
		
		try {
			Iterator<Pixel> sampIter = pic1.sample(10, 2, 3, 3);
			fail("Expected IllegalArgumentException for x value not within the source picture");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		try {
			Iterator<Pixel> sampIter = pic1.sample(3, 20, 3, 3);
			fail("Expected IllegalArgumentException for y value not within the source picture");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			Iterator<Pixel> sampIter = pic1.sample(2, 2, -1, 3);
			fail("Expected IllegalArgumentException for dx < 0");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		try {
			Iterator<Pixel> sampIter = pic1.sample(2, 2, 4,-2);
			fail("Expected IllegalArgumentException for dy < 0");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}	
	}
	
	
	/*specific testing of the exceptions expected when an invalid window iterator
    is constructed. Exceptions include negative width and height values, along with initial width 
    and height values not being in the source picture */
	@Test
	public void testWindowConstructorExceptions() {
		Picture pic1 = new PictureImpl(4,7);
		
		try {
			Iterator<SubPicture> windowIter = pic1.window(8, 2);
			fail("Expected IllegalArgumentException for window width value greater than the "
					+ "witdh of the source picture");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		try {
			Iterator<SubPicture> windowIter = pic1.window(2, 8);
			fail("Expected IllegalArgumentException for window height value greater than the height"
					+ "of the source picture");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			Iterator<SubPicture> windowIter = pic1.window(-5, 2);
			fail("Expected IllegalArgumentException for window width <= 0");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		try {
			Iterator<SubPicture> windowIter = pic1.window(0, 2);
			fail("Expected IllegalArgumentException for window height <= 0");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}	
	}
	
}

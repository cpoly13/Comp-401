package a5.ericxin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	static public String[] getTestNames() {
		String[] test_names = new String[1];

		test_names[0] = "sampleIteratorTest";

		return test_names;
	}

	@Test
	public void sampleIteratorTest() {
		Picture pic = new PictureImpl( 15, 10);
		
		Iterator<Pixel> sample_iter = pic.sample(2, 3, 3, 4);

		//these are the coords our iterator will be iterating through
		int[][] coordXY = {{2,3},{5,3},{8,3},{11,3},{14,3},{2,7},{5,7},{8,7},{11,7},{14,7}};
		//both arrays are length 10 (hopefully)
		Pixel[] color = {RED, GREEN, BLACK, WHITE, WHITE, BLUE, RED, GREEN, BLUE, WHITE};
		//loop makes the picture have different colors :)
		for( int i = 0; i < 10; i++) {
			pic.setPixel(coordXY[i][0], coordXY[i][1], color[i]);
		}
		

		for( int i = 0; i < 10; i++) {
			try {
				Pixel pix = sample_iter.next();
				assertEquals("sample iterator wrong pixel", color[i], pix);
			} catch (RuntimeException e) {
				fail("Supposed to continue sample iterating");
				break;
			}
		}

		try {
			Pixel pix = sample_iter.next();		
			fail("There should be no next sample iterate");
		} catch (NoSuchElementException e) {
		} catch (RuntimeException e) {
			fail("Expected NoSuchElementException but got generic RuntimeException");
		}

	}

}

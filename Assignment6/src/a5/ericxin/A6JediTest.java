package a5.ericxin;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.GrayPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;
import a6jedi.*;

public class A6JediTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagIteratorTest";
		
		return test_names;
	}
	
	@Test
	public void zigzagIteratorTest() {
		Picture pic = new PictureImpl( 3, 6);
		
		Iterator<Pixel> zigzag_iter = pic.zigzag();

		//these are the coords our iterator will be iterating through
		int[][] coordXY = {{0,0},{1,0},{0,1},{0,2},{1,1},{2,0},{2,1},{1,2},{0,3},{0,4},{1,3},{2,2},{2,3},{1,4},{0,5},{1,5},{2,4},{2,5}};
		//both arrays are length 18 (hopefully)
		Pixel[] color = {BLACK, BLACK, BLACK, WHITE, RED, BLUE, BLUE, WHITE, RED, GREEN, BLACK, WHITE, WHITE, BLUE, RED, GREEN, BLUE, WHITE};
		//loop makes the picture have different colors :)
		for( int i = 0; i < 18; i++) {
			pic.setPixel(coordXY[i][0], coordXY[i][1], color[i]);
		}
		
		for( int i = 0; i < 18; i++) {
			try {
				Pixel pix = zigzag_iter.next();
				assertEquals("zigzag iterator wrong pixel", color[i], pix);
			} catch (RuntimeException e) {
				fail("Supposed to continue zigzag iterating");
				break;
			}
		}
		
		try {
			Pixel pix = zigzag_iter.next();		
			fail("There should be no next sample iterate");
		} catch (NoSuchElementException e) {
		} catch (RuntimeException e) {
			fail("Expected NoSuchElementException but got generic RuntimeException");
		}
		
	}
	
}

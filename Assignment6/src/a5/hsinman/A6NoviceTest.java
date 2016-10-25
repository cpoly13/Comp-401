package a5.hsinman;

import static org.junit.Assert.*;

import java.util.Iterator;

import junit.framework.Assert;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	/* A method to get test names as strings for A6 Novice.
	 * test_names is an array of the names of the tests.*/
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "getPixelTest";
		test_names[1] = "extractTest";
		test_names[2] = "setPixelTest";
		
		return test_names;
	}
		
	/*Test for getPixel() method in A6 Novice.
	 * Compares an arbitrary Pixel that was assigned to Picture p
	 * with the output from p.getPixel() that should produce the same Pixel.
	 */
	@Test
	public void getPixelTest(){
		PictureImpl p = new PictureImpl(3, 4);
		Coordinate c = new Coordinate(1, 2);
		Pixel correctPixel = new ColorPixel(.1, .2, .3);
		
		p.setPixel(1, 2, correctPixel);
		assertEquals(correctPixel, p.getPixel(c));
	}
	
	/*Test for extract() method in A6 Novice.
	 * Compares the height, width, and Pixel when the get methods
	 * are directly called on the subpicture and when the 
	 * extract method is used to get the subpicture.
	 */
	@Test
	public void extractTest(){
		PictureImpl p = new PictureImpl(6, 6);
		Pixel correctPixel = new ColorPixel(.3, .2, .1);
		p.setPixel(3, 2, correctPixel);
		SubPictureImpl correctSubPicture = new SubPictureImpl(p, 2, 1, 3, 4);
		Coordinate c1 = new Coordinate(2, 1);
		Coordinate c2 = new Coordinate(4, 4);
		
		assertEquals(correctSubPicture.getHeight(), p.extract(c1, c2).getHeight());
		assertEquals(correctSubPicture.getWidth(), p.extract(c1, c2).getWidth());
		assertEquals(correctSubPicture.getPixel(1, 1), p.extract(c1, c2).getPixel(1, 1));
	}
	
	/* Test for setPixel() method in A6 Novice.
	 * Creates 3 arbitrary Pixels with coordinating Coordinates in an arbitrary Picture
	 * and then sets them to their correct location. The test compares the output from
	 * getPixel() in the coordinate location and the original Pixel that was created.
	 */
	@Test
	public void setPixelTest(){
		PictureImpl p = new PictureImpl(10, 10);
		Coordinate c1 = new Coordinate(5, 2);
		Pixel p1 = new ColorPixel(.9, .8, .7);
		Coordinate c2 = new Coordinate(9, 0);
		Pixel p2 = new ColorPixel(.4, .2, .85);
		Coordinate c3 = new Coordinate(7, 7);
		Pixel p3 = new ColorPixel(.65, .65, .65);
		
		p.setPixel(c1, p1);
		p.setPixel(c2, p2);
		p.setPixel(c3, p3);
		
		assertEquals(p.getPixel(c1), p1);
		assertEquals(p.getPixel(c2), p2);
		assertEquals(p.getPixel(c3), p3);
		
	}
	
}

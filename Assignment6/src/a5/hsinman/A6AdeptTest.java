package a5.hsinman;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
	
	/* A method to get test names as strings for A6 Adept.
	 * test_names is an array of the names of the tests.*/
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";
		
		return test_names;
	}
	
	/*Test for sample() method in A6 Adept.
	 * Creates arbitrary Pixels tied to certain Coordinates in a picture that 
	 * correspond to the correct values of sample_interator
	 * Compares the Pixel to the place in the iterator where it should be.
	 */
	@Test
	public void sampleTest(){
		PictureImpl p = new PictureImpl(6, 9);
		Iterator<Pixel> sample_iter = p.sample(1, 2, 2, 3);
		
		Coordinate c1 = new Coordinate(1, 2);
		Pixel p1 = new ColorPixel(.12, .13, .14);
		Coordinate c2 = new Coordinate(3, 2);
		Pixel p2 = new ColorPixel(.43, .44, .45);
		Coordinate c3 = new Coordinate(5, 2);
		Pixel p3 = new ColorPixel(.59, .58, .57);
		Coordinate c4 = new Coordinate(1, 5);
		Pixel p4 = new ColorPixel(.42, .42, .42);
		Coordinate c5 = new Coordinate(3, 5);
		Pixel p5 = new ColorPixel(.999, .001, .555);
		Coordinate c6 = new Coordinate(5, 5);
		Pixel p6 = new ColorPixel(.9, .8, .7);
		Coordinate c7 = new Coordinate(1, 8);
		Pixel p7 = new ColorPixel(.3, .4,.1234567);
		Coordinate c8 = new Coordinate(3, 8);
		Pixel p8 = new ColorPixel(.2, .2, .0007);
		Coordinate c9 = new Coordinate(5, 8);
		Pixel p9 = new ColorPixel(.3, .76, .12);
		
		assertEquals(p.getPixel(c1), sample_iter.next());
		assertEquals(p.getPixel(c2), sample_iter.next());
		assertEquals(p.getPixel(c3), sample_iter.next());
		assertEquals(p.getPixel(c4), sample_iter.next());
		assertEquals(p.getPixel(c5), sample_iter.next());
		assertEquals(p.getPixel(c6), sample_iter.next());
		assertEquals(p.getPixel(c7), sample_iter.next());
		assertEquals(p.getPixel(c8), sample_iter.next());
		assertEquals(p.getPixel(c9), sample_iter.next());
	}
	
	@Test
	public void windowTest(){
		PictureImpl p = new PictureImpl(4, 4);
		Iterator<SubPicture> window_iter = p.window(2, 2);
		
		SubPicture s1 = p.extract(0, 0, 2, 2);
		SubPicture s2 = p.extract(1, 0, 2, 2);
		SubPicture s3 = p.extract(2, 0, 2, 2);
		SubPicture s4 = p.extract(0, 1, 2, 2);
		SubPicture s5 = p.extract(1, 1, 2, 2);
		SubPicture s6 = p.extract(2, 1, 2, 2);
		SubPicture s7 = p.extract(0, 2, 2, 2);
		SubPicture s8 = p.extract(1, 2, 2, 2);
		SubPicture s9 = p.extract(2, 2, 2, 2);
		
		s1.equals(window_iter.next());
		s2.equals(window_iter.next());
		s3.equals(window_iter.next());
		s4.equals(window_iter.next());
		s5.equals(window_iter.next());
		s6.equals(window_iter.next());
		s7.equals(window_iter.next());
		s8.equals(window_iter.next());
		s9.equals(window_iter.next());
	}
}

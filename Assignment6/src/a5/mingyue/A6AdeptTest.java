package a5.mingyue;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "exampleTest";
		
		return test_names;
	}
	
	@Test
	public void exampleTest() {
		
	}
		
	/*@Test
	public void sampleTest() {
		Picture pic = new PictureImpl(3, 3);
		Pixel p1 = new GrayPixel(0.0);
		Pixel p2 = new GrayPixel(1.0);
		Pixel p3 = new GrayPixel(0.5);
		pic.setPixel(0, 0, p1);
		pic.setPixel(0, 1, p2);
		pic.setPixel(0, 2, p3);
		pic.setPixel(1, 0, p2);
		pic.setPixel(1, 1, p3);
		pic.setPixel(1, 2, p1);
		pic.setPixel(2, 0, p3);
		pic.setPixel(2, 1, p1);
		pic.setPixel(2, 2, p2);
		Iterator<Pixel> sample_iter = pic.sample(0, 0, 2, 1);
		assertEquals(p1, sample_iter.next());
		assertEquals(p3, sample_iter.next());
		assertEquals(p2, sample_iter.next());
		assertEquals(p1, sample_iter.next());
		assertEquals(p3, sample_iter.next());
		assertEquals(p2, sample_iter.next());

		//Coordinate corner_a = new Coordinate(1, 0);
		//Coordinate corner_b = new Coordinate(2, 2);
		//SubPicture sp = pic.extract(corner_a, corner_b);
		//assertEquals(pic.getPixel(1, 1), sp.getPixel(0, 1));		
	}
	*/
}

package a5.davidj96;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "sampleIteratorTest";
		test_names[1] = "testTwo";

		return test_names;
	}

	@Test
	public void sampleIteratorTest() {
		Pixel red = new ColorPixel(1, 0, 0);
		Picture p = new PictureImpl(15, 10);
		Coordinate c = new Coordinate(5,3);
		p.setPixel(c, red);
		Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
		sample_iter.next();
		assertEquals("",red,sample_iter.next());
	}
	@Test
	public void windowIteratorTest() {
		Pixel red = new ColorPixel(1, 0, 0);
		Picture p = new PictureImpl(15, 10);
		Coordinate c = new Coordinate(5,3);
		p.setPixel(c, red);
		Iterator<SubPicture> window_iter = p.window(3, 2);
		
	}
	

}

package a5.joelj21;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "testSetPixel";
		test_names[1] = "testGetPixel";
		test_names[2] = "testExtract";
		
		return test_names;
	}
		
	@Test
	public void testSetPixel() {
		Coordinate c = new Coordinate(1, 1);
		Pixel p = new ColorPixel(1, 1, 0);
		Picture sample = new PictureImpl(2, 2);
		Picture sample2 = new PictureImpl(2, 2);
		
		sample.setPixel(c, p);
		sample2.setPixel(1, 1, p);
		
		assertEquals("Coordinate is not equivalent to separate x and y values.",
				sample.getPixel(1, 1), sample2.getPixel(1, 1));
	}
	
	@Test
	public void testGetPixel() {
		Coordinate c = new Coordinate(1, 1);
		Pixel p = new ColorPixel(1, 1, 0);
		Picture sample = new PictureImpl(2, 2);
		
		sample.setPixel(1, 1, p);
		
		assertEquals("Coordinate value in getPixel is not used as x and y values.", 
				sample.getPixel(c), sample.getPixel(1, 1));
	}
	
	@Test
	public void testExtract() {
		Picture s = new PictureImpl(5, 5);
		Pixel x = new ColorPixel(1, 1, 0);
		s.setPixel(2, 2, x);
		SubPicture p = s.extract(1, 1, 3, 4);
		
		Coordinate c1 = new Coordinate(1, 1);
		Coordinate c2 = new Coordinate(3, 4);
		SubPicture p2 = s.extract(c1, c2);
		
		assertEquals("Pixels do not line up between overloaded and normal extract method.", 
				p.getPixel(1, 1), p2.getPixel(1, 1));
		assertEquals("Widths of overloaded and normal extract methods don't match.", 
				p.getWidth(), p2.getWidth());
		assertEquals("Heights of overloaded and normal extract methods don't match.", 
				p.getHeight(), p2.getHeight());
	}
}

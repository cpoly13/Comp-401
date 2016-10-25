package a5.hattle;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "exampleTest";
		test_names[1] = "pixelTest";
		test_names[2] = "iteratorTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void pixelTest() {
		Picture testPic = new PictureImpl(5,5);
		Coordinate c = new Coordinate(2,3);
		Pixel p = new ColorPixel(.75, .3, .4);
		testPic.setPixel(c, p);
		Coordinate botCorner = new Coordinate(1,1);
		Coordinate topCorner = new Coordinate(4,4);
		Picture cutout = testPic.extract(botCorner, topCorner);
		Coordinate c2 = new Coordinate(1,2);
		Pixel p2 = cutout.getPixel(c2);
		assertEquals(0.75, p2.getRed(), 0.001);
		assertEquals(0.3,  p2.getGreen(), 0.001);
		assertEquals(0.4,  p2.getBlue(), 0.001);
		
	}
	
	@Test
	public void iteratorTest() {
		Picture testPic = new PictureImpl(5,5);
		Coordinate c = new Coordinate(2,3);
		Pixel p = new ColorPixel(.75, .3, .4);
		// why could I not make these a part of state?
		testPic.setPixel(c, p);
		Iterator<Pixel> iteration = testPic.iterator();
		for (int i = 0; i < 17; i++){
			iteration.next();
		}
		Pixel p2 = iteration.next();
		assertEquals(0.75, p2.getRed(), 0.001);
		assertEquals(0.3,  p2.getGreen(), 0.001);
		assertEquals(0.4,  p2.getBlue(), 0.001);
	}
	
	
	
	
		
	
}

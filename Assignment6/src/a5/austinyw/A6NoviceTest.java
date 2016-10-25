package a5.austinyw;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	
	private double precision;
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "coordinateTest";
		test_names[1] = "coordinateMethodsTest";
		test_names[2] = "iteratorTest";
		
		return test_names;
	}
		
	@Before
	public void setup() {
		precision = 0.00001;
	}
	
	@Test
	public void coordinateTest() {
		Coordinate c1 = new Coordinate(0,0);
		Coordinate c2 = new Coordinate(0,1);
		Coordinate c3 = new Coordinate(1,0);
		Coordinate c4 = new Coordinate(1,1);
		
		int expected0 = 0;
		int expected1 = 1;
		
		assertEquals("getX did not return expected value", 
				expected0, c1.getX(), precision);
		assertEquals("getX did not return expected value", 
				expected0, c2.getX(), precision);
		assertEquals("getX did not return expected value", 
				expected1, c3.getX(), precision);
		assertEquals("getX did not return expected value", 
				expected1, c4.getX(), precision);
		
		assertEquals("getY did not return expected value", 
				expected0, c1.getY(), precision);
		assertEquals("getY did not return expected value", 
				expected0, c3.getY(), precision);
		assertEquals("getY did not return expected value", 
				expected1, c2.getY(), precision);
		assertEquals("getY did not return expected value", 
				expected1, c4.getY(), precision);
	}
	
	@Test
	public void coordinateMethodsTest() {
		Picture p1 = new PictureImpl(3,3);
		Coordinate c1 = new Coordinate(2,2);
		Coordinate c2 = new Coordinate(0,1);
		
		p1.setPixel(c1, new GrayPixel(0.467));
		p1.setPixel(c2, new ColorPixel(0.22, 0.51, 1.0));
		
		SubPicture p2 = p1.extract(c1, c2);
		SubPicture p3 = p1.extract(c2, c1);
		
		double expected1 = 0.467;
		double expected2 = 0.51;
		double expectedWidth = 3;
		double expectedHeight = 2;
		double expectedXOffset = 0;
		double expectedYOffset = 1;
		
		assertEquals("Pixel gotten from Coordinate does not match expected",
				expected1, p1.getPixel(c1).getIntensity(), precision);
		assertEquals("Pixel gotten from Coordinate does not match expected",
				expected2, p1.getPixel(c2).getGreen(), precision);
		
		assertEquals("Width gotten from SubPicture does not match expected",
				expectedWidth, p2.getWidth(), precision);
		assertEquals("Height gotten from SubPicture does not match expected",
				expectedHeight, p2.getHeight(), precision);
		assertEquals("xOffset gotten from SubPicture does not match expected",
				expectedXOffset, p2.getXOffset(), precision);
		assertEquals("yOffset gotten from SubPicture does not match expected",
				expectedYOffset, p2.getYOffset(), precision);
		
		assertEquals("SubPictures are not the same",
				p2.getPixel(0,0).getBlue(), p3.getPixel(0,0).getBlue(), precision);
		assertEquals("SubPictures are not the same",
				p2.getPixel(1,0).getRed(), p3.getPixel(1,0).getRed(), precision);
		assertEquals("SubPictures are not the same",
				p2.getPixel(2,1).getGreen(), p3.getPixel(2,1).getGreen(), precision);
	}
	
	@Test
	public void iteratorTest() {
		Picture p1 = new PictureImpl(3,3);
		p1.setPixel(0, 0, new ColorPixel(0, 0.5, 1.0));
		p1.setPixel(1, 1, new GrayPixel(0.666));
		p1.setPixel(2, 2, new ColorPixel(0.12, 0.23, 0.34));
		
		Pixel expectedGray = new GrayPixel(0.5);
		double expected1 = 0.0;
		double expected2 = 0.666;
		double expected3 = 0.34;
		
		Iterator<Pixel> iter1 = p1.iterator();
		assertEquals("1st iterator value does not match expected",
				expected1, iter1.next().getRed(), precision);
		
		assertEquals("2st iterator value does not match expected",
				expectedGray.getIntensity(), iter1.next().getIntensity(), precision);
		assertEquals("3rd iterator value does not match expected",
				expectedGray.getIntensity(), iter1.next().getIntensity(), precision);
		assertEquals("4th iterator value does not match expected",
				expectedGray.getIntensity(), iter1.next().getIntensity(), precision);
		
		assertEquals("5th iterator value does not match expected",
				expected2, iter1.next().getIntensity(), precision);
		
		assertEquals("6th iterator value does not match expected",
				expectedGray.getIntensity(), iter1.next().getIntensity(), precision);
		assertEquals("7th iterator value does not match expected",
				expectedGray.getIntensity(), iter1.next().getIntensity(), precision);
		assertEquals("8th iterator value does not match expected",
				expectedGray.getIntensity(), iter1.next().getIntensity(), precision);
		
		assertEquals("9th iterator value does not match expected",
				expected3, iter1.next().getBlue(), precision);
		
		try {
			iter1.next();
			fail("Called next and the iterator did not throw an exception");
		}
		catch(NoSuchElementException e) {
		}
	}
}

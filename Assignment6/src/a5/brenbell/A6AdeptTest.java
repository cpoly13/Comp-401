package a5.brenbell;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;
import junit.framework.Assert;


public class A6AdeptTest {
	
	 private static final Pixel WHITE = new GrayPixel(1.0D);
	 private static final Pixel BLACK = new GrayPixel(0.0D);
	 private static final Pixel RED = new ColorPixel(1.0, 0.0, 0.0);
	 private static final Pixel GREEN = new ColorPixel(0.0, 1.0, 0.0);
	 private static final Pixel BLUE = new ColorPixel(0.0, 0.0, 1.0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "testSample";
		test_names[1] = "testWindow";
		
		return test_names;
	}
		
	@Test
	public void testSample() {
		Picture testPic = initSample();
		Iterator<Pixel> testPicIterator = testPic.sample(0,0,2,2);
		
		Assert.assertTrue(testPicIterator.hasNext());
		Assert.assertEquals("The pixel given to the iterator isn't what is expected.", GREEN, testPicIterator.next());
		Assert.assertEquals("The pixel given to the iterator isn't what is expected.", RED, testPicIterator.next());

	}
	
	@Test
	public void testWindow() {
		Picture testPic = initSample(); 
		Coordinate testA = new Coordinate(0,0);
		Coordinate testB = new Coordinate(0,1);
		Coordinate testC = new Coordinate(1,0);
		
		Iterator<SubPicture> testWindowIterator = testPic.window(2, 2);
		Coordinate windowTestA = new Coordinate(0,0);
		Coordinate windowTestB = new Coordinate(0,1);
		Coordinate windowTestC = new Coordinate(1,0);
		
		Assert.assertTrue(testWindowIterator.hasNext());
		Picture subPicTest = (Picture)testWindowIterator.next();
		Assert.assertEquals("The next pixel given by the window iterator was not expected.", testPic.getPixel(testA), subPicTest.getPixel(windowTestA));
		Assert.assertEquals("The next pixel given by the window iterator was not expected.", testPic.getPixel(testB), subPicTest.getPixel(windowTestB));
		Assert.assertEquals("The next pixel given by the window iterator was not expected.", testPic.getPixel(testC), subPicTest.getPixel(windowTestC));

		
	}
	
	private Picture initSample() {
		Picture sample = new PictureImpl(3,3);
		
		sample.setPixel(0, 0, GREEN);
		sample.setPixel(1, 0, BLUE);
		sample.setPixel(2, 0, RED);
		sample.setPixel(0, 1, RED);
		sample.setPixel(1, 1, BLUE);
		sample.setPixel(2, 1, GREEN);
		sample.setPixel(0, 2, BLACK);
		sample.setPixel(1, 2, WHITE);
		sample.setPixel(2, 2, BLACK);
		
		
		return sample;
	}
}


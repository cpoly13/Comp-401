package a5.ngtruc;

import static org.junit.Assert.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

/*
 * Nikole Nguyen
 * 10/17/2016
 * 
 */

public class A6NoviceTest {
	
	  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	    @org.junit.Before
	    public void setUp() throws Exception {
	        System.setOut(new PrintStream(outContent));
	    }

	    @org.junit.After
	    public void tearDown() throws Exception {
	        System.setOut(null);
	    }

		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "nullParametersTest";
		test_names[1] = "setBasicPictureCoordinateTest";
		test_names[2] = "setPixelCoordinateTest";
		test_names[3] = "getAndSetPixelCoordinateTest";
		test_names[4] = "subPictureExtractTest";
		
		return test_names;
	}
	
	/*
	 * Test if parameters are null.
	 * pre: a picture that tries to extract outside of bounds and extract co-linear coordinates
	 * post: catch IllegalArgumentException
	 * 
	 */
	
	@Test
	public void nullParametersTest() {
		
		Picture picture = new PictureImpl (10, 7);
		
		try {
			SubPicture sp = picture.extract(new Coordinate(3,8), new Coordinate (8,3));
			fail ("Expected IllegalArgumentException, but parameters passed.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail ("Expected IllegalArgumentException but received Runtime.");
		}
		
		try {
			
			SubPicture sp = picture.extract(new Coordinate (3,5), new Coordinate (3,9));
			fail ("Expected IllegalArgumentException because coordinates are co-linear.");
		} catch (IllegalArgumentException e) {			
		} catch (RuntimeException e) {
			fail ("Expected IllegalArgument, received Runtime.");
		}
		
		// SubPicture sp = picture.extract(new Coordinate (1,5), new Coordinate (4, 6));
		
	}
	
	/*
	 * Set up picture using the coordinates.
	 * pre: An empty picture.
	 * post: Fill the picture with gray pixel intensity 0.6. 
	 * 
	 */
	
	@Test
	public void setBasicPictureCoordinateTest() {
		
		Picture picture = new PictureImpl (15,10);
		
		for (int a = 0; a < picture.getWidth(); a++ ) {
			
			for (int b = 0; b < picture.getHeight(); b++) {
				
				picture.setPixel(a, b, new GrayPixel(0.6));
				
			}
			
		}
		
		
		String output = 
				
				"sssssssssssssss\n" +
				"sssssssssssssss\n" +
				"sssssssssssssss\n" +
				"sssssssssssssss\n" +
				"sssssssssssssss\n" +
				"sssssssssssssss\n" +
				"sssssssssssssss\n" +
				"sssssssssssssss\n" +
				"sssssssssssssss\n" +
				"sssssssssssssss\n";

		picture.print();
		
		assertEquals(output, outContent.toString());
		
	}
	
	/*
	 * Set specific coordinates of a picture to be certain pixels.
	 * pre: An empty picture.
	 * post: A picture whose pixels have been replaced at given coordinates
	 * 			from the for-loop and coordinate objects.
	 * 
	 */
	
	@Test
	public void setPixelCoordinateTest() {
		
		Picture picture = new PictureImpl (12, 6);
		
		for (int a = 0; a < picture.getWidth(); a++ ) {
			
			for (int b = 0; b < picture.getHeight(); b++) {
				
				picture.setPixel(new Coordinate(a,b), new GrayPixel(0.6));
				
			}
			
		}
		
		for (int a = 0; a < picture.getWidth(); a+= 2) {
			
			for (int b = 0; b < picture.getHeight(); b++) {
				
				picture.setPixel(new Coordinate(a,b), new ColorPixel(0.55,0.89,0.32));
				
			}
			
		}
		
		Coordinate coord1 = new Coordinate (3,5);
		Coordinate coord2 = new Coordinate (4,5);
		Coordinate coord3 = new Coordinate (5,2);
		
		picture.setPixel(coord1, new GrayPixel (0.7));
		picture.setPixel(coord2, new GrayPixel (0.3));
		picture.setPixel(coord3, new GrayPixel (0.4));
		
		picture.print();
		
		String output =
				
				":s:s:s:s:s:s\n" +
				":s:s:s:s:s:s\n" +
				":s:s:<:s:s:s\n" +
				":s:s:s:s:s:s\n" +
				":s:s:s:s:s:s\n" +
				":s::Ds:s:s:s\n";
				
		assertEquals(output, outContent.toString());
		
	}
	
	/*
	 * Tests both getter and setters.
	 * Pre: A new picture filled with graypixel 0.8 intensity.
	 * Post: The picture replaced with various coordinates, and the correct pixel returned
	 * 			when the getPixel method is called. 
	 * 
	 */
	
	@Test
	public void getAndSetPixelCoordinateTest() {
		
		Picture picture = new PictureImpl (5,5);
		
		for (int a = 0; a < picture.getWidth(); a++) {
			
			for (int b = 0; b < picture.getHeight(); b++) {
				
				picture.setPixel(new Coordinate(a,b), new GrayPixel(0.8));
				
			}
			
		}
		
		picture.setPixel(new Coordinate(1,3), new ColorPixel(0.23,0.55,0.65));
		picture.setPixel(new Coordinate(1,4), new ColorPixel(0.45,0.23,0.12));
		picture.setPixel(new Coordinate (2,4), new GrayPixel(0.2));
		
		String output =
				
				"-----\n" +
				"-----\n" +
				"-----\n" +
				"-<---\n" +
				"-XX--\n";

		picture.print();
		
		assertEquals(output, outContent.toString());
		
		assertEquals('X', picture.getPixel(1,4).getChar());
		assertEquals('<', picture.getPixel(1,3).getChar());
		assertEquals('X', picture.getPixel(2,4).getChar());
		
		
	}
	
	/*
	 * Tests for the correct subpicture extracted from original picture.
	 * Pre: A picture filled with gray-pixels.
	 * Post: An extracted picture, which is a subpicture object. It should match
	 * 		the expected output.
	 */
	
	@Test
	public void subPictureExtractTest() {
		
		Picture picture = new PictureImpl (14,9);
		
		for (int a = 0; a < picture.getWidth(); a++) {
			
			for (int b = 0; b < picture.getHeight(); b++) {
				
				picture.setPixel(new Coordinate(a,b), new GrayPixel(0.3));
				
			}	
			
		}
		
		picture.setPixel(new Coordinate(1,5), new GrayPixel(0.4));
		picture.setPixel(new Coordinate(4,8), new GrayPixel (0.6));
		
		SubPicture subpic = picture.extract(new Coordinate(1,5), new Coordinate (4,8));
		subpic.print();
		
		String output = 
				"<DDD\n" +
				"DDDD\n" +
				"DDDD\n" +
				"DDDs\n";
		
		assertEquals (output, outContent.toString());
		
	}
	
	
}

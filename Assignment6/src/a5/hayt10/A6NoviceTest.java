package a5.hayt10;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() 
	{
		String[] test_names = new String[2];
		
		test_names[0] = "getSetPixelTest";
		test_names[1] = "iteratorTest";
		
		return test_names;
	}
		
	@Test
	/**
	 * Ensures pixels are set and retrieved properly by using coordinates for the
	 * overloaded getPixel and setPixel methods
	 */
	public void getSetPixelTest() 
	{
		//Sets up an example
		Picture pic = new PictureImpl(5, 5);
		Pixel white = new GrayPixel(1);
		Coordinate center = new Coordinate(3, 3);
		
		try
		{
			pic.setPixel(center, white);
		}
		//If caught, program believes a valid coordinate is invalid
		catch (RuntimeException e)
		{
			fail("Failed to set a valid coordinate");
		}
		//Check if the correct pixel was set
		assertEquals("Pixel retrieval is incorrect,", white, pic.getPixel(center));
	}
	
	@Test
	/**
	 * Test the iterator to ensure the hasNext method and next methods function properly
	 */
	public void iteratorTest()
	{
		//Set up an example
		Picture pic = new PictureImpl(5,5);
		int iterations = 0;
		Iterator<Pixel> testIterations = pic.iterator();
		
		//Count iterations
		try
		{
			while (testIterations.hasNext())
			{
				iterations++;
				testIterations.next();
			}
		}
		//See if program throws exceptions at the wrong times
		catch (NoSuchElementException e)
		{
			fail("The iterator doesn't correctly determine if there is a next element");
		}
		
		//Check the number of iterations and see if every element is visited exactly once
		assertEquals("Iterator doesn't iterate the correct number of times,",
				iterations, pic.getWidth() * pic.getHeight());
		
		Pixel red = new ColorPixel(1,0,0);
		Pixel green = new ColorPixel(0,1,0);
		Pixel blue = new ColorPixel(0,0,1);
		Pixel white = new GrayPixel(1);
		Pixel gray = new GrayPixel(0.25);
		
		Pixel[] pixArr = new Pixel [] {red, green, blue, white, gray};
		Iterator<Pixel> checkMovement = pic.iterator();
		
		//Set array to different values for testing
		for (int i = 0; i < pic.getHeight(); i++)
		{
			for (int j = 0; j < pic.getWidth(); j++)
			{
				pic.setPixel(new Coordinate (j, i), pixArr[j]);
			}
		}
		
		//Ensures iterator is moving to the appropriate next pixel
		iterations = 0;
		while (checkMovement.hasNext())
		{
			Pixel nextPix = checkMovement.next();
			assertEquals("Iterator doesn't move to the next pixel correctly,",
					nextPix.equals(pixArr[iterations % pic.getWidth()]), true);
			iterations++;
		}
	}
}

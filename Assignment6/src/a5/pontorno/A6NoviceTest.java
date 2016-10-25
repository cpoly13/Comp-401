package a5.pontorno;

import static org.junit.Assert.*;
import org.junit.Test;

import a6novice.*;

public class A6NoviceTest
{	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
	static public String[] getTestNames()	// Retrieves all test names for A6Novice.
	{
		String[] test_names = new String[5];
		
		test_names[0] = "testOverloadedSetPixel";
		test_names[1] = "testOverloadedExtract";
		test_names[2] = "testOverloadedSetPixelNullError";
		test_names[3] = "testOverloadedSetPixelBoundsError";
		test_names[4] = "testOverloadedGetPixelBoundsError";
		
		return test_names;
	}
	
	@Test
	public void testOverloadedSetPixel()	// Tests the overloaded method for setPixel using a coordinate object.
	{
		Picture p = new PictureImpl(10, 10);
		Coordinate c = new Coordinate(6, 4);
		Pixel px = new GrayPixel(1);
		
		p.setPixel(c, px);
		
		assertEquals("The intensity of the pixel at (6, 4) does not match the intensity of the set pixel.",
				1, p.getPixel(c).getIntensity(), 0.01);
	}
	
	@Test
	public void testOverloadedExtract()		// Tests the overloaded method for extract using a coordinate object.
	{
		Picture p = new PictureImpl(3, 3);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(2, 0, RED);
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 1, BLUE);
		p.setPixel(2, 1, WHITE);
		p.setPixel(0, 2, BLACK);
		p.setPixel(1, 2, BLACK);
		p.setPixel(2, 2, RED);
		
		Coordinate a = new Coordinate(0, 1);
		Coordinate b = new Coordinate(2, 2);
		
		SubPicture sub = p.extract(a, b);
		
		assertEquals("The Pixel did not match up correctly.", GREEN, sub.getPixel(0, 0));
	}
	
	@Test
	public void testOverloadedSetPixelNullError()	// Tests the overloaded method for setPixel to confirm
	{												// that it gives a error for a null pixel argument.
		Picture p = new PictureImpl(10, 10);
		Coordinate c = new Coordinate(6 , 4);
		Pixel px = null;
		
		try
		{
			p.setPixel(c, px);
			fail("Expected IllegalArgumentException for px = null.");
		}
		
		catch (IllegalArgumentException e)
		{
			
		}
		
		catch (RuntimeException e)
		{
			
		}
	}
	
	@Test
	public void testOverloadedSetPixelBoundsError()	// Tests the overloaded method for setPixel to confirm
	{												// that it gives a error for out of bounds coordinates.
		Picture p = new PictureImpl(10, 10);
		Coordinate c = new Coordinate(12 , 14);
		Pixel px = new GrayPixel(1);
		
		try
		{
			p.setPixel(c, px);
			fail("Expected IllegalArgumentException for out of bounds coordinate.");
		}
		
		catch (IllegalArgumentException e)
		{
			
		}
		
		catch (RuntimeException e)
		{
			
		}
	}
	
	@Test
	public void testOverloadedGetPixelBoundsError()	// Tests the overloaded method for getPixel to confirm
	{												// that it gives a error for out of bounds coordinates.
		Picture p = new PictureImpl(10, 10);
		Coordinate c = new Coordinate(12 , 14);
		
		try
		{
			Pixel px = p.getPixel(c);
			fail("Expected IllegalArgumentException for out of bounds coordinate.");
		}
		
		catch (IllegalArgumentException e)
		{
			
		}
		
		catch (RuntimeException e)
		{
			
		}
	}
}
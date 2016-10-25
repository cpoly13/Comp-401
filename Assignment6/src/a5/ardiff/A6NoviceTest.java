package a5.ardiff;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;
import junit.framework.Assert;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "invalidCoordTest";
		
		return test_names;
	}
		
	@Test
	public void invalidSetPixelCoordTest() {
		Picture p = new PictureImpl(15, 10);
		Coordinate c = new Coordinate(7, -1);
		
		try {
			p.setPixel(c, new ColorPixel(.6,.4,.4));
			fail("Should not be able to define coordinate at this location.");
		}catch(Exception e){
		}
	}
	
	@Test
	public void invalidGetPixelCoordTest() {
		Picture p = new PictureImpl(15, 10);
		Coordinate c = new Coordinate(23, 14);
		
		try {
			p.getPixel(c);
			fail("Should not be able to get this coordinate thats not in the picture.");
		}catch(Exception e){
		}
	}
	
	@Test
	public void invalidExtractCoordTest() {
		Picture p = new PictureImpl(15, 10);
		Coordinate c = new Coordinate(6,5);
		Coordinate c2 = new Coordinate(34,2);
		
		try {
			p.extract(c, c2);
			fail("Subpicture reaches outside the possible boundaries.");
		}catch(Exception e){
		}
	}
	
	@Test
	public void checkValidExtraction() {
		Picture p = new PictureImpl(15,10);
		
		p.setPixel(new Coordinate(7, 4),new ColorPixel(0.6,0.4,0.2));
		
		Coordinate c1 = new Coordinate(6,5);
		Coordinate c2 = new Coordinate(8,3);
		
		Picture expectedSub = new SubPictureImpl(p, 6, 3, 2, 2);
		Picture actualSub = p.extract(c1, c2);
		
		for(int i = 0; i < expectedSub.getHeight(); i++)
		{
			for(int j = 0; j < expectedSub.getWidth(); j++)
			{
				assert(expectedSub.getPixel(new Coordinate(i,j)).equals(actualSub.getPixel(new Coordinate(i,j))));
			}
		}
	}
	
	@Test
	public void hasNextTest()
	{
		Picture p = new PictureImpl(4,4);
		
		int expected = 16;
		
		int actual = 0;
		
		for (Iterator<Pixel> it = p.iterator(); it.hasNext();){
		      it.next();
		      actual++;
		}
		
	
		assertEquals(expected, actual);
	}
	
	
}

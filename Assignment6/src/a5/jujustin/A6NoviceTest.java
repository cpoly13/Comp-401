package a5.jujustin;

import static org.junit.Assert.*;

//import java.util.Iterator;

import org.junit.Test;


import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "invalidCoordinates";
		test_names[1] = "extractTest";
		
		return test_names;
	}
		
	@Test
	public void invalidCoordinates() {
		
		
		Picture p = new PictureImpl(4,4);
		Pixel red = new ColorPixel(1,0,0);

	//getPixel Test		
	try{
		Coordinate c = new Coordinate (-1, 8);
		p.getPixel(c);

	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
	try{
		Coordinate c = new Coordinate (5, 5);
		p.getPixel(c);

	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
	try{
		Coordinate c = new Coordinate (3, 8);
		p.getPixel(c);

	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
	
	
	//setPixel Test
	try{
		Coordinate c = new Coordinate (-1, 8);
		p.setPixel(c, red);

	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
	try{
		Coordinate c = new Coordinate (5, 5);
		p.setPixel(c, red);

	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
	try{
		Coordinate c = new Coordinate (3, 8);
		p.setPixel(c, red);

	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	}
	
	
	}
	
	@Test
	public void extractTest()
	{
		Picture p = new PictureImpl(4,4);
		ColorPixel pix = new ColorPixel(.5,.25,.75);
		p.setPixel(1, 1, pix);
		
		SubPicture s = new SubPictureImpl(p, 1, 1, 3, 3);
	
		Coordinate c = new Coordinate(1,1);
		Coordinate c2 = new Coordinate(3,3);

		
		assertEquals("Result from extract equals subpicture",
				p.extract(c, c2).getHeight(), s.getHeight());
		assertEquals("Result from extract equals subpicture",
				p.extract(c, c2).getWidth(), s.getWidth());
		
		//checking extract to correct subpicture object
		for(int y = 0; y < c2.getY() - c.getY(); y++)
		{
			for(int x = 0; x < c2.getX() - c.getX(); x++)
			{
				assertEquals("Result from extract doesn't equal subpicture",
						p.extract(c, c2).getPixel(x,y), s.getPixel(x,y));
			}
		}
		
		//Invalid Extract Parameters
		try{
			Coordinate c1 = new Coordinate(5,3);
			p.extract(c1, c2);

		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		try{
			Coordinate c1 = new Coordinate(0,0);
			p.extract(c2, c1);

		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		

	
		
		
		
		
	}
	

}

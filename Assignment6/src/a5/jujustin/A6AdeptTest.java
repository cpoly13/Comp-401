package a5.jujustin;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;


public class A6AdeptTest {
	
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "iteratorMethodsExceptionTests";
		test_names[1] = "iteratorTests";
		//test_names[2] = "exampleTest";
		
		
		return test_names;
	}
	
	@Test
	public void iteratorMethodsExceptionTests(){
		

		Picture p1 = new PictureImpl(15,10);
		Pixel red = new ColorPixel(1,0,0);
		
		//for sample test
		p1.setPixel(1, 1, red);
		p1.setPixel(2, 3, red);
		p1.setPixel(5, 3, red);
		p1.setPixel(8, 3, red);
		p1.setPixel(11, 3, red);
		p1.setPixel(14, 3, red);
		p1.setPixel(2, 7, red);
		p1.setPixel(5, 7, red);
		p1.setPixel(8, 7, red);
		p1.setPixel(11, 7, red);
		p1.setPixel(14, 7, red);

		
	
		try{
			p1.sample(0,0,-1,-1);

		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		try{
			p1.window(-1,-1);
			
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		try{
			
			p1.tile(-1,-1);


		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		
		//Sample test
		try{
			Iterator<Pixel> pic1 = p1.sample(2,3,3,4);
			for(int x = 0; x < 15; x ++)
			{
				assertEquals("Iterator Pixel tests",
						pic1.next(), red);
			}


		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		
		
		


	}
	
	@Test
	public void iteratorTests()
	{
		Picture p = new PictureImpl(3,3);

		Iterator<Pixel> pic = p.iterator();
		
		Pixel green = new ColorPixel(0,1,0);
		Pixel blue = new ColorPixel(0,0,1);
		Pixel red = new ColorPixel(1,0,0);
		
		p.setPixel(0,0, green);
		p.setPixel(1,0, green);
		p.setPixel(2,0, green);
		p.setPixel(0,1, blue);
		p.setPixel(1,1, red);
		p.setPixel(2,1, blue);
		p.setPixel(0,2, red);
		p.setPixel(1,2, red);
		p.setPixel(2,2, red);
		
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
			assertEquals("Iterator Pixel tests",
					pic.next(), p.getPixel(y,x));
			if(x != 2)
			{
			assertEquals("In Bounds",
					pic.hasNext(), true);
			}
			}
		}
		assertEquals("Out of Bounds check",
				pic.hasNext(), false);
		

	}
	
	
	
}

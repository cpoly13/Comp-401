package a5.jmbrowne;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;
import a6novice.GrayPixel;

public class A6JediTest 
{
		
	static public String[] getTestNames() 
	{
		String[] test_names = new String[2];
		
		test_names[0] = "exampleTest";
		test_names[1] = "zigZagTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() 
	{
	}
	
	@Test
	public void zigZagTest() //tests an iterator produced by the zigzag method
	{
		PictureImpl p = new PictureImpl(10,10);
		for(int i=0; i<10; i++) //assigns random gray pixels to the elements of the test picture
		{
			for(int j=0; j<10; j++)
			{
				p.setPixel(i, j, new a6jedi.GrayPixel(Math.random()));
			}
		}
		
		Iterator<Pixel> zigzag_iter = p.zigzag();
		
		assertEquals(p.getPixel(0, 0),zigzag_iter.next());
		assertEquals(p.getPixel(1, 0),zigzag_iter.next());
		assertEquals(p.getPixel(0, 1),zigzag_iter.next());
		assertEquals(p.getPixel(0, 2),zigzag_iter.next());
		assertEquals(p.getPixel(1, 1),zigzag_iter.next());
	}
}

package a5.yibei;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import a6adept.*;

public class A6AdeptTest 
{
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	static public String[] getTestNames() 
	{
		String[] test_names = new String[3];

		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";
		test_names[2] = "tileTest";
		return test_names;
	}


	public void fillPicture(Picture p)
	{
		int counter = 0;

		for(int i = 0; i < p.getWidth(); i++)
		{
			for(int j = 0; j < p.getHeight(); j++)
			{
				if(counter++ == 0)
					p.setPixel(i, j, RED);
				else if(counter++ == 1)
					p.setPixel(i, j, GREEN);
				else if(counter++ == 2)
					p.setPixel(i, j, BLUE);
				else if(counter++ == 3)
					p.setPixel(i, j, WHITE);
				else if(counter++ == 4)
					p.setPixel(i, j, BLACK);

				if(counter > 4)
					counter = 0;

			}
		}
		/*for(Pixel i: p)
		{
			System.out.println(i);
		}*/
	}

	@Test
	public void sampleTest() 
	{
		Picture p = new PictureImpl(15,10);
		fillPicture(p);
		Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
		Pixel test;
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(2,3));
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(5,3));
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(8,3));
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(11,3));
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(14,3));
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(2,7));
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(5,7));
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(8,7));
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(11,7));
		test = sample_iter.next();
		assertEquals("Pixel not equal", test, p.getPixel(14,7));
	}
	//(2,3) (5,3) (8,3) (11,3) (14,3) (2,7) (5,7) (8,7) (11, 7) (14, 7)
	@Test
	public void windowTest()
	{
		Picture p = new PictureImpl(5,5);
		fillPicture(p);
		Iterator<SubPicture> window_iter = p.window(3, 2);
		SubPicture expected;

		expected = window_iter.next();
		assertEquals("wrong x",0,expected.getXOffset());
		assertEquals("wrong y",0,expected.getYOffset());

		expected = window_iter.next();
		assertEquals("wrong x",1,expected.getXOffset());
		assertEquals("wrong y",0,expected.getYOffset());
		expected = window_iter.next();
		assertEquals("wrong x",2,expected.getXOffset());
		assertEquals("wrong y",0,expected.getYOffset());
		expected = window_iter.next();
		assertEquals("wrong x",0,expected.getXOffset());
		assertEquals("wrong y",1,expected.getYOffset());
		expected = window_iter.next();
		assertEquals("wrong x",1,expected.getXOffset());
		assertEquals("wrong y",1,expected.getYOffset());
		expected = window_iter.next();
		assertEquals("wrong x",2,expected.getXOffset());
		assertEquals("wrong y",1,expected.getYOffset());
		expected = window_iter.next();
		assertEquals("wrong x",0,expected.getXOffset());
		assertEquals("wrong y",2,expected.getYOffset());
		// (xOffset,YOffset, width, height);
		expected = window_iter.next();
		assertEquals("wrong x",1,expected.getXOffset());
		assertEquals("wrong y",2,expected.getYOffset());
		expected = window_iter.next();
		assertEquals("wrong x",2,expected.getXOffset());
		assertEquals("wrong y",2,expected.getYOffset());
		expected = window_iter.next();
		assertEquals("wrong x",0,expected.getXOffset());
		assertEquals("wrong y",3,expected.getYOffset());
		expected = window_iter.next();
		assertEquals("wrong x",1,expected.getXOffset());
		assertEquals("wrong y",3,expected.getYOffset());
		expected = window_iter.next();
		assertEquals("wrong x",2,expected.getXOffset());
		assertEquals("wrong y",3,expected.getYOffset());

	}

	@Test
	public void tileTest()
	{
		Picture p = new PictureImpl(5,5);
		fillPicture(p);
		SubPicture expected;
		Iterator<SubPicture> tile_iter = p.tile(2, 2);
		
		expected = tile_iter.next();
		assertEquals("wrong x",0,expected.getXOffset());
		assertEquals("wrong y",0,expected.getYOffset());
		assertEquals("wrong width",2,expected.getWidth());
		assertEquals("wrong height",2,expected.getHeight());
		
		expected = tile_iter.next();
		assertEquals("wrong x",2,expected.getXOffset());
		assertEquals("wrong y",0,expected.getYOffset());
		assertEquals("wrong width",2,expected.getWidth());
		assertEquals("wrong height",2,expected.getHeight());
		
		expected = tile_iter.next();
		assertEquals("wrong x",0,expected.getXOffset());
		assertEquals("wrong y",2,expected.getYOffset());
		assertEquals("wrong width",2,expected.getWidth());
		assertEquals("wrong height",2,expected.getHeight());
		
		expected = tile_iter.next();
		assertEquals("wrong x",2,expected.getXOffset());
		assertEquals("wrong y",2,expected.getYOffset());
		assertEquals("wrong width",2,expected.getWidth());
		assertEquals("wrong height",2,expected.getHeight());
		/*
		 f.extract(0,0,2,2);
			f.extract(2,0,2,2);
			f.extract(0,2,2,2);
			f.extract(2,2,2,2);
		 */

	}
}

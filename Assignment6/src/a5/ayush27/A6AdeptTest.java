package a5.ayush27;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;
//import a6novice.Picture;
//import a6novice.PictureImpl;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";
		test_names[2] = "tileTest";

		
		return test_names;
	}
		
	@Test
	public void sampleTest() {
		Picture p = new PictureImpl(15,10);	
		Coordinate c1= new Coordinate(1,2);	
		Pixel cp = new ColorPixel(.5,.2,.1);
		p.setPixel(c1, cp);
		Iterator<Pixel> sample_iter = p.sample(2,3,3,4);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		assertTrue(sample_iter.hasNext());
		assertTrue(sample_iter.next().getGreen() == .5);
		
		
		
		
		 
	}
	
	@Test
	public void windowTest() {
		Picture p = new PictureImpl(5,5);
		Coordinate c1= new Coordinate(1,2);	
		Pixel cp = new ColorPixel(.5,.2,.1);
		p.setPixel(c1, cp);
		Iterator<SubPicture> window_iter = p.window(3, 2);
		assertSame(window_iter.next().getPixel(1,1), p.extract(0,0,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(1,0,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(2,0,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(0,1,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(1,1,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(2,1,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(0,2,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(1,2,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(2,2,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(0,3,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(1,3,3,2).getPixel(1,1));
		assertSame(window_iter.next().getPixel(1,1), p.extract(2,3,3,2).getPixel(1,1));
		
		
		
		
	}
	
	@Test
	public void tileTest() {
		Picture p = new PictureImpl(5,5);
		Iterator<SubPicture> tile_iter = p.tile(2, 2);
		assertSame(tile_iter.next().getPixel(1,1), p.extract(0,0,2,2).getPixel(1,1));
		assertSame(tile_iter.next().getPixel(1,1), p.extract(0,2,2,2).getPixel(1,1));
		assertSame(tile_iter.next().getPixel(1,1), p.extract(2,0,2,2).getPixel(1,1));
		assertSame(tile_iter.next().getPixel(1,1), p.extract(2,2,2,2).getPixel(1,1));
		
    }
}
	

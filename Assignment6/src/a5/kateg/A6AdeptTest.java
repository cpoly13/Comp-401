package a5.kateg;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


import a6adept.*;
import a6adept.Picture;
import a6adept.PictureImpl;

public class A6AdeptTest {
		
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "sampleIteratorTest";
		test_names[1] = "windowIteratorTest";
		test_names[2] = "tileIteratorTest";
		
		return test_names;
	}
		
	@Test
	public void sampleIteratorTest() {
		Picture p = new PictureImpl(15, 10);
		p.setPixel(2, 3, RED);
		Iterator<Pixel> sample_iter = p.sample(2,3,3,4);
		assertEquals("sample Iterator not working", sample_iter.next(), RED);
		
	}
	
	@Test
	public void windowIteratorTest(){
		Picture p = new PictureImpl(5, 5);
		p.setPixel(0, 0, GREEN);
		Iterator<SubPicture> window_iter = p.window(3, 2);
		// Can't do this because no next method for a subpicture: SubPicture z= window_iter.next();
		assertEquals("window iterator not working", window_iter.next().getPixel(0,0), GREEN);
		window_iter.next();
		window_iter.next();
		//the following will always pass because initialized to grey 
		assertEquals("window iterator not working", window_iter.next().getPixel(0,0), p.extract(0, 1,3,2).getPixel(0,0));
	// calling getPixel() on each subpicture because can't compare that two subpictures are equal
	}
	
	@Test
	public void tileIteratorTest(){
		Picture p = new PictureImpl(5, 5);
		p.setPixel(0,0, GREEN);
		p.setPixel(2,0, RED);
		p.setPixel(2,1, BLACK);
		p.setPixel(0,2, BLUE);
		p.setPixel(2,2, WHITE);
		Iterator<SubPicture> tile_iter = p.tile(2, 2);
		assertEquals("tile iterator not working", tile_iter.next().getPixel(0,0), GREEN);
		assertEquals("tile iterator not working", tile_iter.next().getPixel(0,1), BLACK);
		assertEquals("tile iterator not working", tile_iter.next().getPixel(0,0), BLUE);
		assertEquals("tile iterator not working", tile_iter.next().getPixel(0,0), WHITE);
		
	}
}

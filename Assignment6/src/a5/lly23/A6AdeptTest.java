package a5.lly23;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;
import a6adept.ColorPixel;

public class A6AdeptTest {
	Pixel r = new ColorPixel(0.5, 0, 0);
	Pixel g = new ColorPixel(0, 0.5, 0);
	Pixel b = new ColorPixel(0, 0, 0.5);
	
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "testsamplehasNext";
		test_names[1] = "testsamplenext";
		test_names[2] = "testwindow";
		test_names[3] = "testtile";
		
		
		return test_names;
	}
	
	// assertEqual(" ", .getXOffset, 2, .getYOffset(), 3)
		
	@Test
	public void testsamplehasNext() {
		Picture source = new PictureImpl(15, 10);
		Iterator<Pixel> sample = source.sample(2, 3, 3, 4);
		
		assertTrue(sample.hasNext());
	}
	
	@Test
	public void testsamplenext() {
		Picture source = new PictureImpl(15, 10);
		Iterator<Pixel> sample = source.sample(2, 3, 3, 4);
		
		assertEquals("x and y are not within range of width and height", source.getPixel(2, 3), sample.next());
	}
	
	@Test
	public void testwindow() {
		Picture source = new PictureImpl(5, 5);
		Iterator<SubPicture> window = source.window(3, 2);
		
		assertEquals("Window does not slide properly", source.extract(0, 0, 3, 2).getXOffset(), 
				window.next().getXOffset());
		assertEquals("Window does not slide properly", source.extract(0, 0, 3, 2).getYOffset(), 
				window.next().getYOffset());
		assertEquals("Window does not slide properly", source.extract(0, 0, 3, 2).getHeight(), 
				window.next().getHeight());
		assertEquals("Window does not slide properly", source.extract(0, 0, 3, 2).getWidth(), 
				window.next().getWidth());
	}
	
	@Test
	public void testtile() {
		Picture source = new PictureImpl(5, 5);
		Iterator<SubPicture> tile = source.tile(2, 2);
		
		assertEquals("Tiles are not placed correctly", source.extract(0, 0, 2, 2).getXOffset(), 
				tile.next().getXOffset());
		assertEquals("Tiles are not placed correctly", source.extract(0, 0, 2, 2).getYOffset(), 
				tile.next().getYOffset());
		assertEquals("Tiles are not placed correctly", source.extract(0, 0, 2, 2).getHeight(), 
				tile.next().getHeight());
		assertEquals("Tiles are not placed correctly", source.extract(0, 0, 2, 2).getWidth(), 
				tile.next().getWidth());
	}
}

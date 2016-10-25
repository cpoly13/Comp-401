package a5.jeroen;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

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
		Picture p1 = new PictureImpl(15,10);		
		Iterator<Pixel> sample_iter = p1.sample(2, 3, 3, 4);
		
		for (int x=0; x<p1.getWidth(); x++){
			for (int y=0; y<p1.getHeight(); y++){
				p1.setPixel(x, y, randomPixel());
			}
		}
		
		try {
			@SuppressWarnings("unused")
			Iterator<Pixel> sample_iter2 = p1.sample(20, 30, 3, 4);
			fail("Expected IllegalArgumentException for int_x and/or init_y out of bounds.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		try {
			@SuppressWarnings("unused")
			Iterator<Pixel> sample_iter3 = p1.sample(2, 3, -3, -4);
			fail("Expected IllegalArgumentException for dx and/or dy not positive.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		assertEquals("Sample itinerator returned wrong pixel",
				sample_iter.next().equals(p1.getPixel(2, 3)),true);

		assertEquals("Sample itinerator returned wrong pixel",		
				sample_iter.next().equals(p1.getPixel(5, 3)),true);

		assertEquals("Sample itinerator returned wrong pixel",		
				sample_iter.next().equals(p1.getPixel(8, 3)),true);

		assertEquals("Sample itinerator returned wrong pixel",		
				sample_iter.next().equals(p1.getPixel(11, 3)),true);

		assertEquals("Sample itinerator returned wrong pixel",		
				sample_iter.next().equals(p1.getPixel(14, 3)),true);

		assertEquals("Sample itinerator returned wrong pixel",		
				sample_iter.next().equals(p1.getPixel(2, 7)),true);

		assertEquals("Sample itinerator returned wrong pixel",		
				sample_iter.next().equals(p1.getPixel(5, 7)),true);

		assertEquals("Sample itinerator returned wrong pixel",		
				sample_iter.next().equals(p1.getPixel(8, 7)),true);

		assertEquals("Sample itinerator returned wrong pixel",		
				sample_iter.next().equals(p1.getPixel(11, 7)),true);
		
		Iterator<Pixel> sample_iter2 = p1.sample(0, 0, 1, 1);
		
		for (int x=0; x<150; x++) {
			sample_iter2.next();
		}
		
		assertEquals("Sample Iterator hasNext broken",
				sample_iter2.hasNext(),false);
	}
	
	@Test
	public void windowTest(){	
		Picture p2 = new PictureImpl(5,5);
		Iterator<SubPicture> window_iter = p2.window(3, 2);
		
		for (int x=0; x<p2.getWidth(); x++){
			for (int y=0; y<p2.getHeight(); y++){
				p2.setPixel(x, y, randomPixel());
			}
		}
		
		try {
			@SuppressWarnings("unused")
			Iterator<SubPicture> window_iter2 = p2.window(10,10);
			fail("Expected IllegalArgumentException for window_width and/or window_height bigger than picture width/height.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		try {
			@SuppressWarnings("unused")
			Iterator<SubPicture> window_iter3 = p2.window(-3,-2);
			fail("Expected IllegalArgumentException for window_width and/or window_height not positive.");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		assertEquals("Window itinerator doesn't work right",	
				isTheSamePicture(window_iter.next(),p2.extract(0, 0, 3, 2)), true);
		
		assertEquals("Window itinerator doesn't work right",	
				isTheSamePicture(window_iter.next(),p2.extract(1, 0, 3, 2)), true);

		assertEquals("Window itinerator doesn't work right",	
				isTheSamePicture(window_iter.next(),p2.extract(2, 0, 3, 2)), true);
		
		assertEquals("Window itinerator doesn't work right",	
				isTheSamePicture(window_iter.next(),p2.extract(0, 1, 3, 2)), true);
	}
	
	@Test
	public void tileTest(){
		Picture p3 = new PictureImpl(5,5);
		Iterator<SubPicture> tile_iter = p3.tile(2, 2);
		
		for (int x=0; x<p3.getWidth(); x++){
			for (int y=0; y<p3.getHeight(); y++){
				p3.setPixel(x, y, randomPixel());
			}
		}
		
		try {
			@SuppressWarnings("unused")
			Iterator<SubPicture> tile_iter2 = p3.tile(6,6);
			fail("Expected IllegalArgumentException for tile_width and/or tile_height bigger than picture width/height");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		try {
			@SuppressWarnings("unused")
			Iterator<SubPicture> tile_iter3 = p3.tile(-2,-2);
			fail("Expected IllegalArgumentException for tile_width and/or tile_height not positive");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}
		
		assertEquals("Tile itinerator doesn't work right",	
				isTheSamePicture(tile_iter.next(),p3.extract(0, 0, 2, 2)), true);
		
		assertEquals("Tile itinerator doesn't work right",	
				isTheSamePicture(tile_iter.next(),p3.extract(2, 0, 2, 2)), true);
		
		assertEquals("Tile itinerator doesn't work right",	
				isTheSamePicture(tile_iter.next(),p3.extract(0, 2, 2, 2)), true);
		
		assertEquals("Tile itinerator doesn't work right",	
				isTheSamePicture(tile_iter.next(),p3.extract(2, 2, 2, 2)), true);
	}
	
	public static boolean isTheSamePicture(Picture p1, Picture p2){
		if (p1==null||p2==null){
			throw new IllegalArgumentException("Pics null");
		} else if (p1.getWidth()!=p2.getWidth()||p1.getHeight()!=p2.getHeight()) {
			return false;
		} else {
			boolean theSame=true;
			for (int x=0; x<p1.getWidth(); x++) {
				for (int y=0; y<p1.getHeight(); y++) {
					if (!p1.getPixel(x, y).equals(p2.getPixel(x, y))) {
						theSame=false;
					}
				}
			}
		return theSame;
		}
	}
	
	public static Pixel randomPixel() {
		return new ColorPixel(Math.random(), Math.random(),Math.random());
	}
}

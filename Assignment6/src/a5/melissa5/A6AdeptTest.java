package a5.melissa5;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "testSampleMethod";
		test_names[1] = "testSubPictureIterators";
		
		return test_names;
	}
		
	@Test
	public void testSampleMethod() {
		Picture p = new PictureImpl(15,10);
		p.setPixel(new Coordinate(2,3), RED);
		p.setPixel(new Coordinate(5,3), GREEN);
		p.setPixel(new Coordinate(8,3), BLUE);
		p.setPixel(new Coordinate(11,3), WHITE);
		p.setPixel(new Coordinate(14,3), BLACK);
		p.setPixel(new Coordinate(2,7), RED);
		p.setPixel(new Coordinate(5,7), BLUE);
		p.setPixel(new Coordinate(8,7), RED);
		p.setPixel(new Coordinate(11,7), GREEN);
		p.setPixel(new Coordinate(14,7), BLACK);
		Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
		
		assertEquals(sample_iter.next(),p.getPixel(2,3));
		assertEquals(sample_iter.next(),p.getPixel(5,3));
		assertEquals(sample_iter.next(),p.getPixel(8,3));
		assertEquals(sample_iter.next(),p.getPixel(11,3));
		assertEquals(sample_iter.next(),p.getPixel(14,3));
		assertEquals(sample_iter.next(),p.getPixel(2,7));
		assertEquals(sample_iter.next(),p.getPixel(5,7));
		assertEquals(sample_iter.next(),p.getPixel(8,7));
		assertEquals(sample_iter.next(),p.getPixel(11,7));
		assertEquals(sample_iter.next(),p.getPixel(14,7));
	}
	
	@Test
	public void testSubPictureIterators() {
		Picture p = new PictureImpl(5,5);
		Iterator<SubPicture> window_iter = p.window(3,2);
		assertEquals(window_iter.next().getPixel(0, 0), p.extract(0,0,3,2).getPixel(0,0));
		
		
		Iterator<SubPicture> tile_iter = p.tile(2, 2);
		assertEquals(tile_iter.next().getPixel(2, 2), p.extract(0,0,2,2).getPixel(2,2));
	}
}


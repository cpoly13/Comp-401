package a5.amyrose9;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "testCoordinateConstruction";
		test_names[1] = "testCoordinateSetAndGetPixel";
		test_names[2] = "coordinateExtractTest";
		test_names[3] = "pictureIteratorConstructor";
		test_names[4] = "pictureIteratorTest";
		
		return test_names;
	}
		
	@Test
	public void testCoordinateConstruction() {
		Coordinate c = new Coordinate(2, 5);
		assertEquals(2, c.getX(), 0.001);
		assertEquals(5, c.getY(), 0.001);
	}
	
	@Test
	public void testCoordinateSetAndGetPixel() {
		Coordinate c = new Coordinate(-5, 0);
		
		Picture p = new PictureImpl(5,5);
		try {
			p.getPixel(c);
			fail("Expected exception for getPixel if x < 0");
		} catch(RuntimeException e) {
		} catch(Exception e) {
			fail("Runtime exception expected");
		}
		
		c = new Coordinate(1, 1);
		
		Pixel a = (Pixel)(new GrayPixel(0.5));
		compare_pixels(a, p.getPixel(0, 0));
	}
	
	@Test
	public void coordinateExtractTest() {
		Picture p = new PictureImpl(3, 3);
		p.setPixel(0, 0, new GrayPixel(0.2));
		p.setPixel(1, 0, new ColorPixel(0.1, 0.8, 1));
		p.setPixel(2, 0, new GrayPixel(0.30));
		p.setPixel(0, 1, new ColorPixel(0.01, 0.5, 0.4));
		p.setPixel(1, 1, new GrayPixel(0.67));
		p.setPixel(2, 1, new GrayPixel(0.75));
		p.setPixel(0, 2, new GrayPixel(0.90));
		p.setPixel(1, 2, new ColorPixel(0.1, 0.1, 0.25));
		
		Coordinate a = new Coordinate(1, 1);
		Coordinate b = new Coordinate(2, 2);
		
		SubPicture sp = p.extract(a, b);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 1), sp.getPixel(0, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 1), sp.getPixel(1, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 2), sp.getPixel(0, 1));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp.getPixel(1, 1));
		
		SubPicture sp2 = sp.extract(a, a);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp2.getPixel(0, 0));
	}
	
	@Test
	public void pictureIteratorConstructor() {
		Picture p = new PictureImpl(3, 3);
		
		try {
			Iterator<Pixel> i = p.iterator();
		} catch(Exception e) {
			fail("Error occurred when making an iterator");
		}
	}
	
	@Test
	public void pictureIteratorTest() {
		Picture p = new PictureImpl(3, 3);
		p.setPixel(0, 0, new GrayPixel(0.2));
		p.setPixel(1, 0, new ColorPixel(0.1, 0.8, 1));
		p.setPixel(2, 0, new GrayPixel(0.30));
		p.setPixel(0, 1, new ColorPixel(0.01, 0.5, 0.4));
		p.setPixel(1, 1, new GrayPixel(0.67));
		p.setPixel(2, 1, new GrayPixel(0.75));
		p.setPixel(0, 2, new GrayPixel(0.90));
		p.setPixel(1, 2, new ColorPixel(0.1, 0.1, 0.25));
		
		Iterator<Pixel> i = p.iterator();
		
		compare_pixels(i.next(), new GrayPixel(0.2));
		compare_pixels(i.next(), new ColorPixel(0.1, 0.8, 1));
		compare_pixels(i.next(), new GrayPixel(0.30));
		compare_pixels(i.next(), new ColorPixel(0.01, 0.5, 0.4));
		compare_pixels(i.next(), new GrayPixel(0.67));
		compare_pixels(i.next(), new GrayPixel(0.75));
		compare_pixels(i.next(), new GrayPixel(0.90));
		compare_pixels(i.next(), new ColorPixel(0.1, 0.1, 0.25));
		compare_pixels(i.next(), new GrayPixel(0.5));
		
		try {
			i.next();
			fail("Exception not caught when no elements remaining");
		} catch(NoSuchElementException e) {
		} catch(Exception e) {
			fail("Wrong exception caught");
		}
	}
	
	private static boolean compare_pixels(Pixel a, Pixel b) {
		assertEquals(a.getRed(), b.getRed(), 0.001);
		assertEquals(a.getGreen(), b.getGreen(), 0.001);
		assertEquals(a.getBlue(), b.getBlue(), 0.001);
		return true;
	}
}

package a5.benji3;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;
import a6novice.Coordinate;

public class A6NoviceTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "getCoordinatePixel";
	    test_names[1] = "setCoordinatePixel";
	    test_names[2] = "coordinateExtract";
	    test_names[3] = "iteratorTest";
	    test_names[4] = "constructorTest";
		
		return test_names;
	}
		
	@Test
	public void getCoordinatePixel() {
		
		Picture a = new PictureImpl(4,4);
		Coordinate c = new Coordinate(3,2);
		
		a.setPixel(0, 0, RED);
		a.setPixel(1, 0, RED);
		a.setPixel(2, 0, RED);
		a.setPixel(0, 1, GREEN);
		a.setPixel(1, 1, BLUE);
		a.setPixel(2, 1, WHITE);
		a.setPixel(0, 2, BLACK);
		a.setPixel(1, 2, BLACK);
		a.setPixel(2, 2, RED);
		a.setPixel(3, 0, BLACK);
		a.setPixel(3, 1, RED);
		a.setPixel(3, 2, WHITE);
		a.setPixel(3, 3, RED);
		
		// Using the overloaded getPixel method that takes a coordinate.
		
		assertEquals("Result from getPixel(Coordinate c) does not match source picture",
				WHITE, a.getPixel(c));
	}
	
	@Test
	public void setCoordinatePixel() {
		Picture a = new PictureImpl(4,4);
		Coordinate c = new Coordinate(1,1);
		
		a.setPixel(0, 0, RED);
		a.setPixel(1, 0, RED);
		a.setPixel(2, 0, RED);
		a.setPixel(0, 1, GREEN);
		a.setPixel(1, 1, BLUE);
		a.setPixel(2, 1, WHITE);
		a.setPixel(0, 2, BLACK);
		a.setPixel(1, 2, BLACK);
		a.setPixel(2, 2, RED);
		a.setPixel(3, 0, BLACK);
		a.setPixel(3, 1, RED);
		a.setPixel(3, 2, WHITE);
		a.setPixel(3, 3, RED);
		
		// Using the overloaded setPixel method that takes a coordinate.
		
		a.setPixel(c, WHITE);;
		
		assertEquals("Result from setPixel(Coordinate c) does not match source picture",
				WHITE, a.getPixel(c));
		
	}
	
	// Testing extract method that uses two coordinates to find its width, height, and offsets.
	
	@Test
	public void coordinateExtract() {
		
		Picture p = new PictureImpl(5, 5);
		Coordinate a = new Coordinate(2,2);
		Coordinate b = new Coordinate(4,4);
		SubPicture littleP = p.extract(a, b);
		
		assertEquals(3,littleP.getWidth());
	}
	
	@Test
	public void iteratorTest() {
		Picture p = new PictureImpl(6,5);
		Iterator<Pixel> iter = p.iterator();
		Pixel f = new ColorPixel(0,0,0);
		while (iter.hasNext()) {
			Pixel thePixel = iter.next();
			for (int i = 0; i < p.getWidth(); i++) {
				for (int j = 0; j < p.getHeight(); j++) {
					f = p.getPixel(i,j);
				}
			}
			assertEquals(f, thePixel);
		}
	}
	
	@Test
	public void constructorTest() {
		Coordinate c = new Coordinate(6, 3);
		
		assertEquals("Pixel retrieved after setting does not match expected value.", 6, c.getX());
		assertEquals("Pixel retrieved after setting does not match expected value.", 3, c.getY());
		
	}
	
}

package a5.jonlh;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "testCoordinateGettersAndSetters";
		test_names[1] = "testCoordinateExtract";
		test_names[2] = "testRowMajorPixelIterator";
		
		
		return test_names;
	}
	
	@Test
	public void testCoordinateGettersAndSetters()
	{
		PictureImpl p = new PictureImpl(4,4);
		Coordinate a = new Coordinate(0,0);
		Coordinate b = new Coordinate(1,1);
		Coordinate c = new Coordinate(2,3);
		Coordinate d = new Coordinate(3,1);
		Coordinate e = new Coordinate(3,2);
		
		p.setPixel(a, RED);
		p.setPixel(b, BLUE);
		p.setPixel(c, GREEN);
		p.setPixel(d, p.getPixel(c));
		p.setPixel(e, p.getPixel(a));
		p.setPixel(new Coordinate (c.getX(),  b.getY()), p.getPixel(b));
		p.setPixel(new Coordinate (a.getX(),  e.getY()), BLACK);
		
		assertEquals("Picture does not meet expected value", p.getPixel(a), RED);
		assertEquals("Picture does not meet expected value", p.getPixel(b), BLUE);
		assertEquals("Picture does not meet expected value", p.getPixel(c), GREEN);
		assertEquals("Picture does not meet expected value", p.getPixel(d), GREEN);
		assertEquals("Picture does not meet expected value", p.getPixel(e), RED);
		assertEquals("Picture does not meet expected value", p.getPixel(2,1), BLUE);
		assertEquals("Picture does not meet expected value", p.getPixel(0,2), BLACK);
	}
	
	@Test
	public void testCoordinateExtract()
	{
		Picture p = new PictureImpl(3, 3);
		Coordinate a = new Coordinate(1,1);
		Coordinate b = new Coordinate(1,2);
		Coordinate c = new Coordinate(2,1);
		Coordinate d = new Coordinate(2,2);
		
		p.setPixel(a, RED);
		p.setPixel(b, GREEN);
		p.setPixel(c, BLUE);
		p.setPixel(d, WHITE);
		
		SubPicture sp = p.extract(1, 1, 2, 2);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 1), sp.getPixel(0, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 1), sp.getPixel(1, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 2), sp.getPixel(0, 1));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp.getPixel(1, 1));
		
		SubPicture sp2 = sp.extract(1, 1, 1, 1);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp2.getPixel(0, 0));
	}
	
	@Test
	public void testRowMajorPixelIterator()
	{
		Picture p = new PictureImpl(2, 2);
		Iterator<Pixel> iter = p.iterator();
		assertEquals(iter.next(), p.getPixel(0,0));
	}
	
	
}
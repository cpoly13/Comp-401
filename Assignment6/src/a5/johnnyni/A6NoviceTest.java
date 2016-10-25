package a5.johnnyni;

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
		String[] test_names = new String[4];
		
		test_names[0] = "coordinateConstructorTest";
		test_names[1] = "pictureGetAndSetPixelTest";
		test_names[2] = "subPictureExtractTest";
		test_names[3] = "iteratorTest";
		
		return test_names;
	}
		
	@Test
	public void coordinateConstructorTest() {
		Coordinate c = new Coordinate(1, 2);
		assertEquals(1, c.getX());
		assertEquals(2, c.getY());
	}
	
	@Test
	public void pictureGetAndSetPixelTest() {
		Coordinate c = new Coordinate(3, 4);
		Picture p = new PictureImpl(5,7);
		Pixel a = new ColorPixel(0.1, 0.4, 0.8);
		p.setPixel(c, a);
		compare_pixels(a, p.getPixel(c));
	}
	
	@Test
	public void subPictureExtractTest() {
		Picture p = new PictureImpl(3, 3);
		p.setPixel(0, 0, RED);
		p.setPixel(1, 0, RED);
		p.setPixel(2, 0, RED);
		p.setPixel(0, 1, GREEN);
		p.setPixel(1, 1, BLUE);
		p.setPixel(2, 1, WHITE);
		p.setPixel(0, 2, BLACK);
		p.setPixel(1, 2, BLACK);
		p.setPixel(2, 2, RED);
		
		Coordinate x = new Coordinate(1,1);
		Coordinate y = new Coordinate(2,2);
		SubPicture sp = p.extract(x,y);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 1), sp.getPixel(0, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 1), sp.getPixel(1, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(1, 2), sp.getPixel(0, 1));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp.getPixel(1, 1));
		
		SubPicture sp2 = sp.extract(x,x);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				p.getPixel(2, 2), sp2.getPixel(0, 0));
	}
	
	@Test
	public void iteratorTest() {
		Picture p = new PictureImpl(2,2);
		Iterator<Pixel> iter = p.iterator();
		assertEquals(p.getPixel(0, 0), iter.next());
		assertEquals(p.getPixel(0, 1), iter.next());
		assertEquals(p.getPixel(1, 0), iter.next());
		assertEquals(p.getPixel(1, 1), iter.next());
	}
	
	private static boolean compare_pixels(Pixel a, Pixel b) {
		assertEquals(a.getRed(), b.getRed(), 0.001);
		assertEquals(a.getGreen(), b.getGreen(), 0.001);
		assertEquals(a.getBlue(), b.getBlue(), 0.001);
		return true;
	}
}

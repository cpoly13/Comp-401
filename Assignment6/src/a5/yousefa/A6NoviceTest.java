package a5.yousefa;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel GREEN = new ColorPixel(0, 1, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
	private static final Coordinate C0 = new Coordinate(0, 0);
	private static final Coordinate C1 = new Coordinate(1, 0);
	private static final Coordinate C2 = new Coordinate(0, 1);
	private static final Coordinate C3 = new Coordinate(1, 1);

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "testGetSetPixelByCoord";
		test_names[1] = "IteratorTest";

		return test_names;
	}

	@Test
	public void GetSetPixelByCoordTest() {
		Picture p = new PictureImpl(2, 2);

		p.setPixel(C0, RED);
		p.setPixel(C1, GREEN);
		p.setPixel(C2, BLUE);
		p.setPixel(C3, WHITE);

		assertEquals("Unexpected Pixel value gotten.", p.getPixel(C0), RED);
		assertEquals("Unexpected Pixel value gotten.", p.getPixel(C1), GREEN);
		assertEquals("Unexpected Pixel value gotten.", p.getPixel(C2), BLUE);
		assertEquals("Unexpected Pixel value gotten.", p.getPixel(C3), WHITE);

	}

	@Test
	public void IteratorTest() {
		Picture p = new PictureImpl(2, 2);
		Iterator<Pixel> iter = p.iterator();

		assertEquals("Unexpected Pixel value gotten.", p.getPixel(C0), iter.next());
		assertEquals("Unexpected Pixel value gotten.", p.getPixel(C1), iter.next());
		assertEquals("Unexpected Pixel value gotten.", p.getPixel(C2), iter.next());
		assertEquals("Unexpected Pixel value gotten.", p.getPixel(C3), iter.next());
	}
	
}

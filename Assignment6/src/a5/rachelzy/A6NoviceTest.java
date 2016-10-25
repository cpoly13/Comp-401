package a5.rachelzy;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;


public class A6NoviceTest {

	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	static public String[] getTestNames() {
		String[] test_names = new String[5];

		test_names[0] = "testPictureImplPixelGettersAndSetters";
		test_names[1] = "testExtract";
		test_names[2] = "testBadExtractParameter";
		test_names[3] = "testIterator";
		test_names[4] = "textIteratorExceptions";

		return test_names;
	}

	//	@Test
	//	public void exampleTest() {
	//	}

	@Test
	public void testPictureImplPixelGettersAndSetters() {
		Picture pic = new PictureImpl(3, 3);
		Coordinate c1 = new Coordinate(4,0);
		Coordinate c2 = new Coordinate(0,4);
		try {
			pic.setPixel(c1, BLACK);
			fail("Expected IllegalArgumentException for x greater than picture width");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		try {
			pic.setPixel(c2, BLACK);
			fail("Expected IllegalArgumentException for y greater than picture width");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		try {
			pic.getPixel(c1);
			fail("Expected IllegalArgumentException for x greater than picture width");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		try {
			pic.getPixel(c2);
			fail("Expected IllegalArgumentException for x greater than picture width");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
	}

	@Test
	public void testExtract() {
		Picture pic = new PictureImpl(3, 3);
		Coordinate c1 = new Coordinate(0,0);
		Coordinate c2 = new Coordinate(1,0);
		Coordinate c3 = new Coordinate(2,0);
		Coordinate c4 = new Coordinate(0,1);
		Coordinate c5 = new Coordinate(1,1);
		Coordinate c6 = new Coordinate(2,1);
		Coordinate c7 = new Coordinate(0,2);
		Coordinate c8 = new Coordinate(1,2);
		Coordinate c9 = new Coordinate(2,2);
		pic.setPixel(c1, RED);
		pic.setPixel(c2, RED);
		pic.setPixel(c3, RED);
		pic.setPixel(c4, GREEN);
		pic.setPixel(c5, BLUE);
		pic.setPixel(c6, WHITE);
		pic.setPixel(c7, BLACK);
		pic.setPixel(c8, BLACK);
		pic.setPixel(c9, RED);

		SubPicture sp1 = pic.extract(c5, c9);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				sp1.getPixel(c1), pic.getPixel(c5));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				sp1.getPixel(c2), pic.getPixel(c6));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				sp1.getPixel(c4), pic.getPixel(c8));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				sp1.getPixel(c5), pic.getPixel(c9));

		SubPicture sp2 = pic.extract(c1, c5);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				sp2.getPixel(c1), pic.getPixel(c1));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				sp2.getPixel(c5), pic.getPixel(c5));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				sp2.getPixel(c2), pic.getPixel(c2));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				sp2.getPixel(c4), pic.getPixel(c4));
	}

	@Test
	public void testBadExtractParameter() {
		Picture pic = new PictureImpl(3, 3);
		Coordinate c = new Coordinate(1, 1);
		Coordinate e1 = new Coordinate(0, 3);
		Coordinate e2 = new Coordinate(-1, 0);
		Coordinate e3 = new Coordinate(0, -1);
		try {
			pic.extract(e1, c);
			fail("Expected IllegalArgumentException for y coordinate out of bounds");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		try {
			pic.extract(c, e1);
			fail("Expected IllegalArgumentException for x coordinate out of bounds");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		try {
			pic.extract(c, e2);
			fail("Expected IllegalArgumentException for x coordinate less than zero");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
		try {
			pic.extract(e2, c);
			fail("Expected IllegalArgumentException for y coordinate less than zero");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
		}
	}

	@Test
	public void testIterator(){
		Picture pic = new PictureImpl(3, 3);
		Coordinate c1 = new Coordinate(0,0);
		Coordinate c2 = new Coordinate(1,0);
		Coordinate c3 = new Coordinate(2,0);
		Coordinate c4 = new Coordinate(0,1);
		Coordinate c5 = new Coordinate(1,1);
		Coordinate c6 = new Coordinate(2,1);
		Coordinate c7 = new Coordinate(0,2);
		Coordinate c8 = new Coordinate(1,2);
		Coordinate c9 = new Coordinate(2,2);
		pic.setPixel(c1, RED);
		pic.setPixel(c2, RED);
		pic.setPixel(c3, RED);
		pic.setPixel(c4, GREEN);
		pic.setPixel(c5, BLUE);
		pic.setPixel(c6, WHITE);
		pic.setPixel(c7, BLACK);
		pic.setPixel(c8, BLACK);
		pic.setPixel(c9, RED);

		Iterator<Pixel> ipix = pic.iterator();
		Pixel pix00 = ipix.next();
		Pixel pix10 = ipix.next();
		Pixel pix20 = ipix.next();
		Pixel pix01 = ipix.next();
		Pixel pix11 = ipix.next();
		Pixel pix21 = ipix.next();
		Pixel pix02 = ipix.next();
		Pixel pix12 = ipix.next();
		Pixel pix22 = ipix.next();

		assertEquals("Pixel does not match source",
				pic.getPixel(c1), pix00);
		assertEquals("Pixel does not match source",
				pic.getPixel(c2), pix10);
		assertEquals("Pixel does not match source",
				pic.getPixel(c3), pix20);
		assertEquals("Pixel does not match source",
				pic.getPixel(c4), pix01);
		assertEquals("Pixel does not match source",
				pic.getPixel(c5), pix11);
		assertEquals("Pixel does not match source",
				pic.getPixel(c6), pix21);
		assertEquals("Pixel does not match source",
				pic.getPixel(c7), pix02);
		assertEquals("Pixel does not match source",
				pic.getPixel(c8), pix12);
		assertEquals("Pixel does not match source",
				pic.getPixel(c9), pix22);
	}
	
	@Test
	public void textIteratorExceptions(){
		Picture pic = new PictureImpl(3,3);
		try{
			Iterator<Pixel> iter = pic.iterator();
			Pixel pix00 = iter.next();
			Pixel pix10 = iter.next();
			Pixel pix20 = iter.next();
			Pixel pix01 = iter.next();
			Pixel pix11 = iter.next();
			Pixel pix21 = iter.next();
			Pixel pix02 = iter.next();
			Pixel pix12 = iter.next();
			Pixel pix22 = iter.next();
			Pixel pixnull = iter.next();
			fail("The last element does not exist");
		}catch (NoSuchElementException e) {
		}

	}


}

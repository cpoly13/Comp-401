package a5.sagarss;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;

public class A6NoviceTest {

	static public String[] getTestNames() {
		String[] test_names = new String[4];

		test_names[0] = "CoordinateConstructor";
		test_names[1] = "CoordinateConstructorExceptions";
		test_names[2] = "getterandsetter";
		test_names[3] = "SubPictureExtract";

		return test_names;
	}

	private static final Pixel r = new ColorPixel(1, 0, 0);

	@Test
	public void CoordinateConstructor() {
		Coordinate d = new Coordinate(3, 8);
		Coordinate e = new Coordinate(2, 4);
		Coordinate f = new Coordinate(1, 9);
		assertEquals(3, d.getX(), 0.001);
		assertEquals(8, d.getY(), 0.001);
		assertEquals(2, e.getX(), 0.001);
		assertEquals(4, e.getY(), 0.001);
		assertEquals(1, f.getX(), 0.001);
		assertEquals(9, f.getY(), 0.001);
	}

	@Test
	public void CoordinateConstructorExceptions() {
		Picture p = new PictureImpl(2, 2);
		Coordinate a = new Coordinate(0, 0);
		Coordinate b = new Coordinate(1, 0);
		Coordinate c = new Coordinate(0, 1);
		Coordinate d = new Coordinate(1, 1);
		p.setPixel(a, r);
		p.setPixel(b, r);
		p.setPixel(c, r);
		p.setPixel(d, r);
		try {
			SubPicture sp = new SubPictureImpl(p, 1, 1, 3, 1);
			fail("Expected IllegalArgumentException for x offset >= source width");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			SubPicture sp = new SubPictureImpl(p, 1, 1, 1, 3);
			fail("Expected IllegalArgumentException for y offset >= source height");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			SubPicture sp = new SubPictureImpl(p, 1, 1, 2, 1);
			fail("Expected IllegalArgumentException for x offset + width >= source width");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

		try {
			SubPicture sp = new SubPictureImpl(p, 1, 1, 1, 2);
			fail("Expected IllegalArgumentException for y offset + height >= source height");
		} catch (IllegalArgumentException e) {
		} catch (RuntimeException e) {
			fail("Expected IllegalArgumentException but got generic RuntimeException");
		}

	}

	@Test
	public void getterandsetter() {
		Picture p = new PictureImpl(2, 2);
		Coordinate a = new Coordinate(0, 0);
		Coordinate b = new Coordinate(1, 0);
		Coordinate c = new Coordinate(0, 1);
		Coordinate d = new Coordinate(1, 1);
		p.setPixel(a, r);
		p.setPixel(b, r);
		p.setPixel(c, r);
		p.setPixel(d, r);
		SubPicture sp1 = new SubPictureImpl(p, 1, 0, 1, 1);
		assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(b), sp1.getPixel(0, 0));
		SubPicture sp2 = new SubPictureImpl(p, 0, 1, 1, 1);
		assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(c), sp2.getPixel(0, 0));
		SubPicture sp3 = new SubPictureImpl(p, 1, 1, 1, 1);
		assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(d), sp3.getPixel(0, 0));

	}

	@Test
	public void SubPictureExtract() {
		Picture p = new PictureImpl(2, 2);
		Coordinate a = new Coordinate(0, 0);
		Coordinate b = new Coordinate(1, 0);
		Coordinate c = new Coordinate(0, 1);
		Coordinate d = new Coordinate(1, 1);
		p.setPixel(a, r);
		p.setPixel(b, r);
		p.setPixel(c, r);
		p.setPixel(d, r);
		SubPicture sp = p.extract(b, d);
		SubPicture sp2 = p.extract(a, c);
		SubPicture sp3 = p.extract(a, b);
		SubPicture sp4 = p.extract(c, d);
		assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(b), sp2.getPixel(1, 0));
		assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(c), sp3.getPixel(0, 1));
		assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(d), sp.getPixel(0, 1));
		assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(c), sp4.getPixel(0, 0));
	}

}

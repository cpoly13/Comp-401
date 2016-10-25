package a5.smganci;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

	static public String[] getTestNames() {
		String[] test_names = new String[4];

		test_names[0] = "exampleTest";
		test_names[1] = "testSetPixel";
		test_names[2] = "testGetPixel";
		test_names[3] = "testExtract";

		return test_names;
	}

	@Test
	public void exampleTest() {

	}

	@Test
	public void testSetPixel() {
		Coordinate c = new Coordinate(1, 1);
		Pixel p = new ColorPixel(0.1, 0.3, 0.5);
		Picture pic = new PictureImpl(5, 5);
		pic.setPixel(c, p);

		assertEquals("Coordinate does not set", p, pic.getPixel(1, 1));

	}

	@Test
	public void testGetPixel() {
		Coordinate c = new Coordinate(1, 1);
		Pixel p = new ColorPixel(0.1, 0.3, 0.5);
		Picture pic = new PictureImpl(5, 5);
		pic.setPixel(c, p);

		assertEquals("Coordinate does not get", p, pic.getPixel(c));

	}

	@Test

	public void testExtract() {
		Picture p = new PictureImpl(3, 3);

		Coordinate c1 = new Coordinate(1, 1);
		Coordinate c2 = new Coordinate(2, 2);

		p.setPixel(0, 0, new ColorPixel(0.1, 0.2, 0.3));
		p.setPixel(1, 0, new ColorPixel(0.2, 0.2, 0.3));
		p.setPixel(2, 0, new ColorPixel(0.3, 0.2, 0.3));
		p.setPixel(0, 1, new ColorPixel(0.4, 0.2, 0.3));
		p.setPixel(1, 1, new ColorPixel(0.5, 0.2, 0.3));
		p.setPixel(2, 1, new ColorPixel(0.6, 0.2, 0.3));
		p.setPixel(0, 2, new ColorPixel(0.7, 0.2, 0.3));
		p.setPixel(1, 2, new ColorPixel(0.8, 0.2, 0.3));
		p.setPixel(2, 2, new ColorPixel(0.9, 0.2, 0.3));

		SubPicture sp = p.extract(c1, c2);

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

}

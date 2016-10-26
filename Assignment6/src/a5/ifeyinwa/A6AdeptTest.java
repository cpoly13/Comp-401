package a5.ifeyinwa;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testSample";
	test_names[1] = "testWindow";
	test_names[2] = "testTile";

	return test_names;
    }

    @Test
    public void testSample() {

	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);

	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(2, 3)),
		sample_iter.next());
	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(5, 3)),
		sample_iter.next());
	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(8, 3)),
		sample_iter.next());
	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(11, 3)),
		sample_iter.next());
	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(14, 3)),
		sample_iter.next());
	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(2, 7)),
		sample_iter.next());
	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(5, 7)),
		sample_iter.next());
	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(8, 7)),
		sample_iter.next());
	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(11, 7)),
		sample_iter.next());
	assertEquals("Pixel extracted from sample does not match expectation.", p.getPixel(new Coordinate(14, 7)),
		sample_iter.next());

    }

    @Test
    public void testWindow() {
	Picture p = new PictureImpl(5, 5);

	Iterator<SubPicture> window_iter = p.window(3, 2);

	SubPicture sb1 = window_iter.next();
	SubPicture sb2 = window_iter.next();
	SubPicture sb3 = window_iter.next();
	SubPicture sb4 = window_iter.next();
	SubPicture sb5 = window_iter.next();
	SubPicture sb6 = window_iter.next();
	SubPicture sb7 = window_iter.next();
	SubPicture sb8 = window_iter.next();
	SubPicture sb9 = window_iter.next();
	SubPicture sb10 = window_iter.next();
	SubPicture sb11 = window_iter.next();
	SubPicture sb12 = window_iter.next();

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb1.getXOffset(), 0);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb1.getYOffset(), 0);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb1.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb1.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb2.getXOffset(), 1);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb2.getYOffset(), 0);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb2.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb2.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb3.getXOffset(), 2);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb3.getYOffset(), 0);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb3.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb3.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb4.getXOffset(), 0);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb4.getYOffset(), 1);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb4.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb4.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb5.getXOffset(), 1);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb5.getYOffset(), 1);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb5.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb5.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb6.getXOffset(), 2);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb6.getYOffset(), 1);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb6.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb6.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb7.getXOffset(), 0);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb7.getYOffset(), 2);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb7.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb7.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb8.getXOffset(), 1);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb8.getYOffset(), 2);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb8.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb8.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb9.getXOffset(), 2);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb9.getYOffset(), 2);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb9.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb9.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb10.getXOffset(), 0);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb10.getYOffset(), 3);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb10.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb10.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb11.getXOffset(), 1);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb11.getYOffset(), 3);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb11.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb11.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb12.getXOffset(), 2);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb12.getYOffset(), 3);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb12.getWidth(), 3);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb12.getHeight(), 2);
    }

    @Test
    public void testTile() {
	Picture p = new PictureImpl(5, 5);

	Iterator<SubPicture> tile_iter = p.tile(2, 2);

	SubPicture sb1 = tile_iter.next();
	SubPicture sb2 = tile_iter.next();
	SubPicture sb3 = tile_iter.next();
	SubPicture sb4 = tile_iter.next();

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb1.getXOffset(), 0);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb1.getYOffset(), 0);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb1.getWidth(), 2);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb1.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb2.getXOffset(), 2);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb2.getYOffset(), 0);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb2.getWidth(), 2);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb2.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb3.getXOffset(), 0);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb3.getYOffset(), 2);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb3.getWidth(), 2);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb3.getHeight(), 2);

	assertEquals("X Offset of retrieved SubPicture does not match expectation.", sb4.getXOffset(), 2);
	assertEquals("Y Offset of retrieved SubPicture does not match expectation.", sb4.getYOffset(), 2);
	assertEquals("Width of retrieved SubPicture does not match expectation.", sb4.getWidth(), 2);
	assertEquals("Height of retrieved SubPicture does not match expectation.", sb4.getHeight(), 2);

    }

}

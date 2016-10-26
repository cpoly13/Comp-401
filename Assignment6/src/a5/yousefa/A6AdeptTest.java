package a5.yousefa;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
    private static final Coordinate C0 = new Coordinate(0, 0);
    private static final Coordinate C1 = new Coordinate(1, 0);
    private static final Coordinate C2 = new Coordinate(0, 1);
    private static final Coordinate C3 = new Coordinate(1, 1);

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "SampleOriginTest";
	test_names[1] = "SampleCornersTest";
	test_names[2] = "SampleOffsetTest";
	test_names[2] = "tileTest";

	return test_names;
    }

    @Test
    public void SampleOriginTest() {
	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> origin_iter = p.iterator();

	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C0), origin_iter.next());
	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C1), origin_iter.next());
	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C2), origin_iter.next());
	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C3), origin_iter.next());
	assertEquals("There are no more pixels", origin_iter.hasNext(), false);

    }

    @Test
    public void SampleCornersTest() {
	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> corner_iter = p.iterator();

	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C0), corner_iter.next());
	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C1), corner_iter.next());
	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C2), corner_iter.next());
	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C3), corner_iter.next());
	assertEquals("There are no more pixels", corner_iter.hasNext(), false);

    }

    @Test
    public void SampleOffsetTest() {
	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> offset_iter = p.iterator();

	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C0), offset_iter.next());
	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C1), offset_iter.next());
	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C2), offset_iter.next());
	assertEquals("Unexpected Pixel value gotten.", p.getPixel(C3), offset_iter.next());
	assertEquals("There are no more pixels", offset_iter.hasNext(), false);

    }

    @Test
    public void tileTest() {
	Picture p = new PictureImpl(5, 5);
	Iterator<SubPicture> tile_iter = p.tile(2, 2);
	tile_iter.next();
	tile_iter.next();

	assertEquals("There is another subpicture", tile_iter.hasNext(), true);
	assertEquals("The subpictures' pixels don't match", (tile_iter.next()).getPixel(1, 1), p.getPixel(1, 3));

    }

}

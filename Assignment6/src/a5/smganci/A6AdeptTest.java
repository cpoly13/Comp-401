package a5.smganci;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "exampleTest";
	test_names[1] = "testSample";
	test_names[2] = "testHasNext";

	return test_names;
    }

    @Test
    public void exampleTest() {

    }

    @Test
    public void testSample() {
	Picture pic = new PictureImpl(15, 10);
	Iterator<Pixel> sample_iter = pic.sample(2, 3, 3, 4);
	Coordinate[] ic = new Coordinate[10];
	ic[0] = new Coordinate(2, 3);
	ic[1] = new Coordinate(5, 3);
	ic[2] = new Coordinate(8, 3);
	ic[3] = new Coordinate(11, 3);
	ic[4] = new Coordinate(14, 3);
	ic[5] = new Coordinate(2, 7);
	ic[6] = new Coordinate(5, 7);
	ic[7] = new Coordinate(8, 7);
	ic[8] = new Coordinate(11, 7);
	ic[9] = new Coordinate(14, 7);

	pic.setPixel(ic[0], new ColorPixel(0.1, 0.2, 0.3));
	pic.setPixel(ic[1], new ColorPixel(0.2, 0.2, 0.3));
	pic.setPixel(ic[2], new ColorPixel(0.3, 0.2, 0.3));
	pic.setPixel(ic[3], new ColorPixel(0.4, 0.2, 0.3));
	pic.setPixel(ic[4], new ColorPixel(0.5, 0.2, 0.3));
	pic.setPixel(ic[5], new ColorPixel(0.6, 0.2, 0.3));
	pic.setPixel(ic[6], new ColorPixel(0.7, 0.2, 0.3));
	pic.setPixel(ic[7], new ColorPixel(0.8, 0.2, 0.3));
	pic.setPixel(ic[8], new ColorPixel(0.9, 0.2, 0.3));
	pic.setPixel(ic[9], new ColorPixel(0.0, 0.2, 0.3));

	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[0]));
	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[1]));
	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[2]));
	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[3]));
	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[4]));
	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[5]));
	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[6]));
	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[7]));
	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[8]));
	assertEquals("Testing pixel equality", sample_iter.next(), pic.getPixel(ic[9]));

    }

    @Test
    public void testHasNext() {

	Picture pic = new PictureImpl(15, 10);
	Iterator<Pixel> sample_iter = pic.sample(2, 3, 3, 4);
	Coordinate[] ic = new Coordinate[10];
	ic[0] = new Coordinate(2, 3);
	ic[1] = new Coordinate(5, 3);
	ic[2] = new Coordinate(8, 3);
	ic[3] = new Coordinate(11, 3);
	ic[4] = new Coordinate(14, 3);
	ic[5] = new Coordinate(2, 7);
	ic[6] = new Coordinate(5, 7);
	ic[7] = new Coordinate(8, 7);
	ic[8] = new Coordinate(11, 7);
	ic[9] = new Coordinate(14, 7);

	pic.setPixel(ic[0], new ColorPixel(0.1, 0.2, 0.3));
	pic.setPixel(ic[1], new ColorPixel(0.2, 0.2, 0.3));
	pic.setPixel(ic[2], new ColorPixel(0.3, 0.2, 0.3));
	pic.setPixel(ic[3], new ColorPixel(0.4, 0.2, 0.3));
	pic.setPixel(ic[4], new ColorPixel(0.5, 0.2, 0.3));
	pic.setPixel(ic[5], new ColorPixel(0.6, 0.2, 0.3));
	pic.setPixel(ic[6], new ColorPixel(0.7, 0.2, 0.3));
	pic.setPixel(ic[7], new ColorPixel(0.8, 0.2, 0.3));
	pic.setPixel(ic[8], new ColorPixel(0.9, 0.2, 0.3));
	pic.setPixel(ic[9], new ColorPixel(0.0, 0.2, 0.3));

	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), true);
	sample_iter.next();
	assertEquals("Testing hasNext", sample_iter.hasNext(), false);

    }

    // @Test
    //
    // public void testExtract() {
    // Picture p = new PictureImpl(3, 3);
    //
    // Coordinate c1 = new Coordinate(1, 1);
    // Coordinate c2 = new Coordinate(2, 2);
    //
    // p.setPixel(0, 0, new ColorPixel(0.1, 0.2, 0.3));
    // p.setPixel(1, 0, new ColorPixel(0.2, 0.2, 0.3));
    // p.setPixel(2, 0, new ColorPixel(0.3, 0.2, 0.3));
    // p.setPixel(0, 1, new ColorPixel(0.4, 0.2, 0.3));
    // p.setPixel(1, 1, new ColorPixel(0.5, 0.2, 0.3));
    // p.setPixel(2, 1, new ColorPixel(0.6, 0.2, 0.3));
    // p.setPixel(0, 2, new ColorPixel(0.7, 0.2, 0.3));
    // p.setPixel(1, 2, new ColorPixel(0.8, 0.2, 0.3));
    // p.setPixel(2, 2, new ColorPixel(0.9, 0.2, 0.3));
    //
    // SubPicture sp = p.extract(c1, c2);
    //
    // assertEquals("Pixel retrieved from subpicture does not match expected
    // pixel value from source",
    // p.getPixel(1, 1), sp.getPixel(0, 0));
    // assertEquals("Pixel retrieved from subpicture does not match expected
    // pixel value from source",
    // p.getPixel(2, 1), sp.getPixel(1, 0));
    // assertEquals("Pixel retrieved from subpicture does not match expected
    // pixel value from source",
    // p.getPixel(1, 2), sp.getPixel(0, 1));
    // assertEquals("Pixel retrieved from subpicture does not match expected
    // pixel value from source",
    // p.getPixel(2, 2), sp.getPixel(1, 1));
    //
    // SubPicture sp2 = sp.extract(1, 1, 1, 1);
    // assertEquals("Pixel retrieved from subpicture does not match expected
    // pixel value from source",
    // p.getPixel(2, 2), sp2.getPixel(0, 0));
    //
    // }
}

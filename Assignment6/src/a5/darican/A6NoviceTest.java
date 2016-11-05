package a5.darican;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "coordinateTest";
	test_names[1] = "setPixelTest";
	test_names[2] = "SubPictureTest";
	test_names[3] = "extractTest";
	test_names[4] = "iteratorTest";

	return test_names;
    }

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    @Test
    // checking that the pixel coordinates are correct
    public void coordinateTest() {
	Picture p = new PictureImpl(2, 3);
	Coordinate c1 = new Coordinate(1, 0);
	Coordinate c2 = new Coordinate(-1, 0);

	assertEquals("getPixel() called with coordinate different from getPixel()called with x and y", p.getPixel(1, 0),
		p.getPixel(c1));
	try {
	    p.getPixel(c2);
	    fail("Expected illegalArgumentException because x is negative");
	} catch (IllegalArgumentException e) {
	} catch (Exception e) {

	}
    }

    @Test
    public void setPixelTest() {
	Picture p = new PictureImpl(5, 5);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(3, 0, RED);
	p.setPixel(4, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(0, 2, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);

	SubPicture sp = new SubPictureImpl(p, 1, 1, 2, 2);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 1), sp.getPixel(0, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 1), sp.getPixel(1, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 2), sp.getPixel(0, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 2), sp.getPixel(1, 1));

	sp.setPixel(0, 0, RED);
	assertEquals("Pixel retrieved after setting does not match expected value", RED, sp.getPixel(0, 0));
	assertEquals("Pixel in source not changed after setting through subpicture", RED, p.getPixel(0, 0));
    }

    @Test
    public void SubPictureTest() {
	Picture p = new PictureImpl(7, 7);
	SubPicture sp = new SubPictureImpl(p, 1, 2, 3, 2);

	assertEquals("Result from getSource() does not match source picture", p, sp.getSource());
	assertEquals("X offset does not match value given to constructor", 1, sp.getXOffset());
	assertEquals("Y offset does not match value given to constructor", 2, sp.getYOffset());
	assertEquals("Width does not match value given to constructor", 3, sp.getWidth());
	assertEquals("Height does not match value given to constructor", 2, sp.getHeight());
    }

    @Test
    public void extractTest() {
	Picture p = new PictureImpl(4, 4);
	Coordinate c1 = new Coordinate(1, 1);
	Coordinate c2 = new Coordinate(3, 3);
	SubPicture subPic = p.extract(c1, c2);
	assertEquals(3, subPic.getWidth());
    }

    @Test
    public void iteratorTest() {
	Picture p = new PictureImpl(8, 8);
	Iterator<Pixel> iter = p.iterator();
	Pixel setPixel = iter.next();
	assertTrue(p.getPixel(0, 0) == setPixel);
    }

}

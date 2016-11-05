package a5.ajacober;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	return new String[] { "testCoordinateConstructor", "testPictureImplOverload", "testIterator" };
    }

    @Test
    public void testCoordinateConstructor() {
	Coordinate coord = new Coordinate(10, 4);
	assertEquals("getX() returns incorrect value", 10, coord.getX());
	assertEquals("getY() returns incorrect value", 4, coord.getY());
    }

    @Test
    public void testPictureImplOverload() {
	Coordinate c = new Coordinate(6, 7);
	Coordinate corner_a = new Coordinate(0, 0);
	Coordinate corner_b = new Coordinate(3, 3);
	Picture pic = new PictureImpl(10, 10);
	SubPicture sub = new SubPictureImpl(pic, 0, 0, 4, 4);
	SubPicture picExtract = pic.extract(corner_a, corner_b);
	Pixel p = new GrayPixel(0.5);
	pic.setPixel(6, 7, p);
	assertEquals("getPixel() returns incorrect value", p, pic.getPixel(c));
	assertEquals("Extract method did not return correct Subpicture width", sub.getWidth(), picExtract.getWidth());
	assertEquals("Extract method did not return correct Subpicture height", picExtract.getHeight(),
		sub.getHeight());
	assertEquals("Extract method did not return correct Subpicture source", picExtract.getSource(),
		sub.getSource());
	assertEquals("Extract method did not return correct Subpicture X Offset", picExtract.getXOffset(),
		sub.getXOffset());
	assertEquals("Extract method did not return correct Subpicture X Offset", picExtract.getYOffset(),
		sub.getYOffset());
    }

    @Test
    public void testIterator() {
	Picture pic = new PictureImpl(10, 10);
	Pixel p = new GrayPixel(0.5);
	pic.setPixel(3, 4, p);
	Iterator<Pixel> iter = pic.iterator();
	assertEquals("Iterator method hasNext() failed", iter.hasNext(), true);
	assertEquals("Iterator returned wrong pixel", iter.next(), pic.getPixel(0, 0));
    }
}
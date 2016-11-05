package a5.landerer;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "ConstructorCoordinate";
	test_names[1] = "setPixelTest";
	test_names[2] = "subPictureExtract";
	test_names[3] = "iteratorTest";

	return test_names;
    }

    @Test
    public void ConstructorCoordinate() {
	Coordinate c = new Coordinate(1, 2);

	assertEquals("x value does not equal", c.getX(), 1);
	assertEquals("x value does not equal", c.getY(), 2);
    }

    @Test
    public void setPixelTest() {
	Pixel p = new GrayPixel(.2);
	Coordinate x = new Coordinate(1, 1);
	Picture q = new PictureImpl(6, 6);
	q.setPixel(x, p);
	assertEquals("x value does not equal ", q.getPixel(x), p);

    }

    @Test
    public void subPictureExtract() {
	Picture q = new PictureImpl(10, 10);
	Coordinate corner_a = new Coordinate(3, 3);
	Coordinate corner_b = new Coordinate(6, 6);
	SubPicture sub = new SubPictureImpl(q, 3, 3, 3, 3);
	assertTrue("x value does not equal ", q.getPixel(0, 0).getIntensity() == sub.getPixel(corner_a).getIntensity());
	assertTrue("x value does not equal ", q.getPixel(3, 3).getIntensity() == sub.getPixel(corner_b).getIntensity());

    }

    @Test
    public void iteratorTest() {
	Picture q = new PictureImpl(3, 3);
	Iterator<Pixel> iter = q.iterator();

	assertEquals(iter.next(), q.getPixel(0, 0));

    }

    @Test
    public void exampleTest() {
    }
}

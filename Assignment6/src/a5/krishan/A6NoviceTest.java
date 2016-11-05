package a5.krishan;

//collaborators: steven sin, quentin hawkins

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "example";
	test_names[1] = "testIteratorPixel";
	test_names[2] = "testSetAndGetPixel";
	test_names[3] = "testExtract";

	return test_names;
    }

    @Test
    public void testIteratorPixel() {
	Picture p = new PictureImpl(1, 1);
	Iterator<Pixel> iterPixel = p.iterator();
	assertEquals("hasNext Error", iterPixel.hasNext(), true);
	assertEquals("Wrong Pixel Return", iterPixel.next(), p.getPixel(0, 0));

    }

    @Test
    public void testSetAndGetPixel() {
	Picture p = new PictureImpl(1, 1);
	Pixel a = new ColorPixel(1, 1, 1);
	p.setPixel(0, 0, a);
	assertEquals(a, p.getPixel(0, 0));
    }

    @Test
    public void testExtract() {
	Picture p = new PictureImpl(7, 7);
	Coordinate d = new Coordinate(1, 1);
	Coordinate e = new Coordinate(3, 3);
	SubPicture testSubPic = p.extract(d, e);
	assertEquals(3, testSubPic.getWidth());
    }

}

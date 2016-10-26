package a5.hattle;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "exampleTest";
	test_names[1] = "sampleTest";
	test_names[2] = "tileTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void sampleTest() {
	Picture testPic = new PictureImpl(5, 5);
	Coordinate c = new Coordinate(4, 2);
	Pixel p = new ColorPixel(.75, .3, .4);
	testPic.setPixel(c, p);
	Iterator<Pixel> iteration = testPic.sample(0, 0, 4, 2);
	iteration.next();
	iteration.next();
	iteration.next();
	Pixel p2 = iteration.next();
	assertEquals(0.75, p2.getRed(), 0.001);
	assertEquals(0.3, p2.getGreen(), 0.001);
	assertEquals(0.4, p2.getBlue(), 0.001);
    }

    @Test
    public void tileTest() {
	Picture testPic = new PictureImpl(5, 5);
	Coordinate c = new Coordinate(3, 3);
	Pixel p = new ColorPixel(.75, .3, .4);
	testPic.setPixel(c, p);
	Iterator<SubPicture> iteration = testPic.tile(2, 2);
	iteration.next();
	iteration.next();
	iteration.next();
	SubPicture tile = iteration.next();
	Pixel p2 = tile.getPixel(1, 1);
	assertEquals(0.75, p2.getRed(), 0.001);
	assertEquals(0.3, p2.getGreen(), 0.001);
	assertEquals(0.4, p2.getBlue(), 0.001);
    }
}

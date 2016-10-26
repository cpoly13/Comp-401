package a5.zijian;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "getPixelTest";
	test_names[1] = "setPixelTest";
	test_names[2] = "extractTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void getPixelTest() {
	Picture testPic = new PictureImpl(2, 3);
	Coordinate Co = new Coordinate(1, 1);
	Pixel p = new ColorPixel(0.12, 0.34, 0.56);

	Assert.assertEquals(0.5, testPic.getPixel(Co).getRed(), 0.001);
	Assert.assertEquals(0.5, testPic.getPixel(Co).getGreen(), 0.001);
	Assert.assertEquals(0.5, testPic.getPixel(Co).getBlue(), 0.001);

	testPic.setPixel(1, 1, p);
	Assert.assertEquals(0.12, testPic.getPixel(Co).getRed(), 0.001);
	Assert.assertEquals(0.34, testPic.getPixel(Co).getGreen(), 0.001);
	Assert.assertEquals(0.56, testPic.getPixel(Co).getBlue(), 0.001);

    }

    @Test
    public void setPixelTest() {
	Picture testPic = new PictureImpl(3, 4);
	Coordinate testCo1 = new Coordinate(3, 3);
	Coordinate testCo2 = new Coordinate(2, 3);
	Pixel p1 = new ColorPixel(0.75, 0.12, 0.34);

	try {
	    testPic.setPixel(testCo1, p1);
	    fail("exception expected");
	} catch (Exception e) {

	}

	testPic.setPixel(testCo2, p1);
	Assert.assertEquals(0.75, testPic.getPixel(2, 3).getRed(), 0.001);
	Assert.assertEquals(0.12, testPic.getPixel(2, 3).getGreen(), 0.001);
	Assert.assertEquals(0.34, testPic.getPixel(2, 3).getBlue(), 0.001);
    }

    @Test
    public void extractTest() {
	Picture testPic = new PictureImpl(4, 4);
	Coordinate c1 = new Coordinate(0, 1);
	Coordinate c2 = new Coordinate(2, 2);
	Picture sub = testPic.extract(c1, c2);

	Assert.assertEquals(3, sub.getWidth(), 0);
	Assert.assertEquals(2, sub.getHeight(), 0);

    }

}

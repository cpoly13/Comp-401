package a5.carly20;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "getPixelTest";
	test_names[1] = "setPixelTest";
	return test_names;
    }

    @Test
    public void getPixelTest() {
	SubPicture p = new SubPictureImpl(new PictureImpl(10, 10), 2, 2, 5, 5);

	Pixel p1 = p.getPixel(1, 1);
	Pixel c1 = p.getPixel(new Coordinate(1, 1));

	Pixel p2 = p.getPixel(4, 2);
	Pixel c2 = p.getPixel(new Coordinate(4, 2));

	assertEquals("test overloaded getPixel are equal", true, p1 == (c1));
	assertEquals("test overloaded getPixel are equal", true, p2 == (c2));
    }

    @Test
    public void setPixelTest() {
	SubPicture p = new SubPictureImpl(new PictureImpl(10, 10), 2, 2, 5, 5);
	Pixel pix = new ColorPixel(.5, .8, .0);
	Pixel p1 = p.getPixel(1, 1);
	p.setPixel(1, 1, pix);
	p.setPixel(new Coordinate(3, 1), pix);

	assertNotEquals("test overloaded setPixel has changed", true, p1.equals(p.getPixel(1, 1)));
	assertEquals("test overloaded setPixel are equal", true, p.getPixel(1, 1).equals(p.getPixel(3, 1)));

    }

}

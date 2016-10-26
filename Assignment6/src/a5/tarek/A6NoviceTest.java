package a5.tarek;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "testGetPixel";
	test_names[1] = "testExtract";

	return test_names;
    }

    /*
     * This code tests the getPixel method from novice by creating a picture,
     * changing some of the pixels, then retrieving that pixel.
     */
    @Test
    public void testGetPixel() {
	Picture p = new PictureImpl(6, 4);
	Pixel pix = new GrayPixel(0.3);
	Coordinate c = new Coordinate(2, 3);
	p.setPixel(c, pix);

	Pixel colorpixfringe = new ColorPixel(0.0, 1.0, 0.0);
	Picture p2 = new PictureImpl(10, 7);
	Picture subp2 = new SubPictureImpl(p2, 1, 3, 2, 4);
	Coordinate c2 = new Coordinate(3, 2);
	subp2.setPixel(c2, colorpixfringe);

	assertEquals("Coordinate from getPixel() does not match expected coordinatee", p.getPixel(c), pix);
	assertEquals("Coordinate from getPixel() does not match expected coordinates", subp2.getPixel(c2),
		colorpixfringe);

    }

    /*
     * Testing the extract method using coordinate arguments rather than prior
     * arguments.
     */
    @Test
    public void testExtract() {
	Picture p = new PictureImpl(10, 10);
	Pixel pix = new GrayPixel(1);
	p.setPixel(1, 1, pix);
	Coordinate c1 = new Coordinate(0, 0);
	Coordinate c2 = new Coordinate(3, 3);
	SubPicture sub = p.extract(c1, c2);
	
	assertTrue(pix.getIntensity() == sub.getPixel(new Coordinate(1,1)).getIntensity());
    }
}

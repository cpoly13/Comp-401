package a5.frjacobs;

import static org.junit.Assert.*;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "testPictureImplConstructor";
	test_names[1] = "testPictureImplGetHeight";
	test_names[2] = "testPictureImplGetWidth";
	test_names[3] = "testPictureImplSetGetPixel";
	test_names[4] = "testSubPictureImplConstructorGetters";
	test_names[5] = "testSubPictureExceptions1";
	test_names[6] = "testSubPictureExceptions2";
	test_names[7] = "testTransparentColorPixelConstructorGetters";
	test_names[8] = "testTransparentColorPixelException";
	test_names[9] = "testCoordinateGenerator";

	return test_names;
    }

    @Test
    public void testPictureImplConstructor() {
	PictureImpl pic = new PictureImpl(10, 20);
	final Pixel INITIAL_PIXEL = new GrayPixel(0.5D);
	int height = pic.getHeight();
	int width = pic.getWidth();

	assertEquals(width, 10);
	assertEquals(height, 20);
	for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
		assertEquals(pic.getPixel(x, y).getIntensity(), INITIAL_PIXEL.getIntensity(), 0);
	    }
	}
    }

    @Test
    public void testPictureImplGetHeight() {
	PictureImpl pic = new PictureImpl(10, 20);
	int height = pic.getHeight();
	assertEquals(height, 20);
    }

    @Test
    public void testPictureImplGetWidth() {
	PictureImpl pic = new PictureImpl(10, 20);
	int width = pic.getWidth();
	assertEquals(width, 10);
    }

    @Test
    public void testPictureImplSetGetPixel() {
	PictureImpl pic = new PictureImpl(10, 20);
	final Pixel INITIAL_PIXEL = new GrayPixel(0.7);
	pic.setPixel(5, 5, new GrayPixel(0.7));
	assertEquals(pic.getPixel(5, 5).getIntensity(), INITIAL_PIXEL.getIntensity(), 0);
    }

    @Test
    public void testSubPictureImplConstructorGetters() {
	SubPictureImpl pic = new SubPictureImpl(new PictureImpl(20, 20), 4, 5, 6, 7);

	assertEquals(4, pic.getXOffset());
	assertEquals(5, pic.getYOffset());
	assertEquals(6, pic.getWidth());
	assertEquals(7, pic.getHeight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubPictureExceptions1() {
	new SubPictureImpl(new PictureImpl(10, 10), 20, 5, 6, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubPictureExceptions2() {
	new SubPictureImpl(null, 4, 5, 6, 7);
    }

    @Test
    public void testTransparentColorPixelConstructorGetters() {
	TransparentColorPixel tcp = new TransparentColorPixel(0.3, 0.4, 0.5, 0.6);
	assertEquals(0.3, tcp.getRed(), 0);
	assertEquals(0.4, tcp.getGreen(), 0);
	assertEquals(0.5, tcp.getBlue(), 0);
	assertEquals(0.6, tcp.getTransparency(), 0);
    }

    @Test(expected = RuntimeException.class)
    public void testTransparentColorPixelException() {
	new TransparentColorPixel(1.2, 2, 3, 4);
    }

    // @Test
    // public void testCoordinateGenerator() {
    // CoordinateGenerator cg = new CoordinateGenerator(4, 5, 2, 2, 5, 6);
    // assertTrue(cg.hasNext());
    // Coordinate c1 = new Coordinate(4, 5);
    // Coordinate c2 = cg.next();
    // assertEquals(c1.getX(), c2.getX());
    // assertEquals(c1.getY(), c2.getY());
    // assertFalse(cg.hasNext());
    // }

}

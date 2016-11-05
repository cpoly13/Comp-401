package a5.jaime1;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

/*
 * JUnit test for A6 assignment
 */
public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testPictureImplConstructorExceptions";
	test_names[1] = "testTransparentColorPixelExceptions";
	test_names[2] = "testSubPictureImplGettersandSetters";

	return test_names;
    }

    @Test // testing runtime exception for invalid height/width
    public void testPictureImplConstructorExceptions() {
	Picture p = new PictureImpl(4, 5);
	try {
	    new SubPictureImpl(p, 8, 3, 0, 0);
	    fail("Expected RuntimeException for width or height = 0");
	} catch (RuntimeException e) {

	}

    }

    @Test // testing exceptions for TransparentColorPixel invalid input
    public void testTransparentColorPixelExceptions() {

	try {
	    new TransparentColorPixel(2, 0.5, 0.5, 0.5);
	    fail("Expected RuntimeException for Red out of bounds");
	} catch (RuntimeException e) {

	}

    }

    @Test // testing SubPicImpl get/set
    public void testSubPictureImplGettersandSetters() {
	Picture p = new PictureImpl(6, 6);

	SubPicture sp = new SubPictureImpl(p, 1, 1, 2, 2);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 1), sp.getPixel(0, 0));
    }

}

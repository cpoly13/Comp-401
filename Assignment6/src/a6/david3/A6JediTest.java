package a6.david3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	List<String> test_names = new ArrayList<String>();

	test_names.add("zigzag");

	return test_names.toArray(new String[0]);
    }

    @Test
    public void zigzag() {
	Picture p = new PictureImpl(2, 2);
	Pixel p00 = new GrayPixel(0);
	Pixel p01 = new GrayPixel(.2);
	Pixel p10 = new GrayPixel(.4);
	Pixel p11 = new GrayPixel(.6);

	p.setPixel(0, 0, p00);
	p.setPixel(0, 1, p01);
	p.setPixel(1, 0, p10);
	p.setPixel(1, 1, p11);

	Pixel[] pix = new Pixel[] { p00, p10, p01, p11 };

	Iterator<Pixel> iter = p.zigzag();
	assertTrue(iter instanceof Iterator);

	int i = 0;
	try {
	    while (iter.hasNext()) {
		if (iter.next().getIntensity() != pix[i].getIntensity())
		    fail("Pixels not equal at i{" + i + "}");
		i++;
	    }
	} catch (IndexOutOfBoundsException e) {
	    fail("index out of bounds in array pix at i{" + i + "}");
	}
    }

    @Test
    public void zigzagOneElement() {
	Picture p = new PictureImpl(1, 1);
	Pixel p00 = new GrayPixel(.2);
	p.setPixel(0, 0, p00);

	Iterator<Pixel> iter = p.zigzag();
	assertTrue(iter instanceof Iterator);

	if (iter.hasNext()) {
	    assertTrue("intensities don't match", iter.next().getIntensity() == p00.getIntensity());
	} else {
	    fail("not even one element");
	}
	if (iter.hasNext()) {
	    fail("More elements after the only one available");
	}
    }

    @Test
    public void zigzag3x3() {
	Picture p = new PictureImpl(3, 3);
	Pixel p00 = new GrayPixel(0);
	Pixel p10 = new GrayPixel(.2);
	Pixel p20 = new GrayPixel(.1);
	Pixel p01 = new GrayPixel(.4);
	Pixel p11 = new GrayPixel(.3);
	Pixel p21 = new GrayPixel(.5);
	Pixel p02 = new GrayPixel(.6);
	Pixel p12 = new GrayPixel(.7);
	Pixel p22 = new GrayPixel(.8);

	p.setPixel(0, 0, p00);
	p.setPixel(1, 0, p10);
	p.setPixel(2, 0, p20);
	p.setPixel(0, 1, p01);
	p.setPixel(1, 1, p11);
	p.setPixel(2, 1, p21);
	p.setPixel(0, 2, p02);
	p.setPixel(1, 2, p12);
	p.setPixel(2, 2, p22);

	Pixel[] pix = new Pixel[] { p00, p10, p01, p02, p11, p20, p21, p12, p22 };

	Iterator<Pixel> iter = p.zigzag();
	assertTrue(iter instanceof Iterator);

	int i = 0;
	try {
	    while (iter.hasNext()) {
		if (iter.next().getIntensity() != pix[i].getIntensity())
		    fail("Pixels not equal at i{" + i + "}");
		i++;
	    }
	} catch (IndexOutOfBoundsException e) {
	    fail("index out of bounds in array pix at i{" + i + "}");
	}
    }
}

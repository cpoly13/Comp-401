package a5.david3;

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
}

package a5.deleeke;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testZigZag";

	return test_names;
    }

    @Test
    public void testZigZag() {
	Picture pic = new PictureImpl(2, 2);
	Pixel p1 = new GrayPixel(0.1);
	Pixel p2 = new GrayPixel(0.2);
	Pixel p3 = new GrayPixel(0.3);
	Pixel p4 = new GrayPixel(0.4);
	pic.setPixel(0, 0, p1);
	pic.setPixel(1, 0, p2);
	pic.setPixel(0, 1, p3);
	pic.setPixel(1, 1, p4);

	Iterator<Pixel> zz_iter = pic.zigzag();
	Pixel[] expected = { p1, p2, p3, p4 };
	int i = 0;
	while (zz_iter.hasNext()) {
	    Pixel testobj = zz_iter.next();
	    assertTrue(testobj.equals(expected[i]));
	    i++;
	}

    }
}

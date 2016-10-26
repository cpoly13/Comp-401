package a5.wong15w;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigZagTest";

	return test_names;
    }

    @Test
    public void zigZagTest() {
	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> zigZag = p.zigzag();

	Coordinate a = new Coordinate(0, 0);
	Coordinate b = new Coordinate(1, 0);
	Coordinate c = new Coordinate(0, 1);
	Coordinate d = new Coordinate(1, 1);
	ColorPixel aa = new ColorPixel(.5, .1, .1);
	ColorPixel bb = new ColorPixel(.4, .1, .1);
	ColorPixel cc = new ColorPixel(.3, .1, .1);
	ColorPixel dd = new ColorPixel(.2, .1, .1);

	p.setPixel(a, aa);
	p.setPixel(b, bb);
	p.setPixel(c, cc);
	p.setPixel(d, dd);

	double getRedIntensity[] = new double[4];
	int i = 0;
	while (zigZag.hasNext()) {
	    getRedIntensity[i] = zigZag.next().getRed();
	    i++;
	}
	double correctRedIntensity[] = { aa.getRed(), bb.getRed(), cc.getRed(), dd.getRed() };

	assertTrue("The intensities of the pixels do not match expected ones",
		Arrays.equals(correctRedIntensity, getRedIntensity));

    }
}

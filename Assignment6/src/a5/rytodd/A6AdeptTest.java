package a5.rytodd;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testSample";

	return test_names;
    }

    @Test
    public void testSample() {

	Picture p = new PictureImpl(3, 3);

	Coordinate a = new Coordinate(0, 0);
	Coordinate b = new Coordinate(0, 1);
	Coordinate c = new Coordinate(0, 2);
	Coordinate d = new Coordinate(1, 0);
	Coordinate e = new Coordinate(1, 1);
	Coordinate f = new Coordinate(1, 2);
	Coordinate g = new Coordinate(2, 0);
	Coordinate h = new Coordinate(2, 1);
	Coordinate i = new Coordinate(2, 2);

	Pixel red = new ColorPixel(1, 0, 0);
	Pixel green = new ColorPixel(0, 1, 0);
	Pixel blue = new ColorPixel(0, 0, 1);

	p.setPixel(a, red);
	p.setPixel(b, green);
	p.setPixel(c, blue);
	p.setPixel(d, blue);
	p.setPixel(e, green);
	p.setPixel(f, red);
	p.setPixel(g, red);
	p.setPixel(h, green);
	p.setPixel(i, blue);

	p.iterator();

    }
}

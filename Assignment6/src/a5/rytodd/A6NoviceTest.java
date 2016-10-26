package a5.rytodd;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "testSettersAndGetters";
	test_names[1] = "testExtract";
	test_names[2] = "testNext";
	test_names[3] = "testHasNext";

	return test_names;
    }

    @Test
    public void testSettersAndGetters() {

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

	assertEquals("Pixel mismatch", p.getPixel(a), red);
	assertEquals("Pixel mismatch", p.getPixel(b), green);
	assertEquals("Pixel mismatch", p.getPixel(c), blue);
	assertEquals("Pixel mismatch", p.getPixel(d), blue);
	assertEquals("Pixel mismatch", p.getPixel(e), green);
	assertEquals("Pixel mismatch", p.getPixel(f), red);
	assertEquals("Pixel mismatch", p.getPixel(g), red);
	assertEquals("Pixel mismatch", p.getPixel(h), green);
	assertEquals("Pixel mismatch", p.getPixel(i), blue);
    }

    @Test
    public void testExtract() {

	Picture p = new PictureImpl(3, 3);
	Picture newp1 = new PictureImpl(2, 3);

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

	newp1.setPixel(a, blue);
	newp1.setPixel(b, green);
	newp1.setPixel(c, red);
	newp1.setPixel(d, red);
	newp1.setPixel(e, green);
	newp1.setPixel(f, blue);

	assertEquals("Pixel mismatch", p.extract(d, i).getPixel(a), newp1.getPixel(a));
	assertEquals("Pixel mismatch", p.extract(d, i).getPixel(f), newp1.getPixel(f));
	assertEquals("Pixel mismatch", p.extract(d, i).getPixel(c), newp1.getPixel(c));

    }

    @Test
    public void testNext() {

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

	Iterator<Pixel> it = p.iterator();

	assertEquals("next() fails", it.next(), p.getPixel(a));

	it.next();
	it.next();
	assertEquals("next() fails", it.next(), p.getPixel(b));

    }

    @Test
    public void testHasNext() {

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

	Iterator<Pixel> it = p.iterator();

	assertEquals("hasNext() fails", it.hasNext(), true);

    }

}

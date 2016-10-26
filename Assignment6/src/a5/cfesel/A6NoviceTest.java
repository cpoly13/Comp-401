package a5.cfesel;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    static public String[] getTestNames() {

	String[] test_names = new String[3];

	test_names[0] = "pixelIteratorTest";
	test_names[1] = "iterExceptionTest";
	test_names[2] = "coordinateTest";

	return test_names;
    }

    @Test
    public void pixelIteratorTest() {

	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> iter = p.iterator();

	p.setPixel(0, 0, RED);
	p.setPixel(0, 1, BLUE);
	p.setPixel(1, 0, RED);
	p.setPixel(1, 1, GREEN);

	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(0, 0));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(1, 0));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(0, 1));
	assertEquals("Iterator returned wrong pixel", iter.next(), p.getPixel(1, 1));

    }

    @Test
    public void iterExceptionTest() {

	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> iter = p.iterator();

	try {
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();
	    iter.next();

	} catch (RuntimeException e) {

	}
    }

    @Test
    public void coordinateTest() {
	Coordinate c1 = new Coordinate(0, 0);
	Coordinate c2 = new Coordinate(0, 1);
	Coordinate c3 = new Coordinate(1, 0);

	assertEquals("msg", c1.getX(), 0);
	assertEquals("msg", c2.getX(), 0);
	assertEquals("msg", c3.getX(), 1);

	assertEquals("msg", c1.getY(), 0);
	assertEquals("msg", c2.getY(), 1);
	assertEquals("msg", c3.getY(), 0);

    }

}

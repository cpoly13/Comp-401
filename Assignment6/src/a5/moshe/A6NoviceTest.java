package a5.moshe;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "getPixelTest";
	test_names[1] = "setPixelTest";
	test_names[2] = "iteratorTest";
	test_names[3] = "hasNextTest";

	return test_names;
    }

    // private static final Coordinate Cx = new Coordinate
    // The above can be used for consistent coordinates

    @Test
    public void getPixelTest() {
	Picture p = new PictureImpl(5, 5); // how these JUnit tests work is by
					   // testing the result
					   // of the function against the values
					   // I want it to have.
	Coordinate c = new Coordinate(2, 2);
	assertEquals("The Pixel retrieved from the picture does not match its expected value.", p.getPixel(c),
		p.getPixel(2, 2)); // checks to see whether the information
				   // matches
    }

    @Test
    public void setPixelTest() {
	Picture p = new PictureImpl(5, 5);
	Coordinate c = new Coordinate(2, 2);
	Pixel pi = new ColorPixel(0.4, 0.3, 0.3); // this has a weird-looking
						  // value because I was
						  // originally testing the
						  // individual colors.
	p.setPixel(c, pi); // setting a pixel at picture p at coordinate c
	assertEquals("The Pixel set did not match its expected value.", p.getPixel(c), pi); // this
											    // is
											    // also
											    // easier
											    // than
											    // the
											    // previous
											    // step,
											    // but
											    // it
											    // doesn't
											    // check
											    // to
											    // see
											    // whether
											    // a
											    // specific
											    // color
											    // is
											    // wrong.
											    // Probably
											    // not
											    // too
											    // important,
											    // though.
    }

    @Test
    public void iteratorTest() {
	Picture p = new PictureImpl(2, 2);
	p.setPixel(0, 0, new ColorPixel(1, 0, 0));
	p.setPixel(1, 0, new ColorPixel(0, 1, 0));
	p.setPixel(0, 1, new ColorPixel(0, 0, 1));
	p.setPixel(1, 1, new ColorPixel(1, 0, 0));

	Iterator<Pixel> it = p.iterator(); // it = name of iterator. The picture
					   // is calling it.
	assertEquals("The incorrect pixel has been reached", p.getPixel(0, 0), it.next());
	assertEquals("The incorrect pixel has been reached", p.getPixel(1, 0), it.next());
	assertEquals("The incorrect pixel has been reached", p.getPixel(0, 1), it.next());
	assertEquals("The incorrect pixel has been reached", p.getPixel(1, 1), it.next());
	assertEquals("There is no next pixel.", false, it.hasNext());
    }

    @Test
    public void hasNextTest() {
	Picture p = new PictureImpl(2, 2);
	p.setPixel(0, 0, new ColorPixel(1, 0, 0));
	p.setPixel(1, 0, new ColorPixel(0, 1, 0));
	p.setPixel(0, 1, new ColorPixel(0, 0, 1));
	p.setPixel(1, 1, new ColorPixel(1, 0, 0));

	Iterator<Pixel> it = p.iterator();
	assertEquals("hasNext is incorrectly determining whether a pixel exists", true, it.hasNext());
	it.next(); // the idea here is that at a coordinate besides (1,1) there
		   // is a next pixel, so
		   // hasNext should be true. I think.
	assertEquals("hasNext is incorrectly determining whether a pixel exists", true, it.hasNext());
	it.next();
	assertEquals("hasNext is incorrectly determining whether a pixel exists", true, it.hasNext());
	it.next();
	assertEquals("hasNext is incorrectly determining whether a pixel exists", true, it.hasNext());
	it.next();
	assertEquals("hasNext is incorrectly determining whether a pixel exists", false, it.hasNext());
	// at (1,1) there is no next pixel so it should be false?
    }

}

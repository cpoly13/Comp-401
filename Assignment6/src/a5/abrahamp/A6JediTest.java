package a5.abrahamp;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagTest";

	return test_names;
    }

    @Test
    public void zigzagTest() {
	Picture tester = new PictureImpl(5, 5);
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		Coordinate c = new Coordinate(i, j);
		tester.setPixel(c, new ColorPixel(i * .1, j * .13, j * .18));
	    }
	}
	Iterator<Pixel> zigzag = tester.zigzag();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	Coordinate c6 = new Coordinate(2, 0);
	assertTrue(zigzag.next().equals(tester.getPixel(c6)));// make sure one
							      // of the first
							      // few pixels is
							      // correct
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	Coordinate c13 = new Coordinate(3, 1);
	assertTrue(zigzag.next().equals(tester.getPixel(c13)));// make sure a
							       // random middle
							       // pixel is
							       // correct
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	zigzag.next();
	Coordinate c25 = new Coordinate(4, 4);
	assertTrue(zigzag.next().equals(tester.getPixel(c25)));// make sure the
							       // final pixel is
							       // correct
    }
}

package a5.mcanders;

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

    static Pixel pOne = new ColorPixel(.333, .333, .333);
    static Pixel pTwo = new GrayPixel(.5);
    static Pixel pThree = new ColorPixel(.567, .125, .321);
    static Pixel pFour = new GrayPixel(0.0);
    static Pixel pFive = new GrayPixel(.3);
    static Pixel pSix = new GrayPixel(.7);

    static Picture p = new PictureImpl(3, 2);
    static Picture c = new PictureImpl(2, 2);
    static Picture t = new PictureImpl(10, 10);

    static Coordinate c1 = new Coordinate(0, 0);
    static Coordinate c2 = new Coordinate(0, 1);
    static Coordinate c3 = new Coordinate(1, 0);
    static Coordinate c4 = new Coordinate(1, 1);

    @Test
    public void zigzagTest() {

	p.setPixel(0, 0, pOne);
	p.setPixel(1, 0, pTwo);
	p.setPixel(2, 0, pThree);
	p.setPixel(0, 1, pFour);
	p.setPixel(1, 1, pFive);
	p.setPixel(2, 1, pSix);

	Iterator<Pixel> pitt = p.zigzag();

	assertEquals("Iterator is broken", pitt.next().getIntensity(), pOne.getIntensity(), .0001);
	assertEquals("Iterator is broken", pitt.next().getIntensity(), pTwo.getIntensity(), .0001);
	assertEquals("Iterator is broken", pitt.next().getIntensity(), pFour.getIntensity(), .0001);
	assertEquals("Iterator is broken", pitt.next().getIntensity(), pFive.getIntensity(), .0001);
	assertEquals("Iterator is broken", pitt.next().getIntensity(), pThree.getIntensity(), .0001);
	assertEquals("Iterator is broken", pitt.next().getIntensity(), pSix.getIntensity(), .0001);

    }

}

package a5.nishanth;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

//import a4adept.ColorPixel;
//import a4adept.GrayPixel;
//import a4adept.Pixel;
import a6novice.*;

public class A6NoviceTest {
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    private Picture pic;
    private Coordinate c;
    private Coordinate c1;
    private Coordinate c2;
    private Coordinate c3;
    private Coordinate c4;
    private Coordinate c18;
    Pixel p1;
    Pixel p2;
    Pixel black;
    Pixel white;

    @Before
    public void setUp() {
	pic = new PictureImpl(4, 6);

	c = new Coordinate(0, 0);
	c1 = new Coordinate(1, 0);
	c2 = new Coordinate(0, 4);
	c3 = new Coordinate(1, 1);
	c4 = new Coordinate(3, 3);
	c18 = new Coordinate(2, 4);

	p1 = new ColorPixel(.5, .5, .6);
	black = BLACK;
	white = WHITE;
	p2 = new ColorPixel(.3, .9, 1);
	pic.setPixel(c, p1);
	pic.setPixel(c1, p2);
	pic.setPixel(c2, black);
	pic.setPixel(c18, white);
    }

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "exampleTest";
	test_names[1] = "coordinateTest";
	test_names[2] = "getSetPixelTest";
	test_names[3] = "extractTest";
	test_names[4] = "iteratorTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void coordinateTest() {
	// In this test, I test the getX() and getY() methods on Coordinate
	// to see if they work. I also use a negative x value for a coordinate
	// and I show that x and y values cannot be negative.
	Coordinate c = new Coordinate(2, 2);
	assertEquals(2, c.getX());
	assertEquals(2, c.getY());
	Coordinate cNeg = new Coordinate(-2, 2);
	assertEquals("x/y cannot cannot be negative", -2, cNeg.getX());
    }

    @Test
    public void getSetPixelTest() {
	// I set some pixels in the pic and then I just see if the getPixel()
	// and setPixel() methods work accordingly.
	pic.setPixel(c, p1);
	pic.setPixel(c1, p2);
	pic.setPixel(c2, black);
	pic.setPixel(c18, white);
	assertEquals(WHITE, pic.getPixel(c18));
	assertEquals(p2, pic.getPixel(c1));
	// assertEquals(new ColorPixel(.3,.9,1),pic.getPixel(c1));
	// The above doesn't work because they have different locations in
	// memory.

    }

    @Test
    public void extractTest() {
	// I test if the subPic is extracted correctly.
	// pic is 4x6
	c3 = new Coordinate(1, 1);
	c4 = new Coordinate(3, 3);

	// subPic = new SubPictureImpl(pic,1,1,2,2);
	// assertSame(subPic,pic.extract(c3,c4));

	SubPicture subPic = pic.extract(c3, c4);

	assertEquals(3, subPic.getWidth());
	assertEquals(3, subPic.getHeight());
	assertEquals(1, subPic.getXOffset());
	// assertEquals(2,subPic.getWidth()); //why doesn't this work
	// So, my understanding was kind of flawed. It now makes sense why the
	// width should be three, because I start at (1,1), and going to the
	// right,
	// you have pixels at (1,1), (1,2), (1,3), so the width is three. You
	// count
	// each pixel as like a unit, so because there are three pixels across,
	// the width is three.

    }

    @Test
    public void iteratorTest() {
	// pic is 4x6

	c = new Coordinate(0, 0);
	c1 = new Coordinate(1, 0);
	c2 = new Coordinate(0, 4);
	c3 = new Coordinate(1, 1);
	c4 = new Coordinate(3, 3);
	c18 = new Coordinate(2, 4);

	p1 = new ColorPixel(.5, .5, .6);
	black = BLACK;
	white = WHITE;
	p2 = new ColorPixel(.3, .9, 1);

	pic.setPixel(c, p1);
	pic.setPixel(c1, p2);
	pic.setPixel(c2, black);
	pic.setPixel(c18, white);
	Iterator<Pixel> iterator = pic.iterator();
	/*
	 * for (int i = 0; i < 4; i++){ for(int j = 0; j < 7; j++){
	 * 
	 * pixels[i][j] = pic.setPixel(); assertEquals(true,iterator.hasNext());
	 * } }
	 */

	while (iterator.hasNext()) {
	    iterator.next();
	    break;

	}

	assertEquals(true, iterator.hasNext());

    }
}

package a5.mbrady24;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "exampleTest";
	test_names[1] = "coordinateTest";
	test_names[2] = "coordinateGettersAndSettersTest";
	test_names[3] = "extractTest";
	test_names[5] = "coordinateConstructorTest";
	test_names[6] = "coordinateExceptionsTests";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void coordinateTest() {
	Picture p = new PictureImpl(4, 4);
	for (int x = 0; x < p.getWidth(); x++) {
	    for (int y = 0; y < p.getHeight(); y++) {
		Coordinate c = new Coordinate(x, y);
		assertEquals("Pixels do not match", p.getPixel(x, y), p.getPixel(c));
	    }
	}
    }

    @Test
    public void coordinateGettersAndSettersTest() {
	Picture p = new PictureImpl(3, 3);
	Coordinate c1 = new Coordinate(0, 0);
	Coordinate c2 = new Coordinate(1, 0);
	Coordinate c3 = new Coordinate(2, 0);
	Coordinate c4 = new Coordinate(0, 1);
	Coordinate c5 = new Coordinate(1, 1);
	Coordinate c6 = new Coordinate(2, 1);
	Coordinate c7 = new Coordinate(0, 2);
	Coordinate c8 = new Coordinate(1, 2);
	Coordinate c9 = new Coordinate(2, 2);

	p.setPixel(c1, RED);
	p.setPixel(c2, RED);
	p.setPixel(c3, BLACK);
	p.setPixel(c4, BLUE);
	p.setPixel(c5, BLUE);
	p.setPixel(c6, GREEN);
	p.setPixel(c7, RED);
	p.setPixel(c8, GREEN);
	p.setPixel(c9, BLACK);

	assertEquals("Coordinates do not match up", p.getPixel(0, 0), p.getPixel(c1));
	assertEquals("Coordinates do not match up", p.getPixel(1, 0), p.getPixel(c2));
	assertEquals("Coordinates do not match up", p.getPixel(2, 0), p.getPixel(c3));
	assertEquals("Coordinates do not match up", p.getPixel(0, 1), p.getPixel(c4));
	assertEquals("Coordinates do not match up", p.getPixel(1, 1), p.getPixel(c5));
	assertEquals("Coordinates do not match up", p.getPixel(2, 1), p.getPixel(c6));
	assertEquals("Coordinates do not match up", p.getPixel(0, 2), p.getPixel(c7));
	assertEquals("Coordinates do not match up", p.getPixel(1, 2), p.getPixel(c8));
	assertEquals("Coordinates do not match up", p.getPixel(2, 2), p.getPixel(c9));

    }

    @Test
    public void extractTest() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, BLUE);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, BLUE);
	p.setPixel(0, 2, GREEN);
	p.setPixel(1, 2, RED);
	p.setPixel(2, 2, RED);
	Coordinate cornerA = new Coordinate(1, 1);
	Coordinate cornerB = new Coordinate(2, 2);
	SubPicture sp = p.extract(cornerA, cornerB);
	assertEquals(2, sp.getHeight());
	assertEquals(2, sp.getWidth());
    }

    @Test
    public void coordinateConstructorTest() {
	Coordinate c1 = new Coordinate(0, 0);
	Coordinate c2 = new Coordinate(1, 2);
	Coordinate c3 = new Coordinate(3, 2);
	Coordinate c4 = new Coordinate(5, 3);
	assertEquals(0, c1.getX());
	assertEquals(2, c2.getY());
	assertEquals(3, c3.getX());
	assertEquals(5, c4.getX());
    }

    @Test
    public void coordinateExceptionsTest() {
	Picture p = new PictureImpl(2, 2);
	Coordinate c1 = null;
	new Coordinate(0, 1);
	new Coordinate(1, 0);
	new Coordinate(1, 1);

	try {
	    p.setPixel(c1, BLUE);
	    fail("Expected Illegal Argument Exception");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected Illegal Argument Exception but got general exception");
	}
    }

}

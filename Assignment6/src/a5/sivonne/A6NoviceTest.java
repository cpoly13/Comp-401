package a5.sivonne;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "CoordinateTest";
	test_names[1] = "IteratorTest";

	return test_names;
    }

    @Test
    public void CoordinateTest() {
	Picture p = new PictureImpl(2, 2);
	Coordinate c0 = new Coordinate(0, 0);
	Coordinate c1 = new Coordinate(1, 0);
	Coordinate c2 = new Coordinate(0, 1);
	Coordinate c3 = new Coordinate(1, 1);

	p.setPixel(c0, RED);
	p.setPixel(c1, BLUE);
	p.setPixel(c2, WHITE);
	p.setPixel(c3, BLACK);

	assertEquals("Pixel value incorrect", p.getPixel(c0), RED);
	assertEquals("Pixel value incorrect", p.getPixel(c1), BLUE);
	assertEquals("Pixel value incorrect", p.getPixel(c2), WHITE);
	assertEquals("Pixel value incorrect", p.getPixel(c3), BLACK);
    }

    @Test
    public void IteratorTest() {
	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> iter = p.iterator();
	Coordinate c0 = new Coordinate(0, 0);
	Coordinate c1 = new Coordinate(1, 0);
	Coordinate c2 = new Coordinate(0, 1);
	Coordinate c3 = new Coordinate(1, 1);

	p.setPixel(c0, RED);
	p.setPixel(c1, BLUE);
	p.setPixel(c2, WHITE);
	p.setPixel(c3, GREEN);

	assertTrue("Pixel value incorrect", iter.next().equals(p.getPixel(c0)));
	assertTrue("Pixel value incorrect", iter.next().equals(p.getPixel(c1)));
	assertTrue("Pixel value incorrect", iter.next().equals(p.getPixel(c2)));
	assertTrue("Pixel value incorrect", iter.next().equals(p.getPixel(c3)));

    }

    // test if the nosuchelement is going through
    // test if unsupportedoperator is going through

}

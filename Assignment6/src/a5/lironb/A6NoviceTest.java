package a5.lironb;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "testCoordinate";
	test_names[1] = "testExtract";

	return test_names;
    }

    @Test
    public void testCoordinate() {
	Coordinate c1 = new Coordinate(1, 2);
	Picture p1 = new PictureImpl(6, 4);
	p1.setPixel(c1, WHITE);
	assertEquals("Coordinate Setter is not working right", p1.getPixel(1, 2), WHITE);
	Coordinate c2 = new Coordinate(6, 3);
	Picture p2 = new PictureImpl(8, 8);
	p2.setPixel(c2, GREEN);
	assertEquals("Coordinate Setter is not working right", p2.getPixel(6, 3), GREEN);

    }

    @Test
    public void testExtract() {
	Coordinate c1 = new Coordinate(0, 0);
	Coordinate c2 = new Coordinate(1, 0);
	Coordinate c3 = new Coordinate(2, 0);
	Coordinate c4 = new Coordinate(0, 1);
	Coordinate c5 = new Coordinate(1, 1);
	Coordinate c6 = new Coordinate(2, 1);
	Coordinate c7 = new Coordinate(0, 2);
	Coordinate c8 = new Coordinate(1, 2);
	Coordinate c9 = new Coordinate(2, 2);

	Picture p = new PictureImpl(3, 3);
	p.setPixel(c1, RED);
	p.setPixel(c2, RED);
	p.setPixel(c3, RED);
	p.setPixel(c4, GREEN);
	p.setPixel(c5, BLUE);
	p.setPixel(c6, WHITE);
	p.setPixel(c7, BLACK);
	p.setPixel(c8, BLACK);
	p.setPixel(c9, RED);

	SubPicture sp = p.extract(1, 1, 2, 2);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(c5),
		sp.getPixel(c1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(c6),
		sp.getPixel(c2));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(c8),
		sp.getPixel(c4));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(c9),
		sp.getPixel(c5));

	SubPicture sp2 = sp.extract(1, 1, 1, 1);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p.getPixel(c9),
		sp2.getPixel(c1));

    }

}

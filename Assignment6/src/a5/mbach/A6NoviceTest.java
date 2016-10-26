package a5.mbach;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

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
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testCoordinateConstructor";
	test_names[1] = "testExtract";
	test_names[2] = "testIterator";

	return test_names;
    }

    @Test
    public void testCoordinateConstructor() {
	Coordinate c = new Coordinate(2, 3);
	assertEquals("result from getX() does not match the coordinate", 2, c.getX());
	assertEquals("result from getY() does not match the coordinate", 3, c.getY());
    }

    @Test
    public void testExtract() {
	Picture p = new PictureImpl(4, 4);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(3, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(3, 1, BLUE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);
	p.setPixel(3, 2, WHITE);
	p.setPixel(0, 3, WHITE);
	p.setPixel(1, 3, BLUE);
	p.setPixel(2, 3, BLACK);
	p.setPixel(3, 3, RED);

	SubPicture sp = p.extract(1, 1, 3, 3);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 1), sp.getPixel(0, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(3, 1), sp.getPixel(2, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 3), sp.getPixel(0, 2));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(3, 3), sp.getPixel(2, 2));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 1), sp.getPixel(1, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 2), sp.getPixel(0, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 2), sp.getPixel(1, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(3, 2), sp.getPixel(2, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 3), sp.getPixel(1, 2));

	Coordinate c1 = new Coordinate(0, 1);
	Coordinate c2 = new Coordinate(3, 3);
	SubPicture subp = p.extract(c1, c2);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(0, 1), subp.getPixel(0, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(3, 1), subp.getPixel(3, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 3), subp.getPixel(1, 2));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(3, 3), subp.getPixel(3, 2));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 1), subp.getPixel(1, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 1), subp.getPixel(2, 0));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(0, 2), subp.getPixel(0, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(1, 2), subp.getPixel(1, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 2), subp.getPixel(2, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(3, 2), subp.getPixel(3, 1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(0, 3), subp.getPixel(0, 2));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		p.getPixel(2, 3), subp.getPixel(2, 2));
    }

    @Test
    public void testIterator() {
	Picture p = new PictureImpl(2, 2);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);

	Iterator<Pixel> iter = p.iterator();

	assertEquals("Pixel doesn't match expected", p.getPixel(0, 0), iter.next());
	assertEquals("Pixel doesn't match expected", p.getPixel(1, 0), iter.next());
	assertEquals("Pixel doesn't match expected", p.getPixel(0, 1), iter.next());
	assertEquals("Pixel doesn't match expected", p.getPixel(1, 1), iter.next());

    }
}

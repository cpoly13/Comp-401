package a5.robro;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "coordinateConstructorTest";
	test_names[1] = "subPictureFromCoordinateTest";
	test_names[2] = "setGetPixelTest";
	test_names[3] = "iteratorTest";

	return test_names;
    }

    @Test
    public void coordinateConstructorTest() {
	Coordinate c = new Coordinate(3, 1);

	assertEquals("X value does not match value given to constructor", 3, c.getX());
	assertEquals("Y value does not match value given to constructor", 1, c.getY());
    }

    @Test
    public void subPictureFromCoordinateTest() {
	Picture p = new PictureImpl(5, 3);
	Coordinate corner_a = new Coordinate(2, 0);
	Coordinate corner_b = new Coordinate(4, 2);
	SubPicture sp = p.extract(corner_a, corner_b);

	assertEquals("Subpicture source does not match expected source picture", p, sp.getSource());
	assertEquals("Subpicture width does not match expected value", 3, sp.getWidth());
	assertEquals("Subpicture height does not match expected value", 3, sp.getHeight());
	assertEquals("Subpicture xoffset does not match expected value", 2, sp.getXOffset());
	assertEquals("Subpicture yoffset does not match expected value", 0, sp.getYOffset());
    }

    @Test
    public void setGetPixelTest() {
	Picture p = new PictureImpl(5, 3);
	Coordinate c = new Coordinate(3, 1);
	Coordinate c2 = new Coordinate(4, 2);
	p.setPixel(c, RED);
	assertEquals("Picture does not return expected pixel value", RED, p.getPixel(c));
	SubPicture sp = p.extract(c, c2);
	assertEquals("Subpicture does not return expected pixel value", p.getPixel(c), sp.getPixel(0, 0));

    }

    @Test
    public void iteratorTest() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);

	Iterator<Pixel> iter = p.iterator();

	assertEquals("Iterator hasNext not functioning", true, iter.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(0, 0), iter.next());
	assertEquals("Iterator hasNext not functioning", true, iter.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(1, 0), iter.next());
	assertEquals("Iterator hasNext not functioning", true, iter.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(2, 0), iter.next());
	assertEquals("Iterator hasNext not functioning", true, iter.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(0, 1), iter.next());
	assertEquals("Iterator hasNext not functioning", true, iter.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(1, 1), iter.next());
	assertEquals("Iterator hasNext not functioning", true, iter.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(2, 1), iter.next());
	assertEquals("Iterator hasNext not functioning", true, iter.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(0, 2), iter.next());
	assertEquals("Iterator hasNext not functioning", true, iter.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(1, 2), iter.next());
	assertEquals("Iterator hasNext not functioning", true, iter.hasNext());
	assertEquals("Iterator returning incorrect pixel", p.getPixel(2, 2), iter.next());
    }

}

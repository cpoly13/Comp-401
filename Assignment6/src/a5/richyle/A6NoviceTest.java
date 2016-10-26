package a5.richyle;

import static org.junit.Assert.assertEquals;

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
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "coordinateTest";
	test_names[1] = "coordinateExtractTest";

	return test_names;
    }

    @Test
    public void coordinateTest() {
	Coordinate c1 = new Coordinate(2, 3);
	Picture p1 = new PictureImpl(4, 5);
	p1.setPixel(c1, WHITE);
	assertEquals("Coordinate Setter not properly working", p1.getPixel(2, 3), WHITE);
	c1 = new Coordinate(0, 0);
	p1.setPixel(c1, RED);
	assertEquals("Coordinate Setter not properly working", p1.getPixel(0, 0), RED);
    }

    @Test
    public void coordinateExtractTest() {
	Coordinate c1 = new Coordinate(2, 2);
	Coordinate c2 = new Coordinate(3, 3);
	Picture p1 = new PictureImpl(4, 5);
	p1.setPixel(c1, WHITE);
	p1.setPixel(c2, RED);
	p1.setPixel(2, 3, BLUE);
	p1.setPixel(3, 2, BLACK);
	SubPicture s1 = p1.extract(c1, c2);
	assertEquals("Pixel retrieved from Subpicture does not match source", s1.getPixel(0, 0), WHITE);
	assertEquals("Pixel retrieved from Subpicture does not match source", s1.getPixel(1, 0), BLACK);
	assertEquals("Pixel retrieved from Subpicture does not match source", s1.getPixel(0, 1), BLUE);
	assertEquals("Pixel retrieved from Subpicture does not match source", s1.getPixel(1, 1), RED);
    }
}

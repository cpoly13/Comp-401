package a5.brandybs;

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
	String[] test_names = new String[3];

	test_names[0] = "getSetPixelTest";
	test_names[1] = "testExtract";
	test_names[2] = "testIterator";
	return test_names;
    }

    @Test
    public void getSetPixelTest() {
	Picture p = new PictureImpl(3, 3);

	Coordinate eff = new Coordinate(0, 2);
	Coordinate gee = new Coordinate(2, 2);

	p.setPixel(0, 0, GREEN);
	p.setPixel(1, 0, GREEN);
	p.setPixel(2, 0, GREEN);
	p.setPixel(0, 1, BLUE);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, BLUE);
	p.setPixel(eff, WHITE);
	p.setPixel(1, 2, RED);
	p.setPixel(gee, BLACK);

	new Coordinate(2, 0);
	new Coordinate(1, 1);
	Coordinate cee = new Coordinate(0, 0);
	Coordinate dee = new Coordinate(2, 1);

	assertEquals("Result from getPixel does not match correct pixel", p.getPixel(0, 0), p.getPixel(cee));
	assertEquals("Result from getPixel does not match correct pixel", p.getPixel(2, 1), p.getPixel(dee));
	assertEquals("Result from getPixel does not match correct pixel", p.getPixel(0, 2), p.getPixel(eff));
	assertEquals("Result from getPixel does not match correct pixel", p.getPixel(2, 2), p.getPixel(gee));
    }

    @Test
    public void testExtract() {
	Picture p = new PictureImpl(4, 4);
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, RED);
	p.setPixel(2, 0, RED);
	p.setPixel(3, 0, BLUE);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, BLUE);
	p.setPixel(2, 1, WHITE);
	p.setPixel(3, 1, RED);
	p.setPixel(0, 2, BLACK);
	p.setPixel(1, 2, BLACK);
	p.setPixel(2, 2, RED);
	p.setPixel(3, 2, WHITE);
	p.setPixel(0, 3, RED);
	p.setPixel(1, 3, BLUE);
	p.setPixel(2, 3, BLACK);
	p.setPixel(3, 3, GREEN);

	Coordinate ayy = new Coordinate(1, 1);
	Coordinate bee = new Coordinate(2, 2);
	Coordinate cee = new Coordinate(3, 3);
	new Coordinate(3, 2);

	SubPicture subby = p.extract(ayy, cee);
	assertEquals("Pixel retrieved from subpicture doesn't match og pic", p.getPixel(1, 1), subby.getPixel(0, 0));
	assertEquals("Pixel retrieved from subpicture doesn't match og pic", p.getPixel(1, 2), subby.getPixel(0, 1));
	assertEquals("Pixel retrieved from subpicture doesn't match og pic", p.getPixel(3, 2), subby.getPixel(2, 1));
	assertEquals("Pixel retrieved from subpicture doesn't match og pic", p.getPixel(2, 3), subby.getPixel(1, 2));

	SubPicture subster = p.extract(ayy, bee);
	assertEquals("Pixel retrieved from subpicture doesn't match og pic", p.getPixel(1, 2), subster.getPixel(0, 1));
	assertEquals("Pixel retrieved from subpicture doesn't match og pic", p.getPixel(2, 2), subby.getPixel(1, 1));
    }

    @Test
    public void testIterator() {
	Picture p = new PictureImpl(2, 2);

	p.setPixel(0, 0, BLUE);
	p.setPixel(1, 0, WHITE);

	p.setPixel(0, 1, RED);
	p.setPixel(1, 1, RED);

	Iterator<Pixel> weirdo = p.iterator();
	assertEquals("Pixel returned from next does not match", p.getPixel(0, 0), weirdo.next());
	assertEquals("Pixel returned from next does not match", p.getPixel(1, 0), weirdo.next());
	assertEquals("Pixel returned from next does not match", p.getPixel(0, 1), weirdo.next());
	assertEquals("Pixel returned from next does not match", p.getPixel(1, 1), weirdo.next());

    }
}

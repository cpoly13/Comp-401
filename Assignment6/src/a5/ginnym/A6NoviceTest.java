package a5.ginnym;

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
    private static final Coordinate c = new Coordinate(1, 1);
    private static final Coordinate d = new Coordinate(2, 2);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "exampleTest";
	test_names[1] = "testhasNext";
	test_names[2] = "testExtract";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void testhasNext() {
	Picture pic = new PictureImpl(69, 69);
	Iterator<Pixel> i = pic.iterator();
	assertEquals("The iterator is faulty", i.hasNext(), true);
    }

    @Test
    public void testExtract() {
	Picture pic = new PictureImpl(3, 3);
	pic.setPixel(0, 0, RED);
	pic.setPixel(1, 0, RED);
	pic.setPixel(2, 0, RED);
	pic.setPixel(0, 1, GREEN);
	pic.setPixel(1, 1, BLUE);
	pic.setPixel(2, 1, WHITE);
	pic.setPixel(0, 2, BLACK);
	pic.setPixel(1, 2, BLACK);
	pic.setPixel(2, 2, RED);
	SubPicture subPic = pic.extract(c, d);
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
		pic.getPixel(0, 0), subPic.getPixel(1, 1));
    }
}

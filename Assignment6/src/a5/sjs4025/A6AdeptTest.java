package a5.sjs4025;

//Contributors: Quentin Hawkins & Krishan Patel

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
    public static final Pixel RED = new ColorPixel(1, 0, 0);
    public static final Pixel GREEN = new ColorPixel(0, 1, 0);
    public static final Pixel BLUE = new ColorPixel(0, 0, 1);
    public static final Pixel WHITE = new GrayPixel(0);
    public static final Pixel BLACK = new GrayPixel(1);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "testSampleIterator";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void testSampleIterator() {
	Picture p = new PictureImpl(10, 6);
	int x = 1;
	int y = 3;
	int dx = 2;
	int dy = 2;
	Iterator<Pixel> iterTest = p.sample(x, y, dx, dy);
	while (iterTest.hasNext()) {
	    p.setPixel(x, y, RED);
	    if (x + dx < p.getWidth()) {
		x += dx;
	    } else {
		y += dy;
		x = dx + x - p.getWidth();
	    }
	    assertEquals(iterTest.next(), RED);
	}
    }
}
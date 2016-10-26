package a5.krishan;

//collabs: quentin hawkins and steven sin
import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

    public static final Pixel RED = new ColorPixel(1, 0, 0);

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
	int y = 2;
	int dx = 2;
	int dy = 3;
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

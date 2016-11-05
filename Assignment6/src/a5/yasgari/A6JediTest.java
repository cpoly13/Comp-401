package a5.yasgari;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.GrayPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "testZigZag";

	return test_names;
    }

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);

    @Test
    public void testZigZag() {
	Picture p = new PictureImpl(3, 3);
	Iterator<Pixel> zigZagIter = p.zigzag();
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, GREEN);
	p.setPixel(2, 0, BLUE);
	p.setPixel(0, 1, RED);
	p.setPixel(0, 2, GREEN);
	p.setPixel(1, 1, WHITE);
	p.setPixel(1, 2, RED);
	p.setPixel(2, 1, BLUE);
	p.setPixel(2, 2, RED);

	while (zigZagIter.hasNext()) {
	    assertTrue(zigZagIter.next().equals(p.getPixel(0, 0)));
	    assertTrue(zigZagIter.next().equals(p.getPixel(1, 0)));
	    assertTrue(zigZagIter.next().equals(p.getPixel(0, 1)));
	    assertTrue(zigZagIter.next().equals(p.getPixel(0, 2)));
	    assertTrue(zigZagIter.next().equals(p.getPixel(1, 1)));
	    assertTrue(zigZagIter.next().equals(p.getPixel(2, 0)));
	    assertTrue(zigZagIter.next().equals(p.getPixel(2, 1)));
	    assertTrue(zigZagIter.next().equals(p.getPixel(1, 2)));
	    assertTrue(zigZagIter.next().equals(p.getPixel(2, 2)));

	}
    }

}

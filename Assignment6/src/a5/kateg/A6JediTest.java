package a5.kateg;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagIteratorTest";

	return test_names;
    }

    @Test
    public void zigzagIteratorTest() {
	Picture p = new PictureImpl(5, 5);
	p.setPixel(0, 0, GREEN);
	p.setPixel(1, 0, RED);
	Iterator<Pixel> zigzag_iter = p.zigzag();
	assertEquals("zigzag iterator not working", zigzag_iter.next(), GREEN);
	assertEquals("zigzag iterator not working", zigzag_iter.next(), RED);

    }
}

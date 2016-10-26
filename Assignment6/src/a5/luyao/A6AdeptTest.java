package a5.luyao;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "sampleIterTest";

	return test_names;
    }

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Coordinate X = new Coordinate(3, 1);
    private static final Coordinate Y = new Coordinate(7, 1);
    private static final Coordinate Z = new Coordinate(3, 4);
    private static final Coordinate W = new Coordinate(7, 4);

    @Test
    public void exampleTest() {

    }

    @Test
    public void sampleIterTest() {

	Picture a = new PictureImpl(10, 6);

	a.setPixel(X, RED);
	a.setPixel(Y, GREEN);
	a.setPixel(Z, BLUE);
	a.setPixel(W, RED);

	Iterator<Pixel> sampleOne = a.sample(3, 1, 4, 3);
	assertEquals("1st pixel get by the iterator is wrong", RED, sampleOne.next());
	assertEquals("2rd pixel get by the iterator is wrong", GREEN, sampleOne.next());
	assertEquals("3rd pixel get by the iterator is wrong", BLUE, sampleOne.next());
	assertEquals("4th pixel get by the iterator is wrong", RED, sampleOne.next());
	assertFalse("unexpected pixel", sampleOne.hasNext());

    }
}

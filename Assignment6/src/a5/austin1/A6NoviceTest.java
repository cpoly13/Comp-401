package a5.austin1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "basicCoordinateTest";
	test_names[1] = "pictureOvlTest";
	test_names[2] = "iteratorTest";

	return test_names;
    }

    @Test
    public void basicCoordinateTest() {
	Coordinate testCoord = new Coordinate(5, 7);
	assertEquals(testCoord.getX(), 5);
	assertEquals(testCoord.getY(), 7);
    }

    @Test
    public void pictureOvlTest() {
	PictureImpl testPic = new PictureImpl(5, 5);

	Coordinate c1 = new Coordinate(3, 4);
	testPic.setPixel(3, 4, RED);
	assertEquals(testPic.getPixel(c1), RED);

	Coordinate c2 = new Coordinate(4, 3);
	testPic.setPixel(c2, GREEN);
	assertEquals(testPic.getPixel(4, 3), GREEN);

	Coordinate c3 = new Coordinate(3, 3);
	Coordinate c4 = new Coordinate(4, 4);
	SubPicture extractTest = testPic.extract(c3, c4);
	assertEquals(extractTest.getPixel(0, 1), testPic.getPixel(c1));
	assertEquals(extractTest.getPixel(1, 0), testPic.getPixel(c2));
    }

    @Test
    public void iteratorTest() {
	PictureImpl testPic = new PictureImpl(5, 5);
	Iterator<Pixel> iter1 = testPic.iterator();

	Coordinate c1 = new Coordinate(3, 4);
	testPic.setPixel(c1, BLUE);

	Coordinate c2 = new Coordinate(4, 3);
	testPic.setPixel(c2, BLUE);

	for (int i = 0; i < 25; i++) {
	    if (i == 19 || i == 23) {
		assertEquals(iter1.next(), BLUE);
		continue;
	    }
	    iter1.next();
	}

	assertEquals(iter1.hasNext(), false);
    }
}

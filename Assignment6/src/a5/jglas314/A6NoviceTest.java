package a5.jglas314;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

//import a4adept.ColorPixel;
//import a4adept.GrayPixel;
//import a4adept.Pixel;
import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "pictureIteratorTest";
	test_names[1] = "inputValidationTest";
	return test_names;
    }

    @Test
    public void pictureIteratorTest() {
	Coordinate c1 = new Coordinate(0, 0);
	Coordinate c2 = new Coordinate(1, 0);
	Coordinate c3 = new Coordinate(2, 0);
	Coordinate c4 = new Coordinate(0, 1);
	Coordinate c5 = new Coordinate(1, 1);
	Coordinate c6 = new Coordinate(2, 1);
	Coordinate c7 = new Coordinate(0, 2);
	Coordinate c8 = new Coordinate(1, 2);
	Coordinate c9 = new Coordinate(2, 2);
	Coordinate[] cList = { c1, c2, c3, c4, c5, c6, c7, c8, c9 };
	Coordinate[] cList2 = { c1, c2, c4, c5 };

	Picture p1 = new PictureImpl(3, 3);

	p1.setPixel(c1, RED);
	p1.setPixel(c2, GREEN);
	p1.setPixel(c3, BLUE);
	p1.setPixel(c4, WHITE);
	p1.setPixel(c5, BLACK);
	p1.setPixel(c6, RED);
	p1.setPixel(c7, WHITE);
	p1.setPixel(c8, BLACK);
	p1.setPixel(c9, RED);

	Picture p1sub = p1.extract(c5, c9);

	Iterator<Pixel> iter1 = p1.iterator();
	Iterator<Pixel> iter2 = p1sub.iterator();

	for (int i = 0; i < 9; i++) {
	    assertEquals(p1.getPixel(cList[i]), iter1.next());
	}

	for (int j = 0; j < 4; j++) {
	    assertEquals(p1sub.getPixel(cList2[j]), iter2.next());
	}

    }

    @Test
    public void inputValidationTest() {
	Coordinate c1 = new Coordinate(0, 0);
	Coordinate c2 = new Coordinate(0, 1);
	Coordinate c3 = new Coordinate(0, 2);
	Coordinate c4 = new Coordinate(1, 0);
	Coordinate c5 = new Coordinate(1, 1);
	Coordinate c6 = new Coordinate(1, 2);
	Coordinate c7 = new Coordinate(2, 0);
	Coordinate c8 = new Coordinate(2, 1);
	Coordinate c9 = new Coordinate(2, 2);

	Picture p1 = new PictureImpl(3, 3);

	p1.setPixel(c1, RED);
	p1.setPixel(c2, GREEN);
	p1.setPixel(c3, BLUE);
	p1.setPixel(c4, WHITE);
	p1.setPixel(c5, BLACK);
	p1.setPixel(c6, RED);
	p1.setPixel(c7, WHITE);
	p1.setPixel(c8, BLACK);
	p1.setPixel(c9, RED);

	Picture p1sub = p1.extract(c5, c9);

	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p1.getPixel(c5),
		p1sub.getPixel(c1));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p1.getPixel(c8),
		p1sub.getPixel(c4));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p1.getPixel(c6),
		p1sub.getPixel(c2));
	assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source", p1.getPixel(c9),
		p1sub.getPixel(c5));

	try {
	    p1sub.getPixel(c3);
	    fail("Expected IllegalArgumentException for coordinate out of range");
	} catch (RuntimeException e) {
	}

    }

}

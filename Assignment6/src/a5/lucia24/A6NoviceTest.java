package a5.lucia24;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
    private static final Coordinate C1 = new Coordinate(1, 1);
    private static final Coordinate C2 = new Coordinate(2, 2);
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "testCoordinates";
	test_names[1] = "iteratorTest";

	return test_names;
    }

    @Test
    public void testCoordinates() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 0, RED);
	p.setPixel(C1, RED);
	p.setPixel(0, 2, GREEN);
	p.setPixel(2, 1, BLUE);
	p.setPixel(C2, BLUE);

	SubPicture sp = p.extract(C1, C2);
	sp.setPixel(0, 1, GREEN);

	assertEquals("", p.getPixel(C1), sp.getPixel(0, 0));
	assertEquals("", p.getPixel(2, 1), sp.getPixel(C1));
	assertEquals("", p.getPixel(0, 2), sp.getPixel(0, 1));

    }

    @Test
    public void iteratorTest() {
	Picture p = new PictureImpl(3, 3);
	for (int w = 0; w < 3; w++) {
	    for (int h = 0; h < 3; h++) {
		p.setPixel(w, h, GREEN);
	    }
	}
	for (int i = 0; i < 11; i++) {
	    if (p.iterator().hasNext()) {
		assertEquals("", p.iterator().next(), GREEN);
	    }
	    if (p.iterator().hasNext() == false) {
		try {
		    assertEquals("", p.iterator().next(), GREEN);
		    fail("expected stuff");
		} catch (NoSuchElementException e) {
		} catch (RuntimeException e) {
		    fail("don't do that bro");
		}
	    }
	}
    }

}

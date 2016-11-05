package a5.yizhongz;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "coordinateTest";
	test_names[1] = "iteratorTest";

	return test_names;
    }

    @Test
    public void coordinateTest() { // test coordinate
	Coordinate a = new Coordinate(1, 2);
	assertEquals("Result from getX() does not match", 1, a.getX());
	assertEquals("Result from getY() does not match", 2, a.getY());
    }

    @Test
    public void iteratorTest() { // test hasNest method
	Picture p = new PictureImpl(3, 4);
	Iterator<Pixel> i = p.iterator();
	assertEquals("hasNext doesn't work", i.hasNext(), true);

	assertEquals("next doesn't work", i.next(), p.getPixel(0, 0));
    }

}

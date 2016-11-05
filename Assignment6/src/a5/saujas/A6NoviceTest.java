
package a5.saujas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "exceptionTest";
	test_names[1] = "iteratorTest";
	test_names[2] = "extractTest";

	return test_names;
    }

    @Test
    public void exeptionTest() {
	Picture p = new PictureImpl(2, 3);
	Coordinate c = new Coordinate(1, 2);
	try {
	    p.setPixel(c, null);
	    fail("Expected RuntimeException for null parameter");
	} catch (RuntimeException e) {

	}
    }

    @Test
    public void iteratorTest() {
	Picture p = new PictureImpl(2, 3);
	Iterator<Pixel> it = p.iterator();

	for (int i = 0; i < 6; i++) {
	    it.next();
	}
	try {
	    it.next();
	    fail("Expected NoSuchElementException for mismatched heights of horizontal stack components");
	} catch (java.util.NoSuchElementException e) {

	}
    }

    @Test
    public void extractTest() {
	Picture p = new PictureImpl(3, 3);
	assertTrue("Extract does not return correct SubPicture when using Coordinates",
		comparePicture(p.extract(new Coordinate(0, 0), new Coordinate(2, 2)), p.extract(0, 0, 3, 3)));
    }

    private static boolean comparePixels(Pixel a, Pixel b) {
	return ((Math.abs(a.getRed() - b.getRed()) < 0.001) && (Math.abs(a.getGreen() - b.getGreen()) < 0.001)
		&& (Math.abs(a.getBlue() - b.getBlue()) < 0.001));
    }

    private static boolean comparePicture(Picture a, Picture b) {
	boolean equality = false;
	Iterator<Pixel> itrA = a.iterator();
	Iterator<Pixel> itrB = b.iterator();
	while (itrA.hasNext() && itrB.hasNext()) {
	    equality |= comparePixels(itrA.next(), itrB.next());
	}
	if (itrB.hasNext() || itrA.hasNext()) {
	    equality = false;
	}

	return equality;
    }

}

package a5.thrisha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import a6jedi.Coordinate;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.SubPicture;
import a6jedi.SubPictureImpl;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[5];

	test_names[0] = "testCoordinates";
	test_names[1] = "testNoNegatives";
	test_names[2] = "catchPixels";
	test_names[3] = "otherCoordinateTest";
	test_names[4] = "lastTest";
	return test_names;
    }

    @Test
    public void testCoordinates() {
	Coordinate a = new Coordinate(6, 7);
	Picture pic = new PictureImpl(8, 8);

	Coordinate b = new Coordinate(1, 1);
	Coordinate c = new Coordinate(3, 3);
	SubPicture subPic = pic.extract(b, c);
	assertEquals(3, subPic.getWidth());
	assertNotNull(pic.extract(b, a));

    }

    @Test
    public void testNoNegatives() {
	new Coordinate(6, 7);
	Picture pic = new PictureImpl(8, 8);

	Coordinate b = new Coordinate(1, 1);
	Coordinate c = new Coordinate(3, 3);
	SubPicture subPic = pic.extract(b, c);

	try {
	    subPic.extract(-1, 0, -1, -1);
	    subPic.extract(0, 0, -1, -1);
	    subPic.extract(0, -1, -1, -1);
	    subPic.extract(-1, -1, -1, -1);
	    subPic.extract(-1, -1, -1, 0);
	    ;

	    fail("setPixel on transformed pixel should throw IllegalArgumentException");
	} catch (Exception e) {
	}

    }

    @Test
    public void catchPixels() {
	Picture p = new PictureImpl(3, 3);

	try {
	    new SubPictureImpl(p, 3, 2, 4, 1);
	    fail("Expected IllegalArgumentException");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("Expected IllegalArgumentException but got generic RuntimeException");
	}

    }

    @Test
    public void otherCoordinateTest() {

	Coordinate a = new Coordinate(6, 7);

	assertEquals("Coordinate x retrieved from subpicture does not match expected coordinate value from source", 6,
		a.getX());
	assertEquals("Coordinate y retrieved from subpicture does not match expected coordinate value from source", 7,
		a.getY());

    }

    @Test
    public void lastTest() {

	Coordinate b = new Coordinate(3, 8);

	assertEquals("Coordinate x retrieved from subpicture does not match expected coordinate value from source", 3,
		b.getX());
	assertEquals("Coordinate y retrieved from subpicture does not match expected coordinate value from source", 8,
		b.getY());

    }
}

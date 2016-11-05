package a5.sam4364;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.SubPicture;

public class A6NoviceTest {

    static public String[] getTestNames() {

	// test_names[0] = "coordinateTest";
	// test_names[1] = "extractTest";

	// return test_names;

	return new String[] { "coordinateTest", "extractTest" };
    }

    @Test
    public void coordinateTest() {

	Coordinate c = new Coordinate(2, 4);
	assertEquals("Result from getX() does not match x", 2, c.getX());
	assertEquals("Result from getY() does not match y", 4, c.getY());

	Coordinate c2 = new Coordinate(3, 1);
	assertEquals("Result from getX() does not match x", 3, c2.getX());
	assertEquals("Result from getY() does not match y", 1, c2.getY());
    }

    @Test
    public void extractTest() {
	Picture p = new PictureImpl(6, 4);
	Coordinate c1 = new Coordinate(2, 2);
	Coordinate c2 = new Coordinate(3, 3);
	SubPicture s = p.extract(c1, c2);
	assertEquals(2, s.getWidth());
    }

}

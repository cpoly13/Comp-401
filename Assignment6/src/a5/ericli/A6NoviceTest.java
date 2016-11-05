package a5.ericli;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "extractTest";
	test_names[1] = "getYTest";
	test_names[2] = "getXTest";
	return test_names;
    }

    @Test
    public void extractTest() {
	Picture p = new PictureImpl(5, 5);
	Coordinate a = new Coordinate(1, 1);
	Coordinate b = new Coordinate(2, 2);
	SubPicture subPic = p.extract(a, b);
	assertEquals(2, subPic.getWidth());
    }

    @Test
    public void getYTest() {
	Coordinate c = new Coordinate(4, 5);
	assertEquals(5, c.getY());
    }

    @Test
    public void getXTest() {
	Coordinate d = new Coordinate(4, 7);
	assertEquals(4, d.getX());
    }

}

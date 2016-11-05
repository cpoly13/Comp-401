package a5.carly20;

import static org.junit.Assert.*;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "outOfBoundsTest";

	return test_names;
    }

    @Test
    public void outOfBoundsTest() {
	Picture p = new PictureImpl(6, 4);
	SubPicture sp = new SubPictureImpl(p, 3, 2, 1, 1);
	try {
	    sp.tile(10, 4);
	    fail("Tile is out of bounds");
	} catch (IllegalArgumentException e) {
	} catch (RuntimeException e) {
	    fail("goodbye");
	}
    }
}

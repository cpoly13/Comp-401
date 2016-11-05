package a5.ericaly;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigZaggerTestFour";

	return test_names;
    }

    @Test
    public void zigZaggerTestFour() {
	Picture p = new PictureImpl(8, 8);
	Iterator<Pixel> zigZagPic = p.zigzag();
	assertEquals("Wrong, try again", p.getPixel(0, 0), zigZagPic.next());
    }
}

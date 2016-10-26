package a5.isharma;

import static org.junit.Assert.*;
//collaborated with Ashish Khanchandani 
import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "zigzagTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void zigzagTest() {
	Picture p = new PictureImpl(4, 4);
	Iterator<Pixel> iter = p.zigzag();
	assertEquals("zigzag doesn't work", true, iter.hasNext());

    }
}

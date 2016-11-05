package a5.sjs4025;

//Contributors: Quentin Hawkins & Krishan Patel

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "zigZagTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void zigZagTest() {
	Picture p = new PictureImpl(6, 6);
	Pixel a = new ColorPixel(1, 0, 1);
	p.setPixel(0, 0, a);
	Iterator<Pixel> zigZagPic = p.zigzag();
	assertEquals(a, zigZagPic.next());
    }
}

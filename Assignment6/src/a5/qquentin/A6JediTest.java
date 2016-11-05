package a5.qquentin;

//Steven Sin and Krishan Patel
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
	Picture p = new PictureImpl(7, 7);
	Pixel e = new ColorPixel(0, 1, 1);
	p.setPixel(0, 0, e);
	Iterator<Pixel> zigPic = p.zigzag();
	assertEquals(e, zigPic.next());
    }

}

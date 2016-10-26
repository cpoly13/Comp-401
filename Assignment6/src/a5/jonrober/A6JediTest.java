package a5.jonrober;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "testZigZag";
	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void testZigZag() {
	Picture source = new PictureImpl(10, 10);
	Iterator<Pixel> zigZaggedPicture = source.zigzag();
	assertEquals("Zig Zag values invalid", source.getPixel(0, 0), zigZaggedPicture.next());
    }
}

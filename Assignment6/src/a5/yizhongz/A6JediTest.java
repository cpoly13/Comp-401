package a5.yizhongz;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigzagTest";

	return test_names;
    }

    @Test
    public void zigzagTest() { // test zigzag method
	Picture source = new PictureImpl(5, 5);
	Iterator<Pixel> zig = source.zigzag();
	assertEquals("zigzag does not work", source.getPixel(0, 0), zig.next());
	assertEquals("zigzag does not work", source.getPixel(1, 0), zig.next());
	assertEquals("zigzag does not work", source.getPixel(0, 1), zig.next());
	assertEquals("zigzag does not work", source.getPixel(0, 2), zig.next());
    }
}

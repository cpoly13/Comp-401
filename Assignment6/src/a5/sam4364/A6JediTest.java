package a5.sam4364;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {

	// test_names[0] = "zigZagIteratorTest";

	// return test_names;

	return new String[] { "zigZagIteratorTest" };
    }

    @Test
    public void zigZagIteratorTest() {
	Picture source = new PictureImpl(8, 8);
	Pixel newPixel = new ColorPixel(1.0, 0.0, 0.0);
	Pixel changedPixel = source.getPixel(0, 0).blend(newPixel, 0.0);
	source.setPixel(0, 0, changedPixel);
	Iterator<Pixel> zigZaggedPicture = source.zigzag();
	assertEquals(source.getPixel(0, 0), zigZaggedPicture.next());
    }
}

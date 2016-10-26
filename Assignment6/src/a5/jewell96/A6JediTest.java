package a5.jewell96;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigZagIteratorTest";

	return test_names;
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

// True, like if statement, checks to see if the condition is true
// Equals, checks equality (boxes)

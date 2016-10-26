package a5.uri;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "zigZagTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void zigzagTest() {
	Picture q = new PictureImpl(3, 3);
	Iterator<Pixel> iter = q.zigzag();

	assertTrue(iter.next().getIntensity() == q.getPixel(0, 0).getIntensity());
	assertTrue(iter.next().getIntensity() == q.getPixel(1, 0).getIntensity());
	assertTrue(iter.next().getIntensity() == q.getPixel(0, 1).getIntensity());
	assertTrue(iter.next().getIntensity() == q.getPixel(1, 1).getIntensity());
    }
}

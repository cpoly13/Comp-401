package a5.ktran19;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "sampleTest";

	return test_names;
    }

    @Test
    public void sampleTest() {
	Picture pic = new PictureImpl(15, 10);
	Coordinate c = new Coordinate(2, 3);
	Iterator<Pixel> sample_iter = pic.sample(2, 3, 3, 4);
	Pixel p = sample_iter.next();
	assertEquals(pic.getPixel(c), p);

    }
}

package a5.gatassi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.SubPicture;

public class A6AdeptTest {
    private final Picture p = new PictureImpl(4, 5);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "iterTestXBound";
	test_names[1] = "window_iter_Test";

	return test_names;
    }

    @Test
    public void iterTestXBound() {
	try {
	    p.sample(0, 0, 5, 0);
	    fail("changed x cannot be outside of picture");
	} catch (IllegalArgumentException e) {
	    
	}
    }

    @Test
    public void window_iter_Test() {
	Picture source = new PictureImpl(5, 5);
	Iterator<SubPicture> window_iter = source.window(3, 2);
	assertEquals(window_iter.next().getPixel(0, 0).getIntensity(),
		p.extract(0, 0, 3, 2).getPixel(0, 0).getIntensity(), .0001);
    }
}

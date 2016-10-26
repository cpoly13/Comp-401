package a5.jonlh;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "sampleTest";

	return test_names;
    }

    @Test
    public void sampleTest() {
	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> iter = p.sample(0, 0, 1, 1);
	assertEquals(iter.next(), p.getPixel(0, 0));
    }
}

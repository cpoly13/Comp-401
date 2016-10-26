package a5.meli727;

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
    public void zigzagTest() {
	Picture source = new PictureImpl(8, 8);

	Iterator<Pixel> zigPic = source.zigzag();
	assertTrue("zigzag test", source.getPixel(2, 2).getIntensity() == zigPic.next().getIntensity());
	assertTrue("zigzag test", source.getPixel(4, 5).getIntensity() == zigPic.next().getIntensity());
	assertTrue("zigzag test", source.getPixel(0, 0).getIntensity() == zigPic.next().getIntensity());
	assertTrue("zigzag test", source.getPixel(7, 7).getIntensity() == zigPic.next().getIntensity());
    }
}

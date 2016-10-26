package a5.jeroen;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "jediTest";

	return test_names;
    }

    @Test
    public void jediTest() {

	Picture p1 = new PictureImpl(8, 8);
	p1.setPixel(2, 0, randomPixel());
	p1.setPixel(3, 0, randomPixel());
	p1.setPixel(2, 1, randomPixel());
	p1.setPixel(1, 2, randomPixel());

	Iterator<Pixel> zigzag_iter = p1.zigzag();

	for (int x = 0; x < 5; x++) {
	    zigzag_iter.next();
	}

	assertEquals("Zigzag itinerator doesn't work right. All your base are belong to us.",
		zigzag_iter.next().equals(p1.getPixel(2, 0)), true);

	assertEquals("Zigzag itinerator doesn't work right. You have no chance to survive make your time.",
		zigzag_iter.next().equals(p1.getPixel(3, 0)), true);

	assertEquals("Zigzag itinerator doesn't work right. Take off every \'ZIG\'.",
		zigzag_iter.next().equals(p1.getPixel(2, 1)), true);

	assertEquals("Zigzag itinerator doesn't work right. For great justice.",
		zigzag_iter.next().equals(p1.getPixel(1, 2)), true);
    }

    public static Pixel randomPixel() {
	return new ColorPixel(Math.random(), Math.random(), Math.random());
    }
}

package a5.wtcarter;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "exampleTest";
	test_names[1] = "zigzagTestOfChampions";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void zigzagTestOfChampions() {

	Picture pic = new PictureImpl(5, 3);
	Iterator<Pixel> iter = pic.zigzag();

	pic.setPixel(1, 0, new GrayPixel(0.3));
	pic.setPixel(2, 0, new GrayPixel(0.2));
	pic.setPixel(3, 0, new GrayPixel(0.3));
	pic.setPixel(4, 0, new GrayPixel(0.4));
	pic.setPixel(1, 1, new GrayPixel(0.8));
	pic.setPixel(2, 1, new GrayPixel(0.7));
	pic.setPixel(3, 1, new GrayPixel(0));

	String expected = ">D>>-XD:>>#<>>>";
	String result = "";

	while (iter.hasNext()) {
	    result += iter.next().getChar();
	}

	if (!(result.equals(expected))) {
	    fail("Iterator did not follow expected path");
	}
    }
}

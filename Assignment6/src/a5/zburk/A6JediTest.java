package a5.zburk;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @org.junit.Before
    public void setUp() throws Exception {
	System.setOut(new PrintStream(outContent));
    }

    @org.junit.After
    public void tearDown() throws Exception {
	System.setOut(null);
    }

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "exampleTest";
	test_names[1] = "zigZagIterator";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void zigZagIterator() {
	Picture p = new PictureImpl(3, 3);
	p.setPixel(0, 1, new GrayPixel(0.11));
	p.setPixel(0, 2, new GrayPixel(0.21));
	p.setPixel(1, 0, new GrayPixel(0.41));
	p.setPixel(1, 2, new GrayPixel(0.51));
	p.setPixel(2, 1, new GrayPixel(0.61));
	p.setPixel(2, 2, new GrayPixel(0.71));

	Iterator<Pixel> sample_iter = p.zigzag();

	while (sample_iter.hasNext()) {
	    System.out.println(sample_iter.next().getChar());
	}

	String output = ">\n" + "<\n" + "M\n" + "X\n" + ">\n" + ">\n" + "s\n" + ">\n" + ":\n";

	assertEquals(output, outContent.toString());
    }
}

package a5.zburk;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import a6adept.*;

public class A6AdeptTest {

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
	String[] test_names = new String[5];

	test_names[0] = "exampleTest";
	test_names[1] = "sample";
	test_names[1] = "window";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void sample() {
	Picture p = new PictureImpl(15, 10);
	p.setPixel(2, 3, new GrayPixel(0.1));
	p.setPixel(5, 3, new GrayPixel(0.2));
	p.setPixel(8, 3, new GrayPixel(0.3));
	p.setPixel(11, 3, new GrayPixel(0.4));
	p.setPixel(14, 3, new GrayPixel(0.5));
	p.setPixel(2, 7, new GrayPixel(0.6));
	p.setPixel(5, 7, new GrayPixel(0.7));
	p.setPixel(8, 7, new GrayPixel(0.8));

	Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);

	while (sample_iter.hasNext()) {
	    System.out.println(sample_iter.next().getChar());
	}
	String output = "M\n" + "X\n" + "D\n" + "<\n" + ">\n" + "s\n" + ":\n" + "-\n" + ">\n" + ">\n +\n";

	assertEquals(output, outContent.toString());
    }

    @Test
    public void window() {
	Picture p = new PictureImpl(5, 5);
	Iterator<SubPicture> window_iter = p.window(3, 2);
	// Skip over SubPictures created to the last one
	window_iter.next();
	window_iter.next();
	window_iter.next();
	window_iter.next();
	window_iter.next();
	window_iter.next();
	window_iter.next();
	window_iter.next();
	window_iter.next();
	window_iter.next();
	window_iter.next();

	assertEquals(p.getPixel(4, 4), window_iter.next().getPixel(2, 1));
    }

}

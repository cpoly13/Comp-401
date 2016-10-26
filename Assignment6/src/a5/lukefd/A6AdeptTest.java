package a5.lukefd;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "exampleTest";
	test_names[1] = "sampleTest";
	test_names[2] = "windowTest";
	test_names[3] = "tileTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void sampleTest() {
	Pixel red = new ColorPixel(1, 0, 0);
	Picture p = new PictureImpl(15, 10);
	p.setPixel(2, 3, red);
	Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);

	assertEquals("Pixel returned by iterator does not match expected value.", red, sample_iter.next());
    }

    @Test
    public void windowTest() {
	Picture p = new PictureImpl(5, 5);
	Iterator<SubPicture> window_iter = p.window(3, 2);
	SubPicture t = window_iter.next();

	assertEquals("Tile height returned by iterator does not match expected value.",
		p.extract(0, 0, 3, 2).getHeight(), t.getHeight());
	assertEquals("Tile width returned by iterator does not match expected value.", p.extract(0, 0, 3, 2).getWidth(),
		t.getWidth());
	assertEquals("Tile xOffSet returned by iterator does not match expected value.",
		p.extract(0, 0, 3, 2).getXOffset(), t.getXOffset());
	assertEquals("Tile yOffSet returned by iterator does not match expected value.",
		p.extract(0, 0, 3, 2).getYOffset(), t.getYOffset());
    }

    @Test
    public void tileTest() {
	Picture p = new PictureImpl(5, 5);
	Iterator<SubPicture> tile_iter = p.tile(2, 2);
	SubPicture t = tile_iter.next();

	assertEquals("Tile height returned by iterator does not match expected value.",
		p.extract(0, 0, 2, 2).getHeight(), t.getHeight());
	assertEquals("Tile width returned by iterator does not match expected value.", p.extract(0, 0, 2, 2).getWidth(),
		t.getWidth());
	assertEquals("Tile xOffSet returned by iterator does not match expected value.",
		p.extract(0, 0, 2, 2).getXOffset(), t.getXOffset());
	assertEquals("Tile yOffSet returned by iterator does not match expected value.",
		p.extract(0, 0, 2, 2).getYOffset(), t.getYOffset());
    }
}

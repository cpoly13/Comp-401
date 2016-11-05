package a5.ajacober;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	return new String[] { "testSampleIterator", "testWindowIterator", "testTileIterator" };
    }

    @Test
    public void testSampleIterator() {
	Coordinate c1 = new Coordinate(4, 2);
	Pixel p1 = new GrayPixel(0.5);
	Picture pic = new PictureImpl(10, 10);
	pic.setPixel(2, 3, p1);
	Iterator<Pixel> sample_iter = pic.sample(2, 3, 3, 4);

	assertTrue("Sample Iterator returning incorrect first Pixel", p1.getIntensity() == sample_iter.next().getIntensity());
	assertTrue("Sample Iterator returning incorrect coordinates", pic.getPixel(c1).getIntensity() == sample_iter.next().getIntensity());
    }

    @Test
    public void testWindowIterator() {
	Pixel p1 = new GrayPixel(0.5);
	Picture pic = new PictureImpl(10, 10);
	SubPicture sub = pic.extract(0, 0, 3, 2);
	pic.setPixel(2, 3, p1);
	Iterator<SubPicture> window_iter = pic.window(3, 2);

	assertEquals("Window Iterator returning Subpicture with incorrect source", sub.getSource(),
		window_iter.next().getSource());
	assertEquals("Window Iterator returning Subpicture with incorrect width", sub.getWidth(),
		window_iter.next().getWidth());
	assertEquals("Window Iterator returning Subpicture with incorrect height", sub.getHeight(),
		window_iter.next().getHeight());
    }

    @Test
    public void testTileIterator() {
	Pixel p1 = new GrayPixel(0.5);
	Picture pic = new PictureImpl(10, 10);
	SubPicture sub = pic.extract(0, 0, 2, 2);
	pic.setPixel(2, 3, p1);
	Iterator<SubPicture> tile_iter = pic.tile(2, 2);

	assertEquals("Tile Iterator returning Subpicture with incorrect source", sub.getSource(),
		tile_iter.next().getSource());
	assertEquals("Tile Iterator returning Subpicture with incorrect width", sub.getWidth(),
		tile_iter.next().getWidth());
	assertEquals("Tile Iterator returning Subpicture with incorrect height", sub.getHeight(),
		tile_iter.next().getHeight());
    }
}

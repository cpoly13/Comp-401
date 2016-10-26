package a5.wanyi02;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[4];

	test_names[0] = "exampleTest";
	test_names[1] = "testIter";
	test_names[2] = "testWindow";
	test_names[3] = "testTile";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void testIter() {
	Picture p = new PictureImpl(15, 10);
	Iterator<Pixel> iter = p.sample(2, 3, 3, 4);
	assertEquals("iterator does not match", iter.next(), p.getPixel(2, 3));
	assertEquals("iterator does not match", iter.next(), p.getPixel(5, 3));
	assertEquals("iterator does not match", iter.next(), p.getPixel(8, 3));
	assertEquals("iterator does not match", iter.next(), p.getPixel(11, 3));
	assertEquals("iterator does not match", iter.next(), p.getPixel(14, 3));
	assertEquals("iterator hasNext fails", iter.hasNext(), true);
	assertEquals("iterator does not match", iter.next(), p.getPixel(2, 7));
	assertEquals("iterator does not match", iter.next(), p.getPixel(5, 7));
	assertEquals("iterator does not match", iter.next(), p.getPixel(8, 7));
	assertEquals("iterator does not match", iter.next(), p.getPixel(11, 7));
	assertEquals("iterator does not match", iter.next(), p.getPixel(14, 7));
	assertEquals("iterator hasNext fails", iter.hasNext(), false);
    }

    @Test
    public void testWindow() {
	Picture p = new PictureImpl(3, 2);
	Iterator<SubPicture> iter = p.window(3, 2);
	assertEquals("iterator does not match", iter.next().getPixel(0, 0), p.extract(0, 0, 3, 2).getPixel(0, 0));
	// assertEquals("iterator does not match", iter.next().getPixel(0, 0),
	// p.extract(1, 0, 3, 2).getPixel(0, 0));
	// assertEquals("iterator does not match", iter.next().getPixel(0, 0),
	// p.extract(2, 0, 3, 2).getPixel(0, 0));
	// assertEquals("iterator does not match", iter.next(), p.extract(0, 1,
	// 3, 2));
	// assertEquals("iterator does not match", iter.next(), p.extract(1, 1,
	// 3, 2));
	// assertEquals("iterator does not match", iter.next(), p.extract(2, 1,
	// 3, 2));
	// assertEquals("iterator hasNext fails", iter.hasNext(), true);
	// assertEquals("iterator does not match", iter.next(), p.extract(0, 2,
	// 3, 2));
	// assertEquals("iterator does not match", iter.next(), p.extract(1, 2,
	// 3, 2));
	// assertEquals("iterator does not match", iter.next(), p.extract(2, 2,
	// 3, 2));
	// assertEquals("iterator does not match", iter.next(), p.extract(0, 3,
	// 3, 2));
	// assertEquals("iterator does not match", iter.next(), p.extract(1, 3,
	// 3, 2));
	// assertEquals("iterator does not match", iter.next(), p.extract(2, 3,
	// 3, 2));
	// assertEquals("iterator hasNext fails", iter.hasNext(), false);
    }

    @Test
    public void testTile() {
	Picture p = new PictureImpl(3, 2);
	Iterator<SubPicture> iter = p.tile(2, 2);
	assertEquals("iterator does not match", iter.next().getPixel(0, 0), p.extract(0, 0, 2, 2).getPixel(0, 0));
	// assertEquals("iterator does not match", iter.next().getPixel(0, 0),
	// p.extract(2, 0, 2, 2).getPixel(0, 0));
	// assertEquals("iterator hasNext fails", iter.hasNext(), true);
	// assertEquals("iterator does not match", iter.next().getPixel(0, 0),
	// p.extract(0, 2, 2, 2).getPixel(0, 0));
	// assertEquals("iterator does not match", iter.next().getPixel(0, 0),
	// p.extract(2, 2, 2, 2).getPixel(0, 0));
	// assertEquals("iterator hasNext fails", iter.hasNext(), false);
    }
}

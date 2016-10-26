package a5.sagarss;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "SampleIterator";

	return test_names;
    }

    private static final Pixel r = new ColorPixel(1, 0, 0);

    @Test
    public void SampleIterator() {
	Picture p = new PictureImpl(10, 11);
	Coordinate a = new Coordinate(3, 2);
	Coordinate b = new Coordinate(6, 2);
	Coordinate c = new Coordinate(9, 2);
	Coordinate d = new Coordinate(3, 6);
	Coordinate e = new Coordinate(6, 6);
	Coordinate f = new Coordinate(9, 6);
	Coordinate g = new Coordinate(3, 10);
	Coordinate h = new Coordinate(6, 10);
	Coordinate i = new Coordinate(9, 10);
	p.setPixel(a, r);
	p.setPixel(b, r);
	p.setPixel(c, r);
	p.setPixel(d, r);
	p.setPixel(e, r);
	p.setPixel(f, r);
	p.setPixel(g, r);
	p.setPixel(h, r);
	p.setPixel(i, r);
	Iterator<Pixel> sample_iter = p.sample(3, 2, 3, 4);
	assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(a), sample_iter.next());
	assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(b), sample_iter.next());
	assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(c), sample_iter.next());
	assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(d), sample_iter.next());
	assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(e), sample_iter.next());
	assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(f), sample_iter.next());
	assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(g), sample_iter.next());
	assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(h), sample_iter.next());
	assertEquals("Subpicture pixel does not match expected source pixel", p.getPixel(i), sample_iter.next());

    }
}

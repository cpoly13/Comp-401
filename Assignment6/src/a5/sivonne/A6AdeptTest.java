package a5.sivonne;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "SampleTest";
	test_names[1] = "TileTest";

	return test_names;
    }

    @Test
    public void SampleTest() {
	Picture p = new PictureImpl(2, 2);
	Iterator<Pixel> iter = p.iterator();
	Iterator<Pixel> sample_iter = p.sample(0, 0, 1, 1);

	Coordinate c0 = new Coordinate(0, 0);
	Coordinate c1 = new Coordinate(1, 0);
	Coordinate c2 = new Coordinate(0, 1);
	Coordinate c3 = new Coordinate(1, 1);

	p.setPixel(c0, RED);
	p.setPixel(c1, BLUE);
	p.setPixel(c2, WHITE);
	p.setPixel(c3, BLACK);

	assertEquals("Pixel value incorrect", sample_iter.equals(c0), iter.equals(c0));
	assertEquals("Pixel value incorrect", sample_iter.equals(c1), iter.equals(c1));
	assertEquals("Pixel value incorrect", sample_iter.equals(c2), iter.equals(c2));
	assertEquals("Pixel value incorrect", sample_iter.equals(c3), iter.equals(c3));

    }

    @Test
    public void TileTest() {
	Picture p = new PictureImpl(5, 5);

	Iterator<SubPicture> tile_iter = p.tile(2, 2);
	// SubPicture f = tile_iter.next();

	Coordinate c0 = new Coordinate(0, 0);
	Coordinate c1 = new Coordinate(2, 0);
	Coordinate c2 = new Coordinate(0, 2);
	Coordinate c3 = new Coordinate(2, 2);

	p.setPixel(c0, RED);
	p.setPixel(c1, BLUE);
	p.setPixel(c2, WHITE);
	p.setPixel(c3, GREEN);

	assertEquals("Pixel value incorrect", tile_iter.next().getXOffset(), (p.extract(0, 0, 2, 2)).getXOffset());
	assertEquals("Pixel value incorrect", tile_iter.next().getXOffset(), (p.extract(2, 0, 2, 2)).getXOffset());
	assertEquals("Pixel value incorrect", tile_iter.next().getXOffset(), (p.extract(0, 2, 2, 2)).getXOffset());
	assertEquals("Pixel value incorrect", tile_iter.next().getXOffset(), (p.extract(2, 2, 2, 2)).getXOffset());

    }

}

package a5.meli727;

import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[4];
	// MAKE SURE SIZE IS CORRECT

	test_names[0] = "coordinateConstructorTest";
	test_names[1] = "setGetPixelTest";
	test_names[2] = "extractTest";
	test_names[3] = "iteratorTest";
	// MAKE SURE THESE TEST NAMES MATCH

	return test_names;
    }

    @Test
    public void coordinateConstructorTest() {
	Coordinate c1 = new Coordinate(0, 1);
	assertEquals("coordinate constructor test", 0, c1.getX());
	assertEquals("coordinate constructor test", 1, c1.getY());

	Coordinate c2 = new Coordinate(3, 3);
	assertEquals("coordinate constructor test", 3, c2.getX());
	assertEquals("coordinate constructor test", 3, c2.getY());

	Coordinate c3 = new Coordinate(-2, 1);
	assertEquals("coordinate constructor test", -2, c3.getX());
	assertEquals("coordinate constructor test", 1, c3.getY());

    }

    @Test
    public void setGetPixelTest() {

	Picture pic = new PictureImpl(6, 8);

	Coordinate c4 = new Coordinate(0, 2);
	Coordinate c5 = new Coordinate(4, 3);

	Pixel pix = new ColorPixel(.4, .2, 1);
	Pixel pix2 = new GrayPixel(1.0);

	pic.setPixel(c4, pix);
	assertEquals("setter getter test", pix, pic.getPixel(c4));

	pic.setPixel(c4, pix2);
	assertEquals("setter getter test", pix2, pic.getPixel(c4));

	pic.setPixel(c5, pix2);
	assertEquals("setter getter test", pix2, pic.getPixel(c5));

	pic.setPixel(c5, pix);
	assertEquals("setter getter test", pix, pic.getPixel(c5));
    }

    @Test
    public void extractTest() {
	Picture pic2 = new PictureImpl(8, 8);

	Coordinate c6 = new Coordinate(1, 1);
	Coordinate c7 = new Coordinate(3, 3);
	Coordinate c8 = new Coordinate(2, 7);

	SubPicture subPic = pic2.extract(c6, c7);
	assertEquals("extract test", 3, subPic.getWidth());
	assertEquals("extract test", 3, subPic.getHeight());

	SubPicture subPic2 = pic2.extract(c6, c8);
	assertEquals("extract test", 2, subPic2.getWidth());
	assertEquals("extract test", 7, subPic2.getHeight());

    }

    @Test
    public void iteratorTest() {
	Picture pic3 = new PictureImpl(32, 40);
	Coordinate c9 = new Coordinate(2, 2);
	Coordinate c10 = new Coordinate(2, 0);
	Coordinate c11 = new Coordinate(1, 2);
	Coordinate c12 = new Coordinate(0, 0);
	Coordinate c13 = new Coordinate(1, 0);

	pic3.setPixel(c9, RED);
	pic3.setPixel(c10, BLUE);
	pic3.setPixel(c11, GREEN);
	pic3.setPixel(c12, WHITE);
	pic3.setPixel(c13, BLACK);

	Iterator<Pixel> pixIt = pic3.iterator();
	assertEquals("iterator test", pixIt.hasNext(), true);

    }

}

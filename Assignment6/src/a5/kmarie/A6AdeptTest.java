package a5.kmarie;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testSample";
	test_names[1] = "testWindow";
	test_names[2] = "testTile";
	return test_names;
    }

    @Test
    public void testSample() {
	Picture p = new PictureImpl(15, 10);
	Coordinate[] coords = { new Coordinate(2, 3), new Coordinate(5, 3), new Coordinate(8, 3), new Coordinate(11, 3),
		new Coordinate(14, 3), new Coordinate(2, 7), new Coordinate(5, 7), new Coordinate(8, 7),
		new Coordinate(11, 7), new Coordinate(14, 7) };

	Pixel[] colors = { RED, BLUE, BLUE, WHITE, BLACK, BLUE, GREEN, WHITE, BLACK, GREEN };

	for (int i = 0; i < coords.length; i++) {
	    p.setPixel(coords[i], colors[i]);
	}

	Iterator<Pixel> pixelIt = p.sample(2, 3, 3, 4);
	int counter = 0;
	while (pixelIt.hasNext()) {
	    Pixel pix = pixelIt.next();
	    Coordinate C = coords[counter];
	    assertEquals(pix, p.getPixel(C));
	    counter += 1;
	}
    }

    @Test
    public void testWindow() {
	Picture p = new PictureImpl(5, 5);

	SubPicture p1 = p.extract(0, 0, 3, 2);
	int height = p1.getHeight();
	int width = p1.getWidth();
	int xoffset = p1.getXOffset();
	int yoffset = p1.getYOffset();

	Iterator<SubPicture> window_iter = p.window(3, 2);
	SubPicture p2 = window_iter.next();
	int testHeight = p2.getHeight();
	int testWidth = p2.getWidth();
	int testXOff = p2.getXOffset();
	int testYOff = p2.getYOffset();

	assertEquals(height, testHeight);
	assertEquals(width, testWidth);
	assertEquals(xoffset, testXOff);
	assertEquals(yoffset, testYOff);

    }

    @Test
    public void testTile() {
	Picture p = new PictureImpl(5, 5);

	SubPicture p1 = p.extract(0, 0, 2, 2);
	int height = p1.getHeight();
	int width = p1.getWidth();
	int xoffset = p1.getXOffset();
	int yoffset = p1.getYOffset();

	Iterator<SubPicture> tile_iter = p.tile(2, 2);
	SubPicture p2 = tile_iter.next();
	int testHeight = p2.getHeight();
	int testWidth = p2.getWidth();
	int testXOff = p2.getXOffset();
	int testYOff = p2.getYOffset();

	assertEquals(height, testHeight);
	assertEquals(width, testWidth);
	assertEquals(xoffset, testXOff);
	assertEquals(yoffset, testYOff);
    }
}

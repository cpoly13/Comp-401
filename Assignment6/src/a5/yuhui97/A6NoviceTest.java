package a5.yuhui97;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel BLACK = new GrayPixel(0);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testCoordGetPixel";
	test_names[1] = "testCoordExtractSubpicture";
	test_names[2] = "testPixelIterator";

	return test_names;
    }

    @Test
    public void testCoordGetPixel() {
	Picture source = new PictureImpl(2, 2);
	source.setPixel(0, 0, RED);
	source.setPixel(0, 1, GREEN);
	source.setPixel(1, 0, BLUE);
	source.setPixel(1, 1, BLACK);

	Coordinate coord1 = new Coordinate(1, 1);
	Coordinate coord2 = new Coordinate(0, 1);
	Coordinate coord3 = new Coordinate(0, 0);

	SubPicture subpic = new SubPictureImpl(source, 1, 1, 1, 1);

	Coordinate subCoord1 = new Coordinate(0, 0);

	assertEquals("Pixel mismatch for coordinate test", source.getPixel(coord1), source.getPixel(1, 1));
	assertEquals("Pixel mismatch for coordinate test", source.getPixel(coord2), source.getPixel(0, 1));
	assertEquals("Pixel mismatch for coordinate test", source.getPixel(coord3), source.getPixel(0, 0));
	assertEquals("Pixel mismatch for coordinate test", subpic.getPixel(subCoord1), source.getPixel(1, 1));

    }

    @Test
    public void testCoordExtractSubpicture() {
	Picture source = new PictureImpl(2, 2);
	source.setPixel(0, 0, RED);
	source.setPixel(0, 1, GREEN);
	source.setPixel(1, 0, BLUE);
	source.setPixel(1, 1, BLACK);

	Coordinate coord1 = new Coordinate(1, 1);
	Coordinate coord2 = new Coordinate(0, 1);
	new Coordinate(0, 0);
	new Coordinate(1, 0);

	SubPicture subpic = source.extract(coord2, coord1);

	Coordinate subCoord1 = new Coordinate(0, 0);
	Coordinate subCoord2 = new Coordinate(1, 0);

	assertEquals("Pixel mismatch for coordinate subicture test", source.getPixel(coord1),
		subpic.getPixel(subCoord2));
	assertEquals("Pixel mismatch for coordinate subicture test", source.getPixel(coord2),
		subpic.getPixel(subCoord1));
    }

    @Test
    public void testPixelIterator() {
	Picture source = new PictureImpl(2, 2);
	source.setPixel(0, 0, RED);
	source.setPixel(0, 1, GREEN);
	source.setPixel(1, 0, BLUE);
	source.setPixel(1, 1, BLACK);
	Iterator<Pixel> sourceIterator = source.iterator();

	assertEquals("Wrong pixel by iterator", RED, sourceIterator.next());

	assertEquals("Wrong pixel by iterator", BLUE, sourceIterator.next());

	assertEquals("Wrong pixel by iterator", GREEN, sourceIterator.next());

	assertEquals("Wrong pixel by iterator", BLACK, sourceIterator.next());
    }
}

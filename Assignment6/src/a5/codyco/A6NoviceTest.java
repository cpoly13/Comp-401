package a5.codyco;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    /*
     * Create static pixels for colors which are specifically black, white, red,
     * green or blue.
     */

    private static Pixel BLACK = new GrayPixel(0);
    private static Pixel WHITE = new GrayPixel(1);

    private static Pixel RED = new ColorPixel(1, 0, 0);
    private static Pixel GREEN = new ColorPixel(0, 1, 0);
    private static Pixel BLUE = new ColorPixel(0, 1, 0);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testGetPixelCoordinates";
	test_names[1] = "testSubPictureExtract";
	test_names[2] = "testPixelIterator";

	return test_names;
    }

    // Tests the getPixel method when given the coordinates.

    @Test
    public void testGetPixelCoordinates() {
	Picture picture1 = new PictureImpl(5, 5);
	Coordinate picture1Coord1 = new Coordinate(2, 1);
	Coordinate picture1Coord2 = new Coordinate(2, 2);
	Coordinate picture1Coord3 = new Coordinate(4, 1);
	Coordinate picture1Coord4 = new Coordinate(4, 2);

	SubPicture subPicture1 = new SubPictureImpl(picture1, 2, 1, 2, 2);
	Coordinate sub1Coord1 = new Coordinate(0, 0);
	Coordinate sub1Coord2 = new Coordinate(0, 2);
	Coordinate sub1Coord3 = new Coordinate(1, 0);
	Coordinate sub1Coord4 = new Coordinate(1, 2);

	assertEquals("The Pixel returned from the coordinate is not correct.", picture1.getPixel(picture1Coord1),
		picture1.getPixel(2, 1));
	assertEquals("The Pixel returned from the coordinate is not correct.", picture1.getPixel(picture1Coord2),
		picture1.getPixel(2, 2));
	assertEquals("The Pixel returned from the coordinate is not correct.", picture1.getPixel(picture1Coord3),
		picture1.getPixel(4, 1));
	assertEquals("The Pixel returned from the coordinate is not correct.", picture1.getPixel(picture1Coord4),
		picture1.getPixel(4, 2));
	assertEquals("The Pixel returned from the coordinate is not correct.", subPicture1.getPixel(sub1Coord1),
		subPicture1.getPixel(0, 0));
	assertEquals("The Pixel returned from the coordinate is not correct.", subPicture1.getPixel(sub1Coord2),
		subPicture1.getPixel(0, 2));
	assertEquals("The Pixel returned from the coordinate is not correct.", subPicture1.getPixel(sub1Coord3),
		subPicture1.getPixel(1, 0));
	assertEquals("The Pixel returned from the coordinate is not correct.", subPicture1.getPixel(sub1Coord4),
		subPicture1.getPixel(1, 2));

    }

    // Tests that pixels retrieved from the Iterator are the correct color.

    @Test
    public void testPixelIterator() {
	Picture picture3 = new PictureImpl(5, 2);

	// Set the value of each pixel to a color

	picture3.setPixel(0, 0, BLUE);
	picture3.setPixel(1, 0, BLACK);
	picture3.setPixel(2, 0, RED);
	picture3.setPixel(3, 0, BLUE);
	picture3.setPixel(4, 0, GREEN);
	picture3.setPixel(0, 1, WHITE);
	picture3.setPixel(1, 1, BLUE);
	picture3.setPixel(2, 1, WHITE);
	picture3.setPixel(3, 1, RED);
	picture3.setPixel(4, 1, GREEN);

	Iterator<Pixel> pictureIterator = picture3.iterator();

	// Using hasNext to ensure each pixel is correct.

	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", BLUE, pictureIterator.next());
	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", BLACK, pictureIterator.next());
	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", RED, pictureIterator.next());
	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", BLUE, pictureIterator.next());
	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", GREEN, pictureIterator.next());
	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", WHITE, pictureIterator.next());
	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", BLUE, pictureIterator.next());
	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", WHITE, pictureIterator.next());
	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", RED, pictureIterator.next());
	assertTrue(pictureIterator.hasNext());
	assertEquals("The pixel from the iterator is not correct.", GREEN, pictureIterator.next());
    }
}

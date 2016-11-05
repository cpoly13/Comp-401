package a5.mariajg;

//Jackson Witzke
//Andrew Jacober

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "iteratorTest";
	test_names[1] = "coordinateGetterTest";
	test_names[2] = "extractTest";

	return test_names;
    }

    // Test checks that it is true that there is a next element to iterate
    // through
    @Test
    public void iteratorTest() { // test method declaration
	// create new picture object with width and height of 2
	Picture p = new PictureImpl(2, 2);

	// set pixel height, width, color
	p.setPixel(0, 0, RED);
	p.setPixel(1, 0, BLUE);
	p.setPixel(0, 1, GREEN);
	p.setPixel(1, 1, WHITE);

	Iterator<Pixel> i = p.iterator(); // create iterator object

	// test true or false if iterator has a next element to traverse through
	assertTrue(i.hasNext());
	assertEquals("pixel values are not equivalent", i.next(), RED);
	assertTrue(i.hasNext());
	assertEquals("pixel values are not equivalent", i.next(), BLUE);
	assertTrue(i.hasNext());
	assertEquals("pixel values are not equivalent", i.next(), GREEN);
	assertTrue(i.hasNext());
	assertEquals("pixel values are not equivalent", i.next(), WHITE);
	assertFalse(i.hasNext());

    }

    // Test checks if getter correctly retrieves coordinates
    @Test
    public void coordinateGetterTest() { // test method declaration
	Picture p = new PictureImpl(2, 2); // create a new coordinate object

	p.setPixel(1, 0, RED); // set pixel height, width, color
	Coordinate c = new Coordinate(1, 0); // creates a new coordinate object
	// tests if expected value matches with value resulting from .getX() and
	// .getY()
	assertEquals("coordinate x is not correct", 1, c.getX());
	assertEquals("coordiante y is not correct", 0, c.getY());
	assertEquals(RED, p.getPixel(c));

    }

    // test checks if height and width are extracted correctly
    @Test
    public void extractTest() { // test method declaration
	Picture p = new PictureImpl(10, 10); // create a new picture object

	Coordinate corner_a = new Coordinate(3, 2); // create a new coordinate
						    // object
	Coordinate corner_b = new Coordinate(7, 5); // create a new coordinate
						    // object

	// set pixel location and color
	p.setPixel(corner_a, RED);
	p.setPixel(corner_b, WHITE);

	// checks if expected coordinate value matches value resulting from
	// calling
	// .getWidth() and .getHeight() on sub picture object
	assertEquals("width is not correct", p.getPixel(3, 2), RED);
	assertEquals("height is not correct", p.getPixel(7, 5), WHITE);

    }

}

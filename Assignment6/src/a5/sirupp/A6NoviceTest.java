package a5.sirupp;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "getSetTest";
	test_names[1] = "extractTest";
	test_names[2] = "nextTest";

	return test_names;
    }

    // Creating pixel colors to use in test pictures
    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);
    private static final Pixel WHITE = new GrayPixel(1);
    private static final Pixel BLACK = new GrayPixel(0);

    // Test for get and set Coordinate methods
    @Test
    public void getSetTest() {
	// Creating a picture impl and coordinates to test the get Coordinate
	// method
	Picture newPicture = new PictureImpl(2, 2);
	Coordinate testCoordinate = new Coordinate(0, 0);
	Coordinate testCoordinate2 = new Coordinate(0, 1);
	Coordinate testCoordinate3 = new Coordinate(1, 0);
	Coordinate testCoordinate4 = new Coordinate(1, 1);

	// Setting the source picture's pixels at given coordinates
	newPicture.setPixel(0, 0, BLACK);
	newPicture.setPixel(0, 1, BLACK);
	newPicture.setPixel(1, 0, WHITE);
	newPicture.setPixel(1, 1, WHITE);

	// Checking if Coordinate getPixel method returns the same pixels
	assertEquals("The returned pixel does not match its intended set value", BLACK,
		newPicture.getPixel(testCoordinate));
	assertEquals("The returned pixel does not match its intended set value", BLACK,
		newPicture.getPixel(testCoordinate2));
	assertEquals("The returned pixel does not match its intended set value", WHITE,
		newPicture.getPixel(testCoordinate3));
	assertEquals("The return pixel does not match its intended set value", WHITE,
		newPicture.getPixel(testCoordinate4));

	// Creating a picture impl to test the set Coordinate method
	Picture secondPicture = new PictureImpl(4, 4);
	Coordinate firstCoordinate = new Coordinate(0, 0);
	Coordinate secondCoordinate = new Coordinate(3, 3);
	Coordinate thirdCoordinate = new Coordinate(2, 2);
	Coordinate fourthCoordinate = new Coordinate(1, 1);

	// Setting the pixels in the source picture
	secondPicture.setPixel(firstCoordinate, RED);
	secondPicture.setPixel(secondCoordinate, RED);
	secondPicture.setPixel(thirdCoordinate, GREEN);
	secondPicture.setPixel(fourthCoordinate, GREEN);

	// Checking if Coordinate setPixel method set (and get method returns)
	// the correct pixels
	assertEquals("The provided set pixel method does not work", RED, secondPicture.getPixel(0, 0));
	assertEquals("The provided set pixel method does not work", RED, secondPicture.getPixel(3, 3));
	assertEquals("The provided set pixel method does not work", GREEN, secondPicture.getPixel(2, 2));
	assertEquals("The provided set pixel method does not work", GREEN, secondPicture.getPixel(1, 1));

    }

    @Test
    public void extractTest() {
	// Creating a new picture impl to test extract
	Picture bigPicture = new PictureImpl(10, 10);

	// Creating coordinates for subpictures
	Coordinate corner1 = new Coordinate(1, 1);
	Coordinate corner2 = new Coordinate(4, 4);
	Coordinate otherCorner1 = new Coordinate(5, 5);
	Coordinate otherCorner2 = new Coordinate(9, 9);

	// Setting corner pixels
	bigPicture.setPixel(corner1, BLUE);
	bigPicture.setPixel(corner2, BLUE);
	bigPicture.setPixel(otherCorner1, GREEN);
	bigPicture.setPixel(otherCorner2, GREEN);

	// Creating subpictures using corner coordinates
	Picture subPicture1 = bigPicture.extract(corner1, corner2);
	Picture subPicture2 = bigPicture.extract(otherCorner1, otherCorner2);

	// Testing pixels between subpicture and source picture
	assertEquals("The subpicture's pixel doesn't match the big picture's", BLUE, subPicture1.getPixel(0, 0));
	assertEquals("The subpicture's pixel doesn't match the big picture's", BLUE, subPicture1.getPixel(3, 3));

	// Testing pixels between subpicture and source picture
	assertEquals("The subpicture's pixel doesn't match the big picture's", GREEN, subPicture2.getPixel(0, 0));
	assertEquals("The subpicture's pixel doesn't match the big picture's", GREEN, subPicture2.getPixel(4, 4));

    }

    // Testing next method (and through that, hasNext)
    @Test
    public void nextTest() {
	// Creating source picture
	Picture testPicture = new PictureImpl(2, 2);

	// Creating coordinates to set pixels
	Coordinate point1 = new Coordinate(0, 0);
	Coordinate point2 = new Coordinate(1, 0);
	Coordinate point3 = new Coordinate(0, 1);
	Coordinate point4 = new Coordinate(1, 1);

	// Setting pixel values
	testPicture.setPixel(point1, BLACK);
	testPicture.setPixel(point2, BLACK);
	testPicture.setPixel(point3, BLUE);
	testPicture.setPixel(point4, BLUE);

	// Creating picture iterator
	Iterator<Pixel> testIterator = testPicture.iterator();

	// Testing iterator's returned pixels and hasNext method reference
	// within next
	assertEquals("The iterator's next method is failing", BLACK, testIterator.next());
	assertEquals("The iterator's next method is failing", BLACK, testIterator.next());
	assertEquals("The iterator's next method is failing", BLUE, testIterator.next());
	assertEquals("The iterator's next method is failing", BLUE, testIterator.next());
	assertEquals("The iterator's hasNext method is failing", false, testIterator.hasNext());

    }

}

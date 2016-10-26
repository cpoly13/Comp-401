package a5.brenbell;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    private static final Pixel WHITE = new GrayPixel(1.0D);
    private static final Pixel BLACK = new GrayPixel(0.0D);
    private static final Pixel RED = new ColorPixel(1.0, 0.0, 0.0);
    private static final Pixel GREEN = new ColorPixel(0.0, 1.0, 0.0);
    private static final Pixel BLUE = new ColorPixel(0.0, 0.0, 1.0);

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "testIterator";
	test_names[1] = "testCoordinates";
	test_names[2] = "testExtract";

	return test_names;
    }

    @Test
    public void testIterator() {
	Picture testPic = initSample();
	Iterator<Pixel> testPicIterator = testPic.iterator();

	Assert.assertTrue(testPicIterator.hasNext());
	Assert.assertEquals("The next pixel isn't what I expected.", GREEN, testPicIterator.next());

	Assert.assertTrue(testPicIterator.hasNext());
	Assert.assertEquals("The next pixel isn't what I expected.", BLUE, testPicIterator.next());

	Assert.assertTrue(testPicIterator.hasNext());
	Assert.assertEquals("The next pixel isn't what I expected.", RED, testPicIterator.next());

	Assert.assertTrue(testPicIterator.hasNext());
	Assert.assertEquals("The next pixel isn't what I expected.", RED, testPicIterator.next());

	Assert.assertTrue(testPicIterator.hasNext());
	Assert.assertEquals("The next pixel isn't what I expected.", BLUE, testPicIterator.next());

	Assert.assertTrue(testPicIterator.hasNext());
	Assert.assertEquals("The next pixel isn't what I expected.", GREEN, testPicIterator.next());

	Assert.assertTrue(testPicIterator.hasNext());
	Assert.assertEquals("The next pixel isn't what I expected.", BLACK, testPicIterator.next());

	Assert.assertTrue(testPicIterator.hasNext());
	Assert.assertEquals("The next pixel isn't what I expected.", WHITE, testPicIterator.next());

	Assert.assertTrue(testPicIterator.hasNext());
	Assert.assertEquals("The next pixel isn't what I expected.", BLACK, testPicIterator.next());
    }

    @Test
    public void testCoordinates() {
	Picture testPic = initSample();
	Coordinate testA = new Coordinate(0, 0);
	Coordinate testB = new Coordinate(0, 1);
	Coordinate testC = new Coordinate(1, 0);

	Assert.assertEquals("The pixel made by coordinates does not match the picture given.", testPic.getPixel(testA),
		testPic.getPixel(0, 0));
	Assert.assertEquals("The pixel made by coordinates does not match the picture given.", testPic.getPixel(testB),
		testPic.getPixel(0, 1));
	Assert.assertEquals("The pixel made by coordinates does not match the picture given.", testPic.getPixel(testC),
		testPic.getPixel(1, 0));

    }

    @Test
    public void testExtract() {
	Picture testPic = initSample();
	Coordinate testA = new Coordinate(0, 0);
	Coordinate testB = new Coordinate(0, 1);
	Coordinate testC = new Coordinate(1, 0);

	SubPicture subTestPic = testPic.extract(testA, testC);
	Coordinate subTestA = new Coordinate(0, 0);
	Coordinate subTestB = new Coordinate(0, 1);
	Coordinate subTestC = new Coordinate(1, 0);

	Assert.assertEquals("The pixel extracted doesn't match what the source is.", testPic.getPixel(testA),
		subTestPic.getPixel(subTestA));
	Assert.assertEquals("The pixel extracted doesn't match what the source is.", testPic.getPixel(testB),
		subTestPic.getPixel(subTestB));
	Assert.assertEquals("The pixel extracted doesn't match what the source is.", testPic.getPixel(testC),
		subTestPic.getPixel(subTestC));

    }

    private Picture initSample() {
	Picture sample = new PictureImpl(3, 3);

	sample.setPixel(0, 0, GREEN);
	sample.setPixel(1, 0, BLUE);
	sample.setPixel(2, 0, RED);
	sample.setPixel(0, 1, RED);
	sample.setPixel(1, 1, BLUE);
	sample.setPixel(2, 1, GREEN);
	sample.setPixel(0, 2, BLACK);
	sample.setPixel(1, 2, WHITE);
	sample.setPixel(2, 2, BLACK);

	return sample;
    }
}

package a5.mckelly;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

	private static final Pixel RED = new ColorPixel(1, 0, 0);
	private static final Pixel BLUE = new ColorPixel(0, 0, 1);

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "testSample";
		test_names[1] = "testExtract";

		return test_names;
	}

	@Test
	public void testSample() { // Tests creation of samples through the sample
								// method

		// Creates pictures and sets specific pixels to be sampled
		Picture testSample = new PictureImpl(10, 15);
		Picture testSample2 = new PictureImpl(11, 22);
		testSample.setPixel(9, 14, RED);
		testSample2.setPixel(6, 18, BLUE);

		// Tests both hasNext() and next() for picture 1
		assertEquals("Sample hasNext() incorrect", true, testSample.sample(2, 3, 3, 4).hasNext());
		assertEquals("Sample next() incorrect", RED, testSample.sample(9, 14, 1, 1).next());

		// Tests both hasNext() and next() for picture 2
		assertEquals("Sample hasNext() incorrect", true, testSample2.sample(10, 21, 1, 1).hasNext());
		assertEquals("Sample next() incorrect", BLUE, testSample2.sample(6, 18, 2, 2).next());
	}

	@Test
	public void testExtract() { // Tests extract method

		// Creates sample Pictures
		Picture testSample = new PictureImpl(10, 15);
		Picture testSample2 = new PictureImpl(11, 22);

		testSample.setPixel(2, 3, RED); // Top left pixel is red
		testSample.setPixel(6, 7, BLUE); // Bottom right is blue
		testSample2.setPixel(2, 3, RED);
		testSample2.setPixel(10, 19, BLUE);
		Coordinate testCorner1 = new Coordinate(2, 3);
		Coordinate testCorner2 = new Coordinate(6, 7);
		Coordinate testCorner3 = new Coordinate(10, 19);

		// Extracts using color coded corners
		Picture extracted1 = testSample.extract(testCorner1, testCorner2);
		Picture extracted2 = testSample2.extract(testCorner1, testCorner3);

		assertEquals("Extracted Corner does not match", RED, extracted1.getPixel(0, 0));
		assertEquals("Extracted Corner does not match", BLUE, extracted1.getPixel(4, 4));
		assertEquals("Extracted Corner does not match", RED, extracted2.getPixel(0, 0));
		assertEquals("Extracted Corner does not match", BLUE, extracted2.getPixel(8, 16));

	}
}

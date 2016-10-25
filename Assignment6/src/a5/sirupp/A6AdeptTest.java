package a5.sirupp;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "sampleTest";
		test_names[1] = "tileTest";

		return test_names;
	}

	// Creating pixels to fill test pictures
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);

	// Test for sample method
	@Test
	public void sampleTest() {
		// Creating a source picture for sample
		Picture sampleTestPicture = new PictureImpl(10, 10);

		// Creating coordinates to use in sample test
		Coordinate stop1 = new Coordinate(2,2);
		Coordinate stop2 = new Coordinate(4,2);
		Coordinate stop3 = new Coordinate(6,2);
		Coordinate stop4 = new Coordinate(8,2);
		Coordinate stop5 = new Coordinate(2,4);
		Coordinate stop6 = new Coordinate(4, 4);
		Coordinate stop7 = new Coordinate(6,4);
		Coordinate stop8 = new Coordinate(8,4);
		Coordinate stop9 = new Coordinate(2,6);
		Coordinate stop10 = new Coordinate(4,6);
		Coordinate stop11 = new Coordinate(6,6);
		Coordinate stop12 = new Coordinate(8,6);
		Coordinate stop13 = new Coordinate(2,8);
		Coordinate stop14 = new Coordinate(4,8);
		Coordinate stop15 = new Coordinate(6,8);
		Coordinate stop16 = new Coordinate(8,8);

		// Setting pixels at given coordinates
		sampleTestPicture.setPixel(stop1, BLACK);
		sampleTestPicture.setPixel(stop2, BLACK);
		sampleTestPicture.setPixel(stop3, BLACK);
		sampleTestPicture.setPixel(stop4, BLACK);
		sampleTestPicture.setPixel(stop5, BLACK);
		sampleTestPicture.setPixel(stop6, BLACK);
		sampleTestPicture.setPixel(stop7, BLACK);
		sampleTestPicture.setPixel(stop8, BLACK);
		sampleTestPicture.setPixel(stop9, BLACK);
		sampleTestPicture.setPixel(stop10, BLACK);
		sampleTestPicture.setPixel(stop11, BLACK);
		sampleTestPicture.setPixel(stop12, BLACK);
		sampleTestPicture.setPixel(stop13, BLACK);
		sampleTestPicture.setPixel(stop14, BLACK);
		sampleTestPicture.setPixel(stop15, BLACK);
		sampleTestPicture.setPixel(stop16, BLACK);

		// Creating the sample iterator
		Iterator<Pixel> sampleIterator = sampleTestPicture.sample(2, 2, 2, 2);

		// Testing iterator's next pixels with those of the source picture
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
		assertEquals("The iterator's pixel does not match with the intended value", 
				BLACK, sampleIterator.next());
	}

	// Test for window method
	@Test
	public void tileTest() {
		// Creating a source picture and setting select pixels (to be tested)
		Picture tileSource = new PictureImpl(5,5);		
		tileSource.setPixel(0, 0, RED);
		tileSource.setPixel(1, 1, GREEN);
		tileSource.setPixel(2, 2, BLUE);
		tileSource.setPixel(2, 0, RED);
		tileSource.setPixel(3,  1, GREEN);
		tileSource.setPixel(4, 2, BLUE);
		tileSource.setPixel(0, 2, RED);
		tileSource.setPixel(1, 3, GREEN);
		tileSource.setPixel(2, 4, BLUE);
		tileSource.setPixel(2, 2, RED);
		tileSource.setPixel(3, 3, GREEN);
		tileSource.setPixel(4, 4, BLUE);

		// Creating tile iterator
		Iterator<SubPicture> tile_iter = tileSource.tile(2,2);

		// Creating subpicture objects from source using the iterator
		Picture tile1 = tile_iter.next();
		Picture tile2 = tile_iter.next();
		Picture tile3 = tile_iter.next();
		Picture tile4 = tile_iter.next();

		// Testing the subpicture's pixels with equivalent extract calls
		assertEquals("The pixel in the tile doesn't match the source", 
				tileSource.extract(0, 0, 2, 2).getPixel(0,0), tile1.getPixel(0, 0));
		assertEquals("The pixel in the tile doesn't match the source", 
				tileSource.extract(0, 0, 2, 2).getPixel(1, 1), tile1.getPixel(1, 1));
		assertEquals("The pixel in the tile doesn't match the source",
				tileSource.extract(0, 0, 2, 2).getPixel(2, 2), tile1.getPixel(2, 2));
		assertEquals("The pixel in the tile doesn't match the source",
				tileSource.extract(2, 0, 2, 2).getPixel(0, 0), tile2.getPixel(0, 0));
		assertEquals("The pixel in the tile doesn't match the source",
				tileSource.extract(2, 0, 2, 2).getPixel(1, 1), tile2.getPixel(1, 1));
		assertEquals("The pixel in the tile doesn't match the source",
				tileSource.extract(2, 0, 2, 2).getPixel(2, 2), tile2.getPixel(2, 2));
		assertEquals("The pixel in the tile doesn't match the source", 
				tileSource.extract(0, 2, 2, 2).getPixel(0,0), tile3.getPixel(0, 0));
		assertEquals("The pixel in the tile doesn't match the source", 
				tileSource.extract(0, 2, 2, 2).getPixel(1, 1), tile3.getPixel(1, 1));
		assertEquals("The pixel in the tile doesn't match the source",
				tileSource.extract(0, 2, 2, 2).getPixel(2, 2), tile3.getPixel(2, 2));
		assertEquals("The pixel in the tile doesn't match the source",
				tileSource.extract(2, 2, 2, 2).getPixel(0, 0), tile4.getPixel(0, 0));
		assertEquals("The pixel in the tile doesn't match the source",
				tileSource.extract(2, 2, 2, 2).getPixel(1, 1), tile4.getPixel(1, 1));
		assertEquals("The pixel in the tile doesn't match the source",
				tileSource.extract(2, 2, 2, 2).getPixel(2, 2), tile4.getPixel(2, 2));	
	}
}

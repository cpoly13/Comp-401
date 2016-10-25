package a5.tburch22;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;


import a6novice.*;

public class A6NoviceTest {
	
	// final pixel values for the purpose of testing methods that retrieve pixels
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);


	// method with an output of strings that represent the names of the tests in the class
	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "testHasNextMethod";
		test_names[1] = "testCoordinateOverloadedExtractMethod";


		return test_names;
	}


	/*tests the extract method using coordinates by comparing the getPixel value from the 
	 * subpicture to the original location in the source picture
	 */
	@Test
	public void testCoordinateOverloadedExtractMethod() {
		Picture pic = new PictureImpl(4, 4);
		
		//sets colors of various pixels
		pic.setPixel(0, 0, RED);
		pic.setPixel(1, 0, BLACK);
		pic.setPixel(2, 0, WHITE);
		pic.setPixel(0, 1, GREEN);
		pic.setPixel(1, 1, BLUE);
		pic.setPixel(2, 1, GREEN);
		pic.setPixel(0, 2, BLUE);
		pic.setPixel(1, 2, BLACK);
		pic.setPixel(2, 2, WHITE);
		pic.setPixel(0, 3, BLUE);
		pic.setPixel(1, 3, BLACK);
		pic.setPixel(2, 3, RED);

		Coordinate c1 = new Coordinate(1,1);
		Coordinate c2 = new Coordinate(2,3);

		SubPicture spic = pic.extract(c1,c2);
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				pic.getPixel(1, 1), spic.getPixel(0, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				pic.getPixel(2, 1), spic.getPixel(1, 0));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				pic.getPixel(1, 3), spic.getPixel(0, 2));
		assertEquals("Pixel retrieved from subpicture does not match expected pixel value from source",
				pic.getPixel(2, 3), spic.getPixel(1, 2));

	}

	/*method to test whether the next and hasNext methods work correctly, also checks for 
	 * the expected exceptions in the next() method
	 */
	@Test
	public void testNextAndHasNextMethod() {
		Picture pic = new PictureImpl(4,4);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++){
				if(i % 2 == 0)
					pic.setPixel(j, i, RED);
				else
					pic.setPixel(j, i, GREEN);
			}
		}

		Iterator<Pixel> iter1 = pic.iterator();

		/*loop to go through the whole picture where the call to
		 * hasNext should return true, and also should return a red value on the 
		 * first and third lines, and green on the second and fourth
		 */
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++){
				
				assertEquals("The hasNext method should return true , but it did not", 
						true, iter1.hasNext());
				if(i % 2 == 0)
					assertEquals("The hasNext method should return a RED pixel , but it did not", 
							RED, iter1.next());
				else
					assertEquals("The hasNext method should return a GREEN pixel , but it did not", 
							GREEN, iter1.next());
			}
		}
		
		try {
			Pixel p = iter1.next();
			fail("Expected NoSuchElementException for call to next() with no elements left");
		}
		catch (NoSuchElementException e) {
		}
	
		
	}
}

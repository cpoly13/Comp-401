package a5.aleigh;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
	private static final Pixel BLACK = new GrayPixel(0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "testGetPixelByCoordinate";
		test_names[1] = "testSubPictureExtractByCoordinate";
		test_names[2] = "testIteratorHasNext";
		test_names[3] = "testIteratorNext";
		test_names[4] = "testIteratorHasNextFail";
		
		return test_names;
	}
		
	@Test
	public void testGetPixelByCoordinate() {
		Picture testPicture = new PictureImpl(2, 3);
		testPicture.setPixel(0, 0, RED);
		testPicture.setPixel(0, 1, BLUE);
		testPicture.setPixel(0, 2, GREEN);
		testPicture.setPixel(1, 0, RED);
		testPicture.setPixel(1, 1, BLUE);
		testPicture.setPixel(1, 2, GREEN);
		
		Coordinate a = new Coordinate(1,0);
		Coordinate b = new Coordinate(1,1);
		
		assertEquals("Pixel returned does not match expected value", RED, testPicture.getPixel(a)); 
		assertEquals("Pixel returned does not match expected value", BLUE, testPicture.getPixel(b)); 
	}
	
	@Test
	public void testSubPictureExtractByCoordinate() {
		Picture testPicture = new PictureImpl(3, 4);
		testPicture.setPixel(0, 0, RED);
		testPicture.setPixel(0, 1, BLUE);
		testPicture.setPixel(0, 2, GREEN);
		testPicture.setPixel(0, 3, WHITE);
		testPicture.setPixel(1, 0, RED);
		testPicture.setPixel(1, 1, BLUE);
		testPicture.setPixel(1, 2, GREEN);
		testPicture.setPixel(1, 3, WHITE);
		testPicture.setPixel(2, 0, RED);
		testPicture.setPixel(2, 1, BLUE);
		testPicture.setPixel(2, 2, GREEN);
		testPicture.setPixel(2, 3, WHITE);
		
		Coordinate C1 = new Coordinate(1,1);
		Coordinate C2 = new Coordinate(1,3);
		
		SubPicture testSP = testPicture.extract(C1, C2);
		
		assertEquals("Pixel returned does not match expected SubPicture value", testPicture.getPixel(1, 1), testSP.getPixel(0, 0));
		assertEquals("Pixel returned does not match expected SubPicture value", testPicture.getPixel(1, 2), testSP.getPixel(0, 1));
		assertEquals("Pixel returned does not match expected SubPicture value", testPicture.getPixel(1, 3), testSP.getPixel(0, 2));
	
	}
	
	@Test
	public void testIteratorHasNext(){
		Picture testPicture = new PictureImpl(2, 3);
		testPicture.setPixel(0, 0, RED);
		testPicture.setPixel(0, 1, BLUE);
		testPicture.setPixel(0, 2, GREEN);
		testPicture.setPixel(1, 0, RED);
		testPicture.setPixel(1, 1, BLUE);
		testPicture.setPixel(1, 2, GREEN);
		
		Iterator<Pixel> testIterator = testPicture.iterator();
		
		assertTrue("Expected hasNext to return false", testIterator.hasNext());
		
	}
	
	@Test
	public void testIteratorNext(){
		Picture testPicture = new PictureImpl(2, 3);
		testPicture.setPixel(0, 0, RED);
		testPicture.setPixel(0, 1, BLUE);
		testPicture.setPixel(0, 2, GREEN);
		testPicture.setPixel(1, 0, RED);
		testPicture.setPixel(1, 1, BLUE);
		testPicture.setPixel(1, 2, GREEN);
		
		Iterator<Pixel> testIterator = testPicture.iterator();
		
		assertTrue("Expected hasNext to return false", testIterator.hasNext());
		assertEquals("Returned Pixel does not match expected Pixel", testPicture.getPixel(0, 0), testIterator.next());
		
	}
	
	@Test
	public void testIteratorHasNextFail(){
		Picture testPicture = new PictureImpl(2, 3);
		testPicture.setPixel(0, 0, RED);
		testPicture.setPixel(0, 1, BLUE);
		testPicture.setPixel(0, 2, GREEN);
		testPicture.setPixel(1, 0, RED);
		testPicture.setPixel(1, 1, BLUE);
		testPicture.setPixel(1, 2, GREEN);
		
		Iterator<Pixel> testIterator = testPicture.iterator();
		
		assertTrue("Expected hasNext to return false", testIterator.hasNext());
		assertEquals("Returned Pixel does not match expected Pixel", testPicture.getPixel(0, 0), testIterator.next());
		assertTrue("Expected hasNext to return false", testIterator.hasNext());
		assertEquals("Returned Pixel does not match expected Pixel", testPicture.getPixel(1, 0), testIterator.next());
		assertTrue("Expected hasNext to return false", testIterator.hasNext());
		assertEquals("Returned Pixel does not match expected Pixel", testPicture.getPixel(0, 1), testIterator.next());
		assertTrue("Expected hasNext to return false", testIterator.hasNext());
		assertEquals("Returned Pixel does not match expected Pixel", testPicture.getPixel(1, 1), testIterator.next());
		assertTrue("Expected hasNext to return false", testIterator.hasNext());
		assertEquals("Returned Pixel does not match expected Pixel", testPicture.getPixel(1, 2), testIterator.next());
		assertTrue("Expected hasNext to return false", testIterator.hasNext());
		assertEquals("Returned Pixel does not match expected Pixel", testPicture.getPixel(0, 2), testIterator.next());
		assertFalse("Expected hasNext to return false", testIterator.hasNext());
		
	}
	
	
}




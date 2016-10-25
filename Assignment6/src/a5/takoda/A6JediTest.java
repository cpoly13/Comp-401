package a5.takoda;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6jedi.*;

/*
 * Takoda Ren
 * October 19, 2016
 */

public class A6JediTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	
	/*
	 * Output: Returns array of test names in this class
	 * This method is for the successful completion of
	 * the autograder
	 */
	static public String[] getTestNames() {
		String[] testNames = new String[1];
		
		testNames[0] = "testZigzagIterator";
		
		return testNames;
	}
		
	@Test
	public void testZigzagIterator(){
		Picture p = new PictureImpl(6, 4);
		for(int i=0; i<p.getHeight(); i++){
			for(int j=0; j<p.getWidth(); j++){
				if(j%3==0)
					p.setPixel(j, i, RED);
				if((j-1)%3==0)
					p.setPixel(j, i, GREEN);
				if((j-2)%3==0)
					p.setPixel(j, i, BLUE);
			}
		}
		Iterator<Pixel> zz = p.zigzag();
		Pixel[] pa = {RED, GREEN, RED, RED, GREEN, BLUE, RED, BLUE,
				GREEN, RED, GREEN, BLUE, RED, GREEN, BLUE, GREEN, 
				RED, BLUE, RED, GREEN, BLUE, BLUE, GREEN, BLUE};
		for(int i = 0; i < 24; i++){
			assertEquals("Iterator does not return true for hasNext()",
					true, zz.hasNext());
			assertEquals("Pixel returned from iterator does not match expected Pixel",
					pa[i], zz.next());
		}
		assertEquals("Iterator does not return false for has next when the iterator is at end bounds",
				false, zz.hasNext());
		
		try{
			zz.next();
			fail("Iterator did not return NoSuchElementException");
		} catch(NoSuchElementException e){
		} catch(RuntimeException e){
			fail("Expected NoSuchElementException but received"
					+ "RuntimeException.");
		}
	}
}


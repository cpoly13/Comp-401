package a5.davidbc;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "getTestXandY";
		test_names[1] = "getTestPixel";
		test_names[2] = "testExtract";
		test_names[3] = "testIterator";
		
		return test_names;
	}
		
	@Test 
	public void getTestXandY(){
		//Tests the getX() and getY() methods for coordinates
		//In retrospect, this seems like a really lame thing to test...
		//I'll write five tests other than this one.
		Coordinate testCoord = new Coordinate(1,2);
		
		assertEquals(1, testCoord.getX(), 0.0001);
		assertEquals(2, testCoord.getY(), 0.0001);
		
		testCoord = new Coordinate(0,0);
		assertEquals(0,testCoord.getX(), 0.0001);
		assertEquals(0,testCoord.getY(), 0.0001);
		
		}
		

	
	@Test
	public void getTestPixel(){
		//This test is designed to examine if the getPixel method using a Coordinate input
		//produces the expected values
		
		Coordinate testCoord = new Coordinate(1,2);
		Picture testPict = new PictureImpl(3,3);
		Pixel p = new GrayPixel(0.1);
		
		testPict.setPixel(testCoord, p);
		//First test to see if the pixel has been set correctly using the old getPixel method
		assertEquals(testPict.getPixel(1,2),p);
		//Then make sure that the two methods retrieve the same pixel 
		//for a corresponding Coordinate
		assertEquals(testPict.getPixel(testCoord), testPict.getPixel(1,2));
		
		testCoord = new Coordinate(0,0);
		testPict.setPixel(testCoord,p);
		//Testing another Coordinate
		assertEquals(p, testPict.getPixel(0,0));
		assertEquals(testPict.getPixel(0,0),testPict.getPixel(testCoord));
		
		
	}

	@Test
	public void testExtract(){
		Coordinate testCoordOne = new Coordinate(1,1);
		Coordinate testCoordTwo = new Coordinate(3,3);
		Picture testPict = new PictureImpl(4,4);
		Pixel testPixel = new GrayPixel(0.1);
		//Variable initializations
		
		testPict.setPixel(2,2,testPixel);
		SubPicture extractedTestPict = testPict.extract(testCoordOne, testCoordTwo);
		//creating a new SubPicture with extract. This will be the basis for comparison
		
		//Careful to use the getPixel(x,y) method or else this test could fail even though 
		//the extract method works perfectly fine (hopefully getPixel(x,y) works at this point)
		//Now to make sure that the extraction has worked properly by looking for 
		//pixel that has been set to testPixel
		assertEquals(testPixel, extractedTestPict.getPixel(1,1));
		
		
		//Again with some different parameters and a ColorPixel 
		testCoordTwo = new Coordinate(4,4);
		testPict = new PictureImpl(6,6);
		testPixel = new ColorPixel(0.4,0.2,0.9);
		testPict.setPixel(3,1,testPixel);
		extractedTestPict = testPict.extract(testCoordOne,  testCoordTwo);
		assertEquals(testPixel, extractedTestPict.getPixel(2,0));
		
		
	}
	
	@Test
	public void testIterator(){
		//The test picture was designed so that its diagonal would all be
		//testPixels and everything else would be defaultPixels. Then I looped through 
		//the testIter and checked to make sure that all of the iterator pixels
		//were what they were expected to be.
		Picture testPict = new PictureImpl(4,4);
		Pixel testPixel = new GrayPixel(0.1);
		Pixel defaultPixel = new GrayPixel(0.5);
		for(int j = 0; j<4; j++){
			for(int k = 0; k < 4; k++){
				if(j == k){
					testPict.setPixel(j, j,testPixel);
				}else{
					testPict.setPixel(j, k, defaultPixel);
				}
			}
		}
		
		Iterator<Pixel> testIter = testPict.iterator();
		for(int i = 0; i < 16; i++){
			if(i%5 == 0){
				assertEquals(testPixel, testIter.next());
			}else
				assertEquals(testIter.next(), defaultPixel);
		}
		
	}
}
	

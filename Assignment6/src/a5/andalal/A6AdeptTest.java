package a5.andalal;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[5];
		
		test_names[0] = "exampleTest";
		test_names[1] = "windowTest";
		test_names[2] = "tileTest";
		test_names[3] = "sampleTest";
		test_names[4] = "tileTest";
		
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	//tests the sample method
	public void smapleTest(){
		try{
			Picture thisPic = null;
			Iterator<Pixel> iterator = thisPic.sample(0, 0, 1, 1);
			fail("The picture should not be null");
		}catch(IllegalArgumentException e){
		}catch(RuntimeException e){
		}
		
		Picture thisPic = new PictureImpl(4,4);
		try{
			Iterator<Pixel> iterator = thisPic.sample(10, 10, 2, 1);
			fail("Should thow an exception");
		}catch(IllegalArgumentException e){
		}catch(RuntimeException e){
		}
		
		
		/**try{
			Iterator<Pixel> iterator = thisPic.sample(1, 1, 5, 10);
			fail("Should throw an exception");
		}catch(IllegalArgumentException e){
		}catch(RuntimeException e){
		}*/ 
		
		//This should throw an exception b/c it asks for the iterator 
		//to go beyond the bounds of the Picture each time it moves
		//dx number of spaces or dy number of spaces.
		
		Iterator<Pixel> iterator = thisPic.sample(1, 1, 2, 1);
		Pixel thisPix = new ColorPixel(0.1,0.2,0.3);
		thisPic.setPixel(3, 1, thisPix);
		assertTrue(iterator.next().equals(thisPic.getPixel(1,1)));
		assertTrue(iterator.next().equals(thisPic.getPixel(3,1)));	
		
	}
	
	@Test
	//tests the window method
	public void windowTest(){
		try{
			Picture aPic = null;
			Iterator<SubPicture> iterator = aPic.window(2,2);
			fail("The picture should not be null");
		}catch(IllegalArgumentException e){
		}catch(RuntimeException e){
		}
		
		try{
			Picture aPic = new PictureImpl(3,3);
			Iterator<SubPicture> iterator = aPic.window(5, 5);
			fail("The parameters for the sub pic are larger "
					+ "than the picture itself");
		}catch(IllegalArgumentException e){
		}catch(RuntimeException e){
		}
		
		Picture thisPic = new PictureImpl(5,5);
		
		
		Iterator<SubPicture> windowIterator = thisPic.window(2,3);
		
		assertTrue(windowIterator.next().getPixel(0,0).equals(thisPic.extract(0,0,2,3).getPixel(0,0)));
		assertTrue(windowIterator.next().getPixel(0,0).equals(thisPic.extract(1,0,2,3).getPixel(0,0)));
		assertTrue(windowIterator.next().getPixel(0,0).equals(thisPic.extract(2,0,2,3).getPixel(0,0)));
		assertTrue(windowIterator.next().getPixel(0,0).equals(thisPic.extract(0,1,2,3).getPixel(0,0)));
	}
	
	@Test
	//test the tile method
	public void tileTest(){
		try{
			Picture aPic = null;
			Iterator<SubPicture> iterator = aPic.tile(2,2);
			fail("The picture should not be null");
		}catch(IllegalArgumentException e){
		}catch(RuntimeException e){
		}
		
		try{
			Picture thisPic = null;
			Iterator<SubPicture> iterator = thisPic.tile(2,2);
			fail("The picture should not have negative parameters");
		}catch(IllegalArgumentException e){
		}catch(RuntimeException e){
		}
		
		Picture aPic = new PictureImpl(4,4);
		Iterator<SubPicture> iterator = aPic.tile(2,2);
		
		assertTrue(iterator.next().getPixel(0,0).equals(aPic.extract(0,0,2,2).getPixel(0,0)));
		assertTrue(iterator.next().getPixel(0,0).equals(aPic.extract(2,0,2,2).getPixel(0,0)));
		assertTrue(iterator.next().getPixel(0,0).equals(aPic.extract(0,2,2,2).getPixel(0,0)));
		assertTrue(iterator.next().getPixel(0,0).equals(aPic.extract(2,2,2,2).getPixel(0,0)));
		
		
		
	}
}

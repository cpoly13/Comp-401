package a5.andalal;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "exampleTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	//Tests the zigzagTest method
	public void zigzagTest(){
		try{
			Picture aPic = null;
			Iterator<Pixel> aPixelIterator = aPic.zigzag();
			fail("The picture should not be null to run zigzag");
		}catch(IllegalArgumentException e){
		}catch(RuntimeException e){
		}
		
		Picture aPic = new PictureImpl(5,5);
		Iterator<Pixel> pixIterator = aPic.zigzag();
		
		assertTrue(pixIterator.next().equals(aPic.getPixel(0,0)));
		assertTrue(pixIterator.next().equals(aPic.getPixel(1,0)));
		assertTrue(pixIterator.next().equals(aPic.getPixel(0,1)));
		assertTrue(pixIterator.next().equals(aPic.getPixel(0,2)));
		assertTrue(pixIterator.next().equals(aPic.getPixel(1,1)));
		assertTrue(pixIterator.next().equals(aPic.getPixel(2,0)));
		
		Iterator<Pixel> pixIterator2 = aPic.zigzag();
		
		for(int i = 0; i<25; i++){
			assertTrue(pixIterator2.hasNext());
			pixIterator2.next();
		}
		assertFalse(pixIterator2.hasNext());
	}
}

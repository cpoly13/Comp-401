package a5.abrahamp;

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
		
	@Test
	public void sampleTest() {
	  Picture tester = new PictureImpl(15,15);
	  Pixel p = new ColorPixel(.3,.5,.7);
	  for(int x = 2; x < 15; x = x + 3){
	    for(int y = 3; y < 15; y = y + 4){
	      tester.setPixel(new Coordinate(x,y), p);
	    }
	  }
	  Iterator<Pixel> sampler = tester.sample(2,3,3,4);
	  while(sampler.hasNext()){
	    assertEquals(sampler.next(), p);
	  }
	}
	
	@Test
	public void tileTest(){
	  Picture tester = new PictureImpl(15,15);
	  
	  try{
  	  tester.tile(30,30);
  	  fail("No exception caught");
	  }
	  catch(IllegalArgumentException e){}
	  catch(RuntimeException e){fail("Caught Runtime, should be IllegalArgument");}
	  catch(Exception e){fail("Caught generic exception, should be IllegalArgument");}
	  
	  try{
	    tester.tile(0,0);
	    fail("Should have caught an exception");
	  }
	  catch(Exception e){}
	}
}

package a5.abrahamp;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
	  String[] test_names = new String[2];
    
    test_names[0] = "setPixelTest";
    test_names[1] = "getPixelTest";
		
		return test_names;
	}
	
	@Test
	public void setPixelTest() {
    Picture tester = new PictureImpl(3,3);
    Coordinate a = new Coordinate(2,2);
    Pixel p = new GrayPixel(.5);
    try{
      tester.setPixel(a, p);
    }
    catch(Exception e){
      fail("Exception was thrown");
    }
    
    try{
      tester.setPixel(null, p);
      fail("Exeption Expected");
    }
    catch(Exception e){
    }
    
    try{
      tester.setPixel(a, null);
      fail("Exception expected");
    }
    catch(Exception e){
    }
    
    try{
      tester.setPixel(null, null);
      fail("Exception expected");
    }
    catch(Exception e){
    }
  }
	
	@Test
	public void getPixelTest(){
	  Picture tester = new PictureImpl(3,3);
	  Pixel p = new ColorPixel(.3, .5, .7);
	  Coordinate c = new Coordinate(1,2);
	  
	  tester.setPixel(c, p);
	  assertEquals(tester.getPixel(c), p);
	  
	  try{
	    Coordinate c1 = new Coordinate(5,5);
	    tester.getPixel(c1);
	    fail("Should have caught an Exception");
	  }
	  catch(Exception e){}
	  
	}
	
	
}

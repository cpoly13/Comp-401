package a5.mariajg;

//Jackson Witzke
//Andrew Jacober

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
		
		return test_names;
	}
	
	//tests if zig zag is iterating correctly
	@Test
	public void zigzagTeset() { //test method declaration
		Picture p = new PictureImpl(4,4); //creates new picture object
		Iterator<Pixel> iZigZag = p.zigzag(); //creates zig zag iterator object
		
		//checks if pixel at (0,0) is equal to the first pixel traversed through 
		//by calling .next()
		assertEquals("values incorrect",p.getPixel(0,0), iZigZag.next());
	}
}

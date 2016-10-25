package a5.mariajg;

//Jackson Witzke
//Andrew Jacober

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "windowIterTest";
		test_names[1] = "tileIterTest";
		
		
		return test_names;
	}
	
	
	//tests if window iterator iterates correctly and returns the correct value 
	@Test
	public void windowIterTest(){ //test method declaration
		
		Picture p = new PictureImpl(5,5); //creates new picture object
		//creates new sub picture object by calling extract method and retrieving 
		//offsets, width, and height
		SubPicture sp = p.extract(0,0,3,2); 
		Pixel gp = new GrayPixel(.5); //creates a new gray pixel object
		p.setPixel(1, 1, gp); //sets pixel attributes 
		Iterator<SubPicture> window_iter = p.window(3, 2); //creates iterator object to slide (3,2)
		
		//checks if sub picture sources is equal to window iterator source
		assertEquals("source incorrect", sp.getSource(), window_iter.next().getSource());
		//checks if sub picture height is equal to window iterator height
		assertEquals("height incorrect", sp.getHeight(), window_iter.next().getHeight());
		//checks if sub picture width is equal to window iterator width
		assertEquals("width incorrect", sp.getWidth(), window_iter.next().getWidth());	
		
	}
	
	//tests if tile iterator iterates correctly and returns the correct value
	@Test
	public void tileIterTest(){ //test method declaration 
		Picture p = new PictureImpl(5,5); //creates new picture object
		//creates new sub picture object by calling extract method and retrieving 
		//offsets, width, and height
		SubPicture sp = p.extract(0,0,2,2); 
		Pixel gp = new GrayPixel(.5); //creates a new gray pixel object 
		p.setPixel(1, 1, gp); //set pixels attributes
		Iterator<SubPicture> tile_iter = p.tile(2, 2);//creates tile iterator to shift (2,2)
		
		//checks if sub picture source is equal to tile iterator source
		assertEquals("source incorrect", sp.getSource(), tile_iter.next().getSource());
		//checks if sub picture height is equal to tile iterator height
		assertEquals("height incorrect", sp.getHeight(), tile_iter.next().getHeight());
		//checks if sub picture width is equal to tile iterator width
		assertEquals("width incorrect", sp.getWidth(), tile_iter.next().getWidth());	
	
		
	}
}

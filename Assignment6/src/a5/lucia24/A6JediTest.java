package a5.lucia24;

import static org.junit.Assert.*;


import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;
import a6jedi.*;

public class A6JediTest {
	private static Pixel BLUE = new ColorPixel(0,0,1);
	private static Pixel RED = new ColorPixel(1,0,0);
	private static Pixel GREEN = new ColorPixel(0,1,0);
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
		
		return test_names;
	}
		
	@Test
	public void zigzagTest() {
		Picture p = new PictureImpl(5,5);
		
		for (int w=0; w<3; w++){
			for (int h=0; h<3; h++){
				p.setPixel(w, h, RED);
			}
		}
		p.setPixel(1, 1, BLUE);
		p.setPixel(2, 0, GREEN);
		p.setPixel(4, 0, BLUE);
		p.setPixel(4, 1, GREEN);
		p.setPixel(1, 4, BLUE);
		p.setPixel(2, 4, GREEN);
		
		Iterator<Pixel> zag = p.zigzag();
		Pixel[] zigPix = new Pixel[25];
		
		for(int i=0; i<25 ; i++){
			if (zag.hasNext()){
				zigPix[i] = zag.next();
			}
		}
		
		for(int i=0; i <25; i++){
			if (zigPix[i] == BLUE){
				assertEquals("", zigPix[i+1], GREEN);
			}
		}

	}
}

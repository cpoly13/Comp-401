package a5.yizhongz;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;


public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		
		test_names[0] = "iteratorSampleTest";
		test_names[1]="windowTest";
		test_names[2]="tileTest";
		
		return test_names;
	}
		
	
	@Test 
	public void iteratorSampleTest(){	//test sample method
		Picture p = new PictureImpl(3,4);
		Iterator<Pixel> sample1 = p.sample(2, 3, 3, 4);
		assertEquals("Sample does not work",
				p.getPixel(2,3), sample1.next());
		
	}
	@Test
	public void windowTest(){   //test window method
		Picture source = new PictureImpl(5,5);
		Iterator<SubPicture> window1 = source.window(3,2);
		Picture p=window1.next();
		assertEquals("window does not work",
				source.getPixel(0,0), p.getPixel(0,0));
	}
	@Test
	public void tileTest(){   //test tile method
		Picture source = new PictureImpl(5,5);
		Iterator<SubPicture> tile1=source.tile(2, 2);
		Picture p = tile1.next();
		assertEquals("tile does not work",
		source.getPixel(0,0),p.getPixel(0,0));
	}
}

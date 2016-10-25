package a5.mdz1999;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "pictureSampleTest";
		test_names[1] = "pictureWindowTest";
		
		return test_names;
	}
		
	@Test
	public void pictureSampleTest() {
		PictureImpl p = new PictureImpl(10,10);
		Iterator<Pixel> sample_iter = p.sample(9, 9, 1, 1);
		Pixel pix = sample_iter.next();
		if(!pix.equals(p.getPixel(9,9))){
			fail("Pixels not same!");
		}
	}
}

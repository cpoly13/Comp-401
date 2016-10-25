package a5.carly20;


import java.util.Iterator;
import static org.junit.Assert.*;
import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";
		
		return test_names;
	}
		
	@Test
	public void sampleTest() {
		Picture p = new PictureImpl(10, 15);
		Iterator<Pixel> p1 = p.sample(2, 3, 3, 4);
		assertNotEquals("Should not be equal", true, p.sample(0,0,1,1).equals(p1));
	}
	
	@Test
	public void windowTest() {
		Picture p1 = new PictureImpl(5, 5);
		Iterator<SubPicture> window_iter = p1.window(3, 2);
		p1.extract(0,0,3,2);
		p1.extract(1,0,3,2);
		p1.extract(2,0,3,2);
		p1.extract(0,1,3,2);
		p1.extract(1,1,3,2);
		p1.extract(2,1,3,2);
		p1.extract(0,2,3,2);
		p1.extract(1,2,3,2);
		p1.extract(2,2,3,2);
		p1.extract(0,3,3,2);
		p1.extract(1,3,3,2);
		p1.extract(2,3,3,2);
		assertEquals("Should be equivalent", false, window_iter.equals(p1));

		
	}
	
}

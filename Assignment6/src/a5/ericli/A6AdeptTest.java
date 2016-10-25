package a5.ericli;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
import a6adept.*;

public class A6AdeptTest {

		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "iteratorSampleTest";
		test_names[1] = "iteratorWindowTest";
		return test_names;
	}
		
	@Test
	public void iteratorSampleTest() {
		Picture p = new PictureImpl(15, 10);
		Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
		assertEquals(p.getPixel(2,3),sample_iter.next());
	}
	@Test
	public void iteratorWindowTest(){
		Picture p = new PictureImpl(5,5);
		SubPicture a = p.extract(0, 0, 3, 2);
		Iterator<SubPicture> window_iter = p.window(3, 2);
		assertTrue("Subbarea bad", compareSubPictures(a, window_iter.next()));

	}

	private boolean compareSubPictures(SubPicture a, SubPicture b) {
		// TODO Auto-generated method stub
		int c = a.getXOffset();
		int d = b.getXOffset();
		int e = a.getYOffset();
		int f = b.getYOffset();
		int g = a.getHeight();
		int h = b.getHeight();
		int i = a.getWidth();
		int j = b.getWidth();
		if((c == d) && (e==f)){
			if((g==h) && (i==j)){
				return true;
			}
			return false;
		}
		return false;
	}
	


	
	
}

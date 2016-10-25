package a5.jonrober;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;


public class A6AdeptTest {
	
	static public String[] getTestNames() {
		String[] test_names = new String[4];
		
		test_names[0] = "exampleTest";
		test_names[1] = "testSampleIter";
		test_names[2] = "testWindowXOffset";
		test_names[3] = "testWindowYOffset";
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	@Test
	public void testSampleIter(){
		
	    Picture p = new PictureImpl(10,15);
	    Pixel a = new ColorPixel(0.2, 0.3, 0.4);
		Pixel b = new ColorPixel(0.7, 0.7, 0.2);
		
		p.setPixel(1, 0, b);
	    p.setPixel(0, 0, a);
	    p.setPixel(2, 3, a);
	    p.setPixel(5, 3, b);
	   
		Iterator<Pixel> iter = p.sample(2,3,3,4);
		assertEquals("Iterator hasNext error",
				iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				iter.next(), p.getPixel(2,3));
		assertEquals("Iterator hasNext error",
				iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				iter.next(), p.getPixel(5, 3));
	}
	@Test
	public void testWindowXOffset(){
		Picture p = new PictureImpl(5,5);
	
		SubPicture sp = p.extract(0,0,3,2);
		
		Iterator<SubPicture> window_iter = p.window(3, 2);
	
		assertEquals("Iterator returned wrong SubPicture",
			window_iter.next().getXOffset(), sp.getXOffset());
		assertEquals("Iterator hasNext error",
				window_iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				window_iter.next().getXOffset(), p.extract(1,0,3,2).getXOffset());
		assertEquals("Iterator hasNext error",
				window_iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				window_iter.next().getXOffset(), p.extract(2,0,3,2).getXOffset());
		assertEquals("Iterator hasNext error",
				window_iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				window_iter.next().getXOffset(), p.extract(0,1,3,2).getXOffset());
	}
	@Test
	public void testWindowYOffset(){
		Picture p = new PictureImpl(5,5);
	
		SubPicture sp = p.extract(0,0,3,2);
		
		Iterator<SubPicture> window_iter = p.window(3, 2);
	
		assertEquals("Iterator returned wrong SubPicture",
			window_iter.next().getYOffset(), sp.getYOffset());
		assertEquals("Iterator hasNext error",
				window_iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				window_iter.next().getYOffset(), p.extract(1,0,3,2).getYOffset());
		assertEquals("Iterator hasNext error",
				window_iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				window_iter.next().getYOffset(), p.extract(2,0,3,2).getYOffset());
		assertEquals("Iterator hasNext error",
				window_iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				window_iter.next().getYOffset(), p.extract(0,1,3,2).getYOffset());
	}
	
}
	

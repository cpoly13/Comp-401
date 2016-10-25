package a5.jonrober;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;
import a6novice.*;

public class A6NoviceTest {
	
	static public String[] getTestNames() {
		
		String[] test_names = new String[3];
		
		test_names[0] = "exampleTest";
		test_names[1] = "testCoordinateConstructor";
		test_names[2] = "testIterator";
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	@Test
	public void testCoordinateContructor(){
		Picture pic= new PictureImpl(4,4);
		Coordinate c3 = new Coordinate(1,1);
		Coordinate c4 = new Coordinate(3,3);
		SubPicture subPic = pic.extract(c3, c4);
		assertEquals("SubPicture width not correct"
				,3,subPic.getWidth());
		assertEquals("SubPicture height not correct"
				,3, subPic.getWidth());
		}
	
	@Test
	public void testIterator(){
    Picture p = new PictureImpl(2,2);
	Pixel a = new ColorPixel(0.2, 0.3, 0.4);
	Pixel b = new ColorPixel(0.7, 0.7, 0.2);
	

	p.setPixel(0, 0, a);
	p.setPixel(1, 0, b);
		Iterator<Pixel> iter = p.iterator();
		assertEquals("Iterator hasNext error",
				iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				iter.next(),p.getPixel(0,0));
		assertEquals("Iterator hasNext error",
				iter.hasNext(),true);
		assertEquals("Iterator returned wrong pixel",
				iter.next(),p.getPixel(1,0));
	}
		
	}
package a5.abbatude;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.PictureImpl;
import a6adept.SubPicture;
//import a6novice.PictureImpl;
//import a6novice.Pixel;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "windowTest";
		test_names[1] = "tileTest";
		
		return test_names;
	}
		
	@Test
	public void windowTest() {
		PictureImpl p = new PictureImpl(5,2);
		Iterator<SubPicture> w = p.window(2, 2);
		assertEquals(2, w.next().getWidth());
		assertEquals(2, w.next().getWidth());
	}
	
	@Test
	public void tileTest() {
		PictureImpl p = new PictureImpl(2,2);
		Iterator<SubPicture> t = p.tile(1,1);
		t.next();
		t.next();
		assertEquals(true, t.hasNext());
		t.next();
		t.next();
		assertEquals(false, t.hasNext());}
	
}
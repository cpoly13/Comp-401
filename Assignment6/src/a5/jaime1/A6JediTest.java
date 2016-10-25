package a5.jaime1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "testPictureImplConstructorExceptions";
		
		return test_names;
	}
	@Test //testing runtime exception for invalid height/width
	public void testPictureImplConstructorExceptions()
	{
		Picture p = new PictureImpl(4, 5);
		try {
			SubPicture sp = new SubPictureImpl(p, 8, 3, 0, 0);
			fail("Expected RuntimeException for width or height = 0");
		} catch (RuntimeException e) {

	
		}
	
	}
}

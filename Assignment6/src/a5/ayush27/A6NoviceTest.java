package a5.ayush27;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "extractTest";

		return test_names;
	}
		
	@Test
	public void extractTest() {
	/* tests to see if extract method works by comparing width 
	 * and height of subPicture  */
		Picture p1 = new PictureImpl(10,10); 
		
		Coordinate c1 = new Coordinate(1,2);
		Coordinate c2 = new Coordinate(3,5);
		
		SubPicture sp1 = p1.extract(c1,c2);
		
		assertEquals(3, sp1.getWidth());
		assertEquals(4, sp1.getHeight());
		

	}
	
	
}



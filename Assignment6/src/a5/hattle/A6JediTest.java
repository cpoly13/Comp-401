package a5.hattle;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[2];
		
		test_names[0] = "exampleTest";
		test_names[1] = "zigzagTest";
		
		return test_names;
	}
		
	@Test
	public void zigzagTest() {
	
	Picture testPic = new PictureImpl(5,5);
	Coordinate c = new Coordinate(2,1);
	Pixel p = new ColorPixel(.75, .3, .4);
	testPic.setPixel(c, p);
	Iterator<Pixel> iteration = testPic.zigzag();
	for (int i = 0; i < 7; i++){
		iteration.next();
	}
	Pixel p2 = iteration.next();
	assertEquals(0.75, p2.getRed(), 0.001);
	assertEquals(0.3,  p2.getGreen(), 0.001);
	assertEquals(0.4,  p2.getBlue(), 0.001);
	}
}

package a5.vluhadia;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[6];
		
		test_names[0] = "exampleTest";
		test_names[1] = "coordinateTest";
		test_names[2] = "getHeightTest";
		test_names[3] = "getWidthTest";
		test_names[4] = "getTransparencyTest";
		test_names[5] = "getIntensityTest";
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	
	@Test
	public void coordinateTest() {
		Coordinate coordinate = new Coordinate(3,4);
		
		assertEquals(coordinate.getY(), 4);
	}
	
	
	@Test
	public void getHeightTest() {
		PictureImpl pic = new PictureImpl(4,5);
		
		assertEquals(pic.getHeight(), 5);
	}
	
	@Test
	public void getWidthTest() {
		PictureImpl pic2 = new PictureImpl(2,8);
		
		assertEquals(pic2.getWidth(), 2);
	}
	@Test
	public void getTransparencyTest() {
		TransparentColorPixel tcp = new TransparentColorPixel(.3,.3,.3,.5);
		assertTrue(tcp.getTransparency()==.5);
		
		
		
	}
	
	

	
	
	
	@Test
	public void getIntensityTest() {
		GrayPixel gp = new GrayPixel(.56);
		assertTrue(gp.getIntensity()==.56);
	}
	
}

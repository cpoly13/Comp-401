package a5.cahemmer;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "exampleTest";
		test_names[1] = "sampleTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() {
	}
	
	@Test
	public void sampleTest(){
		Picture test = new PictureImpl(15,10);
		
		Coordinate[] coordinates = new Coordinate[10];
		
		Iterator<Pixel> iterator = test.sample(2, 3, 3, 4);
		
		coordinates[0]= new Coordinate(2,3);
		coordinates[1]= new Coordinate(5,3);
		coordinates[2]= new Coordinate(8,3);
		coordinates[3]= new Coordinate(11,3);
		coordinates[4]= new Coordinate(14,3);
		coordinates[5]= new Coordinate(2,7);
		coordinates[6]= new Coordinate(5,7);
		coordinates[7]= new Coordinate(8,7);
		coordinates[8]= new Coordinate(11,7);
		coordinates[9]= new Coordinate(14,7);
		
		test.setPixel(coordinates[0], new ColorPixel(.1, .5, .5));
		test.setPixel(coordinates[1], new ColorPixel(.2, .5, .5));
		test.setPixel(coordinates[2], new ColorPixel(.3, .5, .5));
		test.setPixel(coordinates[3], new ColorPixel(.4, .5, .5));
		test.setPixel(coordinates[4], new ColorPixel(.5, .5, .5));
		test.setPixel(coordinates[5], new ColorPixel(.6, .5, .5));
		test.setPixel(coordinates[6], new ColorPixel(.7, .5, .5));
		test.setPixel(coordinates[7], new ColorPixel(.8, .5, .5));
		test.setPixel(coordinates[8], new ColorPixel(.9, .5, .5));
		test.setPixel(coordinates[9], new ColorPixel(0.0, .5, .5));
		
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[0]));
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[1]));
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[2]));
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[3]));
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[4]));
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[5]));
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[6]));
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[7]));
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[8]));
		assertEquals("Sample of wrong coordinate", iterator.next(), test.getPixel(coordinates[9]));	
		
	}
	
	
}

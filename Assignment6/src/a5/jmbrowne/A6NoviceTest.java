package a5.jmbrowne;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest 
{
		
	static public String[] getTestNames() 
	{
		String[] test_names = new String[3];
		
		test_names[0] = "exampleTest";
		test_names[1] = "setPixelTest";
		test_names[2] = "extractTest";
		
		return test_names;
	}
		
	@Test
	public void exampleTest() 
	{
	}
	
	@Test
	public void setPixelTest() //tests the implementation of the setPixel method in A6 Novice
	{
		PictureImpl testPic = new PictureImpl(3,3);
		Pixel testPixel1 = new GrayPixel(0.4);
		Coordinate locPixel1 = new Coordinate(0,0);
		Pixel testPixel2 = new ColorPixel(0.1,0.4,0.7);
		Coordinate locPixel2 = new Coordinate(0,1);
		
		testPic.setPixel(locPixel1, testPixel1);
		testPic.setPixel(locPixel2, testPixel2);
		
		assertEquals(testPixel1,testPic.getPixel(0,0));
		assertEquals(testPixel2,testPic.getPixel(0,1));
	}
	
	@Test
	public void extractTest() //tests the implementation of the extract method in A6 Novice
	{
		PictureImpl testPic = new PictureImpl(10,10);
		for(int i=0; i<10; i++) //assigns random gray pixels to the elements of the test picture
		{
			for(int j=0; j<10; j++)
			{
				testPic.setPixel(i, j, new GrayPixel(Math.random()));
			}
		}
		
		
		Coordinate testCoordTopLeft = new Coordinate(3,3);
		Coordinate testCoordBotRight = new Coordinate(8,8);
		
		SubPicture testSubPic = testPic.extract(testCoordTopLeft, testCoordBotRight);
		
		assertEquals(testSubPic.getPixel(0,0),testPic.getPixel(3,3));
		assertEquals(testSubPic.getPixel(2,2),testPic.getPixel(5,5));
	}
}

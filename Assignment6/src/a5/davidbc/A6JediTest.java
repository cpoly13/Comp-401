package a5.davidbc;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
		
		return test_names;
	}

@Test
public void zigzagTest(){
	//For this test, I assigned each row a certain pixel, and then
	//called zigzag on the picture and compared the zigzag pixels
	//to the expected pixels.
	Picture testPic = new PictureImpl(3,3);
	Pixel firstRowPix = new GrayPixel(0.1);
	Pixel secondRowPix = new GrayPixel(0.2);
	Pixel thirdRowPix = new GrayPixel(0.3);
	for(int i = 0; i<3; i++){
		for( int j = 0; j<3; j++){
			if(i==0){
			testPic.setPixel(j,i,firstRowPix);
			}else if(i == 1){
				testPic.setPixel(j,i,secondRowPix);
			}else{
				testPic.setPixel(j, i,thirdRowPix);
			}
		}
	}
	Iterator<Pixel> testZigzag = testPic.zigzag();
	assertEquals(testZigzag.next(), firstRowPix);
	assertEquals(testZigzag.next(), firstRowPix);
	assertEquals(testZigzag.next(), secondRowPix);
	assertEquals(testZigzag.next(), thirdRowPix);
	assertEquals(testZigzag.next(), secondRowPix);
	assertEquals(testZigzag.next(), firstRowPix);
	assertEquals(testZigzag.next(), secondRowPix);	
	assertEquals(testZigzag.next(), thirdRowPix);
	assertEquals(testZigzag.next(), thirdRowPix);
}
}



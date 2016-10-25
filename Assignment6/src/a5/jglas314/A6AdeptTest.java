package a5.jglas314;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[3];
		

		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";
		test_names[2] = "tileTest";
		
		return test_names;
	}
		

	
	@Test
	public void sampleTest(){
		Picture p1 = genPicture(15,10);
		Iterator<Pixel> sampleIter = p1.sample(2, 3, 3, 4);
		
		for (int j = 3; j <= 7; j+=4){
			for(int i = 2; i <= 14; i+=3){				
				assertEquals(p1.getPixel(new Coordinate(i,j)), sampleIter.next());	
			}
		}
	}
	
	@Test
	public void windowTest(){
		Picture p1 = genPicture(5,5);
		Iterator<SubPicture> windowIter = p1.window(3, 2);
		Picture windowPic = null;
		
		for(int j = 0; j < 4; j++){
			for(int i = 0; i < 3; i++){	
				
				windowPic = windowIter.next();	

				for (int l = 0; l < p1.extract(i,j,3,2).getHeight(); l++){
					for (int k = 0; k < p1.extract(i,j,3,2).getWidth(); k++){
						assertEquals(p1.extract(i,j,3,2).getPixel(k,l), 
									 windowPic.getPixel(k, l));		
					}
				}
			}
		}
	}
	
	@Test
	public void tileTest(){
		Picture p1 = genPicture(10,10);
		Iterator<SubPicture> tileIter = p1.tile(3, 3);
		Picture tilePic = null;
		for (int j = 0; j <= 6; j+=3){
			for (int i = 0; i <= 6; i+=3){
				tilePic = tileIter.next();
				for (int l = 0; l < 4; l++){
					for (int k = 0; k < 4; k++){
						assertEquals(p1.extract(i, j, 3,3 ).getPixel(k,l),
							tilePic.getPixel(k,l));
					}
				}
			}
		}		
	}
	
	public static Coordinate[] coordList(int width, int height){
		Coordinate[] result = new Coordinate[width*height];
		for (int j = 0; j < height; j++){
			for (int i = 0; i < width; i ++){
				result[j*width+i] = new Coordinate(i,j);
			}		
		}
		return result;
	}
	
	public static Picture genPicture(int width, int height){
		Picture p1 = new PictureImpl(width, height);
		Coordinate[] coords = coordList(width, height);
		for (int j = 0; j < height; j++){
			for (int i = 0; i < width; i ++){
				p1.setPixel(coords[j*width+i], new ColorPixel(Math.random(),Math.random(),Math.random())); 
			}		
		}
		return p1; 	
	}
	
	
}

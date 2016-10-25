package a5.jglas314;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

//import a6adept.ColorPixel;
//import a6adept.Coordinate;
//import a6adept.Picture;
//import a6adept.PictureImpl;
//import a6adept.SubPicture;
import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
		
		return test_names;
	}
		
	@Test
	public void zigzagTest() {
		Picture p1 = genPicture(15,10);
		Iterator<Pixel> zigzag = p1.zigzag();
		
		int x = 0;
		int y = 0;
		
		while (x < 15){
			if (y == 0){
				if (x % 2 ==0){
					System.out.println(x + " " + y);
					if ((x< 15) && (y<10)){
						assertEquals(p1.getPixel(x,y), zigzag.next());
					} 
					x += 1;
				} else {
					while (x != 0){
						if ((x< 15) && (y<10)){
							assertEquals(p1.getPixel(x,y), zigzag.next());
						} 
						x -= 1;
						y += 1;			
					}
				}
			} else {
				if (y % 2 == 0){
					while (y != 0){
						if ((x< 15) && (y<10)){
							assertEquals(p1.getPixel(x,y), zigzag.next());
						}	
						x += 1;
						y -= 1;		
					}	
				} else {
					if ((x< 15) && (y<10)){
						assertEquals(p1.getPixel(x,y), zigzag.next());
					}
					y += 1;
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

package a5.conradc;

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
	

	/** JUnit test for sample iterator of PictureImpl
	 * Input: None
	 * Output: Asserts whether sample iterator was properly implemented
	 */
	
	@Test
	public void sampleTest(){
		
		int dx = 2;
		int dy = 2;
		
		PictureImpl _picture = testPicture();
		Iterator<Pixel> _sample = _picture.sample(1, 1, 2, 2);
		
		for(int i = 1; i < _picture.getHeight(); i += dy){
			for(int j = 1; j < _picture.getWidth(); j += dx){
				assertEquals(_sample.next(),_picture.getPixel(j,i));
			}
		}
		
	}
	
	/** JUnit test for window iterator of PictureImpl
	 * Input: None
	 * Output: Asserts whether window iterator was properly implemented
	 */
	
	@Test
	public void windowTest(){
		
		int window_x = 2;
		int window_y = 2;
		
		PictureImpl _picture = testPicture();
		Iterator<SubPicture> _window = _picture.window(window_x, window_y);
		
		int largest_y = _picture.getHeight()-(window_y - 1);
		int largest_x = _picture.getWidth()-(window_x - 1);
		
		for(int i = 0; i <largest_y; i++){
			for(int j = 0; j < largest_x; j++){
				
				SubPicture _sp = _window.next();
				SubPicture sp = _picture.extract(j,i,2,2);
				
				//compares each pixel in window
				for(int m = 0; m< window_x; m++){
					for(int n = 0; n< window_y; n++){
						assertEquals(_sp.getPixel(m,n), sp.getPixel(m,n));
					}
				}
			}
		}
		
	}
	
	/** JUnit test for tile iterator of PictureImpl
	 * Input: None
	 * Output: Asserts whether tile iterator was properly implemented
	 */
	
	
	@Test
	public void tileTest(){
		
		int tile_x = 2;
		int tile_y = 2;
		
		PictureImpl _picture = testPicture();
		Iterator<SubPicture> _tile = _picture.tile(2, 2);
		
		int largest_y = _picture.getHeight()-(tile_y - 1);
		int largest_x = _picture.getWidth()-(tile_x - 1);
		
		for(int i = 0; i <largest_y; i += tile_y){
			for(int j = 0; j < largest_x; j += tile_x){
				
				SubPicture _sp = _tile.next();
				SubPicture sp = _picture.extract(j,i,2,2);
				
				//compares each pixel in window
				for(int m = 0; m< 2; m++){
					for(int n = 0; n<2; n++){
						assertEquals(_sp.getPixel(m,n), sp.getPixel(m,n));
					}
				}
			}
		}
		
	}
	
	/**Helper method for constructing a Picture and filling it with pixels
	 * Input: None
	 * Output: PictureImpl object filled with unique Pixels
	 */
	
	private static PictureImpl testPicture(){
		PictureImpl pic_test = new PictureImpl(5,5);
		
		for(int i = 0; i< pic_test.getHeight(); i++){
			for(int j =0; j< pic_test.getWidth(); j++){
				pic_test.setPixel(j,i,new ColorPixel(j/pic_test.getWidth(), i/pic_test.getHeight(), 0));
			}
		}
		
		return pic_test;
	}

}

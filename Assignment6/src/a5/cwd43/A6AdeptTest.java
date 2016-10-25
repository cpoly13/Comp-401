package a5.cwd43;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

	static public String[] getTestNames() {
		String[] test_names = new String[2];

		test_names[0] = "sampleTest";
		test_names[1] = "windowTest";

		return test_names;
	}

	@Test
	public void sampleTest() {

		PictureImpl p = new PictureImpl(10, 10);
		Iterator<Pixel> iter = p.sample(0, 0, 3, 3);

		for (int i = 0; i < p.getHeight(); i += 3) {
			for (int j = 0; j < p.getWidth(); j += 3) {
				assertEquals(iter.next(), p.getPixel(j, i));
			}
		}	
	}

	@Test
	public void windowTest() {

		PictureImpl p = new PictureImpl(5, 5);
		Iterator<SubPicture> window_iter = p.window(2, 3);
		for(int n=0; n < p.getHeight()-3; n++){
			for(int m=0; m < p.getWidth()-2; m++){
				SubPicture window = window_iter.next();
				for(int i=0; i < 3; i++){
					for(int j=0; j < 2; j++){
						assertEquals(p.extract(m, n, 2, 3).getPixel(j, i), window.getPixel(j, i));
					}
				}
			}
		}


	}

}

package a5.vatsal;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "sampleTest";

	return test_names;
    }

    private static final Pixel RED = new ColorPixel(1, 0, 0);
    private static final Pixel GREEN = new ColorPixel(0, 1, 0);
    private static final Pixel BLUE = new ColorPixel(0, 0, 1);

    /*
     * Check to see if sample iterator method is iterating properly through a
     * Picture object
     */

    @Test
    public void sampleTest() {
	Picture examplePicture = new PictureImpl(3, 3);

	examplePicture.setPixel(0, 0, RED);
	examplePicture.setPixel(2, 0, GREEN);
	examplePicture.setPixel(0, 2, BLUE);
	examplePicture.setPixel(2, 2, RED);

	Iterator<Pixel> exampleIterator = examplePicture.sample(0, 0, 2, 2);

	if (exampleIterator.hasNext()) {
	    assertTrue(exampleIterator.next().equals(RED));
	}
	if (exampleIterator.hasNext()) {
	    assertTrue(exampleIterator.next().equals(GREEN));
	}
	if (exampleIterator.hasNext()) {
	    assertTrue(exampleIterator.next().equals(BLUE));
	}
	if (exampleIterator.hasNext()) {
	    assertTrue(exampleIterator.next().equals(RED));
	}

    }

}

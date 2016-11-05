package a5.jmbrowne;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[3];

	test_names[0] = "exampleTest";
	test_names[1] = "windowTest";
	test_names[2] = "tileTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void windowTest() // tests an iterator produced by the window method
    {
	PictureImpl p = new PictureImpl(5, 5);
	for (int i = 0; i < 5; i++) // assigns random gray pixels to the
				    // elements of the test picture
	{
	    for (int j = 0; j < 5; j++) {
		p.setPixel(i, j, new a6adept.GrayPixel(Math.random()));
	    }
	}

	Iterator<SubPicture> window_iter = p.window(3, 2);

	SubPicture testPic1 = window_iter.next();
	SubPicture testPic2 = p.extract(0, 0, 3, 2);

	assertEquals(testPic1.getPixel(0, 0), testPic2.getPixel(0, 0));
	assertEquals(testPic1.getPixel(1, 1), testPic2.getPixel(1, 1));

    }

    @Test
    public void tileTest() // tests an iterator produced by the tile method
    {
	PictureImpl f = new PictureImpl(5, 5);
	for (int i = 0; i < 5; i++) // assigns random gray pixels to the
				    // elements of the test picture
	{
	    for (int j = 0; j < 5; j++) {
		f.setPixel(i, j, new a6adept.GrayPixel(Math.random()));
	    }
	}

	Iterator<SubPicture> tile_iter = f.tile(2, 2);

	SubPicture testPicture1 = tile_iter.next();
	SubPicture testPicture2 = f.extract(0, 0, 3, 2);

	assertEquals(testPicture1.getPixel(0, 0), testPicture2.getPixel(0, 0));
	assertEquals(testPicture1.getPixel(1, 1), testPicture2.getPixel(1, 1));
    }
}

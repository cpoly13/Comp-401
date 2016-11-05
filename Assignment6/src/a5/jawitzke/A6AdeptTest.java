package a5.jawitzke;

// maria gilcoat
//andrew jacober
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "windowIteratorTest";
	test_names[1] = "tileIteratorTest";

	return test_names;
    }

    @Test
    public void windowIteratorTest() {
	// create new picture p
	Picture p = new PictureImpl(5, 5);
	// create a subpicture of picture
	SubPicture sp = p.extract(0, 0, 3, 2);
	// create new gray pixel
	Pixel gp = new GrayPixel(.5);
	// set the pixel
	p.setPixel(1, 1, gp);
	Iterator<SubPicture> window_iterator = p.window(3, 2);
	// test to make sure the source of the subpicture and iterator are equal
	assertEquals("incorrect source", sp.getSource(), window_iterator.next().getSource());
	// test to make sure the height of the subpicture and iterator are equal
	assertEquals("incorrect height", sp.getHeight(), window_iterator.next().getHeight());
	// test to make sure the width of the subpicture and iterator are equal
	assertEquals("incorrect width", sp.getWidth(), window_iterator.next().getWidth());

    }

    @Test
    public void tileIteratorTest() {
	// create new picture p
	Picture p = new PictureImpl(5, 5);

	SubPicture sp = p.extract(0, 0, 2, 2);
	// create new gray pixel
	Pixel gp = new GrayPixel(0.5);
	p.setPixel(1, 1, gp);
	Iterator<SubPicture> tile_iter = p.tile(2, 2);

	assertEquals("incorrect source", sp.getSource(), tile_iter.next().getSource());
	assertEquals("incorrect height", sp.getHeight(), tile_iter.next().getHeight());
	assertEquals("incorrect width", sp.getWidth(), tile_iter.next().getWidth());

    }

}

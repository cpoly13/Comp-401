package a5.david3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	List<String> test_names = new ArrayList<String>();

	test_names.add("sample");
	test_names.add("window");
	test_names.add("tile");

	return test_names.toArray(new String[0]);
    }

    private static boolean subPicturesEqual(SubPicture sp, SubPicture test) {
	if (sp == null)
	    return test == null;
	if (test == null)
	    return sp == null;
	if (sp.getWidth() != test.getWidth())
	    return false;
	if (sp.getHeight() != test.getHeight())
	    return false;
	if (sp.getXOffset() != test.getXOffset())
	    return false;
	if (sp.getYOffset() != test.getYOffset())
	    return false;

	for (int i = 0; i < sp.getWidth(); i++) {
	    for (int j = 0; j < sp.getHeight(); j++) {
		if (sp.getPixel(i, j).getIntensity() != test.getPixel(i, j).getIntensity())
		    return false;
	    }
	}

	return true;
    }

    @Test
    public void sample() {
	Picture p = new PictureImpl(2, 2);
	Pixel p00 = new GrayPixel(0);
	Pixel p01 = new GrayPixel(.2);
	Pixel p10 = new GrayPixel(.4);
	Pixel p11 = new GrayPixel(.6);

	p.setPixel(0, 0, p00);
	p.setPixel(0, 1, p01);
	p.setPixel(1, 0, p10);
	p.setPixel(1, 1, p11);

	Iterator<Pixel> iter = p.sample(0, 0, 1, 1);
	assertTrue(iter instanceof Iterator);

	int i = 0, j = 0;
	while (iter.hasNext()) {
	    Pixel pix = iter.next();
	    assertTrue(pix.getIntensity() == p.getPixel(i, j).getIntensity());
	    if (i == 0) {
		i++;
	    } else if (i == p.getWidth() - 1) {
		i = 0;
		j++;
	    }
	}

	try {
	    p.sample(-1, 0, 1, 1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.sample(2, 0, 1, 1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.sample(0, -1, 1, 1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.sample(0, 2, 1, 1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.sample(0, 0, -1, 1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.sample(-1, 0, 1, -1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}
    }

    @Test
    public void window() {
	Picture p = new PictureImpl(2, 2);
	Pixel p00 = new GrayPixel(0);
	Pixel p01 = new GrayPixel(.2);
	Pixel p10 = new GrayPixel(.4);
	Pixel p11 = new GrayPixel(.6);

	p.setPixel(0, 0, p00);
	p.setPixel(0, 1, p01);
	p.setPixel(1, 0, p10);
	p.setPixel(1, 1, p11);

	SubPicture[] pics = new SubPicture[] { p.extract(0, 0, 1, 1), p.extract(1, 0, 1, 1), p.extract(0, 1, 1, 1),
		p.extract(1, 1, 1, 1) };

	Iterator<SubPicture> iter = p.window(1, 1);
	assertTrue(iter instanceof Iterator);

	int i = 0;
	try {
	    while (iter.hasNext()) {
		if (!subPicturesEqual(pics[i], iter.next()))
		    fail("SubPictures not equal at index i{" + i + "}");
		i++;
	    }
	} catch (IndexOutOfBoundsException e) {
	    fail("index out of bounds in array pics at i{" + i + "}");
	}

	try {
	    iter.next();
	    fail("no exception thrown");
	} catch (NoSuchElementException e) {
	}

	try {
	    p.window(-1, 1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.window(3, 1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.window(1, -1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.window(1, 3);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}
    }

    @Test
    public void tile() {
	Picture p = new PictureImpl(2, 2);
	Pixel p00 = new GrayPixel(0);
	Pixel p01 = new GrayPixel(.2);
	Pixel p10 = new GrayPixel(.4);
	Pixel p11 = new GrayPixel(.6);

	p.setPixel(0, 0, p00);
	p.setPixel(0, 1, p01);
	p.setPixel(1, 0, p10);
	p.setPixel(1, 1, p11);

	SubPicture[] pics = new SubPicture[] { p.extract(0, 0, 1, 1), p.extract(1, 0, 1, 1), p.extract(0, 1, 1, 1),
		p.extract(1, 1, 1, 1) };

	Iterator<SubPicture> iter = p.tile(1, 1);
	assertTrue(iter instanceof Iterator);

	int i = 0;
	try {
	    while (iter.hasNext()) {
		if (!subPicturesEqual(pics[i], iter.next()))
		    fail("SubPictures not equal at index i{" + i + "}");
		i++;
	    }
	} catch (IndexOutOfBoundsException e) {
	    fail("index out of bounds in array pics at i{" + i + "}");
	}

	try {
	    iter.next();
	    fail("no exception thrown");
	} catch (NoSuchElementException e) {
	}

	try {
	    p.tile(-1, 1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.tile(3, 1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.tile(1, -1);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}

	try {
	    p.tile(1, 3);
	    fail("no exception thrown");
	} catch (IllegalArgumentException e) {
	}
    }
}

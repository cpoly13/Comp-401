package a6.david3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	List<String> test_names = new ArrayList<String>();

	test_names.add("setPixelCoordinate");
	test_names.add("getPixelCoordinate");
	test_names.add("extract");
	test_names.add("iterator");

	return test_names.toArray(new String[0]);
    }

    @Test
    public void setPixelCoordinate() {
	Coordinate c = new Coordinate(3, 3);
	Picture p = new PictureImpl(5, 5);
	Pixel pix = new GrayPixel(0);
	p.setPixel(c, pix);
	assertTrue(pix.getIntensity() == p.getPixel(3, 3).getIntensity());
    }

    @Test
    public void getPixelCoordinate() {
	Coordinate c = new Coordinate(3, 3);
	Picture p = new PictureImpl(5, 5);
	Pixel pix = new GrayPixel(0);
	p.setPixel(3, 3, pix);
	assertTrue(pix.getIntensity() == p.getPixel(c).getIntensity());
    }

    @Test
    public void extract() {
	Picture p = new PictureImpl(5, 5);
	SubPicture osp = p.extract(2, 2, 2, 2);
	SubPicture test = p.extract(new Coordinate(2, 2), new Coordinate(3, 3));
	SubPicture test2 = p.extract(new Coordinate(2, 3), new Coordinate(3, 2));
	SubPicture test3 = p.extract(new Coordinate(3, 2), new Coordinate(2, 3));
	SubPicture test4 = p.extract(new Coordinate(3, 3), new Coordinate(2, 2));
	assertTrue(subPicturesEqual(osp, test));
	assertTrue(subPicturesEqual(osp, test2));
	assertTrue(subPicturesEqual(osp, test3));
	assertTrue(subPicturesEqual(osp, test4));
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
    public void iterator() {
	Picture p = new PictureImpl(2, 2);
	Pixel p00 = new GrayPixel(0);
	Pixel p01 = new GrayPixel(.2);
	Pixel p10 = new GrayPixel(.4);
	Pixel p11 = new GrayPixel(.6);

	p.setPixel(0, 0, p00);
	p.setPixel(0, 1, p01);
	p.setPixel(1, 0, p10);
	p.setPixel(1, 1, p11);

	Iterator<Pixel> iter = p.iterator();
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
	    iter.next();
	    fail("next did not throw NoSuchElementException");
	} catch (NoSuchElementException e) {

	}
    }
}

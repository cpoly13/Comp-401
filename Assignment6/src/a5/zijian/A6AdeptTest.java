package a5.zijian;

import java.util.Iterator;

import org.junit.Test;
import org.junit.Assert;

import a6adept.*;

public class A6AdeptTest {

    static public String[] getTestNames() {
	String[] test_names = new String[2];

	test_names[0] = "sampleTest";
	test_names[1] = "tileTest";

	return test_names;
    }

    @Test
    public void exampleTest() {
    }

    @Test
    public void sampleTest() {
	Picture pic = new PictureImpl(15, 12);
	Iterator<Pixel> sample_iter = pic.sample(2, 3, 3, 4);
	Pixel p1 = new ColorPixel(0.98, 0.76, 0.54);

	for (int j = 3; j < 12; j += 4) {
	    for (int i = 2; i < 15; i += 3) {
		pic.setPixel(i, j, p1);
	    }
	}

	int count = 0;
	while (sample_iter.hasNext()) {
	    Pixel iter_pic = sample_iter.next();
	    Assert.assertEquals(0.98, iter_pic.getRed(), 0.001);
	    Assert.assertEquals(0.76, iter_pic.getGreen(), 0.001);
	    Assert.assertEquals(0.54, iter_pic.getBlue(), 0.001);
	    count += 1;
	}
	Assert.assertEquals(15, count, 0);
    }

    @Test
    public void tileTest() {
	Picture pic = new PictureImpl(7, 10);
	Iterator<SubPicture> tile_iter = pic.tile(2, 3);

	for (int yOff = 0; yOff < 9; yOff += 3) {
	    for (int xOff = 0; xOff < 6; xOff += 2) {
		SubPicture sub = tile_iter.next();
		Assert.assertEquals(xOff, sub.getXOffset(), 0);
		Assert.assertEquals(yOff, sub.getYOffset(), 0);
	    }
	}
    }

}

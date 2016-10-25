package a5.joplever;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

  static public String[] getTestNames() {
    String[] test_names = new String[1];

    test_names[0] = "jUnitTest4";

    return test_names;
  }

  @Test
  public void jUnitTest4() {
    Picture testPicture = new PictureImpl(7, 7);
    Pixel red = new ColorPixel(1, 0, 0);
    testPicture.setPixel(0, 0, red);
    testPicture.setPixel(2, 0, red);
    testPicture.setPixel(4, 0, red);
    testPicture.setPixel(6, 0, red);
    testPicture.setPixel(0, 2, red);
    testPicture.setPixel(2, 2, red);
    testPicture.setPixel(4, 2, red);
    testPicture.setPixel(6, 2, red);
    testPicture.setPixel(0, 4, red);
    testPicture.setPixel(2, 4, red);
    testPicture.setPixel(4, 4, red);
    testPicture.setPixel(6, 4, red);
    testPicture.setPixel(0, 6, red);
    testPicture.setPixel(2, 6, red);
    testPicture.setPixel(4, 6, red);
    testPicture.setPixel(6, 6, red);
    Iterator<Pixel> sample_iter = testPicture.sample(0, 0, 2, 2);
    while (sample_iter.hasNext()) {
      assertEquals(red, sample_iter.next());
    }
  }
}

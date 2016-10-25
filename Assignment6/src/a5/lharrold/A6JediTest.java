package a5.lharrold;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {

  static public String[] getTestNames() {
    String[] test_names = new String[1];

    test_names[0] = "testZigZag";

    return test_names;
  }

  @Test
  public void testZigZag() {
    Picture pic = new PictureImpl(3, 3);
    ColorPixel pix = new ColorPixel(.7, .6, .5);
    Pixel newPix = pic.getPixel(0, 0).blend(pix, 0.0);
    pic.setPixel(0, 0, newPix);

    Iterator<Pixel> iter = pic.zigzag();
    assertEquals(pic.getPixel(0, 0), iter.next());
    assertEquals(pic.getPixel(1, 1), iter.next());
  }
}

package a5.joplever;

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

    test_names[0] = "jUnitTest5";

    return test_names;
  }

  @Test
  public void jUnitTest5() {
    Picture testPicture = new PictureImpl(5, 5);
    Pixel red = new ColorPixel(1, 0, 0);
    Pixel blue = new ColorPixel(0, 0, 1);
    testPicture.setPixel(0, 0, red);
    testPicture.setPixel(1, 0, blue);
    testPicture.setPixel(0, 1, red);
    testPicture.setPixel(0, 2, blue);
    testPicture.setPixel(1, 1, red);
    testPicture.setPixel(2, 0, blue);
    testPicture.setPixel(3, 0, red);
    testPicture.setPixel(2, 1, blue);
    testPicture.setPixel(1, 2, red);
    testPicture.setPixel(0, 3, blue);
    testPicture.setPixel(0, 4, red);
    testPicture.setPixel(1, 3, blue);
    testPicture.setPixel(2, 2, red);
    testPicture.setPixel(3, 1, blue);
    testPicture.setPixel(4, 0, red);
    testPicture.setPixel(4, 1, blue);
    testPicture.setPixel(3, 2, red);
    testPicture.setPixel(2, 3, blue);
    testPicture.setPixel(1, 4, red);
    testPicture.setPixel(2, 4, blue);
    testPicture.setPixel(3, 3, red);
    testPicture.setPixel(4, 2, blue);
    testPicture.setPixel(4, 3, red);
    testPicture.setPixel(3, 4, blue);
    testPicture.setPixel(4, 4, red);

    Iterator<Pixel> zig_iter = testPicture.zigzag();
    for (int i = 0; i < (testPicture.getWidth() * testPicture.getHeight()); i++) {
      if (zig_iter.hasNext()) {
        assertEquals(red, zig_iter.next());
      }
      if (zig_iter.hasNext()) {
        assertEquals(blue, zig_iter.next());
      }
    }
  }
}

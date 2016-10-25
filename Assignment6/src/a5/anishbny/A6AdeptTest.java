package a5.anishbny;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

  static public String[] getTestNames() {
    String[] test_names = new String[3];

    test_names[0] = "test2";
    test_names[1] = "test3";
    test_names[2] = "test4";

    return test_names;
  }

  @Test
  public void test2() {
    Picture p = new PictureImpl(4, 4);
    p.setPixel(0, 0, new GrayPixel(0.1));
    p.setPixel(2, 0, new GrayPixel(0.2));
    p.setPixel(0, 2, new GrayPixel(0.3));
    p.setPixel(2, 2, new GrayPixel(0.4));
    Pixel[] testArray = { new GrayPixel(0.1), new GrayPixel(0.2), new GrayPixel(0.3),
        new GrayPixel(0.4) };
    Iterator<Pixel> sample_iter = p.sample(0, 0, 2, 2);
    boolean passed = true;
    int counter = 0;
    while (sample_iter.hasNext()) {
      Pixel s = sample_iter.next();
      if (testArray[counter].getIntensity() != s.getIntensity()) {
        passed = false;
      }
      counter++;
    }
    assertTrue(passed);
  }

  public boolean picturesEqual(SubPicture p1, SubPicture p2) {
    for (int i = 0; i < p1.getWidth(); i++) {
      for (int j = 0; j < p1.getHeight(); j++) {
        if (p1.getPixel(i, j).getIntensity() != p2.getPixel(i, j).getIntensity()) {
          return false;
        }
      }
    }
    return true;
  }

  @Test
  public void test3() {
    Picture p = new PictureImpl(5, 5);
    SubPicture[] test = new SubPicture[12];

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        p.setPixel(i, j, new GrayPixel(Math.random()));
      }
    }

    test[0] = p.extract(0, 0, 3, 2);
    test[1] = p.extract(1, 0, 3, 2);
    test[2] = p.extract(2, 0, 3, 2);
    test[3] = p.extract(0, 1, 3, 2);
    test[4] = p.extract(1, 1, 3, 2);
    test[5] = p.extract(2, 1, 3, 2);
    test[6] = p.extract(0, 2, 3, 2);
    test[7] = p.extract(1, 2, 3, 2);
    test[8] = p.extract(2, 2, 3, 2);
    test[9] = p.extract(0, 3, 3, 2);
    test[10] = p.extract(1, 3, 3, 2);
    test[11] = p.extract(2, 3, 3, 2);

    Iterator<SubPicture> window_iter = p.window(3, 2);
    boolean passed = true;
    int counter = 0;
    while (window_iter.hasNext()) {
      if (!picturesEqual(window_iter.next(), test[counter])) {
        passed = false;
      }
      counter++;
    }
    assertTrue(passed);
  }

  @Test
  public void test4() {
    Picture p = new PictureImpl(5, 5);
    SubPicture[] test = new SubPicture[4];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        p.setPixel(i, j, new GrayPixel(Math.random()));
      }
    }
    test[0] = p.extract(0, 0, 2, 2);
    test[1] = p.extract(2, 0, 2, 2);
    test[2] = p.extract(0, 2, 2, 2);
    test[3] = p.extract(2, 2, 2, 2);

    Iterator<SubPicture> tile_iter = p.tile(2, 2);
    boolean passed = true;
    int counter = 0;
    while (tile_iter.hasNext()) {
      if (!picturesEqual(tile_iter.next(), test[counter])) {
        passed = false;
      }
      counter++;
    }
  }
}

package a5.anishbny;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.GrayPixel;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {

  static public String[] getTestNames() {
    String[] test_names = new String[1];

    test_names[0] = "test5";

    return test_names;
  }

  @Test
  public void test5() {
    PictureImpl p = new PictureImpl(2, 2);

    p.setPixel(0, 0, new GrayPixel(0.1));
    p.setPixel(0, 1, new GrayPixel(0.3));
    p.setPixel(1, 0, new GrayPixel(0.2));
    p.setPixel(1, 1, new GrayPixel(0.4));

    double[] test = { 0.1, 0.2, 0.3, 0.4 };

    Iterator<Pixel> zig = p.zigzag();
    int counter = 0;
    boolean passed = true;
    while (zig.hasNext()) {
      if (test[counter] != zig.next().getIntensity()) {
        passed = false;
      }
      counter++;
    }
    assertTrue(passed);
  }
}

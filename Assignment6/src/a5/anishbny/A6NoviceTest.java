package a5.anishbny;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6novice.GrayPixel;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

  static public String[] getTestNames() {
    String[] test_names = new String[1];

    test_names[0] = "test1";

    return test_names;
  }

  @Test
  public void test1() {
    PictureImpl p = new PictureImpl(10, 10);
    double[] test = new double[100];
    int counter = 0;
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        double rand = Math.random();
        test[counter] = rand;
        p.setPixel(j, i, new GrayPixel(rand));
        counter++;
      }
    }

    counter = 0;
    boolean passed = true;
    Iterator<Pixel> pic_iter = p.iterator();
    while (pic_iter.hasNext()) {
      if (test[counter] != pic_iter.next().getIntensity()) {
        passed = false;
      }
      counter++;
    }
    assertTrue(passed);
  }
}

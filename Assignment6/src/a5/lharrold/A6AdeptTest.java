package a5.lharrold;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import a6adept.Coordinate;
import a6adept.GrayPixel;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

  static public String[] getTestNames() {
    String[] test_names = new String[1];

    test_names[0] = "testSampleIterator";

    return test_names;
  }

  @Test
  public void testSampleIterator() {
    PictureImpl pic = new PictureImpl(10, 10);

    List<Coordinate> array = new ArrayList<Coordinate>();
    array.add(new Coordinate(1, 2));
    array.add(new Coordinate(3, 2));
    array.add(new Coordinate(5, 2));
    array.add(new Coordinate(7, 2));
    array.add(new Coordinate(9, 2));
    array.add(new Coordinate(1, 7));
    array.add(new Coordinate(3, 7));
    array.add(new Coordinate(5, 7));
    array.add(new Coordinate(7, 7));
    array.add(new Coordinate(9, 7));

    GrayPixel a = new GrayPixel(1.0);
    pic.setPixel(array.get(0), a);
    GrayPixel b = new GrayPixel(1.0);
    pic.setPixel(array.get(1), b);
    GrayPixel c = new GrayPixel(1.0);
    pic.setPixel(array.get(2), c);
    GrayPixel d = new GrayPixel(1.0);
    pic.setPixel(array.get(3), d);
    GrayPixel e = new GrayPixel(1.0);
    pic.setPixel(array.get(4), e);
    GrayPixel f = new GrayPixel(1.0);
    pic.setPixel(array.get(5), f);
    GrayPixel g = new GrayPixel(1.0);
    pic.setPixel(array.get(6), g);
    GrayPixel h = new GrayPixel(1.0);
    pic.setPixel(array.get(7), h);
    GrayPixel i = new GrayPixel(1.0);
    pic.setPixel(array.get(8), i);

    Iterator<Pixel> sample_iter = pic.sample(1, 2, 2, 5);

    assertEquals(a, sample_iter.next());
    assertEquals(b, sample_iter.next());
    assertEquals(c, sample_iter.next());
    assertEquals(d, sample_iter.next());
    assertEquals(e, sample_iter.next());
    assertEquals(f, sample_iter.next());
    assertEquals(g, sample_iter.next());
    assertEquals(h, sample_iter.next());
    assertEquals(i, sample_iter.next());

  }

}

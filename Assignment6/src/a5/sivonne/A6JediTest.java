package a5.sivonne;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.ColorPixel;
import a6jedi.Coordinate;
import a6jedi.GrayPixel;
import a6jedi.Picture;
import a6jedi.PictureImpl;
import a6jedi.Pixel;

public class A6JediTest {
  private static final Pixel RED   = new ColorPixel(1, 0, 0);
  private static final Pixel GREEN = new ColorPixel(0, 1, 0);
  private static final Pixel BLUE  = new ColorPixel(0, 0, 1);
  private static final Pixel WHITE = new GrayPixel(1);

  static public String[] getTestNames() {
    String[] test_names = new String[1];

    test_names[0] = "ZigzagTest";

    return test_names;
  }

  @Test
  public void ZigzagTest() {
    Picture z = new PictureImpl(8, 8);

    Iterator<Pixel> zigzag = z.zigzag();
    Coordinate c0 = new Coordinate(0, 0);
    Coordinate c1 = new Coordinate(1, 0);
    Coordinate c2 = new Coordinate(0, 1);
    Coordinate c3 = new Coordinate(0, 2);

    z.setPixel(c0, RED);
    z.setPixel(c1, BLUE);
    z.setPixel(c2, WHITE);
    z.setPixel(c3, GREEN);

    assertTrue("Pixel value incorrect", zigzag.next().equals(z.getPixel(0, 0)));
    assertTrue("Pixel value incorrect", zigzag.next().equals(z.getPixel(1, 0)));
    assertTrue("Pixel value incorrect", zigzag.next().equals(z.getPixel(0, 1)));
    assertTrue("Pixel value incorrect", zigzag.next().equals(z.getPixel(0, 2)));
    assertTrue("Pixel value incorrect", zigzag.next().equals(z.getPixel(2, 0)));
    assertTrue("Pixel value incorrect", zigzag.next().equals(z.getPixel(3, 0)));

  }

}

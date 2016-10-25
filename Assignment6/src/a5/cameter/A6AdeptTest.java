package a5.cameter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import a6adept.Coordinate;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

  static public String[] getTestNames() {
    String[] test_names = new String[5];

    test_names[0] = "coordinateGetterTest";
    test_names[1] = "coordinateSetterTest";
    test_names[2] = "coordinateGetXTest";
    test_names[3] = "coordinateGetYTest";
    test_names[4] = "extractTest";

    return test_names;
  }

  @Test
  public void coordinateGetterTest() {
    Coordinate c = new Coordinate(1, 2);
    Picture p = new PictureImpl(3, 3);
    Pixel pix = new GrayPixel(.7);
    p.setPixel(1, 2, pix);
    assertTrue(p.getPixel(c).getIntensity() == .7);
  }

  @Test
  public void coordinateSetterTest() {
    Coordinate c = new Coordinate(1, 2);
    Picture p = new PictureImpl(3, 3);
    Pixel pix = new GrayPixel(.7);
    p.setPixel(c, pix);
    assertTrue(p.getPixel(1, 2).getIntensity() == .7);
  }

  @Test
  public void coordinateGetXTest() {
    Coordinate c = new Coordinate(1, 2);
    assertTrue(c.getX() == 1);
  }

  @Test
  public void coordinateGetYTest() {
    Coordinate c = new Coordinate(1, 2);
    assertTrue(c.getY() == 2);
  }

  @Test
  public void extractTest() {
    Picture p = new PictureImpl(3, 3);
    Pixel pix = new GrayPixel(.7);
    p.setPixel(1, 1, pix);
    Picture exP = p.extract(new Coordinate(1, 1), new Coordinate(2, 2));
    assertTrue(exP.getPixel(0, 0).getIntensity() == .7);
  }
}

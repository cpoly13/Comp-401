package a5.gogoyf;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.SubPicture;
import a6adept.SubPictureImpl;

public class A6AdeptTest {
  static public String[] getTestNames() {
    return new String[] { "sampleTest", "windowTest" };
  }

  // static public String[] getTestNames() {
  // String[] test_names = new String[1];

  // test_names[0] = "exampleTest";

  // return test_names;
  // }

  @Test
  public void exampleTest() {
    String[] test_names = new String[1];
    test_names[0] = "exampleTest";
    String expected = "exampleTest";
    assertEquals(test_names[0], expected);
  }

  @Test
  public void extractTest() {
    Coordinate a = new Coordinate(1, 1);
    Coordinate b = new Coordinate(6, 6);
    PictureImpl source = new PictureImpl(10, 10);
    SubPictureImpl p = (SubPictureImpl) source.extract(a, b);
    assertEquals(p.getWidth(), 6);

  }

  @Test
  public void setPixelTest() {
    ColorPixel p = new ColorPixel(0.4, 0.4, 0.4);
    Coordinate a = new Coordinate(2, 2);
    PictureImpl source = new PictureImpl(10, 10);
    source.setPixel(a, p);
    assertEquals(source.getPixel(a), p);
  }

  @Test
  public void sampleTest() {
    Picture p = new PictureImpl(7, 7);
    Iterator<a6adept.Pixel> i = p.sample(0, 0, 1, 1);
    int a = 0;
    while (i.hasNext()) {
      a++;
      i.next();
    }
    assertEquals(a, 49);

  }

  @Test
  public void windowTest() {
    Picture p = new PictureImpl(6, 6);
    Iterator<SubPicture> i = p.window(3, 3);
    int a = 0;
    while (i.hasNext()) {
      a++;
      i.next();
    }
    assertEquals(a, 16);

  }
}

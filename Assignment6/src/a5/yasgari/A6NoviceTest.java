package a5.yasgari;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

  static public String[] getTestNames() {
    String[] test_names = new String[3];

    test_names[0] = "testCoordinateConstructor";
    test_names[1] = "testSubPicExtract";
    test_names[2] = "testIterator";

    return test_names;
  }

  private static final Pixel RED   = new ColorPixel(1, 0, 0);
  private static final Pixel GREEN = new ColorPixel(0, 1, 0);
  private static final Pixel WHITE = new GrayPixel(1);

  // Testing whether the Coordinate constructor will both get and set a Pixel at
  // a given coordinate.

  @Test
  public void testCoordinateConstructor() {
    Picture picture = new PictureImpl(5, 5);
    Coordinate c = new Coordinate(1, 2);
    picture.setPixel(c, RED);
    assertEquals(RED, picture.getPixel(c));
  }

  // Testing whether the extract method will correctly extract a subpicture from
  // a picture given two coordinates representing the opposing corners of the
  // subpicture.

  @Test
  public void testSubPicExtract() {
    Picture picture = new PictureImpl(5, 5);
    picture.setPixel(2, 2, RED);
    picture.setPixel(3, 2, GREEN);
    Coordinate topLeft = new Coordinate(1, 1);
    Coordinate bottomRight = new Coordinate(3, 3);
    SubPicture sub = picture.extract(topLeft, bottomRight);
    assertEquals("Expected pixel does not match output", picture.getPixel(2, 2),
        sub.getPixel(topLeft));
    assertEquals("Expected pixel does not match output", picture.getPixel(3, 2),
        sub.getPixel(2, 1));
  }

  // Testing to ensure that the iterator iterates through each pixel in the
  // picture in row major order.
  @Test
  public void testIterator() {
    Picture picture = new PictureImpl(2, 2);
    picture.setPixel(0, 0, WHITE);
    picture.setPixel(1, 0, GREEN);
    picture.setPixel(0, 1, RED);
    picture.setPixel(1, 1, GREEN);
    Iterator<Pixel> iterator = picture.iterator();

    while (iterator.hasNext()) {

      assertTrue(iterator.next().equals(WHITE));
      assertTrue(iterator.next().equals(GREEN));
      assertTrue(iterator.next().equals(RED));
      assertTrue(iterator.next().equals(GREEN));
    }
  }

}
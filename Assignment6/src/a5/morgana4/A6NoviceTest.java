package a5.morgana4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;

public class A6NoviceTest {

  static public String[] getTestNames() {
    String[] test_names = new String[4];

    test_names[0] = "exampleTest";
    test_names[1] = "testSetPixel";
    test_names[2] = "testGetPixel";
    test_names[3] = "testExtract";

    return test_names;
  }

  @Test
  public void exampleTest() {}

  @Test
  public void testSetPixel() {
    Picture testPicture = new PictureImpl(3, 3);
    Coordinate c = new Coordinate(1, 1);
    ColorPixel p = new ColorPixel(.3, .2, .1);
    testPicture.setPixel(c, p);

    assertEquals("Pixel does not set", testPicture.getPixel(1, 1), p);
  }

  @Test
  public void testGetPixel() {
    Picture testPicture = new PictureImpl(3, 3);
    Coordinate c = new Coordinate(1, 1);
    ColorPixel p = new ColorPixel(.3, .2, .1);
    testPicture.setPixel(c, p);

    assertEquals("Pixel does not set", testPicture.getPixel(c), p);
  }

  @Test
  public void testExtract() {
    Picture testPicture = new PictureImpl(10, 10);
    Coordinate topLeft = new Coordinate(1, 1);
    Coordinate bottomRight = new Coordinate(9, 9);

    testPicture.setPixel(topLeft, new ColorPixel(.1, .2, .3));
    testPicture.setPixel(bottomRight, new ColorPixel(.3, .2, .1));

    Picture testSub = testPicture.extract(topLeft, bottomRight);
    assertEquals("extract fucked", testPicture.getPixel(topLeft), testSub.getPixel(0, 0));
    assertEquals("extract fucked", testPicture.getPixel(bottomRight),
        testSub.getPixel(testSub.getWidth() - 1, testSub.getHeight() - 1));

  }
}

package a5.joplever;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;

public class A6NoviceTest {

  static public String[] getTestNames() {
    String[] test_names = new String[3];

    test_names[0] = "jUnitTest1";
    test_names[1] = "jUnitTest2";
    test_names[2] = "jUnitTest3";

    return test_names;
  }

  @Test
  public void jUnitTest1() {
    Coordinate TestCoordinate = new Coordinate(15, 10);

    assertEquals("Coordinate's x incorrect", 15, TestCoordinate.getX());
    assertEquals("Coordinate's y incorrect", 10, TestCoordinate.getY());

  }

  @Test
  public void jUnitTest2() {
    Picture testPicture = new PictureImpl(20, 20);
    Coordinate testCoordinate = new Coordinate(15, 10);
    Pixel testPixel = new GrayPixel(0);

    assertEquals("That's the wrong pixel fool!", testPicture.getPixel(15, 10),
        testPicture.getPixel(testCoordinate));

    testPicture.setPixel(testCoordinate, testPixel);

    assertEquals("Mr. T says you set the wrong pixel", testPixel,
        testPicture.getPixel(testCoordinate));

  }

  @Test
  public void jUnitTest3() {
    Picture testPicture = new PictureImpl(5, 5);
    Pixel green = new ColorPixel(0, 1, 0);
    Coordinate testCoordinate = new Coordinate(4, 4);
    testPicture.setPixel(testCoordinate, green);
    Coordinate testCoordinate2 = new Coordinate(1, 0);
    Coordinate testCoordinate3 = new Coordinate(3, 4);
    SubPicture testSubPicture = new SubPictureImpl(testPicture, 1, 0, 4, 5);
    SubPicture testExtractPicture = testPicture.extract(testCoordinate2, testCoordinate);
    assertEquals(testSubPicture.getPixel(testCoordinate3),
        testExtractPicture.getPixel(testCoordinate3));
  }
}

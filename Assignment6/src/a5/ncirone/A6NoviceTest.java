package a5.ncirone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

  static public String[] getTestNames() {
    String[] test_names = new String[5];

    test_names[0] = "testGetX";
    test_names[1] = "testGetY";
    test_names[2] = "testExtractOverload";
    test_names[3] = "testGetPixel";
    test_names[4] = "testRowMajorIterHasNext";

    return test_names;
  }

  // tests Coordinate's getX() method

  @Test
  public void testGetX() {
    Coordinate test = new Coordinate(2, 2);
    int result = test.getX();
    assertEquals(2, result);

    Coordinate test2 = new Coordinate(4, 5);
    int result2 = test2.getX();
    assertEquals(4, result2);
  }

  // tests Coordinates getY() method

  @Test
  public void testGetY() {
    Coordinate test = new Coordinate(2, 4);
    int result = test.getY();
    assertEquals(4, result);

    Coordinate test2 = new Coordinate(4, 5);
    int result2 = test2.getY();
    assertEquals(5, result2);
  }

  @Test
  public void testExtractOverload() {
    Picture source = new PictureImpl(10, 10);
    Coordinate corner_a = new Coordinate(2, 2);
    Coordinate corner_b = new Coordinate(6, 6);
    SubPicture extractOriginal = source.extract(2, 2, 4, 4);
    SubPicture extractOverride = source.extract(corner_a, corner_b);
    int originalXOffset = extractOriginal.getXOffset();
    int originalYOffset = extractOriginal.getYOffset();
    int overrideXOffset = extractOverride.getXOffset();
    int overrideYOffset = extractOverride.getYOffset();
    assertEquals(originalXOffset, overrideXOffset);
    assertEquals(originalYOffset, overrideYOffset);
  }

  @Test
  public void testGetPixel() {
    Pixel newPixel = new ColorPixel(.7, .8, .9);
    Coordinate test = new Coordinate(7, 7);
    Picture testPicture = new PictureImpl(10, 10);
    testPicture.setPixel(7, 7, newPixel);
    Pixel result = testPicture.getPixel(test);
    assertEquals(result, newPixel);
  }

  @Test
  public void testRowMajorIterHasNext() {
    Picture p1 = new PictureImpl(10, 10);
    Iterator<Pixel> iter1 = p1.iterator();
    iter1.next();
    assertTrue(iter1.hasNext());

    Picture p2 = new PictureImpl(1, 1);
    Iterator<Pixel> iter2 = p2.iterator();
    iter2.next();
    assertFalse(iter2.hasNext());
  }

}

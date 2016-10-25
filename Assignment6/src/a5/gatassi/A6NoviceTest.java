package a5.gatassi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.SubPicture;
import a6novice.SubPictureImpl;

public class A6NoviceTest {
  Picture    p  = new PictureImpl(4, 4);
  SubPicture p2 = new SubPictureImpl(p, 0, 0, 2, 2);

  static public String[] getTestNames() {
    String[] test_names = new String[3];

    test_names[0] = "coordinateTestX";
    test_names[1] = "extract_Test";
    test_names[2] = "coordinateTestY";
    return test_names;
  }

  @Test
  public void coordinateTestX() {
    try {
      Coordinate c1 = new Coordinate(-1, 5);
    } catch (IllegalArgumentException e) {
      fail("X coordinate cannot be negative");
    }
  }

  @Test
  public void extract_Test() {
    Coordinate a = new Coordinate(0, 0);
    Coordinate b = new Coordinate(p2.getWidth() - 1, p2.getHeight() - 1);
    SubPicture p3 = p2.extract(a, b);
    assertEquals(p2.getPixel(0, 0).getIntensity(), p3.getPixel(0, 0).getIntensity(),
        .0001);

  }

  @Test
  public void coordinateTestY() {
    try {
      Coordinate c2 = new Coordinate(1, -5);
    } catch (IllegalArgumentException e) {
      fail("Y coordinate cannot be negative");
    }
  }
}

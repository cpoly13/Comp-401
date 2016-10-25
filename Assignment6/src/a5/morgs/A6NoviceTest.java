package a5.morgs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {
  // extend a4 test?
  Picture pc = new PictureImpl(5, 5);

  static public String[] getTestNames() {
    String[] test_names = new String[5];

    test_names[0] = "exampleTest";
    test_names[1] = "getXY";
    test_names[2] = "set";
    test_names[3] = "extract";
    test_names[4] = "iteration";

    return test_names;
  }

  // try catch if expecting an error to be thrown
  // assert equals to show method runs correctly

  @Test
  public void getXY() {
    Coordinate ncor = new Coordinate(2, 7);
    assertEquals(ncor.getX(), 2);
    assertEquals(ncor.getY(), 7);
  }

  @Test
  public void set() {
    ColorPixel cpix = new ColorPixel(.8, .2, .6);
    Coordinate cor = new Coordinate(2, 3);
    pc.setPixel(cor, cpix);
    assertEquals(pc.getPixel(cor), cpix);
  }

  @Test
  public void extract() {
    Coordinate tnew = new Coordinate(1, 1);
    Coordinate bnew = new Coordinate(3, 3);
    Coordinate subnew = new Coordinate(0, 0);
    SubPicture snew = pc.extract(tnew, bnew);
    assertEquals(snew.getPixel(subnew), pc.getPixel(tnew));
  }

  @Test
  public void iteration() {
    Picture small = new PictureImpl(1, 2);
    java.util.Iterator<Pixel> iter = small.iterator();
    Pixel first = iter.next();
    if (!iter.hasNext()) {
      fail("This picture still has a value that was not recognized");
    }
    first = iter.next();
    if (first == null) {
      fail("This picture still has a value that was not recognized");
    }
    assertFalse(iter.hasNext());

  }

}

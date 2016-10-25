package a5.connjin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;

public class A6NoviceTest {

  private static final Pixel RED   = new ColorPixel(1, 0, 0);
  private static final Pixel GREEN = new ColorPixel(0, 1, 0);
  private static final Pixel BLUE  = new ColorPixel(0, 0, 1);

  static public String[] getTestNames() {
    String[] test_names = new String[3];

    test_names[0] = "getPixelTest";
    test_names[1] = "setPixelTest";
    test_names[2] = "iteratorTest";

    return test_names;
  }

  @Test
  public void getPixelTest() {
    Coordinate x = new Coordinate(1, 2);
    Picture p = new PictureImpl(2, 5);
    assertEquals("Pixel retrieved does not match expected", p.getPixel(1, 2),
        p.getPixel(x));
  }

  @Test
  public void setPixelTest() {
    Coordinate c = new Coordinate(1, 2);
    Pixel pix = new ColorPixel(1.0, 1.0, 1.0);
    Picture p = new PictureImpl(2, 5);
    p.setPixel(c, pix);
    assertEquals("Pixel doot", pix, p.getPixel(c));
  }

  @Test
  public void iteratorTest() throws Exception {
    Picture p = new PictureImpl(3, 3);
    p.setPixel(0, 0, RED);
    p.setPixel(1, 0, RED);
    p.setPixel(2, 0, RED);
    p.setPixel(0, 1, GREEN);
    p.setPixel(1, 1, GREEN);
    p.setPixel(2, 1, GREEN);
    p.setPixel(0, 2, BLUE);
    p.setPixel(1, 2, BLUE);
    p.setPixel(2, 2, BLUE);
    Iterator<Pixel> iter = p.iterator();

    assertEquals("Not next", true, iter.hasNext());
    assertEquals("Not next", RED, iter.next());
    assertEquals("Not next", true, iter.hasNext());
    assertEquals("Not next", RED, iter.next());
    assertEquals("Not next", true, iter.hasNext());
    assertEquals("Not next", RED, iter.next());
    assertEquals("Not next", true, iter.hasNext());
    assertEquals("Not next", GREEN, iter.next());
    assertEquals("Not next", true, iter.hasNext());
    assertEquals("Not next", GREEN, iter.next());
    assertEquals("Not next", true, iter.hasNext());
    assertEquals("Not next", GREEN, iter.next());
    assertEquals("Not next", true, iter.hasNext());
    assertEquals("Not next", BLUE, iter.next());
    assertEquals("Not next", true, iter.hasNext());
    assertEquals("Not next", BLUE, iter.next());
    assertEquals("Not next", true, iter.hasNext());
    assertEquals("Not next", BLUE, iter.next());
    assertEquals("Not next", false, iter.hasNext());
    try {
      iter.next();
      fail();
    } catch (NoSuchElementException e) {
      assertEquals("No more pixels", e.getMessage());
    }
  }

}

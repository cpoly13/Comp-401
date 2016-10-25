package a5.yasgari;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.GrayPixel;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;

public class A6AdeptTest {

  static public String[] getTestNames() {
    String[] test_names = new String[3];

    test_names[0] = "testSampleIter";
    test_names[1] = "testWindow";
    test_names[2] = "testTile";

    return test_names;
  }

  private static final Pixel RED   = new ColorPixel(1, 0, 0);
  private static final Pixel GREEN = new ColorPixel(0, 1, 0);
  private static final Pixel BLUE  = new ColorPixel(0, 0, 1);
  private static final Pixel WHITE = new GrayPixel(1);

  // Tests that the sample method correctly iterates through a picture given an
  // initial x and y value and goes through the picture left to right every dx
  // pixels and dy rows.
  @Test
  public void testSampleIter() {
    Picture p = new PictureImpl(15, 10);
    p.setPixel(2, 3, RED);
    p.setPixel(5, 3, GREEN);
    p.setPixel(8, 3, BLUE);
    p.setPixel(11, 3, WHITE);
    p.setPixel(14, 3, GREEN);
    p.setPixel(2, 7, RED);
    p.setPixel(5, 7, GREEN);
    p.setPixel(8, 7, BLUE);
    p.setPixel(11, 7, WHITE);
    p.setPixel(14, 7, GREEN);

    Iterator<Pixel> sampleIter = p.sample(2, 3, 3, 4);
    while (sampleIter.hasNext()) {
      assertTrue(sampleIter.next().equals(RED));
      assertTrue(sampleIter.next().equals(GREEN));
      assertTrue(sampleIter.next().equals(BLUE));
      assertTrue(sampleIter.next().equals(WHITE));
      assertTrue(sampleIter.next().equals(GREEN));
      assertTrue(sampleIter.next().equals(RED));
      assertTrue(sampleIter.next().equals(GREEN));
      assertTrue(sampleIter.next().equals(BLUE));
      assertTrue(sampleIter.next().equals(WHITE));
      assertTrue(sampleIter.next().equals(GREEN));
    }

  }

  // Tests that the window method correctly outputs SubPicture objects given a
  // window width and height across the picture starting from the upper left
  // corner and proceeding from left to right and top to bottom until the window
  // hits the lower right corner.

  @Test
  public void testWindow() {
    Picture p = new PictureImpl(5, 5);
    Iterator<SubPicture> windowIter = p.window(3, 2);
    Coordinate c = new Coordinate(1, 1);

    while (windowIter.hasNext()) {
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(0, 0, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(1, 0, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(2, 0, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(0, 1, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(1, 1, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(2, 1, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(0, 2, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(1, 2, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(2, 2, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(0, 3, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(1, 3, 3, 2).getPixel(c)));
      assertTrue(windowIter.next().getPixel(c).equals(p.extract(2, 3, 3, 2).getPixel(c)));
    }
  }

  // The tile method should produce a sequence of SubPicture objects as if you
  // had cut the original picture into tiles that were tile_width wide and
  // tile_height tall.

  @Test
  public void testTile() {
    Picture p = new PictureImpl(5, 5);
    Iterator<SubPicture> tileIter = p.tile(2, 2);
    Coordinate c = new Coordinate(1, 1);
    while (tileIter.hasNext()) {
      assertTrue(tileIter.next().getPixel(c).equals(p.extract(0, 0, 2, 2).getPixel(c)));
      assertTrue(tileIter.next().getPixel(c).equals(p.extract(2, 0, 2, 2).getPixel(c)));
      assertTrue(tileIter.next().getPixel(c).equals(p.extract(0, 2, 2, 2).getPixel(c)));
      assertTrue(tileIter.next().getPixel(c).equals(p.extract(2, 2, 2, 2).getPixel(c)));
    }
  }
}

package a5.annanna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import a6novice.ColorPixel;
import a6novice.Coordinate;
import a6novice.GrayPixel;
import a6novice.Picture;
import a6novice.PictureImpl;
import a6novice.Pixel;
import a6novice.SubPicture;

public class A6NoviceTest {

  private static final Pixel RED   = new ColorPixel(1, 0, 0);
  private static final Pixel GREEN = new ColorPixel(0, 1, 0);
  private static final Pixel BLUE  = new ColorPixel(0, 0, 1);
  private static final Pixel WHITE = new GrayPixel(1);
  private static final Pixel BLACK = new GrayPixel(0);

  static public String[] getTestNames() {
    String[] test_names = new String[6];

    test_names[0] = "exampleTest";
    test_names[1] = "getAndSetPixelTestWithCoordinates";
    test_names[2] = "iteratorHasNextTest";
    test_names[3] = "iteratorOrderTest";
    test_names[4] = "iteratorsForBothPictureAndSubpicture";
    test_names[5] = "extractTestWithCoords";

    return test_names;
  }

  @Test
  public void exampleTest() {}

  @Test
  public void getAndSetPixelTestWithCoordinates() {
    /*
     * This test makes sure that the new getter and setter methods work with a
     * coordinate in the parameters.
     */
    Picture p = new PictureImpl(3, 3);
    Coordinate c = new Coordinate(0, 1);
    p.setPixel(0, 0, RED);
    p.setPixel(1, 0, RED);
    p.setPixel(2, 0, RED);
    p.setPixel(0, 1, GREEN);
    p.setPixel(1, 1, BLUE);
    p.setPixel(2, 1, WHITE);
    p.setPixel(0, 2, BLACK);
    p.setPixel(1, 2, BLACK);
    p.setPixel(2, 2, RED);
    p.setPixel(c, RED);
    Coordinate d = new Coordinate(2, 1);
    p.setPixel(d, BLUE);
    Coordinate e = new Coordinate(1, 2);
    p.setPixel(e, WHITE);

    assertEquals("Pixel retrieved after setting does not match expected value", RED,
        p.getPixel(0, 1));
    // RED is expected
    assertEquals("Pixel retrieved after setting does not match expected value", BLUE,
        p.getPixel(2, 1));
    assertEquals("Pixel retrieved after setting doesn't match expected value", WHITE,
        p.getPixel(1, 2));
  }

  @Test
  public void iteratorHasNextTest() {
    /*
     * This test makes sure that the iterator's hasNext() method is working
     * properly. Also tests the NoSuchElementException.
     */
    PictureImpl q = new PictureImpl(2, 2);
    q.setPixel(0, 0, RED);
    q.setPixel(1, 0, RED);
    q.setPixel(0, 1, GREEN);
    q.setPixel(1, 1, BLUE);
    Iterator<Pixel> myIterator = q.iterator(); // This makes a new iterator
    assertEquals("The picture is supposed to have a next element", true,
        myIterator.hasNext());
    myIterator.next();
    myIterator.next();
    myIterator.next();
    myIterator.next();
    assertEquals("The picture isn't supposed to have a next element", false,
        myIterator.hasNext());

    try {
      myIterator.next();
      fail("Expected NoSuchElementException");
    } catch (NoSuchElementException e) {

    } catch (RuntimeException e) {
      fail("Expected NoSuchElementException but got generic RuntimeException");
    }

  }

  @Test
  public void iteratorOrderTest() {
    // This test makes sure that the iterator runs in row major order.
    /*
     * If the iterator ran in column major order instead, then the second and
     * third tests would fail.
     */
    PictureImpl q = new PictureImpl(2, 2);
    q.setPixel(0, 0, RED);
    q.setPixel(1, 0, RED);
    q.setPixel(0, 1, GREEN);
    q.setPixel(1, 1, BLUE);

    Iterator<Pixel> myIterator = q.iterator(); // This makes a new iterator
    assertEquals("The pixels should match", myIterator.next(), q.getPixel(0, 0));
    assertEquals("The pixels should match", myIterator.next(), q.getPixel(1, 0));
    assertEquals("The pixels should match", myIterator.next(), q.getPixel(0, 1));
    assertEquals("The pixels should match", myIterator.next(), q.getPixel(1, 1));
  }

  @Test
  public void iteratorsForBothPictureAndSubpicture() {
    /*
     * This test calls the iterator() method on a Picture p, creating a
     * pictureIterator object. It also extracts a new SubPicture from p and
     * calls the iterator() method on it, creating a subPicIterator object. It
     * then goes through both iterators to make sure that the Pixels overlap
     * correctly.
     */
    Picture p = new PictureImpl(3, 3);
    p.setPixel(0, 0, RED);
    p.setPixel(1, 0, RED);
    p.setPixel(2, 0, RED);
    p.setPixel(0, 1, GREEN);
    p.setPixel(1, 1, BLUE);
    p.setPixel(2, 1, WHITE);
    p.setPixel(0, 2, BLACK);
    p.setPixel(1, 2, BLACK);
    p.setPixel(2, 2, RED);
    SubPicture q = p.extract(1, 1, 2, 2);
    Iterator<Pixel> pictureIterator = p.iterator();
    pictureIterator.next();
    pictureIterator.next();
    pictureIterator.next();
    pictureIterator.next();
    Iterator<Pixel> subPicIterator = q.iterator();
    assertEquals("The pixel at subpicture(0, 0) should match the pixel at picture(1, 1)",
        pictureIterator.next(), subPicIterator.next());
    assertEquals("The next pixel should be white", WHITE, pictureIterator.next());
    assertEquals("The next pixel should be white", WHITE, subPicIterator.next());
    assertEquals("The next subPicture pixel should be the pixel at picture(1, 2)",
        subPicIterator.next(), p.getPixel(1, 2));
    assertEquals("The next subPicture pixel should be the pixel at picture(2, 2)",
        subPicIterator.next(), p.getPixel(2, 2));
  }

  @Test
  public void extractTestWithCoords() {
    /*
     * This method acts similarly to the one above, but it uses coordinates as
     * parameters for the extract method.
     */
    Picture p = new PictureImpl(3, 3);
    p.setPixel(0, 0, RED);
    p.setPixel(1, 0, RED);
    p.setPixel(2, 0, RED);
    p.setPixel(0, 1, GREEN);
    p.setPixel(1, 1, BLUE);
    p.setPixel(2, 1, WHITE);
    p.setPixel(0, 2, BLACK);
    p.setPixel(1, 2, BLACK);
    p.setPixel(2, 2, RED);
    Coordinate a = new Coordinate(1, 2);
    Coordinate b = new Coordinate(2, 0);
    SubPicture mySubPic = p.extract(a, b);
    assertEquals("Pixels should match", mySubPic.getPixel(0, 0), p.getPixel(1, 0));
    assertEquals("Pixels should match", mySubPic.getPixel(1, 0), p.getPixel(2, 0));
    assertEquals("Pixels should match", mySubPic.getPixel(0, 1), p.getPixel(1, 1));
    assertEquals("Pixels should match", mySubPic.getPixel(1, 1), p.getPixel(2, 1));
    assertEquals("Pixels should match", mySubPic.getPixel(0, 2), p.getPixel(1, 2));
    assertEquals("Pixels should match", mySubPic.getPixel(1, 2), p.getPixel(2, 2));

  }

}

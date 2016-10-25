package a5.nwalters;

import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.SubPicture;

public class A6JediTest {

  static public String[] getTestNames() {
    String[] test_names = { "windowIteratorTest" };

    return test_names;
  }

  // Test if window_iterator throws exceptions when expected
  @Test
  public void windowIteratorTest() {
    Picture p = new PictureImpl(15, 10);
    Iterator<SubPicture> windowIter = p.window(3, 2);
    while (windowIter.hasNext()) {
      windowIter.next();
    }
    try {
      windowIter.next();
      fail("Expected java.util.NoSuchElementException");
    } catch (java.util.NoSuchElementException e) {
    }
  }
}

package a5.ncirone;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.SubPicture;

public class A6AdeptTest {

  static public String[] getTestNames() {
    String[] test_names = new String[1];

    test_names[0] = "testWindow";

    return test_names;
  }

  @Test
  public void testWindow() {
    Picture p = new PictureImpl(5, 5);
    Iterator<SubPicture> window_iter = p.window(3, 2);
    window_iter.next();
    window_iter.next();
    window_iter.next();
    assertEquals(1, window_iter.next().getYOffset());
  }
}

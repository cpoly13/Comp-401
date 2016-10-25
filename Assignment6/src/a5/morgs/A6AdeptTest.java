package a5.morgs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;
import a6adept.SubPicture;
import a6adept.SubPictureImpl;

public class A6AdeptTest {

  Picture pc = new PictureImpl(5, 5);

  static public String[] getTestNames() {
    String[] test_names = new String[3];

    test_names[0] = "exampleTest";
    test_names[1] = "sampleIterator";
    test_names[2] = "windowIterator";

    return test_names;
  }

  @Test
  public void exampleTest() {}

  @Test
  public void sampleIterator() {
    Iterator<Pixel> sampit = pc.sample(1, 2, 2, 3);

    Pixel first = sampit.next();
    if (!sampit.hasNext()) {
      fail("This picture still has a value that was not recognized");
    }
    first = sampit.next();
    if (first == null) {
      fail("This picture still has a value that was not recognized");
    }
    assertFalse(sampit.hasNext());

  }

  @Test
  public void windowIterator() {
    SubPicture spc = new SubPictureImpl(pc, 0, 0, 4, 4);
    Iterator<SubPicture> windit = spc.window(1, 1);
    SubPicture supposed = windit.next();
    ArrayList<SubPicture> ext = new ArrayList<SubPicture>();

    ext.add(0, spc.extract(0, 0, 1, 1));
    ext.add(1, spc.extract(1, 0, 1, 1));
    ext.add(2, spc.extract(0, 1, 1, 1));
    ext.add(3, spc.extract(1, 1, 1, 1));

    CompareSubPic(ext.iterator().next(), supposed);

  }

  public boolean CompareSubPic(SubPicture s, SubPicture p) {
    if (s.getWidth() != p.getWidth()) {
      fail("These subpictures' width are not equal");
    }
    if (s.getHeight() != p.getHeight()) {
      fail("These subpictures' height are not equal");
    }
    if (s.getXOffset() != p.getXOffset()) {
      fail("These subpictures' x offsets are not equal");
    }
    if (s.getYOffset() != p.getYOffset()) {
      fail("These subpictures' y offsets are not equal");
    }

    return true;
  }

}

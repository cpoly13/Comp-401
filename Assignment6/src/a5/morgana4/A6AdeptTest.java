package a5.morgana4;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import a6adept.ColorPixel;
import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.PictureImpl;
import a6adept.Pixel;

public class A6AdeptTest {

  static public String[] getTestNames() {
    String[] test_names = new String[3];

    test_names[0] = "exampleTest";
    test_names[1] = "testHasNext";
    test_names[2] = "testSample";

    return test_names;
  }

  @Test
  public void exampleTest() {}

  @Test
  public void testHasNext() {
    Picture testPicture = new PictureImpl(2, 2);
    Iterator<Pixel> sampleTester = testPicture.sample(0, 0, 1, 1);
    Coordinate[] ic = new Coordinate[9];

    ic[0] = new Coordinate(0, 0);
    ic[1] = new Coordinate(0, 1);
    ic[3] = new Coordinate(1, 0);
    ic[4] = new Coordinate(1, 1);

    assertEquals("hasNext wrong", sampleTester.hasNext(), true);
    sampleTester.next();
    assertEquals("hasNext wrong", sampleTester.hasNext(), true);
    sampleTester.next();
    assertEquals("hasNext wrong", sampleTester.hasNext(), true);
    sampleTester.next();
    assertEquals("hasNext wrong", sampleTester.hasNext(), true);
    sampleTester.next();
    assertEquals("hasNext wrong", sampleTester.hasNext(), false);
  }

  @Test
  public void testSample() {
    Picture testPicture = new PictureImpl(15, 10);
    Iterator<Pixel> sampleTester = testPicture.sample(2, 3, 3, 4);
    Coordinate[] ic = new Coordinate[10];

    ic[0] = new Coordinate(2, 3);
    ic[1] = new Coordinate(5, 3);
    ic[2] = new Coordinate(8, 3);
    ic[3] = new Coordinate(11, 3);
    ic[4] = new Coordinate(14, 3);
    ic[5] = new Coordinate(2, 7);
    ic[6] = new Coordinate(5, 7);
    ic[7] = new Coordinate(8, 7);
    ic[8] = new Coordinate(11, 7);
    ic[9] = new Coordinate(14, 7);

    testPicture.setPixel(ic[0], new ColorPixel(.1, .2, .3));
    testPicture.setPixel(ic[1], new ColorPixel(.2, .3, .4));
    testPicture.setPixel(ic[2], new ColorPixel(.3, .4, .5));
    testPicture.setPixel(ic[3], new ColorPixel(.4, .5, .6));
    testPicture.setPixel(ic[4], new ColorPixel(.5, .6, .7));
    testPicture.setPixel(ic[5], new ColorPixel(.6, .7, .8));
    testPicture.setPixel(ic[6], new ColorPixel(.7, .8, .9));
    testPicture.setPixel(ic[7], new ColorPixel(.8, .9, .0));
    testPicture.setPixel(ic[8], new ColorPixel(.9, .0, .1));
    testPicture.setPixel(ic[9], new ColorPixel(.0, .1, .2));

    Pixel a = sampleTester.next();
    Pixel b = sampleTester.next();
    Pixel c = sampleTester.next();
    Pixel d = sampleTester.next();
    Pixel e = sampleTester.next();
    Pixel f = sampleTester.next();
    Pixel g = sampleTester.next();
    Pixel h = sampleTester.next();
    Pixel i = sampleTester.next();
    Pixel j = sampleTester.next();

    assertEquals("sample broken af", a, testPicture.getPixel(ic[0]));
    assertEquals("sample broken af", b, testPicture.getPixel(ic[1]));
    assertEquals("sample broken af", c, testPicture.getPixel(ic[2]));
    assertEquals("sample broken af", d, testPicture.getPixel(ic[3]));
    assertEquals("sample broken af", e, testPicture.getPixel(ic[4]));
    assertEquals("sample broken af", f, testPicture.getPixel(ic[5]));
    assertEquals("sample broken af", g, testPicture.getPixel(ic[6]));
    assertEquals("sample broken af", h, testPicture.getPixel(ic[7]));
    assertEquals("sample broken af", i, testPicture.getPixel(ic[8]));
    assertEquals("sample broken af", j, testPicture.getPixel(ic[9]));
  }

}

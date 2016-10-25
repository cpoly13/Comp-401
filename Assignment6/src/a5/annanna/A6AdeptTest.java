package a5.annanna;

/*
 * import static org.junit.Assert.*; import java.util.Iterator; import
 * java.util.NoSuchElementException; import org.junit.Test; import a6adept.*;
 */

import org.junit.Test;

/*
 * In each of these classes is a static method called getTestNames(). This
 * method needs to return an array of strings that correspond to each JUnit test
 * in the class. The autograder will be relying on this method in order to test
 * your tests. You will see that it currently is written to return the name of
 * an example test method. The example test method is there as an example of the
 * correct way to declare a JUnit test within the class. In particular, you must
 * have the "@Test" annotation and the correct signature (i.e., public void).
 * You can remove this exampleTest if you want to. If you do, however, be sure
 * to remove its name from the array of test names returned by getTestNames().
 */

public class A6AdeptTest {

  static public String[] getTestNames() {
    String[] test_names = new String[1];

    test_names[0] = "exampleTest";

    return test_names;
  }

  @Test
  public void exampleTest() {}
}

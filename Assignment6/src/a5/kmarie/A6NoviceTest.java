package a5.kmarie;

import static org.junit.Assert.*;

import org.junit.Test;

import a6novice.*;

public class A6NoviceTest {

    static public String[] getTestNames() {
	String[] test_names = new String[1];

	test_names[0] = "constructorTest";

	return test_names;
    }

    @Test
    public void constructorTest() {
	Coordinate C = new Coordinate(3, 4);
	int x = C.getX();
	int y = C.getY();

	assertEquals(x, 3);
	assertEquals(y, 4);

    }
}

package a5.jonlh;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "zigzagTest";
		
		return test_names;
	}
		
	@Test
	public void zigzagTest() {
		Picture p = new PictureImpl(8,8);
		Iterator<Pixel> iter = p.zigzag();
		assertEquals(iter.next(), p.getPixel(0,0));
	}
}

package a5.zsofiav1;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		return new String[]{"testZigZag"};
	}
	/* testZigZag
	 * Tests Zig Zag iterator of a Picture that is 3 x 3;
	 * Whether it returns correct boolean hasNext() at the start and the end
	 * Tests if correct Pixels were returned when next() is called
	 */
	@Test
	public void testZigZag() {
		Picture p = new PictureImpl(3,3);
		Iterator<Pixel> iter = p.zigzag();
		assertEquals("hasNext() at start is false",
				true,iter.hasNext());
		assertEquals("Pixel recieved is not what expected",
				p.getPixel(0, 0),iter.next());
		assertEquals("Pixel recieved is not what expected",
				p.getPixel(0, 1),iter.next());
		assertEquals("Pixel recieved is not what expected",
				p.getPixel(1, 0),iter.next());
		assertEquals("Pixel recieved is not what expected",
				p.getPixel(2, 0),iter.next());
		assertEquals("Pixel recieved is not what expected",
				p.getPixel(1, 1),iter.next());
		assertEquals("Pixel recieved is not what expected",
				p.getPixel(0, 2),iter.next());
		assertEquals("Pixel recieved is not what expected",
				p.getPixel(1, 2),iter.next());
		assertEquals("Pixel recieved is not what expected",
				p.getPixel(2, 1),iter.next());
		assertEquals("Pixel recieved is not what expected",
				p.getPixel(2, 2),iter.next());
		assertEquals("hasNext() at end is true",
				false,iter.hasNext());
		
		
	}
}

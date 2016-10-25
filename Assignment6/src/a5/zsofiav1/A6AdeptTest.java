package a5.zsofiav1;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import a6adept.*;

public class A6AdeptTest {
	
	private static final Pixel RED = new ColorPixel(1,0,0);
	private static final Pixel GREEN = new ColorPixel(0,1,0);
	private static final Pixel BLUE = new ColorPixel(0,0,1);
	private static final Pixel WHITE = new GrayPixel(1);
		
	static public String[] getTestNames() {
		return new String[]{"testSample", "testTile", "testWindow"};
	}
	/* testSample
	 * Tests Sample iterator of a Picture;
	 * Whether it returns correct boolean hasNext() at the start and the end
	 * Tests if correct Pixels were returned when next() is called
	 * Tests 2 Pictures, 
	 * one 15 x 10 that has a dx and dy > 1
	 * The other calling sample(0,0,1,1), tests if same as iterator in Novice
	 */
	@Test
	public void testSample() {
		Picture p = new PictureImpl(15,10);
		Iterator<Pixel> sample_iter = p.sample(2, 3, 3, 4);
		assertEquals("hasNext() at start is false",
				true,sample_iter.hasNext());
		assertEquals("First pixel in iterator is not pixel (2,3)",
				p.getPixel(2,3),sample_iter.next());
		assertEquals("First pixel in iterator is not pixel (5,3)",
				p.getPixel(5,3),sample_iter.next());
		assertEquals("Second pixel in iterator is not pixel (8,3)",
				p.getPixel(8,3),sample_iter.next());
		assertEquals("Third pixel in iterator is not pixel (11,3)",
				p.getPixel(11,3),sample_iter.next());
		assertEquals("Fourth pixel in iterator is not pixel (14,3)",
				p.getPixel(14,3),sample_iter.next());
		assertEquals("Fifth pixel in iterator is not pixel (2,7)",
				p.getPixel(2,7),sample_iter.next());
		assertEquals("Sixth pixel in iterator is not pixel (5,7)",
				p.getPixel(5,7),sample_iter.next());
		assertEquals("Seventh pixel in iterator is not pixel (8,7)",
				p.getPixel(8,7),sample_iter.next());
		assertEquals("Eight pixel in iterator is not pixel (11,7)",
				p.getPixel(11,7),sample_iter.next());
		assertEquals("Ninth pixel in iterator is not pixel (14,7)",
				p.getPixel(14,7),sample_iter.next());
		assertEquals("hasNext() at end is true",
				false,sample_iter.hasNext());
		
		Picture p2 = new PictureImpl(2, 2);
		Coordinate a = new Coordinate(0,0);
		Coordinate b = new Coordinate(1,0);
		Coordinate c = new Coordinate(0,1);
		Coordinate d = new Coordinate(1,1);
		p2.setPixel(a, RED);
		p2.setPixel(b, BLUE);
		p2.setPixel(c, WHITE);
		p2.setPixel(d, GREEN);
		
		Iterator<Pixel> iter = p2.sample(0,0,1,1);
		assertEquals("hasNext() at start is false",
				true,iter.hasNext());
		assertEquals("0,0 is not red",
				RED,iter.next());
		assertEquals("0,1 is not white",
				BLUE,iter.next());
		assertEquals("1,0 is not blue",
				WHITE,iter.next());
		assertEquals("1,1 is not green",
				GREEN,iter.next());
		assertEquals("hasNext() at end is true",
				false,iter.hasNext());
	}
	/* testWindow
	 * Tests 5 x 5 picture with a window iterator with width of 3 and height of 2
	 * Whether it returns correct boolean hasNext() at the start and the end
	 * Tests if correct SubArea were returned when next() is called
	 */
	@Test
	public void testWindow() {
		Picture p = new PictureImpl(5,5);
		Iterator<SubPicture> window_iter = p.window(3, 2);
		assertEquals("hasNext() at start is false",
				true,window_iter.hasNext());
		assertTrue(" Subpicture retrieved is not Subpicture from (0,0) to (3,2)",
				compareSubPictures(p.extract(0, 0, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (1,0) to (4,2)",
				compareSubPictures(p.extract(1, 0, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (2,0) to (5,2)",
				compareSubPictures(p.extract(2, 0, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (0,1) to (3,3)",
				compareSubPictures(p.extract(0, 1, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (1,1) to (4,3)",
				compareSubPictures(p.extract(1, 1, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (2,1) to (5,3)",
				compareSubPictures(p.extract(2, 1, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (0,2) to (3,4)",
				compareSubPictures(p.extract(0, 2, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (1,2) to (4,4)",
				compareSubPictures(p.extract(1, 2, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (2,2) to (5,4)",
				compareSubPictures(p.extract(2, 2, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (0,3) to (3,5)",
				compareSubPictures(p.extract(0, 3, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (1,3) to (4,5)",
				compareSubPictures(p.extract(1, 3, 3, 2),window_iter.next()));
		assertTrue(" Subpicture retrieved is not Subpicture from (2,3) to (5,5)",
				compareSubPictures(p.extract(2, 3, 3, 2),window_iter.next()));
		assertEquals("hasNext() at end is true",
				false,window_iter.hasNext());
	}
	/* testTile
	 * Tests 5 x 5 picture with a tile iterator with width of 2 and height of 2
	 * Whether it returns correct boolean hasNext() at the start and the end
	 * Tests if correct SubArea were returned when next() is called
	 */
	@Test
	public void testTile() {
		Picture p = new PictureImpl(5,5);
		Iterator<SubPicture> tile_iter = p.tile(2, 2);
		assertEquals("hasNext() at start is false",
				true,tile_iter.hasNext());
		assertTrue("Subpicture retrieved is not Subpicture from (0,0) to (2,2)",
				compareSubPictures(p.extract(0, 0, 2, 2),tile_iter.next()));
		assertTrue("Subpicture retrieved is not Subpicture from (2,0) to (4,2)",
				compareSubPictures(p.extract(2, 0, 2, 2),tile_iter.next()));
		assertTrue("Subpicture retrieved is not Subpicture from (0,2) to (2,4)",
				compareSubPictures(p.extract(0, 2, 2, 2),tile_iter.next()));
		assertTrue("Subpicture retrieved is not Subpicture from (2,2) to (4,4)",
				compareSubPictures(p.extract(2, 2, 2, 2),tile_iter.next()));
		assertEquals("hasNext() at end is true",
				false,tile_iter.hasNext());
		
	}
	/* compareSubPictures
	 * Static Method that takes in 2 SubPictures
	 * returns true if their source, x and y offsets, 
	 * width, and height are identical
	 */
	public static boolean compareSubPictures( SubPicture a, SubPicture b){
		return a.getSource().equals(b.getSource()) && 
				(a.getHeight() == b.getHeight()) &&
				(a.getWidth() == b.getWidth()) &&
				(a.getXOffset() == b.getXOffset()) &&
				(a.getYOffset() == b.getYOffset());
	}
}

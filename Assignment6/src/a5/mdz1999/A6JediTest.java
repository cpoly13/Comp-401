package a5.mdz1999;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6jedi.*;

public class A6JediTest {
		
	static public String[] getTestNames() {
		String[] test_names = new String[1];
		
		test_names[0] = "pictureZigZagTest";
		
		return test_names;
	}
		
	@Test
	public void pictureZigZagTest() {
		PictureImpl p = new PictureImpl(2,2);
		Iterator<Pixel> zigzag_iter = p.zigzag();
		for(int i=0;i<4;i++){
			if(i==0){
				if(!zigzag_iter.next().equals(p.getPixel(0,0))){
					fail("Pixels do not match!");
				}
			}
			if(i==1){
				if(!zigzag_iter.next().equals(p.getPixel(1,0))){
					fail("Pixels do not match!");
				}
			}
			if(i==2){
				if(!zigzag_iter.next().equals(p.getPixel(0,1))){
					fail("Pixels do not match!");
				}
			}
			if(i==3){
				if(!zigzag_iter.next().equals(p.getPixel(1,1))){
					fail("Pixels do not match!");
				}
			}
		}
	}
}

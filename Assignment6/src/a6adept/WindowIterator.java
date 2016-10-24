package a6adept;
import java.util.Iterator;
import java.util.NoSuchElementException;
/*
 * Creates Window Iterator object that returns SubPictures
 *  from dragging a "window" over picture in horizontal top down order
 *  window placement increases by one index with each step
 *  Author: Chris Polychronides
 */
public class WindowIterator implements Iterator<SubPicture> {
	Picture pic;
	int window_width;
	int window_height;
	int x;
	int y;
	
	/*
	 * Constructor that sets fields to appropriate values
	 */
	public WindowIterator(Picture pic, int window_width, int window_height){
		this.pic=pic;
		this.window_width=window_width;
		this.window_height=window_height;
		x=-1; //starts at -1 so that first next() starts at beginning 0,0 index 
		y=0;
	}
	
	/*
	 * Checks if picture has next sub-picture to return
	 * using window width/height from current index
	 * Output: Boolean value whether potential sub-picture exists
	 */
	@Override
	public boolean hasNext() {
		if(x+window_width<pic.getWidth()){
			return true;
		}
		
		else if(y+window_height<pic.getHeight()){
			return true;
		}
		else{
		return false;
		}
	}
	/*
	 * Returns next"windowed" sub-picture after moving "window" area to next 
	 * appropriate index
	 * Output: SubPicture
	 */
	@Override
	public SubPicture next() {
		if(x<0){
			x++;
			SubPicture subPic= new SubPictureImpl(pic,x,y,window_width,window_height);
			return subPic;
		}
		else if(x+window_width<pic.getWidth()){
			x++;
			SubPicture subPic= new SubPictureImpl(pic,x,y,window_width,window_height);
			return subPic;
		}
		else if(y+window_height<pic.getHeight()){
			x=0;
			y++;
			SubPicture subPic= new SubPictureImpl(pic,x,y,window_width,window_height);
			return subPic;
		}
		
		else{
			throw new NoSuchElementException();
		}
	}
	
}

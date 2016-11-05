package a6adept;
import java.util.Iterator;
import java.util.NoSuchElementException;
/*
 * Creates Tile Iterator object that can return SubPictures
 *  from moving a "tile" over picture in horizontal top down subsequent order
 *  with no tile sub-pictures overlapping
 *  Author: Chris Polychronides
 */
public class TileIterator implements Iterator<SubPicture> {
	Picture pic;
	int tile_width;
	int tile_height;
	int x;
	int y;
	
	/*
	 * Constructor that sets fields to appropriate values
	 */
	public TileIterator(Picture pic, int tile_width, int tile_height){
		this.pic=pic;
		this.tile_width=tile_width;
		this.tile_height=tile_height;
		x=-1; // so first instance of next() starts at 0
		y=0;
	}
		
	/*
	 * Checks if picture has next sub-picture to return
	 * using tile width/height from current index
	 * Output: Boolean value whether potential sub-picture exists
	 */
	@Override
	public boolean hasNext() {
		if (x==-1){
			return true;
		}
		
		else if(x+2*tile_width<=pic.getWidth()){
			return true;
		}
		else if(y+2*tile_height<=pic.getHeight()){
			return true;
		}
		
		else{
		return false;
		}
	}
	/*
	 * Returns next"tiled" sub-picture after moving "tile" area to next 
	 * appropriate index
	 * Output: SubPicture
	 */
	@Override
	public SubPicture next() {
		if(x<0){
			x++;
			SubPicture subPic= new SubPictureImpl(pic,x,y,tile_width,tile_height);
			return subPic;
		}
		else if(x+2*tile_width<=pic.getWidth()){
			x+=tile_width;
			SubPicture subPic= new SubPictureImpl(pic,x,y,tile_width,tile_height);
			return subPic;
		}
		else if(y+2*tile_height<=pic.getHeight()){
			x=0;
			y+=tile_height;
			SubPicture subPic= new SubPictureImpl(pic,x,y,tile_width,tile_height);
			return subPic;
		}
		else{
			throw new NoSuchElementException();
		}
	}

}

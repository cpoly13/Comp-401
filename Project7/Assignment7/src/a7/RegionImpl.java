package a7;
/*
 * Region Interface Implementation
 * Takes a picture and returns various regions determined by Coordinates
 */
public class RegionImpl implements Region {
	private Coordinate a;
	private Coordinate b;
	
	/*
	 * Takes in and sets coordinates that define region
	 */
	public RegionImpl(Coordinate a, Coordinate b){
		if(a==null || b==null){
			throw new IllegalArgumentException("Error, one or more of the coordinates are null");
		}
		
		this.a=a;
		this.b=b;
	}
	
	@Override
	public Coordinate getUpperLeft() {
		
		int x;
		int y;
		if(a.getX()<=b.getX()){
			x=a.getX();
		}
		else{
			x=b.getX();
		}
		
		if(a.getY()<=b.getY()){
			y=a.getY();
		}
		else{
			y=b.getY();
		}
		
		return new Coordinate(x,y);
	}

	@Override
	public Coordinate getLowerRight() {
		
		int x;
		int y;
		if(a.getX()>=b.getX()){
			x=a.getX();
		}
		else{
			x=b.getX();
		}
		
		if(a.getY()>=b.getY()){
			y=a.getY();
		}
		else{
			y=b.getY();
		}
		
		return new Coordinate(x,y);
	}

	@Override
	public int getTop() {
		
		if(a.getY()<=b.getY()){
			return a.getY();
		}
		else{
			return b.getY();
		}
	}

	@Override
	public int getBottom() {
		
		if(a.getY()>=b.getY()){
			return a.getY();
		}
		else{
			return b.getY();
		}
		
	}

	@Override
	public int getLeft() {
		
		if(a.getX()<=b.getX()){
			return a.getX();
		}
		
		else{
			return b.getX();
		}
	}

	@Override
	public int getRight() {
		
		if(a.getX()>=b.getX()){
			return a.getX();
		}
		
		else{
			return b.getX();
		}
		
	}
	
	/*
	 * Gives enclosed intersection of this region and other region
	 * Input: Other region
	 * Output: Enclosed region
	 * returns NoIntersectionExceprion if other region does not intersect or is null
	 */
	@Override
	public Region intersect(Region other) throws NoIntersectionException {
		
		if (other==null){
			throw new NoIntersectionException();
		}
		if(this.getLeft()>other.getRight()|| this.getRight()<other.getLeft()
				|| this.getBottom()<other.getTop() || other.getBottom()<this.getTop()){
			throw new NoIntersectionException();
		}
		
		//this lower left region and other upper right region scenario
		if(this.getLeft()<=other.getLeft() && this.getTop()<=other.getTop()){
			
			return new RegionImpl(other.getUpperLeft(), this.getLowerRight());
		}
		
		//other lower left region and this upper right region scenario
		else if(other.getLeft()<=this.getLeft() && other.getTop()<=this.getTop()){
			
			return new RegionImpl(this.getUpperLeft(), other.getLowerRight());
		}
		
		//this upper left region and other lower right region scenario
		else if(this.getLeft()<other.getLeft() && this.getBottom()>other.getBottom()){
			return new RegionImpl(new Coordinate(other.getLeft(),other.getBottom()), new Coordinate(this.getRight(), this.getTop()));
		}
		
		//other upper left region and this lower right region scenario
		else if(other.getLeft()<this.getLeft() && other.getBottom()>this.getBottom()){
			return new RegionImpl(new Coordinate(this.getLeft(),this.getBottom()), new Coordinate(other.getRight(), other.getTop()));
		}
		
		
		else{
			throw new RuntimeException("Error with region intersect method");
		}
	}
	/*
	 * Creates union of two regions
	 * Input: Other region
	 * Output: Region that encompasses this region and other region
	 * returns this region if other region is null
	 */
	@Override
	public Region union(Region other) {
		
		if(other==null){
			return this;
		}
		
		if(this.getLeft()<=other.getLeft()){
			
			if(this.getTop()<=other.getTop()){
				return new RegionImpl(this.getUpperLeft(), other.getLowerRight());
			}
			else{
				return new RegionImpl (new Coordinate(this.getLeft(), this.getBottom()), new Coordinate(other.getRight(),other.getTop()));
			}
		}
		
		else if(other.getLeft()<=this.getLeft()){
			
			if(other.getTop()<=this.getTop()){
				return new RegionImpl(other.getUpperLeft(), this.getLowerRight());
			}
			else{
				return new RegionImpl (new Coordinate(other.getLeft(), other.getBottom()), new Coordinate(this.getRight(),this.getTop()));
			}
		}
		
		else{
			throw new RuntimeException("Error with region intersect method");
		}
	}
	
}

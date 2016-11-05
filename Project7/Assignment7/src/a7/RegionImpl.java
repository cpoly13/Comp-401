package a7;

public class RegionImpl implements Region {
	private Coordinate a;
	private Coordinate b;
	
	public RegionImpl(Coordinate a, Coordinate b){
		this.a=a;
		this.b=b;
	}
	
	@Override
	public Coordinate getUpperLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coordinate getLowerRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBottom() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Region intersect(Region other) throws NoIntersectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region union(Region other) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

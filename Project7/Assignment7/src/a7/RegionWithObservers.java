package a7;
import java.util.List;

public interface RegionWithObservers extends Region {
	public void addObservers(ROIObserver a);
	public void subtractObservers(ROIObserver a);
	public List<ROIObserver> getObservers ();
}

package a8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FramePuzzleWidget extends JPanel implements ChangeListener, MouseListener{
	private PictureView[][] pictureViews;
	private PictureView redPicture;
	private JPanel[][] panels;
	private final Picture originalPic;
	private final Picture redTile;
	private Picture editedPic;
	private Iterator<SubPicture> iter;
	
	public FramePuzzleWidget(Picture p){
		setLayout(new GridLayout(5,5));
		this.setPreferredSize(new Dimension(655,495));
		originalPic=p;
		redTile=new PictureImpl(originalPic.getWidth()/5,originalPic.getHeight()/5);
		
		
		for(int i=0; i<redTile.getWidth();i++)
			for(int n=0; n<redTile.getHeight();n++){
				redTile.setPixel(i, n, new ColorPixel(1,0,0));
			}
		redPicture= new PictureView(redTile.createObservable());
		redPicture.addMouseListener(this);
		
		pictureViews= new PictureView [5][5];
		panels=new JPanel[5][5];
		editedPic=new PictureImpl(originalPic.getWidth(),originalPic.getHeight());
		iter=new TileIterator(originalPic,originalPic.getWidth()/5,originalPic.getHeight()/5);
		
		
		for(int i=0; i<pictureViews.length;i++){
			for(int n=0; n<pictureViews[0].length;n++){
				if(iter.hasNext()){
					pictureViews[i][n]=new PictureView(iter.next().createObservable());
					pictureViews[i][n].addMouseListener(this);
				}
			}
		}
		pictureViews[4][4]=redPicture;
		for(int i=0; i<panels.length;i++){
			for(int n=0; n<panels[0].length;n++){
				panels[i][n]=new JPanel();
				panels[i][n].setLayout(new BorderLayout());
				panels[i][n].add(pictureViews[i][n]);
				add(panels[i][n]);
			}
		}
		
		
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PictureView pictureClicked=(PictureView) e.getComponent();
		Coordinate picCoord=getArrayCoordinates(pictureClicked);
		Coordinate redCoord=getArrayCoordinates(redPicture);
		
		System.out.println("PictureView clicked: "+ picCoord.getX()+ " "+picCoord.getY());
		
		if(picCoord.getX()==redCoord.getX()){
			System.out.println("Matching Row");
			
			//panels[picCoord.getX()][picCoord.getY()]=panels[redCoord.getX()][redCoord.getY()];
			PictureView temp=(PictureView) panels[0][0].getComponent(0);
			temp.setPicture(redTile.createObservable());
			
		}
		
		
		
	}
	
	public Coordinate getArrayCoordinates(PictureView p){
		
		for(int i=0; i<panels.length;i++){
			for(int n=0; n<panels[0].length;n++){
				
				if(p==panels[i][n].getComponent(0)){
					return new Coordinate(i,n);
				}
				
				
			}
		}
		throw new RuntimeException("Logic error in getArrayCoordinates");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}

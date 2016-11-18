package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageAdjusterWidget extends JPanel implements ChangeListener {
	
	private PictureView picture_view;
	private final Picture originalPic;
	private Picture editedPic;
	private JPanel panel;
	private JSlider blurSlider;
	private JLabel blur;
	
	public ImageAdjusterWidget(Picture picture){
		setLayout(new BorderLayout());
		
		picture_view=new PictureView(picture.createObservable());
		originalPic=picture;
		editedPic= new PictureImpl(picture.getWidth(),picture.getHeight());
		
		add(picture_view, BorderLayout.CENTER);
		
		panel=new JPanel();
		blur=new JLabel("Blur:    ");
		
		blurSlider=new JSlider(0,5,0);
		blurSlider.setPaintTicks(true);
		blurSlider.setMajorTickSpacing(1);
		blurSlider.setLabelTable(blurSlider.createStandardLabels(1));
		blurSlider.setPaintLabels(true);
		blurSlider.addChangeListener(this);
		
		panel.setLayout(new BoxLayout(panel,0));
		panel.add(blur);
		panel.add(blurSlider);
		add(panel,BorderLayout.SOUTH);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int blurValue=blurSlider.getValue();
		if (blurValue!=0){
			blurPicture(blurValue);
			picture_view.setPicture(editedPic.createObservable());
		}
		
		else{
			picture_view.setPicture(originalPic.createObservable());
		}
		
	}
	
	public void blurPicture(int value){
		
		for (int i=0; i<editedPic.getWidth();i++){
			for(int n=0; n<editedPic.getHeight(); n++){
				if (i==0 && n==0){
					double averageRed=(originalPic.getPixel(i+1,n).getRed()+originalPic.getPixel(i, n+1).getRed())/2.0;
					double averageGreen=(originalPic.getPixel(i+1,n).getGreen()+originalPic.getPixel(i, n+1).getGreen())/2.0;
					double averageBlue=(originalPic.getPixel(i+1,n).getBlue()+originalPic.getPixel(i, n+1).getBlue())/2.0;
					
					editedPic.setPixel(i, n, new ColorPixel(averageRed,averageGreen,averageBlue));
				}
				else if(i==0 && n>0 && n+1<editedPic.getHeight()){
					double averageRed=(originalPic.getPixel(n-1, n).getRed()+ originalPic.getPixel(i+1,n).getRed()+originalPic.getPixel(i, n+1).getRed())/3.0;
					double averageGreen=(originalPic.getPixel(n-1, n).getGreen()+originalPic.getPixel(i+1,n).getGreen()+originalPic.getPixel(i, n+1).getGreen())/3.0;
					double averageBlue=(originalPic.getPixel(n-1, n).getBlue() + originalPic.getPixel(i+1,n).getBlue()+originalPic.getPixel(i, n+1).getBlue())/3.0;
					
					editedPic.setPixel(i, n, new ColorPixel(averageRed,averageGreen,averageBlue));
				}
				
				else if(i==0 && n+1==editedPic.getHeight()){
					double averageRed=(originalPic.getPixel(n-1, n).getRed()+ originalPic.getPixel(i+1,n).getRed())/2.0;
					double averageGreen=(originalPic.getPixel(n-1, n).getGreen()+originalPic.getPixel(i+1,n).getGreen())/2.0;
					double averageBlue=(originalPic.getPixel(n-1, n).getBlue() + originalPic.getPixel(i+1,n).getBlue())/2.0;
					
					editedPic.setPixel(i, n, new ColorPixel(averageRed,averageGreen,averageBlue));
					
				}
				
				else if(i>0 && n==0 && i+1<editedPic.getWidth()){
					double averageRed=(originalPic.getPixel(i-1, n).getRed()+ originalPic.getPixel(i+1,n).getRed()+originalPic.getPixel(i, n+1).getRed())/3.0;
					double averageGreen=(originalPic.getPixel(i-1, n).getGreen()+originalPic.getPixel(i+1,n).getGreen()+originalPic.getPixel(i, n+1).getGreen())/3.0;
					double averageBlue=(originalPic.getPixel(i-1, n).getBlue() + originalPic.getPixel(i+1,n).getBlue()+originalPic.getPixel(i, n+1).getBlue())/3.0;
					
					editedPic.setPixel(i, n, new ColorPixel(averageRed,averageGreen,averageBlue));
					
					
				}
				
				else if(i>0 && n>0 && i+1<editedPic.getWidth()&& n+1<editedPic.getHeight()){
					double averageRed=(originalPic.getPixel(i, n-1).getRed()+ originalPic.getPixel(i-1, n).getRed()+ originalPic.getPixel(i+1,n).getRed()+originalPic.getPixel(i, n+1).getRed())/4.0;
					double averageGreen=(originalPic.getPixel(i, n-1).getGreen()+originalPic.getPixel(i-1, n).getGreen()+originalPic.getPixel(i+1,n).getGreen()+originalPic.getPixel(i, n+1).getGreen())/4.0;
					double averageBlue=(originalPic.getPixel(i, n-1).getBlue()+originalPic.getPixel(i-1, n).getBlue() + originalPic.getPixel(i+1,n).getBlue()+originalPic.getPixel(i, n+1).getBlue())/4.0;
					
					editedPic.setPixel(i, n, new ColorPixel(averageRed,averageGreen,averageBlue));
					
				}
				
				
			}
		}
	}
	
	

}

package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ImageAdjusterWidget extends JPanel {
	private PictureView picture_view;
	private JPanel panel;
	private JSlider blurSlider;
	
	public ImageAdjusterWidget(Picture picture){
		setLayout(new BorderLayout());
		
		picture_view=new PictureView(picture.createObservable());
		add(picture_view, BorderLayout.CENTER);
		
		panel=new JPanel();
		blurSlider=new JSlider(0,5,0);
		blurSlider.setPaintTicks(true);
		blurSlider.setMajorTickSpacing(1);
		blurSlider.setLabelTable(blurSlider.createStandardLabels(1));
		blurSlider.setPaintLabels(true);
		panel.setLayout(new GridLayout(3,1));
		panel.add(blurSlider);
		add(panel,BorderLayout.SOUTH);
	}
	
	

}

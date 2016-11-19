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
	private JPanel blurPanel;
	private JPanel satPanel;
	private JPanel brightPanel;
	private JPanel gridPanel;
	private JSlider blurSlider;
	private JSlider satSlider;
	private JSlider brightSlider;
	private final JLabel blur;
	private final JLabel sat;
	private final JLabel bright;

	public ImageAdjusterWidget(Picture picture) {
		setLayout(new BorderLayout());

		picture_view = new PictureView(picture.createObservable());
		originalPic = picture;
		editedPic = new PictureImpl(picture.getWidth(), picture.getHeight());

		add(picture_view, BorderLayout.CENTER);
		gridPanel = new JPanel();
		blurPanel = new JPanel();
		satPanel = new JPanel();
		brightPanel = new JPanel();
		blur = new JLabel("Blur:    ");
		sat = new JLabel("Saturation:    ");
		bright = new JLabel("Brightness:     ");

		blurSlider = new JSlider(0, 5, 0);
		blurSlider.setPaintTicks(true);
		blurSlider.setMajorTickSpacing(1);
		blurSlider.setLabelTable(blurSlider.createStandardLabels(1));
		blurSlider.setPaintLabels(true);
		blurSlider.addChangeListener(this);

		satSlider = new JSlider(-100, 100, 0);
		satSlider.setPaintTicks(true);
		satSlider.setMajorTickSpacing(25);
		satSlider.setLabelTable(satSlider.createStandardLabels(25));
		satSlider.setSnapToTicks(true);
		satSlider.setPaintLabels(true);
		satSlider.addChangeListener(this);

		brightSlider = new JSlider(-100, 100, 0);
		brightSlider.setPaintTicks(true);
		brightSlider.setMajorTickSpacing(25);
		brightSlider.setLabelTable(brightSlider.createStandardLabels(25));
		brightSlider.setSnapToTicks(true);
		brightSlider.setPaintLabels(true);
		brightSlider.addChangeListener(this);

		gridPanel.setLayout(new GridLayout(3, 1));

		blurPanel.setLayout(new BoxLayout(blurPanel, 0));
		blurPanel.add(blur);
		blurPanel.add(blurSlider);

		satPanel.setLayout(new BoxLayout(satPanel, 0));
		satPanel.add(sat);
		satPanel.add(satSlider);

		brightPanel.setLayout(new BoxLayout(brightPanel, 0));
		brightPanel.add(bright);
		brightPanel.add(brightSlider);

		gridPanel.add(blurPanel);
		gridPanel.add(satPanel);
		gridPanel.add(brightPanel);

		add(gridPanel, BorderLayout.SOUTH);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int blurValue = blurSlider.getValue();
		int brightValue=brightSlider.getValue();
		int satValue= satSlider.getValue();
		if (blurValue != 0 || brightValue!=0 || satValue!=0) {
			blurPicture(blurValue);
			brightenPicture(brightValue);
			saturatePicture(satValue);
			picture_view.setPicture(editedPic.createObservable());
		}

		else {
			picture_view.setPicture(originalPic.createObservable());
		}

	}

	public void blurPicture(int value) {
		if(value>0){
		for (int i = 0; i < editedPic.getWidth(); i++) {
			for (int n = 0; n < editedPic.getHeight(); n++) {

				double averageRed = 0;
				double averageGreen = 0;
				double averageBlue = 0;
				double divisor = 0;

				for (int count = value; count > 0; count--) {
					try {
						averageRed += originalPic.getPixel(i - count, n).getRed();
						divisor++;
					} catch (Exception e) {

					}
					try {
						averageRed += originalPic.getPixel(i + count, n).getRed();
						divisor++;
					} catch (Exception e) {

					}
					try {
						averageRed += originalPic.getPixel(i, n + count).getRed();
						divisor++;
					} catch (Exception e) {

					}
					try {
						averageRed += originalPic.getPixel(i, n - count).getRed();
						divisor++;
					}

					catch (Exception e) {

					}

					try {
						averageRed += originalPic.getPixel(i + count, n + count).getRed();
						divisor++;
					}

					catch (Exception e) {

					}

					try {
						averageRed += originalPic.getPixel(i - count, n - count).getRed();
						divisor++;
					}

					catch (Exception e) {

					}

					try {
						averageRed += originalPic.getPixel(i + count, n - count).getRed();
						divisor++;
					}

					catch (Exception e) {

					}

					try {
						averageRed += originalPic.getPixel(i - count, n + count).getRed();
						divisor++;
					}

					catch (Exception e) {

					}
					try {
						averageGreen += originalPic.getPixel(i - count, n).getGreen();
					} catch (Exception e) {

					}
					try {
						averageGreen += originalPic.getPixel(i + count, n).getGreen();
					} catch (Exception e) {

					}
					try {
						averageGreen += originalPic.getPixel(i, n + count).getGreen();
					} catch (Exception e) {

					}
					try {
						averageGreen += originalPic.getPixel(i, n - count).getGreen();
					} catch (Exception e) {

					}

					try {
						averageGreen += originalPic.getPixel(i + count, n + count).getGreen();
					} catch (Exception e) {

					}

					try {
						averageGreen += originalPic.getPixel(i - count, n - count).getGreen();
					} catch (Exception e) {

					}

					try {
						averageGreen += originalPic.getPixel(i + count, n - count).getGreen();
					} catch (Exception e) {

					}

					try {
						averageGreen += originalPic.getPixel(i - count, n + count).getGreen();
					} catch (Exception e) {

					}

					try {
						averageBlue += originalPic.getPixel(i - count, n).getBlue();
					} catch (Exception e) {

					}
					try {
						averageBlue += originalPic.getPixel(i + count, n).getBlue();
					} catch (Exception e) {

					}
					try {
						averageBlue += originalPic.getPixel(i, n + count).getBlue();
					} catch (Exception e) {

					}
					try {
						averageBlue += originalPic.getPixel(i, n - count).getBlue();
					} catch (Exception e) {

					}

					try {
						averageBlue += originalPic.getPixel(i + count, n + count).getBlue();
					} catch (Exception e) {

					}

					try {
						averageBlue += originalPic.getPixel(i - count, n - count).getBlue();
					} catch (Exception e) {

					}

					try {
						averageBlue += originalPic.getPixel(i + count, n - count).getBlue();
					} catch (Exception e) {

					}

					try {
						averageBlue += originalPic.getPixel(i - count, n + count).getBlue();
					} catch (Exception e) {

					}

				}

				averageRed = averageRed / divisor;
				averageGreen = averageGreen / divisor;
				averageBlue = averageBlue / divisor;
				editedPic.setPixel(i, n, new ColorPixel(averageRed, averageGreen, averageBlue));

			}

		}
		}
		else{
			for(int i=0; i<editedPic.getWidth();i++){
				for(int n=0; n<editedPic.getHeight(); n++){
					editedPic.setPixel(i, n, originalPic.getPixel(i, n));
				}
			}
		}

	}

	public void brightenPicture(int value) {

		if (value != 0) {
			for (int i = 0; i < editedPic.getWidth(); i++) {
				for (int n = 0; n < editedPic.getHeight(); n++) {
					if (value > 0) {
						Pixel lightened=editedPic.getPixel(i, n).lighten(value/100.0);
						editedPic.setPixel(i, n, lightened);
					}
					else if (value<0){
						Pixel darkened=editedPic.getPixel(i, n).darken(Math.abs(value)/100.0);
						editedPic.setPixel(i, n, darkened);
					}

				}
			}
		}

	}
	
	public void saturatePicture(int value){
		if(value!=0){
			for (int i=0;i<editedPic.getWidth(); i++){
				for(int n=0; n<editedPic.getHeight();n++){
					double oldRed= editedPic.getPixel(i, n).getRed();
					double oldGreen=editedPic.getPixel(i, n).getGreen();
					double oldBlue=editedPic.getPixel(i, n).getBlue();
					double brightness=editedPic.getPixel(i, n).getIntensity();
						if(value<0){
								double newRed=oldRed*(1.0+(value/100.0))-(brightness*value/100.0);
								double newGreen=oldGreen*(1.0+(value/100.0))-(brightness*value/100.0);
								double newBlue=oldBlue*(1.0+(value/100.0))-(brightness*value/100.0);
								
								editedPic.setPixel(i, n, new ColorPixel(newRed,newGreen,newBlue));
						}	
						else if(value>0){
							double largestColor;
							if(oldRed>=oldGreen && oldRed>=oldBlue){
								largestColor=oldRed;
							}
							
							else if(oldGreen>=oldRed && oldGreen>=oldBlue){
								largestColor=oldGreen;
							}
							
							else if(oldBlue>=oldRed && oldBlue>=oldGreen){
								largestColor=oldBlue;
							}
							else{
								throw new RuntimeException("Logic error in finding largest color");
							}
							
							if(largestColor!=0){
								double newRed=oldRed*((largestColor+((1.0-largestColor)*(value/100.0)))/largestColor);
								double newGreen=oldGreen*((largestColor+((1.0-largestColor)*(value/100.0)))/largestColor);
								double newBlue=oldBlue*((largestColor+((1.0-largestColor)*(value/100.0)))/largestColor);
								
								editedPic.setPixel(i, n, new ColorPixel(newRed,newGreen,newBlue));
							}
						}
				}
			}
		}
	}

}

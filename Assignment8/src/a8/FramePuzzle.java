package a8;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePuzzle {
	
	
	public static void main(String args[]) throws IOException{
		Picture p=A8Helper.readFromURL("");
		FramePuzzleWidget widget=new FramePuzzleWidget(p);
		
		JFrame mainFrame=new JFrame();
		mainFrame.setTitle("Assignment 8 Frame Puzzle");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topPanel= new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.add(widget);
		
		mainFrame.setContentPane(topPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		System.out.println("Width: "+p.getWidth());
		System.out.println("Height: "+p.getHeight());
		
	}

}

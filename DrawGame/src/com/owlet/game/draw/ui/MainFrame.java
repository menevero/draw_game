package com.owlet.game.draw.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.owlet.game.draw.data.SharedData;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private static final int[] SIZE_MAIN_FRAME = {800, 600};	
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	SharedData sharedData;
	MainPanel panel;
	
	public MainFrame(SharedData sharedData) {
		super("text");
		this.sharedData = sharedData;
		this.panel = new MainPanel(sharedData, SIZE_MAIN_FRAME);
		
		setLocation(screen.width / 4, screen.height / 8);
		setResizable(false);
		setSize(SIZE_MAIN_FRAME[0], SIZE_MAIN_FRAME[1]);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run() {
		add(panel);
	}
}

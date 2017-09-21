package com.owlet.game.draw.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.owlet.game.draw.controler.GameMasterController;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements Runnable {
	//============================================
	//
	//		Constants
	//
	//============================================
	
	private static final int SIZE_MAIN_FRAME_WIDTH = 800;
	private static final int SIZE_MAIN_FRAME_HEIGHT = 600;
	
	
	
	
	//============================================
	//
	//		Variables
	//
	//============================================
	
	GameMasterController gameMasterController;
	
	/* 현재 컴퓨터의 화면 크기 */
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	MainPanel panel;
	
	
	
	
	//============================================
	//
	//		Constructor
	//
	//============================================
	
	public MainFrame(GameMasterController gameMasterController) {
		super("text");
		this.gameMasterController = gameMasterController;
		
		this.panel = new MainPanel(gameMasterController, SIZE_MAIN_FRAME_WIDTH, SIZE_MAIN_FRAME_HEIGHT);
		
		setLocation(screen.width / 4, screen.height / 8);
		setResizable(false);
		setSize(SIZE_MAIN_FRAME_WIDTH, SIZE_MAIN_FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void run() {
		add(panel);
	}
}

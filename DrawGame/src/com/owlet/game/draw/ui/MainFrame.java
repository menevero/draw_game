package com.owlet.game.draw.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.owlet.game.draw.controler.GameMasterController;
import com.owlet.game.draw.ui.panels.CustomJPanel;
import com.owlet.game.draw.ui.panels.MainMenuPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements Runnable {
	//============================================
	//
	//		Constants
	//
	//============================================
	
	private static final int SIZE_MAIN_FRAME_WIDTH = 800;
	private static final int SIZE_MAIN_FRAME_HEIGHT = 600;
	
	private static GameMasterController gameMasterController = new GameMasterController();
	
	
	
	
	//============================================
	//
	//		Variables
	//
	//============================================
	
	/* 현재 컴퓨터의 화면 크기 */
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private MainMenuPanel mainMenuPanel;
	
	
	
	
	//============================================
	//
	//		Constructor
	//
	//============================================
	
	public MainFrame() {
		super("text");
		
		this.mainMenuPanel = new MainMenuPanel(this);
		
		setLocation(screen.width / 4, screen.height / 8);
		setResizable(false);
		setSize(SIZE_MAIN_FRAME_WIDTH, SIZE_MAIN_FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	//============================================
	//
	//		Utilities
	//
	//============================================
	
	@Override
	public void run() {
		add(mainMenuPanel);
	}

	
	
	
	//============================================
	//
	//		Accessors
	//
	//============================================
	
	public static GameMasterController getGameMasterController() {
		return gameMasterController;
	}
	
	public CustomJPanel getMainMenuPanel() {
		return mainMenuPanel;
	}
	
	public int getWidth() {
		return SIZE_MAIN_FRAME_WIDTH;
	}
	
	public int getHeight() {
		return SIZE_MAIN_FRAME_HEIGHT;
	}
}

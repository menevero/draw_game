package com.owlet.game.draw.ui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.owlet.game.draw.controler.CharacterDrawer;
import com.owlet.game.draw.controler.PlayerAccount;
import com.owlet.game.draw.ui.MainFrame;

/**
 * 캐릭터를 뽑는 패널입니다.
 * 
 * @version 1.0
 * @since 17-09-23
 */
@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {
	//============================================
	//
	//		Variables
	//
	//============================================

	MainFrame frame;
	CharacterDrawer characterDrawer;
	PlayerAccount playerAccount;
	JPanel thisPanel = this;
	JPanel previousPanel;

	/* gameMenu */
	JButton drawButton;
	JButton backButton;




	//============================================
	//
	//		Constructor
	//
	//============================================

	/**
	 * @param MainFrame - 메인 프레임
	 * @param JPanel previousPanel - 이전 패널
	 */
	public DrawingPanel(MainFrame frame, JPanel previousPanel) {
		this.frame = frame;
		this.playerAccount = MainFrame.getGameMasterController().getAccountManager().getPlayerAccount();
		this.characterDrawer = MainFrame.getGameMasterController().getCharacterDrawer();
		this.previousPanel = previousPanel;

		initializeComponents();
		showThisPanel();
	}




	//============================================
	//
	//		Utilities
	//
	//============================================

	/**
	 * 이 패널에 속한 컴포넌트들을 초기화합니다.
	 */
	private void initializeComponents() {
		/* 캐릭터 뽑는 버튼 */
		drawButton = new JButton("캐릭터 뽑기");
		drawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//characterDrawer.startDraw();
				setVisible(false);
				frame.add(new ShowCharacterPanel(frame, thisPanel, characterDrawer.startDraw(), ShowCharacterPanel.SHOW_NEW_CHARACTER));
			}
		});

		/* 메인 메뉴로 돌아가는 버튼 */
		backButton = new JButton("돌아가기");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				previousPanel.setVisible(true);
				frame.deletePanel(thisPanel);
			}
		});
	}


	/**
	 * 이 패널을 보이게 합니다.
	 */
	private void showThisPanel() {
		setLayout(null);
		add(drawButton);
		drawButton.setBounds(0, 300, 100, 100);
		add(backButton);
		backButton.setBounds(0, 200, 100, 100);
	}
}

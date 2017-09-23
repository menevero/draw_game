package com.owlet.game.draw.ui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.owlet.game.draw.controler.AccountManager;
import com.owlet.game.draw.controler.PlayerAccount;
import com.owlet.game.draw.ui.MainFrame;

/**
 * 로그인에 성공했을 때 메인 메뉴 패널의 하위 패널로 생성되는 게임 내 메뉴화면 객체의 클래스입니다.
 * 
 * @version 1.0
 * @since 17-09-23
 */
@SuppressWarnings("serial")
public class GameMenuPanel extends JPanel {
	//============================================
	//
	//		Constant
	//
	//============================================

	private static final int SIZE_MAIN_BUTTON_DISTANCE = 12;




	//============================================
	//
	//		Variables
	//
	//============================================

	PlayerAccount playerAccount;
	MainFrame frame;
	JPanel thisPanel = this;
	JPanel previousPanel;

	/* gameMenu */
	JButton showCharactersButton;
	JButton removeCharacterButton;
	JButton drawCharacterButton;
	JButton logoutButton;




	//============================================
	//
	//		Constructor
	//
	//============================================

	/**
	 * @param MainFrame - 메인 프레임
	 * @param JPanel previousPanel - 이전 패널
	 */
	public GameMenuPanel(MainFrame frame, JPanel previousPanel) {
		this.frame = frame;

		//임시 주석 : 이 플레이어 어카운트 객체는 게임화면에 아이디 표시용으로 쓸 예정임
		this.playerAccount = MainFrame.getGameMasterController().getAccountManager().getPlayerAccount();
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
		/* 캐릭터 보는 화면으로 넘어가는 버튼 */
		showCharactersButton = new JButton("캐릭터 보기");
		showCharactersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.add(new ShowCharacterListPanel(frame, thisPanel));
			}
		});

		/* 캐릭터 삭제 화면으로 넘어가는 버튼 */
		removeCharacterButton = new JButton("캐릭터 삭제");
		removeCharacterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				//showMainMenu();
				validate();
				repaint();
			}
		});

		/* 캐릭터 뽑는 화면으로 넘어가는 버튼 */
		drawCharacterButton = new JButton("캐릭터 뽑기");
		drawCharacterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.add(new DrawingPanel(frame, thisPanel));
			}
		});

		/* 메인 메뉴로 돌아가는 버튼 */
		logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.getMainMenuPanel().setVisible(true);
				frame.deletePanel(thisPanel);
			}
		});
	}


	/**
	 * 이 패널을 보이게 합니다.
	 */
	private void showThisPanel() {
		setLayout(null);
		add(showCharactersButton);
		showCharactersButton.setBounds(0, 300, 100, 100);
		add(removeCharacterButton);
		removeCharacterButton.setBounds(0, 200, 100, 100);
		add(drawCharacterButton);
		drawCharacterButton.setBounds(0, 100, 100, 100);
		add(logoutButton);
		logoutButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, 0, 100, 100);
	}
}

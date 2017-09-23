package com.owlet.game.draw.ui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.owlet.game.draw.ui.ImageIconButton;
import com.owlet.game.draw.ui.Images;
import com.owlet.game.draw.ui.MainFrame;

/**
 * 게임 실행시 항상 가장 아래에 깔려있게 될 메인 메뉴 패널 클래스입니다.<br>
 * 프레임에서 getMainMenuPanel() 메소드를 통해 참조가 가능합니다.<br>
 * <br>
 * 모든 패널들은 다음과 같은 성질을 가지고 있습니다 : <br>
 * <br>
 * 1. 새로운 패널이 생성될 때, 이전 패널은 setVisible() 메소드를 통하여 보이지 않는 상태가 되지만, 객체 자체가 사라지지는 않습니다.<br>
 * 2. 가장 최근에 만들어진 패널에서 이전 패널로 돌아갈 때에는, 최근 패널 객체를 없애버리고 그 전 패널을 표시하도록 합니다.(MainFrame 클래스의 deletePanel() 메소드 사용)<br>
 * 3. 모든 패널들은 MainFrame 객체를 참조할 수 있으며, 이 객체로부터 마스터 컨트롤러와 접촉이 가능합니다.
 * 
 * @version 1.0
 * @since 17-09-23
 */
@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel {
	//============================================
	//
	//		Constants
	//
	//============================================

	private static final int SIZE_MAIN_BUTTON_DISTANCE = 12;




	//============================================
	//
	//		Variables
	//
	//============================================

	MainFrame frame;
	JPanel thisPanel = this;

	ImageIconButton loginButton;
	ImageIconButton signUpButton;
	ImageIconButton programExitButton;




	//============================================
	//
	//		Constructor
	//
	//============================================

	/**
	 * @param JFrame parentFrame - 이 패널을 가지고 있는 프레임
	 */
	public MainMenuPanel(MainFrame frame) {
		this.frame = frame;

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
		//=========================
		//	mainMenu
		//=========================
		/* 로그인 화면으로 넘어가는 버튼 */
		loginButton = new ImageIconButton(Images.BUTTON_MAIN_LOGIN);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.add(new LoginPanel(frame, thisPanel));
			}
		});

		/* 화원가입 화면으로 넘어가는 버튼 */
		signUpButton = new ImageIconButton(Images.BUTTON_MAIN_SIGNIN);
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//TODO 회원가입
			}
		});

		/* 프로그램 종료(0리턴) */
		programExitButton = new ImageIconButton(Images.BUTTON_MAIN_EXIT);
		programExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * 이 패널을 보이게 합니다.
	 */
	private void showThisPanel() {
		setLayout(null);
		add(loginButton);
		loginButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, frame.getHeight() - 300, loginButton.getWidth(), loginButton.getHeight());
		add(signUpButton);
		signUpButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, frame.getHeight() - 208, loginButton.getWidth(), loginButton.getHeight());
		add(programExitButton);
		programExitButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, frame.getHeight() - 130, loginButton.getWidth(), loginButton.getHeight());
	}
}
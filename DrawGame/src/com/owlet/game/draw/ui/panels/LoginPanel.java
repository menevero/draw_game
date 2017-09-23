package com.owlet.game.draw.ui.panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.owlet.game.draw.controler.AccountManager;
import com.owlet.game.draw.ui.ImageIconButton;
import com.owlet.game.draw.ui.Images;
import com.owlet.game.draw.ui.MainFrame;

/**
 * 로그인 세션용 패널 클래스입니다.<br>
 * 다른 패널들과는 달리 사용 후 바로 삭제됩니다.
 * 
 * @version 1.0
 * @since 17-09-23
 */
@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	//============================================
	//
	//		Constants
	//
	//============================================
	
	private static final int LOGIN_ERROR_ALL = 1;
	private static final int LOGIN_ERROR_ID = 2;
	private static final int LOGIN_ERROR_PW = 3;
	private static final int LOGIN_ERROR_WRONG = 4;
	
	
	
	
	//============================================
	//
	//		Variables
	//
	//============================================

	MainFrame frame;
	AccountManager accountManager;
	JPanel thisPanel = this;
	JPanel previousPanel;

	/* loginMenu */
	JTextField idField;
	JTextField passwordField;
	ImageIconButton tryLoginButton;
	JButton backButton;

	/* 로그인이 실패했을 때 사용할 컴포넌트들 */
	JLabel loginFailedMessage;
	ImageIconButton gotoLoginButton;





	//============================================
	//
	//		Constructor
	//
	//============================================

	/**
	 * @param MainFrame - 메인 프레임
	 * @param JPanel previousPanel - 이전 패널
	 */
	public LoginPanel(MainFrame frame, JPanel previousPanel) {
		this.frame = frame;
		this.accountManager = frame.gameMasterController.getAccountManager();
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
		//=========================
		//	loginMenu
		//=========================
		/* 아이디 입력 텍스트필드 */
		idField = new JTextField(10);

		/* 패스워드 입력 텍스트필드 */
		passwordField = new JTextField(10);

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

		/* 텍스트필드에 입력된 텍스트값을 넘겨서 로그인 시작 */
		tryLoginButton = new ImageIconButton(Images.BUTTON_MAIN_LOGIN);
		tryLoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				System.out.println("로그 : " + idField.getText() + " " +  passwordField.getText());
				if(idField.getText().toString().equals("") && passwordField.getText().toString().equals("")) {
					removeAll();
					showLoginFailed(LOGIN_ERROR_ALL);
					validate();
					repaint();
				}
				else if(idField.getText().toString().equals("")) {
					removeAll();
					showLoginFailed(LOGIN_ERROR_ID);
					validate();
					repaint();
				}
				else if(passwordField.getText().toString().equals("")) {
					removeAll();
					showLoginFailed(LOGIN_ERROR_PW);
					validate();
					repaint();
				}
				else if(accountManager.isIDCorrect(idField.getText().toString()) == true && accountManager.isPasswordCorrect(passwordField.getText().toString()) == true) {
					System.out.println("정상적으로 로그인되었습니다");
					passwordField.setText("");
					accountManager.startLogin();
					
					setVisible(false);
					frame.add(new GameMenuPanel(frame, frame.getMainMenuPanel()));
					frame.deletePanel(thisPanel);
				}
				else {
					passwordField.setText("");
					removeAll();
					showLoginFailed(LOGIN_ERROR_WRONG);
					validate();
					repaint();
				}
			}
		});

		//=========================
		// 로그인 실패시 나오는 화면
		//========================= 
		/* 로그인 실패 메시지 표시용 레이블 */
		loginFailedMessage = new JLabel();
		loginFailedMessage.setHorizontalTextPosition(SwingConstants.CENTER);

		/* 다시 로그인창으로 돌아가는 버튼 */
		gotoLoginButton = new ImageIconButton(Images.BUTTON_LOGIN_SESSION_BACK);
		gotoLoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				showThisPanel();
				validate();
				repaint();
			}
		});
	}

	
	/**
	 * 이 패널을 보이게 합니다.
	 */
	private void showThisPanel() {
		setLayout(new FlowLayout());
		add(idField);
		add(passwordField);
		add(tryLoginButton);
		add(backButton);
	}

	
	/**
	 * 로그인에 실패했을 때 잠시 이 패널을 지우고 오류 이유를 보여줍니다.
	 * 에러 메시지를 확인하고 버튼을 누르면 다시 돌아갑니다.
	 */
	private void showLoginFailed(int situation) {
		setLayout(null);
		
		switch(situation) {
		case LOGIN_ERROR_ALL:
			loginFailedMessage.setText("아이디와 패스워드를 입력해 주십시오.");
			break;
			
		case LOGIN_ERROR_ID:
			loginFailedMessage.setText("아이디를 입력해 주십시오.");
			break;
			
		case LOGIN_ERROR_PW:
			loginFailedMessage.setText("패스워드를 입력해 주십시오.");
			break;
			
		case LOGIN_ERROR_WRONG:
			loginFailedMessage.setText("아이디가 존재하지 않거나 패스워드가 틀렸습니다.");
			break;
		}

		add(loginFailedMessage);
		loginFailedMessage.setBounds(0, 0, 400, 150);
		add(gotoLoginButton);
		gotoLoginButton.setBounds(0, 400, gotoLoginButton.getWidth(), gotoLoginButton.getHeight());
	}
}

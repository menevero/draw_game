package com.owlet.game.draw.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.owlet.game.draw.controler.GameMasterController;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	/* 로그인 오류시 사용하는 패러미터 */
	private static final int LOGIN_ERROR_ALL = 1;
	private static final int LOGIN_ERROR_ID = 2;
	private static final int LOGIN_ERROR_PW = 3;
	private static final int LOGIN_ERROR_WRONG = 4;
	
	private static final int SIZE_MAIN_BUTTON_DISTANCE = 12;
	
	//============================================
	//
	//		Variables
	//
	//============================================
	
	GameMasterController gameMasterController;
	
	int frameWidth;
	int frameHeight;
	
	/* mainMenu */
	ImageIconButton loginButton;
	ImageIconButton signUpButton;
	ImageIconButton programExitButton;
	
	/* gameMenu */
	JButton showCharactersButton;
	JButton removeCharacterButton;
	JButton drawCharacterButton;
	JButton logoutButton;
	
	/* loginMenu */
	JTextField idField;
	JTextField passwordField;
	JDialog failedDialog;
	ImageIconButton tryLoginButton;
	JButton abortButton;
	/* showLoginFailed */
	JLabel loginFailedMessage;
	ImageIconButton gotoLoginButton;
	
	/* showCharacters */
	JScrollPane scrollPane;
	JTable characterShowTable;
	JButton gotoGameMenuButton;
	

	
	
	
	//============================================
	//
	//		Constructor
	//
	//============================================
	
	/**
	 * @param GameMasterController gameMasterController - 게임 마스터 컨트롤러
	 * @param int frameWidth - 프레임의 가로 길이
	 * @param int frameHeight - 프레임의 세로 길이
	 */
	public MainPanel(GameMasterController gameMasterController, int frameWidth, int frameHeight) {
		this.gameMasterController = gameMasterController;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		
		setEnabled(false);
		initializeComponents();
		showMainMenu();
	}
	
	
	
	
	//============================================
	//
	//		Utilities
	//
	//============================================
	
	/** 컴포넌트 초기화 */
	private void initializeComponents() {
		 
		//=========================
		//	mainMenu
		//=========================
		/* 로그인 화면으로 넘어가는 버튼 */
		loginButton = new ImageIconButton(Images.BUTTON_MAIN_LOGIN);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				showLoginWindow();
				validate();
				repaint();
			}
		});
		
		/* 화원가입 화면으로 넘어가는 버튼 */
		signUpButton = new ImageIconButton(Images.BUTTON_MAIN_SIGNIN);
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				//TODO 회원가입
				validate();
				repaint();
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
		
		//=========================
		//	gameMenu
		//=========================
		/* 캐릭터 보는 화면으로 넘어가는 버튼 */
		showCharactersButton = new JButton("캐릭터 보기");
		showCharactersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				showCharactersWindow();
				validate();
				repaint();
			}
		});
		
		/* 캐릭터 삭제 화면으로 넘어가는 버튼 */
		removeCharacterButton = new JButton("캐릭터 삭제");
		removeCharacterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				showMainMenu();
				validate();
				repaint();
			}
		});
		
		/* 캐릭터 뽑는 화면으로 넘어가는 버튼 */
		drawCharacterButton = new JButton("캐릭터 뽑기");
		drawCharacterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				showMainMenu();
				validate();
				repaint();
			}
		});
		
		/* 메인 메뉴로 돌아가는 버튼 */
		logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				// TODO 로그아웃 조치
				//sharedData.getLogin().
				//sharedData.getPlayer().initializeLoginInformation();
				showMainMenu();
				validate();
				repaint();
			}
		});

		//=========================
		//	loginMenu
		//=========================
		/* 아이디 입력 텍스트필드 */
		idField = new JTextField(10);
		
		/* 패스워드 입력 텍스트필드 */
		passwordField = new JTextField(10);
		
		/* 아이디와 비밀번호 값이 틀렸을때 나오는 대화상자 */
		failedDialog = new JDialog();
		failedDialog.setUndecorated(false);
		failedDialog.setTitle("로그인 실패");
		
		/* 메인 메뉴로 돌아가는 버튼 */
		abortButton = new JButton("돌아가기");
		abortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				showMainMenu();
				validate();
				repaint();
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
				else if(gameMasterController.getAccountManager().isIDCorrect(idField.getText().toString()) == true && gameMasterController.getAccountManager().isPasswordCorrect(passwordField.getText().toString()) == true) {
					System.out.println("정상적으로 로그인되었습니다");
					passwordField.setText("");
					gameMasterController.getAccountManager().startLogin();
					removeAll();
					showGameMenu();
					validate();
					repaint();
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
				showLoginWindow();
				validate();
				repaint();
			}
		});
		
		gotoGameMenuButton = new JButton("돌아가기");
		gotoGameMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				showGameMenu();
				validate();
				repaint();
			}
		});
	} /* initializeComponents() 끝 */

	
	
	
	/************************************************************************************************************************************************************************/
	/************************************************************************************************************************************************************************/
	/************************************************************************************************************************************************************************/
	
	/** 보유한 캐릭터 확인하는 창 */
	private void showCharactersWindow() {
		/* 테이블 선언 / 초기화 */
		characterShowTable = new CharacterCardShowTable(gameMasterController.getAccountManager().getPlayerAccount().getPlayerBlongedCharacterList());
		
		scrollPane = new JScrollPane(characterShowTable);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(scrollPane);
		scrollPane.setBounds(100, 100, 545, 424);
		scrollPane.setVisible(true);
		scrollPane.validate();
		scrollPane.repaint();
		
		add(gotoGameMenuButton);
		gotoGameMenuButton.setBounds(0, 0, 100, 100);
	}
	
	/** 로그인창 */
	private void showLoginWindow() {
		setLayout(new FlowLayout());
		add(idField);
		add(passwordField);
		add(tryLoginButton);
		add(abortButton);
	}
	
	/** 로그인창에서 로그인 실패시 나오는 창 */
	private void showLoginFailed(int situation) {
		setLayout(null);
		if(situation == LOGIN_ERROR_ALL) {
			loginFailedMessage.setText("아이디와 패스워드를 입력해 주십시오.");
			//TODO 아래 캐릭터 생성 코드 삭제할 것
			gameMasterController.getCharacterDrawer().startDraw();
		}
		else if(situation == LOGIN_ERROR_ID) {
			loginFailedMessage.setText("아이디를 입력해 주십시오.");
		}
		else if(situation == LOGIN_ERROR_PW) {
			loginFailedMessage.setText("패스워드를 입력해 주십시오.");
		}
		else if(situation == LOGIN_ERROR_WRONG) {
			loginFailedMessage.setText("아이디가 존재하지 않거나 패스워드가 틀렸습니다.");
		}

		add(loginFailedMessage);
		loginFailedMessage.setBounds(SIZE_MAIN_BUTTON_DISTANCE, 0, 400, 150);
		add(gotoLoginButton);
		gotoLoginButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, 400, gotoLoginButton.getWidth(), gotoLoginButton.getHeight());
	}

	/** 로그인 후 나오는 게임화면 */
	private void showGameMenu() {
		setLayout(null);
		add(showCharactersButton);
		showCharactersButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, 300, 100, 100);
		add(removeCharacterButton);
		removeCharacterButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, 200, 100, 100);
		add(drawCharacterButton);
		drawCharacterButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, 100, 100, 100);
		add(logoutButton);
		logoutButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, 0, 100, 100);
	}

	/** 게임이 켜졌을 때 나오는 메인메뉴 */
	private void showMainMenu() {
		setLayout(null);
		add(loginButton);
		loginButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, frameHeight - 300, loginButton.getWidth(), loginButton.getHeight());
		add(signUpButton);
		signUpButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, frameHeight - 208, loginButton.getWidth(), loginButton.getHeight());
		add(programExitButton);
		programExitButton.setBounds(SIZE_MAIN_BUTTON_DISTANCE, frameHeight - 130, loginButton.getWidth(), loginButton.getHeight());
	}
}

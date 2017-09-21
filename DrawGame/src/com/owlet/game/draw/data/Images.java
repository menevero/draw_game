package com.owlet.game.draw.data;

/* 각 이미지는 버튼의 경우 normal - pressed - rollovered 순서로 배열에 경로가 들어있음 */
public class Images {
	
	/** 메인메뉴 로그인 버튼 */
	public static final String[] BUTTON_MAIN_LOGIN = {"Images\\BUTTON_MAIN_LOGIN.png", "Images\\BUTTON_MAIN_LOGIN_PRESSED.png", "Images\\BUTTON_MAIN_LOGIN_ROLLOVERED.png"};
	/** 메인메뉴 회원가입 버튼 */
	public static final String[] BUTTON_MAIN_SIGNIN = {"Images\\BUTTON_MAIN_SIGNIN.png", "Images\\BUTTON_MAIN_SIGNIN_PRESSED.png", "Images\\BUTTON_MAIN_SIGNIN_ROLLOVERED.png"};
	/** 메인메뉴 회원가입 버튼 */
	public static final String[] BUTTON_MAIN_EXIT = {"Images\\BUTTON_MAIN_EXIT.png", "Images\\BUTTON_MAIN_EXIT_PRESSED.png", "Images\\BUTTON_MAIN_EXIT_ROLLOVERED.png"};
	
	/** 로그인창에서 로그인 하는 버튼 */
	//public static final String[] BUTTON_LOGIN_SESSION_LOGIN = {"Images\\BUTTON_LOGIN.png", "Images\\BUTTON_LOGIN_PRESSED.png", "Images\\BUTTON_LOGIN_ROLLOVERED.png"};
	/** 로그인 과정에서 에러 발생시 로그인창으로 돌아가는 버튼 */
	public static final String[] BUTTON_LOGIN_SESSION_BACK = {"Images\\BUTTON_BACKTO_LOGIN.png", "Images\\BUTTON_BACKTO_LOGIN_PRESSED.png", "Images\\BUTTON_BACKTO_LOGIN_ROLLOVERED.png"};
	
	public static final String[] CHARACTER_SAMPLE = {"Images\\CHARACTER_SAMPLE.png", "Images\\CHARACTER_SAMPLE_PRESSED.png", "Images\\CHARACTER_SAMPLE_ROLLOVERED.png"};
	
	public static final String[] CHARACTER_NULL_CHARACTER = {"Images\\CHARACTER_NULL.png", "Images\\CHARACTER_CHARACTER_NULL.png", "Images\\CHARACTER_NULL.png"};
}

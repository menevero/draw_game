package com.owlet.game.draw.controler;

/**
 * 로그인 세션 및 로그인된 계정의 관리를 맡고 있는 컨트롤러 클래스입니다.
 * 
 * @version 1.0
 * @since 17-09-21
 */
public class AccountManager {
	//============================================
	//
	//		Variables
	//
	//============================================
	
	private String identifier;
	private String password;
	private PlayerAccount playerAccount = new PlayerAccount();  //임시로 만들어져 있는 플레이어임
	
	
	
	
	//============================================
	//
	//		Utilities
	//
	//============================================
	
	//TODO DB연동시에 아래 엑세서 메소드 삭제하고 ID, PASSWORD 값 대조를 이 메소드에서 한꺼번에 처리
	/**
	 * 로그인 시작
	 */
	public boolean startLogin() {
		//TODO 로그인 시작
		this.identifier = null;
		this.password = null;
		return false;
	}
	
	/**
	 * 아이디 값을 문자열 비교하여 boolean 값 리턴
	 */
	public boolean isIDCorrect(String id) {
		this.identifier = id;
		if(this.identifier.equals("id")) {
			System.out.println(identifier);
			return true;
		}
		else {
			this.identifier = null;
			this.password = null;
			return false;
		}
	}
	
	/**
	 * 패스워드 값을 문자열 비교하여 boolean 값 리턴
	 */
	public boolean isPasswordCorrect(String newPassword) {
		this.password = newPassword;
		if(this.password.equals("1234")) {
			System.out.println(password);
			return true;
		}
		else {
			this.identifier = null;
			this.password = null;
			return false;
		}
	}
	
	
	
	
	//============================================
	//
	//		Accessors
	//
	//============================================
	
	/** 로그인된 계정 정보를 리턴합니다. */
	public PlayerAccount getPlayerAccount() {
		return this.playerAccount;
	}
}

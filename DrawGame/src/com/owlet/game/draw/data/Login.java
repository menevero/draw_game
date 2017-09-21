package com.owlet.game.draw.data;

public class Login {
	//============================================
	//
	//		Variables
	//
	//============================================
	
	private String identification;
	private String password;
	
	
	
	
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
		this.identification = null;
		this.password = null;
		return false;
	}
	
	/**
	 * 아이디 값을 문자열 비교하여 boolean 값 리턴
	 */
	public boolean isIDCorrect(String id) {
		this.identification = id;
		if(this.identification.equals("id")) {
			System.out.println(identification);
			return true;
		}
		else {
			this.identification = null;
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
			this.identification = null;
			this.password = null;
			return false;
		}
	}
}

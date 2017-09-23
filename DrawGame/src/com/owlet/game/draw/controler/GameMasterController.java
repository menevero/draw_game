package com.owlet.game.draw.controler;

/**
 * 게임 데이터를 제어할 여러 하위 컨트롤러 객체들을 포함하고 있는 마스터 컨트롤러 클래스입니다.
 * 
 * @version 1.0
 * @since 17-09-21
 */
public class GameMasterController {
	//============================================
	//
	//		Variables
	//
	//============================================

	private AccountManager accountManager;
	private CharacterDrawer characterDrawer;




	//============================================
	//
	//		Constructor
	//
	//============================================

	public GameMasterController() {
		this.accountManager = new AccountManager();
		this.characterDrawer = new CharacterDrawer(this.accountManager.getPlayerAccount());
	}




	//============================================
	//
	//		Accessors
	//
	//============================================

	/** 계정관리 컨트롤러를 리턴합니다. */
	public AccountManager getAccountManager() {
		return this.accountManager;
	}

	/** 캐릭터 랜덤 생성기를 리턴합니다. */
	public CharacterDrawer getCharacterDrawer() {
		return this.characterDrawer;
	}
}

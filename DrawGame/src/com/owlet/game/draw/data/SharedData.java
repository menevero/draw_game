package com.owlet.game.draw.data;

import java.util.Scanner;

import com.owlet.game.draw.controler.CharacterDrawer;

public class SharedData {
	//============================================
	//
	//		Variables
	//
	//============================================

	/*
	Scanner	- CUI 입력용 scanner
	Login		- 로그인 세션용 클래스
	Images	- GUI 내에서 사용될 이미지 객체들을 모아놓은 클래스(캐릭터 이미지는 캐릭터 객체가 가지고 있음)
	PlayerAccount - 플레이어 계정 객체
	Dice			- 난수 발생기
	characterDrawer - 캐릭터를 뽑아서 플레이어 계정 객체의 playerBelongedCharacters 객체에 add() 시켜줌
	*/
	
	@SuppressWarnings("unused")
	private Scanner scanner = new Scanner(System.in);
	private Login login = new Login();
	private PlayerAccount defaultPlayer = new PlayerAccount();
//	private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
	private CharacterTable characterTable = new CharacterTable();

	/* 주사위 객체 */
	Dice dice = new Dice(characterTable.CHARS_INFERIOR.length, characterTable.CHARS_NORMAL.length, characterTable.CHARS_MAGIC.length, characterTable.CHARS_RARE.length, characterTable.CHARS_UNIQUE.length);

	/* 뽑기 머신 */
	CharacterDrawer characterDrawer = new CharacterDrawer(this.characterTable, this.defaultPlayer, this.dice);
	
	
	
	
	//============================================
	//
	//		Constructor
	//
	//============================================
	
	public SharedData(Scanner scanner) {
		this.scanner = scanner;
	}
	
	
	
	
	//============================================
	//
	//		Accessors
	//
	//============================================
	
	public Login getLogin() {
		return this.login;
	}
	
	public PlayerAccount getPlayer() {
		return this.defaultPlayer;
	}
	
	public CharacterDrawer getCharacterDrawer() {
		return this.characterDrawer;
	}
}

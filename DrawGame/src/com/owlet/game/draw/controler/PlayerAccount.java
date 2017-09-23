package com.owlet.game.draw.controler;

import java.util.ArrayList;

import com.owlet.game.draw.data.Character;

/**
 * 현재 로그인된 계정 정보를 가지고 있을 클래스입니다.<br>
 * 이 클래스의 인스턴스는 AccountManager 객체 안에만 존재합니다.
 * 
 * @version 1.0
 * @since 17-09-21
 */
public class PlayerAccount {
	//============================================
	//
	//		Variables
	//
	//============================================

	private String identifier;
	private ArrayList<Character> playerBelongedCharacters = new ArrayList<Character>();
	//	private ArrayList<Character> playerBelongedEquipments = new ArrayList<Character>();




	//============================================
	//
	//		Utilities
	//
	//============================================
	
	/** 새로운 캐릭터 객체를 넣는 메소드 */
	public boolean addCharacter(Character newCharacter) {
		if(this.playerBelongedCharacters.size() == 10) {
			return false;
		}
		else {
			//TODO DB연동시키기
			this.playerBelongedCharacters.add(newCharacter);
			return true;
		}
	}

	public boolean removeCharacter(int index) {
		if(this.playerBelongedCharacters.size() < 0) {
			return false;
		}

		// IndexOutOfBoundsException 예외처리 필요
		this.playerBelongedCharacters.remove(index);
		return  true;
	}




	//============================================
	//
	//		Accessors
	//
	//============================================

	/*
	public void addMoney(int additionalMoney) {
		this.money += additionalMoney;
		//System.out.println("정상적으로 입금되었습니다.");
	}

	public boolean takeMoney(int value) {
		if(value > this.money) {
			//System.out.println("돈이 부족합니다.");
			return false;
		}
		else {
			this.money -= value;
			return true;
		}
	}*/
	
	public ArrayList<Character> getPlayerBlongedCharacterList() {
		return this.playerBelongedCharacters;
	}

	public void setPlayerIdentfication(String newIdentification) {
		this.identifier = newIdentification;
	}

	public String getPlayerIdentfication() {
		return this.identifier;
	}

	public int getNumberOfBelongedCharacters() {
		return this.playerBelongedCharacters.size();
	}

	/**
	 * 모은 캐릭터 객체를 출력하는 메소드
	 */
	public Character getSpecificCharacter(int index) {
		return this.playerBelongedCharacters.get(index);
	}
}

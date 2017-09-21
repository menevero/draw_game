package com.owlet.game.draw.data;

import java.util.ArrayList;

/* 임시 플레이어 객체 */
public class PlayerAccount {
	//============================================
	//
	//		Variables
	//
	//============================================

	private String identification;
	private int money = 100;

	private ArrayList<Character> playerBelongedCharacters = new ArrayList<Character>();
	//	private ArrayList<Character> playerBelongedEquipments = new ArrayList<Character>();




	//============================================
	//
	//		Utilities
	//
	//============================================

	/*
	 * 새로운 캐릭터 객체를 넣는 메소드
	 */
	public boolean addCharacter(Character newCharacter) {
		if(this.playerBelongedCharacters.size() == 10) {
			return false;
		}
		else {
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
	}
	
	public ArrayList<Character> getCharacterList() {
		return this.playerBelongedCharacters;
	}

	public void setPlayerIdentfication(String newIdentification) {
		this.identification = newIdentification;
	}

	public String getPlayerIdentfication() {
		return this.identification;
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

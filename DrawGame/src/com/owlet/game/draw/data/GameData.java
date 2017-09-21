package com.owlet.game.draw.data;

import java.util.Scanner;

import com.owlet.game.draw.controler.PlayerAccount;

/**
 * 게임에서 사용될 모든 데이터의 총집합니다.
 * 
 * @version 1.0
 * @since 17-09-21
 */
public class GameData {
	//============================================
	//
	//		Variables
	//
	//============================================
	
	private PlayerAccount defaultPlayer = new PlayerAccount();
//	private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
	private CharacterTable characterTable = new CharacterTable();
	
	
	
	
	//============================================
	//
	//		Accessors
	//
	//============================================
	
	public CharacterTable getCharacterTable() {
		return this.characterTable;
	}
	
	public PlayerAccount getPlayer() {
		return this.defaultPlayer;
	}
}

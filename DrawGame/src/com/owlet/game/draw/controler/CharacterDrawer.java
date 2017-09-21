package com.owlet.game.draw.controler;

import com.owlet.game.draw.data.Character;
import com.owlet.game.draw.data.CharacterTable;
import com.owlet.game.draw.data.Dice;
import com.owlet.game.draw.data.PlayerAccount;

public class CharacterDrawer {
	//============================================
	//
	//		Variables
	//
	//============================================

	private CharacterTable characterTable;
	private PlayerAccount player;
	private Dice dice;




	//============================================
	//
	//		Constructor
	//
	//============================================

	public CharacterDrawer(CharacterTable characterTable, PlayerAccount player, Dice dice) {
		this.characterTable = characterTable;
		this.player = player;
		this.dice = dice;
	}




	//============================================
	//
	//		Utilities
	//
	//============================================

	/**
	 * 캐릭터를 생성하는데 성공하면 캐릭터를 리턴하고, 실패하면 null을 리턴함
	 */
	public Character startDraw() {
		int randomNumber;
		randomNumber = dice.rollHundred();
		/* 나중에 문자열 출력 삭제할것 */
		System.out.println("확률" + randomNumber);
		
		if(randomNumber <= 50) {
			System.out.println("5등급");
			randomNumber = dice.rollRankInferior();
			System.out.println("확률" + randomNumber);
			if(player.addCharacter(new Character(characterTable.CHARS_INFERIOR[randomNumber], 001, 0000))) {
				return characterTable.CHARS_INFERIOR[randomNumber];
			}
			return null;
		}
		else if(randomNumber <= 80) {
			System.out.println("4등급");
			randomNumber = dice.rollRankNormal();
			System.out.println("확률" + randomNumber);
			if(player.addCharacter(characterTable.CHARS_NORMAL[randomNumber])) {
				return characterTable.CHARS_NORMAL[randomNumber];
			}
			return null;
		}
		else if(randomNumber <= 95) {
			System.out.println("3등급");
			randomNumber = dice.rollRankMagic();
			System.out.println("확률" + randomNumber);
			if(player.addCharacter(characterTable.CHARS_MAGIC[randomNumber])) {
				return characterTable.CHARS_MAGIC[randomNumber];
			}
			return null;
		}
		else if(randomNumber <= 99) {
			System.out.println("2등급");
			randomNumber = dice.rollRankRare();
			System.out.println("확률" + randomNumber);
			if(player.addCharacter(characterTable.CHARS_RARE[randomNumber])) {
				return characterTable.CHARS_RARE[randomNumber];
			}
			return null;
		}
		else {
			System.out.println("1등급 ");
			randomNumber = dice.rollRankUnique();
			System.out.println("확률" + randomNumber);
			if(player.addCharacter(characterTable.CHARS_UNIQUE[randomNumber])) {
				return characterTable.CHARS_UNIQUE[randomNumber];
			}
			return null;
		}
	}
}

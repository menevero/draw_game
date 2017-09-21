package com.owlet.game.draw.controler;

import java.util.Random;

public class Dice {
	//============================================
	//
	//		Variables
	//
	//============================================
	
	private Random random = new Random();
	private int[] numberOfCharacters = new int[5];
	
	
	
	
	//============================================
	//
	//		Constructor
	//
	//============================================
	
	public Dice(int param1, int param2, int param3, int param4, int param5) {
		this.numberOfCharacters[0] = param1;
		this.numberOfCharacters[1] = param2;
		this.numberOfCharacters[2] = param3;
		this.numberOfCharacters[3] = param4;
		this.numberOfCharacters[4] = param5;
	}
	
	
	
	
	//============================================
	//
	//		Utilities
	//
	//============================================
	
	public int rollHundred() {
		return this.random.nextInt(100) + 1;
	}
	
	/** 1랭크 캐릭터 랜덤 */
	public int rollRankUnique() {
		return random.nextInt(numberOfCharacters[0]);
	}
	
	/** 2랭크 캐릭터 랜덤 */
	public int rollRankRare() {
		return random.nextInt(numberOfCharacters[1]);
	}
	
	/** 3랭크 캐릭터 랜덤 */
	public int rollRankMagic() {
		return random.nextInt(numberOfCharacters[2]);
	}
	
	/** 4랭크 캐릭터 랜덤 */
	public int rollRankNormal() {
		return random.nextInt(numberOfCharacters[3]);
	}
	
	/** 5랭크 캐릭터 랜덤 */
	public int rollRankInferior() {
		return random.nextInt(numberOfCharacters[4]);
	}
}

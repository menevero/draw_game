package com.owlet.game.draw.data;

import com.owlet.game.draw.ui.InvisibleJButton;

public class Character implements Collectable {
	//============================================
	//
	//		Variables
	//
	//============================================
	
	private int ID;
	private String name;
	private String flavorText;
	private String[] imagePath;
	/* CharacterListBearer 객체에서 등급별로 캐릭터 객체를 가지고 있을 arrayList가 있기 때문에 이 변수를 없앨 것도 고려 */
	private int rarity;
	
	private int serialNumber;
	private int ownerID;
	
	private InvisibleJButton characterCard;
	
	
	
	
	//============================================
	//
	//		Constructors
	//
	//============================================
	
	/**
	 * @param idValue - 캐릭터 고유 아이디값
	 * @param name - 캐릭터 이름
	 * @param flavorText - 캐릭터 설명
	 * @param rarity - 캐릭터 희귀도
	 * @param serialNumber - 캐릭터 객체 아이디값
	 */
	public Character(int ID, String name, String flavorText, int rarity, int serialNumber, int ownerID, String[] imagePath) {
		this.ID = ID;
		this.name = name;
		this.flavorText = flavorText;
		this.rarity = rarity;
		this.serialNumber = serialNumber;
		this.ownerID = ownerID;
		this.imagePath = imagePath;
		
//		this.characterCard = new InvisibleJButton(this.image);
	}
	
	/* 복사 생성자! */
	public Character(Character target, int serialNumber, int ownerID) {
		this.ID = target.ID;
		this.name = target.name;
		this.flavorText = target.flavorText;
		this.rarity = target.rarity;
		this.serialNumber = serialNumber;
		this.ownerID = ownerID;
		this.imagePath = target.imagePath;
		
//		this.characterCard = new InvisibleJButton(target.imagePath);
	}
	
	
	
	
	//============================================
	//
	//		Utility
	//
	//============================================
	
	/*
	 * 이 캐릭터가 이미 수집되었으면 true, 아니면 false 반환
	 */
	@Override
	public boolean isCollected() {
		//TODO db연동시 구현?
		return false;
	}
	
	
	
	
	//============================================
	//
	//		Accessors
	//
	//============================================
	
	public InvisibleJButton getCharacterCard() {
		return this.characterCard;
	}
	
	public String[] getImagePath() {
		return this.imagePath;
	}
	
	public void setCharacterName(String newName) {
		this.name = newName;
	}
	
	public String getCharacterName() {
		return this.name;
	}
	
	public void setFlavorText(String newFlavorText) {
		this.flavorText = newFlavorText;
	}
	
	public String getFlavorText() {
		return this.flavorText;
	}
	
	@Override
	public void setRarity(int newRarity) {
		this.rarity = newRarity;
	}
	
	@Override
	public int getRarity() {
		return this.rarity;
	}
}

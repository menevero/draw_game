package com.owlet.game.draw.data;

import com.owlet.game.draw.ui.ImageIconButton;

/**
 * 기본적인 캐릭터 클래스입니다.<br>
 * 이 클래스를 인스턴스화하여 새로운 캐릭터를 생성합니다.
 * 
 * @version 1.0
 * @since 17-09-21
 */
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
	
	private ImageIconButton characterCard;
	
	
	
	
	//============================================
	//
	//		Constructors
	//
	//============================================
	
	/**
	 * @param int ID - 캐릭터 고유 아이디값
	 * @param String name - 캐릭터 이름
	 * @param String flavorText - 캐릭터 설명
	 * @param int rarity - 캐릭터 희귀도
	 * @param int serialNumber - 캐릭터 객체 아이디값
	 * @param int ownerID - 캐릭터 소유주의 아이디값
	 * @param String[] imagePath - 이 캐릭터의 이미지 경로값을 가지고 있는 문자열 배열
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
	
	public ImageIconButton getCharacterCard() {
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

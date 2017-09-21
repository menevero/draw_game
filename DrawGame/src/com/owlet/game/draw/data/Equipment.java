package com.owlet.game.draw.data;

public class Equipment implements Equippable, Collectable {
	private String name;
	private int rarity;	
	
	/*
	 * 이 장비가 이미 수집된 물건이면 true, 아니면 false 반환
	 */
	@Override
	public boolean isCollected() {
		//TODO 
		return false;
	}
	
	//============================================
	//
	//		Accessors
	//
	//============================================
	
	public void setEquipmentName(String newName) {
		this.name = newName;
	}
	
	public String getEquipmentName() {
		return this.name;
	}
	
	@Override
	public boolean equip() {
		return false;
	}
	
	@Override
	public boolean unequip() {
		return false;
	}
	
	@Override
	public void setRarity(int newRarity) {
		this.rarity = newRarity;
	}
	
	@Override
	public int getRarity() {
		return this.rarity;
	}

	@Override
	public int getEquipmentType() {
		// TODO Auto-generated method stub
		return 0;
	}
}

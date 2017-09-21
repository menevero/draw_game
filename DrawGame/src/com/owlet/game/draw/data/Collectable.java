package com.owlet.game.draw.data;

public interface Collectable {
	public boolean isCollected();
	public void setRarity(int newRarity);
	public int getRarity();
}

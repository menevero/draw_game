package com.owlet.game.draw.data;

public class CharacterTable {
	public static final Character CHARS_NULL = new Character(0, "NULL_CHARACTER", "NULL.", 0, 0, 0, Images.CHARACTER_NULL_CHARACTER);
	
	//int idValue, String name, String flavorText, int rarity, String serialNumber, 이미지 리스트
	/* Inferior - Normal - Magic - Rare - Unique */
	public Character[] CHARS_INFERIOR = new Character[1];
	public Character[] CHARS_NORMAL = new Character[1];
	public Character[] CHARS_MAGIC = new Character[1];
	public Character[] CHARS_RARE = new Character[1];
	public Character[] CHARS_UNIQUE = new Character[1];

	public CharacterTable() {
		this.CHARS_INFERIOR[0] = new Character(5, "랭크5 샘플 캐릭터", "말을 잘 듣습니다.", 5, 0, 0, Images.CHARACTER_SAMPLE);
		this.CHARS_NORMAL[0] = new Character(4, "랭크4 샘플 캐릭터", "말을 잘 듣습니다.", 4, 0, 0, Images.CHARACTER_SAMPLE);
		this.CHARS_MAGIC[0] = new Character(3, "랭크3 샘플 캐릭터", "말을 잘 듣습니다.", 3, 0, 0, Images.CHARACTER_SAMPLE);
		this.CHARS_RARE[0] = new Character(2, "랭크2 샘플 캐릭터", "말을 잘 듣습니다.", 2, 0, 0, Images.CHARACTER_SAMPLE);
		this.CHARS_UNIQUE[0] = new Character(1, "랭크1 샘플 캐릭터", "말을 잘 듣습니다.", 1, 0, 0, Images.CHARACTER_SAMPLE);
	}
}

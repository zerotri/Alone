package com.amarant;

import java.awt.Image;

public class Block {

	private int type;
	private Image img;

	public Block(int type) {
		this.type = type;
		img = TexturePack.getTexture(type);
	}

	public int getType() {
		return type;
	}

	public Image getImage() {
		return img;
	}
}

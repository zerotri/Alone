package com.amarant;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

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

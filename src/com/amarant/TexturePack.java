package com.amarant;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class TexturePack {

	private static final int TYPE_AIR = 0xFFFFFFFF;
	private static final int TYPE_GROUND_BLACK = 0xFF000000;
	private static BufferedImage pack;

	public TexturePack() {
		try {
			pack = ImageIO.read(Level.class.getResource("level/texture.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public Image getTexture(int type) {
		int w = 32;
		int h = 32;

		switch (type) {
		case TYPE_AIR:
			return pack.getSubimage(0, 0, w, h);
		case TYPE_GROUND_BLACK:
			return pack.getSubimage(32, 0, w, h);
		default:
			return null;
		}

	}
}

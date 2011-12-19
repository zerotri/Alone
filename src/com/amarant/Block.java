package com.amarant;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Block {

	private static final int TYPE_AIR = 0xFFFFFFFF;
	private static final int TYPE_GROUND_BLACK = 0xFF000000;

	private int type;
	private Image img;

	public Block(int type) {
		this.type = type;
		switch (type) {
		case TYPE_AIR:
			img = loadTile(0);
			break;
		case TYPE_GROUND_BLACK:
			img = loadTile(1);
			break;
		default:
			img = null;
			break;
		}
	}

	public int getType() {
		return type;
	}

	private Image loadTile(int num) {
		int w = 16;
		int h = 16;

		try {
			BufferedImage img = ImageIO.read(Level.class.getResource("level/texture.png"));
			switch (num) {
			case 0:
				return img.getSubimage(0, 0, w, h);
			case 1:
				return img.getSubimage(16, 0, w, h);
			default:
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Image getImage() {
		return img;
	}
}

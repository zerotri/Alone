package com.amarant;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Level {
	private Block[] grid;
	private int gridwidth;
	private int gridheight;
	private int xMod = 0;
	private int yMod = 0;

	public Level(String name) {
		// Load level from file "name"
		new TexturePack();
		loadLevel(name);
		System.out.println("Level loaded");
	}

	public void tick() {
		// xMod = (xMod + 1) % 30;
		// yMod = (yMod + 1) % 30;
	}

	public void render(Graphics g) {
		for (int x = 0; x < gridwidth; x++) {
			for (int y = 0; y < gridheight; y++) {
				g.drawImage(grid[x * gridwidth + y].getImage(), (x + xMod) * 32, (y + yMod) * 32, null);

			}
		}
	}

	private void loadLevel(String name) {
		try {

			BufferedImage img = ImageIO.read(Level.class.getResource("level/" + name + ".png"));

			int w = img.getWidth();
			int h = img.getHeight();
			gridwidth = w;
			gridheight = h;
			grid = new Block[w * h];

			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					grid[x * w + y] = new Block(img.getRGB(x, y));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

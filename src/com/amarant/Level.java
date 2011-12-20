package com.amarant;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Level {
	private Block[] grid;
	private int gridwidth;
	private int gridheight;
	private int xMod;
	private int yMod;
	private boolean jumping;
	private int jumpHeight;

	public Level(String name) {
		// Load level from file "name"
		xMod = 0;
		yMod = 0;
		jumping = false;
		new TexturePack();
		loadLevel(name);
		System.out.println("Level loaded");
	}

	public void tick(boolean keys[]) {
		boolean left = keys[KeyEvent.VK_LEFT];
		boolean right = keys[KeyEvent.VK_RIGHT];
		boolean up = keys[KeyEvent.VK_UP];
		boolean down = keys[KeyEvent.VK_DOWN];
		boolean jump = keys[KeyEvent.VK_SPACE];
		if (left)
			xMod++;
		if (right)
			xMod--;
		if (up)
			yMod++;
		if (down)
			yMod--;
		Random rand = new Random();
		// xMod = rand.nextInt(4) > 1 ? rand.nextInt(2) * -1 + xMod :
		// rand.nextInt(2) + xMod;
		// yMod = rand.nextInt(4) > 1 ? rand.nextInt(2) * -1 + yMod :
		// rand.nextInt(2) + yMod;
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

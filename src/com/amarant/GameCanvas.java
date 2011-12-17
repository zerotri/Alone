package com.amarant;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GameCanvas extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	int width = 800;
	int height = 600;
	public long period = 10;
	private Level level;
	
	public BufferStrategy buf;
	public Graphics g;
	private Thread t;
	
	public GameCanvas() {
		this.setIgnoreRepaint(true);
		this.setBounds(0, 0, width, height);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		level = new Level("Start.lev");
	}
	
	public void addNotify() {
		super.addNotify();
		this.createBufferStrategy(2);
		this.buf = this.getBufferStrategy();
		requestFocus();
		startGame();
	}
	
	public void startGame() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		while (true) {
			long beginTime = System.currentTimeMillis();
			
			Update();
			Render();
			Draw();
			
			long timeTaken = System.currentTimeMillis() - beginTime;
			long sleepTime = period - timeTaken;
			
			try {
				t.sleep(sleepTime);
			}
			catch (Exception e) {
				
			}
			
		}
	}
	
	public void Update(){
		// Game logic goes here
		level.tick();
	}
	
	public void Render(){
		// Draws to the back buffer
		g = buf.getDrawGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		
		// Paint stuff
		level.Render(g);
	}
	
	public void Draw(){
		if (!buf.contentsLost()){
			buf.show();
		}
		
		if (g != null) {
			g.dispose();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.amarant;

import javax.swing.JFrame;

/**
 * @author blacRose, virodoran, zerotri
 *
 */
public class GameFrame {
	
	public static void main(String args[]){
		
		int width = 800;
		int height = 600;
		
		JFrame frame = new JFrame("Alone");
		
		frame.setIgnoreRepaint(true);
		frame.setBounds(0, 0, width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameCanvas game = new GameCanvas();
		
		frame.add(game);
		
		frame.setVisible(true);
	}
}

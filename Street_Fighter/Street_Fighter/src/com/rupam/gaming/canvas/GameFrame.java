 package com.rupam.gaming.canvas;

import java.io.IOException;

import javax.swing.JFrame;

import com.rupam.gaming.utils.GameConstants;



public class GameFrame extends JFrame implements GameConstants  {
	
	public GameFrame() throws IOException  {
		setResizable(false);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(GWIDTH, GHEIGHT);
		setLocationRelativeTo(null);
		Board board = new Board();
		add(board); // Board added in Frame.
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
			try {
				GameFrame obj = new GameFrame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}

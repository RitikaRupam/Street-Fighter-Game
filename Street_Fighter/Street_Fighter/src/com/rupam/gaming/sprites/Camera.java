package com.rupam.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.rupam.gaming.canvas.Board;

public class Camera extends Sprite {
	
	private int moveBlock = 0;
	
	public Camera() {
		x = 11;
		y = 300;
		w = 1400;
		h = 900;
		try {
			image = ImageIO.read(Board.class.getResource("bg.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void move() {
		outOfScreen();
		if(moveBlock == 1) {
			speed = 10;
		}
		else if (moveBlock == 2) {
			speed = -10;
		}
		
		x = x + speed;
		
	}
	
	public void outOfScreen() {
		System.out.println("Value of x is "+x);
		if(x<=10 ) {
			moveBlock = 1; // No Move on Left
		}
		else if (x>=3000-1400) {
			moveBlock = 2; // No Move on Right
		}
		else {
			moveBlock =0; // Allow Both
		}
//		if(x>=3000-1400 || x<=10) {
//			speed = 0;
//		}
		
	}

	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		BufferedImage subImage = image.getSubimage(x, y, w, h);
		return subImage;
	}

}

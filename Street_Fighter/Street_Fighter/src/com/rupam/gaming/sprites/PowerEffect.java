package com.rupam.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PowerEffect extends Sprite {
	
	PowerEffect(int x, int y, BufferedImage img){
		this.image = img;
		
		this.x = x;
		this.y = y;
		w = 80;
		h = 80;		
		speed = 50;
		
	}

	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		return  image.getSubimage(11, 3110, 62, 37);
	}
	
	public void printPower(Graphics pen) {
		pen.drawImage(defaultImage(),x,y,w,h, null);
		move();
	}
	
	
}

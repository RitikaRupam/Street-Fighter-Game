package com.rupam.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class RyuPlayer extends Sprite  {
	private BufferedImage walkImages [] = new BufferedImage[6];

	private BufferedImage standingImages [] = new BufferedImage[8];
	private BufferedImage kickImages [] = new BufferedImage[6];
	private BufferedImage punchImages [] = new BufferedImage[6];
	private BufferedImage powerEffectImages [] = new BufferedImage[5];
	public RyuPlayer() throws IOException {
		x = 100;
		
		y = FLOOR - h;
		speed = 0;
		currentMove = STANDING;
		image = ImageIO.read(RyuPlayer.class.getResource(RYU_IMAGE));
		loadWalkImages();
		loadStandingImages();
		loadKickImages();
		loadPunchImages();
		loadPowerEffectImages();
	}
	
	
	public void jump() {
		if(!isJump) {
		force = DEFAULT_FORCE;
		y = y + force;
		isJump = true;
		}
	}
	
	public void fall() {
		if(y>= (FLOOR - h)) {
			isJump = false;
			return ;
		}
		force = force + GRAVITY;
		y = y + force;
	}
	
	private void loadPowerEffectImages() {
		powerEffectImages[0] = image.getSubimage(5, 1808, 115, 99);
		powerEffectImages[1] = image.getSubimage(128, 1807, 114, 97);
		powerEffectImages[2] = image.getSubimage(252, 1808, 122, 99);
		powerEffectImages[3] = image.getSubimage(385, 1813, 99, 92);
		powerEffectImages[4] = image.getSubimage(493, 1812, 143, 92);
	}
	
	private void loadWalkImages() {
		walkImages[0]  = image.getSubimage(60, 236,77,98);
		walkImages[1]  = image.getSubimage(142, 235,77,98);
		walkImages[2]  = image.getSubimage(225,236,60,98);
		walkImages[3]  = image.getSubimage(304, 233,58,98);
		walkImages[4]  = image.getSubimage(377, 234,59,99);
		walkImages[5]  = image.getSubimage(453, 239,65,96);
	}
	
	private void loadStandingImages() {
		standingImages[0] = image.getSubimage(14, 4, 73, 106);
		standingImages[1] = image.getSubimage(87, 4, 68, 107);
		standingImages[2] = image.getSubimage(164, 4, 72, 108);
		standingImages[3] = image.getSubimage(241,1,72,110);
		standingImages[4] = image.getSubimage(321, 6, 70, 107);
		standingImages[5] = image.getSubimage(396, 4, 61, 105);
		standingImages[6] = image.getSubimage(464, 4, 62, 109);
		standingImages[7] = image.getSubimage(534, 4, 63, 109);
	}
	
	private void loadKickImages() {
		kickImages[0] = image.getSubimage(38, 1043, 69, 103);
		kickImages[1] = image.getSubimage(120,1043,69,98);
		kickImages[2] = image.getSubimage(198, 1040, 122, 104);
		kickImages[3] = image.getSubimage(328, 1046, 72, 99);
		kickImages[4] = image.getSubimage(409, 1046, 69, 100);
		kickImages[5] = image.getSubimage(482, 1045, 92, 104);
				
	}
	private void loadPunchImages() {
		punchImages[0] = image.getSubimage(26, 819, 70, 102);
		punchImages[1] = image.getSubimage(106, 821, 72, 100);
		punchImages[2] = image.getSubimage(187, 821, 115, 100);
		punchImages[3] = image.getSubimage(310, 819, 78, 99);
		punchImages[4] = image.getSubimage(402, 816, 108, 102);
		punchImages[5] = image.getSubimage(517, 821, 79, 100);
	}
	
	private BufferedImage powerEffectImage() {
		if(imageIndex>4) {
			imageIndex=0;
			currentMove = STANDING;
		}
		BufferedImage img = powerEffectImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage walkImage() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove = STANDING;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++;
		return img;
	}
	private BufferedImage kickImage() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove = STANDING;
			isAttacking = false;
		}
		BufferedImage img = kickImages[imageIndex];
		imageIndex++;
		return img;
	}
	private BufferedImage punchImage() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove = STANDING;
			isAttacking = false;
		}
		BufferedImage img = punchImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage standingImage() {
		if(imageIndex>7) {
			imageIndex=0;
		}
		BufferedImage img = standingImages[imageIndex];
		imageIndex++;
		return img;
	}
	private ArrayList<PowerEffect> powers = new ArrayList<>();
	
	public ArrayList<PowerEffect> getPowers() {
		return powers;
	}
	public void addPower() {
		powers.add(new PowerEffect(x+w, y + h/2-40,image ));
	}
	
	@Override
	public BufferedImage defaultImage() {
		 if (currentMove == WALK) {
			return walkImage();
		}
		else if(currentMove == PUNCH) {
			return punchImage();
		}
		else if (currentMove == KICK) {
			return kickImage();
		}
		else if (currentMove == POWER_EFFECT) {
			return powerEffectImage();
		} else
		
			return standingImage();
		
		 
		
	}
	
	

}

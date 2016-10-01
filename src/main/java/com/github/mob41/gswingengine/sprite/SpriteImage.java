package com.github.mob41.gswingengine.sprite;

import java.awt.image.BufferedImage;

public class SpriteImage {

	private final BufferedImage image;
	
	public SpriteImage(BufferedImage image){
		this.image = image;
	}
	
	public BufferedImage getImage(){
		return image;
	}

}

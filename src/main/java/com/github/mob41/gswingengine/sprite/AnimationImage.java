package com.github.mob41.gswingengine.sprite;

import java.awt.image.BufferedImage;

public class AnimationImage extends SpriteImage {

	private final int delay;
	
	public AnimationImage(SpriteImage image){
		super(image.getImage());
		this.delay = -1;
	}
	
	public AnimationImage(BufferedImage image){
		this(image, -1);
	}
	
	public AnimationImage(BufferedImage image, int delay) {
		super(image);
		this.delay = delay;
	}
	
	public int getDelay(){
		return delay;
	}

}

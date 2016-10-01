package com.github.mob41.gswingengine.sprite;

import java.awt.image.BufferedImage;

public class SpriteAnimationThread extends Thread{
	
	private final AnimationImage[] images;
	
	private final int defaultDelay;
	
	public SpriteAnimationThread(SpriteImage[] images, int defaultDelay){
		this(convert(images), defaultDelay);
	}
	
	public SpriteAnimationThread(AnimationImage[] images, int defaultDelay){
		this.images = images;
		this.defaultDelay = defaultDelay;
	}
	
	@Override
	public void run(){
		
	}
	
	public static AnimationImage[] convert(BufferedImage[] images){
		SpriteImage[] out = new SpriteImage[images.length];
		for (int i = 0; i < out.length; i++){
			out[i] = new SpriteImage(images[i]);
		}
		return convert(out);
	}
	
	public static AnimationImage[] convert(SpriteImage[] images){
		AnimationImage[] out = new AnimationImage[images.length];
		for (int i = 0; i < out.length; i++){
			out[i] = new AnimationImage(images[i]);
		}
		return out;
	}
	
}

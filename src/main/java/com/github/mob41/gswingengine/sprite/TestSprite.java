package com.github.mob41.gswingengine.sprite;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.mob41.gswingengine.ui.GamePanel;

public class TestSprite extends Sprite {
	
	private static SpriteImage frame = new SpriteImage(SpriteManager.getImageFromClass("icon.png"));

	public TestSprite(GamePanel panel, String name, Point location) {
		super(panel, name, location);
		setDefaultFrame(frame);
		setFrame(frame);
		
		AnimationImage[] frames = new AnimationImage[30];
		AnimationImage fr1 = new AnimationImage(SpriteManager.getImageFromClass("one.png"));
		AnimationImage fr2 = new AnimationImage(SpriteManager.getImageFromClass("two.png"));
		
		int i = 0;
		for (i = 0; i < 15; i++){
			frames[i] = fr1;
		}
		for (; i < 30; i++){
			frames[i] = fr2;
		}
		
		setWalkFrames(frames);
	}
	
	@Override
	public void onKeyPressed(KeyEvent arg0){
		if (arg0.getKeyCode() == KeyEvent.VK_UP){
			System.out.println("Up");
			moveUp(25);
		} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN){
			System.out.println("Down");
			moveDown(25);
		} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT){
			System.out.println("Left");
			moveLeft(25);
		} else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT){
			System.out.println("Right");
			moveRight(25);
		}
	}
	
	@Override
	public void onMousePressedOverThis(MouseEvent arg0){
		System.out.println("Pressed over this");
		setCenterPos(arg0.getPoint());
	}
}

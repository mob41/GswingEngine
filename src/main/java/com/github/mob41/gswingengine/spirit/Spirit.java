package com.github.mob41.gswingengine.spirit;

import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class Spirit {

	private String name;
	
	private Point location;
	
	private BufferedImage frame;
	
	public Spirit(String name, Point location, BufferedImage frame){
		this.name = name;
		this.location = location;
		this.frame = frame;
	}
	
	public String getName(){
		return name;
	}
	
	public Point getLocation(){
		return location;
	}
	
	public BufferedImage getFrame(){
		return frame;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setLocation(Point point){
		this.location = point;
	}
	
	public void setFrame(BufferedImage frame){
		this.frame = frame;
	}
	
	public int getLeftX(){
		return location.x;
	}
	
	public int getRightX(){
		return location.x + frame.getWidth();
	}
	
	public int getUpY(){
		return location.y;
	}
	
	public int getDownY(){
		return location.y + frame.getWidth();
	}
	
	public boolean isCollisionWith(Spirit anotherSpirit){
		return
	}
	
	public void moveLeft(){
		
	}
}

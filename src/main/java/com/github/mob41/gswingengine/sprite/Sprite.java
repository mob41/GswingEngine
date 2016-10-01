package com.github.mob41.gswingengine.sprite;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.github.mob41.gswingengine.ui.GamePanel;

public abstract class Sprite {

	private String name;
	
	private Point location;
	
	private SpriteImage frame = null;
	
	private SpriteImage defaultFrame = null;
	
	private GamePanel panel;
	
	private AnimationImage walkFrames[] = null;
	
	private AnimationImage walkLeftFrames[] = null;
	
	private AnimationImage walkRightFrames[] = null;
	
	private AnimationImage walkUpFrames[] = null;
	
	private AnimationImage walkDownFrames[] = null;
	
	private AnimationImage stopFrames[] = null;
	
	private AnimationImage appearFrames[] = null;
	
	private AnimationImage disappearFrames[] = null;
	
	public Sprite(GamePanel panel, String name, Point location){
		if (location == null){
			System.err.println("GswingEngine: SpiritManager: Location cannot be null.");
			System.exit(-1);
		}
		this.panel = panel;
		this.name = name;
		this.location = location;
	}
	
	public GamePanel getGamePanel(){
		return panel;
	}
	
	public String getName(){
		return name;
	}
	
	public Point getLocation(){
		return location;
	}
	
	public SpriteImage getFrame(){
		return frame;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setLocation(Point point){
		this.location = point;
	}
	
	public void setCenterPos(Point point){
		setLocation(new Point(point.x - getWidth() / 2, point.y - getHeight() / 2));
	}
	
	public void setWalkFrames(AnimationImage[] frames){
		this.walkFrames = frames;
	}
	
	public void setFrame(SpriteImage frame){
		this.frame = frame;
	}
	
	public void setDefaultFrame(SpriteImage frame){
		this.defaultFrame = frame;
	}
	
	public int getWidth(){
		return frame.getImage().getWidth();
	}
	
	public int getHeight(){
		return frame.getImage().getHeight();
	}
	
	public int getLeftX(){
		return location.x;
	}
	
	public int getRightX(){
		return location.x + frame.getImage().getWidth();
	}
	
	public int getUpY(){
		return location.y;
	}
	
	public int getDownY(){
		return location.y + frame.getImage().getWidth();
	}
	
	public Point getPos(){
		return new Point(getLeftX(), getUpY());
	}
	
	public Point getCenterPos(){
		return new Point((getLeftX() + getRightX()) / 2, (getUpY() + getDownY()) / 2);
	}
	
	public boolean isOverlapping(Sprite anotherSpirit){
		return isInArea(getLeftX(), getRightX(), getUpY(), getDownY(), anotherSpirit.location);
	}
	
	public boolean isCollisionWith(Sprite anotherSpirit){
		return isInArea(getLeftX(), getRightX(), getUpY(), getDownY(), anotherSpirit.location);
	}
	
	public void moveLeft(int percentage){
		if (walkFrames == null){
			location.x -= defaultFrame.getImage().getWidth() * percentage / 100 * 0.5;
		} else {
			location.x -= defaultFrame.getImage().getWidth() * percentage / 100 * 0.5;
			new Thread(){
				public void run(){
					for (int i = 0; i < walkFrames.length; i++){
						setFrame(walkFrames[i]);
						try {
							sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					setFrame(defaultFrame);
				}
			}.start();
		}
	}
	
	public void moveRight(int percentage){
		if (walkFrames == null){
			location.x += defaultFrame.getImage().getWidth() * percentage / 100 * 0.5;
		} else {
			for (int i = 0; i < walkFrames.length; i++){
				setFrame(walkFrames[i]);
				location.x += defaultFrame.getImage().getWidth() * percentage / 100 * 0.5 / walkFrames.length;
			}
			setFrame(defaultFrame);
		}
	}
	
	public void moveUp(int percentage){
		location.y -= frame.getImage().getHeight() * percentage / 100 * 0.5;
	}
	
	public void moveDown(int percentage){
		location.y += frame.getImage().getHeight() * percentage / 100 * 0.5;
	}
	
//Events
	
	public void onKeyPressed(KeyEvent arg0){
		return;
	}
	
	public void onKeyReleased(KeyEvent arg0){
		return;
	}
	
	public void onKeyTyped(KeyEvent arg0){
		return;
	}
	
	public void onMouseDragged(MouseEvent arg0) {
		return;
	}

	public void onMouseDraggedOverThis(MouseEvent arg0) {
		return;
	}

	public void onMouseMoved(MouseEvent arg0) {
		return;
	}

	public void onMouseMovedOverThis(MouseEvent arg0) {
		return;
	}

	public void onMouseClicked(MouseEvent e) {
		return;
	}

	public void onMouseClickedOverThis(MouseEvent e) {
		return;
	}

	public void onMouseEntered(MouseEvent e) {
		return;
	}

	public void onMouseEnteredOverThis(MouseEvent e) {
		return;
	}

	public void onMouseExited(MouseEvent e) {
		return;
	}

	public void onMouseExitedOverThis(MouseEvent e) {
		return;
	}

	public void onMousePressed(MouseEvent e) {
		return;
	}

	public void onMousePressedOverThis(MouseEvent e) {
		return;
	}

	public void onMouseReleased(MouseEvent e) {
		return;
	}

	public void onMouseReleasedOverThis(MouseEvent e) {
		return;
	}
	
	public boolean isPointOverlappingThis(Point location){
		return getLeftX() > location.x &&
				getRightX() < location.x &&
				getUpY() > location.y &&
				getDownY() < location.y;
	}
	
	public static boolean isInArea(int areaLeftX, int areaRightX, int areaUpY, int areaDownY, Point location){
		return areaLeftX < location.x &&
				areaRightX > location.x &&
				areaUpY < location.y &&
				areaDownY > location.y;
	}
	
	public final void drawThis(Graphics g){
		if (frame == null){
			//Skip render if null
			return;
		}
		g.drawImage(frame.getImage(), getLeftX(), getUpY(), null);
	}
}

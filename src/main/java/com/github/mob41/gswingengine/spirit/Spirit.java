package com.github.mob41.gswingengine.spirit;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public abstract class Spirit {

	private String name;
	
	private Point location;
	
	private BufferedImage frame;
	
	public Spirit(String name, Point location){
		if (location == null){
			System.err.println("GswingEngine: SpiritManager: Location cannot be null.");
			System.exit(-1);
		}
		this.name = name;
		this.location = location;
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
	
	public void setCenterPos(Point point){
		setLocation(new Point(point.x - getWidth() / 2, point.y - getHeight() / 2));
	}
	
	public void setFrame(BufferedImage frame){
		this.frame = frame;
	}
	
	public int getWidth(){
		return frame.getWidth();
	}
	
	public int getHeight(){
		return frame.getHeight();
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
	
	public Point getCenterPos(){
		return new Point((getLeftX() + getRightX()) / 2, (getUpY() + getDownY()) / 2);
	}
	
	public boolean isOverlapping(Spirit anotherSpirit){
		return isInArea(getLeftX(), getRightX(), getUpY(), getDownY(), anotherSpirit.location);
	}
	
	public boolean isCollisionWith(Spirit anotherSpirit){
		return isInArea(getLeftX(), getRightX(), getUpY(), getDownY(), anotherSpirit.location);
	}
	
	public void moveLeft(int percentage){
		location.x -= frame.getWidth() * percentage / 100 * 0.5;
	}
	
	public void moveRight(int percentage){
		location.x += frame.getWidth() * percentage / 100 * 0.5;
	}
	
	public void moveUp(int percentage){
		location.y -= frame.getHeight() * percentage / 100 * 0.5;
	}
	
	public void moveDown(int percentage){
		location.y += frame.getHeight() * percentage / 100 * 0.5;
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
		return areaLeftX > location.x &&
				areaRightX < location.x &&
				areaUpY > location.y &&
				areaDownY < location.y;
	}
	
	public final void drawThis(Graphics g){
		g.drawImage(frame, getLeftX(), getUpY(), null);
	}
}

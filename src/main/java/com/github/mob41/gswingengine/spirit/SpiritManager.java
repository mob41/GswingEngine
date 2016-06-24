package com.github.mob41.gswingengine.spirit;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class SpiritManager {
	
	public static final int DEFAULT_MAXIMUM = 50;
	
	private static SpiritManager spiritManager = new SpiritManager(50);
	
	private List<Spirit> spiritList;

	public SpiritManager(int max){
		spiritList = new ArrayList<Spirit>(max);
	}
	
	public static SpiritManager getInstance(){
		return spiritManager;
	}
	
	public List<Spirit> getList(){
		return spiritList;
	}
	
	public void addSpirit(Spirit spirit){
		spiritList.add(spirit);
	}
	
	public void removeSpirit(int index){
		spiritList.remove(index);
	}
	
	public Spirit getSpirit(int index){
		return spiritList.get(index);
	}
	
	public void callOnKeyPressed(KeyEvent arg0){
		for (Spirit spirit : spiritList){
			spirit.onKeyPressed(arg0);
		}
	}
	
	public void callOnKeyReleased(KeyEvent arg0){
		for (Spirit spirit : spiritList){
			spirit.onKeyReleased(arg0);
		}
	}
	
	public void callOnKeyTyped(KeyEvent arg0){
		for (Spirit spirit : spiritList){
			spirit.onKeyTyped(arg0);
		}
	}
	
	public void callOnMouseDragged(MouseEvent arg0) {
		for (Spirit spirit : spiritList){
			spirit.onMouseDragged(arg0);
			if (spirit.isPointOverlappingThis(arg0.getPoint())){
				spirit.onMouseDraggedOverThis(arg0);
			}
		}
	}

	public void callOnMouseMoved(MouseEvent arg0) {
		for (Spirit spirit : spiritList){
			spirit.onMouseMoved(arg0);
			if (spirit.isPointOverlappingThis(arg0.getPoint())){
				spirit.onMouseMovedOverThis(arg0);
			}
		}
	}

	public void callOnMouseClicked(MouseEvent e) {
		for (Spirit spirit : spiritList){
			spirit.onMouseClicked(e);
			if (spirit.isPointOverlappingThis(e.getPoint())){
				spirit.onMouseClickedOverThis(e);
			}
		}
	}

	public void callOnMouseEntered(MouseEvent e) {
		for (Spirit spirit : spiritList){
			spirit.onMouseEntered(e);
			if (spirit.isPointOverlappingThis(e.getPoint())){
				spirit.onMouseEnteredOverThis(e);
			}
		}
	}

	public void callOnMouseExited(MouseEvent e) {
		for (Spirit spirit : spiritList){
			spirit.onMouseExited(e);
			if (spirit.isPointOverlappingThis(e.getPoint())){
				spirit.onMouseExitedOverThis(e);
			}
		}
	}

	public void callOnMousePressed(MouseEvent e) {
		for (Spirit spirit : spiritList){
			spirit.onMousePressed(e);
			if (spirit.isPointOverlappingThis(e.getPoint())){
				spirit.onMousePressedOverThis(e);
			}
		}
	}

	public void callOnMouseReleased(MouseEvent e) {
		for (Spirit spirit : spiritList){
			spirit.onMouseReleased(e);
			if (spirit.isPointOverlappingThis(e.getPoint())){
				spirit.onMouseReleasedOverThis(e);
			}
		}
	}
	
	public static BufferedImage getImageFromClass(String fileName){
		try {
			return ImageIO.read(TestSpirit.class.getClassLoader().getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

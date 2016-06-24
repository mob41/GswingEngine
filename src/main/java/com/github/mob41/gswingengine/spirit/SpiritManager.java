package com.github.mob41.gswingengine.spirit;

import java.awt.event.KeyEvent;
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
	
	public static BufferedImage getImageFromClass(String fileName){
		try {
			return ImageIO.read(TestSpirit.class.getClassLoader().getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

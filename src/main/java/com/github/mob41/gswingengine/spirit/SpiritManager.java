package com.github.mob41.gswingengine.spirit;

import java.util.ArrayList;
import java.util.List;

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
}

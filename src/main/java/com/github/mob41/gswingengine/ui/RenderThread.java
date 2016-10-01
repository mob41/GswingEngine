package com.github.mob41.gswingengine.ui;

import java.util.concurrent.TimeUnit;

public class RenderThread extends Thread {
	
	private final GamePanel gamePanel;
	
	private long time_start = 0;
	
	private long time_now = 0;
	
	private int fps = 0;
	
	private int frame_rendered = 0;
	
	private boolean running = false;
	
	public RenderThread(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}

	@Override
	public void run(){
		if (!running){
			running = true;
			time_start = System.currentTimeMillis();
			while (running){
				gamePanel.repaint();
				frame_rendered++;
				time_now = System.currentTimeMillis();
				float sec = (time_now - time_start) / 1000;
				fps = (int) (frame_rendered / sec);
			}
			running = false;
		}
	}
	
	public void stopRender(){
		running = false;
		fps = 0;
	}
	
	public int getFPS(){
		return fps;
	}
}

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
			time_start = System.nanoTime();
			while (running){
				gamePanel.repaint();
				frame_rendered++;
				time_now = System.nanoTime();
				int sec = (int) TimeUnit.NANOSECONDS.toSeconds(time_now - time_start);
				fps = (int) (frame_rendered / (sec == 0 ? 1 : sec));
			}
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

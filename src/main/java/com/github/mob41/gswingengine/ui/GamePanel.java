package com.github.mob41.gswingengine.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.github.mob41.gswingengine.input.KeyHandler;
import com.github.mob41.gswingengine.spirit.Spirit;
import com.github.mob41.gswingengine.spirit.SpiritManager;

public class GamePanel extends JPanel {
	
	private RenderThread thread;

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		System.err.println("I am adding a HANDLER!");
		System.err.println("HANDLER ADDED!");
		System.err.println("STARTING THREAD!!");
		thread = new RenderThread(this);
		thread.start();
		System.err.println("Thread STARTED!");
	}
	
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, getWidth(), getHeight());
		for(Spirit spirit : SpiritManager.getInstance().getList()){
			spirit.drawThis(g2);
		}
	}

}

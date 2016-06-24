package com.github.mob41.gswingengine.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.mob41.gswingengine.input.KeyHandler;
import com.github.mob41.gswingengine.spirit.Spirit;
import com.github.mob41.gswingengine.spirit.SpiritManager;

public class GamePanel extends JPanel {
	
	private RenderThread thread;
	
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public GamePanel(JFrame frame) {
		frame.addKeyListener(new KeyHandler());
		thread = new RenderThread(this);
		thread.start();
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

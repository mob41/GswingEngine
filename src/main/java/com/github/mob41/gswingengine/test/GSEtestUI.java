package com.github.mob41.gswingengine.test;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;

import com.github.mob41.gswingengine.input.InputHandler;
import com.github.mob41.gswingengine.sprite.SpriteManager;
import com.github.mob41.gswingengine.sprite.TestSprite;
import com.github.mob41.gswingengine.ui.GamePanel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class GSEtestUI {

	private boolean swt = false;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GSEtestUI window = new GSEtestUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GSEtestUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel gamePanel = new GamePanel(frame);
		gamePanel.setBackgroundRepeat(GamePanel.BG_NO_REPEAT);
		gamePanel.setBackgroundImage(SpriteManager.getImageFromClass("tile.fw.png"));
		frame.getContentPane().add(gamePanel);
		
		TestSprite ts = new TestSprite(gamePanel, "Yo", new Point(0, 0));
		SpriteManager.getInstance().addSpirit(ts);
	}

}

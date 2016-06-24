package com.github.mob41.gswingengine.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.mob41.gswingengine.input.InputHandler;
import com.github.mob41.gswingengine.spirit.Spirit;
import com.github.mob41.gswingengine.spirit.SpiritManager;

public class GamePanel extends JPanel {
	
	public static final int BG_NO_REPEAT = 0;
	
	public static final int BG_REPEAT_X = 1;
	
	public static final int BG_REPEAT_Y = 2;
	
	public static final int BG_REPEAT_ALL = 3;
	
	private RenderThread thread;
	
	private BufferedImage bg = null;
	
	private int BG_REPEAT = BG_NO_REPEAT;
	
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public GamePanel(JFrame frame) {
		InputHandler ih = new InputHandler(SpiritManager.getInstance());
		frame.addKeyListener(ih);
		frame.addFocusListener(ih);
		frame.addMouseListener(ih);
		frame.addMouseMotionListener(ih);
		this.frame = frame;
		thread = new RenderThread(this);
		thread.start();
	}
	
	public int getBackgroundRepeat(){
		return BG_REPEAT;
	}
	
	public void setBackgroundRepeat(int bgrepeat){
		this.BG_REPEAT = bgrepeat;
	}
	
	public BufferedImage getBackgroundImage(){
		return bg;
	}
	
	public void setBackgroundImage(BufferedImage bg){
		this.bg = bg;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		g2.clearRect(0, 0, getWidth(), getHeight());
		if (bg != null){
			if (BG_REPEAT == BG_NO_REPEAT) {
				g2.drawImage(bg, 0, 0, this);
			} else {
				int tileWidth = bg.getWidth();
		        int tileHeight = bg.getHeight();
		        
				if (BG_REPEAT == BG_REPEAT_X){
					for (int x = 0; x < getWidth(); x += tileWidth) {
		                g2.drawImage(bg, x, 0, this);
		            }
				} else if (BG_REPEAT == BG_REPEAT_Y){	
					for (int y = 0; y < getHeight(); y += tileHeight) {
		                g2.drawImage(bg, 0, y, this);
		            }
				} else if (BG_REPEAT == BG_REPEAT_ALL){
		            for (int y = 0; y < getHeight(); y += tileHeight) {
		                for (int x = 0; x < getWidth(); x += tileWidth) {
		                    g2.drawImage(bg, x, y, this);
		                }
		            }
				}
			}
		} 
		
		for(Spirit spirit : SpiritManager.getInstance().getList()){
			spirit.drawThis(g2);
		}
		frame.setTitle("FPS: " + thread.getFPS() + " fps");
	}

}

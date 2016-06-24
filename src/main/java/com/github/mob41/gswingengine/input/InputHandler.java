package com.github.mob41.gswingengine.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.github.mob41.gswingengine.spirit.SpiritManager;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, FocusListener {
	
	private final SpiritManager sm;
	
	public InputHandler(SpiritManager spiritMan){
		this.sm = spiritMan;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		sm.callOnKeyPressed(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		sm.callOnKeyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		sm.callOnKeyTyped(arg0);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		sm.callOnMouseDragged(arg0);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		sm.callOnMouseMoved(arg0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		sm.callOnMouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		sm.callOnMouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		sm.callOnMouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		sm.callOnMousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		sm.callOnMouseReleased(e);
	}

}

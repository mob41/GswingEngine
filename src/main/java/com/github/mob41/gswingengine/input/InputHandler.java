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

	@Override
	public void keyPressed(KeyEvent arg0) {
		SpiritManager.getInstance().callOnKeyPressed(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		SpiritManager.getInstance().callOnKeyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		SpiritManager.getInstance().callOnKeyTyped(arg0);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

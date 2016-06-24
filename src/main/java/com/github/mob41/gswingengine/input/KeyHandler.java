package com.github.mob41.gswingengine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.github.mob41.gswingengine.spirit.SpiritManager;

public class KeyHandler implements KeyListener {

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

}

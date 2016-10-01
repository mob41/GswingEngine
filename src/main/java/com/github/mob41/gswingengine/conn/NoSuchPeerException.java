package com.github.mob41.gswingengine.conn;

public class NoSuchPeerException extends Exception {

	public NoSuchPeerException(String string) {
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchPeerException(){
		super();
	}
	
	public NoSuchPeerException(String message, Throwable cause){
		super(message, cause);
	}
	
	public NoSuchPeerException(Throwable cause){
		super(cause);
	}

}

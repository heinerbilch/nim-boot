package com.bilch.nim;

/**
 * Implements the AI player of the nim game. The drawing algorithm is a dark
 * plot.
 * 
 * @author heiner
 *
 */
public class Boss {

	private Stack stack;

	/**
	 * creates the AI player
	 * 
	 * @param stack
	 *            the nim stack
	 */
	public Boss(Stack stack) {
		this.stack = stack;
	}

	/**
	 * draws pieces from the nim stack
	 * 
	 * @return the nim stack after drawing
	 */
	public int draw() {
		return stack.draw(1);
	}

}

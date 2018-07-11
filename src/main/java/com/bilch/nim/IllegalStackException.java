package com.bilch.nim;

/**
 * A stack exception is thrown when the operation on the stack would result in a
 * stack less than zero.
 * 
 * @author heiner
 *
 */
public class IllegalStackException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message the detailed error on the nim stack.
	 */
	public IllegalStackException(final String message) {
		super(message);
	}

}

package com.bilch.nim;

/**
 * A draw exception is thrown when the operation on the stack would break the
 * nim rules.
 * 
 * @author heiner
 *
 */
public class IllegalDrawException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 *            the detailed error on the nim stack.
	 */
	public IllegalDrawException(final String message) {
		super(message);
	}

}

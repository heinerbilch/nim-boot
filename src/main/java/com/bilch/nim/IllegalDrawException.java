package com.bilch.nim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A draw exception is thrown when the operation on the stack would break the
 * nim rules. The exception translates to a 404 error.
 * 
 * @author heiner
 *
 */
@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class IllegalDrawException extends RuntimeException {

	private static final Logger logger = LoggerFactory.getLogger(IllegalDrawException.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 *            the detailed error on the nim stack.
	 */
	public IllegalDrawException(final String message) {
		super("Illegal draw: " + message);
		logger.warn("Illegal draw: " + message);
	}

}

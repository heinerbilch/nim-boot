package com.bilch.nim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements a simple nim stack.
 * 
 * @author heiner
 *
 */
public class Stack {

	private static final int START = 13;
	private int value;
	private static final Logger logger = LoggerFactory.getLogger(Stack.class);

	/**
	 * Constructs a single nim stack with 13 pieces.
	 */
	public Stack() {
		value = START;
	}

	/**
	 * Gets the value of the nim stack.
	 * 
	 * @return the stack value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Draws from the the nim stack.
	 * 
	 * @param number
	 *            the number of pieces to draw from the stack
	 * @return the new stack value
	 */
	public int draw(int number) {
		if (number > 3) {
			throw new IllegalDrawException(String.valueOf(number));
		}
		value -= number;
		if (value < 0) {
			throw new IllegalDrawException(String.valueOf(value));
		}
		logger.info("Stack value: " + value);;
		return value;
	}

}

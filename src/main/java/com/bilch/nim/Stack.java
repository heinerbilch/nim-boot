package com.bilch.nim;

public class Stack {

	private int value;

	public Stack() {
		value = 13;
	}
	
	public int getValue() {
		return value;
	}
	
	public int draw(int number) {
		if (number > 3) {
			throw new IllegalDrawException(String.valueOf(number));
		}
		value -= number;
		if (value < 0) {
			throw new IllegalDrawException(String.valueOf(value));
		}
		return value;
	}

}

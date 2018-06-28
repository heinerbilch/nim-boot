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
		value -= number;
		return value;
	}

}

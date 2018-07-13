package com.bilch.nim;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	
	private Stack testStack;

	@Before
	public void setUp() throws Exception {
		testStack = new Stack();
	}

	@Test
	public void testStack() {
		Stack myStack = new Stack();
		assertThat(myStack.getValue(), equalTo(13));
	}

	@Test
	public void testGetValue() {
		assertThat(testStack.getValue(), equalTo(13));
	}

	@Test
	public void testDraw() {
		assertThat(testStack.draw(3), equalTo(10));
	}

	@Test(expected = IllegalDrawException.class)
	public void testOverDraw() {
		assertThat(testStack.draw(4), equalTo(9));
	}

	@Test(expected = IllegalDrawException.class)
	public void testZeroDraw() {
		assertThat(testStack.draw(0), equalTo(13));
	}

	@Test(expected = IllegalStackException.class)
	public void testStackOverflow() {
		assertThat(testStack.draw(3), equalTo(10));
		assertThat(testStack.draw(3), equalTo(7));
		assertThat(testStack.draw(3), equalTo(4));
		assertThat(testStack.draw(3), equalTo(1));
		assertThat(testStack.draw(3), equalTo(-2));
	}

	public void testOverDrawException() {
		try {
			testStack.draw(4);
		} catch (IllegalDrawException e)
		{
			//* empty *//
		}
		assertThat(testStack.getValue(), equalTo(13));
	}

}

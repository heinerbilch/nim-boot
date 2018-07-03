package com.bilch.nim;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of the nim game controller.
 * 
 * @author heiner
 *
 */
@RestController
@RequestMapping("/start")
public class StartController {

	private Stack stack;
	private Boss boss;

	/**
	 * initializes the nim game
	 * 
	 * @return the initial nim stack value
	 */
	@GetMapping
	public int start() {
		this.stack = new Stack();
		this.boss = new Boss(stack);
		return stack.getValue();
	}

	/**
	 * implements the drawing of player and AI
	 * 
	 * @param noOfPieces
	 *            number of pieces a player draws
	 * @return the nim stack value after drawing of player and machine
	 */
	@GetMapping("/draw/{noOfPieces}")
	public int draw(@PathVariable int noOfPieces) {
		stack.draw(noOfPieces);
		return boss.draw();
	}
}

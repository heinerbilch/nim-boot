package com.bilch.nim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(StartController.class);

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
	 * @param noOfPieces number of pieces a player draws
	 * @return the nim stack value after drawing of player and machine
	 */
	@GetMapping("/draw/{noOfPieces}")
	public int draw(@PathVariable int noOfPieces) {
		try {
			stack.draw(noOfPieces);
		} catch (IllegalDrawException e) {
			logger.warn(e.getLocalizedMessage() + ". Please draw 1,2 or 3 pieces.");
			return stack.getValue();
		} catch (IllegalStackException e) {
			logger.warn(e.getLocalizedMessage() + ". Please draw less pieces, the stack can't be negative.");
			return stack.getValue();
		}
		int bossStack;
		try {
			bossStack = boss.draw();
		} catch (IllegalDrawException e) {
			logger.warn(e.getLocalizedMessage());
			bossStack = stack.getValue();
		} catch (IllegalStackException e) {
			logger.warn(e.getLocalizedMessage());
			bossStack = stack.getValue();
		}
		return bossStack;
	}
}

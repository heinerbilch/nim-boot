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
	private static final int MAXDRAW = 7;

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
		int playerStack = 0;
		playerDraw(noOfPieces);
		int bossStack = stack.getValue();
		if (playerStack > 0) {
			try {
				bossStack = boss.draw();
			} catch (IllegalDrawException e) {
				logger.warn(e.getLocalizedMessage());
				bossStack = stack.getValue();
			} catch (IllegalStackException e) {
				logger.warn(e.getLocalizedMessage());
				bossStack = stack.getValue();
			}
		}
		return bossStack;
	}

	private void playerDraw(int noOfPieces) {
		boolean drawAgain = true;
		boolean notToMany = true;
		int i = 0;
		while (drawAgain && notToMany) {
			try {
				stack.draw(noOfPieces);
				drawAgain = false;
			} catch (IllegalDrawException e) {
				i++;
				logger.warn(e.getLocalizedMessage() + ". Please draw 1,2 or 3 pieces.");
			} catch (IllegalStackException e) {
				i++;
				logger.warn(e.getLocalizedMessage() + ". Please draw less pieces, the stack can't be negative.");
			} finally {
				if (i > MAXDRAW) {
					notToMany = false;
					logger.warn("Maximum number of draws exhausted");
				}
			}
		}
	}
}

package com.bilch.nim;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
	
	private Stack stack;

	@RequestMapping("/start")
	public int start() {
		this.stack = new Stack();
		return stack.getValue();
	}
	
	@RequestMapping("/draw/{noOfPieces}")
	public int draw(@PathVariable int noOfPieces) {
		return stack.draw(noOfPieces);		
	}
}

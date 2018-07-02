package com.bilch.nim;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
public class StartController {
	
	private Stack stack;

	@GetMapping
	public int start() {
		this.stack = new Stack();
		return stack.getValue();
	}
	
	@GetMapping("/draw/{noOfPieces}")
	public int draw(@PathVariable int noOfPieces) {
		return stack.draw(noOfPieces);		
	}
}

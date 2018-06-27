package com.bilch.nim;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NimController {
	
	@RequestMapping
	public String index () {
		return "Welcome to nim !";
	}

}

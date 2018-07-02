package com.bilch.nim;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class IllegalDrawException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalDrawException(String message) {
		super("illegal draw: " + message);
	}

}

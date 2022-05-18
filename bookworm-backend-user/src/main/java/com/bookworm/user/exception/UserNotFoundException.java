package com.bookworm.user.exception;

public class UserNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1379778824000202505L;

	public UserNotFoundException() {
		super("User not found");
	}

}

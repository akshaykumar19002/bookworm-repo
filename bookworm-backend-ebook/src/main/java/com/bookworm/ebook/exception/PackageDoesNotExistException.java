package com.bookworm.ebook.exception;

public class PackageDoesNotExistException extends Exception {
	
	public PackageDoesNotExistException() {
		super("Selected package does not exist");
	}

}

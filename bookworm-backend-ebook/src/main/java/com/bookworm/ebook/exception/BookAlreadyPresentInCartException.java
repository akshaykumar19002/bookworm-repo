package com.bookworm.ebook.exception;

public class BookAlreadyPresentInCartException extends Exception{

	public BookAlreadyPresentInCartException() {
		super("Book is already present in cart.");
	}
	
}

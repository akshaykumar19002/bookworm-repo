package com.bookworm.ebook.exception;

public class BookAlreadyPurchasedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7938720696466651396L;

	public BookAlreadyPurchasedException() {
		super("Book already purchased by user.");
	}
	
}

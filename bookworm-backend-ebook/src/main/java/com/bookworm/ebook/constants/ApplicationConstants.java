package com.bookworm.ebook.constants;

public class ApplicationConstants {
	
	public static final String SUCCESS_STATUS = "Success";
	public static final String FAILURE_STATUS = "Failure";
	
	//Ebook related constants
	public static final String ADD_BOOK_FAILURE = "Failed to add book";
	public static final String ADD_BOOK_SUCCESS = "Booked added successfully.";
	public static final String EDIT_BOOK_FAILURE = "Failed to edit book";
	public static final String EDIT_BOOK_SUCCESS = "Booked updated successfully.";
	public static final String DELETE_BOOK_FAILURE = "Failed to delete book";
	public static final String DELETE_BOOK_SUCCESS = "Booked deleted successfully.";
	public static final String BOOK_DOES_NOT_EXISTS = "Booked does not exist.";
	public static final String EBOOK_RESOURCE_PATH = "src\\main\\resources\\static\\ebooks\\";
	
	//Package related constants
	public static final String ADD_PACKAGE_SUCCESS = "Package created successfully";
	public static final String ADD_PACKAGE_FAILURE = "Failed to create package";
	
	//Billing related constants
	public static final String ADD_BILLING_SUCCESS = "Book added to billing successfully";
	public static final String ADD_BILLING_FAILURE = "Failed to add book to billing";
	public static final String BOOK_ALREADY_PURCHASED = "Book already purchased by user.";
	
	//Rent related constants
	public static final String DELETE_RENTED_BOOK_SUCCESS = "Rented book removed successfully.";
	public static final String DELETE_RENTED_BOOK_FAILURE = "Failed to remove rented book";
	public static final String ADD_RENT_SUCCESS = "Ebook rented successfully.";
	public static final String ADD_RENT_FAILURE = "Failed to rent this ebook";
	
	//Cart related constants
	public static final String CLEAR_CART_SUCCESS = "Cart cleared.";
	public static final String CLEAR_CART_FAILURE = "Failed to clear cart";
	public static final String ADD_CART_SUCCESS = "Ebook added to cart.";
	public static final String ADD_CART_FAILURE = "Failed to add this ebook to cart";
	
	//Lend related constants
	public static final String LEND_FAILURE = "Failed to lend book";
	public static final String LEND_SUCCESS = "Lend successfully";
	
	//purchase types
	public static final String RENT = "rent";
	public static final String BUY = "buy";
	public static final String LEND = "lend";
	
	public static final String BUY_FAILURE = "Failed to buy this ebook";
	public static final String BUY_SUCCESS = "Book bought successfully";	
	
}

package com.bookworm.ebook.service;

import java.util.List;

import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.model.Rent;

public interface RentService {

	Rent addToRent(Rent rent) throws BookAlreadyPurchasedException;

	List<Rent> fetchAllBooksByUserId(Integer userId);

	List<Rent> fetchAllAvailableBooksByUserId(Integer userId);

	void deleteBook(Integer rentId);

	Rent fetchRentDetailsById(Integer rentId);

}

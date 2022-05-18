package com.bookworm.ebook.service;

import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.exception.PackageDoesNotExistException;
import com.bookworm.ebook.model.Lend;

public interface LendService {

	void lendBook(Lend lend) throws BookAlreadyPurchasedException;

	void lendBookAndUpdatePackage(Lend lend) throws BookAlreadyPurchasedException, PackageDoesNotExistException;

	Lend fetchLendDetailsById(Integer lendId);

}

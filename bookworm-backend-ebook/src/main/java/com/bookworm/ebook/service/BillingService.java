package com.bookworm.ebook.service;

import java.util.List;
import java.util.Set;

import com.bookworm.ebook.entity.BillingEntity;
import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.model.Billing;

public interface BillingService {
	
	void addBookToBilling(Billing billing) throws BookAlreadyPurchasedException;

	void buyBook(Billing billing) throws BookAlreadyPurchasedException;

	List<BillingEntity> fetchAllBooksByUserId(Integer userId);

	List<Billing> fetchAllBooksByActionAndUserId(Integer userId, String action);

	Set<Integer> fetchAllActiveBooks(Integer userId);

}

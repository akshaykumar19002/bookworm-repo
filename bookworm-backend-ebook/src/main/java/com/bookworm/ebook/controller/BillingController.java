package com.bookworm.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.ebook.constants.ApplicationConstants;
import com.bookworm.ebook.entity.BillingEntity;
import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.model.ApiResponse;
import com.bookworm.ebook.model.Billing;
import com.bookworm.ebook.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {

	@Autowired
	private BillingService billingService;
	
	@PostMapping("/addBookToBilling")
	public ApiResponse addBookToBilling(@Validated @RequestBody Billing billing) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			billingService.addBookToBilling(billing);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.ADD_BILLING_SUCCESS);
		} catch (BookAlreadyPurchasedException e) {
			apiResponse.setError(ApplicationConstants.BOOK_ALREADY_PURCHASED);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.ADD_BILLING_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
	@GetMapping("fetchAllBooksByUserId")
	public List<BillingEntity> fetchAllBooksByUserId(@RequestParam Integer userId) {
		return billingService.fetchAllBooksByUserId(userId);
	}
	
	@GetMapping("fetchAllBooksByActionAndUserId")
	public List<Billing> fetchAllBooksByActionAndUserId(@RequestParam Integer userId, @RequestParam String action) {
		return billingService.fetchAllBooksByActionAndUserId(userId, action);
	}
	
	@PostMapping("buy")
	public ApiResponse buyBook(@RequestBody Billing billing) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			billingService.buyBook(billing);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.BUY_SUCCESS);
		} catch (BookAlreadyPurchasedException e) {
			apiResponse.setError(ApplicationConstants.BOOK_ALREADY_PURCHASED);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.BUY_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
}

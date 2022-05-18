package com.bookworm.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.ebook.constants.ApplicationConstants;
import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.exception.PackageDoesNotExistException;
import com.bookworm.ebook.model.ApiResponse;
import com.bookworm.ebook.model.Lend;
import com.bookworm.ebook.service.LendService;

@RestController
@RequestMapping("/lend")
public class LendController {

	@Autowired
	private LendService lendService;
	
	@PostMapping("/")
	public ApiResponse lendBook(@Validated @RequestBody Lend lend) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			lendService.lendBook(lend);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.LEND_SUCCESS);
		} catch (BookAlreadyPurchasedException e) {
			apiResponse.setError(ApplicationConstants.BOOK_ALREADY_PURCHASED);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.LEND_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
	@PostMapping("/lendBookAndUpdatePackage")
	public ApiResponse lendBookAndUpdatePackage(@Validated @RequestBody Lend lend) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			lendService.lendBookAndUpdatePackage(lend);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.LEND_SUCCESS);
		} catch (BookAlreadyPurchasedException e) {
			apiResponse.setError(ApplicationConstants.BOOK_ALREADY_PURCHASED);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		} catch (PackageDoesNotExistException e) {
			apiResponse.setError(e.getMessage());
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.LEND_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
}

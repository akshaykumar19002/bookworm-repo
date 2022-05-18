package com.bookworm.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.ebook.constants.ApplicationConstants;
import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.model.ApiResponse;
import com.bookworm.ebook.model.Rent;
import com.bookworm.ebook.service.RentService;

@RestController
@RequestMapping("/rent")
public class RentController {
	
	@Autowired
	private RentService rentService;
	
	@PostMapping("")
	public ApiResponse addToRent(@Validated @RequestBody Rent rent) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			apiResponse.setId(rentService.addToRent(rent).getRentId());
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.ADD_RENT_SUCCESS);
		} catch (BookAlreadyPurchasedException e) {
			apiResponse.setError(ApplicationConstants.BOOK_ALREADY_PURCHASED);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.ADD_RENT_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}

	
	@GetMapping("fetchAllBooksByUserId")
	public List<Rent> fetchAllBooksByUserId(@RequestParam Integer userId) {
		return rentService.fetchAllBooksByUserId(userId);
	}
	
	@GetMapping("fetchAllAvailableBooksByUserId")
	public List<Rent> fetchAllAvailableBooksByUserId(@RequestParam Integer userId){
		return rentService.fetchAllAvailableBooksByUserId(userId);
	}
	
	@DeleteMapping("/")
	public ApiResponse delete(@RequestParam Integer rentId) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			rentService.deleteBook(rentId);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.DELETE_RENTED_BOOK_SUCCESS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.DELETE_RENTED_BOOK_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
}

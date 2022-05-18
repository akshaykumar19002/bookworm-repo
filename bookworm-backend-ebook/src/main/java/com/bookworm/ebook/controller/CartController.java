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
import com.bookworm.ebook.entity.CartEntity;
import com.bookworm.ebook.exception.BookAlreadyPresentInCartException;
import com.bookworm.ebook.model.ApiResponse;
import com.bookworm.ebook.model.Cart;
import com.bookworm.ebook.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/")
	public ApiResponse addToCart(@Validated @RequestBody Cart cart) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			cartService.addToCart(cart);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.ADD_CART_SUCCESS);
		} catch (BookAlreadyPresentInCartException e) {
			apiResponse.setError(e.getMessage());
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.ADD_CART_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
	@GetMapping("/fetchAllItemsByUserId")
	List<CartEntity> fetchAllItemsByUserId(Integer userId) {
		return cartService.fetchAllItemsByUserId(userId);
	}
	
	@DeleteMapping("/deleteBookFromCart")
	public ApiResponse deleteBookFromCart(@RequestParam Integer cartId) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			cartService.deleteBookFromCart(cartId);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.CLEAR_CART_SUCCESS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.CLEAR_CART_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
	@DeleteMapping("/clearCart")
	public ApiResponse delete(@RequestParam Integer userId) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			cartService.clearCart(userId);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.CLEAR_CART_SUCCESS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.CLEAR_CART_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
}

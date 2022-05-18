package com.bookworm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.user.constants.ApplicationConstants;
import com.bookworm.user.model.ApiResponse;
import com.bookworm.user.model.User;
import com.bookworm.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public ApiResponse registerUser(@Validated @RequestBody User user) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			userService.addUser(user);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.SIGNUP_SUCCESS);
		} catch (DataIntegrityViolationException e) {
			apiResponse.setError(ApplicationConstants.USER_ALREADY_EXISTS);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.SIGNUP_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
	@PostMapping("/signin")
	public ApiResponse signin(@RequestBody User user) {
		ApiResponse response = new ApiResponse();
		try {
			user = userService.signin(user);
			response.setStatus(ApplicationConstants.SUCCESS_STATUS);
			response.setMessage(ApplicationConstants.SIGNIN_SUCCESS);
			response.setId(user.getUserId());
			response.setUserType(user.getUserType());
		} catch(Exception e) {
			response.setStatus(ApplicationConstants.FAILURE_STATUS);
			response.setMessage(ApplicationConstants.SIGNIN_FAILURE);
		}
		return response;
	}
	
	@GetMapping("/")
	public List<User> fetchAll() {
		return userService.fetchAllUser();
	}
	
	@GetMapping("/view")
	public User viewUser(@RequestParam("id") Integer userId) {
		return userService.viewUser(userId);
	}
	
}

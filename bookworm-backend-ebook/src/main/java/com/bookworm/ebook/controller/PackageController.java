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
import com.bookworm.ebook.entity.PackageEntity;
import com.bookworm.ebook.model.ApiResponse;
import com.bookworm.ebook.model.Pkg;
import com.bookworm.ebook.service.PackageService;

@RestController
@RequestMapping("/package")
public class PackageController {

	@Autowired
	private PackageService packageServ;
	
	@PostMapping("/")
	public ApiResponse createPackage(@Validated @RequestBody Pkg pkg) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			packageServ.createPackage(pkg);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.ADD_PACKAGE_SUCCESS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.ADD_PACKAGE_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
	@GetMapping("/fetchByUserId")
	public List<PackageEntity> fetchPackages(@RequestParam Integer userId) {
		return packageServ.fetchPackages(userId);
	}
	
}

package com.bookworm.ebook.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookworm.ebook.constants.ApplicationConstants;
import com.bookworm.ebook.model.ApiResponse;
import com.bookworm.ebook.model.Ebook;
import com.bookworm.ebook.service.EbookService;
import com.bookworm.ebook.utils.FileUploadUtil;

@RestController
@RequestMapping("/ebooks")
public class EbookController {

	@Autowired
	private EbookService ebookService;
	
	@PostMapping(value="/", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ApiResponse addBook(@Validated @RequestPart("ebook") String jsonEbook,
			@RequestPart("image") MultipartFile imageFile,
			@RequestPart("pdfFile") MultipartFile pdfFile) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			Ebook ebook = Ebook.fromJson(jsonEbook); 
			ebookService.addBook(ebook, imageFile, pdfFile);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.ADD_BOOK_SUCCESS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.ADD_BOOK_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
	@GetMapping("/")
	public List<Ebook> fetchAll(){
		return ebookService.fetchAll();
	}
	
	@GetMapping("/search")
	public List<Ebook> searchBooks(@RequestParam String searchText) {
		return ebookService.searchBooks(searchText);
	}
	
	@GetMapping("/view")
	public Ebook viewBook(@RequestParam("id") Integer bookId) {
		return ebookService.viewBook(bookId);
	}
	
	@PutMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse editBook(@Validated @RequestBody Ebook ebook) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			ebookService.editBook(ebook);
			apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
			apiResponse.setMessage(ApplicationConstants.EDIT_BOOK_SUCCESS);
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.EDIT_BOOK_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
	@DeleteMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse deleteBook(@RequestParam("id") Integer bookId) {
		ApiResponse apiResponse = new ApiResponse();
		try {
			if (!ebookService.deleteBook(bookId)) {
				apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
				apiResponse.setMessage(ApplicationConstants.BOOK_DOES_NOT_EXISTS);
			} else {
				apiResponse.setStatus(ApplicationConstants.SUCCESS_STATUS);
				apiResponse.setMessage(ApplicationConstants.DELETE_BOOK_SUCCESS);
			}
		} catch (Exception e) {
			apiResponse.setError(ApplicationConstants.DELETE_BOOK_FAILURE);
			apiResponse.setStatus(ApplicationConstants.FAILURE_STATUS);
		}
		return apiResponse;
	}
	
	@GetMapping("/fetchBooks")
	List<Ebook> fetchBooksByUserId(@RequestParam Integer userId) {
		return ebookService.fetchBooksByUserId(userId);
	}
	
}

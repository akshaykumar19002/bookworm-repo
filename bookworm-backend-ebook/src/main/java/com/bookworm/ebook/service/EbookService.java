package com.bookworm.ebook.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bookworm.ebook.model.Ebook;

public interface EbookService {

	void addBook(Ebook ebook, MultipartFile imageFile, MultipartFile pdfFile) throws Exception;

	List<Ebook> fetchAll();

	List<Ebook> searchBooks(String searchText);

	Ebook viewBook(Integer bookId);

	void editBook(Ebook ebook) throws Exception;

	Boolean deleteBook(Integer bookId);

	List<Ebook> fetchBooksByUserId(Integer userId);

}

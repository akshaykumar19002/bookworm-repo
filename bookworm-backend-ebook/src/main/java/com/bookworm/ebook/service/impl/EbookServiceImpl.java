package com.bookworm.ebook.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bookworm.ebook.constants.ApplicationConstants;
import com.bookworm.ebook.entity.EbookEntity;
import com.bookworm.ebook.model.Ebook;
import com.bookworm.ebook.repo.EbookRepository;
import com.bookworm.ebook.service.BillingService;
import com.bookworm.ebook.service.EbookService;
import com.bookworm.ebook.utils.FileUploadUtil;

@Transactional()
@Service("ebookService")
public class EbookServiceImpl implements EbookService {
	
	@Autowired
	private EbookRepository ebookRepo;
	
	@Autowired
	private BillingService billingService;
	
	@Override
	public void addBook(Ebook ebook, MultipartFile imageFile, MultipartFile pdfFile) throws Exception {
		String imageFileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
		String pdfFileName = StringUtils.cleanPath(pdfFile.getOriginalFilename());
		ebook.setImage(imageFileName);
		ebook.setPdf(pdfFileName);
		String uploadDir = new File(ApplicationConstants.EBOOK_RESOURCE_PATH).getAbsolutePath();
		FileUploadUtil.saveFile(uploadDir, imageFileName, imageFile);
		FileUploadUtil.saveFile(uploadDir, pdfFileName, pdfFile);
		ebookRepo.save(ebook.convertToEntity());
	}

	@Override
	public List<Ebook> fetchAll() {
		List<Ebook> ebooks = new ArrayList<>();
		for (EbookEntity ebook: ebookRepo.findAll())
			ebooks.add(ebook.convertToModel());
		return ebooks;
	}

	@Override
	public List<Ebook> searchBooks(String searchText) {
		List<Ebook> ebooks = new ArrayList<>();
		for (EbookEntity ebook: ebookRepo.findByBooktitle(searchText + "%"))
			ebooks.add(ebook.convertToModel());
		return ebooks;
	}

	@Override
	public Ebook viewBook(Integer bookId) {
		return ebookRepo.findById(bookId).get().convertToModel();
	}
	
	@Override
	public void editBook(Ebook ebook) throws Exception {
		ebookRepo.save(ebook.convertToEntity());
	}

	@Override
	public Boolean deleteBook(Integer bookId) {
		try {
			ebookRepo.deleteById(bookId);
		} catch(EmptyResultDataAccessException ex) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public List<Ebook> fetchBooksByUserId(Integer userId) {
		Set<Integer> bookIds = billingService.fetchAllActiveBooks(userId);
		List<EbookEntity> bookEntities = ebookRepo.findAll().stream()
			.filter(ebook -> !bookIds.contains(ebook.getId()))
			.collect(Collectors.toList());
		List<Ebook> ebooks = new ArrayList<>();
		for (EbookEntity e: bookEntities) {
			ebooks.add(e.convertToModel());
		}
		return ebooks;
	}
	
	

}

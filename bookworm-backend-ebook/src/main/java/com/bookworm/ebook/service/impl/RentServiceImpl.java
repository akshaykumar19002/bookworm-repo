package com.bookworm.ebook.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.ebook.entity.RentEntity;
import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.model.Rent;
import com.bookworm.ebook.repo.RentRepository;
import com.bookworm.ebook.service.RentService;

@Transactional()
@Service("rentService")
public class RentServiceImpl implements RentService {

	@Autowired
	private RentRepository rentRepo;
	
	@Override
	public Rent addToRent(Rent rent) throws BookAlreadyPurchasedException {
		List<Rent> rentedBooks = new ArrayList<>();
		for (RentEntity r: rentRepo.findByUserIdAndBookId(rent.getUserId(), rent.getBookId())) {
			if (r.getEndDate() > new Date().getTime())
				rentedBooks.add(r.convertToModel());
		}
		if (rentedBooks.size() == 0)
			return rentRepo.save(rent.convertToEntity()).convertToModel();
		else
			throw new BookAlreadyPurchasedException();
	}

	@Override
	public List<Rent> fetchAllBooksByUserId(Integer userId) {
		List<Rent> rentedBooks = new ArrayList<>();
		for (RentEntity ebook: rentRepo.findByUserId(userId))
			rentedBooks.add(ebook.convertToModel());
		return rentedBooks;
	}

	@Override
	public List<Rent> fetchAllAvailableBooksByUserId(Integer userId) {
		List<Rent> rentedBooks = new ArrayList<>();
		for (RentEntity r: rentRepo.findByUserId(userId)) {
			if (r.getEndDate() > new Date().getTime())
				rentedBooks.add(r.convertToModel());
		}
		return rentedBooks;
	}

	@Override
	public void deleteBook(Integer rentId) {
		rentRepo.deleteById(rentId);
	}
	
	@Override
	public Rent fetchRentDetailsById(Integer rentId) {
		return rentRepo.findById(rentId).get().convertToModel();
		
	}

}

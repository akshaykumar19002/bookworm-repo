package com.bookworm.ebook.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.ebook.constants.ApplicationConstants;
import com.bookworm.ebook.entity.BillingEntity;
import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.model.Billing;
import com.bookworm.ebook.model.Ebook;
import com.bookworm.ebook.model.Lend;
import com.bookworm.ebook.model.Rent;
import com.bookworm.ebook.repo.BillingRepository;
import com.bookworm.ebook.service.BillingService;

@Transactional()
@Service("billingService")
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingRepository billingRepo;
	
	@Override
	public void addBookToBilling(Billing billing) throws BookAlreadyPurchasedException {
		List<Billing> billings = new ArrayList<>();
		BillingEntity be = getBillingEntity(billing);
		for (BillingEntity b: billingRepo.findByUserIdAndBookIdAndAction(be.getUserId(), be.getBookId(), be.getAction())) {
			billings.add(b.convertToModel());
		}
		if (billings.size() == 0)
			billingRepo.save(be);
		else
			throw new BookAlreadyPurchasedException();
		
	}
	
	private BillingEntity getBillingEntity(Billing billing) {
		Ebook book = null;
		Rent rent = null;
		Lend lend = null;
		if (billing.getBookId() != null) {
			book = ServiceLocator.getEbookService().viewBook(billing.getBookId());
		}
		if (billing.getRentId() != null) {
			rent = ServiceLocator.getRentService().fetchRentDetailsById(billing.getRentId());
		}
		if (billing.getLendId() != null) {
			lend = ServiceLocator.getLendService().fetchLendDetailsById(billing.getLendId());
		}
		
		return billing.convertToEntity(book.convertToEntity(), (lend != null) ? lend.convertToEntity() : null,
				(rent != null) ? rent.convertToEntity() : null);
	}

	@Override
	public void buyBook(Billing billing) throws BookAlreadyPurchasedException {
		billing.setAction(ApplicationConstants.BUY);
		addBookToBilling(billing);
	}

	@Override
	public List<BillingEntity> fetchAllBooksByUserId(Integer userId) {
		return billingRepo.findByUserId(userId);
	}

	@Override
	public List<Billing> fetchAllBooksByActionAndUserId(Integer userId, String action) {
		List<Billing> billing = new ArrayList<>();
		for (BillingEntity entity: billingRepo.findByUserIdAndAction(userId, action))
			billing.add(entity.convertToModel());
		return billing;
	}
	
	@Override
	public Set<Integer> fetchAllActiveBooks(Integer userId) {
		List<BillingEntity> billings = billingRepo.findByUserId(userId);
		return new HashSet<Integer>(billings.stream().filter(book -> {
			if (book.getAction().equals(ApplicationConstants.BUY)) {
				return Boolean.TRUE;
			}
			else if (book.getAction().equals(ApplicationConstants.LEND) && book.getLendId().getEndDate() > new Date().getTime()) {
				return Boolean.TRUE;
			} else if (book.getRentId().getEndDate() > new Date().getTime()){
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}).mapToInt(book -> book.getBookId().getId()).boxed().toList());
	}

}

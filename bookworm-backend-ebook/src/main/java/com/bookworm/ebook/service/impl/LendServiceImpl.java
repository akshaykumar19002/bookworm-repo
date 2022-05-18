package com.bookworm.ebook.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.ebook.constants.ApplicationConstants;
import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.exception.PackageDoesNotExistException;
import com.bookworm.ebook.model.Billing;
import com.bookworm.ebook.model.Lend;
import com.bookworm.ebook.repo.LendRepository;
import com.bookworm.ebook.service.BillingService;
import com.bookworm.ebook.service.LendService;
import com.bookworm.ebook.service.PackageService;

@Transactional()
@Service("lendService")
public class LendServiceImpl implements LendService {

	@Autowired
	private LendRepository lendRepo;
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private PackageService packageService;
	
	@Override
	public void lendBook(Lend lend) throws BookAlreadyPurchasedException {
		lend = lendRepo.save(lend.convertToEntity()).convertToModel();
		Billing billing = convertToBilling(lend);
		billingService.addBookToBilling(billing);
	}
	
	private Billing convertToBilling(Lend lend) {
		Billing billing = new Billing();
		billing.setAction(ApplicationConstants.LEND);
		billing.setBookId(lend.getBookId());
		billing.setLendId(lend.getLendId());
		billing.setUserId(lend.getUserId());
		return billing;
	}

	@Override
	public void lendBookAndUpdatePackage(Lend lend) throws BookAlreadyPurchasedException, PackageDoesNotExistException {
		lend = lendRepo.save(lend.convertToEntity()).convertToModel();
		
		//update package -> reduce no of books by 1
		packageService.updatePackage(lend.getPackageId());
		
		Billing billing = convertToBilling(lend);
		billingService.addBookToBilling(billing);
	}

	@Override
	public Lend fetchLendDetailsById(Integer lendId) {
		return lendRepo.findById(lendId).get().convertToModel();
	}

}

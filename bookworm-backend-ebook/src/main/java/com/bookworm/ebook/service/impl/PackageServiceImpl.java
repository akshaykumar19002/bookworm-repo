package com.bookworm.ebook.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.ebook.entity.PackageEntity;
import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.exception.PackageDoesNotExistException;
import com.bookworm.ebook.model.Lend;
import com.bookworm.ebook.model.Pkg;
import com.bookworm.ebook.repo.PackageRepository;
import com.bookworm.ebook.service.PackageService;

@Transactional()
@Service("packageServ")
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageRepository packageRepo;
	
	@Override
	public void createPackage(Pkg pkg) throws BookAlreadyPurchasedException {
		PackageEntity pkgEntity = packageRepo.save(pkg.convertToEntity());
		
		// call lend
		ServiceLocator.getLendService().lendBook(populateLendObject(pkgEntity, pkg.getBookId()));
	}
	
	private Lend populateLendObject(PackageEntity pkg, Integer bookId) {
		Lend lend = new Lend();
		lend.setBookId(bookId);
		lend.setCreatedAt(new Date());
		lend.setEndDate(new Date(pkg.getEndDate()));
		lend.setPackageId(pkg.getPackageId());
		lend.setUserId(pkg.getUserId());
		return lend;
	}

	@Override
	public void updatePackage(Integer packageId) throws PackageDoesNotExistException{
		PackageEntity entity = packageRepo.findById(packageId).get();
		entity.setNoOfBooks(entity.getNoOfBooks() - 1);
		packageRepo.save(entity);
	}

	@Override
	public List<PackageEntity> fetchPackages(Integer userId) {
		return packageRepo.findByUserId(userId, new Date().getTime());
	}

}

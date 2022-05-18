package com.bookworm.ebook.service;

import java.util.List;

import com.bookworm.ebook.entity.PackageEntity;
import com.bookworm.ebook.exception.BookAlreadyPurchasedException;
import com.bookworm.ebook.exception.PackageDoesNotExistException;
import com.bookworm.ebook.model.Pkg;

public interface PackageService {

	void createPackage(Pkg pkg) throws BookAlreadyPurchasedException;

	void updatePackage(Integer packageId) throws PackageDoesNotExistException;

	List<PackageEntity> fetchPackages(Integer userId);

}

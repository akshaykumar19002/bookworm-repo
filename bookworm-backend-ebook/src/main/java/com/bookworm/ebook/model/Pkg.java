package com.bookworm.ebook.model;

import java.sql.Date;

import com.bookworm.ebook.entity.PackageEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

public class Pkg {
	
	private Integer packageId;
	
	private String packageName;
	
	private Integer noOfDays;
	
	private Integer noOfBooks;
	
	private Double lendAmount;
	
	private Integer userId;
	
	private Date endDate;
	
	private Integer bookId;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Integer getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(Integer noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public Double getLendAmount() {
		return lendAmount;
	}

	public void setLendAmount(Double lendAmount) {
		this.lendAmount = lendAmount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public PackageEntity convertToEntity() {
		PackageEntity entity = new PackageEntity();
		entity.setEndDate(endDate.getTime());
		entity.setLendAmount(lendAmount);
		entity.setNoOfBooks(noOfBooks);
		entity.setNoOfDays(noOfDays);
		entity.setPackageId(packageId);
		entity.setPackageName(packageName);
		entity.setUserId(userId);
		return entity;
	}

	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", noOfDays=" + noOfDays
				+ ", noOfBooks=" + noOfBooks + ", lendAmount=" + lendAmount + ", userId=" + userId + ", endDate="
				+ endDate + "]";
	}
	
}

package com.bookworm.ebook.model;

import java.util.Date;

import com.bookworm.ebook.entity.LendEntity;
import com.bookworm.ebook.service.impl.ServiceLocator;

public class Lend {
	
	private Integer lendId;
	
	private Integer userId;
	
	private Integer bookId;
	
	private Integer packageId;
	
	private Date endDate;
	
	private Date createdAt = new Date();

	public Integer getLendId() {
		return lendId;
	}

	public void setLendId(Integer lendId) {
		this.lendId = lendId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public LendEntity convertToEntity() {
		LendEntity lend = new LendEntity();
		lend.setBookId(ServiceLocator.getEbookService().viewBook(bookId).convertToEntity());
		lend.setCreatedAt(createdAt.getTime());
		lend.setEndDate(endDate.getTime());
		lend.setLendId(lendId);
		lend.setPackageId(packageId);
		lend.setUserId(userId);
		return lend;
	}

	@Override
	public String toString() {
		return "Lend [lendId=" + lendId + ", userId=" + userId + ", bookId=" + bookId + ", packageId=" + packageId
				+ ", endDate=" + endDate + ", createdAt=" + createdAt + "]";
	}

}

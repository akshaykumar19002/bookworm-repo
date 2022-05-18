package com.bookworm.ebook.model;

import java.util.Date;

import com.bookworm.ebook.entity.BillingEntity;
import com.bookworm.ebook.entity.EbookEntity;
import com.bookworm.ebook.entity.LendEntity;
import com.bookworm.ebook.entity.RentEntity;

public class Billing {
	
	private Integer id;
	
	private Integer bookId;
	
	private String action;
	
	private Integer rentId;
	
	private Integer lendId;
	
	private Date createdAt = new Date();
	
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getRentId() {
		return rentId;
	}

	public void setRentId(Integer rentId) {
		this.rentId = rentId;
	}

	public Integer getLendId() {
		return lendId;
	}

	public void setLendId(Integer lendId) {
		this.lendId = lendId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public BillingEntity convertToEntity(EbookEntity ebook, LendEntity lend, RentEntity rent) {
		BillingEntity billing = new BillingEntity();
		billing.setAction(action);
		billing.setId(id);
		if (createdAt != null)
			billing.setCreatedAt(createdAt.getTime());
		billing.setBookId(ebook);
		billing.setLendId(lend);
		billing.setRentId(rent);
		billing.setUserId(userId);
		return billing;
	}

	@Override
	public String toString() {
		return "Billing [billingId=" + id + ", bookId=" + bookId + ", action=" + action + ", rentId=" + rentId
				+ ", lendId=" + lendId + ", createdAt=" + createdAt + ", userId=" + userId + "]";
	}

}

package com.bookworm.ebook.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.bookworm.ebook.entity.RentEntity;

public class Rent {

	private Integer rentId;
	
	@Min(1)
	@Max(1000)
	private Integer userId;
	
	@Min(1)
	@Max(1000)
	private Integer bookId;

	@NotNull
	private Date startDate;
	
	@NotNull
	private Date endDate;
	
	@Min(0)
	private Double rentAmount;

	public Integer getRentId() {
		return rentId;
	}

	public void setRentId(Integer rentId) {
		this.rentId = rentId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public RentEntity convertToEntity() {
		RentEntity entity = new RentEntity();
		entity.setBookId(bookId);
		entity.setEndDate(endDate.getTime());
		entity.setRentAmount(rentAmount);
		entity.setRentId(rentId);
		entity.setStartDate(startDate.getTime());
		entity.setUserId(userId);
		return entity;
	}

	@Override
	public String toString() {
		return "Rent [rentId=" + rentId + ", userId=" + userId + ", bookId=" + bookId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", rentAmount=" + rentAmount + "]";
	}
	
}

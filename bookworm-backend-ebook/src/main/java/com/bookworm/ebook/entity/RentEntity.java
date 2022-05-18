package com.bookworm.ebook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bookworm.ebook.model.Rent;

@Entity
@Table(name = "rent")
public class RentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer rentId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "book_id")
	private Integer bookId;
	
	@Column(name = "start_date")
	private Long startDate;
	
	@Column(name = "end_date")
	private Long endDate;
	
	@Column(name = "rent_amount")
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

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public Double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public Rent convertToModel() {
		Rent model = new Rent();
		model.setBookId(bookId);
		model.setEndDate(new Date(endDate));
		model.setRentAmount(rentAmount);
		model.setRentId(rentId);
		model.setStartDate(new Date(startDate));
		model.setUserId(userId);
		return model;
	}

	@Override
	public String toString() {
		return "RentEntity [rentId=" + rentId + ", userId=" + userId + ", bookId=" + bookId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", rentAmount=" + rentAmount + "]";
	}
	
}

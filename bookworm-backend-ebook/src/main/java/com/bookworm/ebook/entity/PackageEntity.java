package com.bookworm.ebook.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bookworm.ebook.model.Pkg;

@Entity
@Table(name = "package")
public class PackageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer packageId;
	
	@Column(name = "package_name")
	private String packageName;
	
	@Column(name = "no_of_days")
	private Integer noOfDays;
	
	@Column(name = "no_of_books")
	private Integer noOfBooks;
	
	@Column(name = "lend_amount")
	private Double lendAmount;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "end_date")
	private Long endDate;

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
	
	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public Pkg convertToModel() {
		Pkg pkg = new Pkg();
		pkg.setLendAmount(lendAmount);
		pkg.setNoOfBooks(noOfBooks);
		pkg.setNoOfDays(noOfDays);
		pkg.setPackageId(packageId);
		pkg.setPackageName(packageName);
		pkg.setUserId(userId);
		pkg.setEndDate(new Date(endDate));
		return pkg;
	}

	@Override
	public String toString() {
		return "PackageEntity [packageId=" + packageId + ", packageName=" + packageName + ", noOfDays=" + noOfDays
				+ ", noOfBooks=" + noOfBooks + ", lendAmount=" + lendAmount + ", userId=" + userId + ", endDate="
				+ endDate + "]";
	}
}

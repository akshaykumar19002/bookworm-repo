package com.bookworm.ebook.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bookworm.ebook.model.Lend;

@Entity
@Table(name = "lend")
public class LendEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer lendId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	private EbookEntity bookId;
	
	@Column(name = "package_id")
	private Integer packageId;
	
	@Column(name = "end_date")
	private Long endDate;
	
	@Column(name = "created_at")
	private Long createdAt;

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

	public EbookEntity getBookId() {
		return bookId;
	}

	public void setBookId(EbookEntity bookId) {
		this.bookId = bookId;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	
	public Lend convertToModel() {
		Lend lend = new Lend();
		lend.setBookId(bookId.getId());
		lend.setCreatedAt(new Date(createdAt));
		lend.setEndDate(new Date(endDate));
		lend.setLendId(lendId);
		lend.setPackageId(packageId);
		lend.setUserId(userId);
		return lend;
	}

	@Override
	public String toString() {
		return "LendEntity [lendId=" + lendId + ", userId=" + userId + ", bookId=" + bookId + ", packageId=" + packageId
				+ ", endDate=" + endDate + ", createdAt=" + createdAt + "]";
	}
	
}

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

import com.bookworm.ebook.model.Billing;

@Entity
@Table(name = "billing")
public class BillingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="book_id", referencedColumnName = "id")
	private EbookEntity bookId;

	@Column(name = "action")
	private String action;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="rent_id", referencedColumnName = "id")
	private RentEntity rentId;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="lend_id", referencedColumnName = "id")
	private LendEntity lendId;

	@Column(name = "created_at")
	private Long createdAt = new Date().getTime();
	
	@Column(name = "user_id")
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public EbookEntity getBookId() {
		return bookId;
	}

	public void setBookId(EbookEntity bookId) {
		this.bookId = bookId;
	}

	public RentEntity getRentId() {
		return rentId;
	}

	public void setRentId(RentEntity rentId) {
		this.rentId = rentId;
	}

	public LendEntity getLendId() {
		return lendId;
	}

	public void setLendId(LendEntity lendId) {
		this.lendId = lendId;
	}

	public Billing convertToModel() {
		Billing billing = new Billing();
		billing.setAction(action);
		billing.setId(id);
		billing.setBookId(bookId.getId());
		if (createdAt != null)
			billing.setCreatedAt(new Date(createdAt));
		if (lendId != null)
			billing.setLendId(lendId.getLendId());
		if (rentId != null)
			billing.setRentId(rentId.getRentId());
		billing.setUserId(userId);
		return billing;
	}

	@Override
	public String toString() {
		return "BillingEntity [billingId=" + id + ", bookId=" + bookId + ", action=" + action + ", rentId="
				+ rentId + ", lendId=" + lendId + ", createdAt=" + createdAt + ", userId=" + userId + "]";
	}

}

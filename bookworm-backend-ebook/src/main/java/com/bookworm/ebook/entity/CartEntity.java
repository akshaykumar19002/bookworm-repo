package com.bookworm.ebook.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bookworm.ebook.model.Cart;

@Entity
@Table(name="cart")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer cartId;
	
	@Column(name = "user_id")
	private Integer userId;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	private EbookEntity bookId;
	
	@Column(name = "action")
	private String action;
	
	@Column(name = "rent_duration")
	private Integer rentDuration;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(Integer rentDuration) {
		this.rentDuration = rentDuration;
	}
	
	public Cart convertToModel() {
		Cart cart = new Cart();
		cart.setAction(action);
		cart.setBookId(bookId.getId());
		cart.setCartId(cartId);
		cart.setRentDuration(rentDuration);
		cart.setUserId(userId);
		return cart;
	}

	@Override
	public String toString() {
		return "CartEntity [cartId=" + cartId + ", userId=" + userId + ", bookId=" + bookId + ", action=" + action
				+ ", rentDuration=" + rentDuration + "]";
	}
}

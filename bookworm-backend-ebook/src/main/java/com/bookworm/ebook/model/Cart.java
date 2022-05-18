package com.bookworm.ebook.model;

import com.bookworm.ebook.entity.CartEntity;
import com.bookworm.ebook.entity.EbookEntity;

public class Cart {
	
	private Integer cartId;
	
	private Integer userId;
	
	private Integer bookId;
	
	private String action;
	
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

	public Integer getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(Integer rentDuration) {
		this.rentDuration = rentDuration;
	}
	
	public CartEntity convertToEntity(EbookEntity ebook) {
		CartEntity cart = new CartEntity();
		cart.setAction(action);
		cart.setBookId(ebook);
		cart.setCartId(cartId);
		cart.setRentDuration(rentDuration);
		cart.setUserId(userId);
		return cart;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", bookId=" + bookId + ", action=" + action
				+ ", rentDuration=" + rentDuration + "]";
	}

}
